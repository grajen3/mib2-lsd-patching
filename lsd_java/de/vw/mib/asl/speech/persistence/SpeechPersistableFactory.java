/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.speech.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.speech.persistence.SpeechSettingsPersistableImpl;

class SpeechPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$speech$persistence$SpeechPersistableFactory;

    SpeechPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 2: {
                return new SpeechSettingsPersistableImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module Speech").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 2: {
                SpeechSettingsPersistableImpl speechSettingsPersistableImpl = new SpeechSettingsPersistableImpl(this.module);
                handlerFactory.createCommonHandler(speechSettingsPersistableImpl).finish();
                handlerFactory.createUserHandler(speechSettingsPersistableImpl).finish();
                return speechSettingsPersistableImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module Speech").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$speech$persistence$SpeechPersistableFactory == null ? (class$de$vw$mib$asl$speech$persistence$SpeechPersistableFactory = SpeechPersistableFactory.class$("de.vw.mib.asl.speech.persistence.SpeechPersistableFactory")) : class$de$vw$mib$asl$speech$persistence$SpeechPersistableFactory).desiredAssertionStatus();
    }
}

