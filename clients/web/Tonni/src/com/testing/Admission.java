package com.testing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.dbmanager.ConnectionMain;
import com.staticvalue.StaticValue;

public class Admission { 
	
//insert	
public String AddAdmissionInfo( String js_input) {
		
		System.out.println("msg: " + js_input.toString());
		JSONObject js = null;

		try {
			js = new JSONObject(js_input);
		} catch (JSONException e1) {
			e1.printStackTrace();
			System.out.println("PARSE ERROR" + e1.getMessage());
		}

		if (js == null) {
			return "Requested JSON is not valid";
		}

		JSONObject js_main= new JSONObject();
		String type = "TONNIBACKEND", output = "";
		StaticValue.init_db_server_parameters();
		Connection conn = null;
		Statement stmt = null;
	    int existing=0;
		String admissionForm="", SQL="",student_name="",subject="",father_name="",mother_name="",student_phone_number="",date_of_birth="",guardian_phone_number="",student_email="",present_address="",permanent_address="";
		try{
			conn = new ConnectionMain().get_mysql_connection();
			stmt = conn.createStatement();
			student_name = js.getString("student_name");
			subject = js.getString("subject");
			father_name = js.getString("father_name");
			mother_name = js.getString("mother_name");
			student_phone_number = js.getString("student_phone_number");
			date_of_birth = js.getString("date_of_birth");
			guardian_phone_number = js.getString("guardian_phone_number");
			student_email = js.getString("student_email");
			present_address = js.getString("present_address");
			permanent_address= js.getString("permanent_address");
			
			SQL = "select * from admissioninfo where student_phone_number = '" + student_phone_number +"'";
			//SQL = SQL + " where mac_address = '" + mac_address +"'";
			ResultSet rset = stmt.executeQuery(SQL);
			while (rset.next()) {
				existing = 1;
			}
			rset.close();
			if(existing==0){
				SQL="INSERT INTO admissioninfo(student_name,subject,father_name,mother_name,student_phone_number,date_of_birth,guardian_phone_number,student_email,present_address,permanent_address) VALUES (";
				SQL=SQL+"'"+student_name+"','"+subject+"','"+father_name+"','"+mother_name+"','"+student_phone_number+"','"+date_of_birth+"',";
				SQL=SQL+"'"+guardian_phone_number+"','"+student_email+"','"+present_address+"','"+permanent_address+"'";
				SQL=SQL+")";
				//System.out.println(SQL);
				int d= stmt.executeUpdate(SQL);
				js_main.put("type", type);
				if(d==1){
				 js_main.put("msg", "Successfully added");
				 js_main.put("tag", "success");
				
				}else{
					js_main.put("msg", "Something went error, Please try again!");
					js_main.put("tag", "failed");
				}
				
			}else{
				js_main.put("msg", "Data already exists!");
				js_main.put("tag", "failed");
			}
			output=js_main.toString();
		}catch(JSONException | SQLException e){
			try {
				js_main.put("type", type);
				js_main.put("msg", e.getMessage());
				js_main.put("TAG", "error");
				output=js_main.toString();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				output="Failed: "+e1.getMessage();
			}
			
			System.out.println("Failed: "+e.getMessage());
		}
		return output;
	}

	public String GetAdmissionInfo( String js_input) {
		
		System.out.println("msg: " + js_input.toString());
		JSONObject js = null;

		try {
			js = new JSONObject(js_input);
		} catch (JSONException e1) {
			e1.printStackTrace();
			System.out.println("PARSE ERROR" + e1.getMessage());
		}

		if (js == null) {
			return "Requested JSON is not valid";
		}

		JSONObject js_main= new JSONObject();
		JSONArray js_arr = new JSONArray();
		String type = "TONNIBACKEND", output = "";
		StaticValue.init_db_server_parameters();
		Connection conn = null;
		Statement stmt = null;
	    int existing=0;
		String admissionForm="", SQL="";
		try{
			conn = new ConnectionMain().get_mysql_connection();
			stmt = conn.createStatement();
	
			SQL = "select id,student_name,subject,father_name,mother_name,student_phone_number,date_of_birth,guardian_phone_number,student_email,present_address,permanent_address from admissioninfo";
			
			ResultSet rset = stmt.executeQuery(SQL);
			while (rset.next()) {
				int id = rset.getInt("id"); 
				String student_name = rset.getString("student_name");
				String subject = rset.getString("subject");
				String father_name = rset.getString("father_name");
				String mother_name = rset.getString("mother_name");
				String student_phone_number = rset.getString("student_phone_number");
				String date_of_birth = rset.getString("date_of_birth");
				String guardian_phone_number = rset.getString("guardian_phone_number");
				String student_email = rset.getString("student_email");
				String present_address = rset.getString("present_address");
				String permanent_address = rset.getString("permanent_address");

				JSONObject js_output= new JSONObject();
				js_output.put("id",id);
				js_output.put("student_name",student_name);
				js_output.put("subject",subject);
				js_output.put("father_name",father_name);
				js_output.put("mother_name",mother_name);
				js_output.put("student_phone_number",student_phone_number);
				js_output.put("date_of_birth",date_of_birth);
				js_output.put("guardian_phone_number",guardian_phone_number);
				js_output.put("student_email",student_email);
				js_output.put("present_address",present_address);
				js_output.put("permanent_address",permanent_address);
				js_arr.put(js_output);
			}
			rset.close(); 
			js_main.put("type", type);
			js_main.put("admission_data", js_arr);
			js_main.put("tag", "Success");
			output=js_main.toString();
		}catch(JSONException | SQLException e){
			try {
				js_main.put("type", type);
				js_main.put("msg", e.getMessage());
				js_main.put("tag", "error");
				output=js_main.toString();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				output="Failed: "+e1.getMessage();
			}
			
			System.out.println("Failed: "+e.getMessage());
		}
		return output;
	}
	

//update
public String GetAdmissionInfoUpdate( String js_input) {
	
	System.out.println("msg: " + js_input.toString());
	JSONObject js = null;

	try {
		js = new JSONObject(js_input);
	} catch (JSONException e1) {
		e1.printStackTrace();
		System.out.println("PARSE ERROR" + e1.getMessage());
	}

	if (js == null) {
		return "Requested JSON is not valid";
	}

	JSONObject js_main= new JSONObject();
	JSONArray js_arr = new JSONArray();
	String type = "TONNIBACKEND", output = "";
	StaticValue.init_db_server_parameters();
	Connection conn = null;
	Statement stmt = null;
    int existing=0,id=0;
	String admissionForm="", SQL="",student_name="",subject="",father_name="",mother_name="",student_phone_number="",date_of_birth="",guardian_phone_number="",student_email="",present_address="",permanent_address="";
	try{
		conn = new ConnectionMain().get_mysql_connection();
		stmt = conn.createStatement();
		id = js.getInt("id");
		student_name = js.getString("student_name");
		subject = js.getString("subject");
		father_name = js.getString("father_name");
		mother_name = js.getString("mother_name");
		student_phone_number = js.getString("student_phone_number");
		date_of_birth = js.getString("date_of_birth");
		guardian_phone_number = js.getString("guardian_phone_number");
		student_email = js.getString("student_email");
		present_address = js.getString("present_address");
		permanent_address= js.getString("permanent_address");
		
		SQL = "select * from admissioninfo where id="+id+" and student_phone_number = '" + student_phone_number +"'";
		ResultSet rset = stmt.executeQuery(SQL);
		while (rset.next()) {
			existing = 1;
		}
		rset.close(); 
		if(existing==1){
			SQL="update admissioninfo set student_name= '"+student_name+"', subject ='"+subject+"'";
			SQL=SQL+" , father_name = '"+father_name+"', mother_name = '"+mother_name+"', date_of_birth = '"+date_of_birth+"' , guardian_phone_number = '"+guardian_phone_number+"' , student_email = '"+student_email+"', present_address = '"+present_address+"', permanent_address = '"+permanent_address+"' ";
			SQL=SQL+" where id="+id+" and student_phone_number = '"+student_phone_number+"'";

			//System.out.println(SQL);
			int d= stmt.executeUpdate(SQL);
			js_main.put("type", type);
			if(d==1){
				js_main.put("msg", "Successfully updated");
				 js_main.put("tag", "Success");
			}else{
				js_main.put("msg", "Something went error, Please try again!");
				js_main.put("tag", "failed");
			}
			
			}else{
				js_main.put("msg", "Data not found");
				js_main.put("tag", "Failed");
			}
		
		output=js_main.toString();
		
	}catch(JSONException | SQLException e){
		try {
			js_main.put("type", type);
			js_main.put("msg", e.getMessage());
			js_main.put("tag", "error");
			output=js_main.toString();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			output="Failed: "+e1.getMessage();
		}
		
		System.out.println("Failed: "+e.getMessage());
	}
	return output;
}
//delete
public String GetAdmissionInfoDelete( String js_input) {
	
	System.out.println("msg: " + js_input.toString());
	JSONObject js = null;

	try {
		js = new JSONObject(js_input);
	} catch (JSONException e1) {
		e1.printStackTrace();
		System.out.println("PARSE ERROR" + e1.getMessage());
	}

	if (js == null) {
		return "Requested JSON is not valid";
	}

	JSONObject js_main= new JSONObject();
	JSONArray js_arr = new JSONArray();
	String type = "TONNIBACKEND", output = "";
	StaticValue.init_db_server_parameters();
	Connection conn = null;
	Statement stmt = null;
	int existing=0,id=0;
	String admissionForm="", SQL="",student_phone_number="";
	//String admissionForm="", SQL="",student_name="",subject="",father_name="",mother_name="",student_phone_number="",date_of_birth="",guardian_phone_number="",student_email="",present_address="",permanent_address="";

	try{
		conn = new ConnectionMain().get_mysql_connection();
		stmt = conn.createStatement();
		id = js.getInt("id"); 
		student_phone_number = js.getString("student_phone_number");
		
		//SQL = "select id,student_name,subject,father_name,mother_name,student_phone_number,date_of_birth,guardian_phone_number,student_email,present_address,permanent_address from admissioninfo";
		//SQL="update admissioninfo set student_name= '+student_name+' where student_phone_number = 'student_phone_number'";
		
		SQL="select * from admissioninfo where id="+id+" and student_phone_number = '"+student_phone_number+"'";
		ResultSet rset = stmt.executeQuery(SQL);
		while (rset.next()) {
			existing = 1;
		}
		rset.close(); 
		if(existing==1){
			SQL="delete from admissioninfo where id="+id+" and student_phone_number = '"+student_phone_number+"'";
			
			System.out.println(SQL);
			int d= stmt.executeUpdate(SQL);
			js_main.put("type", type);
			if(d==1){
			 js_main.put("msg", "Successfully deleted");
			 js_main.put("tag", "Success");
			}else{
				js_main.put("msg", "Something went error, Please try again!");
				js_main.put("tag", "failed");
			}
			
		}else{ 
			js_main.put("msg", "Data not found");
			js_main.put("tag", "failed");
		}
		js_main.put("type", type);
		output=js_main.toString();
	}catch(JSONException | SQLException e){
		try {
			js_main.put("type", type);
			js_main.put("msg", e.getMessage());
			js_main.put("tag", "error");
			output=js_main.toString();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			output="Failed: "+e1.getMessage();
		}
		
		System.out.println("Failed: "+e.getMessage());
	}
	return output;
}
}
