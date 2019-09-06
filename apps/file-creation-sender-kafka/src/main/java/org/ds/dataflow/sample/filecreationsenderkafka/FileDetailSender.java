package org.ds.dataflow.sample.filecreationsenderkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;
import java.util.UUID;

@EnableScheduling
@EnableBinding(Source.class)
public class FileDetailSender {

    private static final Logger logger = LoggerFactory.getLogger(FileDetailSender.class);

    @Autowired
    private Source source;

    private String[] fakefileNames = {"file1", "file2", "file3", "file4", "file5"};

    @Scheduled(fixedDelay = 1000)
    public void sendEvent() {
        logger.info("Preparing event");
        FileDetail fileDetail = new FileDetail();
        fileDetail.setName(this.fakefileNames[new Random().nextInt(5)]);
        fileDetail.setSize(new Random().nextInt(2000));

        Message<FileDetail> message = MessageBuilder
                                        .withPayload(fileDetail)
                                        .setHeader("trace-id", UUID.randomUUID())
                                        .build();


        logger.info("Send event: {}", fileDetail);
        this.source.output().send(message);
    }

}
