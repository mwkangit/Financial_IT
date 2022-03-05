package comento.financial_it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

@SpringBootApplication
public class FinancialItApplication {


	public static void main(String[] args) {
		SpringApplication.run(FinancialItApplication.class, args);
	}

}
