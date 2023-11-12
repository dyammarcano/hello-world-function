package org.example.functions.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Participant {
    String account;
    String filename;
}
