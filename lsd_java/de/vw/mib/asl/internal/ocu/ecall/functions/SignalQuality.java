/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener;
import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.SignalQuality_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class SignalQuality
extends ECallFunction
implements PropertyListener {
    private static final int SIGNAL_QUALITY_NO_RECEPTION;
    private static final int SIGNAL_QUALITY_WEAK_SIGNAL_THRESHOLD;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener;

    private ModelPhoneOcuCallListener getModelPhoneOcuCallListener() {
        return (ModelPhoneOcuCallListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener = SignalQuality.class$("de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener);
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        }
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return 23;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        SignalQuality_Status signalQuality_Status = (SignalQuality_Status)bAPEntity;
        int n = signalQuality_Status.quality == 0 ? 1 : (signalQuality_Status.quality < 30 ? 2 : 3);
        this.getModelPhoneOcuCallListener().updateSignalStrength(n);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("SignalQuality: Update with new modelSignalStrength=").append(n).log();
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

