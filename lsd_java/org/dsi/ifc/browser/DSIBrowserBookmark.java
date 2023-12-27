/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.PathInfo;

public interface DSIBrowserBookmark
extends DSIBase {
    public static final String VERSION;
    public static final int RT_LISTBOOKMARKS;
    public static final int RT_ADDBOOKMARK;
    public static final int RT_EDITBOOKMARK;
    public static final int RT_DELETEBOOKMARK;
    public static final int RT_CREATEFOLDER;
    public static final int RT_DELETEFOLDER;
    public static final int RT_RENAMEFOLDER;
    public static final int RT_EXPORTBOOKMARKS;
    public static final int RT_IMPORTBOOKMARKS;
    public static final int RT_GETQUOTAINFORMATION;
    public static final int ATTR_IMPORTBOOKMARKSPROGRESS;
    public static final int ATTR_EXPORTBOOKMARKSPROGRESS;
    public static final int RP_LISTBOOKMARKSRESULT;
    public static final int RP_ADDBOOKMARKRESULT;
    public static final int RP_EDITBOOKMARKRESULT;
    public static final int RP_DELETEBOOKMARKRESULT;
    public static final int RP_CREATEFOLDERRESULT;
    public static final int RP_DELETEFOLDERRESULT;
    public static final int RP_RENAMEFOLDERRESULT;
    public static final int RP_EXPORTBOOKMARKSRESULT;
    public static final int RP_IMPORTBOOKMARKSRESULT;
    public static final int RP_GETQUOTAINFORMATIONRESULT;
    public static final int IN_BOOKMARKLISTINVALID;

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
}

