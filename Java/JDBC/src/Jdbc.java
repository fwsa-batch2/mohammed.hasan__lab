import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;

public class Jdbc {
   static ResultSet resultSet;
   static Connection conn;
   static Statement statement;
    public static void main(String[] args) throws Exception {
        conn = DriverManager.getConnection("jdbc:mysql://192.168.16.33/java","Riyas","Riyas@2002");
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select id from students");
        System.out.println(resultSet);

//        statement.execute("delete from students where id=1");

        PreparedStatement preparedStatement = conn.prepareStatement("insert into students values(?,?,?,?)");
//        preparedStatement.setString(2,"Kasi");
//        preparedStatement.setString(3,"Antony");
//        preparedStatement.setInt(1,2);
//        preparedStatement.setString(4,"Thoothukudi");
//        preparedStatement.execute();

//        showAll();
    }
    static void showAll() throws SQLException {
        resultSet = statement.executeQuery("select * from students");
        while (resultSet.next()) {
            System.out.printf("%-20s",resultSet.getString("id"));
            System.out.printf("%-20s",resultSet.getString("f_name"));
            System.out.printf("%-20s",resultSet.getString("l_name"));
            System.out.printf("%-20s",resultSet.getString("city"));
            System.out.println();
        }
    }
}
