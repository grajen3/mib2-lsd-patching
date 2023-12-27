/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.sources.current;

import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;

public class CurrentMediaSource
implements Source {
    private final SourceId sourceId;
    private final String mountPoint;
    private final int insertion;
    private final boolean playing;
    private final boolean inserted;
    private final int contentBrowsing;
    private final int rawBrowsing;
    private final int playSimilar;
    private final boolean userAvail;
    private final boolean playable;
    public static final int BROWSING_UNSUPPORTED;
    public static final int BROWSING_LOADING;
    public static final int BROWSING_AVAILABLE;

    public CurrentMediaSource(SourceId sourceId, String string, int n, boolean bl, boolean bl2, int n2, int n3, int n4, boolean bl3, boolean bl4) {
        this.sourceId = sourceId;
        this.mountPoint = string;
        this.insertion = n;
        this.playing = bl;
        this.inserted = bl2;
        this.contentBrowsing = n2;
        this.rawBrowsing = n3;
        this.playSimilar = n4;
        this.userAvail = bl3;
        this.playable = bl4;
    }

    public SourceId getSource() {
        return this.sourceId;
    }

    @Override
    public SourceId getSourceId() {
        return this.sourceId;
    }

    @Override
    public String getMountPoint() {
        return this.mountPoint;
    }

    @Override
    public int getInsertion() {
        return this.insertion;
    }

    @Override
    public boolean isPlaying() {
        return this.playing;
    }

    @Override
    public boolean hasMedia() {
        return this.inserted;
    }

    @Override
    public int getContentBrowsingAvailable() {
        return this.contentBrowsing;
    }

    @Override
    public int getRawBrowsingAvailable() {
        return this.rawBrowsing;
    }

    @Override
    public int getPlaySimilarAvailable() {
        return this.playSimilar;
    }

    @Override
    public boolean isUserVisible() {
        return this.userAvail;
    }

    @Override
    public boolean isPlayable() {
        return this.playable;
    }

    public String toString() {
        return new StringBuffer().append("CurrentMediaSource [sourceId=").append(this.sourceId).append(", insertion=").append(this.insertion).append(", playing=").append(this.playing).append(", inserted=").append(this.inserted).append(", contentBrowsing=").append(this.contentBrowsing).append(", rawBrowsing=").append(this.rawBrowsing).append(", playSimilar=").append(this.playSimilar).append(", userAvail=").append(this.userAvail).append(", playable=").append(this.playable).append("]").toString();
    }
}

