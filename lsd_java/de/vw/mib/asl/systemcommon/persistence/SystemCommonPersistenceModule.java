/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonHandlerFactory;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistableFactory;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonSerializerFactory;
import de.vw.mib.log4mib.Logger;

class SystemCommonPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    SystemCommonPersistenceModule(Logger logger) {
        this.handlerFactory = new SystemCommonHandlerFactory(logger, this);
        this.persistableFactory = new SystemCommonPersistableFactory(this);
        this.serializerFactory = new SystemCommonSerializerFactory();
    }

    @Override
    public String getName() {
        return "SystemCommon";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 4, 0, 0, 0, 0, 6, 0, 0, 0, 0, 19, 0, 0, 0, 0, 15, 0, 0, 0, 0, 21, 0, 0, 0, 1, 1, 14, 4, 0, 0, 0, 1, 0, 0, 0, 0, 2, 4, 0, 0, 0, 11, 4, 0, 0, 0, 3, 5, 0, 0, 0, 4, 0, 0, 0, 0, 5, 0, 0, 0, 0, 13, 4, 0, 0, 0, 12, 0, 0, 0, 0, 14, 0, 0, 0, 0, 16, 0, 0, 0, 0, 17, 0, 0, 0, 0, 18, 8, 0, 0, 0, 20, 0, 0, 0, 0, 22, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 1, 9, 4, 0, 0, 0, 1, 4, 0, 0, 0, 2, 4, 0, 0, 0, 3, 4, 0, 0, 0, 4, 4, 0, 0, 0, 5, 4, 0, 0, 0, 6, 4, 0, 0, 0, 7, 4, 0, 0, 0, 8, 4, 0, 0, 0, 9, 0, 0, 0, 2, 0, 13, 4, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 3, 4, 0, 0, 0, 4, 4, 0, 0, 0, 5, 4, 0, 0, 0, 6, 4, 0, 0, 0, 7, 4, 0, 0, 0, 8, 4, 0, 0, 0, 9, 4, 0, 0, 0, 10, 4, 0, 0, 0, 11, 4, 0, 0, 0, 12, 4, 0, 0, 0, 13};
    }
}

