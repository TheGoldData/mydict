/*
 * Copyright 2016-2019 新商态（北京）科技有限公司
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xst.golddata.mydict

import grails.converters.JSON
import mydict.UserInfo

/*
 * Created by wdg100 on 2019/3/28
 */

class MeController {

    def doLogin(String username,String password,String vcode){

        if(!vcode || !vcode.equalsIgnoreCase(session.getAttribute('validateCode'))){

            render( [status:0,msg:'验证码错误！'] as JSON)

        }

        if(username.equals("admin") && password.equals("admin")){

            UserInfo u=new UserInfo();
            u.username=username
            SessionUtils.setUser(session,u)
            render( [status:1,msg:'ok'] as JSON)
        }else{
            render( [status:0,msg:'用户名或者密码不匹配！'] as JSON)
        }

    }


    def exit(){
        SessionUtils.removeUser(session)
        response.sendRedirect('/')
    }

}
