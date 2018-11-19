# VolleyLite
Android Library for simplifying the usage of Volley http networking library

# Usage

-  Add dependency to the build.gradle file in the app module:

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


- Create new JSONObject for parameters to be posted 

        JSONObject parameters = new JSONObject();
```java
  try {
  
       parameters.put("Name", "Value");
       ,,,
       
    } catch (JSONException e) {
            e.printStackTrace();
    }
```

- create a new instacne of Request class and set the properities :

```java
          
    new Request()
                .init(this  /*context*/)
                .setUrl("API_URL_HERE")
                .setType(IRequestType.POST)
                .setParams(parameters)
                .setAuth(" " /*AUTHENTICATION_USERNAME*/ ,"" /*AUTHENTICATION_PASSWORD*/)
                .DoRequest(new ApiRequest.GetResponse() {
                    @Override
                    public void onSuccess(String result) throws JSONException {
                          // Handle success respose here
                    }

                    @Override
                    public void onFail(String msg) {
                        // Handle error here if request is failed
                    }
                });
                
 ```
