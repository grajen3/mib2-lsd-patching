/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.ASLAudioSDConstants;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.TaEscape_Result;

public abstract class TaEscapeStage
implements Method,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$TaEscape_Result;

    protected final TaEscape_Result dequeueBAPEntity() {
        return (TaEscape_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$TaEscape_Result == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$TaEscape_Result = TaEscapeStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.TaEscape_Result")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$TaEscape_Result);
    }

    @Override
    public int getFunctionId() {
        return 27;
    }

    protected final boolean getTrafficAnnouncementActive() {
        return this.context.getBoolean(1448, false);
    }

    protected final boolean getDabAnnouncementPlaying() {
        return this.context.getBoolean(1429, false);
    }

    protected final boolean getTrafficInformationActive() {
        return this.context.getBoolean(2482, false);
    }

    protected final boolean getPtyAnnouncementActive() {
        return this.context.getBoolean(1441, false);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1448, 1429, 1441, 2482};
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

