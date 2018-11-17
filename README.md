# VolleyLite
Android Library for simplifying the usage of Volley http networking library

# Usage

1.  Add dependency to the build.gradle file in the app module:

### Gradle 

```java
implementation 'dev.omary.volleylite:volleylite:0.0.1'
```

### Maven 

```java
<dependency>
  <groupId>dev.omary.volleylite</groupId>
  <artifactId>volleylite</artifactId>
  <version>0.0.1</version>
  <type>pom</type>
</dependency>
```


2. Create new JSONObject for parameters to be posted 

        JSONObject parameters = new JSONObject();
```java
  try {
  
       parameters.put("Name", "Value");
       ,,,
       
    } catch (JSONException e) {
            e.printStackTrace();
    }
```

3. create a new instacne of Request class and set the properities :

```java
    new Request()
       .init(this  /*context*/)
       .setUrl("YOUR_API_URL")
       .setType(IRequestType.POST)  /*Request Type*/
       .setParams(parameters)   /*Parameter as json object*/
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
