<#assign base=request.contextPath/>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>测试</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${base}/cdn/css/bootstrap.min.css">
</head>
<body style="background-color: #E2E2E2;">
<div>
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label for="firstname" class="col-sm-4 control-label">用户名:</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="firstname" placeholder="请输入用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-4 control-label">密码:</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="lastname" placeholder="请输入密码">
            </div>
        </div>
       <#-- <div class="form-group">
            <div class="col-sm-offset-4 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox">请记住我
                    </label>
                </div>
            </div>
        </div>-->
        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-10">
                <button type="submit" class="btn btn-default">注册</button>
                <button type="submit" class="btn btn-default">登录</button>
            </div>
        </div>
    </form>
</div>
</body>
<script src="${base}/cdn/js/plugins/jquery-2.1.1.min.js"></script>
<script src="${base}/cdn/js/plugins/bootstrap.min.js"></script>
</html>