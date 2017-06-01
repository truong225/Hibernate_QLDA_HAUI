$( function() {
		var dialog, form,
			
			txtName = $("#txtName"),
			txtInput = $("#txtInput"),
			txtOutput = $("#txtOutput"),
			txtTimeDK = $("#txtTimeDK"),
			i = 2;

		function addUser() {
		  var valid = true;
		  	$( "#datatable tbody" ).append( "<tr>" +
				 "<td>" + i + "</td>" +
              "<td>" + txtName.val() + "</td>" +
			  "<td>" + txtInput.val() + "</td>" +
			  "<td>" + txtOutput.val() + "</td>" +
			 "<td>" + txtTimeDK.val()+ "</td>" +
							"<td><a href="+"#"+">Đính kèm<a></td>"	+   
			"</tr>" );
			
			dialog.dialog( "close" );
			i++;
		  return valid;
		}

		dialog = $( "#dialog-form" ).dialog({
		  autoOpen: false,
		  height: 400,
		  width: 350,
		  modal: true,
		  buttons: {
			"Thêm tiến độ": addUser,
			Hủy: function() {
			  dialog.dialog( "close" );
			}
		  },
		  close: function() {
			form[ 0 ].reset();
		  }
		});

		form = dialog.find( "form" ).on( "submit", function( event ) {
		  event.preventDefault();
		  addUser();
		});

		$( "#create-user" ).button().on( "click", function() {
		  dialog.dialog( "open" );
		});
		$('#datepicker').datepicker({
			onSelect: function(dateText, inst) {
			  $("input[name='txtTimeDK']").val(dateText);
			}
		});
	  
} );