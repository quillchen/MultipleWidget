package com.quill.mw.widget.slide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by hspcadmin on 2016/6/30.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    protected  void openActivity(Class<?> clazz){
        startActivity(new Intent(this,clazz));
    }
}
