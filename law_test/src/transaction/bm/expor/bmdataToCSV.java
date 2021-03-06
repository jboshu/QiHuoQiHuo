package transaction.bm.expor;

import org.json.JSONException;
import org.json.JSONObject;
import permission.manager.permissionChecker;
import user.manager.User;
import utils.dbOpener;
import utils.tokenChecker;
import utils.tokenExtractor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class bmdataToCSV extends javax.servlet.http.HttpServlet {

    protected String getCSV(){
        try {
            Connection conn = dbOpener.getDB();

            String sql = "SELECT * FROM tbl_bm";
            System.out.println("即将执行的SQL语句是：" + sql);
            PreparedStatement ptmt = conn.prepareStatement(sql);
            StringBuilder stringBuilder = new StringBuilder("订单号,用户ID,用户名称,股票ID,股票名称,持有数量,买入价格,修改时间\n");
            ResultSet rs=ptmt.executeQuery();
            while(rs.next()){
                stringBuilder.append(rs.getString("OrderId"));
                stringBuilder.append(","+rs.getString("UserId"));
                stringBuilder.append(","+rs.getString("UserName"));
                stringBuilder.append(","+rs.getString("StockId"));
                stringBuilder.append(","+rs.getString("StockName"));
                stringBuilder.append(","+rs.getString("Quantity"));
                stringBuilder.append(","+rs.getString("BUnitPrice"));
                stringBuilder.append(","+rs.getString("CreateAt")+"\n");
                System.out.println();

            }
            conn.close();
            return stringBuilder.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Database Closed！！！");
        return "";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        if(!permissionChecker.checkPermissionAndResponse(request,response,this)) return;
        String csv = getCSV();
        byte[] b=csv.getBytes();
        System.out.println("!!!!!!！！！");
        String filename="订单记录.csv";
        filename= URLEncoder.encode(filename,"UTF-8");
        response.setContentType("file/csv");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        OutputStream output = response.getOutputStream();
        System.out.println("1111111");

        output.write(b);
        output.close();
    }
}
