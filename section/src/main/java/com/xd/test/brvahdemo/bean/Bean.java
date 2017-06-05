package com.xd.test.brvahdemo.bean;

/**
 * Created by Administrator on 2017/6/5 at 9:27
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
public class Bean  {
    public Bean(int imgId) {
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public Bean setImgId(int imgId) {
        this.imgId = imgId;
        return this;
    }

    public String getImgName() {
        return imgName;
    }

    public Bean setImgName(String imgName) {
        this.imgName = imgName;
        return this;
    }

    int imgId;
    String imgName;

}
