package bsru.junpukdee.sutin.ningnong;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import static bsru.junpukdee.sutin.ningnong.R.id.lentSum;
import static bsru.junpukdee.sutin.ningnong.R.id.name_bkt;
import static bsru.junpukdee.sutin.ningnong.R.id.user;

public class UserMain extends AppCompatActivity {

    private TextView name_bkt, surname_bkt, lentSum, backSum, interestSum;
    private Button listMain;
    private String[] loginStrings;
    private ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        //String usedata = getIntent().getStringExtra("datauser");

        name_bkt = (TextView) findViewById(R.id.name_bkt);
        surname_bkt = (TextView) findViewById(R.id.surname_bkt);
        lentSum = (TextView) findViewById(R.id.lentSum);
        backSum = (TextView) findViewById(R.id.backSum);
        interestSum = (TextView) findViewById(R.id.interestSum);
//        img = (ImageView) findViewById(R.id.img);

        Toast.makeText(UserMain.this, name_bkt.getText() , Toast.LENGTH_LONG).show();

        loginStrings = getIntent().getStringArrayExtra("Login");
        name_bkt.setText(loginStrings[1]);
        surname_bkt.setText(loginStrings[2]);
        lentSum.setText(loginStrings[3]);
        backSum.setText(loginStrings[4]);
        interestSum.setText(loginStrings[5]);
//        Picasso.with(UserMain.this).load(getIntent().getStringExtra(loginStrings[6])).into(img);

    }
}
