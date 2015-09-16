<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>个人中心</title>
	</head>
	
	<body>
	
	<div id="head" style="position:absolute;top:0px;left:10%;right:10%;width:80%;height:10%">
		<jsp:include page="/WEB-INF/content/head.jsp"/>
	</div>
	 

	<div id="personal_center" style="position:absolute;top:20%;left:10%;right:10%;width:80%">
		<div style="width:25%;float:left;border: 1px solid #E0E0E0;">
		            个人资料:<br>
			<img src="images/touxiang/<s:property value="#session.user.headImage"/>" align="middle"/>  <br>
			<font color="#666666">用户名：<s:property value="#session.user.username" /></font>   <br>
			<font color="#666666">性别：<s:property value="#session.user.sex" /></font>  <br>
			<font color="#666666">签名：<s:property value="#session.user.signature" /></font>  <br>
			<font color="#666666">邮箱：<s:property value="#session.user.email" /></font>  <br>
		</div>
		<div style="width:70%;float:right">
			<div style="border: 1px solid #E0E0E0;">
		 	   <a href="topic_addTopicRedirect.action">发布新帖</a>
			</div>
		 	<div style="border: 1px solid #E0E0E0;">
		 	           发布帖子:
				<ol class="topics">
					<s:iterator value="#session.user.topics" var="topic">
						<li style="line-height:20px;height:20px;margin:0">
							<a href="topic_showTopic.action?topicId=<s:property value="#topic.topicId"/>" style="float:left;">
								<font color="#666666"><s:property value="#topic.title" /></font>
							</a>
						</li>			
					</s:iterator>
				</ol>
			</div>
			<div style="border: 1px solid #E0E0E0;">
			            回复帖子:
				<ol class="replys">
					<s:iterator value="#session.user.replys" var="reply">
						<li style="line-height:20px;height:20px;margin:0">
							<a href="topic_showTopic.action?topicId=<s:property value="#reply.topic.topicId"/>" style="float:left;">
								<font color="#666666"><s:property value="#reply.topic.title" /></font> 			
							</a>	
							<font color="#666666">:"<s:property value="#reply.content" />"</font>  <br>
						</li>			
					</s:iterator>
				</ol>
			</div>
		</div>
		
	</div>
	
	 
	 <div id="foot" style="position:absolute;top:90%;left:10%;right:10%;width:80%">
		 <jsp:include page="/WEB-INF/content/foot.jsp"/>
	 </div>
	
	</body>
</html>