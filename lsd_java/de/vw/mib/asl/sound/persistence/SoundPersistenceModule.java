/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.sound.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.sound.persistence.SoundHandlerFactory;
import de.vw.mib.asl.sound.persistence.SoundPersistableFactory;
import de.vw.mib.asl.sound.persistence.SoundSerializerFactory;
import de.vw.mib.log4mib.Logger;

class SoundPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    SoundPersistenceModule(Logger logger) {
        this.handlerFactory = new SoundHandlerFactory(logger, this);
        this.persistableFactory = new SoundPersistableFactory(this);
        this.serializerFactory = new SoundSerializerFactory();
    }

    @Override
    public String getName() {
        return "Sound";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 6, 4, 0, 0, 0, 1, 3, 0, 0, 0, 2, 3, 0, 0, 0, 3, 3, 0, 0, 0, 4, 4, 0, 0, 0, 5, 0, 0, 0, 0, 6};
    }
}

