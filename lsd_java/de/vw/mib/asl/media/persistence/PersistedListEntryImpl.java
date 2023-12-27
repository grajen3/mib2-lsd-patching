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
import de.vw.mib.asl.media.persistence.PersistedListEntry;

class PersistedListEntryImpl
extends AbstractPersistable
implements PersistedListEntry {
    private final PersistenceModule module;
    private long entryID;
    private String filename;
    private int contentType;

    PersistedListEntryImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 9;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
    }

    @Override
    public long getEntryID() {
        return this.entryID;
    }

    @Override
    public void setEntryID(long l) {
        this.entryID = l;
        this.markDirty();
    }

    @Override
    public String getFilename() {
        return this.filename;
    }

    @Override
    public void setFilename(String string) {
        this.filename = string;
        this.markDirty();
    }

    @Override
    public int getContentType() {
        return this.contentType;
    }

    @Override
    public void setContentType(int n) {
        this.contentType = n;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

