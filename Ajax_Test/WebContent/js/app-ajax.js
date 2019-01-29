$(document).ready(function() {
	$('#btn1').click(function() {
		$.ajax({
			url : 'GetUserServlet',
			contentType : "application/json; charset=utf-8",
			data : {
				ID : $('#txt1').val(),
				NAME : $('#txt2').val(),
				SALARY : $('#txt3').val()
			},
			success : function(odata) {
				var arr = {};
				arr = odata;
			},
			error : function() {
				alert("error")
			}
		});
	});
});

