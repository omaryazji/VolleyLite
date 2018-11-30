# VolleyLite
Android Library for simplifying APIs requests from android apps based on Volley http networking library

# Usage

- **Step1**  Add Volley   dependency to the build.gradle file in the app module:
```java
    implementation 'com.android.volley:volley:1.1.0'
```
- **Step2**  Add dependency to the build.gradle file in the app module:

###### Gradle 



```java
    implementation 'lib.omry.volleylite:volleylite:0.0.3'
```
OR
###### Maven 

```java
<dependency>
  <groupId>lib.omry.volleylite</groupId>
  <artifactId>volleylite</artifactId>
  <version>0.0.3</version>
  <type>pom</type>
</dependency>
```


- **Step3**  Create new JSONObject for parameters for post methods
```java

 JSONObject parameters = new JSONObject();
 ,,
 ,,
  parameters.put("Name", /*value*/);
 ,,
 ,,
```
Or use HashMap as below

```java

Map<String, String> params = new HashMap();
,,
,,
params.put("Name", /*value*/);
,,
,,
JSONObject parameters = new JSONObject(params);

```



- **Step4** Ceate an instacne of Request class and set the properities :


###### Get Request 
```java
          
    new ApiRequest()
          .init(this  /*context*/)
          .setUrl("API_URL_HERE")
          .setType(IRequestType.GET)
          .setAuth(" " /*AUTHENTICATION_USERNAME*/ ,"" /*AUTHENTICATION_PASSWORD*/)
          .DoRequest(new Request.GetResponse() {
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
          
    new ApiRequest()
          .init(this  /*context*/)
          .setUrl("API_URL_HERE")
          .setType(IRequestType.POST)
          .setParams(parameters)
          .setAuth(" " /*AUTHENTICATION_USERNAME*/ ,"" /*AUTHENTICATION_PASSWORD*/)
          .DoRequest(new Request.GetResponse() {
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
| Name      |  Parameter Type  | Description   |    mandatory | 
|  :---:   |  :----------:  |   :---:  |:---:  |
|`init(context)` | Context  |  context of current state    |YES|
|`setUrl(url)`    | String |  Api URL|YES|
|`setType(requestType)`    | (int) IRequestType |  choose type from IRequestType interface|YES|
|`setAuth(username,password)`    | String , String  |  Authentication ussername and password |by default it's not required unless the api need authentication|
|`setParams(parameters)`    | JSONObject  |  check **step 2** for more details| no 
|`DoRequest()`    |   |  Used for Handling Responses  <br> `onSuccess()`  method will be invoked if the request is successfully processed  and  will return response as string. can be convert to json if needed  <br>`onFail()` method will be invoked if the request is faild and will return message as string| YES |



[ ![Download](https://api.bintray.com/packages/omary/maven/VolleyLites/images/download.svg) ](https://bintray.com/omary/maven/VolleyLites/_latestVersion)

