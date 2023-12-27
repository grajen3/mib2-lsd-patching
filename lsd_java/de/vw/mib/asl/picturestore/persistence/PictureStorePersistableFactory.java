/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.picturestore.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.picturestore.persistence.PictureStoreImpl;
import de.vw.mib.asl.picturestore.persistence.StoredPictureImpl;

class PictureStorePersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$picturestore$persistence$PictureStorePersistableFactory;

    PictureStorePersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 1: {
                return new StoredPictureImpl(this.module);
            }
            case 2: {
                return new PictureStoreImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module PictureStore").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 1: {
                StoredPictureImpl storedPictureImpl = new StoredPictureImpl(this.module);
                handlerFactory.createCommonHandler(storedPictureImpl).finish();
                return storedPictureImpl;
            }
            case 2: {
                PictureStoreImpl pictureStoreImpl = new PictureStoreImpl(this.module);
                handlerFactory.createCommonHandler(pictureStoreImpl).finish();
                return pictureStoreImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module PictureStore").toString());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$picturestore$persistence$PictureStorePersistableFactory == null ? (class$de$vw$mib$asl$picturestore$persistence$PictureStorePersistableFactory = PictureStorePersistableFactory.class$("de.vw.mib.asl.picturestore.persistence.PictureStorePersistableFactory")) : class$de$vw$mib$asl$picturestore$persistence$PictureStorePersistableFactory).desiredAssertionStatus();
    }
}

