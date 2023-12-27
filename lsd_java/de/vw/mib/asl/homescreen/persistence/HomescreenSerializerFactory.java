/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.homescreen.persistence;

import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.homescreen.persistence.HomescreenInfoSerializer;
import de.vw.mib.asl.homescreen.persistence.TileContentSerializer;

class HomescreenSerializerFactory
implements PersistableSerializerFactory {
    HomescreenSerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 1: {
                return new HomescreenInfoSerializer(this);
            }
            case 2: {
                return new TileContentSerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module Homescreen");
    }
}

