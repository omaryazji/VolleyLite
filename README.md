# VolleyLite
Android Library for simplifying the usage of Volley http networking library

# Usage

 Add dependency to the build.gradle file in the app module:

```java
implementation 'dev.omary.volleylite:volleylite:0.0.1'
```


initialize the PrefUtil  inside your application class :

```java
        new Request()
                .init(this)
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
                
                ```




