package br.com.unoesc.orgfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "br.com.unoesc.orgfit.model")
@SpringBootApplication

public class OrgfitApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrgfitApplication.class, args);
	}

}
