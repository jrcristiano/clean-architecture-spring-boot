package com.api.innovation.application.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDTO {
    
    @NotBlank(message = "The field email is required")
	@Email(message = "The field email must be a valid e-mail address")
	@Size(max = 255, message = "The field email is required")
    private String email;


    @NotBlank(message = "The field password is required")
	@Size(min = 8, max = 255, message = "The field password must have between 8 and 255 characters")
    private String password;

    public AuthDTO() {
        
    }

    AuthDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
