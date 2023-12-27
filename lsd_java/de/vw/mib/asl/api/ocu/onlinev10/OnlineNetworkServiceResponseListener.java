/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlinev10;

import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationResult;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationStatus;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationType;

public interface OnlineNetworkServiceResponseListener {
    default public void operationStatus(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceResponseListener$OperationStatus onlineNetworkServiceResponseListener$OperationStatus) {
    }

    default public void operationResult(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceResponseListener$OperationType onlineNetworkServiceResponseListener$OperationType, OnlineNetworkServiceResponseListener$OperationResult onlineNetworkServiceResponseListener$OperationResult) {
    }
}

