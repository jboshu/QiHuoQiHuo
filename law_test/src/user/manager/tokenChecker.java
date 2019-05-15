package user.manager;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * Created by zjm97 on 2019/4/16.
 */
public class tokenChecker {
    public static String checkToken(String token){
            try{
                String userType;
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8");
                String sql="SELECT * FROM tbl_tockeninfo WHERE tockenValue=?";
                PreparedStatement ptmt = conn.prepareStatement(sql);
                ptmt.setString(1,token);
                ResultSet rs=ptmt.executeQuery();
                if(!rs.next()){
                    System.out.println("没有找到token!");
                    return "error";
                }
                else{
                    String TTL = rs.getString("TTL");
                    int id=rs.getInt("id");
                    java.util.Date date = new java.util.Date();
                    try
                    {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        date = sdf.parse(TTL);
                    }
                    catch (ParseException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    if(date.getTime()<new java.util.Date().getTime()){
                        System.out.println("tocken已过期");
                        System.out.printf("ttl=%d",date.getTime());
                        System.out.printf("time=%d",new java.util.Date().getTime());
                        sql = "DELETE FROM tbl_tockeninfo WHERE tockenValue=?";
                        ptmt = conn.prepareStatement(sql);
                        ptmt.setString(1,token);
                        ptmt.execute();
                        return "timeout";
                    }
                    //如果token有效则续期
                    else{
                        System.out.println("token有效!");
                        ptmt = conn.prepareStatement("UPDATE tbl_tockeninfo SET TTL=? WHERE id=?");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        java.util.Date currentDate = new java.util.Date();
                        long timeStamp = currentDate.getTime()+5*60000;
                        System.out.println(timeStamp);
                        ptmt.setString(1,sdf.format(new java.util.Date(timeStamp)));
                        ptmt.setInt(2,id);
                    }
                    int userId = rs.getInt("UserId");
                    sql="SELECT * FROM tbl_userinfo WHERE userId=?";
                    ptmt = conn.prepareStatement(sql);
                    ptmt.setInt(1,userId);
                    rs = ptmt.executeQuery();
                    if(rs.next()){
                        userType = rs.getString("role_id");
                        return userType;
                    }
                    else{
                        System.out.println("没有找到user!");
                        return "error";
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
    return "error";
    }
}