/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.car.persistence;

import de.vw.mib.asl.car.persistence.CarHandlerFactory;
import de.vw.mib.asl.car.persistence.CarPersistableFactory;
import de.vw.mib.asl.car.persistence.CarSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.log4mib.Logger;

class CarPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    CarPersistenceModule(Logger logger) {
        this.handlerFactory = new CarHandlerFactory(logger, this);
        this.persistableFactory = new CarPersistableFactory(this);
        this.serializerFactory = new CarSerializerFactory();
    }

    @Override
    public String getName() {
        return "Car";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 21, 0, 0, 0, 0, 31, 0, 0, 0, 0, 32, 0, 0, 0, 0, 33, 0, 0, 0, 0, 34, 0, 0, 0, 0, 35, 4, 0, 0, 0, 49, 0, 0, 0, 0, 37, 0, 0, 0, 0, 38, 0, 0, 0, 0, 39, 0, 0, 0, 0, 40, 4, 0, 0, 0, 41, 4, 0, 0, 0, 42, 4, 0, 0, 0, 43, 4, 0, 0, 0, 44, 4, 0, 0, 0, 45, 4, 0, 0, 0, 46, 4, 0, 0, 0, 47, 4, 0, 0, 0, 48, 0, 0, 0, 0, 50, 0, 0, 0, 0, 51, 30, 0, 0, 0, 2, 0, 0, 0, 60, 0, 0, 0, 2, 0, 6, 4, 0, 0, 0, 1, 4, 0, 0, 0, 2, 4, 0, 0, 0, 3, 4, 0, 0, 0, 4, 4, 0, 0, 0, 5, 4, 0, 0, 0, 6};
    }
}

