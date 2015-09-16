<%@ page language="java" pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
	<head>
		<title>用户注册</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
	</head>
	<body style="margin-top: 0px; margin-left: 173px; background-color: #FFF;">
		<form id="login" action="user_login.action" method="post">
				<table cellpadding="0px" cellspacing="0px" align="center">
					<tr>
						<td width="450px" >
							<font size="2px" color="#8816511">用户名：</font>
							<input type="text" id="username" name="username" size="16"/>
						</td>
					</tr>
					<tr>
						<td width="450px">
							<font size="2px" color="#8816511">密码：</font>
							<input type="password" id="password" name="password" size="16"/>
						</td>

					</tr>
					<tr>
						<td width="450px">
							<input type="submit" value="确认提交"/>
								&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="刷新重置"/>
						</td>
					</tr>
				</table>
			</form>	
	</body>
</html>
