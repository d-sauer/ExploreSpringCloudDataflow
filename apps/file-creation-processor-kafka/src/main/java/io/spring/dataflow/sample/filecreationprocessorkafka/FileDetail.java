package io.spring.dataflow.sample.filecreationprocessorkafka;

import java.time.ZonedDateTime;

public class FileDetail {

    private String name;

    private long size;

    private ZonedDateTime created;

    private ZonedDateTime modified;

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

    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public ZonedDateTime getModified() {
        return modified;
    }

    public void setModified(ZonedDateTime modified) {
        this.modified = modified;
    }
}
