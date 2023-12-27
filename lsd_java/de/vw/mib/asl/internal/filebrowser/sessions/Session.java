/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser.sessions;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.media.MediaInfo;

public final class Session
implements Loggable {
    private final int aslHandle;
    private Path path;
    private MediaInfo mediaInfo;
    private EventGeneric pendingEvent = null;
    int requestType = -1;
    private int requestMask = 0;
    private int dsiHandle;
    EventGeneric pendingListEvent = null;
    private boolean partitioned = false;
    private String[] extensions;

    Session(int n, Path path) {
        this.aslHandle = n;
        this.path = path;
    }

    public boolean isFree() {
        return this.pendingEvent == null && this.requestMask == 0;
    }

    public void setPendingEvent(EventGeneric eventGeneric, int n) {
        if (this.pendingEvent != null) {
            throw new IllegalStateException("Overwriting pending event!");
        }
        this.pendingEvent = eventGeneric;
        this.requestType = n;
    }

    public void addRequest(int n) {
        this.requestMask |= 2 << n - 1000;
    }

    public void removeRequest(int n) {
        this.requestMask &= ~(2 << n - 1000);
    }

    public EventGeneric popEvent() {
        EventGeneric eventGeneric = this.pendingEvent;
        this.pendingEvent = null;
        this.requestType = -1;
        return eventGeneric;
    }

    public void setListEvent(EventGeneric eventGeneric) {
        this.pendingListEvent = eventGeneric;
    }

    public EventGeneric popListEvent() {
        EventGeneric eventGeneric = this.pendingListEvent;
        this.pendingListEvent = null;
        return eventGeneric;
    }

    public Path getPath() {
        return this.path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public int getAslHandle() {
        return this.aslHandle;
    }

    public int getDsiHandle() {
        return this.dsiHandle;
    }

    public void setDsiHandle(int n) {
        this.dsiHandle = n;
    }

    public boolean isPartitioned() {
        return this.partitioned;
    }

    public void setPartitioned(boolean bl) {
        this.partitioned = bl;
    }

    public String[] getExtensions() {
        return this.extensions;
    }

    public void setExtensions(String[] stringArray) {
        this.extensions = stringArray;
    }

    public void setMediaInfo(MediaInfo mediaInfo) {
        this.mediaInfo = mediaInfo;
        mediaInfo.getName();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("Session(asl=").append(this.aslHandle).append(",dsi=").append(this.dsiHandle).append(",requestType=").append(this.requestType).append(')');
    }

    public String getMediumName() {
        if ((this.mediaInfo.getFlags() & 0x8000) == 0) {
            return this.mediaInfo.name;
        }
        return "";
    }
}

