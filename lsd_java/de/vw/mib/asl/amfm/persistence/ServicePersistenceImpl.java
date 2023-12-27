/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.collections.lists.PersistenceArrayList;
import java.util.List;

class ServicePersistenceImpl
extends AbstractPersistable
implements ServicePersistence {
    private final PersistenceModule module;
    private final PersistenceArrayList ptyCodes = new PersistenceArrayList();
    private int ensEcc;
    private int ensId;
    private long serviceId;
    private String fullName;
    private String shortName;
    private boolean tp;

    ServicePersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 11;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        this.ptyCodes.setRootPersistable(persistable);
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
    public int getEnsId() {
        return this.ensId;
    }

    @Override
    public void setEnsId(int n) {
        this.ensId = n;
        this.markDirty();
    }

    @Override
    public long getServiceId() {
        return this.serviceId;
    }

    @Override
    public void setServiceId(long l) {
        this.serviceId = l;
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
    public List getPtyCodes() {
        return this.ptyCodes;
    }

    @Override
    public boolean isTp() {
        return this.tp;
    }

    @Override
    public void setTp(boolean bl) {
        this.tp = bl;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

