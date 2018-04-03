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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/buttonDisable.js"></script>
<script type="text/javascript">
	function showAlert() {
		alert("Submitted Successfully");
	}
</script>
<script type="text/javascript">
	$(".link").click(function(e) {
		e.preventDefault();
		$('.content-container div').fadeOut('slow');
		$('#' + $(this).data('rel')).fadeIn('slow');
	});
</script>
</head>
<body>
	<div class="jumbotron" style="background-color: #E5E8E8">
		<h3 class="display-2">Account Information</h3>
		<c:forEach items="${accountList}" var="account" varStatus="loop">
      		Account ID:<c:out value="${account.account_Id }"></c:out>
			<br>	Account Name:<c:out value="${account.name}" />
			<br>	Account Number:<c:out value="${account.account_Number}" />
			<br>	Account Division:<c:out value="${account.division}" />
		</c:forEach>
	</div>
	<div class="container col-md-12 ">
		<div class="row">
			<div id="proposalAccordion" class="panel-group">
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
								<c:forEach var="doc" items="${DocList}" varStatus="status"
									step="1" begin="0">
									<tr>
										<td class="col-md-3"><a class="link"
											data-toggle="collapse" data-parent="#proposalAccordion"
											href="#col${status.index}" data-rel="col${status.index}">${doc.docname}</a>
										<td class="col-md-1"><select class="form-control"
											id="sel1">
												<option value="Select">Select</option>
												<option value="Missing">Missing</option>
												<option value="Incorrect">Incorrect</option>
												<option value="Impossible">Impossible</option>
										</select></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!-- Div for error -->
				<div class="panel panel-default col-md-4">
					<div class="panel-heading">Error</div>
					<div class="panel-body"
						style="height: 350px; overflow-y: auto; width: 100%;">
						<div class="content-container">
							<c:forEach var="cnt" varStatus="status" items="${DocList}"
								step="1" begin="0">
								<div id="col${status.index}" class="panel-collapse collapse">
									<div class="panel-body">
										The Document ${cnt.docname} contains errors in it.
										<p class="bg-danger">Status is ${cnt.sts}</p>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<!-- End Div for error -->
			</div>
		</div>
	</div>

	<div class="container col-md-8">
		<form>
			<div class="form-group">
				<label class="col-md-2" for="Comments">Comments</label>
				<textarea class="form-control" id="Comments" rows="3"
					placeholder="Enter Your Comments here..."></textarea>
			</div>
			<div class="form-group">
				<label class="col-md-2" for="sel1">Reviewer</label>

				<div class="col-md-3">
					<select class="form-control" id="sel1">
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
					name="optradio">Other Options
				</label>
			</div>
			<br /> <br />
			<button type="button" class="btn btn-basic col-md-2" value="submit"
				onclick="showAlert()">Submit</button>
			<button type="submit" class="btn btn-default col-md-2"
				formaction="virtualMainBack.htm">Back</button>
		</form>
	</div>



</body>
</html>
