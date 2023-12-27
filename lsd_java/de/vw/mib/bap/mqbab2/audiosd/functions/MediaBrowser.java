/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.audiosd.functions.MediaBrowser$MediaBrowserObjectId;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaServiceListener;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.iterator.elements.MediaFileBrowserElement;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListGenericIdGenerator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed$BAPArrayListDelegate;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayObjectId;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayObjectIdGenerator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayPosIdIterator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_Data;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_FileState;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_GetArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_StatusArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_Data;
import java.util.Iterator;

public class MediaBrowser
extends Function
implements TimerNotifier,
FsgArrayListWindowed$BAPArrayListDelegate,
FsgArrayObjectIdGenerator,
Array,
ASLAudioSDConstants,
SoundServiceListener,
MediaServiceListener {
    private Timer aslRequestTimer;
    private static final int TIMER_ASL_UPDATE_TIME;
    private static final int TIMER_ASL_ACTION_NOTHING;
    private static final int TIMER_ASL_ACTION_WAIT_FOR_ASL_LIST;
    private static final String CDDA_TRACK_CONTENT;
    private FsgArrayListWindowed _windowedFileArrayList;
    private FsgArrayListComplete _fullReceptionList;
    private MediaBrowser_GetArray _lastMediaBrowserGetArray;
    private boolean _mediaBrowserActiveComponent;
    private int _mbBrowsedFolderActiveElement;
    private boolean _bapBrowserListNotAvailble;
    private boolean _mbActionRunning;
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;
    private static final int INVALID_MEDIABROWSER_ENTRY_ID;
    protected static final int ACTIVE_LIST_POS_FOLDER_EQUAL_BROWSED_FOLDER;
    private static final int ACTIVE_LIST_POS_FOLDER_HAS_NO_ACTIVE_ELEMENT;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_FILE_TYPE_FILE_STATE;
    private static final int MAX_ELEMENTS_FILE_NAME;
    private static final int MAX_ELEMENTS_POS;
    protected static final int[] SOUND_LISTENER_IDS;
    protected static final int[] MEDIA_LISTENER_IDS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaBrowser_ChangedArray;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$arrays$FsgArrayListComplete;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ReceptionList_ChangedArray;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$Long;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getMediaService().addMediaServiceListener(this, MEDIA_LISTENER_IDS);
        this.aslRequestTimer = this.getTimerService().createTimer(this, 2000);
        this._windowedFileArrayList = new FsgArrayListWindowed(3829, this);
        this._windowedFileArrayList.setObjectIdGenerator(this);
        this._windowedFileArrayList.setArrayListIDGenerator(new FsgArrayListGenericIdGenerator(-65536, 1));
        this._windowedFileArrayList.initialize();
        this.setCurrentArrayList(this.getCurrentWindowedArrayList());
        return this.getMediaBrowserFullRangeUpdate();
    }

    protected MediaBrowser_ChangedArray dequeueBAPEntity() {
        return (MediaBrowser_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaBrowser_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaBrowser_ChangedArray = MediaBrowser.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaBrowser_ChangedArray);
    }

    @Override
    public int getFunctionId() {
        return 36;
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 23: {
                if (object.getClass() == (class$de$vw$mib$bap$mqbab2$common$arrays$FsgArrayListComplete == null ? (class$de$vw$mib$bap$mqbab2$common$arrays$FsgArrayListComplete = MediaBrowser.class$("de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete")) : class$de$vw$mib$bap$mqbab2$common$arrays$FsgArrayListComplete)) {
                    this.setFullReceptionList((FsgArrayListComplete)object);
                    break;
                }
                if (object.getClass() != (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ReceptionList_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ReceptionList_ChangedArray = MediaBrowser.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ReceptionList_ChangedArray)) break;
                this.setReceptionListChangedArray((ReceptionList_ChangedArray)object);
                break;
            }
            case 38: {
                if (object.getClass() == (class$java$lang$Boolean == null ? (class$java$lang$Boolean = MediaBrowser.class$("java.lang.Boolean")) : class$java$lang$Boolean)) {
                    this.setMediaBrowserActiveComponent((Boolean)object);
                    break;
                }
                if (object.getClass() == (class$java$lang$Integer == null ? (class$java$lang$Integer = MediaBrowser.class$("java.lang.Integer")) : class$java$lang$Integer)) {
                    this.setMediaBrowserActionSucceeded((Integer)object);
                    break;
                }
                if (object.getClass() != (class$java$lang$Long == null ? (class$java$lang$Long = MediaBrowser.class$("java.lang.Long")) : class$java$lang$Long)) break;
                this.setMediaBrowserActionStarted((Long)object);
                break;
            }
        }
    }

    protected void setCurrentArrayList(FsgArrayListWindowed fsgArrayListWindowed) {
        int[] nArray = new int[]{38, 24, 22, 35, 44};
        this.context.updateStages(this, nArray, fsgArrayListWindowed);
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.aslRequestTimer.stop();
        this.getArrayRequestTracker().reset();
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getMediaService().removeMediaServiceListener(this, MEDIA_LISTENER_IDS);
    }

    protected FsgArrayMessageBlockingTracker getArrayRequestTracker() {
        if (this._arrayRequestTracker == null) {
            this._arrayRequestTracker = new FsgArrayMessageBlockingRequestTracker(this, this.getDelegate().getArrayListener(this));
        }
        return this._arrayRequestTracker;
    }

    protected boolean isMediaBrowserActive() {
        MediaService mediaService = this.getMediaService();
        SoundService soundService = this.getSoundService();
        return mediaService.isBapMediaBrowserAvailable() && (soundService.getCurrentAudioComponent() == 2 || soundService.getCurrentAudioComponent() == 6) || this.getMediaBrowserActiveComponent();
    }

    @Override
    public void process(int n) {
        int n2 = this.getMediaService().getBapMediaBrowserState();
        switch (n2) {
            case 1: 
            case 3: {
                if (!this.getMediaBrowserActionRunning()) {
                    this.mediaBrowserListChanged();
                }
                this.setBapBrowserListNotAvailble(false);
                break;
            }
            case 4: {
                if (this.getBapBrowserListNotAvailble() && !this.getMediaBrowserActionRunning()) {
                    this.mediaBrowserListChanged();
                }
                int n3 = this.getBapActiveListPos();
                if (this.getMbBrowsedFolderActiveElement() != n3) {
                    this.setMbBrowsedFolderActiveElement(n3);
                    if (!this.getMediaBrowserActionRunning()) {
                        this.transmitNewActiveListPos();
                    }
                }
                this.setBapBrowserListNotAvailble(false);
                break;
            }
            default: {
                this.setBapBrowserListNotAvailble(true);
            }
        }
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        if (this.isMediaBrowserActive()) {
            this.getArrayMediaBrowser(this.getCurrentWindowedArrayList(), (MediaBrowser_GetArray)bAPEntity, arrayListener);
        } else {
            this.getArrayRadioList((MediaBrowser_GetArray)bAPEntity, arrayListener);
        }
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.requestError(65, this);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        this.getArrayRequestTracker().indicationError(n);
    }

    @Override
    public void requestAcknowledge() {
        this.getArrayRequestTracker().requestAcknowledge();
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 1: {
                this.simulateEmptyMediaBrowserArrayAnswer(this.getLastMediaBrowserGetArray());
                break;
            }
        }
    }

    protected void getArrayRadioList(MediaBrowser_GetArray mediaBrowser_GetArray, ArrayListener arrayListener) {
        this.getArrayReceptionList(this.getFullReceptionList(), mediaBrowser_GetArray, arrayListener);
    }

    private FsgArrayListWindowed getCurrentWindowedArrayList() {
        return this._windowedFileArrayList;
    }

    protected void transmitStatus(MediaBrowser_StatusArray mediaBrowser_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(mediaBrowser_StatusArray);
    }

    private void transmitNewActiveListPos() {
        if (this.isMediaBrowserActive()) {
            MediaBrowser_StatusArray mediaBrowser_StatusArray = new MediaBrowser_StatusArray();
            mediaBrowser_StatusArray.setBroadcast(true);
            mediaBrowser_StatusArray.activeListPos = this.getMbBrowsedFolderActiveElement();
            mediaBrowser_StatusArray.totalNumListElements = this.getCurrentWindowedArrayList().getSize();
            this.getArrayRequestTracker().reportStatusArray(mediaBrowser_StatusArray);
        }
    }

    private int getBapActiveListPos() {
        int n;
        if (this.isMediaBrowserActive()) {
            MediaService mediaService = this.getMediaService();
            if (mediaService.getBapMediaBrowserState() == 0 || mediaService.getActiveTrackInfo().getActiveTrackAbsolutePosition() != -1 || mediaService.getBapMediaBrowserState() == 1) {
                n = -1;
            } else {
                FsgArrayObjectId fsgArrayObjectId = MediaBrowser.createObjectID(mediaService.getBrowsedFolderActiveElement().getBrowsedFolderActiveElementEntryId(), mediaService.getBapContentTypeForBrowsedFolderActiveElement(mediaService.getBrowsedFolderActiveElement().getBrowsedFolderActiveElementContentType()));
                n = this.getCurrentWindowedArrayList().getBapPosIdOrGenerate(fsgArrayObjectId);
                if (n == 0) {
                    n = 0;
                }
            }
        } else {
            n = -1;
        }
        return n;
    }

    private void setLastMediaBrowserGetRequest(MediaBrowser_GetArray mediaBrowser_GetArray) {
        this._lastMediaBrowserGetArray = mediaBrowser_GetArray;
    }

    private MediaBrowser_GetArray getLastMediaBrowserGetArray() {
        return this._lastMediaBrowserGetArray;
    }

    private int getMbBrowsedFolderActiveElement() {
        return this._mbBrowsedFolderActiveElement;
    }

    private void setMbBrowsedFolderActiveElement(int n) {
        this._mbBrowsedFolderActiveElement = n;
    }

    private boolean getBapBrowserListNotAvailble() {
        return this._bapBrowserListNotAvailble;
    }

    private void setBapBrowserListNotAvailble(boolean bl) {
        this._bapBrowserListNotAvailble = bl;
    }

    private void setMediaBrowserActionRunning(boolean bl) {
        this._mbActionRunning = bl;
    }

    protected boolean getMediaBrowserActionRunning() {
        return this._mbActionRunning;
    }

    private void simulateEmptyMediaBrowserArrayAnswer(MediaBrowser_GetArray mediaBrowser_GetArray) {
        MediaBrowser_StatusArray mediaBrowser_StatusArray = new MediaBrowser_StatusArray();
        mediaBrowser_StatusArray.asg_Id = mediaBrowser_GetArray.asg_Id;
        mediaBrowser_StatusArray.taid = mediaBrowser_GetArray.taid;
        mediaBrowser_StatusArray.totalNumListElements = this.getCurrentWindowedArrayList().getSize();
        mediaBrowser_StatusArray.activeListPos = this.getBapActiveListPos();
        FsgArrayRequestData fsgArrayRequestData = this.computeArrayRequestData(this.getCurrentWindowedArrayList(), mediaBrowser_GetArray);
        fsgArrayRequestData.setTransmissionPosForArbitraryArray(mediaBrowser_StatusArray);
        this.transmitStatus(mediaBrowser_StatusArray);
    }

    private void getArrayMediaBrowser(FsgArrayListWindowed fsgArrayListWindowed, MediaBrowser_GetArray mediaBrowser_GetArray, ArrayListener arrayListener) {
        if (this.getArrayRequestTracker().requestGetArray(mediaBrowser_GetArray)) {
            if (this.aslRequestTimer.isRunning()) {
                if (this.getMediaBrowserActionRunning()) {
                    this.simulateEmptyMediaBrowserArrayAnswer(mediaBrowser_GetArray);
                    this.getCurrentWindowedArrayList().stopProcessingGetArray();
                }
            } else {
                this.setLastMediaBrowserGetRequest(mediaBrowser_GetArray);
                this.aslRequestTimer.retrigger(new Integer(1));
                fsgArrayListWindowed.processGetArray(mediaBrowser_GetArray);
            }
        }
    }

    protected void getArrayReceptionList(FsgArrayListComplete fsgArrayListComplete, MediaBrowser_GetArray mediaBrowser_GetArray, ArrayListener arrayListener) {
        if (this.getArrayRequestTracker().requestGetArray(mediaBrowser_GetArray)) {
            FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(mediaBrowser_GetArray.getArrayHeader(), fsgArrayListComplete, MediaBrowser.maximumElementsForRecordAddress(mediaBrowser_GetArray.getArrayHeader().getRecordAddress()));
            MediaBrowser_StatusArray mediaBrowser_StatusArray = new MediaBrowser_StatusArray();
            fsgArrayRequestData.setStatusArrayHeaderDataAndFillRequestData(mediaBrowser_StatusArray, mediaBrowser_GetArray, fsgArrayListComplete);
            mediaBrowser_StatusArray.activeListPos = -1;
            fsgArrayRequestData.setTransmissionPosForArbitraryArray(mediaBrowser_StatusArray);
            int n = mediaBrowser_StatusArray.getArrayData().size();
            for (int i2 = 0; i2 < n; ++i2) {
                ReceptionList_Data receptionList_Data = (ReceptionList_Data)mediaBrowser_StatusArray.getArrayData().get(i2);
                mediaBrowser_StatusArray.getArrayData().replace(i2, this.transformReceptionListDataElement(receptionList_Data, (MediaBrowser_Data)mediaBrowser_StatusArray.createArrayElement()));
            }
            this.transmitStatus(mediaBrowser_StatusArray);
        }
    }

    private MediaBrowser_Data transformReceptionListDataElement(ReceptionList_Data receptionList_Data, MediaBrowser_Data mediaBrowser_Data) {
        mediaBrowser_Data.setPos(receptionList_Data.getPos());
        mediaBrowser_Data.fileName.setContent(receptionList_Data.name);
        mediaBrowser_Data.fileType = 2;
        return mediaBrowser_Data;
    }

    protected static int maximumElementsForRecordAddress(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 4;
                break;
            }
            case 1: {
                n2 = 82;
                break;
            }
            case 2: {
                n2 = 4;
                break;
            }
            case 15: {
                n2 = 205;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private MediaBrowser_ChangedArray getMediaBrowserFullRangeUpdate() {
        MediaBrowser_ChangedArray mediaBrowser_ChangedArray = this.dequeueBAPEntity();
        mediaBrowser_ChangedArray.getArrayHeader().setFullRangeUpdate(true);
        return mediaBrowser_ChangedArray;
    }

    private MediaBrowser_ChangedArray searchForChangeContent() {
        return this.getMediaBrowserFullRangeUpdate();
    }

    protected void mediaBrowserListChanged() {
        if (!this.getMediaBrowserActionRunning()) {
            this.getArrayRequestTracker().reportChangedArray(this.searchForChangeContent());
        }
    }

    private static void setMediaBrowserFileStateFromBrowserFlags(MediaBrowser_FileState mediaBrowser_FileState, int n) {
        mediaBrowser_FileState.drmProteced = (n & 2) == 2;
        mediaBrowser_FileState.emptyFolder = (n & 1) == 1;
        mediaBrowser_FileState.deadLink = (n & 8) == 8;
        mediaBrowser_FileState.importPending = (n & 0x100) == 256;
        mediaBrowser_FileState.importRunning = (n & 0x80) == 128;
        mediaBrowser_FileState.corruptedFileFolder = !mediaBrowser_FileState.drmProteced && (n & 4) == 4;
        mediaBrowser_FileState.importNotPlayable = false;
    }

    private static int getBapFileTypeForBrowserContentType(int n, boolean bl, boolean bl2) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 6;
                break;
            }
            case 2: {
                n2 = 7;
                break;
            }
            case 3: {
                n2 = 11;
                break;
            }
            case 4: {
                n2 = 1;
                break;
            }
            case 5: {
                n2 = 3;
                break;
            }
            case 6: {
                n2 = 4;
                break;
            }
            case 7: {
                n2 = 12;
                break;
            }
            case 8: {
                n2 = 13;
                break;
            }
            case 9: {
                n2 = 14;
                break;
            }
            case 10: {
                n2 = 54;
                break;
            }
            case 11: {
                if (bl2) {
                    n2 = bl ? 61 : 43;
                    break;
                }
                n2 = bl ? 62 : 44;
                break;
            }
            case 13: {
                n2 = bl ? 23 : 21;
                break;
            }
            case 14: {
                if (bl2) {
                    n2 = bl ? 34 : 32;
                    break;
                }
                n2 = bl ? 35 : 33;
                break;
            }
            case 15: {
                if (bl2) {
                    n2 = bl ? 38 : 36;
                    break;
                }
                n2 = bl ? 39 : 37;
                break;
            }
            case 16: {
                if (bl2) {
                    n2 = bl ? 18 : 16;
                    break;
                }
                n2 = bl ? 19 : 17;
                break;
            }
            case 17: {
                if (bl2) {
                    n2 = bl ? 26 : 24;
                    break;
                }
                n2 = bl ? 27 : 25;
                break;
            }
            case 18: {
                if (bl2) {
                    n2 = bl ? 81 : 40;
                    break;
                }
                n2 = bl ? 82 : 41;
                break;
            }
            case 20: {
                n2 = 60;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private static int getBapFileTypeForDynamicPlaylistFilterCriteria(String string) {
        int n;
        if (string.endsWith(".dynPlaylistLastPlayed")) {
            n = 52;
        } else if (string.endsWith(".dynPlaylistMostPlayed")) {
            n = 51;
        } else if (string.endsWith(".dynPlaylistLastCopied")) {
            n = 59;
        } else if (string.startsWith("filterCriteria.dynPlaylistStars")) {
            switch (string.charAt(string.length() - 1)) {
                case '0': {
                    n = 45;
                    break;
                }
                case '1': {
                    n = 46;
                    break;
                }
                case '2': {
                    n = 47;
                    break;
                }
                case '3': {
                    n = 48;
                    break;
                }
                case '4': {
                    n = 49;
                    break;
                }
                case '5': {
                    n = 50;
                    break;
                }
                default: {
                    n = 0;
                    break;
                }
            }
        } else {
            n = 0;
        }
        return n;
    }

    private static int computeBapFileType(boolean bl, String string, int n) {
        int n2;
        if (bl && string.startsWith("filterCriteria.all")) {
            n2 = 42;
        } else if (bl && string.startsWith("filterCriteria.dynPlaylist")) {
            n2 = MediaBrowser.getBapFileTypeForDynamicPlaylistFilterCriteria(string);
        } else {
            boolean bl2;
            boolean bl3 = bl2 = bl ? string.startsWith("filterCriteria.unknown") : false;
            boolean bl4 = bl ? !string.endsWith("s") : true;
            n2 = MediaBrowser.getBapFileTypeForBrowserContentType(n, bl2, bl4);
        }
        return n2;
    }

    protected MediaFileBrowserElement getFileBrowserElementAtIndex(int n) {
        Iterator iterator = this.getMediaService().getWindowedFileBrowser(new int[]{n});
        if (iterator.hasNext()) {
            return (MediaFileBrowserElement)iterator.next();
        }
        return null;
    }

    private static void fillMediaBrowserData(MediaBrowser_Data mediaBrowser_Data, String string, int n, int n2, boolean bl) {
        String string2;
        if (!bl) {
            boolean bl2 = string.startsWith("filterCriteria.");
            string2 = bl2 ? "" : string;
            mediaBrowser_Data.fileType = MediaBrowser.computeBapFileType(bl2, string, n);
        } else {
            mediaBrowser_Data.fileType = 8;
            int n3 = "cdda.track".length();
            string2 = n3 >= 0 && n3 <= string.length() ? string.substring(n3) : string;
        }
        MediaBrowser.setMediaBrowserFileStateFromBrowserFlags(mediaBrowser_Data.fileState, n2);
        mediaBrowser_Data.fileName.setContent(string2);
    }

    private static boolean isCddaDisc(MediaFileBrowserElement mediaFileBrowserElement) {
        boolean bl = mediaFileBrowserElement != null ? mediaFileBrowserElement.getFileTitle().startsWith("cdda.track") : false;
        return bl;
    }

    private static boolean isCdTextDisc(MediaFileBrowserElement mediaFileBrowserElement) {
        boolean bl = mediaFileBrowserElement != null ? mediaFileBrowserElement.getFileName().endsWith(".cda") && mediaFileBrowserElement.getFileName().startsWith("track") : false;
        return bl;
    }

    @Override
    public void getArrayAnswer(FsgArrayListWindowed fsgArrayListWindowed, FsgArrayPosIdIterator fsgArrayPosIdIterator, FsgArrayRequestData fsgArrayRequestData, int[] nArray, BAPGetArray bAPGetArray) {
        if (this.aslRequestTimer.isRunning()) {
            Object object;
            MediaBrowser_StatusArray mediaBrowser_StatusArray = new MediaBrowser_StatusArray();
            MediaBrowser_GetArray mediaBrowser_GetArray = (MediaBrowser_GetArray)bAPGetArray;
            mediaBrowser_StatusArray.activeListPos = this.getBapActiveListPos();
            fsgArrayRequestData.setStatusArrayHeaderData(mediaBrowser_StatusArray, mediaBrowser_GetArray, fsgArrayListWindowed);
            MediaService mediaService = this.getMediaService();
            Iterator iterator = mediaService.getWindowedFileBrowser(nArray);
            boolean bl = false;
            boolean bl2 = false;
            if (iterator.hasNext()) {
                object = (MediaFileBrowserElement)iterator.next();
                bl = MediaBrowser.isCddaDisc((MediaFileBrowserElement)object);
                bl2 = mediaService.isDatabaseBrowsingActive() || bl || MediaBrowser.isCdTextDisc((MediaFileBrowserElement)object);
            }
            object = mediaBrowser_StatusArray.getArrayData();
            iterator = mediaService.getWindowedFileBrowser(nArray);
            while (iterator.hasNext() && fsgArrayPosIdIterator.hasNext()) {
                String string;
                int n = fsgArrayPosIdIterator.next();
                MediaFileBrowserElement mediaFileBrowserElement = (MediaFileBrowserElement)iterator.next();
                MediaBrowser_Data mediaBrowser_Data = (MediaBrowser_Data)mediaBrowser_StatusArray.createArrayElement();
                mediaBrowser_Data.setPos(n);
                if (bl2) {
                    string = mediaFileBrowserElement.getFileTitle();
                    if (string.length() == 0) {
                        string = mediaFileBrowserElement.getFileName();
                    }
                } else {
                    string = mediaFileBrowserElement.getFileName();
                    if (string.length() == 0) {
                        string = mediaFileBrowserElement.getFileTitle();
                    }
                }
                MediaBrowser.fillMediaBrowserData(mediaBrowser_Data, string, mediaFileBrowserElement.getFileContentType(), mediaFileBrowserElement.getFileBrowserFlags(), bl);
                ((BAPArrayData)object).add(mediaBrowser_Data);
            }
            fsgArrayRequestData.setTransmissionPosForArbitraryArray(mediaBrowser_StatusArray);
            this.transmitStatus(mediaBrowser_StatusArray);
            this.aslRequestTimer.stop();
        } else {
            this.mediaBrowserListChanged();
        }
    }

    @Override
    public FsgArrayRequestData computeArrayRequestData(FsgArrayListWindowed fsgArrayListWindowed, BAPGetArray bAPGetArray) {
        int n = MediaBrowser.maximumElementsForRecordAddress(bAPGetArray.getArrayHeader().getRecordAddress());
        return FsgArrayRequestData.computeArrayRequestData(bAPGetArray.getArrayHeader(), this._windowedFileArrayList, n);
    }

    @Override
    public void listCacheCleared(FsgArrayListWindowed fsgArrayListWindowed) {
        this.mediaBrowserListChanged();
        this.setCurrentArrayList(this.getCurrentWindowedArrayList());
    }

    @Override
    public void listWasChanged(FsgArrayListWindowed fsgArrayListWindowed) {
        if (this.isMediaBrowserActive()) {
            MediaService mediaService = this.getMediaService();
            int n = mediaService.getBapMediaBrowserState();
            switch (n) {
                case -1: 
                case 3: 
                case 4: {
                    this.mediaBrowserListChanged();
                    break;
                }
            }
        }
    }

    private static FsgArrayObjectId createObjectID(long l, int n, int n2) {
        return l != -1L ? new MediaBrowser$MediaBrowserObjectId(l, n, n2) : FsgArrayListWindowed.INVALID_OBJECT_ID;
    }

    static FsgArrayObjectId createObjectID(long l, int n) {
        return MediaBrowser.createObjectID(l, n, -1);
    }

    @Override
    public FsgArrayObjectId createObjectID(Object object, int n) {
        MediaFileBrowserElement mediaFileBrowserElement = this.getFileBrowserElementAtIndex(n);
        long l = mediaFileBrowserElement.getFileEntryId();
        int n2 = mediaFileBrowserElement.getFileContentType();
        return MediaBrowser.createObjectID(l, n2, n);
    }

    @Override
    public boolean compareObjectID(FsgArrayObjectId fsgArrayObjectId, Object object) {
        if (FsgArrayListWindowed.INVALID_OBJECT_ID != fsgArrayObjectId) {
            MediaBrowser$MediaBrowserObjectId mediaBrowser$MediaBrowserObjectId = (MediaBrowser$MediaBrowserObjectId)fsgArrayObjectId;
            Iterator iterator = this.getMediaService().getWindowedFileBrowser(new int[]{fsgArrayObjectId.getPosIndex()});
            if (iterator.hasNext()) {
                MediaFileBrowserElement mediaFileBrowserElement = (MediaFileBrowserElement)iterator.next();
                return mediaBrowser$MediaBrowserObjectId.equalTo(mediaFileBrowserElement.getFileEntryId(), mediaFileBrowserElement.getFileContentType());
            }
            return false;
        }
        return false;
    }

    protected void setFullReceptionList(FsgArrayListComplete fsgArrayListComplete) {
        this._fullReceptionList = fsgArrayListComplete;
    }

    protected FsgArrayListComplete getFullReceptionList() {
        return this._fullReceptionList;
    }

    protected void setMediaBrowserActiveComponent(Boolean bl) {
        boolean bl2 = this.isMediaBrowserActive();
        boolean bl3 = bl;
        if (this._mediaBrowserActiveComponent != bl3) {
            this._mediaBrowserActiveComponent = bl3;
            if (bl2) {
                this.mediaBrowserListChanged();
                this.setCurrentArrayList(this.getCurrentWindowedArrayList());
            }
        }
    }

    private boolean getMediaBrowserActiveComponent() {
        return this._mediaBrowserActiveComponent;
    }

    protected void setReceptionListChangedArray(ReceptionList_ChangedArray receptionList_ChangedArray) {
        if (!this.isMediaBrowserActive()) {
            if (receptionList_ChangedArray.getArrayHeader().isFullRangeUpdate()) {
                this.mediaBrowserListChanged();
            } else if (!this.getMediaBrowserActionRunning() && receptionList_ChangedArray.getArrayHeader().getRecordAddress() != 5 && receptionList_ChangedArray.getArrayHeader().getRecordAddress() != 2) {
                MediaBrowser_ChangedArray mediaBrowser_ChangedArray = this.dequeueBAPEntity();
                BAPEntity bAPEntity = receptionList_ChangedArray.getArrayHeader();
                BAPEntity bAPEntity2 = mediaBrowser_ChangedArray.getArrayHeader();
                ((ArrayHeader)bAPEntity2).setRecordAddress(2, ((ArrayHeader)bAPEntity).getSerializationRecordAddress());
                ((ArrayHeader)bAPEntity2).start = ((ArrayHeader)bAPEntity).start;
                ((ArrayHeader)bAPEntity2).elements = ((ArrayHeader)bAPEntity).elements;
                ((ArrayHeader)bAPEntity2).mode.arrayDirectionIsBackward = ((ArrayHeader)bAPEntity).mode.arrayDirectionIsBackward;
                ((ArrayHeader)bAPEntity2).mode.arrayPositionIsTransmitted = ((ArrayHeader)bAPEntity).mode.arrayPositionIsTransmitted;
                ((ArrayHeader)bAPEntity2).mode.indexSize16BitForStartElements = ((ArrayHeader)bAPEntity).mode.indexSize16BitForStartElements;
                ((ArrayHeader)bAPEntity2).mode.shift = ((ArrayHeader)bAPEntity).mode.shift;
                bAPEntity = receptionList_ChangedArray.getArrayData();
                bAPEntity2 = mediaBrowser_ChangedArray.getArrayData();
                int n = receptionList_ChangedArray.getArrayData().size();
                for (int i2 = 0; i2 < n; ++i2) {
                    ((BAPArrayData)bAPEntity2).add(this.transformReceptionListDataElement((ReceptionList_Data)((BAPArrayData)bAPEntity).get(i2), (MediaBrowser_Data)mediaBrowser_ChangedArray.createArrayElement()));
                }
                this.getArrayRequestTracker().reportChangedArray(mediaBrowser_ChangedArray);
            }
        }
    }

    protected void setMediaBrowserActionSucceeded(Integer n) {
        this.setMediaBrowserActionRunning(false);
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
                this.mediaBrowserListChanged();
                break;
            }
        }
    }

    protected void setMediaBrowserActionStarted(Long l) {
        switch (l.intValue()) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                this.setMediaBrowserActionRunning(true);
                break;
            }
            default: {
                this.setMediaBrowserActionRunning(false);
            }
        }
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateMediaData(MediaService mediaService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSoundData(SoundService soundService, int n) {
        if (this.isMediaBrowserActive()) {
            this.process(-1);
        }
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
        MEDIA_LISTENER_IDS = new int[]{542903296, 526126080, 509348864};
    }
}

