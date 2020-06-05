package uz.ulugbek.jwtdemo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.ulugbek.jwtdemo.dto.MyUserDetails;

import java.util.ArrayList;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 05.06.2020 9:57
 */
@Service
public class JwtUserDetailsService  implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("ulugbek".equals(username)) {
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
