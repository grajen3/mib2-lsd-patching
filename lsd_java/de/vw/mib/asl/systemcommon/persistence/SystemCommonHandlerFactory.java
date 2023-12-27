/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;
import de.vw.mib.asl.systemcommon.persistence.AbtFeaturesHandler;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonHandler;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonUserHandler;
import de.vw.mib.asl.systemcommon.persistence.Units;
import de.vw.mib.asl.systemcommon.persistence.UnitsHandler;
import de.vw.mib.asl.systemcommon.persistence.UnitsUserHandler;
import de.vw.mib.log4mib.Logger;

class SystemCommonHandlerFactory
implements HandlerFactory {
    private final Logger logger;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$systemcommon$persistence$SystemCommonHandlerFactory;

    SystemCommonHandlerFactory(Logger logger, PersistenceModule persistenceModule) {
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
                return new SystemCommonHandler((SystemCommon)persistable, this.logger, this.module);
            }
            case 3: {
                return new UnitsHandler((Units)persistable, this.logger, this.module);
            }
            case 2: {
                return new AbtFeaturesHandler((AbtFeatures)persistable, this.logger, this.module);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("The persistable with id '").append(persistable.getId()).append("' is unknown for the persistence module 'SystemCommon'").toString());
    }

    @Override
    public PersistenceDataHandler createUserHandler(Persistable persistable) {
        if (persistable == null) {
            throw new IllegalArgumentException("Cannot create PersistenceDataHandler for null persistable.");
        }
        switch (persistable.getId()) {
            case 1: {
                return new SystemCommonUserHandler((SystemCommon)persistable, this.logger, this.module);
            }
            case 3: {
                return new UnitsUserHandler((Units)persistable, this.logger, this.module);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("The persistable with id '").append(persistable.getId()).append("' is unknown for the persistence module 'SystemCommon'").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$systemcommon$persistence$SystemCommonHandlerFactory == null ? (class$de$vw$mib$asl$systemcommon$persistence$SystemCommonHandlerFactory = SystemCommonHandlerFactory.class$("de.vw.mib.asl.systemcommon.persistence.SystemCommonHandlerFactory")) : class$de$vw$mib$asl$systemcommon$persistence$SystemCommonHandlerFactory).desiredAssertionStatus();
    }
}

