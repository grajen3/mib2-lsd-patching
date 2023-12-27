/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.api.persistence.Persistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;
import de.vw.mib.asl.framework.api.persistence.SharedPersistable;
import de.vw.mib.asl.framework.internal.persistence.internal.db.AbstractRecord;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDb;
import de.vw.mib.asl.framework.internal.persistence.internal.db.Cache;
import de.vw.mib.asl.framework.internal.persistence.internal.db.PrivateInputStream;
import de.vw.mib.asl.framework.internal.persistence.internal.db.PrivateOutputStream;
import de.vw.mib.asl.framework.internal.persistence.internal.db.Requester;
import de.vw.mib.asl.framework.internal.persistence.internal.db.RequesterMap;
import de.vw.mib.asl.framework.internal.persistence.internal.db.SharedPersistableMap;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.NamespaceKeyPair;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServicesProvider;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.util.StringBuilder;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ApiPersDbImpl
implements ApiPersDb {
    public static final byte WRITE;
    public static final byte READ;
    public static ApiPersDb INSTANCE;
    private final Set loadedData = new HashSet();
    private Cache mCache = new Cache();
    private Cache mClonedCache = null;
    private Cache mStoredCache = null;
    private SharedPersistableMap mPersistableHandler = new SharedPersistableMap();
    private RequesterMap mRequestMap = new RequesterMap();

    private ApiPersDbImpl() {
    }

    @Override
    public AbstractRecord getCachedRecord(int n, long l) {
        AbstractRecord abstractRecord = this.getCachedRecordInternal(n, l);
        this.logLoadingStatus(n, l);
        return abstractRecord;
    }

    @Override
    public void putIntoCache(int n, long l, AbstractRecord abstractRecord, boolean bl) {
        this.mCache.put(n, l, abstractRecord, bl);
    }

    @Override
    public boolean isRecordDirty(AbstractRecord abstractRecord) {
        return this.mCache.isRecordDirty(abstractRecord);
    }

    @Override
    public boolean writeRecords() {
        this.mPersistableHandler.serializeRecordsToCache();
        PersistenceServicesProvider.getPersistenceServices().getPersistableService().writeDirtyRecords();
        return this.mCache.writeRecords();
    }

    @Override
    public boolean putRequest(int n, long l, byte by, EventGeneric eventGeneric, PersistenceReadCallback persistenceReadCallback) {
        return this.mRequestMap.putRequest(n, l, by, eventGeneric, persistenceReadCallback);
    }

    @Override
    public Requester removeRequester(int n, long l, byte by) {
        return this.mRequestMap.removeRequester(n, l, by);
    }

    @Override
    public void maintenance() {
        this.mRequestMap.maintenance();
    }

    @Override
    public int getRecordCountInCache() {
        return this.mCache.size();
    }

    @Override
    public Iterator getCacheIterator() {
        return this.mCache.iterator();
    }

    @Override
    public Iterator getRequesterIterator() {
        return this.mRequestMap.getValueIterator();
    }

    @Override
    public void registerSharedPersistable(SharedPersistable sharedPersistable) {
        this.mPersistableHandler.add(sharedPersistable);
    }

    @Override
    public boolean storePersistable(int n, long l, Persistable persistable) {
        try {
            PrivateOutputStream privateOutputStream = new PrivateOutputStream();
            persistable.toStream(privateOutputStream);
            byte[] byArray = privateOutputStream.toByteArray();
            this.putIntoCache(n, l, AbstractRecord.createRecord(n, l, byArray), false);
            return true;
        }
        catch (IOException iOException) {
            PersDebug.error(new StringBuffer().append("Error storing an Object to persistence: ").append(persistable.toString()).append(": ").toString(), iOException);
            return false;
        }
    }

    @Override
    public boolean loadPersistable(int n, long l, Persistable persistable) {
        boolean bl;
        AbstractRecord abstractRecord = this.getCachedRecord(n, l);
        boolean bl2 = bl = abstractRecord != null && abstractRecord.getType() == 3 && abstractRecord.isValid();
        if (bl) {
            return this.doLoadData(n, l, persistable, abstractRecord);
        }
        PersDebug.trace(new StringBuffer().append("Calling clear() because data not found or not valid (e.g. due to uncompressing error) Obj: ").append(PersDebug.namespaceKeyString(n, l)).toString(), true);
        this.clearPersistable(persistable);
        return false;
    }

    @Override
    public int getDirtyRecordCount() {
        this.mPersistableHandler.serializeRecordsToCache();
        return this.mCache.getDirtyRecordCount();
    }

    @Override
    public void useClonedCache() {
        this.mStoredCache = this.mCache;
        try {
            this.mCache = this.mClonedCache = (Cache)this.mCache.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            PersDebug.error("[ApiPersDb] Error cloning cache! ", cloneNotSupportedException);
            this.mStoredCache = null;
            this.mClonedCache = null;
        }
    }

    @Override
    public void restoreCache() {
        if (this.mStoredCache != null) {
            this.mCache = this.mStoredCache;
            this.mClonedCache = null;
            this.mStoredCache = null;
        }
    }

    @Override
    public void reloadAllSharedPersistables() {
        this.mPersistableHandler.reloadAllSharedPersistables();
    }

    @Override
    public boolean isDataLoaded(int n, long l) {
        return this.getCachedRecordInternal(n, l) != null;
    }

    @Override
    public void markDataWasLoaded(int n, long l) {
        this.loadedData.add(new NamespaceKeyPair(n, l));
    }

    void reset() {
        INSTANCE = new ApiPersDbImpl();
    }

    private boolean doLoadData(int n, long l, Persistable persistable, AbstractRecord abstractRecord) {
        byte[] byArray = abstractRecord.getByteArray();
        try {
            PrivateInputStream privateInputStream = new PrivateInputStream(byArray);
            if (privateInputStream.isValid()) {
                persistable.fromStream(privateInputStream);
                privateInputStream.close();
                return true;
            }
            PersDebug.warn("Calling clear() because ris.isValid == false!");
            this.clearPersistable(persistable);
        }
        catch (IOException iOException) {
            this.logDerializationError(n, l, iOException);
            this.clearPersistable(persistable);
        }
        return false;
    }

    private void logDerializationError(int n, long l, IOException iOException) {
        PersDebug.error("Error while deserializing the data stream", iOException);
        PersDebug.info(new StringBuffer().append("The Object was NOT LOADED: ").append(PersDebug.namespaceKeyString(n, l)).append(": ").toString(), iOException.getMessage());
        PersDebug.info(new StringBuffer().append("The Persistence for : ").append(PersDebug.getNamespaceName(n)).append("/").append(PersDebug.getKeyName(n, l)).append(" is set to DEFAULT VALUES").toString());
    }

    private void clearPersistable(Persistable persistable) {
        persistable.clear();
        if (persistable instanceof SharedPersistable) {
            SharedPersistable sharedPersistable = (SharedPersistable)persistable;
            sharedPersistable.markDirty(true);
        }
    }

    private AbstractRecord getCachedRecordInternal(int n, long l) {
        return this.mCache.get(n, l);
    }

    private void logLoadingStatus(int n, long l) {
        boolean bl;
        boolean bl2 = this.loadedData.contains(new NamespaceKeyPair(n, l));
        boolean bl3 = bl = n >= 5000 && n < 6000;
        if (bl && !bl2) {
            Exception exception = new Exception();
            String string = new StringBuilder().append("Persistence Data was requested before it was loaded (NS: ").append(n).append(", key ").append(l).append(")").toString();
            PersDebug.error(string, exception);
        }
    }

    static {
        INSTANCE = new ApiPersDbImpl();
    }
}

