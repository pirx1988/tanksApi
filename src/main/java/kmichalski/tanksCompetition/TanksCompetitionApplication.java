package kmichalski.tanksCompetition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TanksCompetitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TanksCompetitionApplication.class, args);
	}

}
