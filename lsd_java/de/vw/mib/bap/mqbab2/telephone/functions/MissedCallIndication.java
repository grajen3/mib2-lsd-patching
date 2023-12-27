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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.MissedCallIndication_SetGet;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.MissedCallIndication_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class MissedCallIndication
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    private static final int INVALID_MISSED_CALL_DATA;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MissedCallIndication_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeMissedCallIndicationStatus();
    }

    protected MissedCallIndication_Status dequeueBAPEntity() {
        return (MissedCallIndication_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MissedCallIndication_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MissedCallIndication_Status = MissedCallIndication.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.MissedCallIndication_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MissedCallIndication_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 45;
    }

    private MissedCallIndication_Status computeMissedCallIndicationStatus() {
        MissedCallIndication_Status missedCallIndication_Status = this.dequeueBAPEntity();
        missedCallIndication_Status.missedCalls = this.getPhoneService().getCurrentMissedCallsCount();
        missedCallIndication_Status.missedNumbers = -65536;
        return missedCallIndication_Status;
    }

    @Override
    public void process(int n) {
        this.sendMissedCallIndication(this.computeMissedCallIndicationStatus());
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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
        MissedCallIndication_SetGet missedCallIndication_SetGet = (MissedCallIndication_SetGet)bAPEntity;
        if (missedCallIndication_SetGet.missedCalls == 0 && missedCallIndication_SetGet.missedNumbers == 0) {
            MissedCallIndication_Status missedCallIndication_Status = this.computeMissedCallIndicationStatus();
            if (missedCallIndication_Status.missedCalls == 0 || missedCallIndication_Status.missedCalls == -65536) {
                propertyListener.statusProperty(missedCallIndication_Status, this);
            } else {
                this.getPhoneService().clearMissedCallsCounter();
            }
        } else {
            propertyListener.requestError(65, this);
        }
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    private void sendMissedCallIndication(MissedCallIndication_Status missedCallIndication_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(missedCallIndication_Status, this);
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
        PHONE_LISTENER_IDS = new int[]{1174};
    }
}

