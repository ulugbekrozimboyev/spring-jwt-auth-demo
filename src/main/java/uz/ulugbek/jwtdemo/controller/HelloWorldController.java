package uz.ulugbek.jwtdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 05.06.2020 9:37
 */
@RestController
public class HelloWorldController {

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }
}
