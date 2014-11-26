package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@PropertySource("classpath:/config/name.properties")
public class SampleController {

	@Value("${name}")
	String name;
	
	@Value("${server.port}")
	String port;
	
	@Autowired
	Environment env;
	
    @RequestMapping("/")
    String home() {
    	System.out.println("Default: Name: " + name + " Port: " + port);
    	System.out.println("Env: Name: " + env.getProperty("name") + " Port: " + env.getProperty("server.port"));

    	
        return "index";
    }
    
    @RequestMapping("/learn_more")
    String learnMore()
    {
    	System.out.println("Default: Name: " + name + " Port: " + port);
    	System.out.println("Env: Name: " + env.getProperty("name") + " Port: " + env.getProperty("server.port"));

    	return "learn_more";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}