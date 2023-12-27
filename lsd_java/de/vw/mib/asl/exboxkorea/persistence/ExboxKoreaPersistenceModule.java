/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.exboxkorea.persistence;

import de.vw.mib.asl.exboxkorea.persistence.ExboxKoreaHandlerFactory;
import de.vw.mib.asl.exboxkorea.persistence.ExboxKoreaPersistableFactory;
import de.vw.mib.asl.exboxkorea.persistence.ExboxKoreaSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.log4mib.Logger;

class ExboxKoreaPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    ExboxKoreaPersistenceModule(Logger logger) {
        this.handlerFactory = new ExboxKoreaHandlerFactory(logger, this);
        this.persistableFactory = new ExboxKoreaPersistableFactory(this);
        this.serializerFactory = new ExboxKoreaSerializerFactory();
    }

    @Override
    public String getName() {
        return "ExboxKorea";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1};
    }
}

