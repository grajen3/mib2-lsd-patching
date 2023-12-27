/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.instrumentcluster.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.instrumentcluster.persistence.InstrumentClusterHandlerFactory;
import de.vw.mib.asl.instrumentcluster.persistence.InstrumentClusterPersistableFactory;
import de.vw.mib.asl.instrumentcluster.persistence.InstrumentClusterSerializerFactory;
import de.vw.mib.log4mib.Logger;

class InstrumentClusterPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    InstrumentClusterPersistenceModule(Logger logger) {
        this.handlerFactory = new InstrumentClusterHandlerFactory(logger, this);
        this.persistableFactory = new InstrumentClusterPersistableFactory(this);
        this.serializerFactory = new InstrumentClusterSerializerFactory();
    }

    @Override
    public String getName() {
        return "InstrumentCluster";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 1, 4, 0, 0, 0, 1};
    }
}

