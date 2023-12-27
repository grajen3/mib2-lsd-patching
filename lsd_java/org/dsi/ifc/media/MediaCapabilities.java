/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

public class MediaCapabilities {
    public boolean coverArt;
    public boolean playerCoverArt;
    public boolean browserCoverArt;
    public boolean albumBrowser;
    public boolean searchEntries;
    public boolean importData;
    public boolean rawBrowser;
    public boolean favorites;
    public boolean playbackModes;
    public boolean contentBrowser;
    public boolean videoSupport;
    public boolean remoteApps;

    public MediaCapabilities() {
        this.coverArt = false;
        this.playerCoverArt = false;
        this.browserCoverArt = false;
        this.albumBrowser = false;
        this.searchEntries = false;
        this.importData = false;
        this.rawBrowser = false;
        this.favorites = false;
        this.playbackModes = false;
        this.videoSupport = false;
        this.remoteApps = false;
    }

    public MediaCapabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10) {
        this.coverArt = bl;
        this.playerCoverArt = false;
        this.browserCoverArt = false;
        this.albumBrowser = bl2;
        this.searchEntries = bl3;
        this.importData = bl4;
        this.rawBrowser = bl5;
        this.favorites = bl6;
        this.playbackModes = bl7;
        this.contentBrowser = bl8;
        this.videoSupport = bl9;
        this.remoteApps = bl10;
    }

    public MediaCapabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12) {
        this.coverArt = bl;
        this.playerCoverArt = bl2;
        this.browserCoverArt = bl3;
        this.albumBrowser = bl4;
        this.searchEntries = bl5;
        this.importData = bl6;
        this.rawBrowser = bl7;
        this.favorites = bl8;
        this.playbackModes = bl9;
        this.contentBrowser = bl10;
        this.videoSupport = bl11;
        this.remoteApps = bl12;
    }

    public MediaCapabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11) {
        this.coverArt = false;
        this.playerCoverArt = bl;
        this.browserCoverArt = bl2;
        this.albumBrowser = bl3;
        this.searchEntries = bl4;
        this.importData = bl5;
        this.rawBrowser = bl6;
        this.favorites = bl7;
        this.playbackModes = bl8;
        this.contentBrowser = bl9;
        this.videoSupport = bl10;
        this.remoteApps = bl11;
    }

    public boolean isCoverArt() {
        return this.coverArt;
    }

    public boolean isPlayerCoverArt() {
        return this.playerCoverArt;
    }

    public boolean isBrowserCoverArt() {
        return this.browserCoverArt;
    }

    public boolean isAlbumBrowser() {
        return this.albumBrowser;
    }

    public boolean isSearchEntries() {
        return this.searchEntries;
    }

    public boolean isImportData() {
        return this.importData;
    }

    public boolean isRawBrowser() {
        return this.rawBrowser;
    }

    public boolean isFavorites() {
        return this.favorites;
    }

    public boolean isContentBrowser() {
        return this.contentBrowser;
    }

    public boolean isPlaybackModes() {
        return this.playbackModes;
    }

    public boolean isVideoSupport() {
        return this.videoSupport;
    }

    public boolean isRemoteApps() {
        return this.remoteApps;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("MediaCapabilities");
        stringBuffer.append('(');
        stringBuffer.append("coverArt");
        stringBuffer.append('=');
        stringBuffer.append(this.coverArt);
        stringBuffer.append(',');
        stringBuffer.append("playerCoverArt");
        stringBuffer.append('=');
        stringBuffer.append(this.playerCoverArt);
        stringBuffer.append(',');
        stringBuffer.append("browserCoverArt");
        stringBuffer.append('=');
        stringBuffer.append(this.browserCoverArt);
        stringBuffer.append(',');
        stringBuffer.append("albumBrowser");
        stringBuffer.append('=');
        stringBuffer.append(this.albumBrowser);
        stringBuffer.append(',');
        stringBuffer.append("searchEntries");
        stringBuffer.append('=');
        stringBuffer.append(this.searchEntries);
        stringBuffer.append(',');
        stringBuffer.append("importData");
        stringBuffer.append('=');
        stringBuffer.append(this.importData);
        stringBuffer.append(',');
        stringBuffer.append("rawBrowser");
        stringBuffer.append('=');
        stringBuffer.append(this.rawBrowser);
        stringBuffer.append(',');
        stringBuffer.append("favorites");
        stringBuffer.append('=');
        stringBuffer.append(this.favorites);
        stringBuffer.append(',');
        stringBuffer.append("playbackModes");
        stringBuffer.append('=');
        stringBuffer.append(this.playbackModes);
        stringBuffer.append(',');
        stringBuffer.append("contentBrowser");
        stringBuffer.append('=');
        stringBuffer.append(this.contentBrowser);
        stringBuffer.append(',');
        stringBuffer.append("videoSupport");
        stringBuffer.append('=');
        stringBuffer.append(this.videoSupport);
        stringBuffer.append(',');
        stringBuffer.append("remoteApps");
        stringBuffer.append('=');
        stringBuffer.append(this.remoteApps);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

