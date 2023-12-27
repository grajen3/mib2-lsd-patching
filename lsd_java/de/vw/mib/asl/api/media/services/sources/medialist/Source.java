/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.sources.medialist;

import de.vw.mib.asl.api.media.services.sources.SourceId;

public interface Source {
    public static final int INSERTION_EMPTY;
    public static final int INSERTION_LOADING;
    public static final int INSERTION_INSERTED;
    public static final int INSERTION_DEVICE_ERROR;
    public static final int INSERTION_READ_ERROR;
    public static final int INSERTION_UNMOUNT_REQUEST;
    public static final int INSERTION_NO_PLAYABLE_FILES;
    public static final int INSERTION_SWDL;
    public static final int INSERTION_NAVI_DB;
    public static final int BROWSING_UNSUPPORTED;
    public static final int BROWSING_LOADING;
    public static final int BROWSING_AVAILABLE;
    public static final int PLAY_SIMILAR_UNSUPPORTED;
    public static final int PLAY_SIMILAR_LOADING;
    public static final int PLAY_SIMILAR_AVAILABLE;

    default public int getInsertion() {
    }

    default public SourceId getSourceId() {
    }

    default public String getMountPoint() {
    }

    default public boolean isUserVisible() {
    }

    default public boolean isPlaying() {
    }

    default public boolean isPlayable() {
    }

    default public boolean hasMedia() {
    }

    default public int getContentBrowsingAvailable() {
    }

    default public int getRawBrowsingAvailable() {
    }

    default public int getPlaySimilarAvailable() {
    }
}

