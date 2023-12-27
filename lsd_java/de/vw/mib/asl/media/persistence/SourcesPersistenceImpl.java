/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.collections.maps.PersistenceHashMap;
import de.vw.mib.asl.framework.api.persistence2.collections.maps.PersistenceIntIntOptHashMap;
import de.vw.mib.asl.framework.api.persistence2.collections.sets.PersistenceIntOptHashSet;
import de.vw.mib.asl.media.persistence.SourcesPersistence;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntSet;
import java.util.Map;

class SourcesPersistenceImpl
extends AbstractPersistable
implements SourcesPersistence {
    private final PersistenceModule module;
    private final PersistenceIntIntOptHashMap partitionLSM = new PersistenceIntIntOptHashMap();
    private final PersistenceIntOptHashSet databaseFullReported = new PersistenceIntOptHashSet();
    private final PersistenceHashMap deflowered = new PersistenceHashMap();
    private int mediaType;
    private int objectId;

    SourcesPersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 6;
    }

    @Override
    public boolean hasUserSpecificData() {
        return true;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        this.partitionLSM.setRootPersistable(persistable);
        this.databaseFullReported.setRootPersistable(persistable);
        this.deflowered.setRootPersistable(persistable);
    }

    @Override
    public int getMediaType() {
        return this.mediaType;
    }

    @Override
    public void setMediaType(int n) {
        this.mediaType = n;
        this.markDirty();
    }

    @Override
    public IntIntMap getPartitionLSM() {
        return this.partitionLSM;
    }

    @Override
    public IntSet getDatabaseFullReported() {
        return this.databaseFullReported;
    }

    @Override
    public Map getDeflowered() {
        return this.deflowered;
    }

    @Override
    public int getObjectId() {
        return this.objectId;
    }

    @Override
    public void setObjectId(int n) {
        this.objectId = n;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

