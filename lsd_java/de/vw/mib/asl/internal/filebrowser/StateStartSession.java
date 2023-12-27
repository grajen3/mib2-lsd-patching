/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser;

import de.vw.mib.asl.internal.filebrowser.HsmTargetFileBrowser;
import de.vw.mib.asl.internal.filebrowser.sessions.Session;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.media.MediaInfo;

public final class StateStartSession
extends AbstractHsmState {
    private final String _classname = super.getClass().getName();
    EventGeneric pendingEvent = null;
    private final HsmTargetFileBrowser target;

    StateStartSession(HsmTargetFileBrowser hsmTargetFileBrowser, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetFileBrowser;
    }

    public void dsiFileBrowserStartResult(int n, int n2, Path path) {
        Session session;
        boolean bl = false;
        if (0 == n2) {
            bl = true;
            try {
                session = this.target.sessions.getFreeSessionByMountPoint(path.getMountPoint());
                if (session == null) {
                    this.target.warn("no free session found by mount point!");
                    session = this.target.sessions.addSession(n, path);
                }
                session.setMediaInfo(this.target.sourceList.getMediaInfoByMountPoint(path.getMountPoint()));
                session.setDsiHandle(n);
                session.setPath(path);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): Browsing session started").log();
                }
            }
            catch (Exception exception) {
                this.target.error().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): ").append(exception.getMessage()).log();
                this.target.getDsiFileBrowser().stop(n);
                bl = false;
            }
        } else {
            this.target.error().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): Invalid parameter.").log();
        }
        session = this.target.sessions.getDsiSession(n);
        this.pendingEvent.setBoolean(0, bl);
        this.pendingEvent.setInt(1, session.getAslHandle());
        this.pendingEvent.setObject(2, path);
        this.pendingEvent.setBlocked(false);
        try {
            this.target.getEventDispatcher().sendBack(this.pendingEvent);
        }
        catch (GenericEventException genericEventException) {
            this.target.error().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): sendBack() failed [").append(genericEventException.getMessage()).append("]").log();
        }
        this.pendingEvent = null;
        this.transitionToStateIdle();
    }

    private void transitionToStateIdle() {
        try {
            this.trans(this.target.idleState);
        }
        catch (Exception exception) {
            this.target.error().append(this._classname).append(".transitionToStateIdle() failed").log();
        }
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 2: {
                MediaInfo mediaInfo = (MediaInfo)this.pendingEvent.getObject(0);
                Path path = new Path(mediaInfo.mountPoint, HsmTargetFileBrowser.ROOT_PATH);
                this.target.getDsiFileBrowser().start(path);
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
            this.target.trace().append(this._classname).append(".cancelStartRequest()").log();
        }
        eventGeneric.setBoolean(0, false);
        eventGeneric.setInt(1, 0);
    }
}

