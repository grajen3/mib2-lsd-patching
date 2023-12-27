/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.ASG_Capabilities_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class ASGcapabilities
extends Function
implements Property,
ASLNavSDConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$ASG_Capabilities_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        ASG_Capabilities_Status aSG_Capabilities_Status = this.dequeueBAPEntity();
        aSG_Capabilities_Status.presentationCapabilities.__5DSymbolPresentation = true;
        return aSG_Capabilities_Status;
    }

    protected ASG_Capabilities_Status dequeueBAPEntity() {
        return (ASG_Capabilities_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$ASG_Capabilities_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$ASG_Capabilities_Status = ASGcapabilities.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.ASG_Capabilities_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$ASG_Capabilities_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 28;
    }

    @Override
    public void process(int n) {
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
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        ASG_Capabilities_Status aSG_Capabilities_Status = this.dequeueBAPEntity();
        aSG_Capabilities_Status.presentationCapabilities.__5DSymbolPresentation = true;
        propertyListener.statusProperty(aSG_Capabilities_Status, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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

