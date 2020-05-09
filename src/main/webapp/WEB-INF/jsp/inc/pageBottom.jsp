<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="footer">
    <div class="copyright">
        <a href="javascript:void(0)">2018 © Any problem please contact hua.xie@zhenai.com! </a>
    </div>
</div>

<!-- 信息确认框 -->
<div class="modal fade" id="confirmLabel" style="z-index: 3000;" >
    <div class="modal-dialog" style="width: 400px;">
        <div class="modal-content message_align" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title confirmTitle">提示信息</h4>
            </div>
            <div class="modal-body">
                <p class="confirmContent">您确定要执行此操作吗?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a class="btn btn-success confirmOK" data-dismiss="modal">确定</a>
            </div>
        </div>
    </div>
</div>

<!-- 信息提示框 -->
<div class="modal fade" id="alertLabel" style="z-index: 3000;">
    <div class="modal-dialog" style="width: 300px;">
        <div class="modal-content message_align" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title alertTitle">提示信息</h4>
            </div>
            <div class="modal-body">
                <p class="alertContent"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>

<!-- 图片显示框 -->
<div class="modal fade text-center" id="imageViewLabel" tabindex="-1" role="dialog" style="z-index: 3000;" >
    <div class="modal-dialog modal-lg" style="display: inline-block; width: auto;">
        <div class="modal-content">
            <img src="" style="max-width: 1080px;">
        </div>
    </div>
</div>