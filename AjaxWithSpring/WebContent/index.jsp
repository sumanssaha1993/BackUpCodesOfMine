<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX TEST</title>
<script src="//code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#btn1').click(function() {
		$.ajax({
			url : 'hi/hi.htm',
			method : 'GET',
			data : {
				userName : $('#txt1').val()
			},
			success : function(responseText) {
				$('#d2').text(responseText);
			}
		});
	});
});

</script>
</head>
<body>
<div id='d1'>
<input type='text' id='txt1'>
<br>
<button id='btn1'>Enter</button>
<br>
<strong>Ajax Response</strong>:
</div>
<div id='d2'></div>
</body>
</html>