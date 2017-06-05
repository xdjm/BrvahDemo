package com.xd.test.brvahdemo.data;

import com.xd.test.brvahdemo.R;
import com.xd.test.brvahdemo.bean.Bean;
import com.xd.test.brvahdemo.section.Guanjia;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/6/5 at 10:17
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
public class Getdata {
    public static  List<Guanjia> getData() {
        List<Guanjia> list = new ArrayList<>();
        list.add(new Guanjia(true,"Game"));
        list.add(new Guanjia(new Bean(R.drawable.animal_1)));
        list.add(new Guanjia(new Bean(R.drawable.animal_2)));
        list.add(new Guanjia(true,"Work"));
        list.add(new Guanjia(new Bean(R.drawable.animal_3)));
        list.add(new Guanjia(new Bean(R.drawable.animal_4)));
        list.add(new Guanjia(new Bean(R.drawable.animal_5)));
        list.add(new Guanjia(true,"Home"));
        list.add(new Guanjia(new Bean(R.drawable.animal_6)));
        list.add(new Guanjia(true,"Love"));
        list.add(new Guanjia(new Bean(R.drawable.animal_7)));
        list.add(new Guanjia(new Bean(R.drawable.animal_8)));
        list.add(new Guanjia(new Bean(R.drawable.animal_9)));
        list.add(new Guanjia(new Bean(R.drawable.animal_10)));
        return list;
    }
}
