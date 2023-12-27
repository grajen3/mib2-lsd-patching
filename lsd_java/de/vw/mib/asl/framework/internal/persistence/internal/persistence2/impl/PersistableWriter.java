/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDb;
import de.vw.mib.asl.framework.internal.persistence.internal.db.RecordByteArray;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceLogger;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableMetaInfo;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

public class PersistableWriter {
    private final PersistenceKeyProvider persistenceKeys;
    private final PersistenceLogger log;
    private final ApiPersDb apiPersDb;

    public PersistableWriter(PersistenceServices persistenceServices, Map map) {
        this.persistenceKeys = persistenceServices.getPersistenceKeyProvider();
        this.apiPersDb = persistenceServices.getApiPersDb();
        this.log = persistenceServices.getPersistenceLogger();
    }

    public void writeDirtyPersistables(Map map) {
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            AbstractPersistable abstractPersistable = (AbstractPersistable)map$Entry.getKey();
            PersistableMetaInfo persistableMetaInfo = (PersistableMetaInfo)map$Entry.getValue();
            if (!abstractPersistable.isDirty()) continue;
            this.writeDirtyPersistable(abstractPersistable, persistableMetaInfo);
        }
    }

    private void writeDirtyPersistable(AbstractPersistable abstractPersistable, PersistableMetaInfo persistableMetaInfo) {
        PersistenceModule persistenceModule = persistableMetaInfo.getModule();
        this.log.trace(new StringBuffer().append("Writing data for module ").append(persistenceModule.getName()).append(", persistableId=").append(abstractPersistable.getId()).toString());
        int n = this.persistenceKeys.retrieveNamespace(persistenceModule.getName());
        abstractPersistable.updateRootPersistable(abstractPersistable);
        long l = PersistenceKeyUtil.calcCommonKey(abstractPersistable.getId());
        try {
            byte[] byArray;
            long l2;
            PersistableSerializer persistableSerializer = persistenceModule.getSerializerFactory().createSerializer(abstractPersistable.getId());
            byte[] byArray2 = persistableSerializer.serializeCommonData(abstractPersistable);
            this.persistData(n, l, byArray2);
            if (abstractPersistable.hasUserSpecificData()) {
                l2 = PersistenceKeyUtil.calcUserKey(abstractPersistable.getId(), persistableMetaInfo.getProfileId());
                byArray = persistableSerializer.serializeUserSpecificData(abstractPersistable);
                this.persistData(n, l2, byArray);
            }
            l2 = 0L;
            byArray = persistenceModule.getDeclaration();
            this.persistData(n, l2, byArray);
            abstractPersistable.clearDirty();
        }
        catch (Exception exception) {
            PersDebug.error(new StringBuffer().append("Error saving a SharedPersistable: ").append(PersDebug.namespaceKeyString(n, l)).toString(), exception);
        }
    }

    private void persistData(int n, long l, byte[] byArray) {
        boolean bl = true;
        RecordByteArray recordByteArray = new RecordByteArray(n, l, byArray, bl);
        this.apiPersDb.putIntoCache(n, l, recordByteArray, false);
    }
}

