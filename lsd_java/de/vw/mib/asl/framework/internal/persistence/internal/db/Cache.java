/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.internal.persistence.internal.db.AbstractRecord;
import de.vw.mib.asl.framework.internal.persistence.internal.db.CacheKey;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.main.ApiPersMain;
import de.vw.mib.genericevents.GenericEventException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class Cache
implements Cloneable {
    private Map mDsiMap = new HashMap();
    private Map mDataMap = new HashMap();

    private void nextDirtyRecord(AbstractRecord abstractRecord) {
        ApiPersMain.writeViaDsi();
    }

    public Object clone() {
        Cache cache = (Cache)super.clone();
        cache.mDataMap = (Map)((HashMap)this.mDataMap).clone();
        cache.mDsiMap = (Map)((HashMap)this.mDsiMap).clone();
        return cache;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void put(int n, long l, AbstractRecord abstractRecord, boolean bl) {
        if (abstractRecord != null) {
            Map map;
            CacheKey cacheKey = new CacheKey(n, l);
            if (bl) {
                map = this.mDsiMap;
                synchronized (map) {
                    this.mDsiMap.put(cacheKey, abstractRecord);
                }
            }
            map = this.mDataMap;
            synchronized (map) {
                this.mDataMap.put(cacheKey, abstractRecord);
            }
            if (!bl && this.isRecordDirty(abstractRecord)) {
                this.nextDirtyRecord(abstractRecord);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    AbstractRecord get(int n, long l) {
        AbstractRecord abstractRecord;
        CacheKey cacheKey = new CacheKey(n, l);
        Map map = this.mDataMap;
        synchronized (map) {
            abstractRecord = (AbstractRecord)this.mDataMap.get(cacheKey);
        }
        return abstractRecord;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean writeRecords() {
        boolean bl = false;
        Map map = this.mDataMap;
        synchronized (map) {
            Iterator iterator = this.mDataMap.values().iterator();
            while (iterator.hasNext()) {
                AbstractRecord abstractRecord;
                AbstractRecord abstractRecord2 = (AbstractRecord)iterator.next();
                int n = abstractRecord2.getNamespace();
                long l = abstractRecord2.getKey();
                CacheKey cacheKey = new CacheKey(n, l);
                Map map2 = this.mDsiMap;
                synchronized (map2) {
                    abstractRecord = (AbstractRecord)this.mDsiMap.get(cacheKey);
                }
                if (abstractRecord != null && abstractRecord.equals(abstractRecord2)) continue;
                try {
                    abstractRecord2.writeToDsi(n, l);
                    bl = true;
                    map2 = this.mDsiMap;
                    synchronized (map2) {
                        this.mDsiMap.put(cacheKey, abstractRecord2);
                    }
                }
                catch (GenericEventException genericEventException) {
                    PersDebug.error(genericEventException);
                }
            }
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Iterator iterator() {
        Map map = this.mDataMap;
        synchronized (map) {
            return this.mDataMap.values().iterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    int size() {
        Map map = this.mDataMap;
        synchronized (map) {
            return this.mDataMap.size();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean isRecordDirty(AbstractRecord abstractRecord) {
        if (abstractRecord != null) {
            AbstractRecord abstractRecord2;
            CacheKey cacheKey = new CacheKey(abstractRecord.getNamespace(), abstractRecord.getKey());
            Map map = this.mDsiMap;
            synchronized (map) {
                abstractRecord2 = (AbstractRecord)this.mDsiMap.get(cacheKey);
            }
            if (abstractRecord2 == null || !abstractRecord2.equals(abstractRecord)) {
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    int getDirtyRecordCount() {
        int n = 0;
        Map map = this.mDataMap;
        synchronized (map) {
            Iterator iterator = this.mDataMap.values().iterator();
            while (iterator.hasNext()) {
                AbstractRecord abstractRecord = (AbstractRecord)iterator.next();
                if (!this.isRecordDirty(abstractRecord)) continue;
                ++n;
            }
        }
        return n;
    }
}

