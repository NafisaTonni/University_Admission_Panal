$(document).ready(function(){
	
	$('#instRegForm #btnVerifyDomain').prop('disabled', true);
	$('#instRegForm #btnSubmitForm').prop('disabled', true);
	$("#instRegForm #checkboxCheck").hide();
	$('#instRegForm #phone_no').inputmask({"mask": "(999) 99-999999"});
	$.validator.addMethod(
            "regex",
            function(value, element, regexp) 
            {
                if (regexp.constructor != RegExp)
                    regexp = new RegExp(regexp);
                else if (regexp.global)
                    regexp.lastIndex = 0;
                return this.optional(element) || regexp.test(value);
            },
            "Invalid phone no"
    );
	 $("#instRegForm").validate({
			rules: {
				name_eng: {
					required: true, 
				},
				contact_person: {
					required: true, 
				},
				email: {
					required: true,
					email: true
				},
				phone_no: {
					 required: true,
					 minlength:15,
				     regex: /^\(01[1-9]{1}\)\s?[0-9]{2}\-[0-9]{6}$/,
				} ,
				 
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

	 $("#instRegForm  #btnVerifyDomain").click(function(){
		 var verify_sub_domain = {
					type: "verify_sub_domain", 
					data: {
						sub_domain:$("#sub_domain").val(),
					}
				};  
				console.log(verify_sub_domain);
				new UtilWidget()
				.http(verify_sub_domain) 
				.then( (msg) =>  new UtilWidget().state(msg,true))
				.then(message=> {
		               console.log(message);
		               $('#instRegForm #btnSubmitForm').prop('disabled', false);
		               $('#instRegForm #btnVerifyDomain').prop('disabled', true);
					}).catch(d=>console.log(d));
	 });

	 $("#instRegForm #sub_domain").keyup(function() {
		 
		 $('#instRegForm #btnSubmitForm').prop('disabled', true);
		    var input = $(this).val();
		    var regex = new RegExp("^[a-z]{1}?[a-z0-9]+$"); 
		    if(input.length>15){ 
		    	$("#instRegForm #checkboxCheck").text("This field supported max 15 digits");
		    	$("#instRegForm #checkboxCheck").show();
		    	$('#instRegForm #btnVerifyDomain').prop('disabled', true);
		    	
		    	 
		    }else{
		    	if(regex.test(input)){ 
			    	$("#instRegForm #checkboxCheck").hide();
			    	$('#instRegForm #btnVerifyDomain').prop('disabled', false)
			    	 
			    }else{
			    	$("#instRegForm #checkboxCheck").text("Invalid sub-domain name");
			    	$("#instRegForm #checkboxCheck").show();
			    	$('#instRegForm #btnVerifyDomain').prop('disabled', true);
			    } 
		    }
		    
	  });
	
});

function submitSignupForm(){
	
	var add_registration_request = {
				type: "add_registration_request", 
				data: {
					
				}
			}; 
			$.each($('#instRegForm').serializeArray(), function (i, field) {
				add_registration_request.data[field.name] = field.value;
			});
			add_registration_request.data['phone_no'] = $('#instRegForm #phone_no').val().replace(/\(|\)|\-|\_/g,"").split(" ").join(""),
			console.log(JSON.stringify(add_registration_request));
			new UtilWidget()
			.http(add_registration_request) 
			.then( (msg) =>  new UtilWidget().state(msg,true))
			.then(message=> {
	               console.log(message);
		           	bootbox.dialog({
		 				message: "<h6>Registration Successfull, check SMS/Email for confirmation</h6>",
		 			    size: 'small',
		 			    closeButton: false,
		 			    buttons: {
		 			        "success": {
		 			           label: "Ok", 
		 			           className: "btn-primary btn-cus",
		 			           callback: function () {  window.location ="homepage.html"}
		 			        }
		 			    }       
		 			});
	             
				});
	
}
 