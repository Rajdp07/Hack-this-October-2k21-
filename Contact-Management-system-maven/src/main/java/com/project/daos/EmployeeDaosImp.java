package com.project.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.project.entity.Employee;
import com.project.exception.EmployeeNotFoundException;
import com.project.exception.NameNotFoundException;
import com.project.ifaces.CRUDRepository;

public class EmployeeDaosImp implements CRUDRepository {

	private Connection con ;
	public EmployeeDaosImp(Connection con){
		this.con = con;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		
		String sql = "insert into employee values(?,?,?,?,?,?,?,?)";
		int rowAdded=0;
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1,employee.getId());
			pstmt.setString(2,employee.getFirstName());
			pstmt.setString(3,employee.getLastName());
			pstmt.setString(4,employee.getAddress());
			pstmt.setString(5,employee.getEmailAddress());
			pstmt.setString(6,employee.getPhoneNumber());
			pstmt.setDate(7,Date.valueOf(employee.getBirthDate()));
			pstmt.setDate(8,Date.valueOf(employee.getWeddingAnniversary()));
			rowAdded = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return rowAdded==1;
	}

	@Override
	public List<Employee> getEmployee(String name) throws NameNotFoundException {
		// TODO Auto-generated method stub
		List<Employee> myEmployeeList= new ArrayList<>();
		String sql="select * from employee where firstname= ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id= rs.getInt(1);
				String firstName= rs.getString(2);
				String lastName= rs.getString(3);
				String address= rs.getString(4);
				String emailAddress= rs.getString(5);
				String phoneNumber= rs.getString(6);
				LocalDate birthDate= rs.getDate(7).toLocalDate();
				LocalDate weddingAnniversary= rs.getDate(8).toLocalDate();
				
				myEmployeeList.add(new Employee(id, firstName, lastName, address, emailAddress, phoneNumber, birthDate, weddingAnniversary));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(myEmployeeList.isEmpty()) {
			throw new NameNotFoundException("Employee Not Found with given name "+name);
		}
		
		return myEmployeeList;
	}

	@Override
	public Employee getEmployeeByID(int id) throws EmployeeNotFoundException   {
	
		Employee myEmployee = null;
		
		String sql = "select * from employee where id = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
			   String firstName = rs.getString(2);
			   String lastName = rs.getString(3);
			   String address = rs.getString(4);
			   String emailAddress = rs.getString(5);
			   String phoneNumber = rs.getString(6);
			   LocalDate birthDay = rs.getDate(7).toLocalDate();
			   LocalDate weddingAnniversary = rs.getDate(8).toLocalDate();
			   
			   myEmployee= new Employee(id,firstName,lastName,address,emailAddress,phoneNumber,birthDay,weddingAnniversary);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(myEmployee==null) {
			throw new EmployeeNotFoundException("Employee not Found with id "+id);
		}
		
		return myEmployee;
	}

	@Override
	public boolean editEmployee(Employee employee) {
		
		int res=0;
		String sql = "update employee set firstName=?,lastName=?,address=?,emailAddress=?,phoneNumber=?,birthDate=?,weddingAnniversary=? where Id = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1,employee.getFirstName());
			pstmt.setString(2,employee.getLastName());
			pstmt.setString(3,employee.getAddress());
			pstmt.setString(4,employee.getEmailAddress());
			pstmt.setString(5,employee.getPhoneNumber());
			pstmt.setDate(6,Date.valueOf(employee.getBirthDate()));
			pstmt.setDate(7,Date.valueOf(employee.getWeddingAnniversary()));
			pstmt.setInt(8, employee.getId());
			res = pstmt.executeUpdate();
			} catch(Exception ex) {
			    ex.printStackTrace();
		    }
		return res>0;
	}

	@Override
	public List<Employee> getEmployeeOfGivenBirthDate(LocalDate date) {
		List<Employee> mylist=new ArrayList<>();
		String sql = "select * from employee where birthdate = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setDate(1, Date.valueOf(date));
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String address = rs.getString(4);
				String emailAddress = rs.getString(5);
				String phoneNumber = rs.getString(6);
				LocalDate birthDate = rs.getDate(7).toLocalDate();
				LocalDate weddingAnniversary = rs.getDate(8).toLocalDate();
				
				mylist.add(new Employee(id,firstName,lastName,address,emailAddress,phoneNumber,birthDate,weddingAnniversary));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mylist;
	}

	@Override
	public List<Employee> getEmployeeOfGivenAnniversary(LocalDate date) {
		List<Employee> mylist=new ArrayList<>();
		String sql = "select * from employee where weddingAnniversary = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setDate(1, Date.valueOf(date));
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String address = rs.getString(4);
				String emailAddress = rs.getString(5);
				String phoneNumber = rs.getString(6);
				LocalDate birthDate = rs.getDate(7).toLocalDate();
				LocalDate weddingAnniversary = rs.getDate(8).toLocalDate();
				
				mylist.add(new Employee(id,firstName,lastName,address,emailAddress,phoneNumber,birthDate,weddingAnniversary));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mylist;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> mylist=new ArrayList<>();
		String sql = "select * from employee";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String address = rs.getString(4);
				String emailAddress = rs.getString(5);
				String phoneNumber = rs.getString(6);
				LocalDate birthDay = rs.getDate(7).toLocalDate();
				LocalDate weddingAnniversary = rs.getDate(8).toLocalDate();
				
				mylist.add(new Employee(id,firstName,lastName,address,emailAddress,phoneNumber,birthDay,weddingAnniversary));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mylist;
	}

}
