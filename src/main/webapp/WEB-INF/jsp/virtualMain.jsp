
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/coverageColor.css" />
<link rel="stylesheet" type="text/css" href="css/virtualMainAlign.css" />
<script type="text/javascript" src="javascript/virtualMainDataLoad.js"></script>
<title>Virtual Main</title>

<script type="text/javascript">
	  var model = [];
	model.isback = '${isback}';
	model.cType = '${coverageType}';
	model.pType = '${productType}';
	model.u_id = '${underWriterId}';
	model.u_list = '${uList}';
	model.a_list = '${aList}';
</script>
</head>
<body>
	<div class="classtitle">
		<h3 align="center">Virtual Main</h3>
		<a href = "sample.htm">Admin</a>
	</div>
	<div class="classtitle">
		<form id="picker">
			<table align="center"
				style="border-collapse: separate; border-spacing: 40px;">
				<tr>
					<th><label>Coverage Type:</label></th>
					<th><input type="radio" class="cov_Type" name="radiogrp"
						id="B" value="B">Bronze</th>
					<th><input type="radio" class="cov_Type" name="radiogrp"
						id="S" value="S"> Silver</th>
					<th><input type="radio" class="cov_Type" name="radiogrp"
						id="G" value="G"> Gold</th>
					<th><input type="radio" class="cov_Type" name="radiogrp"
						id="P" value="P">Platinum</th>
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
							<input type="checkbox" class="plan" id="S1" value="S1">S1<br>
							<input type="checkbox" class="plan" id="S2" value="S2">S2
							<br>
						</div>
					</td>
					<td>
						<div>
							<input type="checkbox" class="plan" id="G1" value="G1">G1<br>
							<input type="checkbox" class="plan" id="G2" value="G2">G2<br>
						</div>
					</td>
					<td>
						<div>
							<input type="checkbox" class="plan" id="P1" value="P1">P1<br>
							<input type="checkbox" class="plan" id="P2" value="P2">P2<br>
						</div>
					</td>
				</tr>
			</table>
		</form>
		<div align="center">
		<label>UnderWriter List:</label>
			<select class="uwList" id="underwriters">
				<option>Please select an underwriter</option>
			</select>
		</div>
		<br> <br>
		<div align="center" class="accTable" style="display: none">
			<table id="accountTable">
				<tr id="NamesGridView"></tr>
			</table>
		</div>
		<br>
	</div>
</body>
</html>


