package omary.dev.volleyliterequest;
import android.content.Context;

import org.json.JSONObject;

public interface IRequest {
    IRequest init(Context context);
    IRequest setUrl(String url);
    IRequest setType(int type);
    IRequest setParams(JSONObject params);
    IRequest setAuth(String Username,String Password);
    void DoRequest(final ApiRequest.GetResponse onCallBack);

}



