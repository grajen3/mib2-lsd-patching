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
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.ASG_Capabilities_SetGet;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.ASG_Capabilities_Status;

public class ASGCapabilities
extends Function
implements Property {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$ASG_Capabilities_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        int n = this.getPersistenceService().getInstrumentClusterDisplaySize();
        this.displaySizeChanged(n);
        return this.computeASGCapabilities();
    }

    protected ASG_Capabilities_Status dequeueBAPEntity() {
        return (ASG_Capabilities_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$ASG_Capabilities_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$ASG_Capabilities_Status = ASGCapabilities.class$("de.vw.mib.bap.mqbab2.generated.sdssd.serializer.ASG_Capabilities_Status")) : class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$ASG_Capabilities_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 16;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.statusProperty(this.computeASGCapabilities(), this);
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
        ASG_Capabilities_SetGet aSG_Capabilities_SetGet = (ASG_Capabilities_SetGet)bAPEntity;
        if (ASGCapabilities.inputParametersValid(aSG_Capabilities_SetGet)) {
            if (this.getCurrentInstrumentClusterDisplaySize() != aSG_Capabilities_SetGet.displaySizeClass) {
                this.displaySizeChanged(aSG_Capabilities_SetGet.displaySizeClass);
            }
            propertyListener.statusProperty(this.computeASGCapabilities(), this);
        } else {
            propertyListener.requestError(65, this);
        }
    }

    private static boolean inputParametersValid(ASG_Capabilities_SetGet aSG_Capabilities_SetGet) {
        boolean bl;
        switch (aSG_Capabilities_SetGet.displaySizeClass) {
            case 0: 
            case 1: 
            case 2: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
    }

    @Override
    public void process(int n) {
        this.sendAsgCapabilities(this.computeASGCapabilities());
    }

    public ASG_Capabilities_Status computeASGCapabilities() {
        ASG_Capabilities_Status aSG_Capabilities_Status = this.dequeueBAPEntity();
        aSG_Capabilities_Status.displaySizeClass = this.getCurrentInstrumentClusterDisplaySize();
        return aSG_Capabilities_Status;
    }

    private void sendAsgCapabilities(ASG_Capabilities_Status aSG_Capabilities_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(aSG_Capabilities_Status, this);
    }

    private int getCurrentInstrumentClusterDisplaySize() {
        return this.getPersistenceService().getInstrumentClusterDisplaySize();
    }

    private void displaySizeChanged(int n) {
        this.getPersistenceService().setInstrumentClusterDisplaySize(n);
        int n2 = this.getConfigurationService().mapInstrumentClusterDisplaySizeFromBAPToSystem(n);
        if (this.getLogger().isTraceEnabled(1024)) {
            this.getLogger().trace(1024).append("ASGCapabilities: New display size received: configurationManagerSdsDisplaySize=").append(n2).log();
        }
        this.getConfigurationService().setInstrumentClusterDisplaySize(n2);
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

