package uz.ulugbek.jwtdemo.dto;

import java.io.Serializable;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 02.06.2020 18:32
 */
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getJwttoken() {
        return jwttoken;
    }
}
