/*$(document).ready(function() {*/
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
/*});*/