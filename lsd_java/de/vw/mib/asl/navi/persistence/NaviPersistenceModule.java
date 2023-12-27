/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navi.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.navi.persistence.NaviHandlerFactory;
import de.vw.mib.asl.navi.persistence.NaviPersistableFactory;
import de.vw.mib.asl.navi.persistence.NaviSerializerFactory;
import de.vw.mib.log4mib.Logger;

class NaviPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    NaviPersistenceModule(Logger logger) {
        this.handlerFactory = new NaviHandlerFactory(logger, this);
        this.persistableFactory = new NaviPersistableFactory(this);
        this.serializerFactory = new NaviSerializerFactory();
    }

    @Override
    public String getName() {
        return "Navi";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 8, 20, 4, 0, 0, 0, 1, 4, 0, 0, 0, 45, 0, 0, 0, 0, 46, 0, 0, 0, 0, 47, 0, 0, 0, 0, 50, 0, 0, 0, 0, 51, 0, 0, 0, 0, 52, 4, 0, 0, 0, 53, 0, 0, 0, 1, 1, 46, 4, 0, 0, 0, 2, 4, 0, 0, 0, 3, 0, 0, 0, 0, 4, 4, 0, 0, 0, 5, 4, 0, 0, 0, 6, 0, 0, 0, 0, 7, 0, 0, 0, 0, 8, 0, 0, 0, 0, 9, 4, 0, 0, 0, 10, 4, 0, 0, 0, 11, 20, 0, 0, 0, 0, 12, 0, 0, 0, 0, 13, 0, 0, 0, 0, 14, 0, 0, 0, 0, 15, 0, 0, 0, 0, 16, 0, 0, 0, 0, 17, 0, 0, 0, 0, 18, 20, 1, 0, 0, 0, 19, 4, 0, 0, 0, 21, 4, 0, 0, 0, 22, 0, 0, 0, 0, 23, 0, 0, 0, 0, 24, 0, 0, 0, 0, 25, 0, 0, 0, 0, 26, 0, 0, 0, 0, 27, 4, 0, 0, 0, 28, 4, 0, 0, 0, 29, 0, 0, 0, 0, 30, 0, 0, 0, 0, 32, 4, 0, 0, 0, 33, 4, 0, 0, 0, 34, 4, 0, 0, 0, 35, 0, 0, 0, 0, 36, 4, 0, 0, 0, 37, 0, 0, 0, 0, 38, 0, 0, 0, 0, 39, 0, 0, 0, 0, 40, 4, 0, 0, 0, 41, 4, 0, 0, 0, 42, 0, 0, 0, 0, 43, 4, 0, 0, 0, 44, 4, 0, 0, 0, 48, 0, 0, 0, 0, 56, 0, 0, 0, 0, 57, 4, 0, 0, 0, 58, 5, 0, 0, 0, 60};
    }
}

