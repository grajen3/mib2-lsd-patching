/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;
import de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.RemoteProcessState_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class RemoteProcessState
extends ENIFunction
implements PropertyListener,
InternalServiceProvider {
    private static final int NO_OPERATION_RESULT;
    private static final int NO_OPERATION_TYPE;
    private int operationStatus;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener;

    private RemoteProcessServiceListener getRemoteProcessServiceListener() {
        return (RemoteProcessServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener = RemoteProcessState.class$("de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener);
    }

    private static int mapBapProcessState(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 5: {
                n2 = 3;
                break;
            }
            case 6: {
                n2 = 4;
                break;
            }
            case 7: {
                n2 = 5;
                break;
            }
            case 8: {
                n2 = 6;
                break;
            }
            case 4: {
                n2 = 7;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private static int mapToOperationResult(int n, int n2) {
        int n3;
        block0 : switch (n) {
            case 9: {
                n3 = 3;
                break;
            }
            case 4: {
                switch (n2) {
                    case 15: 
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: 
                    case 23: 
                    case 24: 
                    case 25: {
                        n3 = 5;
                        break block0;
                    }
                    case 16: 
                    case 28: {
                        n3 = 6;
                        break block0;
                    }
                    case 17: {
                        n3 = 13;
                        break block0;
                    }
                    case 18: {
                        n3 = 14;
                        break block0;
                    }
                    case 9: {
                        n3 = 7;
                        break block0;
                    }
                    case 10: {
                        n3 = 8;
                        break block0;
                    }
                    case 12: {
                        n3 = 9;
                        break block0;
                    }
                    case 13: {
                        n3 = 10;
                        break block0;
                    }
                    case 14: {
                        n3 = 11;
                        break block0;
                    }
                    case 1: 
                    case 7: 
                    case 8: 
                    case 11: {
                        n3 = 1;
                        break block0;
                    }
                }
                n3 = 1;
                break;
            }
            case 3: {
                n3 = 0;
                break;
            }
            default: {
                n3 = -1;
            }
        }
        return n3;
    }

    private static int mapToOperationType(int n) {
        int n2;
        switch (n) {
            case 3: {
                n2 = 0;
                break;
            }
            case 5: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 12: {
                n2 = 6;
                break;
            }
            case 13: {
                n2 = 8;
                break;
            }
            case 20: {
                n2 = 10;
                break;
            }
            case 21: {
                n2 = 9;
                break;
            }
            case 24: {
                n2 = 13;
                break;
            }
            case 19: {
                n2 = 12;
                break;
            }
            case 15: {
                n2 = 7;
                break;
            }
            case 11: {
                n2 = 5;
                break;
            }
            case 18: {
                n2 = 14;
                break;
            }
            case 16: {
                n2 = 11;
                break;
            }
            case 25: {
                n2 = 4;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    private void setProcessState(int n) {
        int n2 = RemoteProcessState.mapBapProcessState(n);
        if (this.operationStatus != n2) {
            this.operationStatus = n2;
            this.getRemoteProcessServiceListener().operationStatus(this.getProcessState());
        }
    }

    int getProcessState() {
        return this.operationStatus;
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        } else {
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener = RemoteProcessState.class$("de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener, RemoteProcessServiceListener.SERVICE_CONSTANTS);
        }
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return 20;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        RemoteProcessState_Status remoteProcessState_Status = (RemoteProcessState_Status)bAPEntity;
        int n = RemoteProcessState.mapToOperationType(remoteProcessState_Status.commandType);
        int n2 = RemoteProcessState.mapToOperationResult(remoteProcessState_Status.processState, remoteProcessState_Status.exceptionState);
        this.didChangeValue(bAPEntity);
        if (n2 != -1) {
            if (n != -1) {
                this.getRemoteProcessServiceListener().operationResult(n, n2);
                if (this.getLogger().isTraceEnabled(256)) {
                    this.getLogger().trace(256).append("ProcessStateResult operationType=").append(n).append(" result=").append(n2).log();
                }
            } else {
                this.getLogger().error(256).append("RemoteProcessState: got ambiguous operationType for operation bap processStae=").append(remoteProcessState_Status.processState).append(", bap commandType=").append(remoteProcessState_Status.commandType).log();
            }
        }
        this.setProcessState(remoteProcessState_Status.processState);
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (RemoteProcessServiceListener.SERVICE_CONSTANTS[0] == n) {
            this.getRemoteProcessServiceListener().operationStatus(this.getProcessState());
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

