package com.jli.materialtwitter;

import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;


public class MainActivity extends AppCompatActivity {
    private View contentView;

    FloatingActionButton fab;
    ListView tweetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentView =  (View) findViewById(R.id.rootLayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTweetComposer();
            }
        });

        tweetList = (ListView) findViewById(R.id.twitterList);
        getHomeTimeline();
    }

    void showSnackBar()
    {
        Snackbar.make(contentView, "Hello. I am Snackbar!", Snackbar.LENGTH_SHORT)
                .setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .show();
    }

    void showTweetComposer()
    {
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("");
        builder.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    void getHomeTimeline()
    {
        UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("Cloudspace")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter(this, userTimeline);
        tweetList.setAdapter(adapter);
    }
}
