/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.vicsetc.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.vicsetc.persistence.VicsEtcHandlerFactory;
import de.vw.mib.asl.vicsetc.persistence.VicsEtcPersistableFactory;
import de.vw.mib.asl.vicsetc.persistence.VicsEtcSerializerFactory;
import de.vw.mib.log4mib.Logger;

class VicsEtcPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    VicsEtcPersistenceModule(Logger logger) {
        this.handlerFactory = new VicsEtcHandlerFactory(logger, this);
        this.persistableFactory = new VicsEtcPersistableFactory(this);
        this.serializerFactory = new VicsEtcSerializerFactory();
    }

    @Override
    public String getName() {
        return "VicsEtc";
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
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 16, 4, 0, 0, 0, 1, 8, 0, 0, 0, 15, 4, 0, 0, 0, 3, 0, 0, 0, 0, 4, 0, 0, 0, 0, 5, 0, 0, 0, 0, 6, 0, 0, 0, 0, 7, 0, 0, 0, 0, 8, 0, 0, 0, 0, 9, 0, 0, 0, 0, 10, 0, 0, 0, 0, 11, 0, 0, 0, 0, 12, 0, 0, 0, 0, 13, 0, 0, 0, 0, 14, 0, 0, 0, 0, 16, 8, 0, 0, 0, 17};
    }
}

