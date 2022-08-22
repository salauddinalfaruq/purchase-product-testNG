package Utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class Utils {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void getUserCreds(int pos) throws IOException, ParseException {

        String filePath = "./src/test/resources/users.json";

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filePath));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject userObj = (JSONObject) jsonArray.get(pos);

        setEmail ((String) userObj.get("email"));
        setPassword ((String) userObj.get("password"));
    }

    public void writeUserInfo(String email , String password) throws IOException, ParseException {

        String filePath = "./src/test/resources/users.json";

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filePath));
        JSONObject userObj = new JSONObject();

        userObj.put("email" , email);
        userObj.put("password" , password);

        JSONArray jsonArray = (JSONArray) obj;
        jsonArray.add(userObj);

        FileWriter file = new FileWriter(filePath);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();

        System.out.println("Saved");
        System.out.println(jsonArray);
    }

    public int getLastUser() throws IOException, ParseException {

        String filePath = "./src/test/resources/users.json";

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filePath));
        JSONArray jsonArray = (JSONArray) obj;
        return jsonArray.size()-1;
    }

    public void takeScreenshot(WebDriver driver) throws IOException {

        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yy-hh-mm-ss-aa").format(new Date());
        String filePath = "./src/test/resources/screenshot/" + time + ".png";
        File destFile = new File(filePath);
        FileUtils.copyFile(screenShotFile , destFile);
    }

    public int generateRandomNumber(int min , int max){
        int randomNum = (int) (Math.random() * (min - max + max));
        return randomNum;
    }

    public String generateRandomPassword(int len){
        String chars = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZAavcdefghijklmnopqrstuvwxyz!@#$%&";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++){
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
