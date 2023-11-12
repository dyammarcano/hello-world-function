package org.example.functions.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

@NoArgsConstructor
@Getter
public class Participant {
    String account;
    String filepath;
    String blobUrl;
    String flow;

    public Optional<Participant> extractParticipant(String blobUrl) {
        Participant participant = new Participant();

        participant.flow = "saida";

        if (blobUrl != null && blobUrl.contains("ArqsAguardando")) {
            try {
                URL url = new URL(blobUrl);
                String path = url.getPath();

                // Remove leading slash
                path = path.substring(1);

                // Split the path into parts
                String[] parts = path.split("/");

                if (parts.length >= 3) {
                    participant.account = parts[0];
                    participant.filepath = String.format("%s/%s", parts[1], parts[2]);
                    participant.blobUrl = blobUrl;
                    participant.flow = "entrada";
                } else {
                    return Optional.empty();
                }

            } catch (MalformedURLException e) {
                return Optional.empty();
            }

            return Optional.of(participant);
        }

        return Optional.empty();
    }
}
