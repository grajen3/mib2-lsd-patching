/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.albumbrowser;

import org.dsi.ifc.base.DSIBase;

public interface DSIAlbumBrowser
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_BROWSERSTATE;
    public static final int ATTR_FOCUSEDENTRY;
    public static final int ATTR_NUMENTRIES;
    public static final int ATTR_SCROLLMODE;
    public static final int ATTR_LISTPOSITION;
    public static final int RT_INITIALIZEBROWSER;
    public static final int RT_DEINITIALIZEBROWSER;
    public static final int RT_STARTACTIVE;
    public static final int RT_STOP;
    public static final int RT_SETSCROLLMODE;
    public static final int RT_SCROLLTICKS;
    public static final int RT_SELECTALBUM;
    public static final int RT_MOVEFOCUS;
    public static final int RT_ALBUMIDXFORFID;
    public static final int RT_STARTPREVIEW;
    public static final int RT_STARTSINGLE;
    public static final int RP_SELECTALBUM;
    public static final int RP_ALBUMIDXFORFID;
    public static final int BROWSERSTATE_STATE_UNKNOWN;
    public static final int BROWSERSTATE_STATE_INITIALIZED;
    public static final int BROWSERSTATE_STATE_ACTIVE;
    public static final int BROWSERSTATE_STATE_SCROLLING;
    public static final int BROWSERSTATE_STATE_SELECTING;
    public static final int BROWSERSTATE_STATE_ANIMATION_ENTRY;
    public static final int BROWSERSTATE_STATE_PREVIEW;
    public static final int BROWSERSTATE_STATE_ANIMATION_OPEN;
    public static final int BROWSERSTATE_STATE_ANIMATION_CLOSE;
    public static final int BROWSERSTATE_STATE_ANIMATION_PREV_OPEN;
    public static final int BROWSERSTATE_STATE_ANIMATION_PREVSCROLLING;
    public static final int BROWSERSTATE_STATE_SINGLE;
    public static final int BROWSERSTATE_STATE_ANIMATION_PREV_CLOSE;
    public static final int SCROLLMODE_SCROLLMODE_NORMAL;
    public static final int SCROLLMODE_SCROLLMODE_FAST;
    public static final int ANIMATIONMODE_ANIMATIONMODE_STILL;
    public static final int ANIMATIONMODE_ANIMATIONMODE_ANIMATE;
    public static final int ALBUMFLAGS_ENTRYFLAG_UNKNOWN_ALBUM;
    public static final int ALBUMFLAGS_ENTRYFLAG_UNKNOWN_ARTIST;

    default public void initializeBrowser(long l, long l2, int n) {
    }

    default public void deinitializeBrowser() {
    }

    default public void startSingle() {
    }

    default public void startPreview() {
    }

    default public void startActive() {
    }

    default public void stop() {
    }

    default public void setScrollMode(int n) {
    }

    default public void scrollTicks(long l) {
    }

    default public void selectAlbum(long l) {
    }

    default public void moveFocus(long l, int n) {
    }

    default public void albumIdxForFID(long l) {
    }
}

