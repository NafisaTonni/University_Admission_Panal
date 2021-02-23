var previousData = null;
$(document).ready(function(){ 
	previousData = JSON.parse(localStorage.updata)
	loadPreviousData(previousData);
	 $("#admissionFormUpdate").validate({
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
				 submitUpdateForm();

			}
		});


	
});

function loadPreviousData (){
	
	  $('#admissionFormUpdate #student_name').val(previousData.student_name);
	  $('#admissionFormUpdate #subject').val(previousData.subject);
	  $('#admissionFormUpdate #father_name').val(previousData.father_name);
	  $('#admissionFormUpdate #mother_name').val(previousData.mother_name);
	  $('#admissionFormUpdate #student_phone_number').val(previousData.student_phone_number);
	  $('#admissionFormUpdate #date_of_birth').val(previousData.date_of_birth);
	  $('#admissionFormUpdate #guardian_phone_number').val(previousData.guardian_phone_number);
	  $('#admissionFormUpdate #student_email').val(previousData.student_email);
	  $('#admissionFormUpdate #present_address').val(previousData.present_address);
	  $('#admissionFormUpdate #permanent_address').val(previousData.permanent_address);
	
	
}
function submitUpdateForm(){
	
	var update_addmission_info = {
			"type": "update_addmission_info",
			"id": previousData.id,
			   "student_name":$('#admissionFormUpdate #student_name').val(),
			  "subject":$('#admissionFormUpdate #subject').val(),
			  "father_name":$('#admissionFormUpdate #father_name').val(),
			  "mother_name":$('#admissionFormUpdate #mother_name').val(),
			  "student_phone_number": previousData.student_phone_number,
			  "date_of_birth":$('#admissionFormUpdate #date_of_birth').val(),
			  "guardian_phone_number":$('#admissionFormUpdate #guardian_phone_number').val(),
			  "student_email":$('#admissionFormUpdate #student_email').val(),
			  "present_address":$('#admissionFormUpdate #present_address').val(),
			  "permanent_address":$('#admissionFormUpdate #permanent_address').val(),
			};  
	
			new UtilWidget()
			.http(update_addmission_info)  
			.then(message=> {
	               console.log(message); 
	               message.tag =="success"?$("#admissionFormUpdate")[0].reset():""
	               window.location="admissionList.html"
				}).catch(d=>console.log(d))
	
}
