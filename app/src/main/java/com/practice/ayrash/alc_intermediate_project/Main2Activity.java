package com.practice.ayrash.alc_intermediate_project;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        User user = (User) getIntent().getSerializableExtra(MainActivity.EXTRA);
        user.getAvatarUrl();
        user.getLogin();
        user.getUrl();

    }

    //ImageView imageView = (ImageView)findViewById(R.id.profile_photo);
//    class CustomViewHolder {
//        protected ImageView imageView;
//        protected TextView textView;
//        private User user;
//
//        public CustomViewHolder(View view){
//            super(view);
//            this.imageView = (ImageView) view.findViewById(R.id.profile_picture);
//            this.textView = (TextView) view.findViewById(R.id.user_name);
//        }
//
//        void bindUser(User user, Context context){
//            this.user =  user;
//            Picasso.with(context)
//                    .load(user.getAvatarUrl())
//                    .resize(250, 200)
//                    .placeholder(R.drawable.placeholder)
//                    .into(imageView);
//
//            textView.setText(user.getLogin());
//        }}



    }
