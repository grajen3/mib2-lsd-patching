/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.picturestore.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.picturestore.persistence.PictureStoreHandlerFactory;
import de.vw.mib.asl.picturestore.persistence.PictureStorePersistableFactory;
import de.vw.mib.asl.picturestore.persistence.PictureStoreSerializerFactory;
import de.vw.mib.log4mib.Logger;

class PictureStorePersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    PictureStorePersistenceModule(Logger logger) {
        this.handlerFactory = new PictureStoreHandlerFactory(logger, this);
        this.persistableFactory = new PictureStorePersistableFactory(this);
        this.serializerFactory = new PictureStoreSerializerFactory();
    }

    @Override
    public String getName() {
        return "PictureStore";
    }

    @Override
    public long getVersion() {
        return 0L;
    }

    @Override
    public HandlerFactory getHandlerFactory() {
        return this.handlerFactory;
    }

    @Override
    public PersistableFactory getPersistableFactory() {
        return this.persistableFactory;
    }

    @Override
    public PersistableSerializerFactory getSerializerFactory() {
        return this.serializerFactory;
    }

    @Override
    public boolean isUserSpecific() {
        return false;
    }

    @Override
    public byte[] getDeclaration() {
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 4, 4, 0, 0, 0, 1, 8, 0, 0, 0, 2, 4, 0, 0, 0, 3, 4, 0, 0, 0, 4, 0, 0, 0, 2, 0, 1, 20, 30, 0, 0, 0, 1, 0, 0, 0, 1};
    }
}

