package hello.servlet_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ServletPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletPracticeApplication.class, args);
	}

}
