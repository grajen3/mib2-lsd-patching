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
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.generated.audiosd.ASLAudioSDConstants;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.CurrentStationInfo_Status;

public abstract class CurrentStationInfoStage
implements Property,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$CurrentStationInfo_Status;

    protected void setCurrentStationHandleRequested(Boolean bl) {
        int[] nArray = new int[]{23};
        this.context.updateStages(this, nArray, bl);
    }

    protected void setCurrentFsgHandle(Integer n) {
        int[] nArray = new int[]{23};
        this.context.updateStages(this, nArray, n);
    }

    protected final CurrentStationInfo_Status dequeueBAPEntity() {
        return (CurrentStationInfo_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$CurrentStationInfo_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$CurrentStationInfo_Status = CurrentStationInfoStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.CurrentStationInfo_Status")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$CurrentStationInfo_Status);
    }

    @Override
    public int getFunctionId() {
        return 21;
    }

    protected final int getCurrentAudioComponent() {
        return this.context.getInteger(1470, 0);
    }

    protected final int getCurrentStationInfoBand() {
        return this.context.getInteger(1324, 1);
    }

    protected final String getCurrentFmStationName() {
        return this.context.getStringListValue(1456, 4);
    }

    protected final int getCurrentFmFrequency() {
        return this.context.getIntegerListValue(1456, 0);
    }

    protected final int getCurrentFmHdChannelNumber() {
        return this.context.getIntegerListValue(1456, 6);
    }

    protected final String getCurrentAmStationName() {
        return this.context.getStringListValue(1454, 1);
    }

    protected final int getCurrentAMFrequency() {
        return this.context.getIntegerListValue(1454, 0);
    }

    protected final int getCurrentAmHdChannelNumber() {
        return this.context.getIntegerListValue(1454, 4);
    }

    protected final int getFmFrequencyScale() {
        return this.context.getInteger(1366, 0);
    }

    protected final int getDabServiceState() {
        return this.context.getInteger(1356, 0);
    }

    protected final int getDabRadioListState() {
        return this.context.getInteger(1341, 0);
    }

    protected final int getAmRadioGetListState() {
        return this.context.getInteger(1317, 0);
    }

    protected final int getDabEnsembleState() {
        return this.context.getInteger(1339, 0);
    }

    protected final int getDabAdditionalServiceState() {
        return this.context.getInteger(1357, 0);
    }

    protected final String getCurrentDABFrequencyLabel() {
        return this.context.getStringListValue(1455, 6);
    }

    protected final String getCurrentDabServiceShortName() {
        return this.context.getStringListValue(1455, 4);
    }

    protected final String getCurrentDabSecondaryServiceShortName() {
        return this.context.getStringListValue(1455, 2);
    }

    protected final String getCurrentDABEnsembleName() {
        return this.context.getStringListValue(1455, 0);
    }

    protected final String getCurrentSatChannelShortName() {
        return this.context.getStringListValue(1308, 18);
    }

    protected final String getCurrentSatTitleName() {
        return this.context.getStringListValue(3962, 4);
    }

    protected final String getCurrentSatArtistName() {
        return this.context.getStringListValue(3962, 0);
    }

    protected final String getCurrentAMRadioTextArtistName() {
        return this.context.getString(1320, "");
    }

    protected final String getCurrentAMRadioTextTitleName() {
        return this.context.getString(1321, "");
    }

    protected final String getCurrentFmRadioTextPlusArtistName() {
        return this.context.getString(1371, "");
    }

    protected final String getCurrentFmRadioTextPlusTitleName() {
        return this.context.getString(1372, "");
    }

    protected final String getCurrentHdRadioPsTitleName() {
        return this.context.getString(3403, "");
    }

    protected final String getCurrentHdRadioPsArtistName() {
        return this.context.getString(3404, "");
    }

    protected final int getHdRadioState() {
        return this.context.getInteger(1394, 3);
    }

    protected final boolean getRatioTextPlusActive() {
        return this.context.getBoolean(1443, false);
    }

    protected final boolean getManualModeActive() {
        return this.context.getBoolean(1438, false);
    }

    protected final boolean getRadioTextPlusSetupState() {
        return this.context.getBoolean(2323, true);
    }

    protected final boolean getDabRatioTextPlusActive() {
        return this.context.getBoolean(1436, false);
    }

    protected final boolean getRadioTextSetupState() {
        return this.context.getBoolean(1409, true);
    }

    protected final boolean getRdsSetupOptionState() {
        return this.context.getBoolean(1410, true);
    }

    protected final int getCurrentAudioSource() {
        return this.context.getInteger(8, 0);
    }

    protected final int getCDContentType() {
        return this.context.getInteger(3520, 0);
    }

    protected final int getDvdChapter() {
        return this.context.getInteger(124, 3);
    }

    protected final int getDvdChapterCount() {
        return this.context.getInteger(125, 0);
    }

    protected final String getCurrentTitle() {
        return this.context.getStringListValue(58, 5);
    }

    protected final String getCurrentArtist() {
        return this.context.getStringListValue(58, 1);
    }

    protected final String getCurrentAlbum() {
        return this.context.getStringListValue(58, 0);
    }

    protected final int getCurrentTrackNumber() {
        return this.context.getIntegerListValue(58, 7);
    }

    protected final String getActivePlayedFolderName() {
        return this.context.getString(2849, "");
    }

    protected final String getCurrentTvTunerStationName() {
        return this.context.getString(2314, "");
    }

    protected final int getTpState() {
        return this.context.getInteger(1423, 0);
    }

    protected final boolean getTmcSignalAvailable() {
        return this.context.getBoolean(2388, false);
    }

    protected final long getStationListActiveID() {
        return this.context.getLongListValue(2486, 1);
    }

    protected final boolean getBluetoothAvrcpSupported() {
        return this.context.getBoolean(2781, false);
    }

    protected final String getInstrumentClusterIsLanguage() {
        return this.context.getString(0x33322000, "");
    }

    protected final int getArrowKeyScopeMode() {
        return this.context.getInteger(1412, 1);
    }

    protected final int getPresetBankActiveIndex() {
        return this.context.getIntegerListValue(2486, 0);
    }

    protected final int getSmarphoneIntegrationConnectionType() {
        return this.context.getInteger(1114057728, 0);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1470, 1324, 1366, 1356, 1341, 1317, 1339, 1357, 1320, 1321, 1371, 1372, 3403, 3404, 1394, 1443, 1438, 1436, 2323, 1409, 1410, 8, 3520, 124, 125, 2849, 2314, 1423, 2388, 2781, 0x33322000, 1412, 1114057728};
        int[] nArray2 = new int[]{1456, 1454, 1455, 1308, 3962, 58, 2486};
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
        switch (bAPStage.getFunctionId()) {
            case 22: {
                this.setReceptionList((BAPArrayList)object);
                break;
            }
        }
    }

    protected abstract void setReceptionList(BAPArrayList bAPArrayList) {
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

