/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.navsd.ASLNavSDConstants;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.CompassInfo_Status;

public abstract class CompassInfoStage
implements Property,
BAPStage,
ASLNavSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$CompassInfo_Status;

    protected final CompassInfo_Status dequeueBAPEntity() {
        return (CompassInfo_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$CompassInfo_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$CompassInfo_Status = CompassInfoStage.class$("de.vw.mib.bap.mqbpq.generated.navsd.serializer.CompassInfo_Status")) : class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$CompassInfo_Status);
    }

    @Override
    public int getFunctionId() {
        return 16;
    }

    protected final int getCompassInfoAngle() {
        return this.context.getIntegerListValue(748, 1);
    }

    protected final int getCarCompassInfoAngle() {
        return this.context.getIntegerListValue(10127, 1);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{748, 10127};
        bAPStageInitializer.observeAslPropertiesAndLists(this, null, nArray, -1);
    }

    @Override
    public final void setDelegate(BAPStageContext bAPStageContext) {
        this.context = bAPStageContext;
    }

    protected final BAPFunctionControllerDelegate getDelegate() {
        return this.context;
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.customInitialization(bAPStageInitializer);
        return null;
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
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

