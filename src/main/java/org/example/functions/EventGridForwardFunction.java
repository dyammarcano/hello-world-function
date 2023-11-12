package org.example.functions;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.EventGridTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;
import org.example.functions.dto.EventDto;
import org.example.functions.dto.Participant;

import java.util.Optional;

public class EventGridForwardFunction {
    @FunctionName("EventGridForwardFunction")
    public void run(@EventGridTrigger(name = "eventGridEvent") String message, final ExecutionContext context) {
        context.getLogger().info("Java Event Grid trigger function executed.");
        context.getLogger().info(message);

        EventDto eventDto = new EventDto(message);
        Optional<Participant> participant = eventDto.checkParticipant();

        if (participant.isPresent()) {
            context.getLogger().info("Account: " + participant.get().getAccount());
            context.getLogger().info("Filepath: " + participant.get().getFilename());
        }
    }
}
