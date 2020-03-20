package subin;
public class Player{
    long level;
    String nickName;
    String playerId;

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    Player(long level, String nickName, String playerId){
        this.level=level;
        this.nickName=nickName;
        this.playerId=playerId;
    }
    public String toString(){
        return  "급수 : "+level+"\n"+
                "닉네임 : "+nickName+"\n"+
                "PlayerId : "+playerId;
    }

}