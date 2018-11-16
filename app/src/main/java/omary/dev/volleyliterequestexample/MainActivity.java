package omary.dev.volleyliterequestexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import omary.dev.volleyliterequest.ApiRequest;
import omary.dev.volleyliterequest.IRequestType;
import omary.dev.volleyliterequest.Request;
import omary.dev.volleyliterequest.Utility;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        JSONObject parameters = new JSONObject();

        try {
            parameters.put("DeviceID_", "123");
            parameters.put("Username_", "atlas");
            parameters.put("Password_", "a");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        new Request()
                .init(this  /*context*/)
                .setUrl("http://46.45.166.102/AndroidApi/tr/api/MobileApi/Login/")
                .setType(IRequestType.POST)
                .setParams(parameters)
                .DoRequest(new ApiRequest.GetResponse() {
                    @Override
                    public void onSuccess(String result) throws JSONException {
                        Utility.Toast(getApplicationContext(), result);
                    }

                    @Override
                    public void onFail(String msg) {
                        Utility.Toast(getApplicationContext(), msg);
                    }
                });
    }
}
