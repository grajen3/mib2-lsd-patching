/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListHandler$MediaListElementFetcher;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.ListEntry;

public interface MediaBrowserListHandler {
    default public void setFetcher(MediaBrowserListHandler$MediaListElementFetcher mediaBrowserListHandler$MediaListElementFetcher) {
    }

    default public void refetch() {
    }

    default public void refresh(int n) {
    }

    default public void updateFolderPath(MediaBrowserState mediaBrowserState) {
    }

    default public void updateListSize(int n) {
    }

    default public void updateListData(ExtendedListEntry[] extendedListEntryArray, int n) {
    }

    default public void updateListData(CharacterInfo[] characterInfoArray) {
    }

    default public void showErrorInformation(ListEntry listEntry) {
    }

    default public ExtendedListEntry getListEntryByIndex(int n) {
    }

    default public ExtendedListEntry getListEntryById(long l, int n) {
    }

    default public ExtendedListEntry getListEntryByTitle(String string) {
    }
}

