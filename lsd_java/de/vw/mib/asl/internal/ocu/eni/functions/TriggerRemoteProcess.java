/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessService;
import de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener;
import de.vw.mib.asl.internal.ocu.eni.functions.CurrentOnlineUpdateState;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.eni.functions.RemoteProcessState;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.TriggerRemoteProcess_Result;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.TriggerRemoteProcess_StartResult;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;

public final class TriggerRemoteProcess
extends ENIFunction
implements MethodListener,
RemoteProcessService {
    private static final int AUTHORIZATION_TYPE;
    private static final int NO_OPERATION_PENDING;
    private int _remoteProcessOperation;
    private String _lastOnlineUpdateId;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessService;

    private RemoteProcessServiceListener getRemoteProcessServiceListener() {
        return (RemoteProcessServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener = TriggerRemoteProcess.class$("de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener);
    }

    private int getRemoteProcessState() {
        RemoteProcessState remoteProcessState = (RemoteProcessState)this.getDelegate().getBAPFunctionListener(20);
        return remoteProcessState.getProcessState();
    }

    private boolean isRemoteProcessRunning() {
        return this.getRemoteProcessOperation() != -1;
    }

    private int getRemoteProcessOperation() {
        return this._remoteProcessOperation;
    }

    private void setRemoteProcessOperation(int n) {
        this._remoteProcessOperation = n;
    }

    public static char[] convertHexStringToCharArray(String string) {
        int n = string.length();
        char[] cArray = new char[n / 2];
        for (int i2 = 0; i2 < n; i2 += 2) {
            cArray[i2 / 2] = (char)((Character.digit(string.charAt(i2), 16) << 4) + Character.digit(string.charAt(i2 + 1), 16));
        }
        return cArray;
    }

    @Override
    public void initialize(boolean bl) {
        if (!bl) {
            this.getDelegate().registerServiceProvider(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessService == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessService = TriggerRemoteProcess.class$("de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessService")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessService, RemoteProcessService.SERVICE_CONSTANTS);
        } else {
            this.setRemoteProcessOperation(-1);
            this.confirmUpdateInstallation(this._lastOnlineUpdateId);
        }
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return 18;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
        if (this.isRemoteProcessRunning()) {
            int n2 = this.getRemoteProcessOperation();
            this.setRemoteProcessOperation(-1);
            this.getRemoteProcessServiceListener().operationResult(n2, 1);
        }
        this.getLogger().error(256).append("Trigger remote process failed bapErrorCode=").append(n).log();
    }

    @Override
    public void result(BAPEntity bAPEntity, Method method) {
        int n = this.getRemoteProcessOperation();
        this.setRemoteProcessOperation(-1);
        TriggerRemoteProcess_Result triggerRemoteProcess_Result = (TriggerRemoteProcess_Result)bAPEntity;
        if (triggerRemoteProcess_Result.getResultCode() != 0) {
            this.getRemoteProcessServiceListener().operationResult(n, 1);
        } else {
            switch (n) {
                case 5: 
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 13: {
                    this.getRemoteProcessServiceListener().operationResult(n, 0);
                    break;
                }
            }
        }
        if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256, "Trigger remote process finished");
        }
    }

    @Override
    public void serviceListenerRegistered(int n) {
    }

    private boolean remoteProcessPreconditionsMetForOperationType(int n) {
        boolean bl;
        CurrentOnlineUpdateState currentOnlineUpdateState = (CurrentOnlineUpdateState)this.getDelegate().getBAPFunctionListener(36);
        if (currentOnlineUpdateState == null || this.isRemoteProcessRunning() || this.getRemoteProcessState() != 1 && this.getRemoteProcessState() != 0) {
            this.getRemoteProcessServiceListener().operationResult(n, 2);
            bl = false;
            this.getLogger().warn(256).append("TriggerRemoteProcess: Trigger remote process operationType=").append(n).append(", can't be executed because preconditions are not met").log();
        } else {
            bl = true;
        }
        return bl;
    }

    private void startRemoteProcess(int n, int n2, String string, String string2) {
        BAPString bAPString = new BAPString(-129);
        bAPString.setContent(string2);
        this.startRemoteProcess(n, n2, string, bAPString);
    }

    private void startRemoteProcess(int n, int n2, String string, BAPString bAPString) {
        TriggerRemoteProcess_StartResult triggerRemoteProcess_StartResult = new TriggerRemoteProcess_StartResult();
        triggerRemoteProcess_StartResult.commandType = n;
        triggerRemoteProcess_StartResult.param1 = n2;
        triggerRemoteProcess_StartResult.param2.setContent(string);
        triggerRemoteProcess_StartResult.param3.setContent(bAPString);
        this.getDelegate().getMethod(this).startResult(triggerRemoteProcess_StartResult, this);
    }

    @Override
    public void confirmServiceExpiryWarning(String string) {
        if (this.remoteProcessPreconditionsMetForOperationType(2)) {
            this.startRemoteProcess(5, 1, string, "");
            this.setRemoteProcessOperation(2);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'confirmServiceExpiryWarning' started serviceId=").append(string).log();
            }
        }
    }

    @Override
    public void confirmServiceExpiryWarnings() {
        if (this.remoteProcessPreconditionsMetForOperationType(3)) {
            this.startRemoteProcess(5, 0, "", "");
            this.setRemoteProcessOperation(3);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'confirmServiceExpiryWarnings' started").log();
            }
        }
    }

    @Override
    public void pairMainUser(String string, String string2) {
        if (this.remoteProcessPreconditionsMetForOperationType(0)) {
            this.startRemoteProcess(3, 0, string, string2);
            this.setRemoteProcessOperation(0);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'pairMainUser' started user=").append(string).append(", carNetPin=").append(string2).log();
            }
        }
    }

    @Override
    public void restoreFactorySettings() {
        if (this.remoteProcessPreconditionsMetForOperationType(1)) {
            this.startRemoteProcess(2, 0, "", "");
            this.setRemoteProcessOperation(1);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'restoreFactorySettings' started").log();
            }
        }
    }

    @Override
    public void sendLocalServiceStateListRequest() {
        if (this.remoteProcessPreconditionsMetForOperationType(4)) {
            this.startRemoteProcess(25, 0, "", "");
            this.setRemoteProcessOperation(4);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'sendLocalServiceStateList' started").log();
            }
        }
    }

    @Override
    public void authenticateOnlineDownload(String string) {
        if (this.remoteProcessPreconditionsMetForOperationType(6)) {
            BAPString bAPString = new BAPString(-129);
            if (string.length() > 0) {
                bAPString.setRawContent();
                bAPString.setContent(new String(TriggerRemoteProcess.convertHexStringToCharArray(string)));
            } else {
                bAPString.setNullString();
            }
            this.startRemoteProcess(12, 0, "", bAPString);
            this.setRemoteProcessOperation(6);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'authenticate main user' started with hashed SPIN ").append(string).log();
            }
        }
    }

    @Override
    public void confirmDownloadError(String string) {
        if (this.remoteProcessPreconditionsMetForOperationType(9)) {
            this.startRemoteProcess(21, 0, string, "");
            this.setRemoteProcessOperation(9);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'confirm download error' started updateId=").append(string).log();
            }
        }
    }

    @Override
    public void confirmInstallationError(String string) {
        if (this.remoteProcessPreconditionsMetForOperationType(9)) {
            this.startRemoteProcess(21, 0, string, "");
            this.setRemoteProcessOperation(9);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'confirm installation error' started updateId=").append(string).log();
            }
        }
    }

    @Override
    public void confirmInstallationFinished(String string) {
        if (this.remoteProcessPreconditionsMetForOperationType(10)) {
            this.startRemoteProcess(20, 0, string, "");
            this.setRemoteProcessOperation(10);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'confirm ECU update finished successfully' started updateId=").append(string).log();
            }
        }
    }

    @Override
    public void confirmUpdateInstallation(String string) {
        if (this.getDelegate().isInitialized(this)) {
            if (this.remoteProcessPreconditionsMetForOperationType(8)) {
                this.startRemoteProcess(13, 0, string, "");
                this.setRemoteProcessOperation(8);
                if (this.getLogger().isTraceEnabled(256)) {
                    this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'confirm ECU update' started updateId=").append(string).log();
                }
            }
        } else {
            this._lastOnlineUpdateId = string;
        }
    }

    @Override
    public void confirmUpdateWithdrawn(String string) {
        if (this.remoteProcessPreconditionsMetForOperationType(13)) {
            this.startRemoteProcess(24, 0, string, "");
            this.setRemoteProcessOperation(13);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'confirm withdrawn update' started updateId=").append(string).log();
            }
        }
    }

    @Override
    public void postponeOnlineDownload(String string, String string2) {
        if (this.remoteProcessPreconditionsMetForOperationType(5)) {
            this.startRemoteProcess(11, 0, string, string2);
            this.setRemoteProcessOperation(5);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'postpone online update download' started updateId=").append(string).log();
            }
        }
    }

    @Override
    public void postponeUpdateInstallation(String string, String string2) {
        if (this.remoteProcessPreconditionsMetForOperationType(7)) {
            this.startRemoteProcess(15, 0, string, string2);
            this.setRemoteProcessOperation(7);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'postpone ECU update' started updateId=").append(string).log();
            }
        }
    }

    @Override
    public void requestNewLanguage(String string, int n) {
        if (this.remoteProcessPreconditionsMetForOperationType(11)) {
            this.startRemoteProcess(16, n, string, "");
            this.setRemoteProcessOperation(11);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'request new language' started with language=").append(n).log();
            }
        }
    }

    @Override
    public void getChallenge() {
        if (this.remoteProcessPreconditionsMetForOperationType(12)) {
            this.startRemoteProcess(19, 256, "", "");
            this.setRemoteProcessOperation(12);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'get challenge' started ").log();
            }
        }
    }

    @Override
    public void setPrivacyModeActive(boolean bl) {
        if (this.remoteProcessPreconditionsMetForOperationType(14)) {
            if (bl) {
                this.startRemoteProcess(18, 0, "", "");
            } else {
                this.startRemoteProcess(18, 1, "", "");
            }
            this.setRemoteProcessOperation(14);
            if (this.getLogger().isTraceEnabled(256)) {
                this.getLogger().trace(256).append("TriggerRemoteProcess: Trigger remote process 'set privacy mode' started ").log();
            }
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

