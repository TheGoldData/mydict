%{--
  - Copyright 2016-2019 新商态（北京）科技有限公司
  -
  - Licensed under the Apache License, Version 2.0 (the "License");
  - you may not use this file except in compliance with the License.
  - You may obtain a copy of the License at
  -
  -     http://www.apache.org/licenses/LICENSE-2.0
  -
  - Unless required by applicable law or agreed to in writing, software
  - distributed under the License is distributed on an "AS IS" BASIS,
  - WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  - See the License for the specific language governing permissions and
  - limitations under the License.
  --}%
<g:set var="ctx" value="${request.contextPath}"  scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>我的单词-登录</title>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
<style type="text/css">
	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
</style>
</head>
<body>
<div class="login-form">
    <form id="loginForm" action="${ctx}/doLogin" method="post">
        <h2 class="text-center">我的单词-登录</h2>
        <div class="form-group">
            <input type="text"  name="username" class="form-control" placeholder="登录名" required="required">
        </div>
        <div class="form-group">
            <input type="password" name="password" class="form-control" placeholder="密码" required="required">
        </div>
        <div class="form-group">
            <input type="text"  name="vcode" class="form-control" placeholder="输入下面的验证码" required="required">
            <img id="vv" src="${ctx}/code/vcode?timestamp=1"  style="width: 88px;margin-top: 20px;height: 30px;" onclick="chImg('${ctx}')">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">登录</button>
        </div>
        <div class="clearfix">
            %{--<label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>--}%
            %{--<a href="#" class="pull-right">Forgot Password?</a>--}%
        </div>        
    </form>
    <p class="text-center">注，帐号/密码是admin/admin</p>
    <script type="text/javascript">

        function chImg(ctx) {
            var imgSrc = $("#vv");
            var src = imgSrc.attr("src");
            imgSrc.attr("src", function(){
                var timestamp = (new Date()).valueOf();
                return ctx + "/code/vcode" + "?timestamp=" + timestamp;
            });
        }

        $("#loginForm").submit(function (e) {
            var $form=$(this)

            $.post("${ctx}/doLogin",$form.serialize(),function (data) {
                if(data.status!=1){
                    alert(data.msg)
                }else{
                    window.location='${ctx}/'
                }
            },'json')


            return false;
        })
    </script>
</div>
</body>
</html>                                		                            