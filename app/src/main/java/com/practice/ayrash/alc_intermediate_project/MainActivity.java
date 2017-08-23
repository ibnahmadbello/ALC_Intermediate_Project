package com.practice.ayrash.alc_intermediate_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ALC Error";
    private List<User> UserList;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter adapter;
    private ProgressBar progressBar;
    public static String EXTRA = "User_Extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        adapter = new MyRecyclerViewAdapter(this, UserList);
        mRecyclerView.setAdapter(adapter);

        Presenter presenter = new Presenter(this);
        presenter.createInstance();

    }

    public Intent getIntent(User user){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra(EXTRA, user);
        return intent;
    }

    public void passList(UserList list){
        adapter = new MyRecyclerViewAdapter(this, list.getItems());
        mRecyclerView.setAdapter(adapter);
    }

    public void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }

    public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.CustomViewHolder> {
        private List<User> feedItemList;
        private Context mContent;
        public static final String USERNAME_EXTRA = "extra";

        //This is the constructor
        public MyRecyclerViewAdapter(Context context, List<User> feedItemList){
            this.feedItemList = feedItemList;
            this.mContent = context;
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.each_row, null);
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder customViewHolder, int i){
            User user = feedItemList.get(i);
            customViewHolder.bindUser(user, mContent);
        }

        @Override
        public int getItemCount(){
            return (null != feedItemList ? feedItemList.size() : 0);
        }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            protected ImageView imageView;
            protected TextView textView;
            private User user;

            public CustomViewHolder(View view){
                super(view);
                view.setOnClickListener(this);
                this.imageView = (ImageView) view.findViewById(R.id.profile_picture);
                this.textView = (TextView) view.findViewById(R.id.user_name);
            }

            void bindUser(User user, Context context){
                this.user =  user;
                Picasso.with(context)
                        .load(user.getAvatarUrl())
                        .resize(250, 200)
                        .placeholder(R.drawable.placeholder)
                        .into(imageView);

                textView.setText(user.getLogin());
            }

            @Override
            public void onClick(View v) {
                Intent intent = getIntent(user);
                startActivity(intent);
            }
        }

    }


}
