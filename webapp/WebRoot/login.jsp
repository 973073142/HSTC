<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="登录,ssm练习,web项目">
<meta http-equiv="description" content="This is login page">
<!-- 引入css和js -->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<!-- ajax提交方式 -->
<script type="text/javascript">
	/* Js控制通过#myModal的状态：*/
	$("#myModal").modal({
		keyboard : false,
		backdrop : false
	});

	/* Js控制注册日期的状态：*/
	$(function() {
		$(".form_datetime").datetimepicker({
			format : "yyyy-mm-dd hh:ii",
			autoclose : true,
			todayBtn : true,
			todayHighlight : true,
			showMeridian : true,
			pickerPosition : "bottom-left",
			language : 'zh-CN', //中文，需要引用zh-CN.js包
			startView : 2, //月视图
			minView : 2//日期时间选择器所能够提供的最精确的时间选择视图		
		});

		/* 以json的格式提交登录传参 */
		$("#lo")
				.click(
						function() {
							$
									.ajax({
										type : 'post',
										//提交路径
										url : '${pageContext.request.contextPath}/user/checkLogin.action',
										//声明为json格式
										contentType : 'application/json;charset=utf-8',
										//转为json格式
										data : JSON.stringify({
											"username" : $("#loginusername")
													.val(),
											"password" : $("#loginpassword")
													.val()
										}),
										//点击登录以后拿到数据
										success : function(data) {
											if (data == "" || data == null) {//判断
												$("#message").html("用户名或密码错误！");
											} else {//正常跳转--已修改
												window.location.href = "${pageContext.request.contextPath}/items/queryItems.action";
											}
										}
									});
						});
	});
</script>
<style>
#login {
	width: 450px;
	height: 100px;
	margin: 50px auto;
}


</style>
</head>
	<body >
	<!-- background="../WebRoot/upload/2345_image_file_copy_1.jpg" -->
	
		     
		     <center>
		     <br><br><br>
		    <font style="font-size:50px" face="宋体" color="#361410">
		        	 韩师软工果蔬旗舰店
		     </font>
		     </center>
		   
		<div class="container">
			<div id="login">
				<!-- 登录模块，以json提交form就可以不写action -->
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="loginusername" class="col-sm-2 control-label">用户名:</label>
						<div class="col-sm-10">
						<!-- input中的name可作为传送参数的的对应名称，用JSON用@RequestBody -->
							<input type="text" class="form-control" id="loginusername"
								name="userName" placeholder="请输入用户名" required autofocus>
						</div>
					</div>
					<div class="form-group">
						<label for="login+password" class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;码:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="loginpassword"
								name="password" placeholder="请输入密码" required> <label
								class="control-label" for="inputSuccess1" style="color: red;"
								id="message"></label>
						</div>
					</div>
					<!-- 登录注册按钮 -->
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-info" id="lo">登录</button>
							<!-- <button type="button" class="btn btn-danger" data-toggle="modal"
								data-target="#myModal" id="#register"> 注册</button> -->
							<button type="button" class="btn btn-info"
								data-toggle="modal" data-target="#register">
								<span class="glyphicon glyphicon-plus"></span>注册
							</button>
							
						</div>
					</div>
				</form>
			</div>
			
			
			<!-- 注册 -->
			<div id="register" class="modal fade" tabindex="-1">
          <div class="modal-dialog">
             <div class="modal-content">
                  <div class="modal-body">
                      <button class="close" data-dismiss="modal">
                          <span>&times;</span>
                     </button>
                  </div>
                  <div class="modal-title">
                      <h1 class="text-center">注册</h1>
                  </div>
                  <div class="modal-body">
                      <form class="form-group" action="${pageContext.request.contextPath }/user/register.action"
					method="post" id="form" enctype="multipart/form-data" >
					
                              <div class="form-group">
                                  <label for="username">用户名</label>
                                  <input class="form-control" type="text" 
                                  		name="username" placeholder="6-15位字母或数字">
                              </div>
                              <div class="form-group">
                                  <label for="password">密码</label>
                                  <input class="form-control" type="password" 
                                  		name="password" placeholder="至少6位字母或数字">
                              </div>
                              
                              
							
							<div class="form-group">
                                  <label for="sex">性别</label>
                                  <input class="form-control" type="text" 
                                  		name="sex" placeholder="性别以数字替代1=男 0=女">
                              </div>
                              
                              <div class="form-group">
                                  <label for="address">住址</label>
                                  <input class="form-control" type="text" 
                                  		name="address" placeholder="至少6位字母或数字">
                              </div>
							
                              <!-- <div class="form-group">
                                  <label for="">再次输入密码</label>
                                  <input class="form-control" type="password" placeholder="至少6位字母或数字">
                              </div> -->
                             <!--  <div class="form-group">
                                  <label for="">邮箱</label>
                                  <input class="form-control" type="email" placeholder="例如:123@123.com">
                              </div> -->
                              
                              
                              
                              <!-- 提交或取消注册申请 -->
                              <div class="text-right">
                                  <button class="btn btn-primary" type="submit">提交</button>
                                  <button class="btn btn-danger" data-dismiss="modal">取消</button>
                              </div>
                              <!-- <a href="" data-toggle="modal" data-dismiss="modal" data-target="#lo">已有账号？点我登录</a> -->
                      </form>
                  </div>
              </div>
          </div>
      </div>
		</div>
	</body>
</html>
