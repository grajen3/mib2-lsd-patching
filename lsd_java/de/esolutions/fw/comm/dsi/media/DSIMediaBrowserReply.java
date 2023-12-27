/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;

public interface DSIMediaBrowserReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateBrowseMode(int n, int n2) {
    }

    default public void updateContentFilter(int n, int n2) {
    }

    default public void updateBrowseMedia(long l, long l2, int n) {
    }

    default public void updateBrowseFolder(ListEntry[] listEntryArray, int n) {
    }

    default public void updateListSize(int n, int n2, int n3) {
    }

    default public void updateAlphabeticalIndex(CharacterInfo[] characterInfoArray, int n) {
    }

    default public void responseList(ListEntry[] listEntryArray, int n) {
    }

    default public void responsePickList(ListEntry[] listEntryArray) {
    }

    default public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
    }

    default public void responseSetSearchCriteria(int n, boolean bl) {
    }

    default public void updateSearchSize(int n, int n2, int n3, int n4, int n5) {
    }

    default public void responseSelectSearchResult(long l, long l2, boolean bl) {
    }

    default public void responseSetSearchString(String string, boolean bl) {
    }

    default public void updateSearchSpellerState(int n, int n2) {
    }

    default public void responseSearchList(SearchListEntry[] searchListEntryArray, int n) {
    }

    default public void responseSearchListExt(SearchListEntryExt[] searchListEntryExtArray, int n) {
    }

    default public void responseFullyQualifiedName(long l, String string) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

