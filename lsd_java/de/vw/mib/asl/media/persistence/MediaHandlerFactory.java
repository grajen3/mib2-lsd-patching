/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.media.persistence.PersistedListEntry;
import de.vw.mib.asl.media.persistence.PersistedListEntryHandler;
import de.vw.mib.asl.media.persistence.PersistedSelection;
import de.vw.mib.asl.media.persistence.PersistedSelectionHandler;
import de.vw.mib.asl.media.persistence.PlayerPersistence;
import de.vw.mib.asl.media.persistence.PlayerPersistenceHandler;
import de.vw.mib.asl.media.persistence.PlayerPersistenceUserHandler;
import de.vw.mib.asl.media.persistence.SourcesPersistence;
import de.vw.mib.asl.media.persistence.SourcesPersistenceHandler;
import de.vw.mib.asl.media.persistence.SourcesPersistenceUserHandler;
import de.vw.mib.log4mib.Logger;

class MediaHandlerFactory
implements HandlerFactory {
    private final Logger logger;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$media$persistence$MediaHandlerFactory;

    MediaHandlerFactory(Logger logger, PersistenceModule persistenceModule) {
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
            case 6: {
                return new SourcesPersistenceHandler((SourcesPersistence)persistable, this.logger, this.module);
            }
            case 7: {
                return new PlayerPersistenceHandler((PlayerPersistence)persistable, this.logger, this.module);
            }
            case 8: {
                return new PersistedSelectionHandler((PersistedSelection)persistable, this.logger, this.module);
            }
            case 9: {
                return new PersistedListEntryHandler((PersistedListEntry)persistable, this.logger, this.module);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("The persistable with id '").append(persistable.getId()).append("' is unknown for the persistence module 'Media'").toString());
    }

    @Override
    public PersistenceDataHandler createUserHandler(Persistable persistable) {
        if (persistable == null) {
            throw new IllegalArgumentException("Cannot create PersistenceDataHandler for null persistable.");
        }
        switch (persistable.getId()) {
            case 6: {
                return new SourcesPersistenceUserHandler((SourcesPersistence)persistable, this.logger, this.module);
            }
            case 7: {
                return new PlayerPersistenceUserHandler((PlayerPersistence)persistable, this.logger, this.module);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("The persistable with id '").append(persistable.getId()).append("' is unknown for the persistence module 'Media'").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$media$persistence$MediaHandlerFactory == null ? (class$de$vw$mib$asl$media$persistence$MediaHandlerFactory = MediaHandlerFactory.class$("de.vw.mib.asl.media.persistence.MediaHandlerFactory")) : class$de$vw$mib$asl$media$persistence$MediaHandlerFactory).desiredAssertionStatus();
    }
}

