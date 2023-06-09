package br.pucpr.aulaoauth.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @GetMapping("/callback")
    public String getAccessToken(@RequestParam String challenge, @RequestParam String code){
        return "Username: " + service.exchangeForAccessToken(code, challenge);
    }
}
