package com.jli.materialtwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

/**
 * Created by johnli on 7/8/15.
 */
public class LoginActivity  extends AppCompatActivity{

    View contentView;
    private TwitterLoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        contentView =  (View) findViewById(R.id.rootLayout);

        final Activity currentActivity = this;
        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {

            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                Log.d("MatTwitter", "Success Login");
                Intent myIntent = new Intent(currentActivity, MainActivity.class);
                startActivity(myIntent);
                finish();
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Log.d("MatTwitter", "Failed Login");
            }
        });

        TwitterSession session = Twitter.getSessionManager().getActiveSession();
        if(session != null)
        {
            Intent myIntent = new Intent(currentActivity, MainActivity.class);
            startActivity(myIntent);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
