import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;

public class ImageStoring {
    static ResultSet resultSet;
    static Connection conn;
    static Statement statement;
    public static void main(String[] args) throws Exception {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","hasan","HasanTheDON7.");
        statement = conn.createStatement();
        // Storing Image in DB
        PreparedStatement preparedStatement2 = conn.prepareStatement("insert into images values(?)");
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\hasan\\OneDrive\\Desktop\\Mohammed Hasan\\has.jpg");
        preparedStatement2.setBinaryStream(1,fileInputStream,fileInputStream.available());
        preparedStatement2.execute();
        fileInputStream.close();

        // Retrieving image from DB
        PreparedStatement statement = conn.prepareStatement("select * from images");
        resultSet = statement.executeQuery();
        if(resultSet.next()){
            Blob b = resultSet.getBlob(1);
            byte[] byteArray = b.getBytes(1,(int)b.length());
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\hasan\\OneDrive\\Desktop\\Mohammed Hasan\\hasan.jpg");
            fileOutputStream.write(byteArray);
            fileOutputStream.close();
        }
    }
}
