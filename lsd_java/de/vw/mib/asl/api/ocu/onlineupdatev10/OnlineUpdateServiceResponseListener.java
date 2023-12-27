/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlineupdatev10;

import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateService;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceResponseListener$OperationResult;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceResponseListener$OperationStatus;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceResponseListener$OperationType;

public interface OnlineUpdateServiceResponseListener {
    default public void operationResult(OnlineUpdateService onlineUpdateService, OnlineUpdateServiceResponseListener$OperationType onlineUpdateServiceResponseListener$OperationType, OnlineUpdateServiceResponseListener$OperationResult onlineUpdateServiceResponseListener$OperationResult) {
    }

    default public void operationStatus(OnlineUpdateService onlineUpdateService, OnlineUpdateServiceResponseListener$OperationStatus onlineUpdateServiceResponseListener$OperationStatus) {
    }
}

