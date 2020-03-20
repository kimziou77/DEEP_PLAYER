package subin;
public class Player{
    String playerId;
    String nickName;
    long grade;
    long win;
    long lose;
    long stopp;
    String stat;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public long getGrade() {
        return grade;
    }

    public void setGrade(long grade) {
        this.grade = grade;
    }

    public long getWin() {
        return win;
    }

    public void setWin(long win) {
        this.win = win;
    }

    public long getLose() {
        return lose;
    }

    public void setLose(long lose) {
        this.lose = lose;
    }

    public long getStopp() {
        return stopp;
    }

    public void setStopp(long stopp) {
        this.stopp = stopp;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
    Player(){}
    Player(long grade, String nickName, String playerId){
        this.grade=grade;
        this.nickName=nickName;
        this.playerId=playerId;
    }
    public Player(String playerId, String nickName, long grade, long win, long lose, long stopp, String stat) {
        this.playerId = playerId;
        this.nickName = nickName;
        this.grade = grade;
        this.win = win;
        this.lose = lose;
        this.stopp = stopp;
        this.stat = stat;
    }

    public String toString(){
        return  "급수 : "+grade+"\n"+
                "닉네임 : "+nickName+"\n"+
                "PlayerId : "+playerId;
    }

    public static void main(String[] args) {

    }
}