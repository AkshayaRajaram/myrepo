<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Information</title>
<style type="text/css">
label+label {
	margin: 0 10px 0 10px;
}

div.classtitle {
	border: 1px solid darkblue;
	border-radius: 8px;
	width: 134.5%;
}

div.classtitle1 {
	border: 1px solid darkblue;
	border-radius: 8px;
	width: 134.5%;
}

table, td, th {
	text-align: left;
}

table {
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	spacing
}

div.class1 {
	overflow: auto;
	width: 300px;
	height: 110px;
}
</style>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="src/main/webapp/css/accountInfo.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/buttonDisable.js"></script>
<script type="text/javascript">
	function showAlert() {
		alert("Submitted Successfully");
	}
</script>

<script>
$(document).ready(function () {
	

	$("a[rel^='week']").on('click', function(){
		alert("Submitted Successfully");
		  $("div.week").hide();
		  var targetDiv = $(this).attr('rel');
		  $("#"+targetDiv).show();
		});
	
});

</script>

</head>
<body>
<!--
	<div class="classtitle">
		<c:forEach items="${accountList}" var="account" varStatus="loop">
			<center>
				<h2>Account Information</h2>
			</center>
				Account ID:<c:out value="${account.account_Id }"></c:out>
			<br>	Account Name:<c:out value="${account.name}" />
			<br>	Account Number:<c:out value="${account.account_Number}" />
			<br>
		</c:forEach>
	</div>
	<div class="classtitle">
			<center>
				<h2>Account Setup</h2>
			</center>
		<br>
		<br>
		<br><br>		
	</div> -->
<!--  	<div class="classtitle1">
		<form action="accountSave.htm" method="post">
			<table>
				<tr>
					<td><label>Incorrect </label>
						<div class="class1">
							<br>
							<c:forEach var="doc" items="${DocList}">
								<c:set var="flag" value="false" />
								<c:forEach var="map" items="${doc.status}">
									<c:if test="${map.key == 'INCORRECT'}">
										<c:if test="${map.value == true}">
											<input type="checkbox" name="incorrect" value="${map.key}" 
												checked="checked" >${doc.docname}&nbsp;<c:set
												var="flag" value="true" />
											<br>
										</c:if>
									</c:if>
								</c:forEach>
								<c:if test="${flag == false}">
									<input type="checkbox" name="incorrect" value="${map.key}" disabled="disabled">${doc.docname}&nbsp;<br>
								</c:if>
							</c:forEach>
						</div></td>
					<td><label>Missing </label>
						<div class="class1">
							<br>
							<c:forEach var="doc" items="${DocList}">
								<c:set var="flag" value="false" />
								<c:forEach var="map" items="${doc.status}">
									<c:if test="${map.key == 'MISSING'}">
										<c:if test="${map.value == true}">
											<input type="checkbox" name="missing" value="${map.key}"
												checked="checked">${doc.docname}&nbsp; <c:set
												var="flag" value="true" />
											<br>
										</c:if>
									</c:if>
								</c:forEach>
								<c:if test="${flag == false}">
									<input type="checkbox" name="missing" value="${map.key}" disabled="disabled">${doc.docname}&nbsp;<br>
								</c:if>
							</c:forEach>
						</div></td>
					<td><label>Incomplete </label>
						<div class="class1">
							<br>
							<c:forEach var="doc" items="${DocList}">
								<c:set var="flag" value="false" />
								<c:forEach var="map" items="${doc.status}">
									<c:if test="${map.key == 'INCOMPLETE'}">
										<c:if test="${map.value == true}">
											<input type="checkbox" name="incomplete" value="${map.key}"
												checked="checked">${doc.docname}&nbsp; <c:set
												var="flag" value="true" />
											<br>
										</c:if>
									</c:if>
								</c:forEach>
								<c:if test="${flag == false}">
									<input type="checkbox" name="incomplete" value="${map.key}" disabled="disabled">${doc.docname}&nbsp;<br>
								</c:if>
							</c:forEach>
						</div></td>
				</tr>
			
			
			
			
			
			
			
			
			
			
				<br>
				<br>
				<tr>
				<td><label>Comments: :</label></td>
					<td colspan="2"><textarea rows="4" cols="50"></textarea><br>
						<br></td>
				</tr>
				<tr>
					<td><label>Reviewer :</label></td>
					<td><select><c:forEach var="line"
								items="${reviewerList}">
								<option><c:out value="${line}" /></option>
							</c:forEach></select></td>
				<tr>
					<td></td>
					<td><input id="submit" type="button" value="Submit"
						onclick="showAlert()"></td>
						
						<td><button type="submit" formaction="virtualMainBack.htm">Back</button></td>
						</tr>
						
			</table>
		</form>
	</div> -->
	
	
	
	<div class="jumbotron" style="background-color:#E5E8E8">
  <h3 class="display-2">Account Information</h3>

   <c:forEach items="${accountList}" var="account" varStatus="loop">
      
      		Account ID:<c:out value="${account.account_Id }"></c:out>
					<br>	Account Name:<c:out value="${account.name}" />
					<br>	Account Number:<c:out value="${account.account_Number}" />
					<br>	Account Division:<c:out value="${account.division}" />
				</c:forEach>
				

</div>
	
	<%-- <div class="container">
		<div class="panel panel-defualt">
			<div class="panel-heading">Account Information</div>
			<div class="panel-body">
				<c:forEach items="${accountList}" var="account" varStatus="loop">
      
      		Account ID:<c:out value="${account.account_Id }"></c:out>
					<br>	Account Name:<c:out value="${account.name}" />
					<br>	Account Number:<c:out value="${account.account_Number}" />
					<br>	Account Division:<c:out value="${account.division}" />
				</c:forEach>
			</div>
		</div>

	</div> --%>









	<div class="container col-md-12 ">
	<div class="row">
	<div id="proposalAccordion" class="panle-group">
		<div class="panel panel-default col-md-8">

			<div class="panel-heading">Document Info</div>
			<div class="panel-body">
				<table class="table table-condensed table-striped">

					<thead>

						<tr>
							<th>Document Name</th>
							<th>Status</th>
						</tr>

					</thead>

					<tbody id="myTable">
						<c:forEach var="doc" items="${DocList}"  varStatus="status" step="1" begin="0">
						<tr>
							 <td class="col-md-3"><a data-toggle="collapse" data-parent="#proposalAccordion"
								href="#col${status.index}" rel="col${status.index}">${doc.docname}</a>
								
						</td>		
						<!--  <td class="col-md-3"><select class="selectpicker" >
								<option value="Select">Select</option>
									<option value="Missing">Missing</option>
									<option value="Incorrect">Incorrect</option>
									<option value="Impossible">Impossible</option>
							</select>
							 -->
    <td class="col-md-1">  <select class="form-control" id="sel1">
      <option value="Select">Select</option>
									<option value="Missing">Missing</option>
									<option value="Incorrect">Incorrect</option>
									<option value="Impossible">Impossible</option>
      </select>
							
							
							</td>

</tr>
	
</c:forEach>



					</tbody>
				</table>



			</div>
		</div>




<!-- Div for error -->

		<div class="panel panel-default col-md-4">
			<div class="panel-heading">Error</div>

			<div class="panel-body">


		<c:forEach var="cnt" varStatus="status" items="${DocList}" step="1" begin="0">
		<div class="week">
  <div id="col${status.index}" class="panel-collapse collapse "> 
  <div class="panel-body">
			The Document ${cnt.docname}	contains errors in it.<p class="bg-danger">Status is ${cnt.sts}</p>
					</div>
   
  </div></div>
  
  </c:forEach>
	</div>
</div>

<!-- End Div for error -->


</div>

</div>
</div>

<div class="container col-md-8">
<form>
    <div class="form-group">
    <label for="Comments">Comments</label>
    <textarea class="form-control" id="Comments" rows="3" placeholder="Enter the Comments here..."></textarea>
  </div>
    
<%--     
   <label> Reviewer :</label>
				<select class="selectpicker"><c:forEach var="line"
								items="${reviewerList}">
								<option><c:out value="${line}" /></option>
							</c:forEach></select>
							 --%>
				<div class="form-group">
  <label class="col-md-2" for="sel1">Reviewer</label>	
  <div class="col-md-3">		
		 <select class="form-control" id="sel1">
      <c:forEach var="line1"
								items="${reviewerList}">
								<option><c:out value="${line1}" /></option>
							</c:forEach>
      </select>
				</div>
		</div>					
				
    
    <br />
         <br />
    <button type="button" class="btn btn-basic" value="submit" onclcik="showAlert()">Submit</button>
  
    
    <button type="submit"  class="btn btn-default"  formaction="virtualMainBack.htm">Back</button>
					
    
  </form>






</div>
<!-- End Div for container for document -->




	<%-- col${status.index % 3 + 1}
				<tr>
				<label>Comments: :</label></td>
					<td colspan="2"><textarea rows="4" cols="50"></textarea><br>
						<br></td>
				</tr>
				<tr>
					<td><label>Reviewer :</label></td>
					<td><select><c:forEach var="line"
								items="${reviewerList}">
								<option><c:out value="${line}" /></option>
							</c:forEach></select></td>
				<tr>
					<td></td>
					<td><input id="submit" type="button" value="Submit"
						onclick="showAlert()"></td>
						
						<td><button type="submit" formaction="virtualMainBack.htm">Back</button></td>
						</tr>
		 --%>


	
	
	
	
</body>
</html>


