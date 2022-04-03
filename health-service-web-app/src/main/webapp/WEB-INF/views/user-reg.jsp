<html>
<head>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	<link href="css/user-reg.css" rel="stylesheet">
	<script type="text/javascript" src="js/doc-validate.js"></script>
</head>
<body>
    <div class="user-container d-flex flex-column justify-content-center w-100">
       
       	<h1 class="text-center">User Registration</h1>
      <div class="reg-container w-50 p-5">
         <form  action="user-reg" method="post">
			
			
				
				<div class="form-group">
					<label for="username">Username:</label>
					<input type="text" class="form-control" id="username" name="username">
				</div>
				<div class="form-group">
					<label for="password">Password:</label>
					<input type="password" class="form-control" id="password" name="password">
				</div>
				<div class="form-group">
					<label for="role">Select Role: </label>
					<select id="role" name="role">
					    <option  selected="hidden" >Select Role</option>
					    <option value="DOCTOR">Doctor</option>
					    <option value="PATIENT">Patient</option>
					
					</select>
				</div>
				
				<div class="d-flex justify-content-between align-items-center">
					<div class="form-group d-flex justify-content-start">
						<button type="submit" class="btn btn-primary">Next</button>
					</div>
				</div>
			
		</form>
					
      
       </div>
    </div>
  
	
</body>	
</html>