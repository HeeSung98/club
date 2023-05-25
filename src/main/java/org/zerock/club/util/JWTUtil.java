package org.zerock.club.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.jwt.Jwt;

@Log4j2
public class JWTUtil {
    private String secretKey = "zerock12345678";

    private long expire = 60 * 24 * 30;

    public String generateToken(String content) throws Exception {
        return "not yet";
    }
}
