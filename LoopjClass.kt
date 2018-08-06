package kurtis.rx.androidexamples

import android.content.Context
import android.util.Log
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONObject


/**
 * Created on Android Studio
 * Author: Umesh
 * DATE: 8/6/2018
 * TIME :9:56 AM.
 * DAY: Monday
 * Project: rxandroidexamples
 */
class LoopjClass {
    private val TAG = "MOVIE_TRIVIA"
    var asyncHttpClient: AsyncHttpClient? = null
    var requestParams: RequestParams? = null
    var BASE_URL = "http://api.yumfooo.in/api/Home/userlogin"
    var jsonResponse: String? = null

    constructor() {
        this.asyncHttpClient = AsyncHttpClient()
        this.requestParams = RequestParams()
    }


    fun executeLoopjCall(context: Context, queryTerm: String) {
        var jsonObject: JSONObject = JSONObject();
        jsonObject.put("emailid", "umesh@yumfooo.in")
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