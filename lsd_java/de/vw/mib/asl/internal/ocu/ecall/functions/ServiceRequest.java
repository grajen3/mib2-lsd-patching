/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener;
import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.asl.internal.ocu.ecall.functions.ServiceControl;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.ServiceRequest_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class ServiceRequest
extends ECallFunction
implements PropertyListener {
    private boolean _isUsmConfirmationPending;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener;

    private ModelPhoneOcuCallListener getModelPhoneOcuCallListener() {
        return (ModelPhoneOcuCallListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener = ServiceRequest.class$("de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener);
    }

    private ServiceControl getServiceControl() {
        return (ServiceControl)this.getDelegate().getBAPFunctionListener(25);
    }

    private void setUsmConfirmationPending(boolean bl) {
        this._isUsmConfirmationPending = bl;
    }

    boolean isUsmConfirmationPending() {
        return this._isUsmConfirmationPending;
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        }
    }

    @Override
    public void uninitialize() {
        this.getModelPhoneOcuCallListener().updateEmergencyCallRequested(false);
    }

    @Override
    public int getFunctionId() {
        return 24;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        ServiceRequest_Status serviceRequest_Status = (ServiceRequest_Status)bAPEntity;
        this.setUsmConfirmationPending(serviceRequest_Status.serviceType.serviceBreakdownCallPending && serviceRequest_Status.serviceType.mecPending);
        this.getModelPhoneOcuCallListener().updateEmergencyCallRequested(!serviceRequest_Status.serviceType.serviceBreakdownCallPending && serviceRequest_Status.serviceType.mecPending);
        this.getModelPhoneOcuCallListener().informUsmConfirmationPending(this.isUsmConfirmationPending());
        if (serviceRequest_Status.serviceType.serviceBreakdownCallPending && !serviceRequest_Status.serviceType.mecPending) {
            this.getServiceControl().confirmPendingServiceBreakDownCall();
        } else if (serviceRequest_Status.serviceType.infoCallPending) {
            this.getServiceControl().confirmPendingInfoCall();
        }
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
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

