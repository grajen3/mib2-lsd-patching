/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.homescreen.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.homescreen.persistence.HomescreenInfo;
import de.vw.mib.asl.homescreen.persistence.HomescreenInfoHandler;
import de.vw.mib.asl.homescreen.persistence.HomescreenInfoUserHandler;
import de.vw.mib.asl.homescreen.persistence.TileContent;
import de.vw.mib.asl.homescreen.persistence.TileContentHandler;
import de.vw.mib.log4mib.Logger;

class HomescreenHandlerFactory
implements HandlerFactory {
    private final Logger logger;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$homescreen$persistence$HomescreenHandlerFactory;

    HomescreenHandlerFactory(Logger logger, PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && logger == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.logger = logger;
        this.module = persistenceModule;
    }

    @Override
    public PersistenceDataHandler createCommonHandler(Persistable persistable) {
        if (persistable == null) {
            throw new IllegalArgumentException("Cannot create PersistenceDataHandler for null persistable.");
        }
        switch (persistable.getId()) {
            case 1: {
                return new HomescreenInfoHandler((HomescreenInfo)persistable, this.logger, this.module);
            }
            case 2: {
                return new TileContentHandler((TileContent)persistable, this.logger, this.module);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("The persistable with id '").append(persistable.getId()).append("' is unknown for the persistence module 'Homescreen'").toString());
    }

    @Override
    public PersistenceDataHandler createUserHandler(Persistable persistable) {
        if (persistable == null) {
            throw new IllegalArgumentException("Cannot create PersistenceDataHandler for null persistable.");
        }
        switch (persistable.getId()) {
            case 1: {
                return new HomescreenInfoUserHandler((HomescreenInfo)persistable, this.logger, this.module);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("The persistable with id '").append(persistable.getId()).append("' is unknown for the persistence module 'Homescreen'").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$homescreen$persistence$HomescreenHandlerFactory == null ? (class$de$vw$mib$asl$homescreen$persistence$HomescreenHandlerFactory = HomescreenHandlerFactory.class$("de.vw.mib.asl.homescreen.persistence.HomescreenHandlerFactory")) : class$de$vw$mib$asl$homescreen$persistence$HomescreenHandlerFactory).desiredAssertionStatus();
    }
}

