# Loopj_Sample
Network call with LOOPJ Lib James smith.
Loopj is an Android library for making asynchronous HTTP requests. it is used by companies like Instagram, Pinterest, and many others.

Just add the dependencies under module level build.gradle

compile 'com.loopj.android:android-async-http:1.4.9'

Just add the permission of internet and your project is ready.

Fetch the data in get and post from loopj lib android with its friendly code.
for example # POST API:


fun executeLoopjCall(context: Context, queryTerm: String) {
     
     var jsonObject: JSONObject = JSONObject();
        jsonObject.put("emailid", "umesh@gmail.com")
        jsonObject.put("password", "123456")
        val entity = StringEntity(jsonObject.toString())
        requestParams!!.put("s", entity)
        asyncHttpClient!!.post(context, BASE_URL, entity, "application/json", object : JsonHttpResponseHandler() {
          
          override
            fun onSuccess(statusCode: Int, headers: Array<Header>, response: JSONObject) {
                super.onSuccess(statusCode, headers, response)
                jsonResponse = response.toString()
                Log.e(TAG, "onSuccess: $jsonResponse")
            }

            override
            fun onFailure(statusCode: Int, headers: Array<Header>, throwable: Throwable, errorResponse: JSONObject) {
                super.onFailure(statusCode, headers, throwable, errorResponse)
                Log.e(TAG, "onFailure: $errorResponse")
            }
        })
    }
    }

