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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.DataConnectionIndication_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class DataConnectionIndication
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    protected static final int[] PHONE_LISTENER_IDS = new int[]{1101, 1102, 1100};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DataConnectionIndication_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.dequeueBAPEntity();
    }

    protected DataConnectionIndication_Status dequeueBAPEntity() {
        return (DataConnectionIndication_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DataConnectionIndication_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DataConnectionIndication_Status = DataConnectionIndication.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.DataConnectionIndication_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DataConnectionIndication_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 44;
    }

    private void fillConnectionIndicationData(DataConnectionIndication_Status dataConnectionIndication_Status) {
        PhoneService phoneService = this.getPhoneService();
        dataConnectionIndication_Status.connectionIndication = phoneService.getDataVolumeState();
        dataConnectionIndication_Status.dataVolumeDownlink = phoneService.getDataVolumeDownlink();
        dataConnectionIndication_Status.dataVolumeUplink = phoneService.getDataVolumeUplink();
    }

    private void sendDataConnectionIndication(DataConnectionIndication_Status dataConnectionIndication_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(dataConnectionIndication_Status, this);
    }

    @Override
    public void process(int n) {
        DataConnectionIndication_Status dataConnectionIndication_Status = this.dequeueBAPEntity();
        this.fillConnectionIndicationData(dataConnectionIndication_Status);
        this.sendDataConnectionIndication(dataConnectionIndication_Status);
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
        propertyListener.requestError(69, this);
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

