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
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Calibration_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class Calibration
extends Function
implements Property,
ASLNavSDConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$Calibration_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return null;
    }

    protected Calibration_Status dequeueBAPEntity() {
        return (Calibration_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$Calibration_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$Calibration_Status = Calibration.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.Calibration_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$Calibration_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 27;
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
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.dequeueBAPEntity(), this);
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

