package com.xd.test.brvahdemo.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xd.test.brvahdemo.R;

import com.xd.test.brvahdemo.section.Guanjia;

import java.util.List;

/**
 * Created by Administrator on 2017/6/5 at 9:32
 * <p>
 * Copyright (C) 2017 By Administrator
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class Adapter extends BaseSectionQuickAdapter<Guanjia,BaseViewHolder> {
    private Context context;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public Adapter(Context mcontext,int layoutResId, int sectionHeadResId, List<Guanjia> data) {
        super(layoutResId, sectionHeadResId, data);
        context = mcontext;
    }

    @Override
    protected void convertHead(BaseViewHolder helper, Guanjia item) {
        helper.setText(R.id.tv,item.header);
        helper.addOnClickListener(R.id.tv);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, Guanjia item) {
        Glide.with(context).load(item.t.getImgId()).into((ImageView)helper.getView(R.id.imageView));
    }
}
