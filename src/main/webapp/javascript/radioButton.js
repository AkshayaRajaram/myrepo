/**
 * 
 */


       window.onload = function() {

    	  	 $("input.plan").prop("disabled", true);

              

              // next, attach the click event handler to the radio buttons

              var radios = document.forms[0].elements["radiogrp"];

              for (var i = [ 0 ]; i < radios.length; i++)

                     radios[i].onclick = radioClicked;

       }

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
