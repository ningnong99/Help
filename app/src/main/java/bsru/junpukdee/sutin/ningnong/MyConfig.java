package bsru.junpukdee.sutin.ningnong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyConfig {

    private String ip = "10.5.2.47";
    private String port = "81";
    private String login = "http://"+ip+":"+port+"/project/android/user_get.php";
    private String showuse = "http//"+ip+":"+port+"/project/android/showuse.php";
    private String columnUserString ="http//"+ip+":"+port+"/project/android/columnUserString.php";

    public String getColumnUserString() {
        return columnUserString;
    }
    public String getLogin() {
        return login;
        }
    public String getShowuse(){
        return showuse;
    }
}
