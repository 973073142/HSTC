<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册用户成功页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style>
		#div1{
			text-align:center;  
		    margin:0 auto;  
		    padding:0;  
		    clear:both;
			    
		}
    
    </style>
  </head>
  
  <body>
  <div id="div1">
  	<h1>${msg }</h1>
  	<div id="success">
		<a href="${pageContext.request.contextPath }/login.jsp" align="center">去登录</a> 
	</div>
  
  
  </div>
  	
  	 
  </body>
</html>
