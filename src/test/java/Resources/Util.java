package Resources;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Util  {
    public static RequestSpecification req;
        public RequestSpecification requestSpecification() throws Exception {
            if(req == null) {
                PrintStream ps = new PrintStream(new FileOutputStream("log.txt"));
                req = new RequestSpecBuilder().setBaseUri(getProperty("Baseuri")).setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(ps)).addFilter(ResponseLoggingFilter.logResponseTo(ps)).build();
                return req;
            } else {
                return req;
            }
        }
        public static String getProperty(String baseUri) throws Exception{
            FileInputStream fis = new FileInputStream("src//test//java//Resources//global.properties");
            Properties prop = new Properties();
            prop.load(fis);
            return prop.getProperty(baseUri);

        }
        public JsonPath getJson(Response resp){
            String r = resp.asString();
            JsonPath js = new JsonPath(r);
            return js;
        }

}
