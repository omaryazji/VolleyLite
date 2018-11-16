package omary.dev.volleyliterequest;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Base64;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ApiRequest {


    public static void Request(final Context context, String url, JSONObject params, int methodType, final GetResponse onCallBack) {
        final RequestQueue queue = Volley.newRequestQueue(context);

        if (Utility.isNetworkAvailable(context)) {

            Utility.OpenLoadingDialog(context, "");

            final JsonObjectRequest jsObjRequest = new JsonObjectRequest(methodType, url, params, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    // TODO Auto-generated method stub

                    Utility.HideLoading();

                    try {
                        onCallBack.onSuccess(response.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO Auto-generated method stub
                    Utility.HideLoading();

                    onCallBack.onFail(error.toString());
                }
            });


         /*   {
                @Override
                public Map<String, String> getHeaders () throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String credentials = "username:password";
                String auth = "Basic "
                        + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", auth);
                return headers;
            }
            } ;*/

            jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            queue.add(jsObjRequest);
        } else {
            Utility.Toast(context, "Please check your internet connection");
        }
    }

    public interface GetResponse {
        void onSuccess(String result) throws JSONException;

        void onFail(String msg);
    }

}
