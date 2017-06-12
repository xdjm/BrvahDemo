package com.xd.test.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    String s = "[\n" +
            "  {\n" +
            "    \"title\": \"AAAAAAAAAAAAAAAAAAAA\",\n" +
            "    \"content\": \"aaaaaaaaaaaaaaaaaaaa\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"BBBBBBBBBBBBBBBBBBBB\",\n" +
            "    \"content\": \"bbbbbbbbbbbbbbbbbbbbbbbb\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC\",\n" +
            "    \"content\": \"cccccccccccccccccccccccc\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"DDDDDDDDDDDD\",\n" +
            "    \"content\": \"dddddddddddddddddddddddddddddddd\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"EEEEEEEEEEEEEEEE\",\n" +
            "    \"content\": \"eeeeeeeeeeeeeeeeeeeeeeeeeee\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\",\n" +
            "    \"content\": \"ffffffffffffffff\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG\",\n" +
            "    \"content\": \"gggggggggggggggggggggggggggggggggggggggg\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH\",\n" +
            "    \"content\": \"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII\",\n" +
            "    \"content\": \"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii\"\n" +
            "  }\n" +
            "]";
    List<Bean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        rv = (RecyclerView) findViewById(R.id.rv);
        list = new ArrayList<>();
        Bean[] been = new Gson().fromJson(s, Bean[].class);
        Collections.addAll(list, been);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new BaseQuickAdapter<Bean, BaseViewHolder>(R.layout.activity_main, list) {
            @Override
            protected void convert(BaseViewHolder helper, Bean item) {
                helper.setText(R.id.textView1,item.getTitle());
                helper.setText(R.id.textView2,item.getContent());
            }
        });
    }
}
