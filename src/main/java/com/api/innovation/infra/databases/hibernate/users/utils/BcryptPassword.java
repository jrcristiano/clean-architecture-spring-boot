package com.api.innovation.infra.databases.hibernate.users.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPassword {
	public static String encode(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}

	public static boolean passwordMatches(String rawPassword, String encodedPassword) {
		return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
	}
}
