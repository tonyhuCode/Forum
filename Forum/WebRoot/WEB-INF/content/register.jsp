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
		<script type="text/javascript">
			function submit1() {
				if ($('userId').value.length == 0) {
					alert("请填写用户名!");
					return false;
				}
				if ($('pass').value.length == 0) {
					alert("请填写密码!");
					return false;
				}
				if ($('pass1').value.length == 0) {
					alert("请确认密码!");
					return false;
				}
				if ($('pass').value != $('pass1').value) {
					alert("两次密码输入不相符！");
					return false;
				}
				if ($('email').value.length == 0) {
					alert("请填写电子邮件!");
					return false;
				}
				if (!checkemail($('email').value)) {
					alert("您输入Email格式不正确!");
					registerForm.e_mail.focus();
					return false;
				}
				return true;
			}
			function checkemail(e_mail) {
				var str = e_mail;
				var Expression = /\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
				var objExp = new RegExp(Expression);
				if (objExp.test(str) == true) {
					return true;
				} else {
					return false;
				}
			}
		</script>
		<script type="text/javascript">
			function showlogo(imgPath) {
				$('img').src = "images/touxiang/"+imgPath;
			}
			function $(id){
				return document.getElementById(id);
			}
		</script>
	</head>
	<body style="margin-top: 0px; margin-left: 173px; background-color: #FFF;">
		
		<div style="margin-top: 3px;">
			<div style="position: absolute; top: 194px; background-image: url('images/zc_02.gif'); width: 554px; height: 484px; display: inline;">
				<form id="registerform" action="user_register.action" method="post">
					<br />
					<table cellspacing="6">
						<tr>
							<td>
								用&nbsp;户&nbsp;名：
							</td>
							<td>
								<input type="text" id="userId" name="user.username"/>
							</td>
							<td rowspan="3">
								<img src="images/touxiang/1.gif" id="img"><br/>
								<select name="user.headImage" style="width: 65px" onchange="showlogo(this.value)">
									<%
										for (int i = 1; i <= 19; i++) {
									%>
									<option value='<%=i + ".gif"%>'>
										头像<%=i%></option>
									<%
										}
									%>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								密&nbsp;&nbsp;&nbsp;&nbsp;码：
							</td>
							<td>
								<input type="password" id="pass" name="user.password"/>
							</td>
						</tr>
						<tr>
							<td>
								确认密码：
							</td>
							<td>
								<input type="password" id="pass1"/>
							</td>
						</tr>
						<tr>
							<td>
								性&nbsp;&nbsp;&nbsp;&nbsp;别：
							</td>
							<td>
								<input type="radio" name="user.sex" value="男" checked="checked"/>男&nbsp;&nbsp;&nbsp;
								<input type="radio" name="user.sex" value="女"/>女
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;E_mail：
							</td>
							<td  colspan="2">
								<input type="text" id="email" name="user.email" size="40"/>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;签名档：
							</td>
							<td colspan="2">
								<textarea rows="6" cols="32" name="user.signature"></textarea>
							</td>
						</tr>
						<tr>
							<td height="10px"></td>
						</tr> 
						<tr>
							<td align="center" colspan="3">
								<input type="submit" value="确认提交" onclick="return submit1()"/>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="刷新重置"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<%@include file="foot.jsp"%>
	</body>
</html>
