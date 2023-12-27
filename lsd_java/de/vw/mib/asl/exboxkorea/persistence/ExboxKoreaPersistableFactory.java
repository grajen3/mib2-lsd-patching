/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.exboxkorea.persistence;

import de.vw.mib.asl.exboxkorea.persistence.ExboxKoreaImpl;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class ExboxKoreaPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$exboxkorea$persistence$ExboxKoreaPersistableFactory;

    ExboxKoreaPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 1: {
                return new ExboxKoreaImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module ExboxKorea").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 1: {
                ExboxKoreaImpl exboxKoreaImpl = new ExboxKoreaImpl(this.module);
                handlerFactory.createCommonHandler(exboxKoreaImpl).finish();
                handlerFactory.createUserHandler(exboxKoreaImpl).finish();
                return exboxKoreaImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module ExboxKorea").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$exboxkorea$persistence$ExboxKoreaPersistableFactory == null ? (class$de$vw$mib$asl$exboxkorea$persistence$ExboxKoreaPersistableFactory = ExboxKoreaPersistableFactory.class$("de.vw.mib.asl.exboxkorea.persistence.ExboxKoreaPersistableFactory")) : class$de$vw$mib$asl$exboxkorea$persistence$ExboxKoreaPersistableFactory).desiredAssertionStatus();
    }
}

