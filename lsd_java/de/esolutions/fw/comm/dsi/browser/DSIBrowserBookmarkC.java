/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser;

import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.PathInfo;

public interface DSIBrowserBookmarkC {
    default public void listBookmarks(String string) {
    }

    default public void addBookmark(Bookmark bookmark) {
    }

    default public void editBookmark(Bookmark bookmark, Bookmark bookmark2) {
    }

    default public void deleteBookmark(Bookmark bookmark) {
    }

    default public void createFolder(Bookmark bookmark) {
    }

    default public void deleteFolder(String string) {
    }

    default public void renameFolder(String string, String string2) {
    }

    default public void exportBookmarks(PathInfo pathInfo) {
    }

    default public void importBookmarks(PathInfo pathInfo, boolean bl, boolean bl2) {
    }

    default public void getQuotaInformation() {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

