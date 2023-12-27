/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.speech.persistence;

import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.speech.persistence.SpeechSettingsPersistableSerializer;

class SpeechSerializerFactory
implements PersistableSerializerFactory {
    SpeechSerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 2: {
                return new SpeechSettingsPersistableSerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module Speech");
    }
}

