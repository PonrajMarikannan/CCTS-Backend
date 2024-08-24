package com.raj.customsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.raj.customsapp.model.User;
import com.raj.customsapp.serviceImpl.CustomMail;
import com.raj.customsapp.serviceImpl.UserServiceImpl;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserServiceImpl serviceimpl;
    
    @Autowired
    private CustomMail mailservice;
    
    @PostMapping("/register")
    public String addUser(@RequestBody User user) {
        try {
        	
        	if (user.getRole() == null || user.getRole().isEmpty()) {
                user.setRole("client");
            }
        	
            serviceimpl.addUser(user);
            return "Success";
        } catch (Exception e) {
            return "Failure";
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            User UseredUser = serviceimpl.findUserByEmail(user.getEmail());
            if (UseredUser != null && UseredUser.getPassword().equals(user.getPassword())) {
             
            	String role = UseredUser.getRole(); 
            	int id = UseredUser.getUserId();
                return ResponseEntity.ok(new LoginResponse(id,"LoginSuccess", role));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect credentials. Please try again.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error. Please try again later.");
        }
    }
    
    @PostMapping("/mail")
    public ResponseEntity<String> sendCustomEmail(@RequestBody EmailRequest emailRequest) {
        try {
        	String content = String.format(
        		    "Hello %s,\n\n" +
        		    "Your account has been successfully created with CustomsGate.\n\n" +
        		    "Here are your login credentials:\n" +
        		    "Email: %s\n" +
        		    "Password: %s\n\n" +
        		    "For security reasons, we recommend changing your password after logging in for the first time. To do this, please follow these steps:\n" +
        		    "1. Log in to your account using the credentials provided.\n" +
        		    "2. Go to the account settings page.\n" +
        		    "3. Select the option to change your password.\n" +
        		    "4. Follow the instructions to set a new password.\n\n" +
        		    "If you have any questions or need assistance, feel free to contact our support team.\n\n" +
        		    "Best regards,\n" +
        		    "The CustomsGate Team",
        		    emailRequest.getEmail().split("@")[0],  // Use the part of the email before the '@' as the username
        		    emailRequest.getEmail(),
        		    emailRequest.getPassword()
        		);

            String subject = "Successfully Account Creation";
            mailservice.sendEmail(emailRequest.getEmail(), subject, content);
            return ResponseEntity.ok("MailSend");
        } catch (Exception e) {
            e.printStackTrace(); // Log exception for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
        }
    }
    
    
    
    public static class LoginResponse {
    	
    	private int id;
    	private String status;
        private String role;
        
        public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

		public LoginResponse(int id, String status, String role) {
			super();
			this.id = id;
			this.status = status;
			this.role = role;
		}

		public LoginResponse() {
			super();
		}
    }
    
    public static class EmailRequest {
        private String email;
        private String password;
        
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public EmailRequest(String email, String password) {
			super();
			this.email = email;
			this.password = password;
		}
		public EmailRequest() {
			super();
		}    
    }
}
