$(document).ready(function() {

		$.ajax({
			url : 'GetUserServlet',
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				var arr = {};
				arr = data;
				$( "#tags" ).autocomplete({
				      source: arr
				    });
			},
			error : function() {
				alert("error")
			}
		});

});

