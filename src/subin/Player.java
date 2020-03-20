package subin;
public class Player{
    long level;
    String nickName;
    String playerId;
    long winCnt;
    long loseCnt;
    long stopCnt;

    public long getWinCnt() {
        return winCnt;
    }

    public void setWinCnt(long winCnt) {
        this.winCnt = winCnt;
    }

    public long getLoseCnt() {
        return loseCnt;
    }

    public void setLoseCnt(long loseCnt) {
        this.loseCnt = loseCnt;
    }

    public long getStopCnt() {
        return stopCnt;
    }

    public void setStopCnt(long stopCnt) {
        this.stopCnt = stopCnt;
    }


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