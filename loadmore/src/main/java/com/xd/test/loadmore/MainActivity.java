package com.xd.test.loadmore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @butterknife.BindView(R.id.rv)
    RecyclerView rv;
    private BaseQuickAdapter<String,BaseViewHolder> baseViewHolderBaseQuickAdapter;
    private static int PAGE_ =40;
    private  int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        baseViewHolderBaseQuickAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.activity_main_item,getList(16)) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.textView,item);
            }
        };

        baseViewHolderBaseQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                }
        });
        baseViewHolderBaseQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener(){
            @Override
            public void onLoadMoreRequested() {
                rv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(baseViewHolderBaseQuickAdapter.getData().size()<PAGE_){
                            baseViewHolderBaseQuickAdapter.addData(getList(i++));
                            baseViewHolderBaseQuickAdapter.loadMoreComplete();}
                        else baseViewHolderBaseQuickAdapter.loadMoreEnd();
                    }
                },1000);
            }
        },rv);

        baseViewHolderBaseQuickAdapter.setLoadMoreView(new CustLoadingView());
        rv.setAdapter(baseViewHolderBaseQuickAdapter);
    }
    public  List<String> getList(int length){
        List<String> list=new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(i + "");
        }
        return list;
    }
}
