/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.ComponentPersistence;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class ComponentPersistenceImpl
extends AbstractPersistable
implements ComponentPersistence {
    private final PersistenceModule module;
    private int ensId;
    private int ensEcc;
    private long sid;
    private int scidi;
    private String fullName;
    private String shortName;
    private boolean primaryService;

    ComponentPersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 12;
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
    public int getEnsId() {
        return this.ensId;
    }

    @Override
    public void setEnsId(int n) {
        this.ensId = n;
        this.markDirty();
    }

    @Override
    public int getEnsEcc() {
        return this.ensEcc;
    }

    @Override
    public void setEnsEcc(int n) {
        this.ensEcc = n;
        this.markDirty();
    }

    @Override
    public long getSid() {
        return this.sid;
    }

    @Override
    public void setSid(long l) {
        this.sid = l;
        this.markDirty();
    }

    @Override
    public int getScidi() {
        return this.scidi;
    }

    @Override
    public void setScidi(int n) {
        this.scidi = n;
        this.markDirty();
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public void setFullName(String string) {
        this.fullName = string;
        this.markDirty();
    }

    @Override
    public String getShortName() {
        return this.shortName;
    }

    @Override
    public void setShortName(String string) {
        this.shortName = string;
        this.markDirty();
    }

    @Override
    public boolean isPrimaryService() {
        return this.primaryService;
    }

    @Override
    public void setPrimaryService(boolean bl) {
        this.primaryService = bl;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

