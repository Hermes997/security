package ryu.assign.security.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ryu.assign.security.model.User;
import ryu.assign.security.repository.UserRepository;

@Controller
public class SecurityController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/home")
	public String home() {
		return "/home";
	}
	
	@GetMapping("/joinform")
	public String joinForm() {
		return "/joinForm";
	}
	
	@GetMapping("/loginform")
	public String loginForm() {
		return "/loginForm";
	}
	
	@PostMapping("/join")
	public String join (User user) {
		user.setRole("ROLE_USER");
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		
		userRepository.save(user);
		return "redirect:/loginform";
	}
	
	@GetMapping("/user")
	public @ResponseBody String user() {
		
		return "user";
	}
	
	@GetMapping("/manager")
	public @ResponseBody String manager() {
		
		return "manager";
	}
	
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		
		return "admin";
	}
	

}
