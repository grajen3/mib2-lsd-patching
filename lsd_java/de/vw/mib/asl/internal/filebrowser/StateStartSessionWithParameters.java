/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser;

import de.vw.mib.asl.internal.filebrowser.HsmTargetFileBrowser;
import de.vw.mib.asl.internal.filebrowser.ModelSessions;
import de.vw.mib.asl.internal.filebrowser.sessions.Session;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.filebrowser.DSIFileBrowser;
import org.dsi.ifc.filebrowser.Path;

public class StateStartSessionWithParameters
extends AbstractHsmState {
    private EventGeneric pendingEvent = null;
    private final HsmTargetFileBrowser target;
    private DSIFileBrowser dsiFileBrowser;
    private int currentSessionHandle;
    private boolean hideFolders;
    private int extensionFilter;
    private final String _classname = super.getClass().getName();

    StateStartSessionWithParameters(HsmTargetFileBrowser hsmTargetFileBrowser, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetFileBrowser;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 2: {
                Path path = (Path)this.pendingEvent.getObject(0);
                this.extensionFilter = this.pendingEvent.getInt(1);
                this.hideFolders = this.pendingEvent.getBoolean(2);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append(this._classname).append(".handle(HSM_ENTRY): Path=").append(path == null ? "null" : path.toString()).append(", extFilter=").append(this.extensionFilter).append(", hideFolders=").append(this.hideFolders).append("").log();
                }
                this.dsiFileBrowser = this.target.getDsiFileBrowser();
                this.dsiFileBrowser.start(path);
                break;
            }
            case 2500019: {
                this.cancelStartRequest(eventGeneric);
                break;
            }
            default: {
                hsmState = this.getParent();
            }
        }
        return hsmState;
    }

    private void cancelStartRequest(EventGeneric eventGeneric) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append(this._classname).append(".cancelStartRequest(): Request for starting a new session denied due to pending session start request.").log();
        }
        eventGeneric.setBoolean(0, false);
        eventGeneric.setInt(1, 0);
        this.target.getEventDispatcher().sendBack(eventGeneric);
    }

    public void dsiFileBrowserStartResult(int n, int n2, Path path) {
        this.currentSessionHandle = n;
        if (0 == n2 && path != null) {
            try {
                Session session = this.target.sessions.addSession(this.currentSessionHandle, path);
                session.setMediaInfo(this.target.sourceList.getMediaInfoByMountPoint(path.getMountPoint()));
                session.setDsiHandle(this.currentSessionHandle);
                session.setPendingEvent(this.pendingEvent, this.hideFolders ? 1008 : 1007);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): Browsing session started").log();
                }
            }
            catch (Exception exception) {
                this.target.error().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): ").append(exception.getMessage()).log();
                this.dsiFileBrowser.stop(this.currentSessionHandle);
                this.currentSessionHandle = 0;
                this.transitionToStateIdle();
            }
            if (this.hideFolders) {
                this.dsiFileBrowser.setFileTypeFilter(this.currentSessionHandle, 1);
            } else {
                this.dsiFileBrowser.setFileExtensionFilter(this.currentSessionHandle, ModelSessions.CONTENT_FILTERS[this.extensionFilter]);
            }
        } else {
            this.target.error().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): Invalid parameter.").log();
            this.transitionToStateIdle();
        }
    }

    public void dsiFileBrowserSetFileTypeFilterResult(int n, int n2) {
        Session session = this.target.sessions.getDsiSession(n);
        if (null != session) {
            this.dsiFileBrowser.setFileExtensionFilter(this.currentSessionHandle, ModelSessions.CONTENT_FILTERS[this.extensionFilter]);
        } else {
            this.target.warn().append(this._classname).append(".dsiFileBrowserSetFileTypeFilterResult(): Unknown session handle ").append(n).log();
            this.transitionToStateIdle();
        }
    }

    public void dsiFileBrowserSetFileExtensionFilterResult(int n, int n2) {
        Session session = this.target.sessions.getDsiSession(n);
        if (null != session) {
            this.dsiFileBrowser.getFileCount(this.currentSessionHandle);
        } else {
            this.target.warn().append(this._classname).append(".dsiFileBrowserSetFileExtensionFilterResult(): Unknown session handle ").append(n).log();
            this.transitionToStateIdle();
        }
    }

    public void dsiFileBrowserGetFileCountResult(int n, int n2, int n3) {
        Session session = this.target.sessions.getDsiSession(n);
        if (null != session) {
            session.removeRequest(1015);
            try {
                this.reportNumberOfEntries(n2 == 0, n3);
            }
            catch (GenericEventException genericEventException) {
                this.target.error().append(this._classname).append(".dsiFileBrowserGetFileCountResult(").append(n).append(", ").append(n2).append(", ").append(n3).append(") GenericEventException: ").append(genericEventException.getMessage()).log();
            }
        } else {
            this.target.warn().append(this._classname).append(".dsiFileBrowserGetFileCountResult(").append(n).append(", ").append(n2).append(", ").append(n3).append("): Unknown session.").log();
        }
        this.transitionToStateIdle();
    }

    private void reportNumberOfEntries(boolean bl, int n) {
        if (null != this.pendingEvent) {
            this.pendingEvent.removeAllParameters();
            this.pendingEvent.setBoolean(0, bl);
            this.pendingEvent.setInt(1, this.currentSessionHandle);
            this.pendingEvent.setInt(2, n);
            this.pendingEvent.setBlocked(false);
            this.target.getEventDispatcher().sendBack(this.pendingEvent);
        }
    }

    private void transitionToStateIdle() {
        try {
            this.trans(this.target.idleState);
        }
        catch (Exception exception) {
            this.target.error().append(this._classname).append(".transitionToStateIdle() failed").log();
        }
    }

    public void setPendingEvent(EventGeneric eventGeneric) {
        this.pendingEvent = eventGeneric;
    }
}

