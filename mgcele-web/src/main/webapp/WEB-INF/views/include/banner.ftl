<style type="text/css">
    body {font-size:12px; color:#222; font-family:Verdana,Arial,Helvetica,sans-serif; background:#f0f0f0; margin:0px; padding:0px;}

</style>
<div id="Banner">
    <div id="imgAdv" align="left" >
    </div>
</div>
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
