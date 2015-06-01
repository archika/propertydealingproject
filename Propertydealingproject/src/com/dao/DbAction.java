package com.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class DbAction {
	
	public static boolean authUser(String custname,String mobileno,String emailid,String dob,String gender,String occupation,String address){
		boolean status=false;
		Connection con=Daopro.getConnection();
		try{
			Statement st=con.createStatement();
			String query="select * from customertab where custname='"+custname+"' mobile no='"+mobileno+"'emailid='"+emailid+"' dob='"+dob+"' gender='"+gender+"' occupation='"+occupation+"'address='"+address+"' ";
			ResultSet rs=st.executeQuery(query);
			if(rs.next()){
				status=true;
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return status;
		
	} 
	
	public static boolean InsertCustomertData(String custname,String mobileno,String emailid,String dob,String gender,String occupation,String address){
		boolean status=false;
		Connection con=Daopro.getConnection();
		try{
			Statement st=con.createStatement();
			String uuid=UUID.randomUUID().toString().replace("-", "");
			String query="insert into customertab(custname,mobileno,emailid,dob,gender,occupation,address) values('"+custname+"','"+mobileno+"','"+emailid+"','"+dob+"','"+gender+"','"+occupation+"',"+address+"')";
			int r=st.executeUpdate(query);
			if(r>0){
				status=true;
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return status;
		
	}
	
	public static ResultSet getCustomerData(){
		ResultSet rs=null;
		Connection con=Daopro.getConnection();
		try{
			Statement st=con.createStatement();
			String query="select * from customertab";
			rs=st.executeQuery(query);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return rs;
	}
	
}