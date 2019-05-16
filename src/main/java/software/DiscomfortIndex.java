package software;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class DiscomfortIndex {
    public String DiscomfortIndex(double temp, double humidity){
        if (temp>=36.0 && humidity>=80.0){
            return "매우 불쾌";
        } else if (temp>=32.0 && humidity>=65.0){
            return "불쾌";
        } else if (temp>=28.0 && humidity>=50.0){
            return "보통";
        } else{
            return "좋음";
        }
    }

    public double Humidity() {
        double humidity = 0;
        return humidity;
    }

    public double Temp() {
        double temp = 0;
        try {
            String lon = "127.1458118";
            String lat = "35.8241932";

            String urlstr = "http://api.openweathermap.org/data/2.5/weather?"
                    + "lat=" + lat + "&lon=" + lon
                    + "&appid=06acfc7b92c7784a003147914cf89b25";
            URL url = new URL(urlstr);
            BufferedReader bf;
            String line;
            String result = "";

            bf = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = bf.readLine()) != null) {
                result = result.concat(line);
            }

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);

            JSONObject mainArray = (JSONObject) jsonObj.get("main");
            double ktemp = Double.parseDouble(mainArray.get("temp").toString());
            temp = ktemp - 273.15;

            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
}
