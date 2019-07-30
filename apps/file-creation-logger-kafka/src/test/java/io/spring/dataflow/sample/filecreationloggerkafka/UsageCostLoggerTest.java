package io.spring.dataflow.sample.filecreationloggerkafka;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.support.MessageBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@SpringBootTest
class UsageCostLoggerTest {

    @Autowired
    protected Sink sink;

    @Autowired
    protected UsageCostLogger usageCostLogger;

    @Test
    public void testUsageCostLogger() throws Exception {
        // Given
        ArgumentCaptor<FileUsageCost> captor = ArgumentCaptor.forClass(FileUsageCost.class);

        // When
        this.sink.input().send(MessageBuilder.withPayload("{\"name\":\"fileA\",\"dataCost\":25.1}").build());

        // Then
        verify(this.usageCostLogger).process(captor.capture());
    }

    @EnableAutoConfiguration
    @EnableBinding(Sink.class)
    static class TestConfig {

        // Override `UsageCostLogger` bean for spying.
        @Bean
        @Primary
        public UsageCostLogger usageCostLogger() {
            return spy(new UsageCostLogger());
        }
    }
}