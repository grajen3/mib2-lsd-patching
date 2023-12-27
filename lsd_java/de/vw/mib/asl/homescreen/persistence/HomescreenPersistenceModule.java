/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.homescreen.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.homescreen.persistence.HomescreenHandlerFactory;
import de.vw.mib.asl.homescreen.persistence.HomescreenPersistableFactory;
import de.vw.mib.asl.homescreen.persistence.HomescreenSerializerFactory;
import de.vw.mib.log4mib.Logger;

class HomescreenPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    HomescreenPersistenceModule(Logger logger) {
        this.handlerFactory = new HomescreenHandlerFactory(logger, this);
        this.persistableFactory = new HomescreenPersistableFactory(this);
        this.serializerFactory = new HomescreenSerializerFactory();
    }

    @Override
    public String getName() {
        return "Homescreen";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 2, 4, 0, 0, 0, 1, 20, 30, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 3, 8, 0, 0, 0, 1, 4, 0, 0, 0, 2, 5, 0, 0, 0, 3};
    }
}

