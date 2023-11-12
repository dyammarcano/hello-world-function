package org.example.functions.dto;

import com.microsoft.applicationinsights.core.dependencies.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventDtoTest {

    @Test
    void test() {
        String message = "{\"topic\":\"/subscriptions/1e7956ea-ada5-4694-9839-ea6431b9af39/resourceGroups/rg-app-azure-function-examples-v2-231112124800/providers/Microsoft.Storage/storageAccounts/storageaccountfordatapoc\",\"subject\":\"/blobServices/default/containers/container1/blobs/New Folder/1 BU46LufhEIhxIt_BUyPaRQ.jpeg\",\"eventType\":\"Microsoft.Storage.BlobCreated\",\"id\":\"6b38e784-c01e-0091-3085-153e18060277\",\"data\":{\"api\":\"PutBlob\",\"clientRequestId\":\"d15c9f64-bca1-4814-694e-436283205d03\",\"requestId\":\"6b38e784-c01e-0091-3085-153e18000000\",\"eTag\":\"0x8DBE39CEED0418B\",\"contentType\":\"image/jpeg\",\"contentLength\":63905,\"blobType\":\"BlockBlob\",\"blobUrl\":\"https://storageaccountfordatapoc.blob.core.windows.net/container1/New Folder/1 BU46LufhEIhxIt_BUyPaRQ.jpeg\",\"url\":\"https://storageaccountfordatapoc.blob.core.windows.net/container1/New Folder/1 BU46LufhEIhxIt_BUyPaRQ.jpeg\",\"sequencer\":\"0000000000000000000000000003607b000000000000e055\",\"identity\":\"$superuser\",\"storageDiagnostics\":{\"batchId\":\"f5d1ef99-9006-0035-0085-1537be000000\"}},\"dataVersion\":\"\",\"metadataVersion\":\"1\",\"eventTime\":\"2023-11-12T16:32:16.4094003Z\"}";
        EventDto eventDto = new Gson().fromJson(message, EventDto.class);
        assertEquals("f5d1ef99-9006-0035-0085-1537be000000", eventDto.getData().getStorageDiagnostics().getBatchId());
    }
}