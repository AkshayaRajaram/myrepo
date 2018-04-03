
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script type="text/javascript" src="javascript/radioButton.js"></script>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<title>Virtual Main</title>
 <!-- <style>

input[type="radio"] {
  /* remove standard background appearance */
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  /* create custom radiobutton appearance */
  display: inline-block;
  width: 25px;
  height: 25px;
  padding: 6px;
  /* background-color only for content */
  background-clip: content-box;
  border: 2px solid #bbbbbb;
  background-color: #e7e6e7;
  border-radius: 50%;
}

/* appearance for checked radiobutton */
input[id="op1"]:checked {
  background-color: #8B4513;
}
input[id="op2"]:checked {
  background-color: #BDB76B;
}
input[id="op3"]:checked {
  background-color: #FFD700;
}
input[id="op4"]:checked {
  background-color: #CD853F;
}


</style> -->
<link rel="stylesheet" href="css/coverageColor.css">
<style>
div.classtitle {
	border: 1px solid darkblue;
	border-radius: 8px;
	width: 134.5%;
} 
td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
}
</style>



 <!-- <script>

       /* window.onload = function() {

    	  	 $("input.plan").prop("disabled", true);

              

              // next, attach the click event handler to the radio buttons

              var radios = document.forms[0].elements["radiogrp"];

              for (var i = [ 0 ]; i < radios.length; i++)

                     radios[i].onclick = radioClicked;

       } */

       function radioClicked() {

 

              // find out which radio button was clicked and

              // disable/enable appropriate input elements

              switch (this.value) {

              case "op1":
            	  
            	 
                    
              	  var ud=$('#item');

                  ud.find('option').remove(); 

                  ud.empty().append('<option selected="selected" value="0">Please select an underwriter</option>');


                     $(".accTable").hide(); 
                     $("input.plan").prop("checked", false);
                     $("input.plan").prop("disabled", true);

                     document.getElementById("B1").disabled = false;

                     document.getElementById("B2").disabled = false;

                    
                   

                     break;

              case "op2":
            	  
            	  var ud=$('#item');

                  ud.find('option').remove(); 

                  ud.empty().append('<option selected="selected" value="0">Please select an underwriter</option>');


                     $(".accTable").hide(); 
                     $("input.plan").prop("checked", false);
                     $("input.plan").prop("disabled", true);
                   //  $("input.plan").prop("disabled", true);
                   
                 

                     document.getElementById("S1").disabled = false;

                     document.getElementById("S2").disabled = false;
                     
                     break;
                     

                  

                 

              case "op3":
            	  var ud=$('#item');

                  ud.find('option').remove(); 

                  ud.empty().append('<option selected="selected" value="0">Please select an underwriter</option>');


                     $(".accTable").hide(); 
                     $("input.plan").prop("checked", false);
                     $("input.plan").prop("disabled", true);

                   

                     document.getElementById("G1").disabled = false;

                     document.getElementById("G2").disabled = false;


                     break;
              case "op4":
            	  var ud=$('#item');

                  ud.find('option').remove(); 

                  ud.empty().append('<option selected="selected" value="0">Please select an underwriter</option>');


                  $(".accTable").hide(); 
                  $("input.plan").prop("checked", false);
                  $("input.plan").prop("disabled", true);
                

                  document.getElementById("P1").disabled = false;

                  document.getElementById("P2").disabled = false;

                  break;


              }

 

       }

</script>  -->

<script>
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
		
		var u_list = ${uList};
		var a_list = ${aList};
		 var ud=$('#item');

         ud.find('option').remove(); 

         ud.empty().append('<option selected="selected" value="0">Please select an underwriter</option>');

      

         for (var i = 0; i < u_list.length; i++) {

        

          var mydata = u_list[i];
        
     

          $('#item').append($("<option></option>").val(mydata.underWriter_Id).html(mydata.underWriter_Name)); 

         

         }
         $('#item').val(u_id).change();
      

        // to populate table records
        		var a_list = ${aList};  
        $(".accTable").css({'display':'block'}); 

         

         $("#accountTable").find("tr:gt(0)").remove();

   

         

         for (var i = 0; i < a_list.length; i++) {

                var mydata = a_list[i];

                

                var bt= $('<input/>').attr({ type: 'button', name:'btn1', value:'am button'});

             $("#NamesGridView").after("<tr><td>" + mydata.account_Id + "</td><td>" + mydata.name +"</td><td> <button id='but1' class='botaoadd'>initiate </button><a href='accountInfo.htm?id="+mydata.account_Id+"'>fail</a> </td></tr>");

         }

    	 
         

	  
	});
</script>

<script>

$(document).ready(function () {
	

		
	    
	    	
	    	
	 


       $('.plan').on('change', function() {

           $('.plan').not(this).prop('checked', false);

           $(".accTable").hide(); 

        
           var coverageType = $("input[name='radiogrp']:checked").val();
          
           var productType = $(this).val();

          // $("#dp").children().prop('disabled',true);

           

          $.ajax({

                     url:"getUnderWriter.htm",
                     
             

                     dataType: 'json',

                     data:{productType:productType , coverageType:coverageType

                     },

                     context: this, 

                      success: function (data) {

                           // $("#dp").children().prop('disabled',false);

                       json: data 

                        var ud=$('#item');

                      ud.find('option').remove(); 

                      ud.empty().append('<option selected="selected" value="0">Please select an underwriter</option>');

                   

                      for (var i = 0; i < data.length; i++) {

                     

                       var mydata = data[i];
                     
                   

                       $('#item').append($("<option></option>").val(mydata.underWriter_Id).html(mydata.underWriter_Name)); 

                      

                      }

                   

 

                       console.log(data);

                   },

                   error: function (request) {
           
                  
                  console.log(request.responseText);
                  window.location.replace("error.jsp?");

                       $(".return-json").html("Some error!");

                   }

               }); 

 

            

       });

       $('.uwList').on('change', function() {

                  var id = $(this).val();

                 

                  $.ajax({

                           url:"getAccountList.htm",

                           dataType: 'json',

                           data:{id:id

                           },

                           context: this, 

                            success: function (data) {

                                  json: data 

                               

                                   if (id==0)

                                  {

                                                $(".accTable").hide();

                                  }

                                  else

                                         {

                                  

                             

                            $(".accTable").css({'display':'block'}); 

                     

                           $("#accountTable").find("tr:gt(0)").remove();

                     

                           

                           for (var i = 0; i < data.length; i++) {

                                  var mydata = data[i];

                                  

                                  var bt= $('<input/>').attr({ type: 'button', name:'btn1', value:'am button'});

                               $("#NamesGridView").after("<tr><td>" + mydata.account_Id + "</td><td>" + mydata.name +"</td><td> <button id='but1' class='botaoadd'>initiate </button><a href='accountInfo.htm?id="+mydata.account_Id+"'>fail</a> </td></tr>");

                           }

                                         }

       

                              console.log(data);

                          },

                          error: function (request) {
                        	  window.location.replace("error.jsp");

                              $(".return-json").html("Some error!");

                          }

                      }); 

                 

              });

       

       

       });

 

 

</script>

</head>

<body>
<div class="classtitle">
	<h3 align="center">Virtual Main</h3>
</div>
	
<div class="classtitle">
	<form id="picker">

		<table align="center"
			style="border-collapse: separate; border-spacing: 40px;">
  
			<tr>
             
				<th><label>Coverage Type:</label></th>

				<th><input type="radio" name="radiogrp" id ="op1" value="op1">Bronze</th>

				<th><input type="radio" name="radiogrp" id="op2" value="op2">

					Silver</th>
 
				<th><input type="radio" name="radiogrp" id="op3" value="op3">

					Gold</th>
					<th><input type="radio" name="radiogrp" id ="op4" value="op4">Platinum</th>
				

			</tr>

			<tr>

				<th><label>Product Type:</label></th>

				<td>

					<div>

						<input type="checkbox" class="plan" id="B1" value="B1">B1<br>

						<input type="checkbox" class="plan" id="B2" value="B2">B2<br>

					</div>

				</td>



				<td>

					<div>

						<input type="checkbox" class="plan" id="S1" value="S1"> S1<br>

						<input type="checkbox" class="plan" id="S2" value="S2">S2
						<br>

					</div>

				</td>

				<td>

					<div>

						<input type="checkbox" class="plan" id="G1" value="G1">G1<br>

						<input type="checkbox" class="plan" id="G2" value="G2">G2
						<br>

					</div>

				</td>
				<td>

					<div>

						<input type="checkbox" class="plan" id="P1" value="P1">P1<br>

						<input type="checkbox" class="plan" id="P2" value="P2">P2
						<br>

					</div>

				</td>

			</tr>

		</table>

	</form>



	<div align="center">

		<select class="uwList" id="item">

			<option>Please select an underwriter</option>

		</select>

	</div>

	<br>



	<br>





	<div align="center" class="accTable" style="display: none">

		<table id="accountTable">



			<tr id="NamesGridView">

			</tr>

		</table>

	</div>
	<br>
	
	</div>
	
	<a href="account.jsp">link</a>

</body>

</html>


