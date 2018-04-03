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
<link rel="stylesheet" href="src/main/webapp/css/accountInfo.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/buttonDisable.js"></script>
<script type="text/javascript">
	function showAlert() {
		alert("Submitted Successfully");
	}
</script>
</head>
<body>
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
	</div>
	<div class="classtitle1">
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
	</div>
</body>
</html>


