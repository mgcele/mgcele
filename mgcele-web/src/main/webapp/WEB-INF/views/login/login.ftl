<#assign base=request.contextPath/>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>我是登陆页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel=stylesheet type=text/css href="${base}/cdn/img/style.css">
    <link rel="stylesheet" href="${base}/cdn/css/login.css" type="text/css"></link>
    <link rel="stylesheet" href="${base}/cdn/img/style3.css" type="text/css"></link>
    <link type="text/css" rel="stylesheet" href="${base}/cdn/js/weebox0.4/weebox.css" />

    <script language="JavaScript">
        if (window.top != self){
            window.top.location = self.location;
        }
    </script>

</head>

<body style="text-align: center;">
<form id="fm1" class="fm-v clearfix" action="login_login.do" method="post" onsubmit="return submitForm()">
    <div class="w">
        <div id="logo"><img src="${base}/cdn/img/logo.jpg" alt="广告管理"></div>
    </div>
    <div class=" w1" id="entry">
        <div class="mc " id="bgDiv">
            <div id="entry-bg"  style="width: 511px; height: 357px; position: absolute; top:10px;left:10px;">
                <div id="Banner">
                    <div id="imgAdv" align="left" >

                    </div>
                </div>
            </div>
            <div class="form " style="text-align: left;">
                <div class="item fore1">
                    <span>用户名</span>
                    <div class="item-ifo">
                        <input id="username" name="user.loginname" class="text" tabindex="1" accesskey="n" type="text" value=""  tabindex="1"  size="25" autocomplete="false"/>
                    </div>
                </div>
                <div class="item fore2">
                    <span>密码</span>
                    <div class="item-ifo">
                        <input id="password" name="user.pwd" class="text" tabindex="2" accesskey="p" type="password" value="" size="25" autocomplete="off"/>
                    </div>
                </div>
                <#--<div class="item fore3  " id="o-authcode">
                    <span>验证码</span>
                    <div class="item-ifo">
                        <input id="ValidateCode" name="ValidateCode" class="text text-1" tabindex="6"  style="ime-mode:disabled" accesskey="p" type="text" value="" size="5" maxlength="4" autocomplete="off"/>
                        <label class="img">
                            <img src="image.jsp" title="点击重新获取验证码" style="cursor:pointer;width:100px;height:33px;display:block;"  onclick="this.src='image.jsp?date='+new Date();"/>
                        </label>
                    </div>
                </div>-->

                <input type="submit"  id="loginsubmit" value="" style="width:311px;height:36px;border:none;background: url(${base}/cdn/img/login/login_bg.jpg) no-repeat;cursor:pointer; margin: 0 auto 5px auto; ">

                <input type="button"  id="orderquery" onclick="findOrderBtn('','');"  value="" style="width:311px;height:36px;border:none;background: url(${base}/cdn/img/login/btn_ddcx_bg.jpg) no-repeat;cursor:pointer; margin: 0 auto 5px auto; ">
                <input type="button"  id="orderApply"  onclick="addmessageOrderBtn();"value="" style="display:none;width:311px;height:36px;border:none;background: url(${base}/cdn/img/login/btn_ddtj_bg.jpg) no-repeat;cursor:pointer; margin: 0 auto 5px auto; ">
                <span>初始用户名：admin 密码：ad</span>
            </div>
        </div>
    </div>
</form>
<div class="w">
    <div id="footer-2013">
        <div class="copyright">Copyright &#169;2014 &nbsp;&nbsp;广告管理助手&nbsp;版权所有</div>
    </div>
</div>

<script src="${base}/cdn/js/cookie.js"></script>
<script src="${base}/cdn/js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${base}/cdn/js/weebox0.4/bgiframe.js"></script>
<script type="text/javascript" src="${base}/cdn/js/weebox0.4/weebox.js"></script>
<script language="javascript" type="text/javascript" src="${base}/cdn/My97DatePicker/WdatePicker.js" ></script>

<style type="text/css">
    body {font-size:12px; color:#222; font-family:Verdana,Arial,Helvetica,sans-serif; background:#f0f0f0; margin:0px; padding:0px;}

</style>

<script type="text/javascript">
    var n=1;
    var m=5;
    function show(){
        for(var i=1;i<=m;i++){
            if(i==n){
                $("#a"+i).show();
            }else{
                $("#a"+i).hide();
            }
        }
        if(n==m){
            n=1;
        }else{
            n++;
        }
    }
    var t=setInterval("show()",10000);

    $(function(){
        show();
        $.ajax({
            type: "POST",
            url: "login_getAdv.do",
            dataType:"html",
            success: function(msg){
                $("#imgAdv").html(msg);
            }
        });
    });

</script>
<script>
    function submitForm(){
        if($.trim($("#username").val())==""){
            alert("请输入用户名!");
            $("#username").focus();
            return false;
        }
        if($.trim($("#password").val())==""){
            alert("请输入密码!");
            $("#password").focus();
            return false;
        }
        /*if($.trim($("#ValidateCode").val())==""){
            alert("请输入验证码!");
            $("#ValidateCode").focus();
            return false;
        }*/
        //	if(document.getElementById("RememberMe").checked==true){
        //设置cookie
        //	SetCookie("adv_loginName",document.getElementById("username").value,60*60*24*365);
        //}
        return true;
    }
    $("#username").focus();

    function findOrderBtn(id,pwd){
        $.weeboxs.open('findorder.jsp?id='+id+'&pwd='+pwd, {title:'查询订单', contentType:'ajax',height:420,width:700,
            onok:function(){
                $.weeboxs.close();
            }
        });
    }

    function addmessageOrderBtn(){
        $.weeboxs.open('messageOrder.jsp', {title:'订单申请', contentType:'ajax',height:420,width:600,
            onok:function(){
                if($.trim($("#title").val())==""){
                    alert("请输入公司名称!");
                    $("#title").focus();
                    return false;
                }
                if($.trim($("#customername").val())==""){
                    alert("请输入联系人!");
                    $("#customername").focus();
                    return false;
                }
                if($.trim($("#phone").val())==""){
                    alert("请输入联系人电话!");
                    $("#phone").focus();
                    return false;
                }
                if($.trim($("#address").val())==""){
                    alert("请输入收货地址!");
                    $("#address").focus();
                    return false;
                }
                if($.trim($("#content").val())==""){
                    alert("请输入耗材需求");
                    $("#content").focus();
                    return false;
                }

                document.getElementById("MyForm").submit();

                $.weeboxs.close();
            }
        });
    }
    /*$(function(){
        if(<%=message%>!=null){
            $.weeboxs.open(<%=message%>, {title:'温馨提示！',height:100,width:300});
        }
    })*/

    $(function(){
        var isSub=true;
        $.ajax({
            type: "POST",
            url: "login_updateSystem.do",
            //data: "name=John&location=Boston",
            success: function(msg){
                if(msg!=""){
                    if($.trim(msg)=="register"){

                        $.weeboxs.open('settingCode.jsp', {title:'软件注册', contentType:'ajax',height:420,width:500,
                            onok:function(){
                                if($.trim($("#name_client").val())==""){
                                    alert("请输入企业名称！");
                                    return false;
                                }
                                if($.trim($("#areaSelect").val())==""){
                                    alert("请选择所在地区！");
                                    return false;
                                }
                                if($.trim($("#address_client").val())==""){
                                    alert("请输入企业地址！");
                                    return false;
                                }
                                if($.trim($("#telphone_client").val())==""){
                                    alert("请输入企业固定电话！");
                                    return false;
                                }
                                $.post("code_save.do","clientMessage.name="+$("#name_client").val()+"&clientMessage.address="+$("#address_client").val()+"&clientMessage.areacode="+$("#areaSelect").val()+"&clientMessage.qq="+$("#qq_client").val()+"&clientMessage.remarkN10="+$("#telphone_client").val()+"&clientMessage.phone="+$("#phone_client").val(),registerComplete,"text");
                            }
                        });
                    }else{
                        alert(msg);
                    }
                }
            }
        });
        $.ajax({
            type: "POST",
            url: "login_clientMessage.do",
            //data: "name=John&location=Boston",
            dataType:"text",
            success: function(msg){
                if(msg!=""){
                    document.getElementById("orderApply").style.display="block";
                }
            }
        });
    });
    function registerComplete(data){
        if(data!=null){
            if(data=="success"){
                alert("恭喜，软件注册成功！");
                $.weeboxs.close();
                //location.href="/login.jsp";
            }else{
                alert(data);
            }
        }
    }
</script>
</body>
</html>
