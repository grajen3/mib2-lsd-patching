/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.car.persistence;

import de.vw.mib.asl.car.persistence.CarImpl;
import de.vw.mib.asl.car.persistence.CarOffroadImpl;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class CarPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$car$persistence$CarPersistableFactory;

    CarPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 1: {
                return new CarImpl(this.module);
            }
            case 2: {
                return new CarOffroadImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module Car").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 1: {
                CarImpl carImpl = new CarImpl(this.module);
                handlerFactory.createCommonHandler(carImpl).finish();
                return carImpl;
            }
            case 2: {
                CarOffroadImpl carOffroadImpl = new CarOffroadImpl(this.module);
                handlerFactory.createCommonHandler(carOffroadImpl).finish();
                return carOffroadImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module Car").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$car$persistence$CarPersistableFactory == null ? (class$de$vw$mib$asl$car$persistence$CarPersistableFactory = CarPersistableFactory.class$("de.vw.mib.asl.car.persistence.CarPersistableFactory")) : class$de$vw$mib$asl$car$persistence$CarPersistableFactory).desiredAssertionStatus();
    }
}

