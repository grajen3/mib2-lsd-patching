/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemearly.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.systemearly.persistence.SystemEarlyHandlerFactory;
import de.vw.mib.asl.systemearly.persistence.SystemEarlyPersistableFactory;
import de.vw.mib.asl.systemearly.persistence.SystemEarlySerializerFactory;
import de.vw.mib.log4mib.Logger;

class SystemEarlyPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    SystemEarlyPersistenceModule(Logger logger) {
        this.handlerFactory = new SystemEarlyHandlerFactory(logger, this);
        this.persistableFactory = new SystemEarlyPersistableFactory(this);
        this.serializerFactory = new SystemEarlySerializerFactory();
    }

    @Override
    public String getName() {
        return "SystemEarly";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 3};
    }
}

