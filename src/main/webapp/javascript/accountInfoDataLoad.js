/**
 * 
 */
  function showAlert() {
        alert("Submitted Successfully");
    }
$(document).ready(function() {
	$('.targetdiv').hide();
	$("a").click(function() {
		$('.targetdiv').hide();
		$("#div" + $(this).attr("target")).show();
	});

});