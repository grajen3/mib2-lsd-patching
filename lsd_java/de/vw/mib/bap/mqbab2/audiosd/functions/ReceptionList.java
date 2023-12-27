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
import de.vw.mib.bap.mqbab2.audiosd.functions.ReceptionList$BAPArrayListReceptionListIDGenerator;
import de.vw.mib.bap.mqbab2.audiosd.functions.ReceptionList$ReceptionListWithCurrentStation;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationServiceLanguageChangeListener;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentAMStationInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentFMStationInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioReceptionListElement;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayDeltaContext;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListElementComparator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ActiveSource_Status;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_Data;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_GetArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_StatusArray;
import java.util.Iterator;

public class ReceptionList
extends Function
implements TimerNotifier,
FsgArrayListElementComparator,
Array,
ASLAudioSDConstants,
RadioServiceListener,
SoundServiceListener,
ConfigurationServiceLanguageChangeListener {
    private boolean transmitALongDABProgrammStation = false;
    protected FsgArrayListComplete fullReceptionList = null;
    private int _elementType = 5;
    private int elementTypeDAB = 5;
    private int parentId = 0;
    private int receptionListASLRadioBand = 1;
    private static final int MAX_NUMBER_IN_MAPPING_LIST;
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;
    private int currentActiveSourceType = 0;
    private static final int ACTIVE_SOURCE_TYPE_UNKNOWN;
    private static final int ACTIVE_SOURCE_TYPE_RADIO;
    private static final int ACTIVE_SOURCE_TYPE_NO_RADIO;
    private Timer timerAfterBandChange = null;
    private static final int TIMER_AFTER_BAND_CHANGE_TIME;
    private Timer updateTimer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private static final int NO_PARENT_ID_PRESENT;
    protected static final int NOT_FOUND_INDEX;
    protected static final int PRESET_ID_OFFSET;
    protected static final int PRESET_ID_INVALID_VALUE;
    private static final int ASL_RADIO_GET_CURRENT_BAND_CONST_BAND_TV;
    private static final int PARENT_ID_UNKNOWN_ROOT;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_ALL_WITHOUT_FREQUENCY;
    private static final int MAX_ELEMENTS_TYPE_ATTRIBUTES;
    private static final int MAX_ELEMENTS_PRESET_ID_FM_REG_CODE_CATEGORY_NAME;
    private static final int MAX_ELEMENTS_NAME;
    private static final int MAX_ELEMENTS_FREQUENCY;
    private static final int MAX_ELEMENTS_TYPE_ATTRIBUTES_CATEGORY_NAME;
    private static final int MAX_ELEMENTS_POS;
    protected static final int[] SOUND_LISTENER_IDS;
    protected static final int[] RADIO_LISTENER_IDS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    private ReceptionList$ReceptionListWithCurrentStation receptionListWithCurrentStation = new ReceptionList$ReceptionListWithCurrentStation(this);
    private static final int BAP_STAGE_UPDATE_ID_LIST_WITH_CURRENT_STATION;
    private boolean addActiveStationToReceptionList = false;
    protected long idOfCurrentStation = -1L;
    private ReceptionList_Data currentStationData = null;
    private int currentStationRadioBand = 0;
    private static final int INVALID_STATION_ID;
    private static final int CURRENT_STATION_IN_RECEPTIONLIST_BAP_POS_ID;
    private static final int CURRENT_STATION_IN_RECEPTIONLIST_MIN_BAP_ID;
    private static final int AM_HD_STATION;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ReceptionList_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getConfigurationService().addLanguageChangeListener(this);
        this.updateTimer = this.getTimerService().createTimer(this, 5000);
        this.timerAfterBandChange = this.getTimerService().createTimer(this, 400);
        this.fullReceptionList = new FsgArrayListComplete(new ReceptionList$BAPArrayListReceptionListIDGenerator(this, -65536, 1));
        this.receptionListASLRadioBand = this.getCurrentBand();
        this.setFullReceptionList(this.fullReceptionList);
        this.receptionListWithCurrentStation.init(bAPStageInitializer);
        return this.getFullRangeReceptionListContent();
    }

    protected ReceptionList_ChangedArray dequeueBAPEntity() {
        return (ReceptionList_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ReceptionList_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ReceptionList_ChangedArray = ReceptionList.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ReceptionList_ChangedArray);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 43: {
                this.setTransmitLongDabPs((Boolean)object);
                break;
            }
            case 16: {
                this.setNewActiveSource((ActiveSource_Status)object);
                break;
            }
        }
    }

    protected void setFullReceptionList(FsgArrayListComplete fsgArrayListComplete) {
        int[] nArray = new int[]{16, 24, 22, 44, 36};
        this.context.updateStages(this, nArray, fsgArrayListComplete);
    }

    protected void setReceptionListChangedArray(ReceptionList_ChangedArray receptionList_ChangedArray) {
        int[] nArray = new int[]{36};
        this.context.updateStages(this, nArray, receptionList_ChangedArray);
    }

    @Override
    public int getFunctionId() {
        return 23;
    }

    private FsgArrayMessageBlockingTracker getArrayRequestTracker() {
        if (this._arrayRequestTracker == null) {
            this._arrayRequestTracker = new FsgArrayMessageBlockingRequestTracker(this, this.getDelegate().getArrayListener(this));
        }
        return this._arrayRequestTracker;
    }

    private int getElementType() {
        return this._elementType;
    }

    protected final void setElementType(int n) {
        this._elementType = n;
    }

    protected int getCurrentBand() {
        int n = this.getSoundService().getCurrentAudioComponent() == 5 ? 4 : this.getRadioService().getCurrentStationBand();
        return n;
    }

    private void sendChangedArray(ReceptionList_ChangedArray receptionList_ChangedArray) {
        this.getArrayRequestTracker().reportChangedArray(receptionList_ChangedArray);
        this.setReceptionListChangedArray(receptionList_ChangedArray);
    }

    private void computeReceptionList(int n, boolean bl) {
        ReceptionList_ChangedArray receptionList_ChangedArray;
        if (this.isReceptionListBeeingUpdated(n)) {
            receptionList_ChangedArray = this.fullReceptionList.getSize() > 0 ? this.getFullRangeReceptionListContent() : null;
            this.fullReceptionList.clearContent();
        } else if (this.fullReceptionList.numberOfMappedIDValues() > 5000) {
            this.fullReceptionList.clear();
            this.computeFullReceptionList();
            receptionList_ChangedArray = this.getFullRangeReceptionListContent();
        } else {
            FsgArrayDeltaContext fsgArrayDeltaContext = this.fullReceptionList.createNewDeltaContext(this);
            this.computeFullReceptionList();
            receptionList_ChangedArray = this.searchForChangedContent(fsgArrayDeltaContext);
        }
        if (receptionList_ChangedArray != null) {
            this.setFullReceptionList(this.fullReceptionList);
            this.sendChangedArray(receptionList_ChangedArray);
            if (bl) {
                this.updateTimer.retrigger(new Integer(0));
            }
        }
    }

    public void processInternal(boolean bl) {
        int n = this.getCurrentBand();
        if ((this.updateTimer.isRunning() && bl || this.timerAfterBandChange.isRunning()) && this.receptionListASLRadioBand == n) {
            this.updateTimer.setUserInfo(new Integer(1));
        } else if (this.receptionListASLRadioBand != n) {
            this.fullReceptionList.clearContent();
            this.receptionListASLRadioBand = n;
            this.setFullReceptionList(this.fullReceptionList);
            this.sendChangedArray(this.getFullRangeReceptionListContent());
            this.timerAfterBandChange.retrigger(new Integer(1));
        } else {
            this.computeReceptionList(n, bl);
        }
    }

    @Override
    public void process(int n) {
        if (n == 85) {
            this.receptionListWithCurrentStation.process(n);
        } else {
            this.processInternal(true);
        }
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        ReceptionList_GetArray receptionList_GetArray = (ReceptionList_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(receptionList_GetArray)) {
            if (this.getCurrentBand() == 2 && (this.getElementType() != receptionList_GetArray.elementType || this.parentId != receptionList_GetArray.parent_Id)) {
                this.elementTypeDAB = receptionList_GetArray.elementType;
                this.setElementType(this.elementTypeDAB);
                this.parentId = receptionList_GetArray.parent_Id;
                this.fullReceptionList.createNewDeltaContext(this);
                this.computeFullReceptionList();
                this.setFullReceptionList(this.fullReceptionList);
            }
            FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(receptionList_GetArray.getArrayHeader(), this.fullReceptionList, ReceptionList.maximumElementsForRecordAddress(receptionList_GetArray.getArrayHeader().getRecordAddress()));
            ReceptionList_StatusArray receptionList_StatusArray = new ReceptionList_StatusArray();
            fsgArrayRequestData.setStatusArrayHeaderDataAndFillRequestData(receptionList_StatusArray, receptionList_GetArray, this.fullReceptionList);
            receptionList_StatusArray.elementType = this.getElementType();
            receptionList_StatusArray.parent_Id = this.parentId;
            fsgArrayRequestData.setTransmissionPosForArbitraryArray(receptionList_StatusArray);
            this.transmitStatus(arrayListener, receptionList_StatusArray);
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
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
        this.receptionListWithCurrentStation.initialize(true);
    }

    @Override
    public void uninitialize() {
        this.updateTimer.stop();
        this.timerAfterBandChange.stop();
        this.getArrayRequestTracker().reset();
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getConfigurationService().removeLanguageChangeListener(this);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        this.getArrayRequestTracker().indicationError(n);
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 1: {
                this.processInternal(true);
                break;
            }
        }
    }

    private boolean isReceptionListBeeingUpdated(int n) {
        boolean bl;
        RadioService radioService = this.getRadioService();
        switch (n) {
            case 0: {
                bl = radioService.getAMRadioListState() == 1;
                break;
            }
            case 2: {
                bl = radioService.getDABRadioListState() == 1;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private void transmitStatus(ArrayListener arrayListener, ReceptionList_StatusArray receptionList_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(receptionList_StatusArray);
    }

    private ReceptionList_ChangedArray getFullRangeReceptionListContent() {
        ReceptionList_ChangedArray receptionList_ChangedArray = this.dequeueBAPEntity();
        receptionList_ChangedArray.elementType = this.getElementType();
        receptionList_ChangedArray.parent_Id = this.parentId;
        receptionList_ChangedArray.getArrayHeader().setFullRangeUpdate(true);
        return receptionList_ChangedArray;
    }

    protected static final void setAttributes(ReceptionList_Data receptionList_Data, int n) {
        receptionList_Data.attributes.available = (n & 1) == 1;
        receptionList_Data.attributes.dvbServiceCorrupted = (n & 8) == 8;
        receptionList_Data.attributes.dabPrimaryServiceContainsSecondaryServiceS = (n & 4) == 4;
        receptionList_Data.attributes.dabPrimaryServiceCorrupted = (n & 8) == 8;
        receptionList_Data.attributes.dabServiceLinkedToFm = (n & 0x10) == 16;
        receptionList_Data.attributes.tpAvailableSupportedByStation = (n & 0x20) == 32;
        receptionList_Data.attributes.tmcAvailableSupportedByStation = (n & 0x40) == 64;
        receptionList_Data.attributes.sdarsStationSubscribedOrNotAnSdarsStation = (n & 0x80) == 128;
    }

    protected String computeReceptionListName(int n, String string, String string2) {
        String string3 = n == 1 || string == null || string.length() == 0 || !this.getRadioService().isPiCodingActivated() ? string2 : string;
        return string3;
    }

    private void computeReceptionListForAMFM(int n) {
        this.setElementType(5);
        Iterator iterator = this.getRadioService().getReceptionList();
        while (iterator.hasNext()) {
            RadioReceptionListElement radioReceptionListElement = (RadioReceptionListElement)iterator.next();
            ReceptionList_Data receptionList_Data = new ReceptionList_Data(null);
            int n2 = radioReceptionListElement.getReceptionListElementFrequency();
            long l = radioReceptionListElement.getReceptionListElementUniqueId();
            receptionList_Data.type = radioReceptionListElement.getReceptionListElementType();
            ReceptionList.setAttributes(receptionList_Data, radioReceptionListElement.getReceptionListElementAttributes());
            int n3 = radioReceptionListElement.getReceptionListElementPresetId();
            receptionList_Data.presetId = n3 == -1 ? 0 : n3 + 1;
            receptionList_Data.fmReg_Code = radioReceptionListElement.getReceptionListElementFMRegCode();
            receptionList_Data.category = radioReceptionListElement.getReceptionListElementCategory();
            String string = this.formatFrequency(n2, n, radioReceptionListElement.getReceptionListElementChannel());
            String string2 = this.computeReceptionListName(n, radioReceptionListElement.getReceptionListElementName(), string);
            receptionList_Data.frequency.setContent(string);
            receptionList_Data.name.setContent(string2);
            if (l == 0L || l == -1L) continue;
            if (n == 0) {
                long l2 = AudioSDCommon.filterOutPIFromUniqueID(l);
                this.fullReceptionList.putElement(l, l2, receptionList_Data, l);
                continue;
            }
            this.fullReceptionList.putElement(l, receptionList_Data, l);
        }
    }

    private void computeReceptionListForDAB() {
        this.setElementType(this.elementTypeDAB);
        int n = 0;
        Iterator iterator = this.getRadioService().getReceptionList();
        while (iterator.hasNext()) {
            boolean bl;
            RadioReceptionListElement radioReceptionListElement = (RadioReceptionListElement)iterator.next();
            int n2 = radioReceptionListElement.getReceptionListElementType();
            int n3 = this.fullReceptionList.getBapPosID(radioReceptionListElement.getReceptionListElementUniqueId());
            switch (this.getElementType()) {
                case 0: {
                    bl = n2 == 2;
                    break;
                }
                case 1: {
                    boolean bl2 = bl = n2 == 3;
                    if (!bl || this.parentId == 0) break;
                    bl = this.parentId == n3 || this.parentId == 0;
                    break;
                }
                case 2: {
                    boolean bl3 = bl = n2 == 3 || n2 == 4;
                    if (!bl || this.parentId == 0) break;
                    bl = this.parentId == n3 || this.parentId == 0;
                    break;
                }
                case 3: {
                    bl = n2 == 2 || n2 == 3 || n2 == 4;
                    break;
                }
                case 4: {
                    bl = n2 == 3 || n2 == 4;
                    break;
                }
                case 5: {
                    bl = n2 == 3;
                    break;
                }
                default: {
                    bl = false;
                }
            }
            if (bl) {
                ReceptionList_Data receptionList_Data = new ReceptionList_Data(null);
                receptionList_Data.type = n2;
                ReceptionList.setAttributes(receptionList_Data, radioReceptionListElement.getReceptionListElementAttributes());
                int n4 = radioReceptionListElement.getReceptionListElementPresetId();
                receptionList_Data.presetId = n4 == -1 ? 0 : n4 + 1;
                receptionList_Data.fmReg_Code = radioReceptionListElement.getReceptionListElementFMRegCode();
                receptionList_Data.category = radioReceptionListElement.getReceptionListElementCategory();
                String string = this.transmitALongDABProgrammStation ? radioReceptionListElement.getReceptionListElementName() : radioReceptionListElement.getReceptionListElementShortName();
                receptionList_Data.name.setContent(string);
                receptionList_Data.frequency.setContent(radioReceptionListElement.getReceptionListElementDABFrequency());
                this.fullReceptionList.putElement(radioReceptionListElement.getReceptionListElementUniqueId(), receptionList_Data, n);
            }
            ++n;
        }
    }

    private void computeReceptionListForSirius() {
        this.setElementType(1);
        Iterator iterator = this.getRadioService().getReceptionList();
        while (iterator.hasNext()) {
            RadioReceptionListElement radioReceptionListElement = (RadioReceptionListElement)iterator.next();
            ReceptionList_Data receptionList_Data = new ReceptionList_Data(null);
            int n = radioReceptionListElement.getReceptionListElementFrequency();
            long l = radioReceptionListElement.getReceptionListElementUniqueId();
            l = l == 0L ? (long)n : l;
            receptionList_Data.type = radioReceptionListElement.getReceptionListElementType();
            ReceptionList.setAttributes(receptionList_Data, radioReceptionListElement.getReceptionListElementAttributes());
            int n2 = radioReceptionListElement.getReceptionListElementPresetId();
            receptionList_Data.presetId = n2 == -1 ? 0 : n2 + 1;
            receptionList_Data.fmReg_Code = 0;
            receptionList_Data.category = radioReceptionListElement.getReceptionListElementCategory();
            String string = this.transmitALongDABProgrammStation ? radioReceptionListElement.getReceptionListElementName() : radioReceptionListElement.getReceptionListElementShortName();
            String string2 = String.valueOf(n);
            if (string == null || string.length() == 0) {
                string = string2;
            }
            receptionList_Data.frequency.setContent(string2);
            receptionList_Data.name.setContent(string);
            if (l == 0L) continue;
            this.fullReceptionList.putElement(l, receptionList_Data, l);
        }
    }

    private void computeReceptionListForTv() {
        this.setElementType(1);
        Iterator iterator = this.getRadioService().getReceptionList();
        while (iterator.hasNext()) {
            RadioReceptionListElement radioReceptionListElement = (RadioReceptionListElement)iterator.next();
            ReceptionList_Data receptionList_Data = new ReceptionList_Data(null);
            long l = radioReceptionListElement.getReceptionListElementParentUniqueId();
            receptionList_Data.type = radioReceptionListElement.getReceptionListElementType();
            ReceptionList.setAttributes(receptionList_Data, radioReceptionListElement.getReceptionListElementAttributes());
            int n = radioReceptionListElement.getReceptionListElementPresetId();
            receptionList_Data.presetId = n == -1 ? 0 : n + 1;
            receptionList_Data.fmReg_Code = 0;
            receptionList_Data.category = radioReceptionListElement.getReceptionListElementCategory();
            String string = radioReceptionListElement.getReceptionListElementShortName();
            receptionList_Data.frequency.setContent("");
            receptionList_Data.name.setContent(string);
            if (l == 0L) continue;
            this.fullReceptionList.putElement(l, receptionList_Data, l);
        }
    }

    protected void computeReceptionListForRadio(int n) {
        if (n == 4) {
            this.computeReceptionListForTv();
        } else {
            switch (n) {
                case 1: {
                    this.computeReceptionListForAMFM(0);
                    this.addCurrentStationToReceptionListIfNecessary();
                    break;
                }
                case 0: {
                    this.computeReceptionListForAMFM(1);
                    this.addCurrentStationToReceptionListIfNecessary();
                    break;
                }
                case 2: {
                    this.computeReceptionListForDAB();
                    break;
                }
                case 3: {
                    this.computeReceptionListForSirius();
                    break;
                }
            }
        }
    }

    private void computeFullReceptionList() {
        this.receptionListASLRadioBand = this.getCurrentBand();
        this.computeReceptionListForRadio(this.receptionListASLRadioBand);
    }

    private static int maximumElementsForRecordAddress(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 4;
                break;
            }
            case 1: {
                n2 = 6;
                break;
            }
            case 2: {
                n2 = 88;
                break;
            }
            case 3: {
                n2 = 6;
                break;
            }
            case 4: {
                n2 = 6;
                break;
            }
            case 5: {
                n2 = 10;
                break;
            }
            case 6: {
                n2 = 6;
                break;
            }
            case 15: {
                n2 = 176;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private ReceptionList_ChangedArray searchForChangedContent(FsgArrayDeltaContext fsgArrayDeltaContext) {
        ReceptionList_ChangedArray receptionList_ChangedArray = this.dequeueBAPEntity();
        receptionList_ChangedArray.elementType = this.getElementType();
        receptionList_ChangedArray.parent_Id = this.parentId;
        if (!FsgArrayRequestData.computeChangeArrayData(receptionList_ChangedArray, fsgArrayDeltaContext, this.fullReceptionList, true)) {
            receptionList_ChangedArray = null;
        }
        return receptionList_ChangedArray;
    }

    protected final void setTransmitLongDabPs(Boolean bl) {
        boolean bl2 = bl;
        if (this.transmitALongDABProgrammStation != bl2) {
            this.transmitALongDABProgrammStation = bl2;
            this.processInternal(true);
        }
    }

    protected final void setNewActiveSource(ActiveSource_Status activeSource_Status) {
        int n = activeSource_Status.sourceType;
        int n2 = n != 2 && n != 17 && n != 1 && n != 3 && n != 5 && n != 4 ? 2 : 1;
        if (this.currentActiveSourceType != 0 && n2 == 1 && this.currentActiveSourceType == 2) {
            this.sendChangedArray(this.getFullRangeReceptionListContent());
        }
        this.currentActiveSourceType = n2;
    }

    @Override
    public int compare(BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        int n2;
        ReceptionList_Data receptionList_Data = (ReceptionList_Data)bAPArrayElement;
        ReceptionList_Data receptionList_Data2 = (ReceptionList_Data)bAPArrayElement2;
        boolean bl = receptionList_Data.name.toString().compareTo(receptionList_Data2.name.toString()) == 0;
        boolean bl2 = receptionList_Data.presetId == receptionList_Data2.presetId;
        switch (n) {
            case -1: {
                if (!bl && bl2) {
                    n2 = 4;
                    break;
                }
                if (!bl || !bl2) {
                    n2 = 3;
                    break;
                }
                n2 = -1;
                break;
            }
            case 4: {
                if (!bl2) {
                    n2 = 3;
                    break;
                }
                if (!bl) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                n2 = !bl || !bl2 ? n : -1;
            }
        }
        return n2;
    }

    private boolean getAddActiveStationToReceptionList() {
        return this.addActiveStationToReceptionList;
    }

    protected void setAddActiveStationToReceptionList(boolean bl) {
        if (this.addActiveStationToReceptionList != bl) {
            this.addActiveStationToReceptionList = bl;
            if (bl) {
                this.computeCurrentStationData();
            } else {
                this.resetCurrentStationData();
            }
            this.processInternal(false);
        }
    }

    protected void recomputeTheReceptionList() {
        if (this.getAddActiveStationToReceptionList()) {
            this.computeCurrentStationData();
            this.processInternal(false);
        }
    }

    private long setReceptionListDataForAm(ReceptionList_Data receptionList_Data) {
        receptionList_Data.type = 1;
        ReceptionList.setAttributes(receptionList_Data, 1);
        receptionList_Data.presetId = 0;
        receptionList_Data.fmReg_Code = 0;
        receptionList_Data.category = 0;
        RadioCurrentAMStationInfo radioCurrentAMStationInfo = this.getRadioService().getCurrentAMStationInfo();
        int n = radioCurrentAMStationInfo.getCurrentAMStationInfoFrequency();
        int n2 = radioCurrentAMStationInfo.getCurrentAMStationInfoHDChannelNumber() == 1 ? 0 : -1;
        String string = this.formatFrequency(n, 1, n2);
        receptionList_Data.frequency.setContent(string);
        receptionList_Data.name.setContent(string);
        return AudioSDCommon.computeUniqueID(4, 0, n, n2);
    }

    protected String formatFrequency(int n, int n2, int n3) {
        String string = this.getRadioService().getFMFrequencyScale() == 1 ? this.getFixFormatter().fmtIcFrequencyNAR(n, n2, n3) : this.getFixFormatter().fmtIcFrequency(n, n2, this.getConfigurationService().getCurrentGUILanguage());
        return string;
    }

    private long setReceptionListDataForFm(ReceptionList_Data receptionList_Data) {
        receptionList_Data.type = 1;
        ReceptionList.setAttributes(receptionList_Data, 1);
        receptionList_Data.presetId = 0;
        receptionList_Data.fmReg_Code = 0;
        receptionList_Data.category = 0;
        RadioCurrentFMStationInfo radioCurrentFMStationInfo = this.getRadioService().getCurrentFMStationInfo();
        int n = radioCurrentFMStationInfo.getCurrentFMStationInfoFrequency();
        int n2 = radioCurrentFMStationInfo.getCurrentFMStationInfoHDChannelNumber();
        String string = this.formatFrequency(n, 0, n2);
        String string2 = this.computeReceptionListName(0, radioCurrentFMStationInfo.getCurrentFMStationInfoStationName(), string);
        receptionList_Data.frequency.setContent(string);
        receptionList_Data.name.setContent(string2);
        return AudioSDCommon.computeUniqueID(1, 0, n, n2);
    }

    private void computeCurrentStationData() {
        long l;
        ReceptionList_Data receptionList_Data = new ReceptionList_Data(null);
        switch (this.getCurrentBand()) {
            case 0: {
                l = this.setReceptionListDataForAm(receptionList_Data);
                this.currentStationRadioBand = 0;
                break;
            }
            case 1: {
                l = this.setReceptionListDataForFm(receptionList_Data);
                this.currentStationRadioBand = 1;
                break;
            }
            default: {
                l = -1L;
            }
        }
        if (l != -1L) {
            this.idOfCurrentStation = l;
            this.currentStationData = receptionList_Data;
        } else {
            this.resetCurrentStationData();
        }
    }

    private void resetCurrentStationData() {
        this.currentStationData = null;
    }

    private void addCurrentStationToReceptionListIfNecessary() {
        if (this.getAddActiveStationToReceptionList() && this.idOfCurrentStation != -1L && this.currentStationData != null && this.currentStationRadioBand == this.getCurrentBand() && !this.receptionListWithCurrentStation.stationIDInReceptionList()) {
            this.fullReceptionList.putElement(this.idOfCurrentStation, this.currentStationData, this.idOfCurrentStation);
        }
    }

    @Override
    public void processHMIEvent(int n) {
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
        SOUND_LISTENER_IDS = new int[]{1470};
        RADIO_LISTENER_IDS = new int[]{1324, 1341, 1317, 1366, 1426, 1270};
    }
}

