var previousData = null;
$(document).ready(function(){ 
	previousData = JSON.parse(localStorage.updata)
	loadPreviousData(previousData);
	 $("#memberFormUpdate").validate({
			rules: {
				name: {
					required: true, 
				},
				company_name: {
					required: true, 
				},
				designation: {
					required: true, 
				},
				official_email: {
					required: true, 
				},
				phone_number: {
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
	
	  $('#memberFormUpdate #name').val(previousData.name);
	  $('#memberFormUpdate #company_name').val(previousData.company_name);
	  $('#memberFormUpdate #designation').val(previousData.designation);
	  $('#memberFormUpdate #official_email').val(previousData.official_email);
	  $('#memberFormUpdate #phone_number').val(previousData.phone_number);
}
function submitUpdateForm(){
	
	var update_member_info = {
			"type": "update_member_info",
			"id": previousData.id,
			   "name":$('#memberFormUpdate #name').val(),
			  "company_name":$('#memberFormUpdate #company_name').val(),
			  "designation":$('#memberFormUpdate #designation').val(),
			  "official_email": previousData.official_email,
			  "phone_number":$('#memberFormUpdate #phone_number').val(),
			 
			  
			};  
	
			new UtilWidget()
			.http(update_member_info)  
			.then(message=> {
	               console.log(message); 
	               message.tag =="success"?$("#memberFormUpdate")[0].reset():""
	               window.location="memberList.html"
				}).catch(d=>console.log(d))
	
}
