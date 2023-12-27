/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.ImportReport;
import org.dsi.ifc.browser.PathInfo;

public interface DSIBrowserBookmarkListener
extends DSIListener {
    default public void listBookmarksResult(String string, Bookmark[] bookmarkArray, int n) {
    }

    default public void bookmarkListInvalid() {
    }

    default public void addBookmarkResult(Bookmark bookmark, int n) {
    }

    default public void editBookmarkResult(Bookmark bookmark, int n) {
    }

    default public void deleteBookmarkResult(Bookmark bookmark, int n) {
    }

    default public void createFolderResult(Bookmark bookmark, int n) {
    }

    default public void deleteFolderResult(String string, int n) {
    }

    default public void renameFolderResult(String string, int n) {
    }

    default public void exportBookmarksResult(PathInfo pathInfo, int n) {
    }

    default public void updateExportBookmarksProgress(PathInfo pathInfo, int n, int n2) {
    }

    default public void importBookmarksResult(PathInfo pathInfo, ImportReport importReport, int n) {
    }

    default public void updateImportBookmarksProgress(PathInfo pathInfo, int n, int n2) {
    }

    default public void getQuotaInformationResult(int n, int n2, int n3) {
    }
}

