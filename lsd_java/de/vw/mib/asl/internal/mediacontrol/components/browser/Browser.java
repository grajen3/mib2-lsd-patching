/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.components.browser;

import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.common.component.ResponseHandler;
import de.vw.mib.asl.internal.mediacontrol.components.browser.AbstractBrowser;
import de.vw.mib.asl.internal.mediacontrol.components.browser.BrowserState;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import org.dsi.ifc.upnp.ListEntry;

public class Browser
extends AbstractBrowser {
    BrowserState mState = new BrowserState();
    private final int RT_OPEN_FOLDER = Browser.assignRequestId();
    private ListEntry[] mRequestedFolderPath;
    private ListEntry[] mLastListResponse = null;
    private final int RT_LIST = Browser.assignRequestId();

    public BrowserState getState() {
        return this.mState;
    }

    public Browser(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getComponentId() {
        return 2;
    }

    public void rqOpenFolder(ListEntry[] listEntryArray, ResponseHandler responseHandler) {
        if (this.registerForResponse(this.RT_OPEN_FOLDER, responseHandler)) {
            if (Util.isNullOrEmpty(listEntryArray)) {
                this.fireResponse(false, "openFolder: path must not be null/empty");
                return;
            }
            if (Helper.isSameFolder(listEntryArray, this.getState().getFolderPath())) {
                this.fireResponse(true, "openFolder: path already open");
                return;
            }
            this.mRequestedFolderPath = listEntryArray;
            this.getDSI().changeFolder(listEntryArray);
        }
    }

    public void dsiUPNPBrowserUpdateBrowseFolder(ListEntry[] listEntryArray, int n) {
        this.mState.setFolderPath(listEntryArray, n == 1);
        this.mState.setListSize(0, 0, n == 1);
    }

    public void dsiUPNPBrowserUpdateListSize(int n, int n2, int n3) {
        this.mState.setListSize(n, n2, n3 == 1);
        if (this.isRegisteredForResponse(this.RT_OPEN_FOLDER)) {
            if (Helper.isSameFolder(this.mRequestedFolderPath, this.getState().getFolderPath())) {
                this.fireResponse(true, this.RT_OPEN_FOLDER);
            }
        } else if (this.getState().getListState() == -1 && !Util.isNullOrEmpty(this.getState().getFolderPath())) {
            this.getState().setListState(2);
        }
    }

    public void rqList(String string, int n, int n2, int n3, ResponseHandler responseHandler) {
        if (this.registerForResponse(this.RT_LIST, responseHandler)) {
            this.getDSI().requestList(string, n, n2, n3);
        }
    }

    public void dsiUPNPBrowserResponseList(ListEntry[] listEntryArray, int n) {
        if (this.isRegisteredForResponse(this.RT_LIST)) {
            if (Util.isNullOrEmpty(listEntryArray)) {
                this.mLastListResponse = null;
                this.fireResponse(false, "null or empty list");
                return;
            }
            this.mLastListResponse = listEntryArray;
            this.fireResponse(true);
        }
    }

    public void dsiUPNPBrowserInvalidBrowsePath() {
        this.mState.indicateInvalidBrowsePath();
    }

    public ListEntry[] getListResponse() {
        return this.mLastListResponse;
    }

    public ListEntry[] getAbsolutePath(String string, int n) {
        ListEntry[] listEntryArray = this.getState().getFolderPath();
        ListEntry[] listEntryArray2 = new ListEntry[listEntryArray.length + 1];
        System.arraycopy((Object)listEntryArray, 0, (Object)listEntryArray2, 0, listEntryArray.length);
        listEntryArray2[listEntryArray2.length - 1] = new ListEntry(string, null, null, n, 0, 0);
        return listEntryArray2;
    }

    public ListEntry[] getDeviceSelectionPath() {
        ListEntry[] listEntryArray = null;
        ListEntry[] listEntryArray2 = this.getState().getFolderPath();
        if (listEntryArray2 != null && listEntryArray2.length >= 1) {
            listEntryArray = new ListEntry[]{listEntryArray2[0]};
        }
        return listEntryArray;
    }

    public ListEntry[] getDeviceRootPath() {
        ListEntry[] listEntryArray = null;
        ListEntry[] listEntryArray2 = this.getState().getFolderPath();
        if (listEntryArray2 != null && listEntryArray2.length >= 2) {
            listEntryArray = new ListEntry[]{listEntryArray2[0], listEntryArray2[1]};
        }
        return listEntryArray;
    }

    public ListEntry[] getParentFolder(int n) {
        ListEntry[] listEntryArray = null;
        Object[] objectArray = this.getState().getFolderPath();
        if (!Util.isNullOrEmpty(objectArray)) {
            int n2 = objectArray.length - Math.abs(n);
            if (n2 < 1) {
                n2 = 1;
            }
            listEntryArray = new ListEntry[n2];
            System.arraycopy((Object)objectArray, 0, (Object)listEntryArray, 0, n2);
        }
        return listEntryArray;
    }

    public void dsiUPNPBrowserAsyncException(int n, String string, int n2) {
        if (n2 == 1001) {
            if (this.isRegisteredForResponse(this.RT_LIST)) {
                this.fireResponse(false, new StringBuffer().append("dsiRequestList async: ").append(string).toString());
            }
        } else if (n2 == 1000 && this.isRegisteredForResponse(this.RT_OPEN_FOLDER)) {
            this.fireResponse(false, new StringBuffer().append("dsiOpenFolder async: ").append(string).toString());
        }
    }
}

