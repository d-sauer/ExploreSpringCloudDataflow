package io.spring.dataflow.sample.filecreationsenderkafka;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootTest
public class FileCreationSenderKafkaApplicationTests {

    private static final Logger logger = getLogger(FileCreationSenderKafkaApplicationTests.class);

	@Test
	@DisplayName("Load application context")
	public void contextLoads() {
	    logger.info("Context loaded");
	}


}
