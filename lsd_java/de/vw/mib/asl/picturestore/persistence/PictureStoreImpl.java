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
import de.vw.mib.asl.framework.api.persistence2.collections.lists.PersistenceArrayList;
import de.vw.mib.asl.picturestore.persistence.PictureStore;
import java.util.Iterator;
import java.util.List;

class PictureStoreImpl
extends AbstractPersistable
implements PictureStore {
    private final PersistenceModule module;
    private final PersistenceArrayList pictures = new PersistenceArrayList();

    PictureStoreImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        this.pictures.setRootPersistable(persistable);
        Iterator iterator = this.getPictures().iterator();
        while (iterator.hasNext()) {
            AbstractPersistable abstractPersistable = (AbstractPersistable)iterator.next();
            if (abstractPersistable == null) continue;
            abstractPersistable.updateRootPersistable(persistable);
        }
    }

    @Override
    public List getPictures() {
        return this.pictures;
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

