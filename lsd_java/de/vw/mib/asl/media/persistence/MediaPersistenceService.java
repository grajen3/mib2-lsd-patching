/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.media.persistence.PersistedListEntry;
import de.vw.mib.asl.media.persistence.PersistedSelection;
import de.vw.mib.asl.media.persistence.PlayerPersistence;
import de.vw.mib.asl.media.persistence.SourcesPersistence;

public interface MediaPersistenceService
extends ModulePersistenceService {
    default public SourcesPersistence loadSourcesPersistence() {
    }

    default public PlayerPersistence loadPlayerPersistence() {
    }

    default public SourcesPersistence createSourcesPersistence() {
    }

    default public PlayerPersistence createPlayerPersistence() {
    }

    default public PersistedSelection createPersistedSelection() {
    }

    default public PersistedListEntry createPersistedListEntry() {
    }
}

