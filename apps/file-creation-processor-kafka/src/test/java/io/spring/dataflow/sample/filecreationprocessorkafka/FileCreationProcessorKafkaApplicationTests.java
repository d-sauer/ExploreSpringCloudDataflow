package io.spring.dataflow.sample.filecreationprocessorkafka;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class FileCreationProcessorKafkaApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(FileCreationProcessorKafkaApplicationTests.class);

	@Test
	@DisplayName("Load application context")
	public void contextLoads() {
		logger.info("Context loaded");
	}

}
