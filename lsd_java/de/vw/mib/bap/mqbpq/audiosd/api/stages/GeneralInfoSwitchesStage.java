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
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.GeneralInfoSwitches_Status;

public abstract class GeneralInfoSwitchesStage
implements Property,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$GeneralInfoSwitches_Status;

    protected final GeneralInfoSwitches_Status dequeueBAPEntity() {
        return (GeneralInfoSwitches_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$GeneralInfoSwitches_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$GeneralInfoSwitches_Status = GeneralInfoSwitchesStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.GeneralInfoSwitches_Status")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$GeneralInfoSwitches_Status);
    }

    @Override
    public int getFunctionId() {
        return 24;
    }

    protected final boolean getTpSetupOptionState() {
        return this.context.getBoolean(1422, false);
    }

    protected final boolean getRdsSetupOptionState() {
        return this.context.getBoolean(1410, true);
    }

    protected final int getNaviDomainAvailable() {
        return this.context.getInteger(1676, 0);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1422, 1410, 1676};
        bAPStageInitializer.observeAslPropertiesAndLists(this, nArray, null, -1);
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

