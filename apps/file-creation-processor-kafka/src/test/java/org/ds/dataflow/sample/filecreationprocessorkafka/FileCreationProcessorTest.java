package org.ds.dataflow.sample.filecreationprocessorkafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileCreationProcessorTest {

    @Autowired
    private Processor processor;

    @Autowired
    private MessageCollector messageCollector;


    @Test
    void processFileUsageCost() throws InterruptedException {
        // Given
        this.processor.input().send(MessageBuilder.withPayload("{\"name\":\"fileA\",\"size\":100}").build());

        // When
        Message message = this.messageCollector.forChannel(this.processor.output()).poll(1, TimeUnit.SECONDS);

        // Then
        String fileDetailJSON = message.getPayload().toString();

        assertTrue(fileDetailJSON.contains("name"));
        assertTrue(fileDetailJSON.contains("dataCost"));
    }
}