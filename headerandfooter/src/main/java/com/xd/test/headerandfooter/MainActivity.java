package com.xd.test.headerandfooter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<String> list = new ArrayList<>();
        for(int i = 0;i<15;i++)
        {
            list.add(i+"");
        }
        rv.setLayoutManager(new LinearLayoutManager(this));
        BaseQuickAdapter<String,BaseViewHolder> baseViewHolderBaseQuickAdapter =new BaseQuickAdapter<String, BaseViewHolder>(R.layout.activity_rv_item, list) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.itemTv,item);
            }
        };
        baseViewHolderBaseQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
            }
        });
        rv.setAdapter(baseViewHolderBaseQuickAdapter);
        baseViewHolderBaseQuickAdapter.addHeaderView(getHeaderView());
        baseViewHolderBaseQuickAdapter.addFooterView(getFooterView(),0);
    }

    private View getFooterView() {
        View v = getLayoutInflater().inflate(R.layout.activity_footer_layout,(ViewGroup) rv.getParent(),false);
        v.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "activity_footer_layout", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
    private View getHeaderView() {
        View v = getLayoutInflater().inflate(R.layout.activity_header_layout,(ViewGroup) rv.getParent(),false);
        v.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "activity_header_layout", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
