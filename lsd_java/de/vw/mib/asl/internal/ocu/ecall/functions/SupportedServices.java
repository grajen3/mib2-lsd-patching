/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;
import de.vw.mib.asl.internal.ocu.ecall.api.model.ModelOcuTestModeListener;
import de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener;
import de.vw.mib.asl.internal.ocu.ecall.api.voice.SupportedServicesListener;
import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.SupportedServices_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.BAPFunctionList;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class SupportedServices
extends ECallFunction
implements PropertyListener,
InternalServiceProvider {
    private boolean mecSupported;
    private boolean infoCallSupported;
    private boolean serviceBreakdownCallSupported;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelOcuTestModeListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener;

    private ModelPhoneOcuCallListener getModelPhoneOcuCallListener() {
        return (ModelPhoneOcuCallListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener = SupportedServices.class$("de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener);
    }

    private ModelOcuTestModeListener getModelOcuTestModeListener() {
        return (ModelOcuTestModeListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelOcuTestModeListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelOcuTestModeListener = SupportedServices.class$("de.vw.mib.asl.internal.ocu.ecall.api.model.ModelOcuTestModeListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelOcuTestModeListener);
    }

    private SupportedServicesListener getSupportedServicesListener() {
        return (SupportedServicesListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener = SupportedServices.class$("de.vw.mib.asl.internal.ocu.ecall.api.voice.SupportedServicesListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener);
    }

    private BAPFunctionList getFunctionList() {
        return (BAPFunctionList)((Object)this.getDelegate().getBAPFunctionListener(3));
    }

    boolean isOcu2Available() {
        BAPFunctionList bAPFunctionList = this.getFunctionList();
        return bAPFunctionList.containsFunction(26) && bAPFunctionList.containsFunction(25) && bAPFunctionList.containsFunction(24) && bAPFunctionList.containsFunction(27);
    }

    private void evaluateOcu2Availability() {
        this.getModelPhoneOcuCallListener().updateOcu2Available(this.isOcu2Available());
    }

    private void _informServices() {
        this.getSupportedServicesListener().updateSupportedServices(this.infoCallSupported, this.serviceBreakdownCallSupported, this.mecSupported);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("SupportedServices: Update with new supported services (info, breakdown, mec) = ").append(this.infoCallSupported).append(", ").append(this.serviceBreakdownCallSupported).append(", ").append(this.mecSupported).log();
        }
    }

    private void setSupportedServices(boolean bl, boolean bl2, boolean bl3) {
        if (this.mecSupported != bl || this.infoCallSupported != bl2 || this.serviceBreakdownCallSupported != bl3) {
            this.mecSupported = bl;
            this.infoCallSupported = bl2;
            this.serviceBreakdownCallSupported = bl3;
        }
        this._informServices();
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        } else {
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener = SupportedServices.class$("de.vw.mib.asl.internal.ocu.ecall.api.voice.SupportedServicesListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener, SupportedServicesListener.SERVICE_CONSTANTS);
        }
    }

    @Override
    public void uninitialize() {
        this.setSupportedServices(false, false, false);
        this.updateTestModeSupported(false);
    }

    @Override
    public int getFunctionId() {
        return 27;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        SupportedServices_Status supportedServices_Status = (SupportedServices_Status)bAPEntity;
        this.setSupportedServices(supportedServices_Status.services.mecSupported, supportedServices_Status.services.infoCallSupported, supportedServices_Status.services.serviceBreakdownCallSupported);
        this.evaluateOcu2Availability();
        this.updateTestModeSupported(supportedServices_Status.services.testModeSupportedDf3_4);
        return true;
    }

    private void updateTestModeSupported(boolean bl) {
        this.getModelOcuTestModeListener().updateOcuServiceModeVisibility(bl);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("OCU Testmode visibility: ").append(bl);
        }
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (SupportedServicesListener.SERVICE_CONSTANTS[0] == n) {
            this._informServices();
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

