package omary.dev.volleyliterequest;

import android.content.Context;

import org.json.JSONObject;

import org.json.JSONException;

public class ApiRequest implements IRequest {
    Context context;
    String url;
    int methodType;
    JSONObject params;
    String Username= "",Password = "";

    @Override
    public IRequest init(Context context) {
        this.context = context;
        return this;
    }

    @Override
    public IRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public IRequest setType(int type) {
        this.methodType = type;
        return this;
    }

    @Override
    public IRequest setParams(JSONObject params) {
        this.params = params;
        return this;
    }


    @Override
    public IRequest setAuth(String username,String password) {
        this.Username = username;
        this.Password = password;
        return this;
    }

    @Override
    public void DoRequest(final Request.GetResponse onCallBack) {

        Request.Request(this.context, this.url, this.params, this.methodType,this.Username,this.Password, new Request.GetResponse() {
            @Override
            public void onSuccess(String result) throws JSONException {

                onCallBack.onSuccess(result);
            }

            @Override
            public void onFail(String msg) {
                onCallBack.onFail(msg);

            }
        });
    }
}
