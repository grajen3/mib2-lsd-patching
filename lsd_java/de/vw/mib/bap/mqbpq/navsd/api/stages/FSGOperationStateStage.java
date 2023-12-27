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
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.FSG_OperationState_Status;

public abstract class FSGOperationStateStage
implements Property,
BAPStage,
ASLNavSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$FSG_OperationState_Status;

    protected final FSG_OperationState_Status dequeueBAPEntity() {
        return (FSG_OperationState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$FSG_OperationState_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$FSG_OperationState_Status = FSGOperationStateStage.class$("de.vw.mib.bap.mqbpq.generated.navsd.serializer.FSG_OperationState_Status")) : class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$FSG_OperationState_Status);
    }

    @Override
    public int getFunctionId() {
        return 15;
    }

    protected final int getNaviDomainAvailable() {
        return this.context.getInteger(1676, 0);
    }

    protected final int getSystemOnOffState() {
        return this.context.getInteger(1632, 5);
    }

    protected final int getNavOperationState() {
        return this.context.getInteger(735, 0);
    }

    protected final int getNavigationStatus() {
        return this.context.getInteger(733, 0);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1676, 1632, 735, 733};
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

