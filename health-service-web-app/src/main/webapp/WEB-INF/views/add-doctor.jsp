<html>
<head>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	<link href="css/add-doc.css" rel="stylesheet">
	<script type="text/javascript" src="js/doc-validate.js"></script>
</head>
<body>
    <div class="container d-flex flex-column justify-content-center">
       
       <h4 align="center" class="heading">Doctor Registration Form</h4>
      <div class="reg-container ">
         
					<form class="" method="post" action="add-doctor" onsubmit="return validate()">
						 <div class="container p-3">
                           <div class="row">
                           
                         <div class="form-group col-12 col-md-5 col-lg-4">
						 <label for="ename" >Enter  Name</label><br>
						  <div class="input-group">
							<input type="text" class="form-control" name="dname" id="dname"  placeholder="Enter your Name" onblur="isValidDoctorName()"/>
						  </div>
						  <p id="p1"></p>	
				        </div>
						
						<div class="form-group col-12 col-md-7 col-lg-4">
						<label for="specialization">Enter Specialization</label>
						  <div class="input-group">
							<input type="text" class="form-control" name="specialization" id="specialization"  placeholder="Enter your specialization"/>
						  </div>	
						</div>
						
						<div class="form-group col-12 col-md-4 col-lg-4">
						<label for="availabletiming">Enter Available Timing</label>
						  <div class="input-group">
							<input type="text" class="form-control" name="availabletiming" id="availabletiming"  placeholder="Enter your  Available Timings"/>
						  </div>	
						</div>
						
						<div class="form-group col-12 col-md-5 col-lg-4">
						<label for="qualification">Enter Qualification</label>
						  <div class="input-group">
							<input type="text" class="form-control" name="qualification" id="qualification"  placeholder="Enter Qualification"/>
						  </div>
						</div>
						
						<div class="form-group col-12 col-md-6 col-lg-4">
						<label for="expinyears">Enter Experience In Years</label>
						  <div class="input-group">
						     <input type="number" class="form-control" name="expinyears" id="expinyears"  placeholder="Enter Experience In Years"/>
						  </div>	
						</div>
						
						<div class="form-group col-12 col-md-6 col-lg-4">
						<label for="mobile">Enter Mobile</label>
						  <div class="input-group">
							<input type="number" class="form-control" name="mobile" id="mobile"  placeholder="Enter mobile" onblur="isValidMobile()"/>
						  </div>
						  <p id="p2"></p>
						</div>
						
						<div class="form-group col-12 col-md-8 col-lg-4">
						<label for="email">Enter Email</label>
						  <div class="input-group">
							<input type="text" class="form-control" name="email" id="email"  placeholder="Enter Email" onblur="isValidEmail()" />
						  </div>
						  <p id="p3"></p>
						</div>
                        
						 </div>
       </div>
       <div class="form-group ">
						<input type="submit" name="register"
							class="btn btn-primary btn-lg  login-button m-3"
							value="Register">
			</div>
					</form>
      
       </div>
    </div>
  
	
</body>	
</html>