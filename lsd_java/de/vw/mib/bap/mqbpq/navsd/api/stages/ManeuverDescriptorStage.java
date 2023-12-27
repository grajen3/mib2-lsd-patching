/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.StringIterator;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.navsd.ASLNavSDConstants;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.ManeuverDescriptor_ChangedArray;

public abstract class ManeuverDescriptorStage
implements Array,
BAPStage,
ASLNavSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$ManeuverDescriptor_ChangedArray;

    protected final ManeuverDescriptor_ChangedArray dequeueBAPEntity() {
        return (ManeuverDescriptor_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$ManeuverDescriptor_ChangedArray == null ? (class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$ManeuverDescriptor_ChangedArray = ManeuverDescriptorStage.class$("de.vw.mib.bap.mqbpq.generated.navsd.serializer.ManeuverDescriptor_ChangedArray")) : class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$ManeuverDescriptor_ChangedArray);
    }

    @Override
    public int getFunctionId() {
        return 22;
    }

    protected final int getRouteGuidanceState() {
        return this.context.getInteger(732, 0);
    }

    protected final IntegerIterator getMainElement() {
        return this.context.getIntegerListIterator(751, 0);
    }

    protected final IntegerIterator getDirection() {
        return this.context.getIntegerListIterator(751, 1);
    }

    protected final IntegerIterator getZLevelGuidance() {
        return this.context.getIntegerListIterator(751, 2);
    }

    protected final StringIterator getSidestreets() {
        return this.context.getStringListIterator(751, 3);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{732};
        int[] nArray2 = new int[]{751};
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

