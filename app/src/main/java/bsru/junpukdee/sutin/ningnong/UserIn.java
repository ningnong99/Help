package bsru.junpukdee.sutin.ningnong;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


/**
 * Created by NongDay on 5/17/2017.
 */

public class UserIn extends AsyncTask<String, Void, String> {

    private Context context;

    public UserIn (Context context){
        this.context = context;
    }


    @Override
    protected String doInBackground(String... params) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            String resJSON = response.body().string();
                 Log.d("getdata", "getdata==>" + resJSON);
            return resJSON;
        } catch (Exception e) {
            Log.d("getdata", "getdata==>" + e.toString());
        }
        return null;
    }
}
