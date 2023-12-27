/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.gridmenu.persistence;

import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.gridmenu.persistence.GridMenuSerializer;

class GridMenuSerializerFactory
implements PersistableSerializerFactory {
    GridMenuSerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 2: {
                return new GridMenuSerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module GridMenu");
    }
}

