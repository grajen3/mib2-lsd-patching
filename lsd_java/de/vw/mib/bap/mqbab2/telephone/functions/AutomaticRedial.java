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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.AutomaticRedial_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class AutomaticRedial
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    private static final int INVALID_INDEX;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$AutomaticRedial_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return null;
    }

    protected AutomaticRedial_Status dequeueBAPEntity() {
        return (AutomaticRedial_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$AutomaticRedial_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$AutomaticRedial_Status = AutomaticRedial.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.AutomaticRedial_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$AutomaticRedial_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 57;
    }

    private AutomaticRedial_Status computeAutomaticRedialStatus() {
        AutomaticRedial_Status automaticRedial_Status = this.dequeueBAPEntity();
        this.computeAutomaticRedialStatus(automaticRedial_Status);
        return automaticRedial_Status;
    }

    @Override
    public void process(int n) {
        this.sendAutomaticRedialStatus(this.computeAutomaticRedialStatus());
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
        propertyListener.statusProperty(this.computeAutomaticRedialStatus(), this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    private int findAutomaticRedialIndex() {
        int n = -1;
        return n;
    }

    private void sendAutomaticRedialStatus(AutomaticRedial_Status automaticRedial_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(automaticRedial_Status, this);
    }

    private void computeAutomaticRedialStatus(AutomaticRedial_Status automaticRedial_Status) {
        automaticRedial_Status.automaticRedialState.automaticRedialActive = this.findAutomaticRedialIndex() != -1;
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
        PHONE_LISTENER_IDS = new int[]{1158};
    }
}

