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
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.DistanceTimeToDestination_Status;

public abstract class DistanceTimeToDestinationStage
implements Property,
BAPStage,
ASLNavSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$DistanceTimeToDestination_Status;

    protected final DistanceTimeToDestination_Status dequeueBAPEntity() {
        return (DistanceTimeToDestination_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$DistanceTimeToDestination_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$DistanceTimeToDestination_Status = DistanceTimeToDestinationStage.class$("de.vw.mib.bap.mqbpq.generated.navsd.serializer.DistanceTimeToDestination_Status")) : class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$DistanceTimeToDestination_Status);
    }

    @Override
    public int getFunctionId() {
        return 21;
    }

    protected final int getRouteGuidanceState() {
        return this.context.getInteger(732, 0);
    }

    protected final int getCurrentDistanceUnit() {
        return this.context.getInteger(1584, 0);
    }

    protected final int getDistanceToDestinationDistance() {
        return this.context.getIntegerListValue(749, 0);
    }

    protected final int getDistanceToDestinationUnit() {
        return this.context.getIntegerListValue(749, 1);
    }

    protected final int getSystemTimeFormat() {
        return this.context.getInteger(1643, 1);
    }

    protected final int getTimeToDestinationMinutes() {
        return this.context.getIntegerListValue(750, 2);
    }

    protected final int getTimeToDestinationHours() {
        return this.context.getIntegerListValue(750, 3);
    }

    protected final int getTimeToDestinationDay() {
        return this.context.getIntegerListValue(750, 4);
    }

    protected final int getTimeToDestinationMonth() {
        return this.context.getIntegerListValue(750, 5);
    }

    protected final int getTimeToDestinationYear() {
        return this.context.getIntegerListValue(750, 6);
    }

    protected final int getTimeToDestinationTimeInfo() {
        return this.context.getInteger(737153024, 0);
    }

    protected final int getRemainingTravelTimeHour() {
        return this.context.getIntegerListValue(753930240, 2);
    }

    protected final int getRemainingTravelTimeMinute() {
        return this.context.getIntegerListValue(753930240, 1);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{732, 1584, 1643, 737153024};
        int[] nArray2 = new int[]{749, 750, 753930240};
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

