/**
 * 
 */
$(document).one('ready', function(){
	   // your code
	var status = '${back}';
	var cType =  '${coverageType}';
	var pType = '${productType}';
	var u_id = '${underWriterId}';
  

 


		 $("input[name=radiogrp][value='"+cType+"']").prop('checked', true);
		$("input[type=checkbox][value='"+pType+"']").prop('checked', true);
		
		//${'.plan'}.prop('disabled',true);
		//$("input[type=checkbox][class="plan"]").prop('disabled',false);
		
		$("input.plan").prop("disabled", true);
		$("input[type=checkbox][value='"+pType+"']").prop('disabled',false);
		
	
		
	 /* $("input[value='op2']").attr("id");
	 $('input[type=radio][name=radiogrp]:checked').prop('id') */
	
		/* $.each(list, function( index, value ) {
			alert( index + ": " + value );
		}); */
		
		// to populate dropdown list
		
		var u_list = '${uList}';
		var a_list = '${aList}';
		 var ud=$('#item');

         ud.find('option').remove(); 

         ud.empty().append('<option selected="selected" value="0">Please select an underwriter</option>');

      

         for (var i = 0; i < u_list.length; i++) {

        

          var mydata = u_list[i];
        
     

          $('#item').append($("<option></option>").val(mydata.underWriter_Id).html(mydata.underWriter_Name)); 

         

         }
         $('#item').val(u_id).change();
      

        // to populate table records
        		var a_list = '${aList}';  
        $(".accTable").css({'display':'block'}); 

         

         $("#accountTable").find("tr:gt(0)").remove();

   

         

         for (var i = 0; i < a_list.length; i++) {

                var mydata = a_list[i];

                

                var bt= $('<input/>').attr({ type: 'button', name:'btn1', value:'am button'});

             $("#NamesGridView").after("<tr><td>" + mydata.account_Id + "</td><td>" + mydata.name +"</td><td> <button id='but1' class='botaoadd'>initiate </button><a href='accountInfo.htm?id="+mydata.account_Id+"'>fail</a> </td></tr>");

         }

    	 
         

	  
	});