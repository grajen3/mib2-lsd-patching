/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.gridmenu.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.gridmenu.persistence.GridMenuImpl;

class GridMenuPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$gridmenu$persistence$GridMenuPersistableFactory;

    GridMenuPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 2: {
                return new GridMenuImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module GridMenu").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 2: {
                GridMenuImpl gridMenuImpl = new GridMenuImpl(this.module);
                handlerFactory.createCommonHandler(gridMenuImpl).finish();
                handlerFactory.createUserHandler(gridMenuImpl).finish();
                return gridMenuImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module GridMenu").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$gridmenu$persistence$GridMenuPersistableFactory == null ? (class$de$vw$mib$asl$gridmenu$persistence$GridMenuPersistableFactory = GridMenuPersistableFactory.class$("de.vw.mib.asl.gridmenu.persistence.GridMenuPersistableFactory")) : class$de$vw$mib$asl$gridmenu$persistence$GridMenuPersistableFactory).desiredAssertionStatus();
    }
}

