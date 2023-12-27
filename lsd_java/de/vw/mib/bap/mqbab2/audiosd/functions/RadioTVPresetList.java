/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.audiosd.functions.AudioSDCommon;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationServiceLanguageChangeListener;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioAMPresetListElement;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioDABPresetListElement;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioFMPresetListElement;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioSiriusPresetListElement;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerService;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerServiceListener;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.datatypes.iterator.elements.TvTunerPresetListElement;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayDeltaContext;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListElementComparator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListGenericIdGenerator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.RadioTV_PresetList_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.RadioTV_PresetList_Data;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.RadioTV_PresetList_GetArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.RadioTV_PresetList_StatusArray;
import java.util.Iterator;

public class RadioTVPresetList
extends Function
implements TimerNotifier,
FsgArrayListElementComparator,
Array,
ASLAudioSDConstants,
RadioServiceListener,
SoundServiceListener,
TvTunerServiceListener,
ConfigurationServiceLanguageChangeListener {
    private FsgArrayListComplete fullRadioTVPresetList = null;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private static final int ARRAY_OFFSET;
    private static final int MAX_NUMBER_IN_MAPPING_LIST;
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_PRESET_INDEX_WAVEBAND_NAME;
    private static final int MAX_ELEMENTS_PRESET_INDEX_NAME;
    private static final int MAX_ELEMENTS_POS;
    protected static final int[] RADIO_LISTENER_IDS;
    protected static final int[] SOUND_LISTENER_IDS;
    protected static final int[] TV_TUNER_LISTENER_IDS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$RadioTV_PresetList_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getTvTunerService().addTvTunerServiceListener(this, TV_TUNER_LISTENER_IDS);
        this.getConfigurationService().addLanguageChangeListener(this);
        this.timer = this.getTimerService().createTimer(this, 5000);
        this.fullRadioTVPresetList = new FsgArrayListComplete(new FsgArrayListGenericIdGenerator(255, 1));
        this.computeFullPresetList();
        this.setFullRadioTvPresetList(this.fullRadioTVPresetList);
        return this.getFullRangePresetContent();
    }

    protected RadioTV_PresetList_ChangedArray dequeueBAPEntity() {
        return (RadioTV_PresetList_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$RadioTV_PresetList_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$RadioTV_PresetList_ChangedArray = RadioTVPresetList.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.RadioTV_PresetList_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$RadioTV_PresetList_ChangedArray);
    }

    protected void setFullRadioTvPresetList(FsgArrayListComplete fsgArrayListComplete) {
        int[] nArray = new int[]{24, 16, 22, 44, 36};
        this.context.updateStages(this, nArray, fsgArrayListComplete);
    }

    protected void setRadioTvPresetListChangedArray(RadioTV_PresetList_ChangedArray radioTV_PresetList_ChangedArray) {
        int[] nArray = new int[]{36};
        this.context.updateStages(this, nArray, radioTV_PresetList_ChangedArray);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 33;
    }

    private FsgArrayMessageBlockingTracker getArrayRequestTracker() {
        if (this._arrayRequestTracker == null) {
            this._arrayRequestTracker = new FsgArrayMessageBlockingRequestTracker(this, this.getDelegate().getArrayListener(this));
        }
        return this._arrayRequestTracker;
    }

    @Override
    public void process(int n) {
        if (this.timer.isRunning()) {
            this.timer.setUserInfo(new Integer(1));
        } else {
            RadioTV_PresetList_ChangedArray radioTV_PresetList_ChangedArray;
            if (this.fullRadioTVPresetList.numberOfMappedIDValues() > 500) {
                this.fullRadioTVPresetList.clear();
                this.computeFullPresetList();
                radioTV_PresetList_ChangedArray = this.getFullRangePresetContent();
            } else {
                FsgArrayDeltaContext fsgArrayDeltaContext = this.fullRadioTVPresetList.createNewDeltaContext(this);
                this.computeFullPresetList();
                radioTV_PresetList_ChangedArray = this.searchForChangedContent(fsgArrayDeltaContext);
            }
            if (radioTV_PresetList_ChangedArray != null) {
                this.setFullRadioTvPresetList(this.fullRadioTVPresetList);
                this.getArrayRequestTracker().reportChangedArray(radioTV_PresetList_ChangedArray);
                this.setRadioTvPresetListChangedArray(radioTV_PresetList_ChangedArray);
                this.timer.retrigger(new Integer(0));
            }
        }
    }

    protected String formatFrequencyOrReturnPresetName(String string, int n, int n2, int n3) {
        RadioService radioService = this.getRadioService();
        String string2 = !(string.length() != 0 && radioService.isPiCodingActivated() || n == 0) ? (radioService.getFMFrequencyScale() == 1 ? this.getFixFormatter().fmtIcFrequencyNAR(n, n2, -1) : this.getFixFormatter().fmtIcFrequency(n, n2, this.getConfigurationService().getCurrentGUILanguage())) : string;
        return string2;
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        RadioTV_PresetList_GetArray radioTV_PresetList_GetArray = (RadioTV_PresetList_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(radioTV_PresetList_GetArray)) {
            FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(radioTV_PresetList_GetArray.getArrayHeader(), this.fullRadioTVPresetList, RadioTVPresetList.maximumElementsForRecordAddress(radioTV_PresetList_GetArray.getArrayHeader().getRecordAddress()));
            RadioTV_PresetList_StatusArray radioTV_PresetList_StatusArray = new RadioTV_PresetList_StatusArray();
            fsgArrayRequestData.setStatusArrayHeaderDataAndFillRequestData(radioTV_PresetList_StatusArray, radioTV_PresetList_GetArray, this.fullRadioTVPresetList);
            fsgArrayRequestData.setTransmissionPosForArbitraryArray(radioTV_PresetList_StatusArray);
            this.transmitStatus(arrayListener, radioTV_PresetList_StatusArray);
        }
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.requestError(55, this);
    }

    @Override
    public void requestAcknowledge() {
        this.getArrayRequestTracker().requestAcknowledge();
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        this.getArrayRequestTracker().indicationError(n);
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getArrayRequestTracker().reset();
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getTvTunerService().removeTvTunerServiceListener(this, TV_TUNER_LISTENER_IDS);
        this.getConfigurationService().removeLanguageChangeListener(this);
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 1: {
                this.process(-1);
                break;
            }
        }
    }

    private void transmitStatus(ArrayListener arrayListener, RadioTV_PresetList_StatusArray radioTV_PresetList_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(radioTV_PresetList_StatusArray);
    }

    private RadioTV_PresetList_ChangedArray getFullRangePresetContent() {
        RadioTV_PresetList_ChangedArray radioTV_PresetList_ChangedArray = this.dequeueBAPEntity();
        radioTV_PresetList_ChangedArray.getArrayHeader().setFullRangeUpdate(false);
        return radioTV_PresetList_ChangedArray;
    }

    protected void fillPresetListDataElement(RadioTV_PresetList_Data radioTV_PresetList_Data, int n, int n2, int n3, String string) {
        radioTV_PresetList_Data.presetIndex = n + 1;
        radioTV_PresetList_Data.waveband = n2;
        radioTV_PresetList_Data.attributes.ibocService = false;
        radioTV_PresetList_Data.attributes.dabPrimaryServiceContainsSecondaryServiceS = (n3 & 4) == 4;
        radioTV_PresetList_Data.attributes.tpAvailableSupportedByStation = (n3 & 0x20) == 32;
        radioTV_PresetList_Data.attributes.tmcAvailableSupportedByStation = (n3 & 0x40) == 64;
        radioTV_PresetList_Data.attributes.sdarsStationSubscribedOrNotAnSdarsStation = false;
        radioTV_PresetList_Data.attributes.dabSecondaryService = false;
        radioTV_PresetList_Data.name.setContent(string);
    }

    protected void createAndStorePresetListDataElementInFullPresetList(String string, int n, int n2, int n3) {
        if (string.length() != 0) {
            RadioTV_PresetList_Data radioTV_PresetList_Data = new RadioTV_PresetList_Data(null);
            this.fillPresetListDataElement(radioTV_PresetList_Data, n, n2, n3, string);
            this.fullRadioTVPresetList.putElement(AudioSDCommon.computeUniquePresetID(n2, n), radioTV_PresetList_Data, n);
        }
    }

    protected final void computeFullPresetList(int n, Iterator iterator) {
        int n2 = 0;
        block7: while (iterator.hasNext()) {
            switch (n) {
                case 4: {
                    Object object = (RadioAMPresetListElement)iterator.next();
                    String string = this.formatFrequencyOrReturnPresetName("", object.getAMPresetElementFrequence(), 1, object.getAMPresetElementHDStationNumber());
                    this.createAndStorePresetListDataElementInFullPresetList(string, n2, n, 0);
                    ++n2;
                    continue block7;
                }
                case 7: {
                    Object object = (RadioDABPresetListElement)iterator.next();
                    String string = object.getDABPresetElementName();
                    this.createAndStorePresetListDataElementInFullPresetList(string, n2, n, object.getDABPresetElementAttributes());
                    ++n2;
                    continue block7;
                }
                case 1: {
                    Object object = (RadioFMPresetListElement)iterator.next();
                    String string = this.formatFrequencyOrReturnPresetName(object.getFMPresetElementName(), object.getFMPresetElementFrequencies(), 0, object.getFMPresetElementHDStationNumber());
                    this.createAndStorePresetListDataElementInFullPresetList(string, n2, n, object.getFMPresetElementAttributes());
                    ++n2;
                    continue block7;
                }
                case 6: {
                    Object object = (RadioSiriusPresetListElement)iterator.next();
                    String string = object.getSiriusPresetElementName();
                    this.createAndStorePresetListDataElementInFullPresetList(string, n2, n, 0);
                    ++n2;
                    continue block7;
                }
                case 9: {
                    Object object = (TvTunerPresetListElement)iterator.next();
                    String string = object.getTvPresetElementName();
                    this.createAndStorePresetListDataElementInFullPresetList(string, n2, n, 0);
                    ++n2;
                    continue block7;
                }
            }
            iterator.next();
            ++n2;
        }
    }

    private void computeFullPresetListForAmFmDABSirius() {
        RadioService radioService = this.getRadioService();
        switch (radioService.getCurrentStationBand()) {
            case 0: {
                this.computeFullPresetList(4, radioService.getAMPresetList());
                break;
            }
            case 2: {
                this.computeFullPresetList(7, radioService.getDABPresetList());
                break;
            }
            case 1: {
                this.computeFullPresetList(1, radioService.getFMPresetList());
                break;
            }
            case 3: {
                this.computeFullPresetList(6, radioService.getSiriusPresetList());
                break;
            }
        }
    }

    protected void computeFullPresetList() {
        if (this.getSoundService().getCurrentAudioComponent() == 5) {
            this.computeFullPresetList(9, this.getTvTunerService().getTvTunerPresetList());
        } else {
            this.computeFullPresetListForAmFmDABSirius();
        }
    }

    private static int maximumElementsForRecordAddress(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 4;
                break;
            }
            case 1: {
                n2 = 4;
                break;
            }
            case 2: {
                n2 = 4;
                break;
            }
            case 15: {
                n2 = 54;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private RadioTV_PresetList_ChangedArray searchForChangedContent(FsgArrayDeltaContext fsgArrayDeltaContext) {
        RadioTV_PresetList_ChangedArray radioTV_PresetList_ChangedArray = this.dequeueBAPEntity();
        if (!FsgArrayRequestData.computeChangeArrayData(radioTV_PresetList_ChangedArray, fsgArrayDeltaContext, this.fullRadioTVPresetList, false)) {
            radioTV_PresetList_ChangedArray = null;
        }
        return radioTV_PresetList_ChangedArray;
    }

    @Override
    public int compare(BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        int n2;
        RadioTV_PresetList_Data radioTV_PresetList_Data = (RadioTV_PresetList_Data)bAPArrayElement;
        RadioTV_PresetList_Data radioTV_PresetList_Data2 = (RadioTV_PresetList_Data)bAPArrayElement2;
        boolean bl = radioTV_PresetList_Data.presetIndex == radioTV_PresetList_Data2.presetIndex;
        boolean bl2 = radioTV_PresetList_Data.waveband == radioTV_PresetList_Data2.waveband;
        boolean bl3 = radioTV_PresetList_Data.attributes.dabPrimaryServiceContainsSecondaryServiceS == radioTV_PresetList_Data2.attributes.dabPrimaryServiceContainsSecondaryServiceS && radioTV_PresetList_Data.attributes.tpAvailableSupportedByStation == radioTV_PresetList_Data2.attributes.tpAvailableSupportedByStation && radioTV_PresetList_Data.attributes.tmcAvailableSupportedByStation == radioTV_PresetList_Data2.attributes.tmcAvailableSupportedByStation;
        boolean bl4 = radioTV_PresetList_Data.name.toString().compareTo(radioTV_PresetList_Data2.name.toString()) == 0;
        switch (n) {
            case -1: {
                if (!bl3) {
                    n2 = 0;
                    break;
                }
                if (!bl2) {
                    n2 = 1;
                    break;
                }
                if (!bl || !bl4) {
                    n2 = 2;
                    break;
                }
                n2 = -1;
                break;
            }
            case 2: {
                if (!bl3) {
                    n2 = 0;
                    break;
                }
                if (!bl2) {
                    n2 = 1;
                    break;
                }
                if (!bl || !bl4) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            case 1: {
                if (!bl3) {
                    n2 = 0;
                    break;
                }
                if (!(bl2 && bl && bl4)) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                n2 = !bl3 || !bl2 || !bl || !bl4 ? 0 : -1;
            }
        }
        return n2;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateTvTunerData(TvTunerService tvTunerService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSoundData(SoundService soundService, int n) {
        this.process(-1);
    }

    @Override
    public void updateRadioData(RadioService radioService, int n) {
        this.process(-1);
    }

    @Override
    public void languageChanged() {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        RADIO_LISTENER_IDS = new int[]{1324, 1366, 1426, 1313, 1451, 1461, 1458};
        SOUND_LISTENER_IDS = new int[]{1470};
        TV_TUNER_LISTENER_IDS = new int[]{2710};
    }
}

