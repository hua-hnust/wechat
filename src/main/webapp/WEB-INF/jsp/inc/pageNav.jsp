<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="sidebar" role="navigation" data-step="2" data-position="right" class="navbar-default navbar-static-side">
    <div class="sidebar-collapse menu-scroll">
        <ul id="side-menu" class="nav">

            <div class="clearfix"></div>
            <li class="console">
                <a href="${base}/user">
                    <i class="fa fa-tachometer fa-fw"><div class="icon-bg bg-orange"></div></i>
                    <span class="menu-title"> 用户管理 </span>
                </a>
            </li>

            <li class="user">
                <a href="${base}/notice">
                    <i class="fa fa-database fa-fw"><div class="icon-bg bg-red"></div></i>
                    <span class="menu-title"> 通知 </span>
                </a>
            </li>

            <li class="mobile">
                <a href="${base}/news">
                    <i class="fa fa-file-o fa-fw"><div class="icon-bg bg-red"></div></i>
                    <span class="menu-title"> 新闻信息 </span>
                </a>
            </li>
        </ul>
    </div>
</nav>
<jsp:include page="scripts.jsp"/>
