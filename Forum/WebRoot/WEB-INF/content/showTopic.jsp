<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>${session.showTopic.title}</title>
	</head>

	<body style="margin-top: 0px; margin-left: 173px; background-color: #FFF;">

		<div id="head" style="position:absolute;top:0px;left:10%;right:10%;width:80%;height:10%">
			<jsp:include page="/WEB-INF/content/head.jsp"/>
		</div>
		
		<div id="show_topic" style="position:absolute;top:20%;left:10%;right:10%;width:80%" align="center">
			<table cellpadding="0" cellspacing="0">
			<tr>
			<td height="189px" width="1002px">
			<table cellpadding="0" cellspacing="5" border="1">
			
				<tr valign="top" bordercolor="">
					<td height="25" width="180px">
						查看：${session.showTopic.scanCount} | 回复：${session.showTopic.responseCount}
					</td>			
					<td width="400px">
						${session.showTopic.title}
					</td>
					<td width="300px">
						发表于：${session.showTopic.submitTime}
					</td>
				</tr>
				<tr>
					<td height="60" align="center">
						<img src="images/touxiang/${session.showTopic.user.headImage}">
					</td>
					<td valign="top" colspan="5" rowspan="3">
						${session.showTopic.content}
					</td>
				</tr>
				<tr>
					<td height="30" align="center">
						${session.showTopic.user.username}
					</td>
				</tr>
				<tr>
					<td height="59" align="center">
						${session.showTopic.user.signature}  
					</td>
				</tr>
				</table>
			</td>
			</tr>
				<s:if test="#session.showTopic.replys.size>0">
					<s:iterator value="#session.showTopic.replys" var="reply">
						<tr>
							<td height="189px" width="1002px">
								<table cellpadding="0" cellspacing="0" border="1">
									<tr valign="top" bordercolor="">
										<td height="25" width="180px"></td>			
										<td width="400px"></td>
										<td width="300px">
											发表于：${reply.submitTime}
										</td>
									</tr>
									<tr>
										<td height="60" align="center">
											<img src="images/touxiang/<s:property value="#reply.user.headImage"/>"/>
										</td>
										<td valign="top" colspan="4" rowspan="3">
											${reply.content}
										</td>
									</tr>
									<tr>
										<td height="30" align="center">
											${reply.user.username}
										</td>
									</tr>
									<tr>
										<td height="30" align="center">
											${reply.user.signature}
										</td>
									</tr>
								</table>	
							</td>							
						</tr>
					</s:iterator>
				</s:if>
				<tr>
				    <td align="center">
					<form action="topic_addReply.action?topicId=${session.showTopic.topicId }" method="post">
						<textarea id="content" name="replyContent" cols="50" rows="4"></textarea><br>
						<input type="submit" value="回复"/> 
					</form>
					</td>
				</tr>
				<tr>
					<td><jsp:include page="/WEB-INF/content/foot.jsp"/></td>
				</tr>
				
				
			</table>
		</div>
			
	</body>
</html>