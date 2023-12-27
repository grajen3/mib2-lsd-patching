/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.picturestore.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.picturestore.persistence.StoredPicture;

class StoredPictureImpl
extends AbstractPersistable
implements StoredPicture {
    private final PersistenceModule module;
    private int identification;
    private String url;
    private int bitfieldOfUsers;
    private int ctxId;

    StoredPictureImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 1;
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
    public int getIdentification() {
        return this.identification;
    }

    @Override
    public void setIdentification(int n) {
        this.identification = n;
        this.markDirty();
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public void setUrl(String string) {
        this.url = string;
        this.markDirty();
    }

    @Override
    public int getBitfieldOfUsers() {
        return this.bitfieldOfUsers;
    }

    @Override
    public void setBitfieldOfUsers(int n) {
        this.bitfieldOfUsers = n;
        this.markDirty();
    }

    @Override
    public int getCtxId() {
        return this.ctxId;
    }

    @Override
    public void setCtxId(int n) {
        this.ctxId = n;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

