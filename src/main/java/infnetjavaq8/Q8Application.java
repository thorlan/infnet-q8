package infnetjavaq8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import infnetjavaq8.service.WSConsumer;

@SpringBootApplication
public class Q8Application implements CommandLineRunner{
	
	@Autowired
	private WSConsumer consumer;

	public static void main(String[] args) {
		SpringApplication.run(Q8Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		consumer.consume();
		
	}

}
