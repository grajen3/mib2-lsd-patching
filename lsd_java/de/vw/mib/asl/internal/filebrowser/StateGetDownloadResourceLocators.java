/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser;

import de.vw.mib.asl.internal.filebrowser.HsmTargetFileBrowser;
import de.vw.mib.asl.internal.filebrowser.ModelSessions;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public class StateGetDownloadResourceLocators
extends AbstractHsmState {
    private final HsmTargetFileBrowser _target;
    private final String _classname = super.getClass().getName();
    private EventGeneric answerevent;
    private Path path;
    private String fileName;
    private int sessionHandle = -1;

    public StateGetDownloadResourceLocators(HsmTargetFileBrowser hsmTargetFileBrowser, String string, HsmState hsmState) {
        super(hsmTargetFileBrowser.getHsm(), string, hsmState);
        this._target = hsmTargetFileBrowser;
    }

    void setParameters(EventGeneric eventGeneric, String string, String string2) {
        this.answerevent = eventGeneric;
        this.path = new Path(string, new String[0]);
        this.fileName = string2;
        this.answerevent.setBlocked(true);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".handle(HSM_ENTRY)").log();
                }
                this._target.getDsiFileBrowser().start(this.path);
                break;
            }
        }
        return this;
    }

    private void fail(String string) {
        this._target.warn(string);
        this.answerevent.setBlocked(false);
        this.answerevent.setBoolean(2, false);
        this.answerevent.setObject(3, new ResourceLocator[0]);
        this._target.sendBackSafe(this.answerevent);
        this.transIdle();
    }

    public void dsiFileBrowserStartResult(int n, int n2, Path path) {
        this.sessionHandle = n;
        if (n2 == 0) {
            this._target.getDsiFileBrowser().setFileExtensionFilter(n, ModelSessions.getImageExtensionFilter());
        } else {
            this.fail("dsiFileBrowserStartResult success!=OK");
        }
    }

    public void dsiFileBrowserSetFileExtensionFilterResult(int n, int n2) {
        if (n2 != 0) {
            this.fail("dsiFileBrowserSetFileExtensionFilterResult success!=OK");
        }
        if (n != this.sessionHandle) {
            this.fail("unexpected handle in dsiFileBrowserSetFileExtensionFilterResult!");
        }
        this._target.getDsiFileBrowser().getFileCount(n);
    }

    public void dsiFileBrowserGetFileCountResult(int n, int n2, int n3) {
        if (n2 != 0) {
            this.fail("dsiFileBrowserGetFileCountResult success!=OK");
        }
        if (n != this.sessionHandle) {
            this._target.warn("unexpected handle in dsiFileBrowserGetFileCountResult!");
        }
        if (n3 == 0) {
            if (this.fileName == null) {
                this.answerevent.setBoolean(2, true);
                this.answerevent.setObject(3, new ResourceLocator[0]);
                this.answerevent.setBlocked(false);
                this._target.sendBackSafe(this.answerevent);
                this.transIdle();
            } else {
                this.fail("0 files found");
            }
        }
        if (this.fileName == null) {
            this._target.getDsiFileBrowser().getResourceLocatorWindow(n, n3, 0);
        } else {
            this._target.getDsiFileBrowser().getViewWindow(n, n3, 0);
        }
    }

    public void dsiFileBrowserGetViewWindowResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, int n4) {
        if (n2 != 0) {
            this.fail("dsiFileBrowserGetFileCountResult success!=OK");
        }
        if (n != this.sessionHandle) {
            this._target.warn("unexpected handle in dsiFileBrowserGetViewWindowResult!");
        }
        for (int i2 = 0; i2 < browsedFileSet.getFiles().length; ++i2) {
            BrowsedFile browsedFile = browsedFileSet.getFiles()[i2];
            if (!browsedFile.getFilename().equals(this.fileName)) continue;
            this._target.getDsiFileBrowser().getResourceLocatorWindow(n, 1, i2);
            return;
        }
        this.fail(new StringBuffer().append("file ").append(this.fileName).append(" not found.").toString());
    }

    public void dsiFileBrowserGetResourceLocatorWindowResult(int n, int n2, int n3, ResourceLocator[] resourceLocatorArray, int n4) {
        if (n != this.sessionHandle) {
            this.fail("unexpected handle in dsiFileBrowserGetResourceLocatorWindowResult");
        }
        if (n2 != 0) {
            this.fail("dsiFileBrowserGetResourceLocatorWindowResult success!=OK");
        }
        this.answerevent.setBoolean(2, true);
        this.answerevent.setObject(3, resourceLocatorArray);
        this.answerevent.setBlocked(false);
        this._target.sendBackSafe(this.answerevent);
        this.transIdle();
    }

    private void transIdle() {
        if (this.sessionHandle != -1) {
            this._target.getDsiFileBrowser().stop(this.sessionHandle);
            this.sessionHandle = -1;
        }
        try {
            this.trans(this._target.idleState);
        }
        catch (Exception exception) {
            this._target.error().append("trans failed").attachThrowable(exception).log();
        }
    }
}

