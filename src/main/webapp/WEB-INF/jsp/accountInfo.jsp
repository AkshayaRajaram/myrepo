<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Information</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="javascript/accountInfoDataLoad.js"></script>
	<link rel="stylesheet" type="text/css" href="css/accountInfo.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="container-fluid">
				<div class="row">
					<div class="jumbotron jumbotron-fluid">
						<div class="row">
							<p class=" text-center text-info">ACCOUNT INFORMATION</p>
							<c:forEach items="${accountList}" var="account" varStatus="loop">
								<div class="col-lg-3">
									<table align="left">
										<tbody>
											<tr>
												<td class="tableaccount text-info "><Strong>Account
														Number</Strong></td>
												<td class="tableaccount1"><c:out
														value="${account.accountNumber}" /></td>
											</tr>
											<tr>
												<td class="tableaccount text-info"><Strong>Account
														Name</Strong></td>
												<td class="tableaccount1"><c:out
														value="${account.name}" /></td>
											</tr>

										</tbody>
									</table>
								</div>
								<div class="col-lg-3">
									<table align="center">
										<tbody>
											<tr>
												<td class="tableaccount text-info"><Strong>Account
														Division</Strong></td>
												<td class="tableaccount1"><c:out
														value="${account.division}" /></td>
											</tr>
											<tr>
												<td class="tableaccount text-info"><Strong>Created
														By</Strong></td>
												<td class="tableaccount1"><c:out
														value="${account.createdBy}" /></td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="col-lg-3">
									<table align="right">
										<tbody>
											<tr>
												<td class="tableaccount text-info"><Strong>Created
														Date</Strong></td>
												<td class="tableaccount1"><c:out
														value="${account.createdDate}" /></td>
											</tr>
											<tr>
												<td class="tableaccount text-info"><Strong>Updated
														By</Strong></td>
												<td class="tableaccount1"><c:out
														value="${account.updatedBy}" /></td>
											</tr>
										</tbody>
									</table>
								</div>
							</c:forEach>

						</div>
						<!-- for account information -->
						<hr />
						<div class="row">
							<p class="text-center text-info">ACCOUNT SETUP</p>
							Yet to develop
						</div>
						<!--row for account setup  -->
						<hr />
					</div>
					<!--jumbotron  -->

				</div>
				<!-- row -->
				<div class="row">
					<div class="col-md-8">
						<div class="panel panel-primary borderless">
<!-- 							<div class="panel-heading">Documents Information</div>
 -->							<div class="panel-body">


								<table class="table table-condensed table-striped">
									<thead>
										<tr>
											<th>Document Name</th>
											<th>File Name</th>
											<th>Status</th>
										</tr>
									</thead>
									<tbody id="myTable">
										<c:forEach var="doc" items="${DocList}" varStatus="status"
											step="1" begin="0">
											<tr>
												<td class="col-md-3"><a target="${status.index }">${doc.document.docName}</a>
												<td class="col-md-3">${doc.document.fileName}</td>
												<td class="col-md-1"><select
													class="form-control input-sm" id="sel1">
													<option value="Select">Select</option>
														<option value="Missing">Missing</option>
														<option value="Incorrect">Incorrect</option>
														<option value="Impossible">Impossible</option>
												</select></td>

											</tr>
										</c:forEach>
									</tbody>
								</table>


<!--     <div class="container col-md-8"> -->
		<div class="panel borderless">
			<div class="panel-body">
				<form>
					<div class="form-group">
						<label class="col-md-2" for="Comments">Comments</label>
						<textarea class="form-control" id="Comments" rows="3"
							placeholder="Enter Your Comments here..."></textarea>
					</div>
					<div class="form-group">
						<label class="col-md-2" for="sel1">Reviewer</label>

						<div class="col-md-2">
							<select class="form-control input-sm" id="sel1">
								<c:forEach var="line1" items="${reviewerList}">
									<option><c:out value="${line1}" /></option>
								</c:forEach>
							</select>
						</div>
					</div>
					<br /> <br />
					<div class="form-group">
						<label class="col-md-2" for="optradio">Status</label> <label
							class="radio-inline"> <input type="radio" name="optradio">Approved
						</label> <label class="radio-inline"> <input type="radio"
							name="optradio">Not Approved
						</label> <label class="radio-inline"> <input type="radio"
							name="optradio" checked="">Other Options
						</label>
					</div>
					<br /> <br />
					<button type="button" class="btn btn-basic col-md-1" value="submit">Submit</button>
					<button type="submit" class="btn btn-default col-md-1"
						formaction="virtualMainBack.htm">Back</button>
				</form>
				<!--     </div> -->


			</div>
			<!--panel body  -->
		</div>
		<!--panel end  -->
							</div>
						</div><!-- panel body -->
					</div>
					<!-- panel end -->
					<div class="col-md-4">
						<c:forEach var="cnt" varStatus="status" items="${DocList}"
							step="1" begin="0">
							<div id="div${status.index}" class="targetdiv">
								<div class="panel panel-danger">
									<div class="panel-heading">Error Status of the Documents</div>
									<div class="panel-body">
										The Document
										<mark>${cnt.document.docName} </mark>
										contains errors in it. Status is
										<mark> ${cnt.validationstatus.status}</mark>
									<p>	Missing- Files Missings
										Incomplete - Incompete data
										Incorrect - Incorrect data
										</p>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>


				</div>
				<!-- row Error div -->
			</div>
			<!-- Container fluid -->
		</div>
	</div>
</body>
</html>
