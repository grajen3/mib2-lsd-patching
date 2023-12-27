/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.recorder;

import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.recorder.RecorderStateListener;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

public class RecorderState {
    private MediaCollector mRecorderMedia = null;
    private RecorderStateListener mListener = null;
    private boolean mIdle = true;

    public void setListener(RecorderStateListener recorderStateListener) {
        this.mListener = recorderStateListener;
    }

    public void reset() {
        this.setRecorderMedia(null);
    }

    public MediaCollector getActiveMedia() {
        return this.mRecorderMedia;
    }

    public void setRecorderMedia(MediaCollector mediaCollector) {
        if (this.mRecorderMedia != mediaCollector) {
            this.mRecorderMedia = mediaCollector;
            if (this.mListener != null) {
                this.mListener.onRecorderMediaChanged(this.mRecorderMedia);
            }
        }
    }

    public void setRecorderIdle(boolean bl) {
        if (this.mIdle != bl) {
            this.mIdle = bl;
            if (bl) {
                MediaObjectAccessor.mMediaController.syncCoverFlow();
            }
        }
    }

    public boolean isRecorderIdle() {
        return this.mIdle;
    }
}

