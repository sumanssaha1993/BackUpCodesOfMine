$(document).ready(function() {
	$('#txt1').blur(function() {
		$.ajax({
			url : 'GetUserServlet',
			data : {
				userName : $('#txt1').val()
			},
			success : function(responseText) {
				$('#d2').text(responseText);
			}
		});
	});
});