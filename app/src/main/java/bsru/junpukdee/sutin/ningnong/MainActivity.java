package bsru.junpukdee.sutin.ningnong;
        import android.content.Intent;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.json.JSONArray;
        import org.json.JSONObject;
        import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button signIn;
    private EditText userEditText, passEditText;
    private String userString, passString;
    private String jsonuser;
    private String datauser;
    private String[] loginStrings = new String[8];
    private boolean statusUser = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindwidget();
        buttoncontroller();
    }

    private void buttoncontroller(){
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userString = userEditText.getText().toString();
                passString = passEditText.getText().toString();
                if (userString.equals("") || passString.equals("")){

                    Toast.makeText(MainActivity.this, "ใส่รายละเอียดให้ครบ", Toast.LENGTH_LONG).show();

                } else {
                    UserIn userIn = new UserIn(MainActivity.this);
                    MyConfig myConfig = new MyConfig();

                    try {
                        userIn.execute(myConfig.getLogin()
                            +"?code_bkt="+userString+"&"
                                +"password="+passString
                        );

                        jsonuser = userIn.get();
                        JSONObject dataJsonObject = new JSONObject(jsonuser);
                        JSONArray leaders = dataJsonObject.getJSONArray("datauser");
                        Log.d("user", jsonuser.toString());
                        for (int i = 0; i < leaders.length(); i += 1) {

                            JSONObject jsonObject = leaders.getJSONObject(i);
                            if (userString.equals(jsonObject.getString("name_bkt"))) {
                                loginStrings[0] = jsonObject.getString("id_bkt");
                                loginStrings[1] = jsonObject.getString("name_bkt");
                                loginStrings[2] = jsonObject.getString("surname_bkt");
                                loginStrings[3] = jsonObject.getString("lentSum");
                                loginStrings[4] = jsonObject.getString("backSum");
                                loginStrings[5] = jsonObject.getString("interestSum");
                                loginStrings[6] = jsonObject.getString("img");

                                break;

                            }   // if

                        }   // for

                        Intent intent = new Intent(MainActivity.this, UserMain.class);
                        intent.putExtra("Login", loginStrings);
                        startActivity(intent);
                        finish();

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Try to login", Toast.LENGTH_LONG).show();
                        Log.d("jsonuser", "jsonuser==>" + e.toString());

                    }
                }
            }
        });
    }

    private void bindwidget(){

        userEditText = (EditText) findViewById(R.id.userEditText);
        passEditText = (EditText) findViewById(R.id.passEditText);
        signIn = (Button) findViewById(R.id.signIn);

    }

}
