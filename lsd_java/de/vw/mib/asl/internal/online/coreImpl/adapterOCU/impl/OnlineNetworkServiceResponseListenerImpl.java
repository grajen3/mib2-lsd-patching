/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterOCU.impl;

import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationResult;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationStatus;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationType;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.CoreServiceOCUFactory;

public class OnlineNetworkServiceResponseListenerImpl
implements OnlineNetworkServiceResponseListener {
    @Override
    public void operationStatus(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceResponseListener$OperationStatus onlineNetworkServiceResponseListener$OperationStatus) {
    }

    @Override
    public void operationResult(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceResponseListener$OperationType onlineNetworkServiceResponseListener$OperationType, OnlineNetworkServiceResponseListener$OperationResult onlineNetworkServiceResponseListener$OperationResult) {
        switch (onlineNetworkServiceResponseListener$OperationType.value()) {
            case 0: {
                CoreServiceOCUFactory.getNotifier().validateOwnerResponse(this.getInternalResultValue(onlineNetworkServiceResponseListener$OperationType.value(), onlineNetworkServiceResponseListener$OperationResult.value()));
                break;
            }
            case 1: {
                CoreServiceOCUFactory.getNotifier().resetToFactorySettingsResponse(1, this.getInternalResultValue(onlineNetworkServiceResponseListener$OperationType.value(), onlineNetworkServiceResponseListener$OperationResult.value()));
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
        }
    }

    private int getInternalResultValue(int n, int n2) {
        int n3 = -1;
        block0 : switch (n) {
            case 0: {
                switch (n2) {
                    case 0: {
                        n3 = 0;
                        break block0;
                    }
                    case 1: {
                        n3 = 35;
                        break block0;
                    }
                    case 2: {
                        n3 = 35;
                        break block0;
                    }
                    case 3: {
                        n3 = 38;
                        break block0;
                    }
                    case 4: {
                        n3 = 34;
                        break block0;
                    }
                    case 6: {
                        n3 = 37;
                        break block0;
                    }
                    case 7: {
                        n3 = 37;
                        break block0;
                    }
                    case 8: {
                        n3 = 37;
                        break block0;
                    }
                    case 11: {
                        n3 = 33;
                        break block0;
                    }
                    case 12: {
                        n3 = 38;
                        break block0;
                    }
                    case 13: {
                        n3 = 36;
                        break block0;
                    }
                }
                n3 = 35;
                break;
            }
            case 1: {
                switch (n2) {
                    case 0: {
                        n3 = 0;
                        break block0;
                    }
                    case 1: {
                        n3 = 29;
                        break block0;
                    }
                    case 2: {
                        n3 = 31;
                        break block0;
                    }
                    case 3: {
                        n3 = 32;
                        break block0;
                    }
                }
                break;
            }
        }
        return n3;
    }
}

