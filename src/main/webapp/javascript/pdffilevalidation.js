$(document).ready(function(){
    $("#file1").change(function(){
        var ext = $('#file1').val().split('.').pop().toLowerCase();
     	if($.inArray(ext, ['pdf','docx']) == -1) {     		
    		alert('Invalid File.. Please upload Excel File.');
    		$('#file1').val('');
            }
    });
 
}); 