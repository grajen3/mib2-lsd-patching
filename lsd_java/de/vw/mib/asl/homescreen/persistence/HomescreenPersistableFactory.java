/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.homescreen.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.homescreen.persistence.HomescreenInfoImpl;
import de.vw.mib.asl.homescreen.persistence.TileContentImpl;

class HomescreenPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$homescreen$persistence$HomescreenPersistableFactory;

    HomescreenPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 1: {
                return new HomescreenInfoImpl(this.module);
            }
            case 2: {
                return new TileContentImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module Homescreen").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 1: {
                HomescreenInfoImpl homescreenInfoImpl = new HomescreenInfoImpl(this.module);
                handlerFactory.createCommonHandler(homescreenInfoImpl).finish();
                handlerFactory.createUserHandler(homescreenInfoImpl).finish();
                return homescreenInfoImpl;
            }
            case 2: {
                TileContentImpl tileContentImpl = new TileContentImpl(this.module);
                handlerFactory.createCommonHandler(tileContentImpl).finish();
                return tileContentImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module Homescreen").toString());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$homescreen$persistence$HomescreenPersistableFactory == null ? (class$de$vw$mib$asl$homescreen$persistence$HomescreenPersistableFactory = HomescreenPersistableFactory.class$("de.vw.mib.asl.homescreen.persistence.HomescreenPersistableFactory")) : class$de$vw$mib$asl$homescreen$persistence$HomescreenPersistableFactory).desiredAssertionStatus();
    }
}

