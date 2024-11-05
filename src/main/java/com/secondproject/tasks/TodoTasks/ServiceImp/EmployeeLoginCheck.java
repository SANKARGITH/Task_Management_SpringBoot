//package com.secondproject.tasks.TodoTasks.ServiceImp;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.secondproject.tasks.TodoTasks.Entity.Employee;
//import com.secondproject.tasks.TodoTasks.Exceptions.EmployeeNotFound;
//import com.secondproject.tasks.TodoTasks.Respository.EmployeeRespository;
//
//@Service
//public class EmployeeLoginCheck implements UserDetailsService{
//	 
//	@Autowired
//	EmployeeRespository empRepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Employee emp = empRepo.findByEmail(email);
//		if(emp == null) {
//			throw new EmployeeNotFound("User Not Exists...");
//		}
//		Set<String> role = new HashSet<String>();
//		role.add("ROLE_ADMIN");
//		return new User(emp.getEmail(), emp.getPassword(),userAuthorities(role));
//	}
//	
//	
//	private Collection<? extends GrantedAuthority> userAuthorities(Set<String>  roles){
//		return roles.stream().map(
//				role ->new SimpleGrantedAuthority(role)
//				).collect(Collectors.toList());
//	}
//	
//	
//}
