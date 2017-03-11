<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>RSA</title>

<script type="text/javascript" src="http://localhost/js/jquery-3.1.1.min.js"></script>

<script type="text/javascript" src="app/rsa-min.js"></script>
<script type="text/javascript" src="lib/js/jsencrypt.min.js"></script>

</head>
<body>
	<input  id="w" name="w"  />
	<input  id='i' value="加密" type="button" />
	<input  id='d' value="解密" type="button" /><br>
	密文：
	<div id="en">等待加密</div>
	明文：
	<div id="de">等待解密</div>
</body>
</html>