package com.example.thenoobydev.serverdataupload;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by thenoobydev on 31/3/18.
 */

public class MySingleton {
    private static MySingleton mySingleton;
    private RequestQueue requestQueue;
    private static Context mCtx;

    private MySingleton(Context context){
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized MySingleton getMySingleton(Context context){
        if (mySingleton == null){
            mySingleton = new MySingleton(context);
        }
        return mySingleton;
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T>void addTorequestque(Request<T> request){
        requestQueue.add(request);
    }
}
