/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.media.persistence.MediaHandlerFactory;
import de.vw.mib.asl.media.persistence.MediaPersistableFactory;
import de.vw.mib.asl.media.persistence.MediaSerializerFactory;
import de.vw.mib.log4mib.Logger;

class MediaPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    MediaPersistenceModule(Logger logger) {
        this.handlerFactory = new MediaHandlerFactory(logger, this);
        this.persistableFactory = new MediaPersistableFactory(this);
        this.serializerFactory = new MediaSerializerFactory();
    }

    @Override
    public String getName() {
        return "Media";
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
        return true;
    }

    @Override
    public byte[] getDeclaration() {
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 4, 4, 0, 0, 0, 1, 22, 4, 4, 0, 0, 0, 2, 21, 4, 0, 0, 0, 3, 22, 4, 8, 0, 0, 0, 4, 0, 0, 0, 6, 1, 1, 4, 0, 0, 0, 5, 0, 0, 0, 7, 0, 2, 8, 0, 0, 0, 1, 4, 0, 0, 0, 2, 0, 0, 0, 7, 1, 4, 0, 0, 0, 0, 3, 4, 0, 0, 0, 4, 22, 4, 30, 0, 0, 0, 8, 0, 0, 0, 8, 0, 0, 0, 0, 7, 0, 0, 0, 8, 0, 14, 4, 0, 0, 0, 14, 8, 0, 0, 0, 1, 4, 0, 0, 0, 2, 0, 0, 0, 0, 3, 4, 0, 0, 0, 4, 20, 30, 0, 0, 0, 9, 0, 0, 0, 5, 0, 0, 0, 0, 6, 0, 0, 0, 0, 7, 4, 0, 0, 0, 8, 4, 0, 0, 0, 9, 5, 0, 0, 0, 10, 5, 0, 0, 0, 11, 5, 0, 0, 0, 12, 5, 0, 0, 0, 13, 0, 0, 0, 9, 0, 3, 5, 0, 0, 0, 1, 8, 0, 0, 0, 2, 4, 0, 0, 0, 3};
    }
}

