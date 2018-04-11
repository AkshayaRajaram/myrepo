
$(document).ready(function () {
	var status = model.isback;
	$("input.plan").prop("disabled", true);
    if(status === 'true') {
		var cType = model.cType;
		var pType = model.pType ;
		var u_id = model.u_id ;
		var u_list =model.u_list;
		var a_list =model.a_list;
		$("input[name=radiogrp][value='"+cType+"']").prop('checked', true);
		$("input[type=checkbox][value='"+pType+"']").prop('checked', true);
		$("input.plan").prop("disabled", true);
		$("input[type=checkbox][value='"+pType+"']").prop('disabled',false);
// to populate dropdown list
		$('#underwriters').find('option').remove(); 
		$('#underwriters').empty().append('<option selected="selected" value="0">Please select an underwriter</option>');
		$.each(JSON.parse(u_list), function (index, value) {
		$('#underwriters').append($("<option></option>").val(value.underWriterId).html(value.underWriterName)); });
		$('#underwriters').val(u_id).change();
// to populate table records
		$(".accTable").css({'display' : 'block'});
		$("#accountTable").find("tr:gt(0)").remove();
		$.each(JSON.parse(a_list), function (index, value) {
			$("#NamesGridView").after("<tr><td>"+ value.accountId+ "</td><td>"+ value.name+ "</td><td> <button id='but1' class='botaoadd'>initiate </button><a href='accountInfo.htm?id="+ value.accountId+ "'>fail</a> </td></tr>");});
    }
			
	$('.cov_Type').on('change', function() {
		$("input.plan").prop("disabled", true);
		$("input.plan").prop("checked", false);
		var cov_Type = $(this).val();
		$('#underwriters').find('option').remove(); 
		$('#underwriters').empty().append('<option selected="selected" value="0">Please select an underwriter</option>');
        $(".accTable").hide(); 
        var enabledProducts = cov_Type == "B" ? "B" : cov_Type == "S" ? "S" : cov_Type == "G" ? "G" : cov_Type == "P" ? "P":" ";
        $("input[type=checkbox][value='"+enabledProducts+"1"+"']").prop('disabled', false);
        $("input[type=checkbox][value='"+enabledProducts+"2"+"']").prop('disabled', false);
               
	});
	
    $('.plan').on('change', function() {
        $('.plan').not(this).prop('checked', false);
        $(".accTable").hide();
        var coverageType = $("input[name='radiogrp']:checked").val();
        var productType = $(this).val();
        $.ajax({
             url:"getUnderWriter.htm",
             dataType: 'json',
             data:{productType:productType , coverageType:coverageType },
             context: this, 
             success: function (data) {
                  json: data 
                  $('#underwriters').find('option').remove(); 
                  $('#underwriters').empty().append('<option selected="selected" value="0">Please select an underwriter</option>');
                  for (var i = 0; i < data.length; i++) {
                       $('#underwriters').append($("<option></option>").val(data[i].underWriterId).html(data[i].underWriterName)); 
                   }
               },
              error: function (request) {
                  console.log(request.responseText);
                  window.location.replace("error.jsp");
                  $(".return-json").html("Some error!");
               }
          }); 
     });
   
    $('.uwList').on('change', function() {
         var id = $(this).val();
         $.ajax({
              url:"getAccountList.htm",
              dataType: 'json',
              data:{id:id },
              context: this, 
              success: function (data) {
                   json: data 
                   if (id==0)  {
                   		$(".accTable").hide();   
                   }
                   else        {
                   		$(".accTable").css({'display':'block'}); 
                        $("#accountTable").find("tr:gt(0)").remove();
                        for (var i = 0; i < data.length; i++) {
                            $("#NamesGridView").after("<tr><td>" + data[i].accountId + "</td><td>" + data[i].name +"</td><td> <button id='but1' class='botaoadd'>initiate </button><a href='accountInfo.htm?id="+data[i].accountId+"'>fail</a> </td></tr>");
                        }
                  }
              },
              error: function (request) {
                    window.location.replace("error.jsp");
                    $(".return-json").html("Some error!");
               }
           }); 
       });

});
