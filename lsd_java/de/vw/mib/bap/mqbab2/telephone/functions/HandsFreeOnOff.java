/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.HandsFreeOnOff_SetGet;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.HandsFreeOnOff_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class HandsFreeOnOff
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    protected static final int[] PHONE_LISTENER_IDS = new int[]{1238};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HandsFreeOnOff_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeHandsFreeStatus();
    }

    protected HandsFreeOnOff_Status dequeueBAPEntity() {
        return (HandsFreeOnOff_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HandsFreeOnOff_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HandsFreeOnOff_Status = HandsFreeOnOff.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.HandsFreeOnOff_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HandsFreeOnOff_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 33;
    }

    private HandsFreeOnOff_Status computeHandsFreeStatus() {
        HandsFreeOnOff_Status handsFreeOnOff_Status = this.dequeueBAPEntity();
        handsFreeOnOff_Status.handsFreeOnOff.on = this.getPhoneService().isHandsfreeAudioEnabled();
        return handsFreeOnOff_Status;
    }

    @Override
    public void process(int n) {
        this.sendHandsFreeOnOffState(this.computeHandsFreeStatus());
    }

    private void sendHandsFreeOnOffState(HandsFreeOnOff_Status handsFreeOnOff_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(handsFreeOnOff_Status, this);
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
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        if (this.getPhoneService().getCurrentPhoneCallCount() != 0) {
            HandsFreeOnOff_SetGet handsFreeOnOff_SetGet = (HandsFreeOnOff_SetGet)bAPEntity;
            HandsFreeOnOff_Status handsFreeOnOff_Status = this.computeHandsFreeStatus();
            if (handsFreeOnOff_Status.handsFreeOnOff.on != handsFreeOnOff_SetGet.handsFreeOnOff.on) {
                this.getPhoneService().setHandsfreeAudioModeActive(handsFreeOnOff_SetGet.handsFreeOnOff.on);
            } else {
                propertyListener.statusProperty(handsFreeOnOff_Status, this);
            }
        } else {
            propertyListener.requestError(128, this);
        }
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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
}

