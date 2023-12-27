/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemearly.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.systemearly.persistence.SystemEarlyImpl;

class SystemEarlyPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$systemearly$persistence$SystemEarlyPersistableFactory;

    SystemEarlyPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 1: {
                return new SystemEarlyImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module SystemEarly").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 1: {
                SystemEarlyImpl systemEarlyImpl = new SystemEarlyImpl(this.module);
                handlerFactory.createCommonHandler(systemEarlyImpl).finish();
                return systemEarlyImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module SystemEarly").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$systemearly$persistence$SystemEarlyPersistableFactory == null ? (class$de$vw$mib$asl$systemearly$persistence$SystemEarlyPersistableFactory = SystemEarlyPersistableFactory.class$("de.vw.mib.asl.systemearly.persistence.SystemEarlyPersistableFactory")) : class$de$vw$mib$asl$systemearly$persistence$SystemEarlyPersistableFactory).desiredAssertionStatus();
    }
}

