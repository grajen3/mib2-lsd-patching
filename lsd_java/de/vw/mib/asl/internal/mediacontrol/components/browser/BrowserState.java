/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.components.browser;

import de.vw.mib.asl.internal.mediacontrol.components.browser.ListenerFolderPath;
import de.vw.mib.asl.internal.mediacontrol.components.browser.ListenerInvalidBrowsePath;
import de.vw.mib.asl.internal.mediacontrol.components.browser.ListenerListSize;
import de.vw.mib.asl.internal.mediacontrol.components.browser.ListenerListState;
import java.util.ArrayList;
import org.dsi.ifc.upnp.ListEntry;

public class BrowserState {
    private int mListState = -1;
    public static final int LIST_STATE_NOT_AVAILABLE;
    public static final int LIST_STATE_LOADING;
    public static final int LIST_STATE_EMPTY;
    public static final int LIST_STATE_READY;
    private int mListSize;
    private ArrayList mListSizeListener = new ArrayList();
    private ListEntry[] mFolderPath;
    private ArrayList mFolderPathListener = new ArrayList();
    private ArrayList mListStateListener = new ArrayList();
    private ArrayList mInvalidBrowsePathListener = new ArrayList();

    public void addListSizeListener(ListenerListSize listenerListSize) {
        if (listenerListSize != null) {
            this.mListSizeListener.add(listenerListSize);
            listenerListSize.updateListSize(this);
        }
    }

    private void notifyListSizeListener() {
        for (int i2 = 0; i2 < this.mListSizeListener.size(); ++i2) {
            ListenerListSize listenerListSize = (ListenerListSize)this.mListSizeListener.get(i2);
            listenerListSize.updateListSize(this);
        }
    }

    public void setListSize(int n, int n2, boolean bl) {
        this.mListSize = n;
        this.notifyListSizeListener();
    }

    public int getListSize() {
        return this.mListSize;
    }

    public void addFolderPathListener(ListenerFolderPath listenerFolderPath) {
        if (listenerFolderPath != null) {
            this.mFolderPathListener.add(listenerFolderPath);
            listenerFolderPath.updateFolderPath(this);
        }
    }

    private void notifyFolderPathListener() {
        for (int i2 = 0; i2 < this.mFolderPathListener.size(); ++i2) {
            ListenerFolderPath listenerFolderPath = (ListenerFolderPath)this.mFolderPathListener.get(i2);
            listenerFolderPath.updateFolderPath(this);
        }
    }

    public void setFolderPath(ListEntry[] listEntryArray, boolean bl) {
        this.mFolderPath = listEntryArray;
        this.notifyFolderPathListener();
    }

    public ListEntry[] getFolderPath() {
        return this.mFolderPath;
    }

    public void addListStateListener(ListenerListState listenerListState) {
        if (listenerListState != null) {
            this.mListStateListener.add(listenerListState);
            listenerListState.updateListState(this);
        }
    }

    private void notifyListStateListener() {
        for (int i2 = 0; i2 < this.mListStateListener.size(); ++i2) {
            ListenerListState listenerListState = (ListenerListState)this.mListStateListener.get(i2);
            listenerListState.updateListState(this);
        }
    }

    public void setListState(int n) {
        this.mListState = n;
        this.notifyListStateListener();
    }

    public int getListState() {
        return this.mListState;
    }

    public void addInvalidBrowsePathListener(ListenerInvalidBrowsePath listenerInvalidBrowsePath) {
        if (listenerInvalidBrowsePath != null) {
            this.mInvalidBrowsePathListener.add(listenerInvalidBrowsePath);
        }
    }

    private void notifyInvalidBrowsePathListener() {
        for (int i2 = 0; i2 < this.mInvalidBrowsePathListener.size(); ++i2) {
            ListenerInvalidBrowsePath listenerInvalidBrowsePath = (ListenerInvalidBrowsePath)this.mInvalidBrowsePathListener.get(i2);
            listenerInvalidBrowsePath.indicateInvalidBrowsePath();
        }
    }

    public void indicateInvalidBrowsePath() {
        this.notifyInvalidBrowsePathListener();
    }
}

