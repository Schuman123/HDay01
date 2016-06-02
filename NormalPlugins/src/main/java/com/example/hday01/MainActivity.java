package com.example.hday01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bean.GiftBean;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.HttpUitls;

public class MainActivity extends AppCompatActivity {
    private List<String> data = new ArrayList<>();

    @Bind(R.id.button)
    Button btn_open;
    @Bind(R.id.button2)
    Button btn_close;
    @Bind(R.id.ratingBar)
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button, R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String json = HttpUitls.doGetToString("http://zhushou.72g.com/app/gift/gift_list/");
                        GiftBean giftBean =  new Gson().fromJson(json, GiftBean.class);
                        String s = giftBean.getInfo().toString();
                        Log.i("s", "run: "+s);

                    }
                }).start();

                break;
            case R.id.button2:
                Toast.makeText(MainActivity.this, "xixixi", Toast.LENGTH_SHORT).show();
                break;
        }
    }

   /* public class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return data.size() != 0 ? data.size() : 0;
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            LayoutInflater.from(MainActivity.this).inflate(R.layout.item_play, null);

            return null;
        }

    }
    static class ViewHolder {
        @Bind(R.id.button3)
        Button button3;
        @Bind(R.id.textView)
        TextView textView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }*/
}
