package com.wxywizard.hellospringboot;

import java.sql.DriverManager;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.sql.Connection;

public class jdbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
                String URL="jdbc:mysql://sh-cdb-ogmmh2x7.sql.tencentcdb.com:63154/test?useUnicode=true&amp;characterEncoding=utf-8";
                String USER="root";
                String PASSWORD="***";
                //1.加载驱动程序
                Class.forName("com.mysql.jdbc.Driver");
                //2.获得数据库链接
                Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
                //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
                Statement st=conn.createStatement();
   /*             ResultSet rs=st.executeQuery("select * from user");
                //4.处理数据库的返回结果(使用ResultSet类)
                while(rs.next()){
                     System.out.println(rs.getString("user_name")+" "
                                        +rs.getString("user_password"));
                 }*/

                //关闭资源
               // rs.close();
                st.close();
                conn.close();
            }
}
