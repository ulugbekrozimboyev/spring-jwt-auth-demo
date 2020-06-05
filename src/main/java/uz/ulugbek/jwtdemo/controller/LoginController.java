package uz.ulugbek.jwtdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import uz.ulugbek.jwtdemo.config.JwtTokenUtil;
import uz.ulugbek.jwtdemo.dto.JwtRequest;
import uz.ulugbek.jwtdemo.dto.JwtResponse;
import uz.ulugbek.jwtdemo.service.JwtUserDetailsService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

//    public LoginController(SecurityHelper securityHelper) {
//        this.securityHelper = securityHelper;
//    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            e.printStackTrace();
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


}
