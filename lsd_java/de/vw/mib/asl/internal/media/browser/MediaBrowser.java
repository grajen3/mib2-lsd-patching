/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.browser.BrowserPathData;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListHandler;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;

public interface MediaBrowser {
    default public void rqOpenFolder(ListEntry[] listEntryArray, ResponseHandler responseHandler) {
    }

    default public void rqAddSelection(Selection selection, ResponseHandler responseHandler) {
    }

    default public MediaBrowserState getState() {
    }

    default public ListEntry[] getMatchingBrowseFolder(MediaPlayer mediaPlayer) {
    }

    default public ListEntry getMatchingBrowseEntry(MediaPlayer mediaPlayer) {
    }

    default public boolean isBrowsingAvailable() {
    }

    default public int getInstanceId() {
    }

    default public BrowserPathData getPathData() {
    }

    default public ListEntry[] getBrowseFolder() {
    }

    default public Selection createDefaultSelection() {
    }

    default public Selection createPlaySimilarSelection(PlayMode playMode, EntryInfo entryInfo) {
    }

    default public void setListState(int n) {
    }

    default public int getListSize() {
    }

    default public ListEntry[] getAbsolutePathByListEntry(ListEntry listEntry) {
    }

    default public int getComponentId() {
    }

    default public void rqListEntry(long l, int n, String string, int n2, boolean bl, ResponseHandler responseHandler) {
    }

    default public ExtendedListEntry getRequestedListEntry() {
    }

    default public void setFocusedElement(ExtendedListEntry extendedListEntry) {
    }

    default public void rqList(long l, int n, int n2, int n3, ResponseHandler responseHandler) {
    }

    default public ExtendedListEntry[] getListResponse() {
    }

    default public MediaBrowserListHandler getListHandler() {
    }
}

