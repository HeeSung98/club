package org.zerock.club.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.zerock.club.security.dto.ClubAuthMemberDTO;

import java.io.IOException;

@Log4j2
public class ClubLoginSuccessHandler implements AuthenticationSuccessHandler {
    public ClubLoginSuccessHandler (PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private PasswordEncoder passwordEncoder;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        log.info("인증성공");

        ClubAuthMemberDTO clubAuthMemberDTO = (ClubAuthMemberDTO) authentication.getPrincipal();

        boolean formSocial = clubAuthMemberDTO.isFormSocial();

        log.info("Need Modify Member? " + formSocial);

        boolean passwordResult = passwordEncoder.matches("1111", clubAuthMemberDTO.getPassword());

        if(formSocial && passwordResult) {
            redirectStrategy.sendRedirect(request, response, "/member/modify?form=social");
        }
    }
}
