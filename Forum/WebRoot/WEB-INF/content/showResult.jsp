<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>显示搜索结果</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/main.css"> 
	<!-- 下方采用的class，可以在上述css中定义格式 -->
</head>
<body>

<div>
	<jsp:include page="/WEB-INF/content/head.jsp"/>	
</div>

<div style="padding: 10px 30px; font-size: 12px; font-family:'宋体'">
	共有<font color="red">${fn:length(resultList) }</font>个结果
</div>

<%--显示搜索结果--%>
<c:forEach items="${resultList}" var="common" varStatus="status">
    <table class="postList searchArticleResultList" cellspacing="0">
        <tr class="title">
            <td width="20">${status.index + 1}</td>
            <td><a href="topic_showTopic.action?topicId=${common.id }">${common.title } </a>
            </td>
        </tr>
        <tr class="content">
            <td/>
            <td>${common.content}</td>
        </tr>
        <tr class="info">
            <td/>
            <td>${common.submitTime}</td>
        </tr>
    </table>
</c:forEach>

</body>
</html>
