/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.filebrowser.FileBrowserListCollector;
import de.vw.mib.asl.internal.filebrowser.HsmTargetFileBrowser;
import de.vw.mib.asl.internal.filebrowser.sessions.Session;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.media.MediaInfo;

public final class StateStartModelContextSession
extends AbstractHsmState {
    private final String _classname = super.getClass().getName();
    private final HsmTargetFileBrowser target;
    Path sessionStartPath = null;
    boolean submitSetPathResult;
    MediaInfo mediaInfo;

    StateStartModelContextSession(HsmTargetFileBrowser hsmTargetFileBrowser, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetFileBrowser;
    }

    public void dsiFileBrowserStartResult(int n, int n2, Path path) {
        if (0 == n2) {
            try {
                Session session;
                if (this.target.getModelSessions().isValid()) {
                    session = this.target.getModelSessions().getCurrentModelFilebrowserSession();
                    session.setDsiHandle(n);
                } else {
                    session = this.target.sessions.addSession(n, path);
                    session.setDsiHandle(n);
                    this.target.getModelSessions().setSessionForCurrentModelContext(session);
                }
                session.setMediaInfo(this.target.sourceList.getMediaInfoByMountPoint(path.getMountPoint()));
                this.target.activateCurrentModelSessionFilter();
                session.setPath(path);
                this.target.notifyModel(session);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): Browsing session started").log();
                }
                this.target.getDsiFileBrowser().getFileCount(n);
                this.submitSetPathResultToModel(true);
            }
            catch (Exception exception) {
                this.target.error().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): ").append(exception.getMessage()).attachThrowable(exception).log();
                this.target.getDsiFileBrowser().stop(n);
                this.submitSetPathResultToModel(false);
            }
        } else {
            this.submitSetPathResultToModel(false);
            this.target.error().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): Invalid success parameter.").log();
        }
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

    public void dsiFileBrowserAsyncException(int n, String string, int n2) {
        if (n == 8304 && n2 == 1000) {
            this.target.error().append(this._classname).append(".dsiFileBrowserAsyncException(").append(n).append(", ").append(string).append(", ").append(n2).log();
            this.transitionToStateIdle();
        }
    }

    public void dsiFileBrowserSetFileTypeActiveResult(int n) {
        boolean bl = this.target.fileTypeActive = n == 0;
        if (!this.target.fileTypeActive) {
            this.target.warn("failure on dsiFileBrowserSetFileTypeActiveResult, continuing anyway. errorcode=", n);
        }
        this.target.getDsiFileBrowser().start(this.sessionStartPath);
        this.sessionStartPath = null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 100500: {
                if (this.target.fileTypeActive) {
                    this.target.getDsiFileBrowser().start(this.sessionStartPath);
                    this.sessionStartPath = null;
                    break;
                }
                this.target.warn(new StringBuffer().append(this._classname).append(": file type resolution should be active at this point.").toString());
                this.target.getDsiFileBrowser().setFileTypeActive(true);
                break;
            }
            case 3: {
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-1373297152);
                eventGeneric2.setInt(0, 100);
                eventGeneric2.setObject(1, this.mediaInfo);
                eventGeneric2.setSenderEventId(-1356519936);
                this.target.sendSafe(eventGeneric2);
                break;
            }
            case 2500015: {
                MediaInfo[] mediaInfoArray = (MediaInfo[])eventGeneric.getObject(2);
                this.target.partitionChoiceState.setPartitions(mediaInfoArray);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("StatePartitionChoice/ASL_FILEBROWSER_UPDATE_PARTITION_LIST partitions: ").append(mediaInfoArray.length).log();
                }
                if (mediaInfoArray.length == 1) {
                    this.target.sendSafe(ServiceManager.mGenericEventFactory.newEvent(-1058336256, -1058336256, -1803026176));
                    this.target.setCollectedPartitions(null);
                    break;
                }
                Session session = this.target.sessions.addSession(mediaInfoArray[0]);
                this.target.getModelSessions().setSessionForCurrentModelContext(session);
                session.setPath(this.sessionStartPath);
                session.setPartitioned(true);
                ServiceManager.aslPropertyManager.valueChangedInteger(3822, 0);
                FileBrowserListCollector[] fileBrowserListCollectorArray = this.partitionsToCollector(mediaInfoArray);
                this.target.setCollectedPartitions(fileBrowserListCollectorArray);
                this.target.idleState.handleModelUpdateFileCount(session.getAslHandle(), mediaInfoArray.length);
                this.target.notifyModel(session);
                break;
            }
            case 0x40000140: {
                int n2 = eventGeneric.getInt(0);
                Object object = ListManager.getGenericASLList(424).getRowItem(n2);
                if (object == null || !(object instanceof FileBrowserListCollector)) break;
                FileBrowserListCollector fileBrowserListCollector = (FileBrowserListCollector)object;
                if (fileBrowserListCollector.mediaInfo == null) break;
                this.sessionStartPath = new Path(fileBrowserListCollector.mediaInfo.getMountPoint(), this.sessionStartPath.getFolderNames());
                this.target.getModelSessions().getCurrentModelFilebrowserSession().setPath(this.sessionStartPath);
                this.target.sendSafe(ServiceManager.mGenericEventFactory.newEvent(-1058336256, -1058336256, -1803026176));
                this.target.setCollectedPartitions(null);
                break;
            }
            default: {
                hsmState = this.getParent();
            }
        }
        return hsmState;
    }

    private FileBrowserListCollector[] partitionsToCollector(MediaInfo[] mediaInfoArray) {
        FileBrowserListCollector fileBrowserListCollector;
        FileBrowserListCollector[] fileBrowserListCollectorArray = new FileBrowserListCollector[mediaInfoArray.length];
        for (int i2 = 0; i2 < mediaInfoArray.length; ++i2) {
            MediaInfo mediaInfo = mediaInfoArray[i2];
            fileBrowserListCollector = new FileBrowserListCollector();
            fileBrowserListCollector.mediaInfo = mediaInfo;
            fileBrowserListCollector.resourceLocator = null;
            fileBrowserListCollector.listEntry = new BrowsedFile(i2, false, mediaInfo.getName(), 3, 0L);
            fileBrowserListCollectorArray[i2] = fileBrowserListCollector;
        }
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace().append("partitionsToCollector with ").append(fileBrowserListCollectorArray.length).append("entries. {");
            for (int i3 = 0; i3 < fileBrowserListCollectorArray.length; ++i3) {
                fileBrowserListCollector = fileBrowserListCollectorArray[i3];
                logMessage.append("FileBrowserListCollector[").append(i3).append("]=(mediaInfo.name=").append(fileBrowserListCollector.mediaInfo.name).append(", BrowsedFile=").append(fileBrowserListCollector.listEntry).append(", ");
            }
            logMessage.append("}").log();
        }
        return fileBrowserListCollectorArray;
    }

    private void submitSetPathResultToModel(boolean bl) {
        String string;
        if (!this.submitSetPathResult) {
            return;
        }
        if (bl) {
            this.target.sendHMIEvent(514);
            string = " notify model SET_PATH_SUCCESS";
        } else {
            this.target.sendHMIEvent(515);
            string = " notify model SET_PATH_FAILED";
        }
        if (this.target.isTraceEnabled()) {
            this.target.trace().append(this._classname).append(".submitSetPathResultToModel - ").append(string).log();
        }
    }
}

