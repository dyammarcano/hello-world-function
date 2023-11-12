package org.example.functions;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.EventGridTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;
import org.example.functions.dto.EventDto;

public class EventGridForwardFunction {
    @FunctionName("EventGridForwardFunction")
    public void run(@EventGridTrigger(name = "eventGridEvent") String message, final ExecutionContext context) {
        context.getLogger().info("Java Event Grid trigger function executed.");
        context.getLogger().info(message);

        EventDto eventDto = new EventDto().deserializeEvent(message);
        context.getLogger().info(eventDto.getData().getApi());
    }
}
