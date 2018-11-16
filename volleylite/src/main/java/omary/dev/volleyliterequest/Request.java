package omary.dev.volleyliterequest;

import android.content.Context;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import org.json.JSONException;

public class Request implements IRequest {
    Context context;
    String url;
    int methodType;
    JSONObject params;

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
    public void DoRequest(final ApiRequest.GetResponse onCallBack) {

        ApiRequest.Request(this.context, this.url, this.params, this.methodType, new ApiRequest.GetResponse() {
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