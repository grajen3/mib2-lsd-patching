/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.filebrowser.HsmTargetFileBrowser;
import de.vw.mib.asl.internal.filebrowser.ModelSessions;
import de.vw.mib.asl.internal.filebrowser.sessions.Session;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.media.MediaInfo;

public class StateStartAslSession
extends AbstractHsmState {
    private final HsmTargetFileBrowser target;
    private MediaInfo mediaInfo = null;

    public StateStartAslSession(HsmTargetFileBrowser hsmTargetFileBrowser, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetFileBrowser;
    }

    void setMediaInfo(MediaInfo mediaInfo) {
        if (this.mediaInfo != mediaInfo) {
            this.target.partitionChoiceState.setPartitions(null);
            this.mediaInfo = mediaInfo;
        }
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 3: {
                Session session = this.target.sessions.addSession(this.mediaInfo);
                session.setPath(new Path(this.mediaInfo.getMountPoint(), HsmTargetFileBrowser.ROOT_PATH));
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-1373297152);
                eventGeneric2.setInt(0, session.getAslHandle());
                eventGeneric2.setObject(1, this.mediaInfo);
                eventGeneric2.setSenderEventId(-1356519936);
                this.target.sendSafe(eventGeneric2);
                break;
            }
            case 2500015: {
                int n2 = eventGeneric.getInt(0);
                MediaInfo[] mediaInfoArray = (MediaInfo[])eventGeneric.getObject(2);
                this.target.partitionChoiceState.setPartitions(mediaInfoArray);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("StatePartitionChoice/ASL_FILEBROWSER_UPDATE_PARTITION_LIST(").append(n2).append(") partitions: ").append(mediaInfoArray.length).log();
                }
                this.target.sessions.getAslSession(n2).setPartitioned(mediaInfoArray.length > 1);
                if (mediaInfoArray.length == 1) {
                    this.trans(this.target.startSessionState);
                    break;
                }
                if (this.target.startSessionState.pendingEvent == null) break;
                Session session = this.target.sessions.getAslSession(n2);
                this.target.startSessionState.pendingEvent.setBoolean(0, true);
                this.target.startSessionState.pendingEvent.setInt(1, n2);
                this.target.startSessionState.pendingEvent.setObject(2, session.getPath());
                this.target.startSessionState.pendingEvent.setBlocked(false);
                this.target.sendBackSafe(this.target.startSessionState.pendingEvent);
                this.target.startSessionState.pendingEvent = null;
                this.trans(this.target.partitionChoiceState);
                break;
            }
            case 2500007: 
            case 2500008: {
                Session session = this.target.sessions.getAslSession(eventGeneric.getInt(0));
                String[] stringArray = n == -1490737664 ? ModelSessions.CONTENT_FILTERS[eventGeneric.getInt(1)] : (String[])eventGeneric.getObject(1);
                session.setExtensions(stringArray);
                eventGeneric.setBoolean(1, true);
                break;
            }
            case 2500000: 
            case 2500001: 
            case 2500003: 
            case 2500004: 
            case 2500009: 
            case 2500011: 
            case 2500018: 
            case 1073742146: {
                this.trans(this.target.idleState);
                hsmState = this.getParent();
                break;
            }
            default: {
                hsmState = this.getParent();
            }
        }
        return hsmState;
    }
}

