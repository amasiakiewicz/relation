package pl.company.relation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneOffset;

@SpringBootApplication
public class RelationApplication {
	public static final ZoneOffset DEFAULT_ZONE_OFFSET = ZoneOffset.UTC;


	public static void main(String[] args) {
		SpringApplication.run(RelationApplication.class, args);
	}

}
