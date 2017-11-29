<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考勤</title>
<%@include file="../common/include.jsp"%>
<script type="text/javascript">
$(document).ready(function() { 	
	var a = $("#nav3").addClass("active");	
});
</script>
<%@include file="../common/header.jsp"%>


<div class="container">
	<h2>考勤基本情况</h2>            
	<table class="table">
		<thead>
			<tr>
				<th>日期</th>
				<th>上班情况</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>Anna</td>
			</tr>
			<tr>
				<td>2</td>
				<td>Debbie</td>
			</tr>
			<tr>
				<td>3</td>
				<td>John</td>
			</tr>
		</tbody>
	</table>
</div>




















<%@include file="../common/footer.jsp"%> 
</html>