package com.jli.materialtwitter.base;

import android.app.Application;
import android.util.Log;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

/**
 * Created by johnli on 7/8/15.
 */
public class BaseApplication extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "ENTER_TWITTER_KEY";
    private static final String TWITTER_SECRET = "ENTER_TWITTER_SECRET";

    @Override
    public void onCreate()
    {
        super.onCreate();
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

        Log.d("Twitter", "Initialized with extended application");

    }
}
