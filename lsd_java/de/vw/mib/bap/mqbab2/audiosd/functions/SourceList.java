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
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaServiceListener;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.iterator.elements.MediaAvailableAudioSourcesElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayDeltaContext;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListElementComparator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListGenericIdGenerator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceList_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceList_Data;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceList_GetArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceList_StatusArray;
import java.util.Iterator;

public class SourceList
extends Function
implements TimerNotifier,
FsgArrayListElementComparator,
Array,
ASLAudioSDConstants,
SystemServiceListener,
MediaServiceListener {
    private FsgArrayListComplete fullSourceList = new FsgArrayListComplete(new FsgArrayListGenericIdGenerator(255, 1));
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_META_INFO_ONLY;
    private static final int MAX_ELEMENTS_NAME;
    private static final int MAX_ELEMENTS_ATTRIBUTES;
    private static final int MAX_ELEMENTS_MEDIA_TYPE;
    private static final int MAX_ELEMENTS_POS;
    private static final int MAX_NUMBER_IN_MAPPING_LIST;
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    protected static final int[] SYSTEM_LISTENER_IDS;
    protected static final int[] MEDIA_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SourceList_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getMediaService().addMediaServiceListener(this, MEDIA_LISTENER_IDS);
        this.timer = this.getTimerService().createTimer(this, 1500);
        this.computeFullSourceList(this.fullSourceList);
        this.setInternalFullSourceList(this.fullSourceList);
        return this.getFullRangeSourceListContent();
    }

    protected SourceList_ChangedArray dequeueBAPEntity() {
        return (SourceList_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SourceList_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SourceList_ChangedArray = SourceList.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceList_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SourceList_ChangedArray);
    }

    protected void setFullSourceList(FsgArrayListComplete fsgArrayListComplete) {
        int[] nArray = new int[]{17, 16, 38, 34};
        this.context.updateStages(this, nArray, fsgArrayListComplete);
    }

    protected void setNumberOfSourceListElements(Integer n) {
        int[] nArray = new int[]{44};
        this.context.updateStages(this, nArray, n);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 32;
    }

    private FsgArrayMessageBlockingTracker getArrayRequestTracker() {
        if (this._arrayRequestTracker == null) {
            this._arrayRequestTracker = new FsgArrayMessageBlockingRequestTracker(this, this.getDelegate().getArrayListener(this));
        }
        return this._arrayRequestTracker;
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        SourceList_GetArray sourceList_GetArray = (SourceList_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(sourceList_GetArray)) {
            FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(sourceList_GetArray.getArrayHeader(), this.fullSourceList, SourceList.maximumElementsForRecordAddress(sourceList_GetArray.getArrayHeader().getRecordAddress()));
            SourceList_StatusArray sourceList_StatusArray = new SourceList_StatusArray();
            fsgArrayRequestData.setStatusArrayHeaderDataAndFillRequestData(sourceList_StatusArray, sourceList_GetArray, this.fullSourceList);
            fsgArrayRequestData.setTransmissionPosForArbitraryArray(sourceList_StatusArray);
            this.transmitStatus(arrayListener, sourceList_StatusArray);
        }
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.requestError(65, this);
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
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getArrayRequestTracker().reset();
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getMediaService().removeMediaServiceListener(this, MEDIA_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        this.getArrayRequestTracker().indicationError(n);
    }

    @Override
    public void process(int n) {
        if (this.timer.isRunning()) {
            this.timer.setUserInfo(new Integer(1));
            FsgArrayListComplete fsgArrayListComplete = this.fullSourceList.copy();
            this.computeFullSourceList(fsgArrayListComplete);
            this.setInternalFullSourceList(fsgArrayListComplete);
        } else {
            SourceList_ChangedArray sourceList_ChangedArray;
            if (this.fullSourceList.numberOfMappedIDValues() > 20) {
                this.fullSourceList.clear();
                this.computeFullSourceList(this.fullSourceList);
                sourceList_ChangedArray = this.getFullRangeSourceListContent();
            } else {
                FsgArrayDeltaContext fsgArrayDeltaContext = this.fullSourceList.createNewDeltaContext(this);
                this.computeFullSourceList(this.fullSourceList);
                sourceList_ChangedArray = this.searchForChangedContent(fsgArrayDeltaContext);
            }
            if (sourceList_ChangedArray != null) {
                this.getArrayRequestTracker().reportChangedArray(sourceList_ChangedArray);
                this.setInternalFullSourceList(this.fullSourceList);
                this.timer.retrigger(new Integer(0));
            }
        }
    }

    private void transmitStatus(ArrayListener arrayListener, SourceList_StatusArray sourceList_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(sourceList_StatusArray);
    }

    private SourceList_ChangedArray getFullRangeSourceListContent() {
        SourceList_ChangedArray sourceList_ChangedArray = this.dequeueBAPEntity();
        sourceList_ChangedArray.getArrayHeader().setFullRangeUpdate(true);
        return sourceList_ChangedArray;
    }

    private static void setSourceName(SourceList_Data sourceList_Data, String string) {
        if (string != null) {
            sourceList_Data.name.setContent(string);
        } else {
            sourceList_Data.name.setContent("");
        }
    }

    private SourceList_ChangedArray searchForChangedContent(FsgArrayDeltaContext fsgArrayDeltaContext) {
        SourceList_ChangedArray sourceList_ChangedArray = this.dequeueBAPEntity();
        if (!FsgArrayRequestData.computeChangeArrayData(sourceList_ChangedArray, fsgArrayDeltaContext, this.fullSourceList, true)) {
            sourceList_ChangedArray = null;
        }
        return sourceList_ChangedArray;
    }

    private void fillSourceAttributes(SourceList_Data sourceList_Data, int n, int n2, boolean bl, String string, boolean bl2) {
        boolean bl3 = n != 10 && n != 13 && n != 12 && n != 0;
        boolean bl4 = (n2 & 0x100) != 256;
        boolean bl5 = bl3 && (n2 & 0x1000) != 4096 && (n2 & 0x800) != 2048 && n != 11 && n != 15 && n != 19 && n != 17;
        boolean bl6 = bl5 && (n2 & 0x400) != 1024 && (n2 & 1) != 1;
        boolean bl7 = n != 12;
        boolean bl8 = (n2 & 0x10) != 16;
        sourceList_Data.attributes.builtInAndReadyMediumInserted = bl && bl3;
        sourceList_Data.attributes.mediumAudioNoError = bl4;
        sourceList_Data.attributes.mediaIsPlayable = bl6;
        sourceList_Data.attributes.mediumIsReadable = bl5;
        sourceList_Data.attributes.mediumIsNotBeingLoaded = bl7;
        sourceList_Data.attributes.noImportRunning = bl8;
        sourceList_Data.attributes.mediumSupportBrowserListDf4_2 = bl2;
        SourceList.setSourceName(sourceList_Data, string);
    }

    private void setSourceTypeMediaTypeAttributesName(int n, SourceList_Data sourceList_Data, String string, boolean bl, int n2, int n3, boolean bl2) {
        this.fillSourceAttributes(sourceList_Data, n2, n3, bl, string, bl2);
        MediaService mediaService = this.getMediaService();
        switch (n) {
            case 3: {
                sourceList_Data.sourceType = 13;
                sourceList_Data.mediaType = 8;
                break;
            }
            case 6: {
                if (n2 == 9 && mediaService.isMetaInfoRequestSupported()) {
                    sourceList_Data.sourceType = 22;
                    sourceList_Data.mediaType = 9;
                    break;
                }
                sourceList_Data.sourceType = 21;
                sourceList_Data.mediaType = 0;
                break;
            }
            case 4: {
                if (n2 == 2) {
                    sourceList_Data.sourceType = 18;
                    sourceList_Data.mediaType = 2;
                } else if (n2 == 6) {
                    sourceList_Data.sourceType = 18;
                    sourceList_Data.mediaType = 6;
                } else {
                    sourceList_Data.sourceType = 7;
                    sourceList_Data.mediaType = 1;
                }
                if (n2 != 5 && n2 != 6) break;
                sourceList_Data.attributes.mediaIsPlayable = sourceList_Data.attributes.noImportRunning;
                break;
            }
            case 1: {
                if (n2 == 2) {
                    sourceList_Data.sourceType = 8;
                    sourceList_Data.mediaType = 2;
                } else if (n2 == 3) {
                    sourceList_Data.sourceType = 8;
                    sourceList_Data.mediaType = 3;
                } else if (n2 == 6) {
                    sourceList_Data.sourceType = 8;
                    sourceList_Data.mediaType = 6;
                } else {
                    sourceList_Data.sourceType = 6;
                    sourceList_Data.mediaType = 1;
                }
                if (n2 != 5 && n2 != 6) break;
                sourceList_Data.attributes.mediaIsPlayable = sourceList_Data.attributes.noImportRunning;
                break;
            }
            case 5: {
                sourceList_Data.sourceType = 10;
                sourceList_Data.mediaType = 7;
                boolean bl3 = (n3 & 0x100) == 256;
                sourceList_Data.attributes.mediaIsPlayable &= bl3;
                break;
            }
            case 7: {
                sourceList_Data.sourceType = 16;
                sourceList_Data.mediaType = 12;
                break;
            }
            case 2: {
                sourceList_Data.sourceType = 11;
                sourceList_Data.mediaType = 7;
                sourceList_Data.instance_Id = this.getConfigurationService().getAvailableNumberOfSDCardSlots() <= 1 ? 0 : 1;
                break;
            }
            case 10: {
                sourceList_Data.sourceType = 11;
                sourceList_Data.mediaType = 7;
                sourceList_Data.instance_Id = 2;
                break;
            }
            case 8: {
                sourceList_Data.sourceType = 19;
                sourceList_Data.mediaType = 7;
                sourceList_Data.instance_Id = mediaService.isSecondUSBSocketAvailable() ? 1 : 0;
                break;
            }
            case 13: {
                sourceList_Data.sourceType = 19;
                sourceList_Data.mediaType = 7;
                sourceList_Data.instance_Id = 2;
                break;
            }
            case 9: 
            case 12: {
                if (bl) {
                    sourceList_Data.sourceType = 14;
                    sourceList_Data.mediaType = 8;
                    break;
                }
                sourceList_Data.sourceType = 15;
                sourceList_Data.mediaType = 255;
                break;
            }
            case 11: {
                sourceList_Data.sourceType = 28;
                sourceList_Data.mediaType = 9;
                break;
            }
            default: {
                sourceList_Data.sourceType = 255;
                sourceList_Data.mediaType = 0;
                sourceList_Data.attributes.builtInAndReadyMediumInserted = false;
                sourceList_Data.attributes.mediumAudioNoError = true;
                sourceList_Data.attributes.mediaIsPlayable = false;
                sourceList_Data.attributes.mediumIsReadable = false;
                sourceList_Data.attributes.mediumIsNotBeingLoaded = true;
                sourceList_Data.attributes.noImportRunning = true;
                sourceList_Data.attributes.mediumSupportBrowserListDf4_2 = false;
                sourceList_Data.name.setContent("");
            }
        }
    }

    private void setSmartPhoneSourceType(SourceList_Data sourceList_Data) {
        switch (this.getSmartphoneIntegrationService().getSmarphoneIntegrationActiveConnectionType()) {
            case 2: {
                sourceList_Data.sourceType = 37;
                sourceList_Data.name.setContent("Car Play");
                this.setSmartPhoneSourceAttributes(sourceList_Data);
                break;
            }
            case 4: {
                sourceList_Data.sourceType = 40;
                sourceList_Data.name.setContent("Car Life");
                this.setSmartPhoneSourceAttributes(sourceList_Data);
                break;
            }
            case 3: {
                sourceList_Data.sourceType = 39;
                sourceList_Data.name.setContent("Android Auto");
                this.setSmartPhoneSourceAttributes(sourceList_Data);
                break;
            }
            case 1: {
                sourceList_Data.sourceType = 38;
                sourceList_Data.name.setContent("Mirror Link");
                this.setSmartPhoneSourceAttributes(sourceList_Data);
                break;
            }
        }
    }

    private void setSmartPhoneSourceAttributes(SourceList_Data sourceList_Data) {
        sourceList_Data.attributes.mediumSupportBrowserListDf4_2 = false;
    }

    private void setDataForMediaSources(FsgArrayListComplete fsgArrayListComplete) {
        Iterator iterator = this.getMediaService().getAvailableAudioSources();
        while (iterator.hasNext()) {
            MediaAvailableAudioSourcesElement mediaAvailableAudioSourcesElement = (MediaAvailableAudioSourcesElement)iterator.next();
            int n = mediaAvailableAudioSourcesElement.getAudioSourceId();
            String string = mediaAvailableAudioSourcesElement.getAudioSourceName();
            boolean bl = mediaAvailableAudioSourcesElement.isAudioSourceEnabled();
            int n2 = mediaAvailableAudioSourcesElement.getAudioSourceMediaFlag();
            int n3 = mediaAvailableAudioSourcesElement.getAudioSourceMediaType();
            boolean bl2 = mediaAvailableAudioSourcesElement.isAudioSourceBrowsable();
            SourceList_Data sourceList_Data = new SourceList_Data(null);
            this.setSourceTypeMediaTypeAttributesName(n, sourceList_Data, string, bl, n3, n2, bl2);
            if (sourceList_Data.sourceType == 255) continue;
            fsgArrayListComplete.putElement(n, sourceList_Data, n);
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
                n2 = 44;
                break;
            }
            case 2: {
                n2 = 4;
                break;
            }
            case 3: {
                n2 = 89;
                break;
            }
            case 4: {
                n2 = 89;
                break;
            }
            case 15: {
                n2 = 134;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    protected void addAdditionalBroadcastSources(FsgArrayListComplete fsgArrayListComplete) {
    }

    protected void addAdditionalVideoSources(FsgArrayListComplete fsgArrayListComplete) {
        if (this.getConfigurationService().isTvFeatureSelected()) {
            SourceList_Data sourceList_Data = new SourceList_Data(null);
            sourceList_Data.sourceType = 9;
            sourceList_Data.instance_Id = 0;
            sourceList_Data.mediaType = 11;
            sourceList_Data.attributes.builtInAndReadyMediumInserted = true;
            sourceList_Data.attributes.mediumAudioNoError = true;
            sourceList_Data.attributes.mediaIsPlayable = true;
            sourceList_Data.attributes.mediumIsReadable = true;
            sourceList_Data.attributes.mediumIsNotBeingLoaded = true;
            sourceList_Data.attributes.noImportRunning = true;
            sourceList_Data.attributes.mediumSupportBrowserListDf4_2 = true;
            sourceList_Data.name.setContent("");
            fsgArrayListComplete.putElement(-6L, sourceList_Data, 0L);
        }
    }

    private void computeFullSourceList(FsgArrayListComplete fsgArrayListComplete) {
        SourceList_Data sourceList_Data;
        SystemService systemService = this.getSystemService();
        if (systemService.isDABAvailable()) {
            sourceList_Data = new SourceList_Data(null);
            sourceList_Data.sourceType = 3;
            sourceList_Data.instance_Id = 0;
            sourceList_Data.mediaType = 10;
            sourceList_Data.attributes.builtInAndReadyMediumInserted = true;
            sourceList_Data.attributes.mediumAudioNoError = true;
            sourceList_Data.attributes.mediaIsPlayable = true;
            sourceList_Data.attributes.mediumIsReadable = true;
            sourceList_Data.attributes.mediumIsNotBeingLoaded = true;
            sourceList_Data.attributes.noImportRunning = true;
            sourceList_Data.attributes.mediumSupportBrowserListDf4_2 = true;
            sourceList_Data.name.setContent("");
            fsgArrayListComplete.putElement(-2L, sourceList_Data, 0L);
        }
        sourceList_Data = new SourceList_Data(null);
        sourceList_Data.sourceType = 1;
        sourceList_Data.instance_Id = 0;
        sourceList_Data.mediaType = 10;
        sourceList_Data.attributes.builtInAndReadyMediumInserted = true;
        sourceList_Data.attributes.mediumAudioNoError = true;
        sourceList_Data.attributes.mediaIsPlayable = true;
        sourceList_Data.attributes.mediumIsReadable = true;
        sourceList_Data.attributes.mediumIsNotBeingLoaded = true;
        sourceList_Data.attributes.noImportRunning = true;
        sourceList_Data.attributes.mediumSupportBrowserListDf4_2 = true;
        sourceList_Data.name.setContent("");
        fsgArrayListComplete.putElement(-3L, sourceList_Data, 0L);
        if (systemService.isAMAvailable()) {
            sourceList_Data = new SourceList_Data(null);
            sourceList_Data.sourceType = 2;
            sourceList_Data.instance_Id = 0;
            sourceList_Data.mediaType = 10;
            sourceList_Data.attributes.builtInAndReadyMediumInserted = true;
            sourceList_Data.attributes.mediumAudioNoError = true;
            sourceList_Data.attributes.mediaIsPlayable = true;
            sourceList_Data.attributes.mediumIsReadable = true;
            sourceList_Data.attributes.mediumIsNotBeingLoaded = true;
            sourceList_Data.attributes.noImportRunning = true;
            sourceList_Data.attributes.mediumSupportBrowserListDf4_2 = true;
            sourceList_Data.name.setContent("");
            fsgArrayListComplete.putElement(-4L, sourceList_Data, 0L);
        }
        this.addAdditionalBroadcastSources(fsgArrayListComplete);
        this.setDataForMediaSources(fsgArrayListComplete);
        this.addAdditionalVideoSources(fsgArrayListComplete);
    }

    private void setInternalFullSourceList(FsgArrayListComplete fsgArrayListComplete) {
        this.setFullSourceList(fsgArrayListComplete);
        this.setNumberOfSourceListElements(new Integer(fsgArrayListComplete.getSize()));
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

    @Override
    public int compare(BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        SourceList_Data sourceList_Data = (SourceList_Data)bAPArrayElement;
        SourceList_Data sourceList_Data2 = (SourceList_Data)bAPArrayElement2;
        boolean bl = sourceList_Data.mediaType == sourceList_Data2.mediaType;
        boolean bl2 = sourceList_Data.attributes.builtInAndReadyMediumInserted == sourceList_Data2.attributes.builtInAndReadyMediumInserted && sourceList_Data.attributes.mediumAudioNoError == sourceList_Data2.attributes.mediumAudioNoError && sourceList_Data.attributes.mediaIsPlayable == sourceList_Data2.attributes.mediaIsPlayable && sourceList_Data.attributes.mediumIsNotBeingLoaded == sourceList_Data2.attributes.mediumIsNotBeingLoaded && sourceList_Data.attributes.noImportRunning == sourceList_Data2.attributes.noImportRunning;
        boolean bl3 = sourceList_Data.name.toString().compareTo(sourceList_Data2.name.toString()) == 0;
        boolean bl4 = sourceList_Data.sourceType == sourceList_Data2.sourceType;
        boolean bl5 = sourceList_Data.instance_Id == sourceList_Data2.instance_Id;
        int n2 = 0;
        switch (n) {
            case -1: {
                if (!bl4 || !bl5 || !bl3 && !bl2 || !bl3 && !bl || !bl2 && !bl) {
                    if (!bl3) {
                        n2 = 0;
                        break;
                    }
                    n2 = 1;
                    break;
                }
                if (!bl) {
                    n2 = 4;
                    break;
                }
                if (!bl2) {
                    n2 = 3;
                    break;
                }
                if (!bl3) {
                    n2 = 2;
                    break;
                }
                n2 = -1;
                break;
            }
            case 0: {
                if (!(bl5 && bl4 && bl3 && bl2 && bl)) {
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
                if (!(bl5 && bl4 && bl3 && bl2 && bl)) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                if (!(bl5 && bl4 && bl3 && bl2 && bl)) {
                    if (!bl3) {
                        n2 = 0;
                        break;
                    }
                    n2 = 1;
                    break;
                }
                n2 = -1;
            }
        }
        return n2;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateMediaData(MediaService mediaService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
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
        SYSTEM_LISTENER_IDS = new int[]{334, 335};
        MEDIA_LISTENER_IDS = new int[]{2781, 3678, 56};
    }
}

