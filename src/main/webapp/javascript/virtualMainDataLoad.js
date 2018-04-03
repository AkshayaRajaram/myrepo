/**
 * 
 */
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

       

       

       })