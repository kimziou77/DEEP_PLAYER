package subin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

class JSP {
    private static String jsonReadAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    public static JSONObject readJsonFromUrl(String url) throws IOException{
        InputStream is = new URL(url).openStream();
        JSONParser parser= new JSONParser();
        JSONObject json=null;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = jsonReadAll(rd);
            json = (JSONObject)parser.parse(jsonText);
            return json;
        }catch(ParseException e){
            e.printStackTrace();
        }finally {
            is.close();
        }
        return json;
    }
}
class Character{
    public static void main(String[] args) throws IOException {
        System.out.println("캐릭터이름을 입력해주세요");
        Scanner sc= new Scanner(System.in);
        String characterName = sc.nextLine(); //System.out.println(nickName);

        String characterEncode = URLEncoder.encode(characterName,"UTF-8");
        String url="https://api.neople.co.kr/cy/characters?apikey=tqaHURDFgZyZ9NL3j3Lq08GuudRMiRNc";
        JSONObject character=JSP.readJsonFromUrl(url);

        JSONArray parse_item =(JSONArray)character.get("rows");
        JSONObject item;
        for(int i=0;i<parse_item.size();i++){
            item=(JSONObject) parse_item.get(i);
            String ci=(String)item.get("characterId");
            String cn=(String)item.get("characterName");
            if(characterName.equals(cn)){
                System.out.println("characterId : "+ci);
                System.out.println("characterName : "+cn);
                break;
            }
        }
        //System.out.println(jo);
        //URL url = new URL("https://api.neople.co.kr/cy/players?nickname="+ nickName +"&wordType=%3CwordType%3E&apikey=tqaHURDFgZyZ9NL3j3Lq08GuudRMiRNc");
        System.out.println("--------------------");
    }
}
public class Info{
    static ArrayList<Player> playerList;
    public static void createUser(String nameTmp) throws IOException {
        String nameEncode=URLEncoder.encode(nameTmp,"UTF-8");
        String urlTmp="https://api.neople.co.kr/cy/players?nickname="+ nameEncode +"&wordType=%3CwordType%3E&apikey=tqaHURDFgZyZ9NL3j3Lq08GuudRMiRNc";
        JSONObject jo=JSP.readJsonFromUrl(urlTmp);
        JSONArray parse_item =(JSONArray)jo.get("rows");
        JSONObject item;
        for(int i=0;i<parse_item.size();i++){
            item=(JSONObject) parse_item.get(i);
            Long grade= (Long)item.get("grade");
            String name=(String)item.get("nickname");
            String id=(String)item.get("playerId");

            Player p = new Player(grade,name,id);
            playerList.add(p);
//            System.out.println(p);
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("닉네임을 입력해주세요");
        Scanner sc= new Scanner(System.in);
        String nickName = sc.nextLine(); //System.out.println(nickName);
        String nameEncode = URLEncoder.encode(nickName,"UTF-8");
        createUser(nameEncode);
        //System.out.println(jo);
        System.out.println("--------------------");
    }
}
class Player{
    long level;
    String nickName;
    String playerId;
    Player(long level,String nickName,String playerId){
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