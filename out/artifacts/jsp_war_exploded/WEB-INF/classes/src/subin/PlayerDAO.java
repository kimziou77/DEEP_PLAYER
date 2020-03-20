package subin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlayerDAO {
    private Connection conn;//데이터베이스에 접근하기위한 객체
    private PreparedStatement pstmt;
    private ResultSet rs; //정보를담는 객체

    public PlayerDAO(){
        try{
            String dbURL="jdbc:mysql://localhost:3306/deep?characterEncoding=UTF-8&serverTimezone=UTC"; //DEEP이라는 데이터베이스에접속
            String dbID="subin";
            String dbPassword="990902";
            Class.forName("com.mysql.jdbc.Driver");//mysql드라이버
            conn= DriverManager.getConnection(dbURL,dbID,dbPassword);
            System.out.println("[데이터베이스 접속 성공]");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String get_playerId_from_nickName(String nickName){
        String SQL = "SELECT playerId From USER WHERE nickName=?";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,nickName);
            rs = pstmt.executeQuery();

            if(rs.next()){
                return rs.getString(1);
            }else{
                return "NO_nickName";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "DB_error";//데이터베이스오류
    }
    public int join(Player user){ //DB에 유저를 넣는다.
        //데이터개수만큼
        String SQL = "INSERT INTO USER VALUES (?,?,?,?,?,?,?)";
        try{
            pstmt= conn.prepareStatement(SQL);
            pstmt.setString(1,user.getPlayerId());
            pstmt.setString(2,user.getNickName());
            Long grade = user.getGrade();
            Long win =user.getWin();
            Long lose =user.getLose();
            Long stopp =user.getStopp();
            pstmt.setString(3,grade.toString());
            pstmt.setString(4,win.toString());
            pstmt.setString(5,lose.toString());
            pstmt.setString(6,stopp.toString());
            pstmt.setString(7,user.getStat());
            return pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;// Database Error
    }
    public int IN_DB(String playerID){//유저가 DB에 있는지 검사한다.
        String SQL = "SELECT * From USER WHERE playerID=?";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,playerID);
            rs = pstmt.executeQuery();

            if(rs.next()){
                return 1;// playerID is in DB == true
            }else{
                return 0;// no playerID
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;//데이터베이스오류
    }
    public Player DB_USER(String playerID){//DB에 있는 유저를 불러온다.
        Player p =new Player();
        String SQL = "SELECT * From USER WHERE playerID=?";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,playerID);
            rs = pstmt.executeQuery();

            if(rs.next()){
                p.setPlayerId(rs.getString(1));
                p.setNickName(rs.getString(2));
                p.setGrade(rs.getInt(3));
                p.setWin(rs.getInt(4));
                p.setLose(rs.getInt(5));
                p.setStopp(rs.getInt(6));
                p.setStat(rs.getString(7));
//                return rs.getString(1);
            }else{
                System.out.println("unKnown Player");
//                return "NEWBIE";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//        return "DB_error";//데이터베이스오류
        return p;
    }
}
