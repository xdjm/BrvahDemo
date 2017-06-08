package com.xd.test.animandempty;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @butterknife.BindView(R.id.toolbar)
    Toolbar toolbar;
    @butterknife.BindView(R.id.rv)
    RecyclerView rv;
    private BaseQuickAdapter<String,BaseViewHolder> baseViewHolderBaseQuickAdapter;
    private View view_Empty, view_NoData,view_Loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        rv.setLayoutManager(new LinearLayoutManager(this));
        view_Empty = getLayoutInflater().inflate(R.layout.activity_main_empty, (ViewGroup) rv.getParent(), false);
        view_Empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFresh();
            }
        });

        view_NoData = getLayoutInflater().inflate(R.layout.activity_main_error, (ViewGroup) rv.getParent(), false);
        view_NoData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFresh();
            }
        });

        view_Loading = getLayoutInflater().inflate(R.layout.activity_main_loading, (ViewGroup) rv.getParent(), false);
        baseViewHolderBaseQuickAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.activity_main_item, null) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.textView, item);
            }
        };
        baseViewHolderBaseQuickAdapter.isFirstOnly(false);
        rv.setAdapter(baseViewHolderBaseQuickAdapter);
        onFresh();
    }

    private void onFresh() {
        baseViewHolderBaseQuickAdapter.setEmptyView(view_Loading);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(error) {
                    error = false;
                    baseViewHolderBaseQuickAdapter.setEmptyView(view_Empty);
                }
                else {if(exit){
                    exit = false;
                    baseViewHolderBaseQuickAdapter.setEmptyView(view_NoData);
                }
                else{
                    baseViewHolderBaseQuickAdapter.setNewData(getData(1000));
                }
                }
            }
        },2000);
    }

    private boolean error = true;
    private boolean exit = true;
    private List<String> getData(int ii) {
        List<String> list =new ArrayList<>();
        for(int i=0;i<ii;i++){
            if(i==0)
                list.add("点击菜单切换动画样式");
            else
            list.add(""+i);
        }
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.alpha:
                baseViewHolderBaseQuickAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                break;
            case R.id.scalein:
                baseViewHolderBaseQuickAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                break;
            case R.id.slideinbottom:
                baseViewHolderBaseQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                break;
            case R.id.slideinleft:
                baseViewHolderBaseQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                break;
            case R.id.slideinright:
                baseViewHolderBaseQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
