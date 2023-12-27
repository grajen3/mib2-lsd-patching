/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navinfotile.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.navinfotile.persistence.NavInfoTileHandlerFactory;
import de.vw.mib.asl.navinfotile.persistence.NavInfoTilePersistableFactory;
import de.vw.mib.asl.navinfotile.persistence.NavInfoTileSerializerFactory;
import de.vw.mib.log4mib.Logger;

class NavInfoTilePersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    NavInfoTilePersistenceModule(Logger logger) {
        this.handlerFactory = new NavInfoTileHandlerFactory(logger, this);
        this.persistableFactory = new NavInfoTilePersistableFactory(this);
        this.serializerFactory = new NavInfoTileSerializerFactory();
    }

    @Override
    public String getName() {
        return "NavInfoTile";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 4, 0, 0, 0, 3};
    }
}

