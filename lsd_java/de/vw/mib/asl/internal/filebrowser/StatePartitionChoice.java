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
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.media.MediaInfo;

public class StatePartitionChoice
extends AbstractHsmState {
    private final String _classname = super.getClass().getName();
    private final HsmTargetFileBrowser target;
    private MediaInfo[] partitions = null;

    public StatePartitionChoice(HsmTargetFileBrowser hsmTargetFileBrowser, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetFileBrowser;
    }

    public void setPartitions(MediaInfo[] mediaInfoArray) {
        this.partitions = mediaInfoArray;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 3: {
                break;
            }
            case 2500005: {
                int n2 = eventGeneric.getInt(0);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("StatePartitionChoice/ASL_FILEBROWSER_GET_NUMBER_OF_ENTRIES(").append(n2).append(") partitions: ").append(this.partitions != null ? this.partitions.length : -1).log();
                }
                eventGeneric.setBoolean(1, true);
                eventGeneric.setInt(2, this.partitions.length);
                this.target.idleState.handleModelUpdateFileCount(n2, this.partitions.length);
                break;
            }
            case 2500006: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("StatePartitionChoice/ASL_FILEBROWSER_GET_ENTRIES(?) partitions: ").append(this.partitions != null ? this.partitions.length : -1).log();
                }
                this.reportEntries(eventGeneric);
                break;
            }
            case 2500002: {
                int n3 = eventGeneric.getInt(0);
                BrowsedFile browsedFile = (BrowsedFile)eventGeneric.getObject(1);
                Session session = this.target.sessions.getAslSession(n3);
                this.target.trace("StatePartitionChoice: Received ASLFilebrowserServiceIds.OPEN_DIRECTORY_RELATIVE");
                if (null != session) {
                    if (browsedFile.fileType != 3) {
                        this.target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_RELATIVE): file was passed -> ").append(browsedFile.filename).log();
                        this.target.idleState.reportDirectoryChangeResult(eventGeneric, n3, false, session.getPath());
                        break;
                    }
                    if (session.isFree()) {
                        Path path = new Path(this.partitionFromId((long)browsedFile.getId()).mountPoint, HsmTargetFileBrowser.ROOT_PATH);
                        session.setPath(path);
                        eventGeneric.setBlocked(true);
                        session.setPendingEvent(eventGeneric, 1000);
                        this.target.getDsiFileBrowser().start(path);
                        break;
                    }
                    this.target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_RELATIVE): Request denied due to pending event.").log();
                    this.target.idleState.reportDirectoryChangeResult(eventGeneric, n3, false, session.getPath());
                    break;
                }
                this.target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_RELATIVE): Unknown session handle ").append(n3).log();
                this.target.idleState.reportDirectoryChangeResult(eventGeneric, n3, false, null);
                break;
            }
            default: {
                hsmState = this.getParent();
            }
        }
        return hsmState;
    }

    private void reportEntries(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        BrowsedFile[] browsedFileArray = new BrowsedFile[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            browsedFileArray[i2] = new BrowsedFile(StatePartitionChoice.idFromPartition(this.partitions[i2]), false, this.partitions[i2].getName(), 3, 0L);
        }
        Path path = new Path(this.partitions[0].getMountPoint(), HsmTargetFileBrowser.ROOT_PATH);
        BrowsedFileSet browsedFileSet = new BrowsedFileSet(path, browsedFileArray);
        this.target.idleState.reportEntries(eventGeneric, n, true, n2, browsedFileSet);
        this.target.idleState.handleModelUpdateFileCount(n, this.partitions.length);
    }

    private static long idFromPartition(MediaInfo mediaInfo) {
        return 0x4000000000000L + (mediaInfo.deviceID << 32 | mediaInfo.mediaID);
    }

    private MediaInfo partitionFromId(long l) {
        int n = (int)(l - 0x4000000000000L >> 32);
        int n2 = (int)(l - 0x4000000000000L & 0);
        for (int i2 = 0; i2 < this.partitions.length; ++i2) {
            if (this.partitions[i2].getDeviceID() != (long)n || this.partitions[i2].mediaID != (long)n2) continue;
            return this.partitions[i2];
        }
        throw new RuntimeException(new StringBuffer().append("could not find media for id ").append(l).append(". mangling/unmangling of deviceID/mediaID probably failed.").toString());
    }

    public void dsiFileBrowserStartResult(int n, int n2, Path path) {
        if (0 == n2) {
            try {
                Session session = this.target.sessions.getFreeSessionByMountPoint(path.getMountPoint());
                if (session == null) {
                    this.target.error("Unexpected fail of SessionManager.getFreeSessionByMountPoint(...) in StatePartitionChoice.dsiFileBrowserStartResult()");
                    session = this.target.sessions.addSession(n, path);
                }
                session.setMediaInfo(this.target.sourceList.getMediaInfoByMountPoint(path.getMountPoint()));
                session.setDsiHandle(n);
                session.setPath(path);
                this.target.getDsiFileBrowser().setFileExtensionFilter(n, session.getExtensions());
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): Browsing session started").log();
                }
            }
            catch (Exception exception) {
                this.target.error().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): ").append(exception.getMessage()).log();
                this.target.getDsiFileBrowser().stop(n);
            }
        } else {
            this.target.error().append(this._classname).append(".dsiFileBrowserStartResult(sessionHandle=").append(n).append(", success=").append(n2 == 0).append(", path=").append(path == null ? "null" : path.toString()).append("): Invalid parameter.").log();
        }
    }

    public void dsiFileBrowserSetFileExtensionFilterResult(int n, int n2) {
        Session session = this.target.sessions.getDsiSession(n);
        if (null != session) {
            EventGeneric eventGeneric = session.popEvent();
            if (this.target.isTraceEnabled()) {
                n2 = 0;
                this.target.trace().append("StatePartitionChoice.dsiFileBrowserSetFileExtensionFilterResult(dsiSessionHandle=").append(n).append(", success=").append(0).append(") session.aslHandle=").append(session.getAslHandle()).log();
            }
            eventGeneric.setInt(0, session.getAslHandle());
            eventGeneric.setBoolean(1, n2 == 0);
            eventGeneric.setObject(2, session.getPath());
            eventGeneric.setBlocked(false);
            try {
                this.target.getEventDispatcher().sendBack(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                this.target.warn(new StringBuffer().append("sendBack failed in StatePartitionChoice.dsiFileBrowserSetFileExtensionFilterResult(). ").append(genericEventException).toString());
            }
            try {
                this.trans(this.target.browsingPartitionedState);
            }
            catch (Exception exception) {
                this.target.warn(new StringBuffer().append("transition to idle state failed in StatePartitionChoice.dsiFileBrowserSetFileExtensionFilterResult(). ").append(exception).toString());
            }
        } else {
            this.target.warn().append(this._classname).append(".dsiFileBrowserSetFileExtensionFilterResult(): Unknown session handle ").append(n).log();
        }
    }
}

