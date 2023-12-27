/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.SignalQuality2_Status;
import de.vw.mib.bap.mqbab2.telephone2.api.ASLTelephone2Constants;

public final class SignalQuality
extends Function
implements Property,
ASLTelephone2Constants,
PhoneServiceListener {
    private static final int SIGNAL_QUALITY_MULTIPLICATOR;
    private static final int ZERO_QUALITY;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$SignalQuality2_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeSignalQuality();
    }

    protected SignalQuality2_Status dequeueBAPEntity() {
        return (SignalQuality2_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$SignalQuality2_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$SignalQuality2_Status = SignalQuality.class$("de.vw.mib.bap.mqbab2.generated.telephone2.serializer.SignalQuality2_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$SignalQuality2_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 20;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeSignalQuality(), this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    private SignalQuality2_Status computeSignalQuality() {
        SignalQuality2_Status signalQuality2_Status = this.dequeueBAPEntity();
        signalQuality2_Status.quality = this.getBapSignalQuality();
        return signalQuality2_Status;
    }

    private int getBapSignalQuality() {
        int n;
        PhoneService phoneService = this.getPhoneService();
        int n2 = phoneService.isSignalStrengthAvailable() ? ((n = phoneService.getSignalStrength()) <= 5 && n > 0 ? n * 20 : 0) : 0;
        return n2;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
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
        PHONE_LISTENER_IDS = new int[]{1087, 1097};
    }
}

