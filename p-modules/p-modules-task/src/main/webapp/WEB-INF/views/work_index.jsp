<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<link  href="..css/bs/bootstrap.css" rel="stylesheet" type="text/css" >
<link  href="..css/common/footer.css" rel="stylesheet" type="text/css" >
<script type="text/javascript"></script>
<script src="../js/jquery/jquery-3.2.1.min.js"></script>
<script src="../js/bs/bootstrap.js"></script>
<script>

$(document).ready(function() { 
	alert(1);
	var a = $("#nav3").hasClass("active");
	console.log(a);
	alert(a);
};
</script>
<%@include file="../common/header.jsp"%>
<%@include file="../common/footer.jsp"%>

</head>
</html>