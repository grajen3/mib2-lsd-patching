/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.impl;

import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateService;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceResponseListener;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceResponseListener$OperationResult;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceResponseListener$OperationStatus;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceResponseListener$OperationType;
import de.vw.mib.asl.internal.online.ocu.OCUUpdateServiceFactory;
import de.vw.mib.asl.internal.online.ocu.states.OCUUpdateServiceTarget;

public class OCUUpdateServiceResponseListener
implements OnlineUpdateServiceResponseListener {
    private final OCUUpdateServiceTarget _target;

    public OCUUpdateServiceResponseListener(OCUUpdateServiceTarget oCUUpdateServiceTarget) {
        this._target = oCUUpdateServiceTarget;
    }

    private int getInternalResultValue(int n, int n2) {
        int n3 = -1;
        switch (n2) {
            case 0: {
                n3 = 0;
                break;
            }
            case 1: {
                n3 = 1;
                break;
            }
            case 2: {
                n3 = 2;
                break;
            }
            case 3: {
                n3 = 3;
                break;
            }
            default: {
                n3 = -1;
            }
        }
        return n3;
    }

    @Override
    public void operationResult(OnlineUpdateService onlineUpdateService, OnlineUpdateServiceResponseListener$OperationType onlineUpdateServiceResponseListener$OperationType, OnlineUpdateServiceResponseListener$OperationResult onlineUpdateServiceResponseListener$OperationResult) {
        switch (onlineUpdateServiceResponseListener$OperationType.value()) {
            case 2: {
                OCUUpdateServiceFactory.getController(this._target).authenticateOnlineDownloadResponse(onlineUpdateService, this.getInternalResultValue(onlineUpdateServiceResponseListener$OperationType.value(), onlineUpdateServiceResponseListener$OperationResult.value()));
                break;
            }
            case 5: {
                OCUUpdateServiceFactory.getController(this._target).confirmUpdateInstallationResponse(onlineUpdateService, this.getInternalResultValue(onlineUpdateServiceResponseListener$OperationType.value(), onlineUpdateServiceResponseListener$OperationResult.value()));
                break;
            }
            case 7: {
                OCUUpdateServiceFactory.getController(this._target).confirmErrorResponse(onlineUpdateService, this.getInternalResultValue(onlineUpdateServiceResponseListener$OperationType.value(), onlineUpdateServiceResponseListener$OperationResult.value()));
                break;
            }
            case 8: {
                OCUUpdateServiceFactory.getController(this._target).confirmInstallationFinishedResponse(onlineUpdateService, this.getInternalResultValue(onlineUpdateServiceResponseListener$OperationType.value(), onlineUpdateServiceResponseListener$OperationResult.value()));
                break;
            }
            case 4: {
                OCUUpdateServiceFactory.getController(this._target).postponeUpdateInstallationResponse(onlineUpdateService, this.getInternalResultValue(onlineUpdateServiceResponseListener$OperationType.value(), onlineUpdateServiceResponseListener$OperationResult.value()));
                break;
            }
            case 1: {
                OCUUpdateServiceFactory.getController(this._target).postponeOnlineDownloadResponse(onlineUpdateService, this.getInternalResultValue(onlineUpdateServiceResponseListener$OperationType.value(), onlineUpdateServiceResponseListener$OperationResult.value()));
                break;
            }
            case 9: {
                OCUUpdateServiceFactory.getController(this._target).confirmUpdateWithdrawnResponse(onlineUpdateService, this.getInternalResultValue(onlineUpdateServiceResponseListener$OperationType.value(), onlineUpdateServiceResponseListener$OperationResult.value()));
                break;
            }
            case 10: {
                OCUUpdateServiceFactory.getController(this._target).requestChallengeResponse(onlineUpdateService, this.getInternalResultValue(onlineUpdateServiceResponseListener$OperationType.value(), onlineUpdateServiceResponseListener$OperationResult.value()));
                break;
            }
            case 0: {
                break;
            }
        }
    }

    @Override
    public void operationStatus(OnlineUpdateService onlineUpdateService, OnlineUpdateServiceResponseListener.OperationStatus operationStatus) {
    }
}

