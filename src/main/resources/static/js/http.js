var $http = function(){
}

/** 获取接口请求地址 **/
$http.rootPath = function(){
	return base + "/";
}

/** 包装post请求 **/
$http.post = function(url,data,callback){
	if( !url || !url.trim() ){
		return;
	}
	if( url.substring(0,1) == '/' ){
		url = url.substring(1);
	}
	url = $http.rootPath() + url;
	$.post(url,data,function(response){
		callback(response);
	},"json").error(function(response){
		var responseObj = JSON.parse(response.responseText);
		callback(responseObj);
	},"json");
};

/** 包装get请求 **/
$http.get = function(url,callback){
	if( !url || !url.trim() ){
		return;
	}
	if( url.substring(0,1) == '/' ){
		url = url.substring(1);
	}
	url = $http.rootPath() + url;
	$.get(url,function(response){
		callback(response);
	},"json").error(function(response){
		var responseObj = JSON.parse(response.responseText);
		callback(responseObj);
	},"json");
};

/** 链接跳转 **/
$http.location = function(url){
	if( url.substring(0,1) == '/' ){
		url = url.substring(1);
	}
	location.href  = $http.rootPath() + url; 
}

/** 链接跳转 **/
$http.open = function(url){
	if( url.substring(0,1) == '/' ){
		url = url.substring(1);
	}
	window.open($http.rootPath() + url);
}

/** 重新加载页面 **/
$http.reload = function(){
	window.location.reload(true);
}