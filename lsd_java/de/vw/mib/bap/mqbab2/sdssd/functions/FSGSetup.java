/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.FSG_Setup_Status;

public class FSGSetup
extends Function
implements Property {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$FSG_Setup_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return null;
    }

    protected FSG_Setup_Status dequeueBAPEntity() {
        return (FSG_Setup_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$FSG_Setup_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$FSG_Setup_Status = FSGSetup.class$("de.vw.mib.bap.mqbab2.generated.sdssd.serializer.FSG_Setup_Status")) : class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$FSG_Setup_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 14;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        FSG_Setup_Status fSG_Setup_Status = this.computeFSGSetupStatus();
        propertyListener.statusProperty(fSG_Setup_Status, this);
    }

    @Override
    public void requestAcknowledge() {
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
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
    }

    @Override
    public void process(int n) {
        this.sendFSGSetupStatus(this.computeFSGSetupStatus());
    }

    private FSG_Setup_Status computeFSGSetupStatus() {
        FSG_Setup_Status fSG_Setup_Status = this.dequeueBAPEntity();
        this.setFSGSetupData(fSG_Setup_Status);
        return fSG_Setup_Status;
    }

    private void sendFSGSetupStatus(FSG_Setup_Status fSG_Setup_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(fSG_Setup_Status, this);
    }

    private void setFSGSetupData(FSG_Setup_Status fSG_Setup_Status) {
        fSG_Setup_Status.setupValue._commandIdsSupported = false;
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

