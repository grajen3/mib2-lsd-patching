/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.ASLAudioSDConstants;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.FSG_Setup_Status;

public abstract class FSGSetupStage
implements Property,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$FSG_Setup_Status;

    protected final FSG_Setup_Status dequeueBAPEntity() {
        return (FSG_Setup_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$FSG_Setup_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$FSG_Setup_Status = FSGSetupStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.FSG_Setup_Status")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$FSG_Setup_Status);
    }

    @Override
    public int getFunctionId() {
        return 14;
    }

    protected final int getVolumeEntertainmentMax() {
        return this.context.getIntegerListValue(1522, 0);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1522};
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

