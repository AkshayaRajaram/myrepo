 $(document).ready(function(){
	 $('#file').change(function(){
		 var ext = $('#file').val().split('.').pop().toLowerCase();
		 if($.inArray(ext, ['xls','xlsx']) == -1) {
		     alert('invalid file.... please upload Excel File');
		     $('#file').val('');
		 }
		 
	 });
	 $('#file1').change(function(){
		 var ext = $('#file1').val().split('.').pop().toLowerCase();
		 if($.inArray(ext, ['pdf','docx','xls','xlsx']) == -1) {
		     alert('invalid file.... please upload Excel File');
		     $('#file1').val('');
		 }
		 
	 });
	 
 });