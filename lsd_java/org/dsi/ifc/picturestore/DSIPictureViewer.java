/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturestore;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureViewer
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_VIEWERSTATE;
    public static final int ATTR_SCROLLMODE;
    public static final int ATTR_LISTPOSITION;
    public static final int ATTR_NUMENTRIES;
    public static final int ATTR_NUMSELECTEDENTRIES;
    public static final int PICTUREVIEWERRESULT_OK;
    public static final int PICTUREVIEWERRESULT_ERROR;
    public static final int VIEWERMODE_PICTURESTORE;
    public static final int VIEWERMODE_FILEBROWSER;
    public static final int SELECTIONMODE_OFF;
    public static final int SELECTIONMODE_SINGLE;
    public static final int SELECTIONMODE_MULTI;
    public static final int FILETYPE_UNKNOWNFILE;
    public static final int FILETYPE_FOLDER;
    public static final int FILETYPE_IMAGE;
    public static final int SCROLLMODE_SCROLLMODE_NORMAL;
    public static final int SCROLLMODE_SCROLLMODE_FAST;
    public static final int VIEWERSTATE_STATE_UNKNOWN;
    public static final int VIEWERSTATE_STATE_INITIALIZED;
    public static final int VIEWERSTATE_STATE_ACTIVE;
    public static final int VIEWERSTATE_STATE_SCROLLING;
    public static final int VIEWERSTATE_STATE_SELECTING;
    public static final int VIEWERSTATE_STATE_ANIMATION_CENTERVIEW;
    public static final int VIEWERSTATE_STATE_ANIMATION_SIDEVIEW;
    public static final int ANIMATIONTYPE_CENTERVIEW;
    public static final int ANIMATIONTYPE_SIDEVIEW;
    public static final int ANIMATIONMODE_ANIMATIONMODE_STILL;
    public static final int ANIMATIONMODE_ANIMATIONMODE_ANIMATE;
    public static final int IMPORTFILTER_IMPORT_SOURCE_UNDEFINED;
    public static final int IMPORTFILTER_IMPORT_SOURCE_USB;
    public static final int IMPORTFILTER_IMPORT_SOURCE_SDCARD;
    public static final int IMPORTFILTER_IMPORT_SOURCE_ONLINE;
    public static final int VIEWFILTER_DATETYPE_IMPORTDATE;
    public static final int VIEWFILTER_DATETYPE_CREATIONDATE;
    public static final int SORTING_IMPORTDATE_ASCENDING;
    public static final int SORTING_IMPORTDATE_DESCENDING;
    public static final int RT_INITIALIZEVIEWER;
    public static final int RT_DEINITIALIZEVIEWER;
    public static final int RT_SETSELECTIONMODE;
    public static final int RT_STARTRENDERING;
    public static final int RT_STOPRENDERING;
    public static final int RT_SETSCROLLMODE;
    public static final int RT_SCROLLTICKS;
    public static final int RT_MOVEFOCUS;
    public static final int RT_GETPICTUREINFO;
    public static final int RT_CHANGEFOLDER;
    public static final int RT_TOGGLEPICTURESELECTION;
    public static final int RT_TOGGLEALLPICTURESSELECTION;
    public static final int RT_CLEARALLPICTURESSELECTION;
    public static final int RT_TRIGGERANIMATION;
    public static final int RT_SETFILTERSETID;
    public static final int RT_MOVEFOCUSBYRESOURCELOCATOR;
    public static final int RT_SETSORTINGDIRECTION;
    public static final int RP_GETPICTUREINFORESULT;
    public static final int RP_SELECTIONRESULT;
    public static final int RP_CREATEFILTERSETRESULT;
    public static final int RP_DELETEFILTERSETRESULT;
    public static final int RP_CHANGEDFILTERSETRESULT;
    public static final int RP_GETAVAILABLEYEARSRESULT;
    public static final int RP_GETAVAILABLEMONTHSRESULT;
    public static final int RP_LISTFORCONTEXTWITHFILTERRESULT;
    public static final int RP_DELETEPICTURESWITHFILTERSETRESULT;

    default public void initializeViewer(int n, int n2) {
    }

    default public void deinitializeViewer() {
    }

    default public void setSelectionMode(int n) {
    }

    default public void startRendering() {
    }

    default public void stopRendering() {
    }

    default public void setScrollMode(int n) {
    }

    default public void scrollTicks(long l) {
    }

    default public void moveFocus(long l, int n) {
    }

    default public void getPictureInfo(long l) {
    }

    default public void changeFolder(long l) {
    }

    default public void togglePictureSelection(long l) {
    }

    default public void toggleAllPicturesSelection() {
    }

    default public void clearAllPicturesSelection() {
    }

    default public void triggerAnimation(int n, long l) {
    }

    default public void setFilterSetId(int n) {
    }

    default public void moveFocusByResourceLocator(ResourceLocator resourceLocator, int n) {
    }

    default public void setSortingDirection(int n) {
    }
}

