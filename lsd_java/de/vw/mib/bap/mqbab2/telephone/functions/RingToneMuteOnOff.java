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
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneCallInformationElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.RingToneMuteOnOff_SetGet;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.RingToneMuteOnOff_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class RingToneMuteOnOff
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    protected static final int[] PHONE_LISTENER_IDS = new int[]{1096};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$RingToneMuteOnOff_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return null;
    }

    protected RingToneMuteOnOff_Status dequeueBAPEntity() {
        return (RingToneMuteOnOff_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$RingToneMuteOnOff_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$RingToneMuteOnOff_Status = RingToneMuteOnOff.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.RingToneMuteOnOff_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$RingToneMuteOnOff_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 56;
    }

    @Override
    public void process(int n) {
        RingToneMuteOnOff_Status ringToneMuteOnOff_Status = this.dequeueBAPEntity();
        this.computeRingtoneMuteOnOff(ringToneMuteOnOff_Status);
        this.sendRingToneMuteStatus(ringToneMuteOnOff_Status);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
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
        PhoneService phoneService = this.getPhoneService();
        RingToneMuteOnOff_SetGet ringToneMuteOnOff_SetGet = (RingToneMuteOnOff_SetGet)bAPEntity;
        if (ringToneMuteOnOff_SetGet.ringToneMuteOnOff.on == phoneService.isRingtoneMuted()) {
            RingToneMuteOnOff_Status ringToneMuteOnOff_Status = this.dequeueBAPEntity();
            this.computeRingtoneMuteOnOff(ringToneMuteOnOff_Status);
            propertyListener.statusProperty(ringToneMuteOnOff_Status, this);
        } else if (this.incomingNotAcceptedCallPresent()) {
            phoneService.setRingtoneMute(ringToneMuteOnOff_SetGet.ringToneMuteOnOff.on);
        } else {
            propertyListener.requestError(151, this);
        }
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    private void sendRingToneMuteStatus(RingToneMuteOnOff_Status ringToneMuteOnOff_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(ringToneMuteOnOff_Status, this);
    }

    private void computeRingtoneMuteOnOff(RingToneMuteOnOff_Status ringToneMuteOnOff_Status) {
        ringToneMuteOnOff_Status.ringToneMuteOnOff.on = this.getPhoneService().isRingtoneMuted();
    }

    private boolean incomingNotAcceptedCallPresent() {
        boolean bl = false;
        Iterator iterator = this.getPhoneService().getCallInformations();
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            if (phoneCallInformationElement.getCallState() != 3) continue;
            bl = true;
            break;
        }
        return bl;
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

