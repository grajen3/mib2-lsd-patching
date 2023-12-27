/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.entertainmentmanager.persistence;

import de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentPersistenceSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;

class EntertainmentManagerSerializerFactory
implements PersistableSerializerFactory {
    EntertainmentManagerSerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 1: {
                return new EntertainmentPersistenceSerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module EntertainmentManager");
    }
}

