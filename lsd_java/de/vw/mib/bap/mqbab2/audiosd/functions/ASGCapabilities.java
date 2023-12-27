/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ASG_Capabilities_SetGet;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ASG_Capabilities_Status;

public final class ASGCapabilities
extends Function
implements Property,
ASLAudioSDConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ASG_Capabilities_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return this.computeASGCapabilitiesStatus();
    }

    protected ASG_Capabilities_Status dequeueBAPEntity() {
        return (ASG_Capabilities_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ASG_Capabilities_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ASG_Capabilities_Status = ASGCapabilities.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ASG_Capabilities_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ASG_Capabilities_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 43;
    }

    private void setTransmit16CharsDabNameSetting(boolean bl) {
        this.getPersistenceService().setDABLongLabelsActive(bl);
    }

    private boolean readTransmit16CharsDabNameSetting() {
        return this.getPersistenceService().isDABLongLabelsActive();
    }

    private void setGetASGCapabilities(ASG_Capabilities_SetGet aSG_Capabilities_SetGet, PropertyListener propertyListener) {
        if (this.readTransmit16CharsDabNameSetting() == aSG_Capabilities_SetGet.presentationCapabilities.dabLongPsMax_16Chars) {
            propertyListener.statusProperty(this.computeASGCapabilitiesStatus(), this);
        } else {
            this.setTransmit16CharsDabNameSetting(aSG_Capabilities_SetGet.presentationCapabilities.dabLongPsMax_16Chars);
            this.process(-1);
        }
    }

    private void sendAsgCapabilities(ASG_Capabilities_Status aSG_Capabilities_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(aSG_Capabilities_Status, this);
    }

    private void setAsgCapabilitiesStatusData(ASG_Capabilities_Status aSG_Capabilities_Status) {
        aSG_Capabilities_Status.presentationCapabilities.dabLongPsMax_16Chars = this.readTransmit16CharsDabNameSetting();
        aSG_Capabilities_Status.presentationCapabilities.sdarsLongPsMax_16CharsDf4_1 = this.readTransmit16CharsDabNameSetting();
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this.setGetASGCapabilities((ASG_Capabilities_SetGet)bAPEntity, propertyListener);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
        this.setTransmitLongDabPs(this.readTransmit16CharsDabNameSetting() ? Boolean.TRUE : Boolean.FALSE);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void process(int n) {
        this.sendAsgCapabilities(this.computeASGCapabilitiesStatus());
    }

    protected void setTransmitLongDabPs(Boolean bl) {
        int[] nArray = new int[]{21, 23};
        this.context.updateStages(this, nArray, bl);
    }

    private ASG_Capabilities_Status computeASGCapabilitiesStatus() {
        ASG_Capabilities_Status aSG_Capabilities_Status = this.dequeueBAPEntity();
        this.setAsgCapabilitiesStatusData(aSG_Capabilities_Status);
        return aSG_Capabilities_Status;
    }

    public void persistenceAvailable() {
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

