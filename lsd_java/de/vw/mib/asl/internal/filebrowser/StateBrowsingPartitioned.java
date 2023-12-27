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
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.filebrowser.Path;

public final class StateBrowsingPartitioned
extends AbstractHsmState {
    private final HsmTargetFileBrowser _target;
    private final String _classname = super.getClass().getName();
    private boolean isChangeFolderTriggeredBySetPath = false;

    StateBrowsingPartitioned(HsmTargetFileBrowser hsmTargetFileBrowser, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = hsmTargetFileBrowser;
    }

    public void dsiFileBrowserChangeFolderResult(int n, int n2, Path path) {
        block11: {
            Session session = this._target.sessions.getDsiSession(n);
            if (n2 == 0 && this._target.getModelSessions().getCurrentModelFilebrowserSession() == session) {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".dsiFileBrowserChangeFolderResult(").append(n).append(", ").append(n2).append(", ").append(path == null ? "null" : path.toString()).append("): handleModelUpdateCurrentFolder() getCurrentModelFilebrowserSession()").log();
                }
                try {
                    this.handleModelUpdateCurrentFolder(session.getAslHandle(), path);
                    if (this.isChangeFolderTriggeredBySetPath) {
                        this.submitSetPathResultToModel(true);
                    }
                    break block11;
                }
                catch (GenericEventException genericEventException) {
                    this._target.error().append(this._classname).append(".dsiFileBrowserChangeFolderResult(").append(n).append(", ").append(n2).append(", ").append(path == null ? "null" : path.toString()).append("): handleModelUpdateCurrentFolder() failed [").append(genericEventException.getMessage()).append("]").log();
                    if (this.isChangeFolderTriggeredBySetPath) {
                        this.submitSetPathResultToModel(false);
                    }
                    break block11;
                }
            }
            if (null != session) {
                EventGeneric eventGeneric = session.popEvent();
                session.setPath(path);
                try {
                    this.reportDirectoryChangeResult(eventGeneric, session.getAslHandle(), n2 == 0, path);
                }
                catch (GenericEventException genericEventException) {
                    this._target.error().append(this._classname).append(".dsiFileBrowserChangeFolderResult(").append(n).append(", ").append(n2).append(", ").append(path == null ? "null" : path.toString()).append("): reportDirectoryChangeResult() failed [").append(genericEventException.getMessage()).append("]").log();
                }
            } else {
                this._target.warn().append(this._classname).append(".dsiFileBrowserChangeFolderResult(").append(n).append(", ").append(n2).append(", ").append(path == null ? "null" : path.toString()).append(") unknown session with sessionHandle ").append(n).log();
            }
            if (this.isChangeFolderTriggeredBySetPath) {
                this.submitSetPathResultToModel(false);
            }
        }
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 2500011: {
                int n2 = eventGeneric.getInt(0);
                Session session = this._target.sessions.getAslSession(n2);
                if (null != session) {
                    if (session.isFree()) {
                        eventGeneric.setBlocked(true);
                        session.setPendingEvent(eventGeneric, 1006);
                        Path path = new Path(session.getPath().mountPoint, HsmTargetFileBrowser.ROOT_PATH);
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("ASLFilebrowserServiceIds.CHANGE_TO_ROOT_DIRECTORY changeFolder(").append(n2).append(',').append(path.toString()).append(')').log();
                        }
                        this._target.getDsiFileBrowser().changeFolder(session.getDsiHandle(), path);
                        break;
                    }
                    this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_CHANGE_TO_ROOT_DIRECTORY): Request denied due to pending event.").log();
                    this.reportDirectoryChangeResult(eventGeneric, n2, false, session.getPath());
                    break;
                }
                this._target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_CHANGE_TO_ROOT_DIRECTORY): Unknown session handle ").append(n2).log();
                this.reportDirectoryChangeResult(eventGeneric, n2, false, null);
                break;
            }
            case 2500001: {
                int n3 = eventGeneric.getInt(0);
                int n4 = eventGeneric.getInt(1);
                Session session = this._target.sessions.getAslSession(n3);
                if (null != session) {
                    if (session.isFree()) {
                        String[] stringArray = session.getPath().folderNames;
                        if (stringArray.length >= n4) {
                            eventGeneric.setBlocked(true);
                            session.setPendingEvent(eventGeneric, 1006);
                            String[] stringArray2 = new String[stringArray.length - n4];
                            System.arraycopy((Object)stringArray, 0, (Object)stringArray2, 0, stringArray2.length);
                            Path path = new Path(session.getPath().mountPoint, stringArray2);
                            if (this._target.isTraceEnabled()) {
                                this._target.trace().append("ASLFilebrowserServiceIds.CHANGE_TO_PARENT_DIRECTORY changeFolder(").append(n3).append(',').append(path.toString()).append(')').log();
                            }
                            this._target.getDsiFileBrowser().changeFolder(session.getDsiHandle(), path);
                            break;
                        }
                        this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_CHANGE_TO_PARENT_DIRECTORY): Request denied due to invalid number of folderlevels to move up.").log();
                        this.reportDirectoryChangeResult(eventGeneric, n3, false, session.getPath());
                        break;
                    }
                    this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_CHANGE_TO_PARENT_DIRECTORY): Request denied due to pending event.").log();
                    this.reportDirectoryChangeResult(eventGeneric, n3, false, session.getPath());
                    break;
                }
                this._target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_CHANGE_TO_PARENT_DIRECTORY): Unknown session handle ").append(n3).log();
                this.reportDirectoryChangeResult(eventGeneric, n3, false, null);
                break;
            }
            case 2500003: {
                int n5 = eventGeneric.getInt(0);
                String[] stringArray = (String[])eventGeneric.getObject(1);
                Session session = this._target.sessions.getAslSession(n5);
                if (null != session) {
                    if (session.isFree()) {
                        eventGeneric.setBlocked(true);
                        session.setPendingEvent(eventGeneric, 1006);
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("ASLFilebrowserServiceIds.OPEN_DIRECTORY_ABSOLUTE changeFolder(").append(n5).append(',').append(new Path(session.getPath().mountPoint, stringArray).toString()).append(')').log();
                        }
                        this._target.getDsiFileBrowser().changeFolder(session.getDsiHandle(), new Path(session.getPath().mountPoint, stringArray));
                        break;
                    }
                    this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_ABSOLUTE): Request denied due to pending event.").log();
                    this.reportDirectoryChangeResult(eventGeneric, n5, false, session.getPath());
                    break;
                }
                this._target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_ABSOLUTE): Unknown session handle ").append(n5).log();
                this.reportDirectoryChangeResult(eventGeneric, n5, false, null);
                break;
            }
            case 2500004: {
                int n6 = eventGeneric.getInt(0);
                Path path = (Path)eventGeneric.getObject(1);
                Session session = this._target.sessions.getAslSession(n6);
                if (null != session) {
                    if (session.isFree()) {
                        eventGeneric.setBlocked(true);
                        session.setPendingEvent(eventGeneric, 1006);
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("ASLFilebrowserServiceIds.OPEN_DIRECTORY_ABSOLUTE_BY_PATH changeFolder(").append(n6).append(',').append(path.toString()).append(')').log();
                        }
                        this._target.getDsiFileBrowser().changeFolder(session.getDsiHandle(), path);
                        break;
                    }
                    this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_ABSOLUTE_BY_PATH): Request denied due to pending event.").log();
                    this.reportDirectoryChangeResult(eventGeneric, n6, false, session.getPath());
                    break;
                }
                this._target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_ABSOLUTE_BY_PATH): Unknown session handle ").append(n6).log();
                this.reportDirectoryChangeResult(eventGeneric, n6, false, null);
                break;
            }
            case 1073742143: {
                this._target.trace("StateBrowsingPartitioned: Received ASLFileBrowserServiceConstants.MOVE_FOLDER_UP");
                int n7 = eventGeneric.getInt(0);
                this._target.idleState.handleModelMoveFolderUp(n7);
                break;
            }
            default: {
                hsmState = this.getParent();
            }
        }
        return hsmState;
    }

    void handleModelUpdateFileCount(int n, int n2) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleModelUpdateFileCount(handle=").append(n).append(", count=").append(n2).append(")").log();
        }
        ListManager.getGenericASLList(424).setSize(0);
        ListManager.getGenericASLList(424).setSize(n2);
    }

    private void handleModelUpdateCurrentFolder(int n, Path path) {
        Session session = this._target.sessions.getAslSession(n);
        session.setPath(path);
        this._target.notifyModel(session);
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleModelUpdateCurrentFolder(): Changed current folder to ").append(path).log();
        }
        this._target.getDsiFileBrowser().getFileCount(session.getDsiHandle());
    }

    void reportDirectoryChangeResult(EventGeneric eventGeneric, int n, boolean bl, Path path) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".reportDirectoryChangeResult(): currentPath = ").append(path).log();
        }
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setObject(2, path);
        this._target.sendBackIfBlocked(eventGeneric);
    }

    private void submitSetPathResultToModel(boolean bl) {
        String string;
        this.isChangeFolderTriggeredBySetPath = false;
        if (bl) {
            this._target.sendHMIEvent(514);
            string = " notify model SET_PATH_SUCCESS";
        } else {
            this._target.sendHMIEvent(515);
            string = " notify model SET_PATH_FAILED";
        }
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".submitSetPathResultToModel - ").append(string).log();
        }
    }
}

