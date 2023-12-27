/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.navsd.ASLNavSDConstants;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.DistanceToNextManeuver_Status;

public abstract class DistanceToNextManeuverStage
implements Property,
BAPStage,
ASLNavSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$DistanceToNextManeuver_Status;

    protected final DistanceToNextManeuver_Status dequeueBAPEntity() {
        return (DistanceToNextManeuver_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$DistanceToNextManeuver_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$DistanceToNextManeuver_Status = DistanceToNextManeuverStage.class$("de.vw.mib.bap.mqbpq.generated.navsd.serializer.DistanceToNextManeuver_Status")) : class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$DistanceToNextManeuver_Status);
    }

    @Override
    public int getFunctionId() {
        return 18;
    }

    protected final int getCurrentDistanceUnit() {
        return this.context.getInteger(1584, 0);
    }

    protected final int getRouteGuidanceState() {
        return this.context.getInteger(732, 0);
    }

    protected final int getNextManeuverDistance() {
        return this.context.getIntegerListValue(741, 0);
    }

    protected final int getNextManeuverDistanceUnit() {
        return this.context.getIntegerListValue(741, 1);
    }

    protected final int getNextManeuverBargraphOnOff() {
        return this.context.getIntegerListValue(741, 2);
    }

    protected final IntegerIterator getMainElement() {
        return this.context.getIntegerListIterator(751, 0);
    }

    protected final int getNextManeuverBargraph() {
        return this.context.getIntegerListValue(741, 3);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1584, 732};
        int[] nArray2 = new int[]{741, 751};
        bAPStageInitializer.observeAslPropertiesAndLists(this, nArray, nArray2, -1);
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

