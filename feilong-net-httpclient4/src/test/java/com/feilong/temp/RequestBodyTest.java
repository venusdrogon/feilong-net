/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.temp;

import static com.feilong.core.bean.ConvertUtil.toMap;

import org.junit.Test;

import com.feilong.json.jsonlib.JsonUtil;
import com.feilong.net.HttpMethodType;
import com.feilong.net.entity.HttpRequest;
import com.feilong.net.httpclient4.HttpClientUtil;
import com.feilong.test.AbstractTest;

public class RequestBodyTest extends AbstractTest{

    @Test
    public void test1(){
        test("http://127.0.0.1:8084/requestbody1?name=jinxin&age=18");
    }

    @Test
    public void test2(){
        test("http://127.0.0.1:8084/requestbody2?name=jinxin&age=18");
    }

    @Test
    public void test3(){
        test("http://127.0.0.1:8084/requestbody3?name=jinxin&age=18");
    }

    @Test
    public void test(){
        test("http://127.0.0.1:8084/requestbody4?name=jinxin&age=18");
    }

    //---------------------------------------------------------------

    private void test(String uri){
        HttpRequest httpRequest = new HttpRequest(uri, toMap("country", "china"), HttpMethodType.POST);

        httpRequest.setRequestBody(JsonUtil.format(httpRequest, 0, 0));
        LOGGER.debug(HttpClientUtil.getResponseBodyAsString(httpRequest));
    }
}
