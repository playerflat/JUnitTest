package software;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Temp {
    public double Temp() {
        double temp = 0;
        try {
            //서울시청의 위도와 경도
            String lon = "127.1458118";  //경도
            String lat = "35.8241932";   //위도

            //OpenAPI call하는 URL
            String urlstr = "http://api.openweathermap.org/data/2.5/weather?"
                    + "lat=" + lat + "&lon=" + lon
                    + "&appid=06acfc7b92c7784a003147914cf89b25";
            URL url = new URL(urlstr);
            BufferedReader bf;
            String line;
            String result = "";

            //날씨 정보를 받아온다.
            bf = new BufferedReader(new InputStreamReader(url.openStream()));

            //버퍼에 있는 정보를 문자열로 변환.
            while ((line = bf.readLine()) != null) {
                result = result.concat(line);
            }

            //문자열을 JSON으로 파싱
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);

            /*
            //지역 출력
            System.out.println("지역 : " + jsonObj.get("name"));

            //날씨 출력
            JSONArray weatherArray = (JSONArray) jsonObj.get("weather");
            JSONObject obj = (JSONObject) weatherArray.get(0);
            System.out.println("날씨 : " + obj.get("main"));
            */

            //온도 출력(절대온도이므로 변환 필요)
            JSONObject mainArray = (JSONObject) jsonObj.get("main");
            double ktemp = Double.parseDouble(mainArray.get("temp").toString());
            temp = ktemp - 273.15;
            //System.out.printf("온도 : %.2f\n", temp);

            bf.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }
}