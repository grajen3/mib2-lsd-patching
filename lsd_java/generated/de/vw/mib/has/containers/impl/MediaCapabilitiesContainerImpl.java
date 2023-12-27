/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.MediaCapabilitiesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class MediaCapabilitiesContainerImpl
extends AbstractContainer
implements MediaCapabilitiesContainer {
    private static final byte ELEMENT_COVER_ART;
    private static final byte ELEMENT_DATABASE_BROWSE_MODE;
    private static final byte ELEMENT_DETAIL_INFO;
    private static final byte ELEMENT_ELAPSED_TIME;
    private static final byte ELEMENT_FAST_BACKWARD;
    private static final byte ELEMENT_FAST_FORWARD;
    private static final byte ELEMENT_PAUSE;
    private static final byte ELEMENT_PLAY;
    private static final byte ELEMENT_PLAYBACK_MODES;
    private static final byte ELEMENT_PLAYING_TIME;
    private static final byte ELEMENT_PMLT_MODE;
    private static final byte ELEMENT_RAW_BROWSE_MODE;
    private static final byte ELEMENT_SET_TIME_POS;
    private static final byte ELEMENT_SKIP_BACKWARD;
    private static final byte ELEMENT_SKIP_FORWARD;
    private boolean attrCoverArt;
    private boolean attrDatabaseBrowseMode;
    private boolean attrDetailInfo;
    private boolean attrElapsedTime;
    private boolean attrFastBackward;
    private boolean attrFastForward;
    private boolean attrPause;
    private boolean attrPlay;
    private boolean attrPlaybackModes;
    private boolean attrPlayingTime;
    private boolean attrPMLTMode;
    private boolean attrRawBrowseMode;
    private boolean attrSetTimePos;
    private boolean attrSkipBackward;
    private boolean attrSkipForward;

    @Override
    public int getContainerId() {
        return 66;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean getCoverArt() {
        return this.attrCoverArt;
    }

    @Override
    public boolean getDatabaseBrowseMode() {
        return this.attrDatabaseBrowseMode;
    }

    @Override
    public boolean getDetailInfo() {
        return this.attrDetailInfo;
    }

    @Override
    public boolean getElapsedTime() {
        return this.attrElapsedTime;
    }

    @Override
    public boolean getFastBackward() {
        return this.attrFastBackward;
    }

    @Override
    public boolean getFastForward() {
        return this.attrFastForward;
    }

    @Override
    public boolean getPause() {
        return this.attrPause;
    }

    @Override
    public boolean getPlay() {
        return this.attrPlay;
    }

    @Override
    public boolean getPlaybackModes() {
        return this.attrPlaybackModes;
    }

    @Override
    public boolean getPlayingTime() {
        return this.attrPlayingTime;
    }

    @Override
    public boolean getPMLTMode() {
        return this.attrPMLTMode;
    }

    @Override
    public boolean getRawBrowseMode() {
        return this.attrRawBrowseMode;
    }

    @Override
    public boolean getSetTimePos() {
        return this.attrSetTimePos;
    }

    @Override
    public boolean getSkipBackward() {
        return this.attrSkipBackward;
    }

    @Override
    public boolean getSkipForward() {
        return this.attrSkipForward;
    }

    @Override
    public boolean isCoverArtSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isDatabaseBrowseModeSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isDetailInfoSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public boolean isElapsedTimeSet() {
        return this._isElementSet((byte)3);
    }

    @Override
    public boolean isFastBackwardSet() {
        return this._isElementSet((byte)4);
    }

    @Override
    public boolean isFastForwardSet() {
        return this._isElementSet((byte)5);
    }

    @Override
    public boolean isPauseSet() {
        return this._isElementSet((byte)6);
    }

    @Override
    public boolean isPlaySet() {
        return this._isElementSet((byte)7);
    }

    @Override
    public boolean isPlaybackModesSet() {
        return this._isElementSet((byte)8);
    }

    @Override
    public boolean isPlayingTimeSet() {
        return this._isElementSet((byte)9);
    }

    @Override
    public boolean isPMLTModeSet() {
        return this._isElementSet((byte)10);
    }

    @Override
    public boolean isRawBrowseModeSet() {
        return this._isElementSet((byte)11);
    }

    @Override
    public boolean isSetTimePosSet() {
        return this._isElementSet((byte)12);
    }

    @Override
    public boolean isSkipBackwardSet() {
        return this._isElementSet((byte)13);
    }

    @Override
    public boolean isSkipForwardSet() {
        return this._isElementSet((byte)14);
    }

    @Override
    public void setCoverArt(boolean bl) {
        this.attrCoverArt = bl;
        this._setElement((byte)0, true);
    }

    @Override
    public void setDatabaseBrowseMode(boolean bl) {
        this.attrDatabaseBrowseMode = bl;
        this._setElement((byte)1, true);
    }

    @Override
    public void setDetailInfo(boolean bl) {
        this.attrDetailInfo = bl;
        this._setElement((byte)2, true);
    }

    @Override
    public void setElapsedTime(boolean bl) {
        this.attrElapsedTime = bl;
        this._setElement((byte)3, true);
    }

    @Override
    public void setFastBackward(boolean bl) {
        this.attrFastBackward = bl;
        this._setElement((byte)4, true);
    }

    @Override
    public void setFastForward(boolean bl) {
        this.attrFastForward = bl;
        this._setElement((byte)5, true);
    }

    @Override
    public void setPause(boolean bl) {
        this.attrPause = bl;
        this._setElement((byte)6, true);
    }

    @Override
    public void setPlay(boolean bl) {
        this.attrPlay = bl;
        this._setElement((byte)7, true);
    }

    @Override
    public void setPlaybackModes(boolean bl) {
        this.attrPlaybackModes = bl;
        this._setElement((byte)8, true);
    }

    @Override
    public void setPlayingTime(boolean bl) {
        this.attrPlayingTime = bl;
        this._setElement((byte)9, true);
    }

    @Override
    public void setPMLTMode(boolean bl) {
        this.attrPMLTMode = bl;
        this._setElement((byte)10, true);
    }

    @Override
    public void setRawBrowseMode(boolean bl) {
        this.attrRawBrowseMode = bl;
        this._setElement((byte)11, true);
    }

    @Override
    public void setSetTimePos(boolean bl) {
        this.attrSetTimePos = bl;
        this._setElement((byte)12, true);
    }

    @Override
    public void setSkipBackward(boolean bl) {
        this.attrSkipBackward = bl;
        this._setElement((byte)13, true);
    }

    @Override
    public void setSkipForward(boolean bl) {
        this.attrSkipForward = bl;
        this._setElement((byte)14, true);
    }

    @Override
    public void unsetCoverArt() {
        this.attrCoverArt = false;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetDatabaseBrowseMode() {
        this.attrDatabaseBrowseMode = false;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetDetailInfo() {
        this.attrDetailInfo = false;
        this._setElement((byte)2, false);
    }

    @Override
    public void unsetElapsedTime() {
        this.attrElapsedTime = false;
        this._setElement((byte)3, false);
    }

    @Override
    public void unsetFastBackward() {
        this.attrFastBackward = false;
        this._setElement((byte)4, false);
    }

    @Override
    public void unsetFastForward() {
        this.attrFastForward = false;
        this._setElement((byte)5, false);
    }

    @Override
    public void unsetPause() {
        this.attrPause = false;
        this._setElement((byte)6, false);
    }

    @Override
    public void unsetPlay() {
        this.attrPlay = false;
        this._setElement((byte)7, false);
    }

    @Override
    public void unsetPlaybackModes() {
        this.attrPlaybackModes = false;
        this._setElement((byte)8, false);
    }

    @Override
    public void unsetPlayingTime() {
        this.attrPlayingTime = false;
        this._setElement((byte)9, false);
    }

    @Override
    public void unsetPMLTMode() {
        this.attrPMLTMode = false;
        this._setElement((byte)10, false);
    }

    @Override
    public void unsetRawBrowseMode() {
        this.attrRawBrowseMode = false;
        this._setElement((byte)11, false);
    }

    @Override
    public void unsetSetTimePos() {
        this.attrSetTimePos = false;
        this._setElement((byte)12, false);
    }

    @Override
    public void unsetSkipBackward() {
        this.attrSkipBackward = false;
        this._setElement((byte)13, false);
    }

    @Override
    public void unsetSkipForward() {
        this.attrSkipForward = false;
        this._setElement((byte)14, false);
    }
}

