/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayObjectId;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowserControl_Result;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowserControl_StartResult;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceList_Data;

public final class MediaBrowserControl
extends Function
implements TimerNotifier,
Method,
ASLAudioSDConstants,
MediaServiceListener {
    private int _currentBapAction = -1;
    private int _bapPosIdToBrowse;
    private static final int BAP_ACTION_NOTHING;
    private static final int BAP_ACTION_SWITCH_SOURCE;
    private FsgArrayListComplete fullSourceList = null;
    private FsgArrayListWindowed currentArrayList = null;
    private int _reportedSourceListReference;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int FOLDER_LEVEL_ROOT;
    private static final int FOLDER_LEVEL_PARENT_DIRECTORY;
    private static final int INVALID_ASL_SOURCE_DEVICE_ID;
    private static final int INVALID_BROWSER_ENTRY_ID;
    protected static final int[] MEDIA_LISTENER_IDS;
    protected static final int[] MEDIA_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaBrowserControl_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getMediaService().addMediaServiceListener(this, MEDIA_LISTENER_IDS);
        this.getMediaService().addHMIEventListener(this, MEDIA_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 1625948160);
        return null;
    }

    protected MediaBrowserControl_Result dequeueBAPEntity() {
        return (MediaBrowserControl_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaBrowserControl_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaBrowserControl_Result = MediaBrowserControl.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowserControl_Result")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaBrowserControl_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 32: {
                this.setFullSourceList((FsgArrayListComplete)object);
                break;
            }
            case 36: {
                this.setCurrentArrayList((FsgArrayListWindowed)object);
                break;
            }
            case 16: {
                this.setActiveSourceListReference((Long)object);
                break;
            }
        }
    }

    protected void setMediaBrowserActiveComponent(Boolean bl) {
        int[] nArray = new int[]{36, 24, 35, 16};
        this.context.updateStages(this, nArray, bl);
    }

    protected void setMediaBrowserActionSucceeded(Integer n) {
        int[] nArray = new int[]{36};
        this.context.updateStages(this, nArray, n);
    }

    protected void setMediaBrowserActionStarted(Long l) {
        int[] nArray = new int[]{36};
        this.context.updateStages(this, nArray, l);
    }

    protected void setActivateBapPosId(Integer n) {
        int[] nArray = new int[]{34};
        this.context.updateStages(this, nArray, n);
    }

    @Override
    public int getFunctionId() {
        return 38;
    }

    @Override
    public void initialize(boolean bl) {
        this.setCurrentBapAction(-1);
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getMediaService().removeMediaServiceListener(this, MEDIA_LISTENER_IDS);
        this.getMediaService().removeHMIEventListener(this, MEDIA_LISTENER_HMI_EVENT_IDS);
    }

    @Override
    public void process(int n) {
    }

    private void activeMediaSource(int n) {
        this.setActivateBapPosId(new Integer(n));
        this.setCurrentBapAction(-2);
        this.setMediaBrowserActiveComponent(Boolean.FALSE);
    }

    private void startResultGoToSource(MethodListener methodListener, int n) {
        int n2 = this.getAslDeviceIdForBapPosId(n);
        if (n2 != -1) {
            boolean bl = this.isSourceBrowseable(n);
            if (!(bl && this.getBapPosIdToBrowse() != n || this.getActiveSourceListReference() != n)) {
                this.setMediaBrowserActiveComponent(bl);
                this.startResultSucceeded(methodListener);
            } else if (bl) {
                this.setBapPosIdToBrowse(n);
                this.getMediaService().startBrowsingSourceById(n2);
                this.setCurrentBapAction(3);
            } else {
                this.activeMediaSource(n);
            }
        } else {
            this.startResultFailed(methodListener);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        MediaBrowserControl_StartResult mediaBrowserControl_StartResult = (MediaBrowserControl_StartResult)bAPEntity;
        if (!MediaBrowserControl.inputParametersValid(mediaBrowserControl_StartResult)) {
            methodListener.requestError(65, this);
        } else if (this.getCurrentBapAction() != -1) {
            this.startResultFailed(methodListener);
        } else {
            switch (mediaBrowserControl_StartResult.control) {
                case 0: {
                    if (this.isSourceBrowseable(this.getActiveSourceListReference())) {
                        this.getMediaService().triggerFollowMode();
                        this.setCurrentBapAction(mediaBrowserControl_StartResult.control);
                        break;
                    }
                    this.setMediaBrowserActiveComponent(Boolean.FALSE);
                    this.startResultSucceeded(methodListener);
                    break;
                }
                case 1: {
                    this.getMediaService().moveFolderLevelUp(0);
                    this.setCurrentBapAction(mediaBrowserControl_StartResult.control);
                    break;
                }
                case 2: {
                    this.getMediaService().moveFolderLevelUp(1);
                    this.setCurrentBapAction(mediaBrowserControl_StartResult.control);
                    break;
                }
                case 3: {
                    this.startResultGoToSource(methodListener, mediaBrowserControl_StartResult.reference);
                    break;
                }
                case 4: {
                    long l = this.getBrowserEntryIdForBapPosId(mediaBrowserControl_StartResult.reference);
                    if (l != -1L) {
                        this.getMediaService().openFolderEntry(l, this.getMediaService().getFolderContentTypeForFilerBrowserContentType(this.getBrowserContentTypeForBapPosId(mediaBrowserControl_StartResult.reference)));
                        this.setCurrentBapAction(mediaBrowserControl_StartResult.control);
                        break;
                    }
                    this.startResultFailed(methodListener);
                    break;
                }
                default: {
                    methodListener.requestError(65, this);
                }
            }
        }
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.getCurrentBapAction() != -1) {
            this.setCurrentBapAction(-1);
            this.sendResult(methodListener, 2);
        } else {
            this.sendResult(methodListener, 3);
        }
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    protected void mediaBrowserActionWasPerformed() {
        int n = this.getCurrentBapAction();
        if (n != -1) {
            boolean bl;
            MediaService mediaService = this.getMediaService();
            switch (mediaService.getCurrentAction().getCurrentActionType()) {
                case 0: {
                    boolean bl2 = bl = n == 3;
                    if (!bl) break;
                    if (mediaService.getBapMediaBrowserState() == 1) {
                        bl = false;
                        this.activeMediaSource(this.getBapPosIdToBrowse());
                        break;
                    }
                    this.setMediaBrowserActiveComponent(Boolean.TRUE);
                    break;
                }
                case 1: {
                    bl = this.getCurrentBapAction() == 4;
                    break;
                }
                case 2: {
                    bl = n == 2 || n == 1;
                    break;
                }
                case 3: {
                    bl = n == 0;
                    break;
                }
                default: {
                    bl = false;
                }
            }
            if (bl) {
                if (mediaService.getCurrentAction().getCurrentActionStatus() == 3) {
                    this.startResultFailed(null);
                } else {
                    this.startResultSucceeded(null);
                }
            }
        }
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case -2: 
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                this.startResultFailed(null);
                break;
            }
            default: {
                if (this.getCurrentBapAction() == -1) break;
                this.setCurrentBapAction(-1);
            }
        }
    }

    protected void setFullSourceList(FsgArrayListComplete fsgArrayListComplete) {
        this.fullSourceList = fsgArrayListComplete;
    }

    protected void setCurrentArrayList(FsgArrayListWindowed fsgArrayListWindowed) {
        this.currentArrayList = fsgArrayListWindowed;
    }

    protected void setActiveSourceListReference(Long l) {
        int n = l.intValue();
        if (n != this._reportedSourceListReference) {
            this._reportedSourceListReference = n;
            if (this.getCurrentBapAction() == -2) {
                this.startResultSucceeded(null);
            }
            if (this.isSourceBrowseable(this.getActiveSourceListReference())) {
                this.setMediaBrowserActiveComponent(Boolean.FALSE);
            }
        }
    }

    private int getActiveSourceListReference() {
        return this._reportedSourceListReference;
    }

    private void startResultSucceeded(MethodListener methodListener) {
        this.setMediaBrowserActionSucceeded(new Integer(this.getMediaService().getCurrentAction().getCurrentActionType()));
        this.sendResult(methodListener, 0);
        this.setCurrentBapAction(-1);
    }

    private void startResultFailed(MethodListener methodListener) {
        this.sendResult(methodListener, 1);
        this.setCurrentBapAction(-1);
    }

    private static boolean inputParametersValid(MediaBrowserControl_StartResult mediaBrowserControl_StartResult) {
        return mediaBrowserControl_StartResult.control >= 0 && mediaBrowserControl_StartResult.control <= 4;
    }

    private void sendResult(MethodListener methodListener, int n) {
        MediaBrowserControl_Result mediaBrowserControl_Result = this.dequeueBAPEntity();
        mediaBrowserControl_Result.browserControlResult = n;
        if (methodListener != null) {
            methodListener.result(mediaBrowserControl_Result, this);
        } else {
            this.getDelegate().getMethodListener(this).result(mediaBrowserControl_Result, this);
        }
    }

    private int getAslDeviceIdForBapPosId(int n) {
        int n2 = this.fullSourceList != null ? (int)this.fullSourceList.getInternalUserId(n) : -1;
        return n2;
    }

    private SourceList_Data findSourceListData(int n) {
        return this.fullSourceList != null ? (SourceList_Data)this.fullSourceList.getElement(n) : null;
    }

    private long getBrowserEntryIdForBapPosId(int n) {
        long l;
        if (this.currentArrayList != null) {
            FsgArrayObjectId fsgArrayObjectId = this.currentArrayList.getObjectId(n);
            l = fsgArrayObjectId.getEntryId();
        } else {
            l = -1L;
        }
        return l;
    }

    private int getBrowserContentTypeForBapPosId(int n) {
        int n2;
        if (this.currentArrayList != null) {
            FsgArrayObjectId fsgArrayObjectId = this.currentArrayList.getObjectId(n);
            n2 = fsgArrayObjectId.getInternalUserId();
        } else {
            n2 = 0;
        }
        return n2;
    }

    private boolean isSourceBrowseable(int n) {
        boolean bl;
        SourceList_Data sourceList_Data = this.findSourceListData(n);
        if (sourceList_Data != null) {
            switch (sourceList_Data.sourceType) {
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 9: 
                case 12: {
                    bl = false;
                    break;
                }
                default: {
                    bl = true;
                    break;
                }
            }
        } else {
            bl = false;
        }
        return bl && this.getMediaService().isBapMediaBrowserAvailable();
    }

    private int getCurrentBapAction() {
        return this._currentBapAction;
    }

    private void setCurrentBapAction(int n) {
        this._currentBapAction = n;
        if (n != -1) {
            this.timer.retrigger(new Integer(n));
            this.setMediaBrowserActionStarted(new Long(n));
        } else if (this.timer.isRunning()) {
            this.timer.setUserInfo(new Integer(n));
        }
    }

    private int getBapPosIdToBrowse() {
        return this._bapPosIdToBrowse;
    }

    private void setBapPosIdToBrowse(int n) {
        this._bapPosIdToBrowse = n;
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 556: {
                this.mediaBrowserActionWasPerformed();
                break;
            }
        }
    }

    @Override
    public void updateMediaData(MediaService mediaService, int n) {
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
        MEDIA_LISTENER_IDS = new int[]{3834, 542903296};
        MEDIA_LISTENER_HMI_EVENT_IDS = new int[]{556};
    }
}

