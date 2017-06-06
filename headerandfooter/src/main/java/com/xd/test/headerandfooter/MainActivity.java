package com.xd.test.headerandfooter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;
    private BaseQuickAdapter<String,BaseViewHolder> baseViewHolderBaseQuickAdapter;
    private int[] imgId = {
            R.drawable.colorful_1,
            R.drawable.colorful_2,
            R.drawable.colorful_3,
            R.drawable.colorful_4,
            R.drawable.colorful_5,

    };
    private int[] imgId_ ={
            R.drawable.footer_1,
            R.drawable.footer_2,
            R.drawable.footer_3,
            R.drawable.footer_4,
            R.drawable.footer_5,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<String> list = new ArrayList<>();
        for(int i = 0;i<15;i++)
        {
            if(i==0)
                list.add("添加头布局");
            else if(i==14)
                list.add("添加尾布局");
            else list.add(i+"");
        }
        rv.setLayoutManager(new LinearLayoutManager(this));
        baseViewHolderBaseQuickAdapter =new BaseQuickAdapter<String, BaseViewHolder>(R.layout.activity_rv_item, list) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.itemTv,item);
            }
        };
        baseViewHolderBaseQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(position==0)
                    baseViewHolderBaseQuickAdapter.addHeaderView(getHeaderView());
                else if(position==14)
                    baseViewHolderBaseQuickAdapter.addFooterView(getFooterView(),0);
                else Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
            }
        });
        rv.setAdapter(baseViewHolderBaseQuickAdapter);
        baseViewHolderBaseQuickAdapter.addHeaderView(getHeaderView());
        baseViewHolderBaseQuickAdapter.addFooterView(getFooterView(),0);
    }
    private View getFooterView() {
        final View view = getLayoutInflater().inflate(R.layout.activity_footer_layout,(ViewGroup) rv.getParent(),false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "FooterLayout remove", Toast.LENGTH_SHORT).show();
                baseViewHolderBaseQuickAdapter.removeFooterView(v);
            }
        });
        ImageView imageView = (ImageView) view.findViewById(R.id.img2);
        Glide.with(this).load(imgId[new Random().nextInt(5)]).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "FooterLayout",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    private View getHeaderView() {
        final View view = getLayoutInflater().inflate(R.layout.activity_header_layout,(ViewGroup) rv.getParent(),false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "HeaderLayout remove",Toast.LENGTH_SHORT).show();
                baseViewHolderBaseQuickAdapter.removeHeaderView(v);
            }
        });
        ImageView imageView = (ImageView) view.findViewById(R.id.img1);
        Glide.with(this).load(imgId_[new Random().nextInt(5)]).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "HeaderLayout",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
