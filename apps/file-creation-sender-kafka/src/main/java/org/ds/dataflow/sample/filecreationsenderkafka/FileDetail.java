package org.ds.dataflow.sample.filecreationsenderkafka;

import java.time.ZonedDateTime;

public class FileDetail {

    private String name;

    private long size;

    public FileDetail() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

}