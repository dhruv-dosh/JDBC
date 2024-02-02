package JDBC;
import java.io.FileInputStream;
import  java.sql.*;

public class Jdbc_addingImg {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LearningJdbc","root","payas@2005");

            String str = "insert into image(img) value(?)";
            PreparedStatement prd = con.prepareStatement(str);
            FileInputStream fil = new FileInputStream("Learning2.png");
            prd.setBinaryStream(1,fil,fil.available());
            prd.executeUpdate();
            System.out.println("Image added...");
            con.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
