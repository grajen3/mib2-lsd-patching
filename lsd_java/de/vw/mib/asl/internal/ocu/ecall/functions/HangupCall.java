/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.ecall.api.asl.AudioManagementServiceListener;
import de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCall;
import de.vw.mib.asl.internal.ocu.ecall.functions.CallState;
import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.asl.internal.ocu.ecall.functions.ServiceControl;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.HangupCall_StartResult;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.log4mib.LogMessage;

public final class HangupCall
extends ECallFunction
implements MethodListener,
ModelPhoneOcuCall,
AudioManagementServiceListener {
    private static final int CALL_ID_NOT_FOUND;
    private boolean _hangupRunning;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCall;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener;

    private boolean isHangupRunning() {
        return this._hangupRunning;
    }

    private void setHangupRunning(boolean bl) {
        this._hangupRunning = bl;
    }

    private ServiceControl getServiceControl() {
        return (ServiceControl)this.getDelegate().getBAPFunctionListener(25);
    }

    @Override
    public void initialize(boolean bl) {
        if (!bl) {
            this.getDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCall == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCall = HangupCall.class$("de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCall")) : class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCall, ModelPhoneOcuCall.SERVICE_CONSTANTS);
            this.getDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener = HangupCall.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.AudioManagementServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener, AudioManagementServiceListener.AUDIO_MANAGEMENT_SERVICE_CONSTANTS);
        } else {
            this.setHangupRunning(false);
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
        this.setHangupRunning(false);
        this.getLogger().error(512).append("Starting hangup call failed bapErrorCode=").append(n).log();
    }

    @Override
    public void result(BAPEntity bAPEntity, Method method) {
        this.setHangupRunning(false);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512, "Hangup a OCU call by user finished successful");
        }
    }

    @Override
    public void hangupOcuCall() {
        LogMessage logMessage = this._tryToHangupOcuCall();
        if (logMessage != null) {
            if (!this.isHangupRunning()) {
                this.getServiceControl().abortAnNotYetEstablishedService();
            }
            logMessage.log();
        }
    }

    @Override
    public void audioConnectionReleased(int n) {
    }

    @Override
    public void audioConnectionStarted(int n) {
        if (n == 104 || n == 99) {
            CallState callState = (CallState)this.getDelegate().getBAPFunctionListener(17);
            if (!callState.isOcuAcnCallActive()) {
                this._tryToHangupOcuCall();
            } else if (this.getLogger().isTraceEnabled(512)) {
                this.getLogger().trace(512, "Incoming HFP call during OCU ACN call detected. Ignore the HFP call, do nothing");
            }
        }
    }

    @Override
    public void audioUserMuteIsActive(boolean bl, boolean bl2) {
        if (bl && bl2) {
            this.audioConnectionStarted(8);
        }
    }

    @Override
    public void audioManagementStatus(int n) {
    }

    @Override
    public void requestConnectionAcknowledge(int n) {
    }

    private LogMessage _tryToHangupOcuCall() {
        LogMessage logMessage;
        if (!this.isHangupRunning()) {
            boolean bl;
            int n = this.getActiveCallId();
            boolean bl2 = bl = n != -1;
            if (bl) {
                this._hangupOcuCall(n);
                logMessage = null;
            } else {
                logMessage = this.getLogger().error(512).append("Tried to hangup a OCU call from model, but no call is active");
            }
        } else {
            logMessage = this.getLogger().error(512).append("Tried to hangup a OCU call from model, but hangup is already running activeCallId=").append(this.getActiveCallId());
        }
        return logMessage;
    }

    private void _hangupOcuCall(int n) {
        HangupCall_StartResult hangupCall_StartResult = new HangupCall_StartResult();
        hangupCall_StartResult.callId = n;
        this.getDelegate().getMethod(this).startResult(hangupCall_StartResult, this);
        this.setHangupRunning(true);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("Perform a hangup of OCU call with callId=").append(n).log();
        }
    }

    private int getActiveCallId() {
        CallState callState = (CallState)this.getDelegate().getBAPFunctionListener(17);
        int[] nArray = callState.getOcuCallStates();
        int n = -1;
        if (callState != null && nArray != null) {
            int n2 = nArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (nArray[i2] != 2 && nArray[i2] != 3) continue;
                n = i2;
            }
        }
        return n;
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

