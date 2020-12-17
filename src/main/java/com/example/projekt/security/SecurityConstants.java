package com.example.projekt.security;

public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 900_000; // 15min
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/uzytkownicy/sign-up";
    public static final String CONFIRMATION_TOKEN_URL = "/accountConfirm";
}
