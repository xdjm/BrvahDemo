package com.xd.test.loadmore;

import com.chad.library.adapter.base.loadmore.LoadMoreView;

/**
 * Created by Administrator on 2017/6/7 at 23:13
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
 class CustLoadingView extends LoadMoreView{

    @Override
    public int getLayoutId() {
        return R.layout.loading_getlayout;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.load_more_loading_view;
    }


    @Override
    protected int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }


    @Override
    protected int getLoadEndViewId() {
        return R.id.load_more_load_end_view;
    }
}
