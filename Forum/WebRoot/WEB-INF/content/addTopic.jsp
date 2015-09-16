<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="true">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>发布新帖</title>
	</head>
	<body style="margin-top: 0px; margin-left: 173px; background-color: #FFF;">
	
		<div id="head" style="position:absolute;top:0px;left:10%;right:10%;width:80%;height:10%">
			<jsp:include page="/WEB-INF/content/head.jsp"/>
	    </div>
	 
		
		<div style="margin-top: 3px;">
			<div style="position: absolute; top: 194px; background-image: url('images/zc_02.gif'); width: 554px; height: 484px; display: inline;">
				<form id="addTopic" action="topic_addTopic.action" method="post">
					<br />
					<table cellspacing="6">
						<tr>
							<td>
								标&nbsp;题：
							</td>
							<td>
								<input type="text" id="title" name="title"/>
							</td>
							
						</tr>
						<tr>
							<td>
								版&nbsp;块：
							</td>
							<td>
								<s:iterator value="#session.forumTypeList" var="forumType">
									<input type="radio" name="forumTypeName" value="${ forumType.typeName}" checked="checked"/>${forumType.typeName}&nbsp;&nbsp;&nbsp;		
								</s:iterator>
							</td>
						</tr>

						<tr>
							<td>
								内&nbsp;&nbsp;容：
							</td>
							<td colspan="2">
								<textarea rows="6" cols="32" name="content"></textarea>
							</td>
						</tr>
						<tr>
							<td height="10px"></td>
						</tr> 
						<tr>
							<td align="center" colspan="3">
								<input type="submit" value="发布"/>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="重置"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>		

	</body>
</html>