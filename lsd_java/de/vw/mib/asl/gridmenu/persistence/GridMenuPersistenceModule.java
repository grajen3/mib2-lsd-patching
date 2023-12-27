/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.gridmenu.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.gridmenu.persistence.GridMenuHandlerFactory;
import de.vw.mib.asl.gridmenu.persistence.GridMenuPersistableFactory;
import de.vw.mib.asl.gridmenu.persistence.GridMenuSerializerFactory;
import de.vw.mib.log4mib.Logger;

class GridMenuPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    GridMenuPersistenceModule(Logger logger) {
        this.handlerFactory = new GridMenuHandlerFactory(logger, this);
        this.persistableFactory = new GridMenuPersistableFactory(this);
        this.serializerFactory = new GridMenuSerializerFactory();
    }

    @Override
    public String getName() {
        return "GridMenu";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 1, 20, 5, 0, 0, 0, 1};
    }
}

