/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.media.persistence.PersistedListEntrySerializer;
import de.vw.mib.asl.media.persistence.PersistedSelectionSerializer;
import de.vw.mib.asl.media.persistence.PlayerPersistenceSerializer;
import de.vw.mib.asl.media.persistence.SourcesPersistenceSerializer;

class MediaSerializerFactory
implements PersistableSerializerFactory {
    MediaSerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 6: {
                return new SourcesPersistenceSerializer(this);
            }
            case 7: {
                return new PlayerPersistenceSerializer(this);
            }
            case 8: {
                return new PersistedSelectionSerializer(this);
            }
            case 9: {
                return new PersistedListEntrySerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module Media");
    }
}

