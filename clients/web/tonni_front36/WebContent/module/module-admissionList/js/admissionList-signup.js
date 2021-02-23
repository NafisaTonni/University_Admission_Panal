var gridOptions;
var admissionData=null;

$(document).ready(function(){
	 buildAdmissionGrid();
	loadAdmissionData();
	
	
});
function loadAdmissionData(){
	var get_addmission_info = {
			"type": "get_addmission_info"
			}; 
	new UtilWidget()
	.http(get_addmission_info) 
	.then(msg=> { 
		console.log(msg)
		admissionData = msg.admission_data;
		gridOptions.api.setRowData(msg.admission_data);
		gridOptions.api.sizeColumnsToFit();
		}).catch(d=>console.log(d))
}
function buildAdmissionGrid(){
	gridOptions = {
			onGridReady: function(params) {
				params.api.sizeColumnsToFit();
				window.addEventListener('resize', function() {
	 		          setTimeout(function() {
	 		            params.api.sizeColumnsToFit();
	 		          })
	 		        });
			},
			 defaultColDef: {
		        sortable: true,
		        filter: true,
		        resizable: true,
		    },
		floatingFilter: true,
	    rowSelection: 'single',
		columnDefs : [
	    	{
				headerName: "ID",
				field: "id",
				maxWidth: 60,
				
			},
			{headerName: "Student Name",field: "student_name"} , 
			{headerName: "Subject",field: "subject"} ,
			{headerName: "Father Name",field: "father_name"} ,
			{headerName: "Mother Name",field: "mother_name"} ,
			{headerName: "student Number",field: "student_phone_number"} ,
			{headerName: "Date of Birth",field: "date_of_birth"} ,
			{headerName: "Guardian Number",field: "guardian_phone_number"} ,
			{headerName: "Student Email",field: "student_email"} ,
			{headerName: "Present Address",field: "present_address"} ,
			{headerName: "Permanent Address",field: "permanent_address"} ,
			
			{
				headerName: "",
				field: 'edit',
					//cellRenderer: ageCellRendererFunc,
				template: `
						<div  class="products-actions">
						<a class="edit align-middle fa fa-pencil-alt action-icon" title="Edit"   style="color: var(--success);padding-bottom:3px;"
							aria-hidden="true">
						</a>
						<span class="sr-only"></span>
						</div>`,
				maxWidth: 50,
				filter: false,
				sortable: false,},
				
			  {
				headerName: "",
				field: 'delete', 
				template: `
					<div  class="products-actions">
					
							<a class="remove align-middle fa fa-times action-icon" title="Delete"  style="color: var(--danger); padding-bottom:3px;"
						aria-hidden="true">
					</a>
					<span class="sr-only"></span>
					</div>`,
				maxWidth: 50,
				filter: false,
 				sortable: false,
			  } 
			
		],
		
		onCellClicked: function(event) {
	    	
	    	let selectedID = event.colDef.field.trim();
	    	let selectedData = event.data;
	    	 
	    	switch (selectedID) {
	    	case "edit": 
	    		editwData(selectedData);
				break;
			case "delete": 
				deleteWData(selectedData);
				break;
			default:
				break;
			}
	    	 
	    },
	 
	};
	 
	

	// lookup the container we want the Grid to use
	var eGridDiv = document.querySelector('#admissionListGrid');
	$( "#admissionListGrid" ).empty();

	eGridDiv.childNodes[0] !== undefined
			&& eGridDiv.removeChild(eGridDiv.childNodes[0]);
	new agGrid.Grid(eGridDiv, gridOptions);
	gridOptions.columnApi.getColumn("id").setSort("asc");
	gridOptions.api.setRowData([]);
	gridOptions.api.sizeColumnsToFit();
}
//update
function editwData (data){
	localStorage.setItem("updata", JSON.stringify(data));
	window.location="admissionUpdate.html"
}
//delete
function deleteWData (data){
	var delete_addmission_info = {
			  "type": "delete_addmission_info",
			  "id": data.id, 
			  "student_phone_number": data.student_phone_number
			};  
	bootbox.confirm({
		message: "Are You Sure ?",
		size: 'small',
		buttons: {
			confirm: {
				label: 'Yes',
				className: 'btn-success btn-cus'
			},
			cancel: {
				label: 'No',
				className: 'btn-danger btn-cus'
			}
		},
		callback: function (result) {
			var delete_addmission_info = {
					  "type": "delete_addmission_info",
					  "id": data.id, 
					  "student_phone_number": data.student_phone_number
					};  
			result && new UtilWidget()
			.http(delete_addmission_info)  
			.then(message=> {
	               console.log(message); 
	               message.tag =="Success"?loadAdmissionData():""
				}).catch(d=>console.log(d))
		}
	});
			
}
 