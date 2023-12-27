/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.recorder;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.recorder.AbstractMediaRecorder;
import de.vw.mib.asl.internal.media.recorder.MediaRecorderHelper;
import de.vw.mib.asl.internal.media.recorder.RecorderState;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.ListEntry;

public class MediaRecorder
extends AbstractMediaRecorder {
    private final RecorderState mRecorderState = new RecorderState();
    private static final int RT_SET_ACTIVE_MEDIA = MediaRecorder.assignRequestId();
    private MediaCollector mActiveMedia = null;
    private MediaCollector mRequestedMedia = null;
    private static final int RT_SET_ENCODING_QUALITY = MediaRecorder.assignRequestId();
    private int mRequestedEncodingQuality = -1;
    private static final int RT_SET_SELECTION = MediaRecorder.assignRequestId();
    private static final int RT_EXECUTE_IMPORT = MediaRecorder.assignRequestId();
    private static final int RT_EXECUTE_DELETE = MediaRecorder.assignRequestId();
    private boolean mImportCanceledByUser = false;
    private boolean mImportFinished = false;
    private boolean mImportAborted = false;
    private boolean mDeleteFinished = false;
    private boolean mDeleteAborted = false;
    private boolean mStoreCapacityExceeded = false;
    private long mActiveMediaDeviceId;
    private long mActiveMediaMediaId;
    private int importStatus = -1;
    private boolean deletionRunning = false;
    private int deletionStatus = -1;

    public MediaRecorder(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 363795200;
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    public void reset() {
        this.mRecorderState.reset();
        this.mImportCanceledByUser = false;
        this.mImportFinished = false;
        this.mImportAborted = false;
        this.mDeleteFinished = false;
        this.mDeleteAborted = false;
        this.mStoreCapacityExceeded = false;
        this.valueChangedInteger(2735, 0);
        this.valueChangedInteger(27, 0);
        this.valueChangedInteger(28, 0);
        this.valueChangedInteger(26, 0);
        this.valueChangedBoolean(96, false);
        this.valueChangedBoolean(43, this.mStoreCapacityExceeded);
        this.valueChangedInteger(17, 0);
        this.valueChangedInteger(15, 0);
    }

    public void rqSetActiveMedia(MediaCollector mediaCollector, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SET_ACTIVE_MEDIA, responseHandler)) {
            this.reset();
            this.mActiveMedia = null;
            this.mRequestedMedia = mediaCollector;
            this.importStatus = -1;
            this.deletionStatus = -1;
            this.getDSI().setActiveMedia(mediaCollector.getDeviceID(), mediaCollector.getMediaID());
        }
    }

    public void retrieveId(ISources iSources) {
        this.mActiveMedia = iSources.getSourceById(this.mActiveMediaDeviceId, this.mActiveMediaMediaId);
    }

    public void dsiMediaRecorderUpdateActiveMedia(long l, long l2, int n) {
        this.mActiveMediaDeviceId = l;
        this.mActiveMediaMediaId = l2;
        this.mActiveMedia = this.mRequestedMedia;
        this.mRecorderState.setRecorderMedia(this.mActiveMedia);
        this.detectMediaActivationCompleted();
    }

    private void detectMediaActivationCompleted() {
        if (this.isRegisteredForResponse(RT_SET_ACTIVE_MEDIA)) {
            if (this.mActiveMedia != null && (this.importStatus == 7 || this.deletionStatus == 7)) {
                this.fireResponse(true);
                return;
            }
            if (this.importStatus == 0 || this.deletionStatus == 0) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(324799488);
                ServiceManager.logger.info(1024, "CLOSE_BROWSER");
                this.fireResponse(false, "ready for selection not reached (f.i. due to media ejected)");
            }
        }
    }

    public MediaCollector getActiveMedia() {
        return this.mActiveMedia;
    }

    public void rqSetEncodingQuality(ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SET_ENCODING_QUALITY, responseHandler)) {
            this.mRequestedEncodingQuality = this.getPersistence().getUserEncodingQuality();
            this.getDSI().setEncodingQuality(this.mRequestedEncodingQuality);
        }
    }

    public void dsiMediaRecorderResponseSetEncodingQuality(int n) {
        this.fireResponse(this.mRequestedEncodingQuality == n, RT_SET_ENCODING_QUALITY);
        this.mRequestedEncodingQuality = -1;
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("RECORDER ~ ENCODING QUALITY: ").append(n).toString());
        }
    }

    public void rqSetSelection(Selection selection, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SET_SELECTION, responseHandler)) {
            if (selection == null || selection.getInstanceID() != 7) {
                this.fireResponse(false);
                return;
            }
            this.getDSI().setSelection(selection.getInstanceID());
        }
    }

    public void dsiMediaRecorderResponseSetSelection(int n, boolean bl) {
        if (bl) {
            this.fireResponse(n == 7, RT_SET_SELECTION);
        }
    }

    public void rqStartImport(boolean bl, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_EXECUTE_IMPORT, responseHandler)) {
            this.getDSI().startImport(bl);
        }
    }

    public void rqStartDelete(ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_EXECUTE_DELETE, responseHandler)) {
            this.getDSI().startDelete();
        }
    }

    public void abortImport() {
        this.mImportCanceledByUser = true;
        this.getDSI().abortImport();
    }

    public void abortDelete() {
        this.getDSI().abortDelete();
    }

    public void dsiMediaRecorderUpdateDatabaseSpace(DatabaseSpace databaseSpace, int n) {
        this.valueChangedInteger(21, (int)databaseSpace.getSizeAvail());
        this.valueChangedInteger(19, (int)databaseSpace.getNumEntries());
        this.valueChangedInteger(20, (int)databaseSpace.getMaxEntries());
        this.valueChangedInteger(22, (int)databaseSpace.getSize());
        int n2 = 0;
        if (databaseSpace.getNumEntries() > 0L) {
            n2 = (int)(databaseSpace.getSize() - databaseSpace.getSizeAvail());
        }
        this.valueChangedInteger(23, n2);
        this.valueChangedBoolean(39, true);
    }

    public void dsiMediaRecorderUpdateImportStatus(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("RECORDER ~ IMPORT STATE: ").append(MediaRecorderHelper.getImportStatusStr(n)).toString());
        }
        if (n2 != 1) {
            this.importStatus = -1;
            return;
        }
        this.importStatus = n;
        boolean bl = true;
        switch (n) {
            case 0: {
                if (this.mImportFinished) {
                    this.valueChangedInteger(2735, 4);
                    this.fireResponse(true, RT_EXECUTE_IMPORT);
                }
                if (this.mImportAborted) {
                    if (this.mImportCanceledByUser) {
                        this.valueChangedInteger(2735, 5);
                        this.mImportCanceledByUser = false;
                    } else {
                        this.valueChangedInteger(2735, 6);
                    }
                    this.fireResponse(true, RT_EXECUTE_IMPORT);
                }
                this.valueChangedInteger(2735, 0);
                this.mImportAborted = false;
                this.mImportFinished = false;
                break;
            }
            case 1: {
                this.valueChangedInteger(2735, 3);
                bl = false;
                break;
            }
            case 2: {
                this.valueChangedInteger(2735, 1);
                break;
            }
            case 3: {
                bl = false;
                break;
            }
            case 4: {
                bl = false;
                this.mImportFinished = true;
                break;
            }
            case 5: {
                bl = false;
                this.mImportAborted = true;
                break;
            }
            case 6: {
                bl = false;
                this.fireResponse(true, RT_EXECUTE_IMPORT, "import suspended");
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                bl = false;
                MediaObjectAccessor.mMediaController.resumeImport();
                break;
            }
        }
        this.mRecorderState.setRecorderIdle(bl);
        this.detectMediaActivationCompleted();
    }

    public void onDeviceChanges() {
        MediaCollector mediaCollector = this.getActiveMedia();
        this.deletionRunning = mediaCollector != null && mediaCollector.isFlagSet(4096);
        this.detectDeletionCompleted();
    }

    private void detectDeletionCompleted() {
        if (this.isRegisteredForResponse(RT_EXECUTE_DELETE)) {
            if (!this.deletionRunning && this.deletionStatus == 0) {
                this.fireResponse(true);
            } else {
                this.trace().append("Not firing response for RT_EXECUTE_DELETE, deletionRunning=").append(this.deletionRunning).append(", deletionStatus=").append(this.deletionStatus).log();
            }
        }
    }

    public void dsiMediaRecorderUpdateDeletionStatus(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("RECORDER ~ DELETE STATE: ").append(MediaRecorderHelper.getDeleteStatusStr(n)).toString());
        }
        if (n2 != 1) {
            this.deletionStatus = -1;
            return;
        }
        this.deletionStatus = n;
        boolean bl = true;
        switch (n) {
            case 0: {
                if (this.mDeleteFinished) {
                    this.valueChangedInteger(2734, 4);
                    this.detectDeletionCompleted();
                }
                if (this.mDeleteAborted) {
                    this.valueChangedInteger(2734, 5);
                    this.detectDeletionCompleted();
                }
                this.mDeleteAborted = false;
                this.mDeleteFinished = false;
                bl = true;
                this.valueChangedInteger(2734, 0);
                break;
            }
            case 1: {
                bl = false;
                this.valueChangedInteger(2734, 3);
                break;
            }
            case 2: {
                this.valueChangedInteger(2734, 1);
                break;
            }
            case 3: {
                bl = false;
                this.valueChangedBoolean(96, true);
                break;
            }
            case 4: {
                bl = false;
                this.mDeleteFinished = true;
                break;
            }
            case 5: {
                bl = false;
                this.mDeleteAborted = true;
                break;
            }
            case 7: {
                this.detectMediaActivationCompleted();
                break;
            }
        }
        this.mRecorderState.setRecorderIdle(bl);
    }

    public void dsiMediaRecorderUpdateImportProgress(long l, ListEntry listEntry, int n) {
        this.valueChangedInteger(17, (int)l);
    }

    public void dsiMediaRecorderUpdateDeletionProgress(long l, int n) {
        this.valueChangedInteger(15, (int)l);
    }

    public void dsiMediaRecorderUpdateImportSummary(long l, long l2, long l3, long l4, long l5, long l6, int n) {
        this.valueChangedInteger(27, (int)(l4 + l6));
        this.valueChangedInteger(28, (int)(l + l5));
    }

    public void dsiMediaRecorderAsyncException(int n, String string, int n2) {
        switch (n2) {
            case 1000: {
                this.fireResponse(false, RT_SET_ACTIVE_MEDIA);
                break;
            }
            case 1005: 
            case 1006: {
                this.fireResponse(false, RT_EXECUTE_DELETE);
                break;
            }
            case 1003: 
            case 1004: {
                this.fireResponse(false, RT_EXECUTE_IMPORT);
                break;
            }
            case 1007: {
                this.fireResponse(false, RT_SET_ENCODING_QUALITY);
                break;
            }
            case 1001: {
                this.fireResponse(false, RT_SET_SELECTION);
                break;
            }
        }
    }

    public void notifyFileSelectionDone(Selection selection) {
        boolean bl;
        long l = selection.getEntriesSelected();
        long l2 = selection.getEntriesAvailable();
        long l3 = selection.getSizeSelected();
        long l4 = selection.getSizeAvailable();
        long l5 = selection.getPlaylistsSelected();
        boolean bl2 = bl = l4 <= l3 || l2 < l;
        if (this.mStoreCapacityExceeded != bl) {
            this.info(new StringBuffer().append("RECORDER ~ StoreCapacityExceeded changed to ").append(bl).toString());
            this.valueChangedBoolean(43, bl);
            this.mStoreCapacityExceeded = bl;
        }
        int n = (int)(l + l5);
        this.valueChangedInteger(27, n);
        this.valueChangedInteger(26, n);
        this.valueChangedBoolean(96, n > 0);
    }

    public RecorderState getRecorderState() {
        return this.mRecorderState;
    }

    public int getUserEncodingQuality() {
        return this.getPersistence().getUserEncodingQuality();
    }

    public void setUserEncodingQuality(int n) {
        this.getPersistence().setUserEncodingQuality(n);
    }

    @Override
    public int getComponentId() {
        return 8;
    }
}

