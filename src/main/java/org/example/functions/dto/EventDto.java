package org.example.functions.dto;

import com.microsoft.applicationinsights.core.dependencies.google.gson.Gson;
import lombok.Data;

@Data
public class EventDto {
    private String topic;
    private String subject;
    private String eventType;
    private String id;
    private DataDto data;
    private String dataVersion;
    private String metadataVersion;
    private String eventTime;

    public EventDto deserializeEvent(String message) {
        EventDto eventDto = new Gson().fromJson(message, EventDto.class);
        this.topic = eventDto.getTopic();
        this.subject = eventDto.getSubject();
        this.eventType = eventDto.getEventType();
        this.id = eventDto.getId();
        this.data = eventDto.getData();
        this.dataVersion = eventDto.getDataVersion();
        this.metadataVersion = eventDto.getMetadataVersion();
        this.eventTime = eventDto.getEventTime();

        return this;
    }
}
