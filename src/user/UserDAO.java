package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    private Connection conn;//데이터베이스에 접근하기위한 객체
    private PreparedStatement pstmt;
    private ResultSet rs; //정보를담는 객체

    public UserDAO(){
        try{
            String dbURL="jdbc:mysql://localhost:3306/bbs?characterEncoding=UTF-8&serverTimezone=UTC"; //DEEP이라는 데이터베이스에접속
            String dbID="subin";
            String dbPassword="990902";
            Class.forName("com.mysql.jdbc.Driver");//mysql드라이버
            conn= DriverManager.getConnection(dbURL,dbID,dbPassword);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public int login(String userID, String userPassword){
        String SQL = "SELECT userPassword From USER WHERE userID=?";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,userID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                if(rs.getString(1).equals(userPassword))
                    return 1;//로그인성공
                else
                    return 0;//비밀번호 불일치
            }
            return -1;//아이디가없음
        }catch(Exception e){
            e.printStackTrace();
        }
        return -2;//데이터베이스오류
    }
    public int join(User user){
        //데이터개수만큼
        String SQL = "INSERT INTO USER VALUES (?,?,?)";
        try{
            pstmt= conn.prepareStatement(SQL);
            pstmt.setString(1,user.getUserID().toString());
            pstmt.setString(2,user.getUserPassword());
            pstmt.setString(3,user.getUserGender());
            return pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;// Database Error
    }
}
