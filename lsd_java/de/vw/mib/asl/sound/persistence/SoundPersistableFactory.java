/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.sound.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.sound.persistence.SoundSettingsImpl;

class SoundPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$sound$persistence$SoundPersistableFactory;

    SoundPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 1: {
                return new SoundSettingsImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module Sound").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 1: {
                SoundSettingsImpl soundSettingsImpl = new SoundSettingsImpl(this.module);
                handlerFactory.createCommonHandler(soundSettingsImpl).finish();
                handlerFactory.createUserHandler(soundSettingsImpl).finish();
                return soundSettingsImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module Sound").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$sound$persistence$SoundPersistableFactory == null ? (class$de$vw$mib$asl$sound$persistence$SoundPersistableFactory = SoundPersistableFactory.class$("de.vw.mib.asl.sound.persistence.SoundPersistableFactory")) : class$de$vw$mib$asl$sound$persistence$SoundPersistableFactory).desiredAssertionStatus();
    }
}

