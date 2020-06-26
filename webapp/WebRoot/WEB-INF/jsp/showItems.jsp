<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>水果商品展示</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="js/bootstrap-datetimepicker.zh-CN.js"></script>
	
	<!-- 让表格中的文字有居中 -->
	<style>
	#headName{
			text-align:center;  
		    margin:0 auto;  
		    padding:0;  
		    clear:both;
	}
     th {text-align:center}
     
     /* body{
     	background-image: url(D:\000常用文件夹\试用\JAVA  EE\try\WebRoot\upload\IMG_20160914_094127.jpg);
        background-repeat: no-repeat;
        background-size: cover;
     	
     	
     } */
     
    </style>
</head>

<script type="text/javascript">
<!-- 添加模态框（Modal）插件 -->
	$("#myModal").modal({
		keyboard : false,
		backdrop : true
	});
	$(function() {

		$(".form_datetime").datetimepicker({
			format : "yyyy-mm-dd hh:ii",
			autoclose : true,
			todayBtn : true,
			todayHighlight : true,
			showMeridian : true,
			pickerPosition : "bottom-left",
			language : 'zh-CN',//中文，需要引用zh-CN.js包
			startView : 2,//月视图
			minView : 2
		//日期时间选择器所能够提供的最精确的时间选择视图
		});
	});
</script>
<body>
<!-- 	<img alt="backgroundPic" src="//D:/000常用文件夹/试用/JAVA  EE/try/WebRoot/uploa/IMG_20160914_094127.jpg">
 -->	<div class="container">
			<div class="col-md-offset-10">
				<h4>
					欢迎您:&nbsp;&nbsp;<span class="glyphicon glyphicon-user"></span>
					<strong>${userLogin.username }</strong><small>
					<a href="${pageContext.request.contextPath }/user/logOut.action">注销</a></small>
				</h4>
			</div>
		
		<div id="headName" style="margin:0 auto;"> <h1>韩师软工果蔬旗舰店</h1> </div>
		
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-7">
				<h2>水果展示</h2>
				
			</div>
		</div>
		<!-- 按钮-->
		<div class="row">
			<div class="col-md-6 col-md-offset-10">
				<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#myModal">
					<span class="glyphicon glyphicon-plus"></span>添加水果
				</button>
			</div>
		</div>
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<form
					action="${pageContext.request.contextPath }/items/addCar.action"
					method="post">
					<table class="table table-bordered table-hover">
						<tr class="success" align="center">
							<th>水果名称</th>
							<th>水果价格</th>
							<th>水果图片</th>
							<th>水果介绍</th>
							<th>生产日期</th>
							<!-- colspan="3"clospan就是column span表格中的跨列，就是横向合并表格的3个单元格. -->
							<th colspan="3">操作</th>
						</tr>
						<!--  --><!--  -->
						<!--  --><!--  -->
						<!--  --><!--  -->
						<!--  --><!--  -->
						<!--  --><!--  -->
						
						<c:forEach items="${pageInfo.list}" var="item">
							<tr align="center">
								<td>${item.name }</td>
								<td>${item.price }</td>
								<!-- 照片显示 -->
								<td><img title="${item.detail }"
									style="width: 60px; height: 60px"
									src="${pageContext.request.contextPath}/upload/${item.pic}"></td>
									
								<td>${item.detail }</td>
								<!-- fmt函数库提供返回日期格式 -->
								<td><fmt:formatDate value="${item.createtime}"
										pattern="yyyy-MM-dd" /></td>
								<!-- 删除操作-带id参数 -->
								<td><a
									href="${pageContext.request.contextPath }/items/del.action?id=${item.id}"><button
											type="button" class="btn btn-success btn-lg"
											onclick="return confirm('确定要删除信息吗？') ">
											<span class="glyphicon glyphicon-trash"></span> 删除
										</button></a></td>
								<!-- 修改操作 -->	
								<td><a
									href="${pageContext.request.contextPath }/items/findOne.action?id=${item.id}"><button
											type="button" class="btn btn-success btn-lg">
											<span class="glyphicon glyphicon-edit"></span> 修改
										</button></a></td>
							</tr>
						</c:forEach>
					</table>
				</form>
			</div>
		</div>
		<!-- 分页 -->
		<div class="row">
			<!-- 分页信息 -->
			<div class="col-md-6">
				<h4>当前第${pageInfo.pageNum }页，共${pageInfo.pages }页，共${pageInfo.total }条记录数</h4>
			</div>
			<!-- 分页条 -->
			<div class="col-md-6">
				<ul class="pagination pagination-lg">
					<li><a
						href="${pageContext.request.contextPath }/items/queryItems.action?pn=1">首页</a></li>
					<c:if test="${pageInfo.hasPreviousPage }">
						<li><a
							href="${pageContext.request.contextPath }/items/queryItems.action?pn=${pageInfo.pageNum-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:forEach items="${pageInfo.navigatepageNums }" var="nav">
						<c:if test="${nav==pageInfo.pageNum }">
							<li class="active"><a
								href="${pageContext.request.contextPath }/items/queryItems.action?pn=${nav}">${nav }</a></li>
						</c:if>
						<c:if test="${nav!=pageInfo.pageNum }">
							<li><a
								href="${pageContext.request.contextPath }/items/queryItems.action?pn=${nav}">${nav }</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pageInfo.hasNextPage}">
						<li><a
							href="${pageContext.request.contextPath }/items/queryItems.action?pn=${pageInfo.pageNum+1}"
							aria-label="Previous"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a
						href="${pageContext.request.contextPath }/items/queryItems.action?pn=${pageInfo.pages}">末页</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 添加商品的模态框-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
			<!-- 模态框的标题 -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加商品</h4>
				</div>
				<!-- 模态框的主体-表单头部 -->
				<form class="form-horizontal" role="form"
					action="${pageContext.request.contextPath }/items/addItems.action"
					method="post" id="form" enctype="multipart/form-data">
					<div class="modal-body">
						<div class="form-group  form-group-lg">
							<label for="firstname" class="col-sm-3 control-label">商品名称:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control input-lg" id="name"
									name="name" placeholder="请输入商品名字" required autofocus>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">商品价格:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control input-lg" id="price"
									name="price" placeholder="请输入商品价格" required autofocus>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">商品生产日期:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control input-lg form_datetime"
									id="createtime" name="createtime">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">商品介绍:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control input-lg" id="detail"
									name="detail" placeholder="请输入商品介绍" required autofocus>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">上传商品图片:</label>
							<div class="col-sm-5">
								<input type="file" class="form-control input-lg" id="items_pic"
									name="items_pic">
							</div>
						</div>
					</div>
					<!-- 模态框的尾部 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary" id="save">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>