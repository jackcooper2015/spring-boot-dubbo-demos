package com.reapal.dubbo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@ServletComponentScan
@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(WebApplication.class);
        application.run(args);
    }

    @RequestMapping("/")
    public String home(){
	    return "redirect:/index";
    }

}
