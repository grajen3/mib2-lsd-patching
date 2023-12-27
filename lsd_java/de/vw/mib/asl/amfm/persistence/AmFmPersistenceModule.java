/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmHandlerFactory;
import de.vw.mib.asl.amfm.persistence.AmFmPersistableFactory;
import de.vw.mib.asl.amfm.persistence.AmFmSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.log4mib.Logger;

class AmFmPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    AmFmPersistenceModule(Logger logger) {
        this.handlerFactory = new AmFmHandlerFactory(logger, this);
        this.persistableFactory = new AmFmPersistableFactory(this);
        this.serializerFactory = new AmFmSerializerFactory();
    }

    @Override
    public String getName() {
        return "AmFm";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 6, 0, 0, 0, 0, 43, 0, 0, 0, 0, 44, 4, 0, 0, 0, 1, 4, 0, 0, 0, 2, 4, 0, 0, 0, 6, 4, 0, 0, 0, 7, 0, 0, 0, 1, 1, 34, 0, 0, 0, 0, 8, 0, 0, 0, 0, 9, 0, 0, 0, 0, 10, 0, 0, 0, 0, 11, 4, 0, 0, 0, 12, 4, 0, 0, 0, 13, 4, 0, 0, 0, 14, 0, 0, 0, 0, 15, 4, 0, 0, 0, 16, 4, 0, 0, 0, 17, 0, 0, 0, 0, 18, 0, 0, 0, 0, 19, 4, 0, 0, 0, 20, 0, 0, 0, 0, 21, 0, 0, 0, 0, 39, 0, 0, 0, 0, 22, 0, 0, 0, 0, 23, 0, 0, 0, 0, 24, 0, 0, 0, 0, 25, 0, 0, 0, 0, 26, 0, 0, 0, 0, 27, 0, 0, 0, 0, 28, 0, 0, 0, 0, 29, 0, 0, 0, 0, 30, 0, 0, 0, 0, 31, 0, 0, 0, 0, 32, 30, 0, 0, 0, 2, 0, 0, 0, 33, 30, 0, 0, 0, 2, 0, 0, 0, 34, 4, 0, 0, 0, 36, 4, 0, 0, 0, 37, 4, 0, 0, 0, 38, 4, 0, 0, 0, 40, 4, 0, 0, 0, 41, 4, 0, 0, 0, 42, 0, 0, 0, 2, 0, 30, 8, 0, 0, 0, 1, 5, 0, 0, 0, 2, 4, 0, 0, 0, 3, 4, 0, 0, 0, 4, 4, 0, 0, 0, 5, 4, 0, 0, 0, 6, 0, 0, 0, 0, 7, 0, 0, 0, 0, 8, 0, 0, 0, 0, 9, 0, 0, 0, 0, 10, 0, 0, 0, 0, 11, 0, 0, 0, 0, 12, 8, 0, 0, 0, 13, 0, 0, 0, 0, 14, 8, 0, 0, 0, 15, 8, 0, 0, 0, 16, 0, 0, 0, 0, 17, 4, 0, 0, 0, 18, 4, 0, 0, 0, 19, 0, 0, 0, 0, 20, 0, 0, 0, 0, 21, 8, 0, 0, 0, 22, 8, 0, 0, 0, 23, 4, 0, 0, 0, 24, 4, 0, 0, 0, 25, 4, 0, 0, 0, 26, 5, 0, 0, 0, 27, 0, 0, 0, 0, 28, 0, 0, 0, 0, 29, 30, 0, 0, 0, 4, 0, 0, 0, 30, 0, 0, 0, 3, 0, 7, 30, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 8, 30, 0, 0, 0, 4, 0, 0, 0, 3, 4, 0, 0, 0, 5, 4, 0, 0, 0, 6, 5, 0, 0, 0, 7, 0, 0, 0, 4, 0, 2, 4, 0, 0, 0, 1, 8, 0, 0, 0, 2, 0, 0, 0, 5, 0, 0, 0, 0, 0, 5, 1, 6, 20, 30, 0, 0, 0, 3, 0, 0, 0, 1, 20, 30, 0, 0, 0, 3, 0, 0, 0, 2, 4, 0, 0, 0, 3, 4, 0, 0, 0, 4, 4, 0, 0, 0, 5, 4, 0, 0, 0, 6, 0, 0, 0, 6, 0, 0, 0, 0, 0, 6, 1, 1, 20, 30, 0, 0, 0, 7, 0, 0, 0, 1, 0, 0, 0, 7, 0, 6, 4, 0, 0, 0, 1, 4, 0, 0, 0, 2, 8, 0, 0, 0, 3, 8, 0, 0, 0, 4, 4, 0, 0, 0, 5, 3, 0, 0, 0, 6, 0, 0, 0, 8, 0, 2, 4, 0, 0, 0, 21, 4, 0, 0, 0, 22, 0, 0, 0, 8, 1, 17, 30, 0, 0, 0, 9, 0, 0, 0, 1, 30, 0, 0, 0, 10, 0, 0, 0, 2, 30, 0, 0, 0, 11, 0, 0, 0, 3, 30, 0, 0, 0, 12, 0, 0, 0, 4, 30, 0, 0, 0, 10, 0, 0, 0, 5, 30, 0, 0, 0, 11, 0, 0, 0, 6, 0, 0, 0, 0, 7, 0, 0, 0, 0, 8, 0, 0, 0, 0, 9, 0, 0, 0, 0, 10, 0, 0, 0, 0, 11, 4, 0, 0, 0, 12, 0, 0, 0, 0, 13, 4, 0, 0, 0, 16, 4, 0, 0, 0, 17, 0, 0, 0, 0, 18, 20, 30, 0, 0, 0, 13, 0, 0, 0, 19, 0, 0, 0, 9, 0, 2, 5, 0, 0, 0, 1, 8, 0, 0, 0, 2, 0, 0, 0, 10, 0, 8, 4, 0, 0, 0, 1, 4, 0, 0, 0, 2, 8, 0, 0, 0, 3, 4, 0, 0, 0, 4, 8, 0, 0, 0, 5, 0, 0, 0, 0, 6, 8, 0, 0, 0, 7, 0, 0, 0, 0, 8, 0, 0, 0, 11, 0, 7, 4, 0, 0, 0, 1, 4, 0, 0, 0, 2, 5, 0, 0, 0, 8, 8, 0, 0, 0, 4, 8, 0, 0, 0, 5, 20, 1, 0, 0, 0, 6, 0, 0, 0, 0, 7, 0, 0, 0, 12, 0, 7, 4, 0, 0, 0, 1, 4, 0, 0, 0, 2, 5, 0, 0, 0, 3, 4, 0, 0, 0, 4, 8, 0, 0, 0, 5, 8, 0, 0, 0, 6, 0, 0, 0, 0, 7, 0, 0, 0, 13, 0, 5, 30, 0, 0, 0, 11, 0, 0, 0, 1, 30, 0, 0, 0, 10, 0, 0, 0, 2, 30, 0, 0, 0, 9, 0, 0, 0, 3, 30, 0, 0, 0, 4, 0, 0, 0, 4, 5, 0, 0, 0, 6, 0, 0, 0, 14, 0, 11, 4, 0, 0, 0, 39, 4, 0, 0, 0, 30, 4, 0, 0, 0, 31, 4, 0, 0, 0, 32, 8, 0, 0, 0, 33, 4, 0, 0, 0, 34, 8, 0, 0, 0, 35, 4, 0, 0, 0, 36, 4, 0, 0, 0, 37, 0, 0, 0, 0, 38, 20, 30, 0, 0, 0, 16, 0, 0, 0, 27, 0, 0, 0, 14, 1, 13, 30, 0, 0, 0, 15, 0, 0, 0, 1, 30, 0, 0, 0, 15, 0, 0, 0, 2, 4, 0, 0, 0, 3, 0, 0, 0, 0, 4, 4, 0, 0, 0, 5, 20, 30, 0, 0, 0, 15, 0, 0, 0, 6, 4, 0, 0, 0, 28, 1, 0, 0, 0, 8, 0, 0, 0, 0, 9, 20, 4, 0, 0, 0, 10, 20, 4, 0, 0, 0, 29, 0, 0, 0, 0, 23, 0, 0, 0, 0, 24, 0, 0, 0, 15, 0, 7, 4, 0, 0, 0, 1, 4, 0, 0, 0, 2, 4, 0, 0, 0, 3, 4, 0, 0, 0, 4, 8, 0, 0, 0, 5, 8, 0, 0, 0, 6, 0, 0, 0, 0, 7, 0, 0, 0, 16, 0, 2, 4, 0, 0, 0, 1, 30, 0, 0, 0, 4, 0, 0, 0, 2};
    }
}

