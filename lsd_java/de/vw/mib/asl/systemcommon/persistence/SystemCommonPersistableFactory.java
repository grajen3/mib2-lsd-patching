/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.systemcommon.persistence.AbtFeaturesImpl;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonImpl;
import de.vw.mib.asl.systemcommon.persistence.UnitsImpl;

class SystemCommonPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$systemcommon$persistence$SystemCommonPersistableFactory;

    SystemCommonPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 1: {
                return new SystemCommonImpl(this.module);
            }
            case 3: {
                return new UnitsImpl(this.module);
            }
            case 2: {
                return new AbtFeaturesImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module SystemCommon").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 1: {
                SystemCommonImpl systemCommonImpl = new SystemCommonImpl(this.module);
                handlerFactory.createCommonHandler(systemCommonImpl).finish();
                handlerFactory.createUserHandler(systemCommonImpl).finish();
                return systemCommonImpl;
            }
            case 3: {
                UnitsImpl unitsImpl = new UnitsImpl(this.module);
                handlerFactory.createCommonHandler(unitsImpl).finish();
                handlerFactory.createUserHandler(unitsImpl).finish();
                return unitsImpl;
            }
            case 2: {
                AbtFeaturesImpl abtFeaturesImpl = new AbtFeaturesImpl(this.module);
                handlerFactory.createCommonHandler(abtFeaturesImpl).finish();
                return abtFeaturesImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module SystemCommon").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$systemcommon$persistence$SystemCommonPersistableFactory == null ? (class$de$vw$mib$asl$systemcommon$persistence$SystemCommonPersistableFactory = SystemCommonPersistableFactory.class$("de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistableFactory")) : class$de$vw$mib$asl$systemcommon$persistence$SystemCommonPersistableFactory).desiredAssertionStatus();
    }
}

