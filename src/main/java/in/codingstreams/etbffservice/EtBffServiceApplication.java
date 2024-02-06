package in.codingstreams.etbffservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EtBffServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtBffServiceApplication.class, args);
	}

}
