<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
	<script type="text/javascript" src = "javascript/excelfilevalidation.js"></script>
		<script type="text/javascript" src = "javascript/pdffilevalidation.js"></script>
		<script type="text/javascript" src ="javascript/buttonDisableOnLoad.js"></script>
		<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	 <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css"/>
 <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>


<c:if test="${message == 'successUpload'}">
		<script>
			alert("Excel File Saved Successfully");
		</script>
	</c:if>
	<c:if test="${message == 'successConversion'}">
		<script>
			alert("Excel File Converted to CSV Successfully");
		</script>
	</c:if>
	<c:if test="${message == 'deletedSuccessfully'}">
		<script>
			alert("Excel File deleted Successfully");
		</script>
	</c:if>
	<c:if test="${message == 'CannotDeleteExcel'}">
		<script>
			alert("Selected Excel file cannot be deleted as it has CSV dependency");
		</script>
	</c:if>
	
	
<script>
       $(document).ready(function(){
    	 
    
    	   document.getElementById("1").checked = true;
    	  
    	   alert("alert")
    	   $('.document').hide();
    	   $.ajax({
     		  url:"listexcel.htm",
     		  method: "POST",
     		  dataType :"json",
     		  
     		  
     		  success:function(data){
     			  json:data
     			 
     	  $("#excelTable").dataTable({
     		  destroy: true,
     		  data: data,
     		  columns :[
     			  {'data' : 'fileName'},
     			  {'data': 'rowcount'},
     			  {'data': 'colCount'},
     			  {'render': function(data, type, row ,meta){
     				 return  '<a href="downloadExcel.htm?id='+row.id+'">Download</a>';}
     			  },
     			  {'render': function(data, type, row ,meta){
     	   				 return  '<a href="deleteExcel.htm?id='+row.id+'">Delete</a>';}
     	   			  }
     			 
     			  
     		  ]
     	  });
     		  }
     	  
     	  });
    	   $("#excelform").on('submit',function(event){
    		   event.preventDefault(); //prevent default action 
    		    var post_url = $(this).attr("action"); //get form action url
    		    var request_method = $(this).attr("method"); //get form GET/POST method
    		    var form_data = new FormData($(this)[0]); //Creates new FormData obj
    		
    		    $.ajax({
    		        url : post_url,
    		        type: request_method,
    		        data : form_data,
    		        dataType :"json",
    		        contentType: false,
    		        cache: false,
    		        processData:false,  
            success: function (data) {
            	json: data
            
       	 $("#excelTable").dataTable({
   		  destroy: true,
   		  data: data,
   		  columns :[
 			  {'data' : 'fileName'},
 			  {'data': 'rowcount'},
 			  {'data': 'colCount'},
 			  {'render': function(data, type, row ,meta){
 				 return  '<a href="downloadExcel.htm?id='+row.id+'">Download</a>';}
 			  },
 			  {'render': function(data, type, row ,meta){
 	   				 return  '<a href="deleteExcel.htm?id='+row.id+'">Delete</a>';}
 	   			  }
 			 
 			  
 		  ]
   	  });
       	 
            }
       	 });
    	   })
    	
    	 
    	   $('.acc').click(function() {
               $('.document').hide();
               $(".account").show();
               document.getElementById("2").checked = false;
               
                
        }); 	   
    	   $(".doc").click(function() {
               $(".account").hide();
                $(".document").show();
                document.getElementById("1").checked = false;
               /*  $('#doctable').DataTable( {
                	  "ajax": "data.json"
                	} );
                     */
                                             
    	  $.ajax({
    		  url:"listdoc.htm",
    		  method: "POST",
    		  dataType :"json",
    		  
    		  
    		  success:function(data){
    			  json:data
    	  $("#doctable").dataTable({
    		  destroy: true,
    		  data: data,
    		  columns :[
    			  {'data' : 'fileName'},
    			  {'data': 'fileType'},
    			  {'data': 'id'},
    			  {'render': function(data, type, row ,meta){
    				 return  '<a href="downloadDocument.htm?id='+row.id+'">Download</a>';}
    			  },
    			  {'render': function(data, type, row ,meta){
    	   				 return  '<a href="deleteDoc.htm?id='+row.id+'">Delete</a>';}
    	   			  }
    			 
    			  
    		  ]
    	  });
    		  }
    	  
    	  });
                }); 
    	   
    	   $("#myform").on('submit',function(event){
    		   event.preventDefault(); //prevent default action 
    		    var post_url = $(this).attr("action"); //get form action url
    		    var request_method = $(this).attr("method"); //get form GET/POST method
    		    var form_data = new FormData($(this)[0]); //Creates new FormData obj
    		
    		    $.ajax({
    		        url : post_url,
    		        type: request_method,
    		        data : form_data,
    		        dataType :"json",
    		        contentType: false,
    		        cache: false,
    		        processData:false,  
            success: function (data) {
            	json: data
            
       	 $("#doctable").dataTable({
   		  destroy: true,
   		  data: data,
   		  columns :[
   			  {'data' : 'fileName'},
   			  {'data': 'fileType'},
   			  {'data': 'id'},
   			  {'render': function(data, type, row ,meta){
   				 return  '<a href="downloadDocument.htm?id='+row.id+'">Download</a>';}
   			  },
   			 {'render': function(data, type, row ,meta){
   				 return  '<a href="deleteDoc.htm?id='+row.id+'">Delete</a>';}
   			  }
   			
   		  ]
   	  });
       	 
            }
       	 });
    	   });
    	 
       });
                
                

       </script>               
	
    	
     
    	


</head>


<body>

<h1>Prepare Training Data</h1><br>


<div>
        <label><input type="radio" name="account" id="1" class ="acc"value="acc" /> Account Level Information</label>
        <label><input type="radio" name="document" id ="2"class="doc" value="doc"/>Document Level Information</label>
       
        
   </div>
        
      <div class="account"> 
        <form action="uploadExcel.htm" method="post" enctype="multipart/form-data" id ="excelform">
		<label>Select Excel File :</label>
	
		<input id = "file" name="file" type="file"> <br> <br> 
	
		<input id = "submit" type="submit" value="Upload File" disabled>
	
		
	</form>
	<br>
	<br>
	<table class="display jqueryDataTable" id="excelTable">
		<thead>
			<tr>
			<!-- 	<th>#</th> -->
				<th>File Name</th>
				<th>Data Count</th>
				<th>Attribute Count</th>
				<th>Download</th>
		
				<th>Delete</th>
			</tr>
		</thead>
		<%-- <tbody >
			<c:forEach items="${excelFiles}" var = "excelFiles" varStatus = "loop">
			<tr>
				<td scope="row"><c:out value = "${loop.count }"></c:out></td>
				<td><c:out value = "${excelFiles.fileName}"/></td>
				<td><c:out value = "${excelFiles.rowcount}"/></td> 
				<td><c:out value = "${excelFiles.colCount}"/></td> 
				<td>
					<a href="downloadExcel.htm?id=${excelFiles.id}">
						Download
  					</a>
				</td> 
					
				<td>
					<a href="deleteExcel.htm?id=${excelFiles.id}">
					<img src="images/delete.png" alt="delete" style="width:30px;height:28px;border:0;"></a>
				</td>

			</tr>
			</c:forEach>
		</tbody> --%>
	</table>
</div>
 <div class="document" id="member">
<form id ="myform" action="uploadPdf.htm"  method="post" enctype="multipart/form-data" >
		<label>Select Document File :</label>
	
		<input id = "file1" name="file" type="file"> <br> <br> 
	
		<input id = "btn_submit" type="submit" value="Upload File" disabled>
	
	
	</form>
		<br>
	<br>
 
	<table id="doctable" class="display dataTable">
	<thead>
			<tr id ="pdfinfo">
				
				<th>File Name</th>
				<th>File Type</th>
				<th>ID</th>
				<th>Download</th>
				<th>Delete</th>
				
			
			</tr>
		</thead>
	<!-- <tbody id ="docinfo">
			<tr id="docinfo"></tr>
			</tbody> -->
				</table>
</div> 
	
</body>
</html>