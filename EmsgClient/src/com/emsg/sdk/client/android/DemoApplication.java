
package com.emsg.sdk.client.android;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.emsg.sdk.EmsgClient;
import com.emsg.sdk.EmsgClient.EmsStateCallBack;

public class DemoApplication extends Application {
    private static final String TAG = Application.class.getSimpleName();

    private EmsgClient mEmsgClient = null;

    public EmsgClient getEmsgClient() {
        return mEmsgClient;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mEmsgClient = EmsgClient.getInstance();
        mEmsgClient.init(this);
        mEmsgClient.setEmsStCallBack(new EmsStateCallBack() {
          
            @Override
            public void onAnotherClientLogin() {
                Toast.makeText(DemoApplication.this, "被迫下线", Toast.LENGTH_LONG).show();
            }

			@Override
			public void onEmsgClosedListener() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onEmsgOpenedListener() {
				// TODO Auto-generated method stub
				
			}
        });
    }

    @Override
    public void onTerminate() {
        try {
            mEmsgClient.closeClient();
        } catch (Exception ex) {
            Log.e(TAG, "尝试关闭client异常." + ex.getMessage(), ex);
        }
        super.onTerminate();
    }

}
