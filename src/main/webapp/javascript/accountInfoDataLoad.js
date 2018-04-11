/**
 * Error Message display
 */

$(document).ready(function() {
	$('.targetdiv').hide();
	$("a").click(function() {
		$('.targetdiv').hide();
		$("#div" + $(this).attr("target")).show();
	});

});