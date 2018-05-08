<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2p">
		<thead>
			<tr>
				<th>File Name</th>
				<th>Row Count</th>
				<th>Column Count</th>
				
			</tr> 
 
</thead>
		<tbody>
			<c:forEach items="${excelFiles}" var = "excelFiles">
			<tr>
				<td><c:out value = "${excelFiles.fileName}"/></td>
				<td><c:out value = "${excelFiles.rowcount}"/></td> 
				<td><c:out value = "${excelFiles.colCount}"/></td> 
			</tr>
			</c:forEach>
		</tbody>
	</table> 
<h2>${message}</h2>

</body>
</html>