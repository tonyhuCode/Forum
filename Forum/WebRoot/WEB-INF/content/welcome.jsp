<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>论坛世界</title>
	</head>
	
	<body>
	
	<div id="head" style="position:absolute;top:0px;left:10%;right:10%;width:80%;height:10%">
		<jsp:include page="/WEB-INF/content/head.jsp"/>
	</div>
	 

	<div id="forum_type" style="position:absolute;top:20%;left:10%;right:10%;width:80%">
			<s:iterator value="#session.forumTypeList" var="forum">
				<div style="width:40%">
					<div style="background:#E6FFCC;">
						<font size="4px" color="#F86400"><s:property value="#forum.typeName"/></font>
					</div>
					<div style="border: 1px solid #E0E0E0;">
						<ol class="service_intro">
							<s:iterator value="#forum.topics" var="topic">
								<li style="line-height:20px;height:20px;margin:0">
									<a href="topic_showTopic.action?topicId=<s:property value="#topic.topicId"/>" style="float:left;">
										<font color="#666666"><s:property value="#topic.title" /></font>
									</a>
									<a href="space-uid-72.html" style="float:right;">
										<font color="#999999"><s:property value="#topic.user.username"/></font>
									</a>
								</li>			
							</s:iterator>
						</ol>
					</div>
				</div>
			</s:iterator>
	</div>
	
	 
	 <div id="foot" style="position:absolute;top:90%;left:10%;right:10%;width:80%">
		 <jsp:include page="/WEB-INF/content/foot.jsp"/>
	 </div>
	
	</body>
</html>