package io.spring.dataflow.sample.filecreationsenderkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;

@EnableScheduling
@EnableBinding(Source.class)
public class FileDetailSender {

    @Autowired
    private Source source;

    private String[] fakefileNames = {"file1", "file2", "file3", "file4", "file5"};

    @Scheduled(fixedDelay = 1000)
    public void sendEvent() {
        FileDetail fileDetail = new FileDetail();
        fileDetail.setName(this.fakefileNames[new Random().nextInt(5)]);
        fileDetail.setCreated(ZonedDateTime.now(ZoneOffset.UTC));
        fileDetail.setModified(ZonedDateTime.now(ZoneOffset.UTC));
        fileDetail.setSize(new Random().nextInt(2000));

        Message<FileDetail> message = MessageBuilder
                                        .withPayload(fileDetail)
                                        .setHeader("trace-id", UUID.randomUUID())
                                        .build();

        this.source.output().send(message);
    }

}
