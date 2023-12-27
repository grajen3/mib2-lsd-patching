/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;
import de.vw.mib.asl.framework.internal.persistence.internal.db.Requester;
import de.vw.mib.asl.framework.internal.persistence.internal.db.RequesterKey;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class RequesterMap {
    private static final long TIMEOUT;
    private final Map mMap = new HashMap();

    RequesterMap() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean putRequest(int n, long l, byte by, int n2, int n3) {
        boolean bl = false;
        if (n2 != 0 && n3 != 0) {
            RequesterKey requesterKey = new RequesterKey(n, l, by);
            Object object = this.mMap;
            synchronized (object) {
                if (!this.mMap.containsKey(requesterKey)) {
                    this.mMap.put(requesterKey, new Requester(n, l, n2, n3));
                    return true;
                }
            }
            if (PersDebug.isTraceEnabled()) {
                object = new StringBuffer(64);
                object = ((StringBuffer)object).append("Persistence: ").append("Ups, Persistence request already pending. [namespace=").append(n).append("][key=").append(l).append("][mode=").append(by).append("]");
                PersDebug.trace(((StringBuffer)object).toString(), false);
            }
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean putRequest(int n, long l, byte by, EventGeneric eventGeneric, PersistenceReadCallback persistenceReadCallback) {
        boolean bl = false;
        RequesterKey requesterKey = new RequesterKey(n, l, by);
        Object object = this.mMap;
        synchronized (object) {
            if (!this.mMap.containsKey(requesterKey)) {
                this.mMap.put(requesterKey, new Requester(n, l, eventGeneric, persistenceReadCallback));
                return true;
            }
        }
        if (PersDebug.isTraceEnabled()) {
            object = new StringBuffer(64);
            object = ((StringBuffer)object).append("Persistence: ").append("Ups, Persistence request already pending. [namespace=").append(n).append("][key=").append(l).append("][mode=").append(by).append("]");
            PersDebug.trace(((StringBuffer)object).toString(), false);
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Requester removeRequester(int n, long l, byte by) {
        RequesterKey requesterKey = new RequesterKey(n, l, by);
        Requester requester = null;
        Map map = this.mMap;
        synchronized (map) {
            requester = (Requester)this.mMap.get(requesterKey);
            if (requester != null) {
                this.mMap.remove(requesterKey);
            }
        }
        return requester;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void maintenance() {
        Map map = this.mMap;
        synchronized (map) {
            Collection collection = this.mMap.values();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                Requester requester = (Requester)iterator.next();
                if (!requester.isOld(0)) continue;
                iterator.remove();
            }
        }
    }

    public Iterator getValueIterator() {
        return this.mMap.values().iterator();
    }
}

