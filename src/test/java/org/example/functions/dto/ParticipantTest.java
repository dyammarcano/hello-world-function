package org.example.functions.dto;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParticipantTest {

    @Test
    void extractParticipant() {
        String riobm = "{\"topic\":\"/subscriptions/1e7956ea-ada5-4694-9839-ea6431b9af39/resourceGroups/rg-app-azure-function-examples-v2-231112124800/providers/Microsoft.Storage/storageAccounts/storageaccountfordatapoc\",\"subject\":\"/blobServices/default/containers/05000005/blobs/ArqsAguardando/ARQ0001_CDB_INCL-SIRC.txt\",\"eventType\":\"Microsoft.Storage.BlobCreated\",\"id\":\"6b38e784-c01e-0091-3085-153e18060277\",\"data\":{\"api\":\"PutBlob\",\"clientRequestId\":\"d15c9f64-bca1-4814-694e-436283205d03\",\"requestId\":\"6b38e784-c01e-0091-3085-153e18000000\",\"eTag\":\"0x8DBE39CEED0418B\",\"contentType\":\"image/jpeg\",\"contentLength\":63905,\"blobType\":\"BlockBlob\",\"blobUrl\":\"https://storageaccountfordatapoc.blob.core.windows.net/05000005/ArqsAguardando/ARQ0001_CDB_INCL-SIRC.txt\",\"url\":\"https://storageaccountfordatapoc.blob.core.windows.net/05000005/ArqsAguardando/ARQ0001_CDB_INCL-SIRC.txt\",\"sequencer\":\"0000000000000000000000000003607b000000000000e055\",\"identity\":\"$superuser\",\"storageDiagnostics\":{\"batchId\":\"f5d1ef99-9006-0035-0085-1537be000000\"}},\"dataVersion\":\"\",\"metadataVersion\":\"1\",\"eventTime\":\"2023-11-12T16:32:16.4094003Z\"}";
        String pr90302bm = "{\"topic\":\"/subscriptions/1e7956ea-ada5-4694-9839-ea6431b9af39/resourceGroups/rg-app-azure-function-examples-v2-231112124800/providers/Microsoft.Storage/storageAccounts/storageaccountfordatapoc\",\"subject\":\"/blobServices/default/containers/03483002/blobs/ArqsAguardando/ARQ0001_RDB_SEMC-SIRC.txt\",\"eventType\":\"Microsoft.Storage.BlobCreated\",\"id\":\"6b38e784-c01e-0091-3085-153e18060277\",\"data\":{\"api\":\"PutBlob\",\"clientRequestId\":\"d15c9f64-bca1-4814-694e-436283205d03\",\"requestId\":\"6b38e784-c01e-0091-3085-153e18000000\",\"eTag\":\"0x8DBE39CEED0418B\",\"contentType\":\"image/jpeg\",\"contentLength\":63905,\"blobType\":\"BlockBlob\",\"blobUrl\":\"https://storageaccountfordatapoc.blob.core.windows.net/03483002/ArqsAguardando/ARQ0001_RDB_SEMC-SIRC.txt\",\"url\":\"https://storageaccountfordatapoc.blob.core.windows.net/03483002/ArqsAguardando/ARQ0001_RDB_SEMC-SIRC.txt\",\"sequencer\":\"0000000000000000000000000003607b000000000000e055\",\"identity\":\"$superuser\",\"storageDiagnostics\":{\"batchId\":\"f5d1ef99-9006-0035-0085-1537be000000\"}},\"dataVersion\":\"\",\"metadataVersion\":\"1\",\"eventTime\":\"2023-11-12T16:32:16.4094003Z\"}";
        String retorno = "{\"topic\":\"/subscriptions/1e7956ea-ada5-4694-9839-ea6431b9af39/resourceGroups/rg-app-azure-function-examples-v2-231112124800/providers/Microsoft.Storage/storageAccounts/storageaccountfordatapoc\",\"subject\":\"/blobServices/default/containers/03483002/blobs/ArqsRetorno/ARQ0001_RDB_SEMC-SIRC.txt.48598264\",\"eventType\":\"Microsoft.Storage.BlobCreated\",\"id\":\"6b38e784-c01e-0091-3085-153e18060277\",\"data\":{\"api\":\"PutBlob\",\"clientRequestId\":\"d15c9f64-bca1-4814-694e-436283205d03\",\"requestId\":\"6b38e784-c01e-0091-3085-153e18000000\",\"eTag\":\"0x8DBE39CEED0418B\",\"contentType\":\"image/jpeg\",\"contentLength\":63905,\"blobType\":\"BlockBlob\",\"blobUrl\":\"https://storageaccountfordatapoc.blob.core.windows.net/03483002/ArqsRetorno/ARQ0001_RDB_SEMC-SIRC.txt.48598264\",\"url\":\"https://storageaccountfordatapoc.blob.core.windows.net/03483002/ArqsRetorno/ARQ0001_RDB_SEMC-SIRC.txt.48598264\",\"sequencer\":\"0000000000000000000000000003607b000000000000e055\",\"identity\":\"$superuser\",\"storageDiagnostics\":{\"batchId\":\"f5d1ef99-9006-0035-0085-1537be000000\"}},\"dataVersion\":\"\",\"metadataVersion\":\"1\",\"eventTime\":\"2023-11-12T16:32:16.4094003Z\"}";

        EventDto eventDto = new EventDto(riobm);
        Optional<Participant> participant = eventDto.checkParticipant();

        if (participant.isPresent()) {
            assertEquals("05000005", participant.get().account);
            assertEquals("ArqsAguardando/ARQ0001_CDB_INCL-SIRC.txt", participant.get().filepath);
            assertEquals("https://storageaccountfordatapoc.blob.core.windows.net/05000005/ArqsAguardando/ARQ0001_CDB_INCL-SIRC.txt", eventDto.getData().getBlobUrl());
        }

        eventDto = new EventDto(pr90302bm);
        participant = eventDto.checkParticipant();

        if (participant.isPresent()) {
            assertEquals("03483002", participant.get().account);
            assertEquals("ArqsAguardando/ARQ0001_RDB_SEMC-SIRC.txt", participant.get().filepath);
            assertEquals("https://storageaccountfordatapoc.blob.core.windows.net/03483002/ArqsAguardando/ARQ0001_RDB_SEMC-SIRC.txt", eventDto.getData().getBlobUrl());
        }

        eventDto = new EventDto(retorno);
        participant  = eventDto.checkParticipant();

        assertEquals("03483002", participant.get().account);
    }
}
