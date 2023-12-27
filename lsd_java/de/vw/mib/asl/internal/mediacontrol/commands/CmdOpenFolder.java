/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.commands;

import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.common.commands.AbstractCommand;
import de.vw.mib.asl.internal.mediacontrol.components.browser.Browser;
import org.dsi.ifc.upnp.ListEntry;

public final class CmdOpenFolder
extends AbstractCommand {
    private static int TIMEOUT = 20000;
    private static final int STEP_1_OPEN_FOLDER;
    private final Browser mBrowser;
    private final ListEntry[] mFolderPath;
    private boolean mFolderChangeNeeded;

    private CmdOpenFolder(Browser browser, ListEntry[] listEntryArray) {
        super(browser.getComponentId(), 1, 1, TIMEOUT);
        this.mBrowser = browser;
        this.mFolderPath = listEntryArray;
    }

    public static CmdOpenFolder createRelativeCmd(Browser browser, String string, int n) {
        ListEntry[] listEntryArray = browser.getAbsolutePath(string, n);
        return new CmdOpenFolder(browser, listEntryArray);
    }

    public static CmdOpenFolder createAbsoluteCmd(Browser browser, ListEntry[] listEntryArray) {
        return new CmdOpenFolder(browser, listEntryArray);
    }

    public static CmdOpenFolder createOpenDeviceSelectionCmd(Browser browser) {
        ListEntry[] listEntryArray = browser.getDeviceSelectionPath();
        return new CmdOpenFolder(browser, listEntryArray);
    }

    public static CmdOpenFolder createOpenDeviceRootCmd(Browser browser) {
        ListEntry[] listEntryArray = browser.getDeviceRootPath();
        return new CmdOpenFolder(browser, listEntryArray);
    }

    public static CmdOpenFolder createOpenParentCmd(Browser browser, int n) {
        ListEntry[] listEntryArray = browser.getParentFolder(n);
        return new CmdOpenFolder(browser, listEntryArray);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                if (!this.mFolderChangeNeeded) {
                    if (this.isTraceEnabled()) {
                        this.trace("openFolder: path already open");
                    }
                    this.nextStep();
                    return;
                }
                this.mBrowser.rqOpenFolder(this.mFolderPath, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    public void onEnter() {
        boolean bl = this.mFolderChangeNeeded = !Helper.isSameFolder(this.mFolderPath, this.mBrowser.getState().getFolderPath());
        if (this.mFolderChangeNeeded) {
            this.mBrowser.getState().setListState(0);
        }
    }

    @Override
    public void onExit() {
        if (this.mBrowser.getState().getListSize() <= 0) {
            this.mBrowser.getState().setListState(1);
        } else {
            this.mBrowser.getState().setListState(2);
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "OPEN_FOLDER";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        String string = Helper.getListEntriesStr(this.mFolderPath);
        return new StringBuffer().append("path=").append(string).toString();
    }
}

