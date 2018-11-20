# VolleyLite
Android Library for simplifying APIs requests from android apps based on Volley http networking library

# Usage

- **Step1**  Add dependency to the build.gradle file in the app module:

###### Gradle 

```java
implementation 'dev.omary.volleylite:volleylite:0.0.1'
```

###### Maven 

```java
<dependency>
  <groupId>dev.omary.volleylite</groupId>
  <artifactId>volleylite</artifactId>
  <version>0.0.1</version>
  <type>pom</type>
</dependency>
```


- **Step2**  Create new JSONObject for parameters for post methods
```java

 JSONObject parameters = new JSONObject();
 
 parameters.put("Name", /*value*/);
 ,,
 ,,
 ,,
```
Or use HashMap as below

```java

Map<String, String> params = new HashMap();
params.put("Name", /*value*/);
,,
,,
,,
JSONObject parameters = new JSONObject(params);

```



- **Step3** Ceate an instacne of Request class and set the properities :


###### Get Request 
```java
          
    new Request()
          .init(this  /*context*/)
          .setUrl("API_URL_HERE")
          .setType(IRequestType.GET)
          .setAuth(" " /*AUTHENTICATION_USERNAME*/ ,"" /*AUTHENTICATION_PASSWORD*/)
          .DoRequest(new ApiRequest.GetResponse() {
                    @Override
                    public void onSuccess(String successResponse) throws JSONException {
                          // Handle success respose here
                    }

                    @Override
                    public void onFail(String errorResponse) {
                        // Handle error here if request is failed
                    }
             });
                
 ```
###### Post Request 

```java
          
    new Request()
          .init(this  /*context*/)
          .setUrl("API_URL_HERE")
          .setType(IRequestType.POST)
          .setParams(parameters)
          .setAuth(" " /*AUTHENTICATION_USERNAME*/ ,"" /*AUTHENTICATION_PASSWORD*/)
          .DoRequest(new ApiRequest.GetResponse() {
                    @Override
                    public void onSuccess(String successResponse) throws JSONException {
                          // Handle success respose here
                    }

                    @Override
                    public void onFail(String errorResponse) {
                        // Handle error here if request is failed
                    }
             });
                
 ```


# Functions
| Name      | Parameter Type | Description   |   
|  :---:   |  :-----:  |   :---:  |
|`init(context)` | Context  |  context of current state    |
|`setUrl(url)`    | String |  Api URL|
|`setType(requestType)`    | (int) IRequestType |  choose type from IRequestType interface|
|`setAuth(username,password)`    | String , String  |  Authentication ussername and password |
|`setParams(parameters)`    | JSONObject  |  check **step 2** form more details|
|`DoRequest()`    |   |  Used for Handling Responses  <br> `onSuccess()`  method will invoked if the request is successfully processed  and  will return response as string. can be convert to json if needed  <br>`onFail()` method will invoked if the request is faild and will return message as string|





