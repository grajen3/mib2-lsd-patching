/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.carearly.persistence;

import de.vw.mib.asl.carearly.persistence.CarEarlyHandlerFactory;
import de.vw.mib.asl.carearly.persistence.CarEarlyPersistableFactory;
import de.vw.mib.asl.carearly.persistence.CarEarlySerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.log4mib.Logger;

class CarEarlyPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    CarEarlyPersistenceModule(Logger logger) {
        this.handlerFactory = new CarEarlyHandlerFactory(logger, this);
        this.persistableFactory = new CarEarlyPersistableFactory(this);
        this.serializerFactory = new CarEarlySerializerFactory();
    }

    @Override
    public String getName() {
        return "CarEarly";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 6, 0, 0, 0, 0, 6, 4, 0, 0, 0, 1, 0, 0, 0, 0, 5, 4, 0, 0, 0, 2, 4, 0, 0, 0, 3, 4, 0, 0, 0, 4};
    }
}

