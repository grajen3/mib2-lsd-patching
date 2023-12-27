/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.media.persistence.PersistedListEntryImpl;
import de.vw.mib.asl.media.persistence.PersistedSelectionImpl;
import de.vw.mib.asl.media.persistence.PlayerPersistenceImpl;
import de.vw.mib.asl.media.persistence.SourcesPersistenceImpl;

class MediaPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$media$persistence$MediaPersistableFactory;

    MediaPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 6: {
                return new SourcesPersistenceImpl(this.module);
            }
            case 7: {
                return new PlayerPersistenceImpl(this.module);
            }
            case 8: {
                return new PersistedSelectionImpl(this.module);
            }
            case 9: {
                return new PersistedListEntryImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module Media").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 6: {
                SourcesPersistenceImpl sourcesPersistenceImpl = new SourcesPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(sourcesPersistenceImpl).finish();
                handlerFactory.createUserHandler(sourcesPersistenceImpl).finish();
                return sourcesPersistenceImpl;
            }
            case 7: {
                PlayerPersistenceImpl playerPersistenceImpl = new PlayerPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(playerPersistenceImpl).finish();
                handlerFactory.createUserHandler(playerPersistenceImpl).finish();
                return playerPersistenceImpl;
            }
            case 8: {
                PersistedSelectionImpl persistedSelectionImpl = new PersistedSelectionImpl(this.module);
                handlerFactory.createCommonHandler(persistedSelectionImpl).finish();
                return persistedSelectionImpl;
            }
            case 9: {
                PersistedListEntryImpl persistedListEntryImpl = new PersistedListEntryImpl(this.module);
                handlerFactory.createCommonHandler(persistedListEntryImpl).finish();
                return persistedListEntryImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module Media").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$media$persistence$MediaPersistableFactory == null ? (class$de$vw$mib$asl$media$persistence$MediaPersistableFactory = MediaPersistableFactory.class$("de.vw.mib.asl.media.persistence.MediaPersistableFactory")) : class$de$vw$mib$asl$media$persistence$MediaPersistableFactory).desiredAssertionStatus();
    }
}

