/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.api.persistence.Persistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;
import de.vw.mib.asl.framework.api.persistence.SharedPersistable;
import de.vw.mib.asl.framework.internal.persistence.internal.db.AbstractRecord;
import de.vw.mib.asl.framework.internal.persistence.internal.db.Requester;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;

public interface ApiPersDb {
    default public AbstractRecord getCachedRecord(int n, long l) {
    }

    default public void putIntoCache(int n, long l, AbstractRecord abstractRecord, boolean bl) {
    }

    default public boolean isRecordDirty(AbstractRecord abstractRecord) {
    }

    default public boolean writeRecords() {
    }

    default public boolean putRequest(int n, long l, byte by, EventGeneric eventGeneric, PersistenceReadCallback persistenceReadCallback) {
    }

    default public Requester removeRequester(int n, long l, byte by) {
    }

    default public void maintenance() {
    }

    default public int getRecordCountInCache() {
    }

    default public Iterator getCacheIterator() {
    }

    default public Iterator getRequesterIterator() {
    }

    default public void registerSharedPersistable(SharedPersistable sharedPersistable) {
    }

    default public boolean storePersistable(int n, long l, Persistable persistable) {
    }

    default public boolean loadPersistable(int n, long l, Persistable persistable) {
    }

    default public int getDirtyRecordCount() {
    }

    default public void useClonedCache() {
    }

    default public void restoreCache() {
    }

    default public void reloadAllSharedPersistables() {
    }

    default public boolean isDataLoaded(int n, long l) {
    }

    default public void markDataWasLoaded(int n, long l) {
    }
}

