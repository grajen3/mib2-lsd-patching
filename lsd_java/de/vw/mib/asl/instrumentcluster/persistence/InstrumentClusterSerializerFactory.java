/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.instrumentcluster.persistence;

import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.instrumentcluster.persistence.AudioSD_ASGCapabilitiesSerializer;
import de.vw.mib.asl.instrumentcluster.persistence.SDSSD_ASGCapabilitiesSerializer;

class InstrumentClusterSerializerFactory
implements PersistableSerializerFactory {
    InstrumentClusterSerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 1: {
                return new AudioSD_ASGCapabilitiesSerializer(this);
            }
            case 2: {
                return new SDSSD_ASGCapabilitiesSerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module InstrumentCluster");
    }
}

