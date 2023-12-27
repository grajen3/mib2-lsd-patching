/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.ecall.api.model.ModelOcuTestMode;
import de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneDialOcuCall;
import de.vw.mib.asl.internal.ocu.ecall.functions.CallState;
import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.asl.internal.ocu.ecall.functions.HangupCall;
import de.vw.mib.asl.internal.ocu.ecall.functions.ServiceRequest;
import de.vw.mib.asl.internal.ocu.ecall.functions.ServiceState;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.ServiceControl_Result;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.ServiceControl_StartResult;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;

public final class ServiceControl
extends ECallFunction
implements MethodListener,
ModelPhoneDialOcuCall,
ModelOcuTestMode {
    private boolean _operationRunning;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneDialOcuCall;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelOcuTestMode;

    private boolean isOperationRunning() {
        return this._operationRunning;
    }

    private void setOperationRunning(boolean bl) {
        this._operationRunning = bl;
    }

    private ServiceRequest getServiceRequest() {
        return (ServiceRequest)this.getDelegate().getBAPFunctionListener(24);
    }

    private CallState getCallState() {
        return (CallState)this.getDelegate().getBAPFunctionListener(17);
    }

    private boolean isECallManual112Present() {
        return this.getCallState().isECallManual112Present();
    }

    private HangupCall getHangupCall() {
        return (HangupCall)this.getDelegate().getBAPFunctionListener(18);
    }

    @Override
    public void initialize(boolean bl) {
        if (!bl) {
            this.getDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneDialOcuCall == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneDialOcuCall = ServiceControl.class$("de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneDialOcuCall")) : class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneDialOcuCall, ModelPhoneDialOcuCall.SERVICE_CONSTANTS);
            this.getDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelOcuTestMode == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelOcuTestMode = ServiceControl.class$("de.vw.mib.asl.internal.ocu.ecall.api.model.ModelOcuTestMode")) : class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelOcuTestMode, ModelOcuTestMode.SERVICE_CONSTANTS);
        } else {
            this.setOperationRunning(false);
        }
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return 25;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
        this.setOperationRunning(false);
        this.getLogger().error(512).append("Starting service control failed bapErrorCode=").append(n).log();
    }

    @Override
    public void result(BAPEntity bAPEntity, Method method) {
        this.setOperationRunning(false);
        if (this.getLogger().isTraceEnabled(512)) {
            ServiceControl_Result serviceControl_Result = (ServiceControl_Result)bAPEntity;
            this.getLogger().trace(512).append("ServiceControl: Operation service control finished with controlResult=").append(serviceControl_Result.controlResult).log();
        }
    }

    private void triggerServiceControlStartResult(int n, int n2) {
        ServiceControl_StartResult serviceControl_StartResult = new ServiceControl_StartResult();
        serviceControl_StartResult.serviceType = n;
        serviceControl_StartResult.controlCode = n2;
        this.getDelegate().getMethod(this).startResult(serviceControl_StartResult, this);
    }

    private void dialBreakDownCall() {
        this.triggerServiceControlStartResult(1, 3);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512, "ServiceControl: Start dialing of breakdown call");
        }
    }

    private void dialEmergencyCall() {
        this.triggerServiceControlStartResult(5, 3);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512, "ServiceControl: Start dialing of emergency call");
        }
    }

    private void dialInfoCall() {
        this.triggerServiceControlStartResult(3, 3);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512, "ServiceControl: Start dialing of info call");
        }
    }

    private void denyOcuServiceConfirmation() {
        this.triggerServiceControlStartResult(255, 1);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512, "ServiceControl: Deny all services");
        }
    }

    private void denyOcuMecConfirmation() {
        this.triggerServiceControlStartResult(5, 1);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512, "ServiceControl: Deny MEC confirmation");
        }
    }

    private boolean isTerminationOfServicePossible() {
        ServiceState serviceState = (ServiceState)this.getDelegate().getBAPFunctionListener(26);
        return serviceState.getOcuMenuServiceType() == 2 && serviceState.getServiceType() != 0;
    }

    private void terminateCurrentService() {
        ServiceState serviceState = (ServiceState)this.getDelegate().getBAPFunctionListener(26);
        this.triggerServiceControlStartResult(serviceState.getServiceType(), 2);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512, "ServiceControl: Terminate current service");
        }
    }

    private void confirmPendingEmergencyCall() {
        this.triggerServiceControlStartResult(5, 0);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512, "ServiceControl: Start dialing of emergency call");
        }
    }

    void confirmPendingServiceBreakDownCall() {
        if (!this.isOperationRunning()) {
            this.triggerServiceControlStartResult(1, 0);
            if (this.getLogger().isTraceEnabled(512)) {
                this.getLogger().trace(512, "ServiceControl: Confirm pending service breakdown call");
            }
        } else {
            this.getLogger().error(512, "ServiceControl: Can't confirm pending service breakdown call because operation is still in progress");
        }
    }

    void confirmPendingInfoCall() {
        if (!this.isOperationRunning()) {
            this.triggerServiceControlStartResult(3, 0);
            if (this.getLogger().isTraceEnabled(512)) {
                this.getLogger().trace(512, "ServiceControl: Confirm pending info call");
            }
        } else {
            this.getLogger().error(512, "ServiceControl: Can't confirm pending service call because operation is still in progress");
        }
    }

    void abortAnNotYetEstablishedService() {
        if (!this.isOperationRunning()) {
            if (this.isTerminationOfServicePossible()) {
                this.terminateCurrentService();
                this.setOperationRunning(true);
            } else {
                this.getLogger().error(512, "ServiceControl: Skipped terminate not yet established service, because there is no service to terminate");
            }
        } else {
            this.getLogger().error(512, "ServiceControl: Can't terminate not yet established service, because operation is still in progress");
        }
    }

    @Override
    public void dialServiceNumber() {
        if (!this.isOperationRunning()) {
            if (this.getServiceRequest().isUsmConfirmationPending()) {
                this.confirmPendingServiceBreakDownCall();
            } else {
                this.dialBreakDownCall();
            }
            this.setOperationRunning(true);
        } else {
            this.getLogger().error(512, "ServiceControl: Can't dial service number of because operation is still in progress");
        }
    }

    @Override
    public void dialEmergencyNumber() {
        if (!this.isOperationRunning()) {
            if (this.getServiceRequest().isUsmConfirmationPending()) {
                this.confirmPendingEmergencyCall();
            } else {
                this.dialEmergencyCall();
            }
            this.setOperationRunning(true);
        } else {
            this.getLogger().error(512, "ServiceControl: Can't dial emergency number of because operation is still in progress");
        }
    }

    @Override
    public void dialInfoNumber() {
        if (!this.isOperationRunning()) {
            this.dialInfoCall();
            this.setOperationRunning(true);
        } else {
            this.getLogger().error(512, "ServiceControl: Can't dial info number of because operation is still in progress");
        }
    }

    @Override
    public void denyAllServicesConfirmations() {
        if (!this.isOperationRunning()) {
            this.denyOcuServiceConfirmation();
            this.setOperationRunning(true);
        } else {
            this.getLogger().error(512, "ServiceControl: Can't deny all services, because operation is still in progress");
        }
    }

    @Override
    public void abortService() {
        if (!this.isOperationRunning()) {
            if (this.isTerminationOfServicePossible()) {
                this.terminateCurrentService();
                this.setOperationRunning(true);
            } else if (this.isECallManual112Present()) {
                this.getHangupCall().hangupOcuCall();
            } else {
                this.getHangupCall().hangupOcuCall();
                this.getLogger().error(512, "ServiceControl: Skipped terminate MEC service, because there is no service to terminate, try to hangup call");
            }
        } else {
            this.getLogger().error(512, "ServiceControl: Can't terminate service, because operation is still in progress");
        }
    }

    @Override
    public void confirmEmergencyConfirmation() {
        if (!this.isOperationRunning()) {
            this.confirmPendingEmergencyCall();
            this.setOperationRunning(true);
        } else {
            this.getLogger().error(512, "ServiceControl: Can't confirm emergency confirmation, because operation is still in progress");
        }
    }

    @Override
    public void abortEmergencyConfirmation() {
        if (!this.isOperationRunning()) {
            this.denyOcuMecConfirmation();
            this.setOperationRunning(true);
        } else {
            this.getLogger().error(512, "ServiceControl: Can't abort emergency confirmation, because operation is still in progress");
        }
    }

    @Override
    public void triggerOcuServiceMode() {
        if (!this.isOperationRunning()) {
            this.triggerServiceControlStartResult(6, 3);
            if (this.getLogger().isTraceEnabled(512)) {
                this.getLogger().trace(512, "ServiceControl: Trigger test mode");
            }
        } else {
            this.getLogger().error(512, "ServiceControl: Can't trigger test mode, because operation is still in progress");
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

