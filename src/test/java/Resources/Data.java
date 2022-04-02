package Resources;

import java.util.LinkedHashMap;
import java.util.Map;

public class Data {
    public static String getLoginPayload(String use,String pwd){
        return "{ \"username\": \""+use+"\", \"password\": \""+pwd+"\" }";
    }
    public static String getCreateIssuePayload(String summary,String msg){
        return "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"Key\": \"RSA\",\n" +
                "            \"id\":\"10000\"\n" +
                "        },\n" +
                "        \"summary\": \""+summary+"\",\n" +
                "        \"environment\": \"UAT\",\n" +
                "        \"description\": \""+msg+"\",\n" +
                "        \"issuetype\":{\n" +
                "\t\t\t\"name\":\"Bug\"\n" +
                "\t\t}\n" +
                "    }\n" +
                "}";
    }
    public static Map<String, Object> getAddCommentPayload(String docstr){
      LinkedHashMap<String , Object> finalMap = new LinkedHashMap<>();
      finalMap.put("body",docstr);
        return finalMap;
    }
}
