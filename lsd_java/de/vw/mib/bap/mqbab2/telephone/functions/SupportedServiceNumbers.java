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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.SupportedServiceNumbers_Status;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.SupportedServiceNumbers_Status$ServiceNumbers;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class SupportedServiceNumbers
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    protected static final int[] PHONE_LISTENER_IDS = new int[]{1248, 1150, 1153, 1149};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$SupportedServiceNumbers_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeSupportedServiceNumbersStatus();
    }

    protected SupportedServiceNumbers_Status dequeueBAPEntity() {
        return (SupportedServiceNumbers_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$SupportedServiceNumbers_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$SupportedServiceNumbers_Status = SupportedServiceNumbers.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.SupportedServiceNumbers_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$SupportedServiceNumbers_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 59;
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
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeSupportedServiceNumbersStatus(), this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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

    private SupportedServiceNumbers_Status computeSupportedServiceNumbersStatus() {
        SupportedServiceNumbers_Status supportedServiceNumbers_Status = this.dequeueBAPEntity();
        SupportedServiceNumbers_Status$ServiceNumbers supportedServiceNumbers_Status$ServiceNumbers = supportedServiceNumbers_Status.serviceNumbers;
        supportedServiceNumbers_Status$ServiceNumbers.voiceMailboxSupported = this.isMailboxNumberAvailable();
        supportedServiceNumbers_Status$ServiceNumbers.infoCallSupported = this.isInfoCallNumberAvailable();
        supportedServiceNumbers_Status$ServiceNumbers.serviceCallSupported = this.isServiceCallNumberAvailable();
        supportedServiceNumbers_Status$ServiceNumbers.emergencyCallSupported = this.isEmergencyCallNumberAvailable();
        return supportedServiceNumbers_Status;
    }

    private boolean isMailboxNumberAvailable() {
        return this.getPhoneService().getMailboxCallNumber().length() != 0;
    }

    private boolean isInfoCallNumberAvailable() {
        return this.getPhoneService().getInfoCallNumber().length() != 0;
    }

    private boolean isServiceCallNumberAvailable() {
        return this.getPhoneService().getServiceCallNumber().length() != 0;
    }

    private boolean isEmergencyCallNumberAvailable() {
        return this.getPhoneService().getEmergencyCallNumber().length() != 0;
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

