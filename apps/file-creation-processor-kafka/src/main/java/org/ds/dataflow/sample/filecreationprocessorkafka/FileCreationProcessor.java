package org.ds.dataflow.sample.filecreationprocessorkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import java.math.BigDecimal;

@EnableBinding(Processor.class)
public class FileCreationProcessor {

    private static final Logger logger = LoggerFactory.getLogger(FileCreationProcessor.class);

    private BigDecimal ratePerMB = new BigDecimal("0.05");

    // TODO: get correlation id
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public FileUsageCost processFileUsageCost(FileDetail fileDetail) {
        logger.info("Processing: {}", fileDetail);
        FileUsageCost fileUsageCost = new FileUsageCost();
        fileUsageCost.setName(fileDetail.getName());
        fileUsageCost.setDataCost(new BigDecimal(fileDetail.getSize()).multiply(ratePerMB));

        logger.info("Producing: {}", fileUsageCost);
        return fileUsageCost;
    }


}
