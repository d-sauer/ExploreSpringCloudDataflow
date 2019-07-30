package io.spring.dataflow.sample.filecreationloggerkafka;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootTest
public class FileCreationLoggerKafkaApplicationTests {

    private static final Logger logger = getLogger(FileCreationLoggerKafkaApplicationTests.class);

    @Test
    @DisplayName("Load application context")
    public void contextLoads() {
        logger.info("Context loaded");
    }

}
