package org.example.functions.dto;

import com.microsoft.applicationinsights.core.dependencies.google.gson.Gson;
import lombok.Data;
import org.example.functions.Constants;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

@Data
public class EventDto {
    private String id;
    private String topic;
    private String subject;
    private String eventType;
    private String dataVersion;
    private String metadataVersion;
    private String eventTime;
    private DataDto data;
    private boolean arqsRetorno;
    private boolean arqsAguardando;

    public EventDto(String message) {
        EventDto eventDto = new Gson().fromJson(message, this.getClass());
        this.id = eventDto.getId();
        this.data = eventDto.getData();
        this.topic = eventDto.getTopic();
        this.subject = eventDto.getSubject();
        this.eventTime = eventDto.getEventTime();
        this.eventType = eventDto.getEventType();
        this.dataVersion = eventDto.getDataVersion();
        this.metadataVersion = eventDto.getMetadataVersion();
    }

    public Optional<Participant> checkParticipant() {
        if (this.data != null) {
            arqsRetorno = this.data.getBlobUrl().contains(Constants.ARQ_RETORNO);
            arqsAguardando = this.data.getBlobUrl().contains(Constants.ARQ_AGUARDANDO);

            try {
                URL urlObj = new URL(this.data.getBlobUrl());
                String[] parts = urlObj.getPath().substring(1).split("/");

                if (parts.length >= 3) {
                    Participant participant = Participant.builder()
                            .account(parts[0])
                            .filename(parts[2])
                            .build();
                    return Optional.of(participant);
                } else {
                    return Optional.empty();
                }
            } catch (MalformedURLException e) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
