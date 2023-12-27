/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.carearly.persistence;

import de.vw.mib.asl.carearly.persistence.CarEarlySerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;

class CarEarlySerializerFactory
implements PersistableSerializerFactory {
    CarEarlySerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 1: {
                return new CarEarlySerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module CarEarly");
    }
}

