/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions.carplay;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.SignalQuality_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class SignalQualityCarPlay
extends Function
implements Property,
ASLTelephoneConstants,
CarPlayServiceListener {
    private static final int SIGNAL_QUALITY_MULTIPLICATOR;
    private static final int ZERO_QUALITY;
    protected static final int[] CAR_PLAY_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$SignalQuality_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getCarPlayService().addCarPlayServiceListener(this, CAR_PLAY_LISTENER_IDS);
        return this.computeSignalQualityStatus();
    }

    protected SignalQuality_Status dequeueBAPEntity() {
        return (SignalQuality_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$SignalQuality_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$SignalQuality_Status = SignalQualityCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.SignalQuality_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$SignalQuality_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 21;
    }

    private void setQuality(SignalQuality_Status signalQuality_Status) {
        int n = this.getCarPlayService().getCarPlayDeviceState().getCarPlayCellularNetworkSignalStrength();
        signalQuality_Status.quality = n <= 5 && n > 0 ? n * 20 : 0;
    }

    private void sendSignalQuality(SignalQuality_Status signalQuality_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(signalQuality_Status, this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getCarPlayService().removeCarPlayServiceListener(this, CAR_PLAY_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        this.sendSignalQuality(this.computeSignalQualityStatus());
    }

    private SignalQuality_Status computeSignalQualityStatus() {
        SignalQuality_Status signalQuality_Status = this.dequeueBAPEntity();
        this.setQuality(signalQuality_Status);
        return signalQuality_Status;
    }

    @Override
    public void updateCarPlayData(CarPlayService carPlayService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        CAR_PLAY_LISTENER_IDS = new int[]{1092550784};
    }
}

