<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="javascript/excelfilevalidation.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>File Upload</h1><br>
	<form action="uploadExcel.htm" method="post" enctype="multipart/form-data">
		<label>Select Excel File :</label>
	
		<input id = "file" name="file" type="file" required> <br> <br> 
	
		<input id = "submit" type="submit" value="Upload File">
		
	</form> 

</body>
</html>