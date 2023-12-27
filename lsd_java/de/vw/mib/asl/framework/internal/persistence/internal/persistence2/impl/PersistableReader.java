/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.internal.persistence.internal.db.AbstractRecord;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDb;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.GenericDeserializer;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceLogger;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptorRegistry;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableMetaInfo;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableReader$CacheId;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.util.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class PersistableReader {
    private final PersistenceServices services;
    private final HashMap persistable2MetaInfo;
    private final HashMap persistablesCache = new HashMap();
    private final GenericDeserializer genericDeserializer;
    private final ApiPersDb apiPersDb;
    private final ModuleDescriptorRegistry moduleRegistry;
    private final PersistenceLogger log;

    public PersistableReader(PersistenceServices persistenceServices, HashMap hashMap) {
        this.services = persistenceServices;
        this.persistable2MetaInfo = hashMap;
        this.genericDeserializer = persistenceServices.getGenericDeserializer();
        this.apiPersDb = persistenceServices.getApiPersDb();
        this.moduleRegistry = persistenceServices.getModuleDescriptorRegistry();
        this.log = persistenceServices.getPersistenceLogger();
    }

    public Persistable loadPersistable(PersistenceModule persistenceModule, int n, byte by) {
        Preconditions.checkArgumentNotNull(persistenceModule);
        String string = persistenceModule.getName();
        this.log.trace(new StringBuffer().append("Loading Persistable, module=").append(string).append(", persistableId=").append(n).toString());
        ModuleDescriptor moduleDescriptor = this.moduleRegistry.getOrCreateDescriptor(persistenceModule);
        if (moduleDescriptor == null) {
            throw this.invalidModuleNamespace(string, n);
        }
        int n2 = moduleDescriptor.getNamespace();
        PersistableReader$CacheId persistableReader$CacheId = new PersistableReader$CacheId(n2, n);
        if (this.persistablesCache.containsKey(persistableReader$CacheId)) {
            this.log.trace(new StringBuffer().append("Persistable '").append(string).append("/").append(n).append("' was loaded before, returning cached persistable.").toString());
            return (Persistable)this.persistablesCache.get(persistableReader$CacheId);
        }
        Persistable persistable = this.internalLoadPersistable(persistenceModule, n, n2, by);
        persistable.updateRootPersistable(persistable);
        this.persistable2MetaInfo.put(persistable, new PersistableMetaInfo(by, persistenceModule));
        this.persistablesCache.put(persistableReader$CacheId, persistable);
        return persistable;
    }

    public void evictUserSpecificPersistables() {
        PersistableReader$CacheId persistableReader$CacheId;
        Set set = this.persistablesCache.keySet();
        ArrayList arrayList = new ArrayList();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            persistableReader$CacheId = (PersistableReader$CacheId)iterator.next();
            Persistable persistable = (Persistable)this.persistablesCache.get(persistableReader$CacheId);
            if (!persistable.hasUserSpecificData()) continue;
            arrayList.add(persistableReader$CacheId);
        }
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            persistableReader$CacheId = (PersistableReader$CacheId)iterator.next();
            this.persistablesCache.remove(persistableReader$CacheId);
        }
    }

    private Persistable internalLoadPersistable(PersistenceModule persistenceModule, int n, int n2, byte by) {
        byte[] byArray;
        long l;
        byte[] byArray2;
        Persistable persistable = persistenceModule.getPersistableFactory().createPersistable(n);
        try {
            byArray2 = this.readDeclaration(n2);
        }
        catch (Exception exception) {
            this.logDeclarationError(persistenceModule, n, n2, exception);
            persistable = persistenceModule.getPersistableFactory().createPersistableWithDefaults(n);
            return persistable;
        }
        try {
            l = PersistenceKeyUtil.calcCommonKey(n);
            byArray = this.readPersistenceData(n2, l);
            this.genericDeserializer.deserialize(byArray2, byArray, persistable, persistenceModule, false);
        }
        catch (Exception exception) {
            this.logCommonDataError(persistenceModule, n, n2, exception);
            persistable = persistenceModule.getPersistableFactory().createPersistableWithDefaults(n);
            return persistable;
        }
        if (persistable.hasUserSpecificData()) {
            try {
                l = PersistenceKeyUtil.calcUserKey(n, by);
                byArray = this.readPersistenceData(n2, l);
                this.genericDeserializer.deserialize(byArray2, byArray, persistable, persistenceModule, true);
            }
            catch (Exception exception) {
                this.logUserDataError(persistenceModule, n, n2, exception);
                persistable = persistenceModule.getPersistableFactory().createPersistableWithDefaults(n);
            }
        }
        return persistable;
    }

    private byte[] readDeclaration(int n) {
        int n2 = 0;
        return this.readPersistenceData(n, n2);
    }

    private byte[] readPersistenceData(int n, long l) {
        AbstractRecord abstractRecord = this.apiPersDb.getCachedRecord(n, l);
        if (abstractRecord == null) {
            throw this.invalidDataException(n, l, "data is null");
        }
        if (abstractRecord.getType() != 3) {
            throw this.invalidDataException(n, l, new StringBuffer().append(" data is not an  byte-array-record  got=").append(abstractRecord.getLogTypeString()).toString());
        }
        if (!abstractRecord.isValid()) {
            throw this.invalidDataException(n, l, " data is marked as invalid");
        }
        return abstractRecord.getByteArray();
    }

    private PersistenceException invalidDataException(int n, long l, String string) {
        return new PersistenceException(new StringBuffer().append("Invalid data for NS=").append(n).append(", key=").append(l).append(" cause=").append(string).toString());
    }

    private IllegalArgumentException invalidModuleNamespace(String string, int n) {
        int n2 = this.services.getPersistenceKeyProvider().retrieveNamespace(string);
        String string2 = new StringBuffer().append("Unable to load peristable '").append(n).append("' for module '").append(string).append("' cause it's namespace is ").append(n2).toString();
        return new IllegalArgumentException(string2);
    }

    private void logUserDataError(PersistenceModule persistenceModule, int n, int n2, Exception exception) {
        String string = new StringBuffer().append("Could not load user data  for module ").append(persistenceModule.getName()).append(", peristableId = ").append(n).append("( namespace = ").append(n2).append(", key = ").append(PersistenceKeyUtil.calcCommonKey(n)).append(") \r\n").toString();
        string = new StringBuffer().append(string).append("Using default user data values instead! Cause: ").append(exception.getMessage()).toString();
        this.log.warning(string);
    }

    private void logCommonDataError(PersistenceModule persistenceModule, int n, int n2, Exception exception) {
        String string = new StringBuffer().append("Could not load common data for module ").append(persistenceModule.getName()).append(", peristableId = ").append(n).append("( namespace = ").append(n2).append(", key = ").append(PersistenceKeyUtil.calcCommonKey(n)).append(") \r\n").toString();
        string = new StringBuffer().append(string).append("Using defaults values instead! Cause: ").append(exception.getMessage()).toString();
        this.log.warning(string);
    }

    private void logDeclarationError(PersistenceModule persistenceModule, int n, int n2, Exception exception) {
        String string = new StringBuffer().append("Could not load declaration data for module ").append(persistenceModule.getName()).append(", peristableId = ").append(n).append("( namespace = ").append(n2).append(", key = ").append(PersistenceKeyUtil.calcCommonKey(n)).append(") \r\n").toString();
        string = new StringBuffer().append(string).append("Using defaults values instead! Cause: ").append(exception.getMessage()).toString();
        this.log.warning(string);
    }
}

