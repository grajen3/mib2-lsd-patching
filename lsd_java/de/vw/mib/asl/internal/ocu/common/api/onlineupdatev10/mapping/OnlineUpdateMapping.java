/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.mapping;

import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState$UpdateState;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums.OnlineUpdateListState;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums.OperationResult;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums.OperationStatus;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums.OperationType;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums.UpdateState;

public class OnlineUpdateMapping {
    public static OnlineUpdateListState mapEniOnlineUpdateListState(int n) {
        OnlineUpdateListState onlineUpdateListState;
        switch (n) {
            case 3: {
                onlineUpdateListState = OnlineUpdateListState.ENUM_LOADED;
                break;
            }
            case 2: {
                onlineUpdateListState = OnlineUpdateListState.ENUM_LOADING;
                break;
            }
            case 4: {
                onlineUpdateListState = OnlineUpdateListState.ENUM_ERROR;
                break;
            }
            case 1: {
                onlineUpdateListState = OnlineUpdateListState.ENUM_NOT_AVAILABLE;
                break;
            }
            default: {
                throw new UnsupportedOperationException(new StringBuffer().append("Wrong updateListState mapping value given: updateListState=").append(n).toString());
            }
        }
        return onlineUpdateListState;
    }

    public static OnlineUpdateState$UpdateState mapEniUpdateState(int n, int n2, int n3, int n4) {
        UpdateState updateState;
        block20: {
            block19: {
                if (n3 != 4) break block19;
                switch (n4) {
                    case 15: 
                    case 17: 
                    case 18: 
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: 
                    case 23: 
                    case 24: 
                    case 25: {
                        updateState = UpdateState.ENUM_SPIN_INVALID;
                        break block20;
                    }
                    case 16: 
                    case 28: {
                        updateState = UpdateState.ENUM_SPIN_FAILED;
                        break block20;
                    }
                    case 1: 
                    case 7: 
                    case 8: 
                    case 9: 
                    case 10: 
                    case 11: 
                    case 12: 
                    case 13: 
                    case 14: {
                        updateState = UpdateState.ENUM_SPIN_ERROR;
                        break block20;
                    }
                    default: {
                        throw new UnsupportedOperationException(new StringBuffer().append("There combination of the processState ").append(n3).append(" and the exceptionState ").append(n4).append(" is invalid.").toString());
                    }
                }
            }
            switch (n) {
                case 0: 
                case 1: 
                case 20: {
                    updateState = UpdateState.ENUM_NO_UPDATE_AVAILABLE;
                    break;
                }
                case 2: 
                case 22: {
                    updateState = UpdateState.ENUM_DOWNLOAD_CONFIRM_PENDING;
                    break;
                }
                case 6: {
                    updateState = UpdateState.ENUM_DOWNLOAD_RUNNING;
                    break;
                }
                case 9: {
                    updateState = UpdateState.ENUM_INSTALLATION_CONFIRM_PENDING;
                    break;
                }
                case 8: {
                    updateState = UpdateState.ENUM_DOWNLOAD_ERROR_CONFIRM_PENDING;
                    break;
                }
                case 19: 
                case 25: {
                    updateState = UpdateState.ENUM_DOWNLOAD_WITHDRAWN_CONFIRM_PENDING;
                    break;
                }
                case 13: {
                    updateState = UpdateState.ENUM_INSTALLATION_RUNNING;
                    break;
                }
                case 15: {
                    updateState = UpdateState.ENUM_INSTALLATION_FINISHED_CONFIRM_PENDING;
                    break;
                }
                case 14: {
                    if (n2 == 28) {
                        updateState = UpdateState.ENUM_INSTALLATION_FATAL_ERROR_CONFIRM_PENDING;
                        break;
                    }
                    if (n2 == 27) {
                        updateState = UpdateState.ENUM_INSTALLATION_ERROR_CONFIRM_PENDING;
                        break;
                    }
                    updateState = UpdateState.ENUM_NO_UPDATE_AVAILABLE;
                    break;
                }
                case 24: {
                    updateState = UpdateState.ENUM_INSTALLATION_PRECONDITION_NOT_MET;
                    break;
                }
                default: {
                    updateState = UpdateState.ENUM_NO_UPDATE_AVAILABLE;
                }
            }
        }
        return updateState;
    }

    public static OperationStatus mapEniOperationStatus(int n) {
        OperationStatus operationStatus;
        switch (n) {
            case 0: 
            case 7: {
                operationStatus = OperationStatus.ENUM_NO_INFORMATION;
                break;
            }
            case 1: {
                operationStatus = OperationStatus.ENUM_NO_REQUEST_ACTIVE;
                break;
            }
            case 2: {
                operationStatus = OperationStatus.ENUM_IN_PROGRESS;
                break;
            }
            case 4: {
                operationStatus = OperationStatus.ENUM_CONNECTING_TO_SERVER;
                break;
            }
            case 5: {
                operationStatus = OperationStatus.ENUM_WAITING_FOR_AUTHENTICATION;
                break;
            }
            case 6: {
                operationStatus = OperationStatus.ENUM_DATA_TRANSMISSION;
                break;
            }
            default: {
                throw new UnsupportedOperationException(new StringBuffer().append("Wrong operationStatus mapping value given: operationStatus=").append(n).toString());
            }
        }
        return operationStatus;
    }

    public static OperationType mapEniOperationType(int n) {
        OperationType operationType;
        switch (n) {
            case 5: {
                operationType = OperationType.ENUM_POSTPONE_ONLINE_DOWNLOAD;
                break;
            }
            case 6: {
                operationType = OperationType.ENUM_AUTHENTICATE_ONLINE_DOWNLOAD;
                break;
            }
            case 7: {
                operationType = OperationType.ENUM_POSTPONE_UPDATE_INSTALLATION;
                break;
            }
            case 8: {
                operationType = OperationType.ENUM_CONFIRM_UPDATE_INSTALLATION;
                break;
            }
            case 9: {
                operationType = OperationType.ENUM_CONFIRM_UPDATE_ERROR;
                break;
            }
            case 10: {
                operationType = OperationType.ENUM_CONFIRM_INSTALLATION_FINISHED;
                break;
            }
            case 12: {
                operationType = OperationType.ENUM_REQUEST_CHALLENGE;
                break;
            }
            case 13: {
                operationType = OperationType.ENUM_CONFIRM_UPDATE_WITHDRAWN;
                break;
            }
            case 11: {
                operationType = OperationType.ENUM_NO_OPERATION;
                break;
            }
            default: {
                throw new UnsupportedOperationException(new StringBuffer().append("Wrong operationType mapping value given: operationType=").append(n).toString());
            }
        }
        return operationType;
    }

    public static OperationResult mapEniOperationResult(int n) {
        OperationResult operationResult;
        switch (n) {
            case 0: {
                operationResult = OperationResult.ENUM_SUCCESSFUL;
                break;
            }
            case 1: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                operationResult = OperationResult.ENUM_NOT_SUCCESSFUL;
                break;
            }
            case 2: {
                operationResult = OperationResult.ENUM_NOT_SUCCESSFUL_SERVICE_BUSY;
                break;
            }
            case 4: {
                operationResult = OperationResult.ENUM_NOT_SUCCESSFUL_ILLEGAL_OPERATION;
                break;
            }
            default: {
                throw new UnsupportedOperationException(new StringBuffer().append("Wrong operationResult mapping value given: operationResult=").append(n).toString());
            }
        }
        return operationResult;
    }

    public static long mapDownloadSize(int n, int n2) {
        long l;
        switch (n2) {
            case 2: {
                l = n << 10;
                break;
            }
            case 3: {
                l = n << 20;
                break;
            }
            case 4: {
                l = n << 30;
                break;
            }
            case 5: {
                l = n << 40;
                break;
            }
            default: {
                l = n;
            }
        }
        return l / 0;
    }
}

