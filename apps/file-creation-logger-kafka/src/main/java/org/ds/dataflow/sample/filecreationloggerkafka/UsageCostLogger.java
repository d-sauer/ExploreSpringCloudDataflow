package org.ds.dataflow.sample.filecreationloggerkafka;

import org.slf4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import static org.slf4j.LoggerFactory.getLogger;

@EnableBinding(Sink.class)
public class UsageCostLogger {

    private static final Logger logger = getLogger(UsageCostLogger.class);

    @StreamListener(Sink.INPUT)
    public void process(FileUsageCost fileUsageCost) {
        logger.info("Receiving: {}", fileUsageCost.toString());
    }
}
