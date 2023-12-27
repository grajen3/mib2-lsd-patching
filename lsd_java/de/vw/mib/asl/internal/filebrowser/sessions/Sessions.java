/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser.sessions;

import de.vw.mib.asl.internal.filebrowser.HsmTargetFileBrowser;
import de.vw.mib.asl.internal.filebrowser.sessions.Session;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.media.MediaInfo;

public class Sessions {
    private final Session[] sessions;
    private final IntObjectOptHashMap halfClosedSessions = new IntObjectOptHashMap();

    public Sessions(int n) {
        this.sessions = new Session[n];
    }

    public Session addSession(int n, Path path) {
        int n2 = this.findFreeSlot();
        if (0 <= n2) {
            this.sessions[n2] = new Session(n, path);
            return this.sessions[n2];
        }
        throw new Exception("Too many open sessions!");
    }

    public Session addSession(MediaInfo mediaInfo) {
        int n = 1;
        int n2 = -1;
        for (int i2 = 0; i2 < this.sessions.length; ++i2) {
            if (this.sessions[i2] != null) {
                n = Math.max(n, this.sessions[i2].getAslHandle() + 1);
                continue;
            }
            n2 = i2;
        }
        if (n2 == -1) {
            throw new RuntimeException("Too many open sessions!");
        }
        this.sessions[n2] = new Session(n, new Path("", HsmTargetFileBrowser.ROOT_PATH));
        this.sessions[n2].setMediaInfo(mediaInfo);
        this.sessions[n2].setDsiHandle(-1);
        return this.sessions[n2];
    }

    public Session removeSession(int n) {
        for (int i2 = this.sessions.length - 1; i2 >= 0; --i2) {
            if (null == this.sessions[i2] || this.sessions[i2].getAslHandle() != n) continue;
            Session session = this.sessions[i2];
            this.sessions[i2] = null;
            if (session.pendingListEvent != null) {
                this.halfClosedSessions.put(session.getDsiHandle(), session);
            }
            return session;
        }
        return null;
    }

    public boolean removeIfHalfClosed(Session session) {
        return this.halfClosedSessions.remove(session.getDsiHandle()) != null;
    }

    public Session getAslSession(int n) {
        for (int i2 = this.sessions.length - 1; i2 >= 0; --i2) {
            if (null == this.sessions[i2] || this.sessions[i2].getAslHandle() != n) continue;
            return this.sessions[i2];
        }
        return null;
    }

    public Session getDsiSession(int n) {
        for (int i2 = this.sessions.length - 1; i2 >= 0; --i2) {
            if (null == this.sessions[i2] || this.sessions[i2].getDsiHandle() != n) continue;
            return this.sessions[i2];
        }
        return null;
    }

    public Session getAnyDsiSession(int n) {
        if (this.halfClosedSessions.containsKey(n)) {
            return (Session)this.halfClosedSessions.get(n);
        }
        return this.getDsiSession(n);
    }

    public Session getSessionByMountPoint(String string) {
        for (int i2 = this.sessions.length - 1; i2 >= 0; --i2) {
            if (null == this.sessions[i2] || !this.sessions[i2].getPath().mountPoint.equals(string)) continue;
            return this.sessions[i2];
        }
        return null;
    }

    public Session getFreeSessionByMountPoint(String string) {
        for (int i2 = this.sessions.length - 1; i2 >= 0; --i2) {
            Session session = this.sessions[i2];
            if (null == session || session.getDsiHandle() != -1 || !session.getPath().mountPoint.equals(string)) continue;
            return session;
        }
        return null;
    }

    private int findFreeSlot() {
        for (int i2 = this.sessions.length - 1; i2 >= 0; --i2) {
            if (null != this.sessions[i2]) continue;
            return i2;
        }
        return -1;
    }

    public List getByRequestType(int n) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.sessions.length; ++i2) {
            this.sessions[i2].removeRequest(n);
            if (this.sessions[i2] == null || this.sessions[i2].requestType != n) continue;
            arrayList.add(this.sessions[i2]);
        }
        return arrayList;
    }
}

