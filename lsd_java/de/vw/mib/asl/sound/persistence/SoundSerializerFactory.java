/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.sound.persistence;

import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.sound.persistence.SoundSettingsSerializer;

class SoundSerializerFactory
implements PersistableSerializerFactory {
    SoundSerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 1: {
                return new SoundSettingsSerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module Sound");
    }
}

