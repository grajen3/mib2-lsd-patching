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
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.TaInfo_Status;

public abstract class TaInfoStage
implements Property,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$TaInfo_Status;

    protected final TaInfo_Status dequeueBAPEntity() {
        return (TaInfo_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$TaInfo_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$TaInfo_Status = TaInfoStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.TaInfo_Status")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$TaInfo_Status);
    }

    @Override
    public int getFunctionId() {
        return 26;
    }

    protected final int getCurrentDABAnnouncementType() {
        return this.context.getInteger(1326, 0);
    }

    protected final boolean getDabAnnouncementPlaying() {
        return this.context.getBoolean(1429, false);
    }

    protected final boolean getPtyAnnouncementActive() {
        return this.context.getBoolean(1441, false);
    }

    protected final boolean getTrafficInformationActive() {
        return this.context.getBoolean(2482, false);
    }

    protected final int getTrafficInformationFrequencyType() {
        return this.context.getInteger(2397, 0);
    }

    protected final boolean getTrafficAnnouncementActive() {
        return this.context.getBoolean(1448, false);
    }

    protected final int getTrafficAnnouncementSource() {
        return this.context.getInteger(1424, 0);
    }

    protected final String getCurrentTAStationName() {
        return this.context.getString(1328, "");
    }

    protected final String getCurrentDABAnnouncementStationName() {
        return this.context.getString(1325, "");
    }

    protected final int getCurrentTAFrequency() {
        return this.context.getInteger(3007, -530972416);
    }

    protected final String getCurrentPTYAnnouncementStationName() {
        return this.context.getString(1327, "");
    }

    protected final int getCurrentPTYAnnouncementFrequency() {
        return this.context.getInteger(3006, -530972416);
    }

    protected final int getFmFrequencyScale() {
        return this.context.getInteger(1366, 0);
    }

    protected final boolean getPiCodingActivated() {
        return this.context.getBoolean(1426, true);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1326, 1429, 1441, 2482, 2397, 1448, 1424, 1328, 1325, 3007, 1327, 3006, 1366, 1426};
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

