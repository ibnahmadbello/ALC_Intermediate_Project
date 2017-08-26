package com.practice.ayrash.alc_intermediate_project;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.practice.ayrash.alc_intermediate_project.R.id.profile_photo;
import static com.practice.ayrash.alc_intermediate_project.R.id.profile_url;
import static com.practice.ayrash.alc_intermediate_project.R.id.user_name;
import static com.practice.ayrash.alc_intermediate_project.R.id.username;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2Activity";
    public static final String USERNAME_EXTRA = "extra";
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final User user = (User) getIntent().getSerializableExtra(MainActivity.EXTRA);
//        user.getAvatarUrl();
//        user.getLogin();
//        user.getUrl();

        ImageView imageView = (ImageView) findViewById(R.id.profile_photo);
        TextView textView1 = (TextView) findViewById(R.id.username);
        TextView textView2 = (TextView) findViewById(R.id.profile_url);

        Picasso.with(this)
                .load(user.getAvatarUrl())
                .placeholder(R.drawable.placeholder)
                .into(imageView);

        textView1.setText(user.getLogin());
        textView2.setText(user.getHtmlUrl());
        final String url = user.getHtmlUrl();

        textView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType("text/plain");
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Check out this awesome developer @");
                shareIntent.putExtra(Intent.EXTRA_TEXT, user.getLogin());
                shareIntent.putExtra(Intent.EXTRA_TEXT, user.getHtmlUrl());
                if (shareIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(shareIntent);
                }
            }
        });

    }

    }
