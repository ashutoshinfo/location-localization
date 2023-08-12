package info.ashutosh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PersonPreferredLanguageApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonPreferredLanguageApplication.class, args);
	}

}
