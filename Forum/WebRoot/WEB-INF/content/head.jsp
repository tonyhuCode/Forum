
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<script language="javascript" type="text/javascript">
	function getTime() {
		document.getElementById("getTime").innerHTML = new Date()
				.toLocaleString();
		setTimeout("getTime()", 1000);
	}
</script>
	<table width="955" border="0" align="center">
	    
	    <tr>
		    <td width="752" height="35" align="center">
		    
		        <span id="getTime"></span>
				 <script language="javascript" type="text/javascript">
					getTime();
				</script>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		        ${sessionScope.user.username } 您好！
		        <s:if test="#session.user == null">
						<a href="user_loginRedirect.action">[请登录]</a></s:if>
				<s:else>
				        <a href="user_logout.action">[注销]</a></s:else>
						
				<a href="user_registerRedirect.action">[注册]</a>
			</td>
			<td>
				<form action="search_query.action" method="post">
				    <table>
				    	<tr>
				    		<td><input type="text" name="queryString"></td>
				    		<td><input type="submit" value="搜索"/></td>
				    	</tr>
				    </table>
			    	
					
				</form>
			</td>
	    </tr>
	    <tr>
		    <td width="752" height="35" align="center">
		    	<a href="index.action"><font size="6" color="#83C9BC">首页</font></a>
		    	<font size="15" color="CABCB7">|</font>	
		    	<a href="user_personalCenter.action"><font size="6" color="#83C9BC">个人中心</font></a>
		 	</td>
		</tr>   
	</table>