package com.emsg.sdk;

import java.util.Date;

import android.util.Log;

public class MyLogger {
	private final boolean isDebug = false;
	private final String TAG_EMSGCLIENT = "LogFromEmsgClient";
	
	private Class<?> clazz = null;
	
	public MyLogger(Class<?> c){
		clazz = c;
	}
	
	public void info(Object o){
		if(isDebug)
			Log.i(TAG_EMSGCLIENT, "["+new Date()+"]"+clazz.getName()+" : "+o.toString());
	}
	
	public void debug(Object o){
		if(isDebug)
			Log.d(TAG_EMSGCLIENT, "["+new Date()+"]"+clazz.getName()+" : "+o.toString());
	}
	
}
