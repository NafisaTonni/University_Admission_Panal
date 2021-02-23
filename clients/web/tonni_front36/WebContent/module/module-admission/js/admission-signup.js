
$(document).ready(function(){ 
	 $("#admissionForm").validate({
			rules: {
				student_name: {
					required: true, 
				},
				subject: {
					required: true, 
				},
				father_name: {
					required: true, 
				},
				mother_name: {
					required: true, 
				},
				student_phone_number: {
					required: true, 
				},
				date_of_birth: {
					required: true, 
				},
				guardian_phone_number: {
					required: true, 
				},
				
				student_email: {
					required: true,
					email: true
				},
				present_address: {
					required: true,
					
				},
				
				permanent_address: {
					required: true,
				
				}, 
			}, 
	         messages: {
	        	 
	 		},
			errorElement: "em",
			errorPlacement: function (error, element) {
				// Add the `invalid-feedback` class to the error element
				error.addClass("invalid-feedback");

				if (element.prop("type") === "checkbox") {
					error.insertAfter(element.next("label"));
				} else {
					error.insertAfter(element);
				}
			},
			highlight: function (element, errorClass, validClass) {
				$(element).addClass("is-invalid").removeClass("is-valid");
			},
			unhighlight: function (element, errorClass, validClass) {
				$(element).addClass("is-valid").removeClass("is-invalid");
			},
			submitHandler: function (form) { 
				 submitSignupForm();

			}
		});


	
});

function submitSignupForm(){
	
	var add_addmission_info = {
			"type": "add_addmission_info",
			   "student_name":$('#admissionForm #student_name').val(),
			  "subject":$('#admissionForm #subject').val(),
			  "father_name":$('#admissionForm #father_name').val(),
			  "mother_name":$('#admissionForm #mother_name').val(),
			  "student_phone_number":$('#admissionForm #student_phone_number').val(),
			  "date_of_birth":$('#admissionForm #date_of_birth').val(),
			  "guardian_phone_number":$('#admissionForm #guardian_phone_number').val(),
			  "student_email":$('#admissionForm #student_email').val(),
			  "present_address":$('#admissionForm #present_address').val(),
			  "permanent_address":$('#admissionForm #permanent_address').val(),
			};  
			new UtilWidget()
			.http(add_addmission_info)  
			.then(message=> {
	               console.log(message); 
	               message.tag =="success"?$("#admissionForm")[0].reset():""
				}).catch(d=>console.log(d))
	
}
