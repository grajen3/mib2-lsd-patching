/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.entertainmentmanager.persistence;

import de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentPersistenceImpl;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class EntertainmentManagerPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$entertainmentmanager$persistence$EntertainmentManagerPersistableFactory;

    EntertainmentManagerPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 1: {
                return new EntertainmentPersistenceImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module EntertainmentManager").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 1: {
                EntertainmentPersistenceImpl entertainmentPersistenceImpl = new EntertainmentPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(entertainmentPersistenceImpl).finish();
                handlerFactory.createUserHandler(entertainmentPersistenceImpl).finish();
                return entertainmentPersistenceImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module EntertainmentManager").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$entertainmentmanager$persistence$EntertainmentManagerPersistableFactory == null ? (class$de$vw$mib$asl$entertainmentmanager$persistence$EntertainmentManagerPersistableFactory = EntertainmentManagerPersistableFactory.class$("de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentManagerPersistableFactory")) : class$de$vw$mib$asl$entertainmentmanager$persistence$EntertainmentManagerPersistableFactory).desiredAssertionStatus();
    }
}

