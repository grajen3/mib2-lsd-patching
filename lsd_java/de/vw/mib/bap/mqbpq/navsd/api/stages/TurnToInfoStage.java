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
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.TurnToInfo_Status;

public abstract class TurnToInfoStage
implements Property,
BAPStage,
ASLNavSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$TurnToInfo_Status;

    protected final TurnToInfo_Status dequeueBAPEntity() {
        return (TurnToInfo_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$TurnToInfo_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$TurnToInfo_Status = TurnToInfoStage.class$("de.vw.mib.bap.mqbpq.generated.navsd.serializer.TurnToInfo_Status")) : class$de$vw$mib$bap$mqbpq$generated$navsd$serializer$TurnToInfo_Status);
    }

    @Override
    public int getFunctionId() {
        return 20;
    }

    protected final String getTurnToInfoStreet() {
        return this.context.getStringListValue(744, 0);
    }

    protected final String getTurnToInfoSignPost() {
        return this.context.getStringListValue(744, 1);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{744};
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

