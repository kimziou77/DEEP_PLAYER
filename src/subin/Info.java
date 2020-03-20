package subin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;
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
        System.out.println("--------------------");
    }
}
public class Info{
    public static Player createUser(String nameTmp) throws IOException {
        String nameEncode=URLEncoder.encode(nameTmp,"UTF-8");
        String urlTmp="https://api.neople.co.kr/cy/players?nickname="+ nameEncode +"&wordType=%3CwordType%3E&apikey=tqaHURDFgZyZ9NL3j3Lq08GuudRMiRNc";
        JSONObject jo=JSP.readJsonFromUrl(urlTmp);
        JSONArray parse_item =(JSONArray)jo.get("rows");
        JSONObject item;
            item=(JSONObject) parse_item.get(0);
            Long grade= (Long)item.get("grade");
            String name=(String)item.get("nickname");
            String id=(String)item.get("playerId");

            Player p = new Player(grade,name,id);
//            System.out.println(p);
        return p;
    }
    public static HashMap<String, Long> moreInfo(String playerId) throws IOException {
        String API = "tqaHURDFgZyZ9NL3j3Lq08GuudRMiRNc";
        String URL ="https://api.neople.co.kr/cy/players/"+playerId+"?apikey="+API;
        JSONObject jo=JSP.readJsonFromUrl(URL);
        JSONArray parse_item =(JSONArray)jo.get("records");
        JSONObject rating;
        JSONObject normal;
//        JSONObject [] game;
        rating = (JSONObject)parse_item.get(0);
        normal = (JSONObject)parse_item.get(1);
        Long winCnt = (Long)normal.get("winCount");
        Long loseCnt= (Long)normal.get("loseCount");
        Long stopCnt= (Long)normal.get("stopCount");
        HashMap<String,Long> m = new HashMap<>();

        m.put("win",winCnt);
        m.put("lose",loseCnt);
        return m;
    }

    enum PP{GO, NEWBIE, SEMI_GO};

    public static PP judge(String playerId) throws IOException {
            HashMap<String,Long> m = moreInfo(playerId);
//            if(player.getLevel()>=100)
//                return PP.GO;
//            else
//                return PP.NEWBIE;
//        }
//        PP result=PP.NEWBIE;
//        result=judge(p);
//        switch(result){
//            case GO:{
//                script.println("<script>");
////            script.println("location.href = 'GO.jsp'");
//                script.println("</script>");
//            }
//            case SEMI_GO:{
//                script.println("<script>");
////            script.println("location.href = 'SEMI_GO.jsp'");
//                script.println("</script>");
//            }
//            case NEWBIE:{
//                script.println("<script>");
////            script.println("location.href = 'NEWBIE.jsp'");
//                script.println("</script>");
//            }
//        }
        return PP.NEWBIE;
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
