<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${base}/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${base}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${base}/static/js/jquery.menu.js"></script>
<script type="text/javascript" src="${base}/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${base}/static/js/bootstrap-hover-dropdown.js"></script>
<script type="text/javascript" src="${base}/static/js/http.js"></script>
<script>
    function selectNav(className){
        $("#side-menu li."+className).addClass("active");
    }

    /** 弹出框 **/
    function alert(message){
        $("#alertLabel .alertContent").html(message);
        $("#alertLabel").modal("show");
    }

    /** 确认框 **/
    function confirm(param,callback){

        $("#confirmLabel .confirmOK").unbind("click");

        if( param && param.title ){
            $("#confirmLabel .confirmTitle").html(param.title);
        }else{
            $("#confirmLabel .confirmTitle").html("提示信息");
        }

        if( param && param.content ){
            $("#confirmLabel .confirmContent").html(param.content);
        }else{
            $("#confirmLabel .confirmContent").html("您确定要执行此操作吗?");
        }
        $("#confirmLabel").modal("show");

        if( callback ){
            $("#confirmLabel .confirmOK").bind("click",callback);
        }else{
            $("#confirmLabel .confirmOK").unbind("click");
        }
    }

    /** 弹出图片 **/
    function showImage(url){
        $("#imageViewLabel img").attr("src",url);
        $("#imageViewLabel").modal('show');
    }

</script>