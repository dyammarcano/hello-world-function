package org.example.functions.dto;

import lombok.Data;

@Data
public class DataDto {
    private String api;
    private String clientRequestId;
    private String requestId;
    private String eTag;
    private String contentType;
    private long contentLength;
    private String blobType;
    private String blobUrl;
    private String url;
    private String sequencer;
    private String identity;
    private StorageDiagnosticsDto storageDiagnostics;
}
