/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.systemcommon.persistence.AbtFeaturesSerializer;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonSerializer;
import de.vw.mib.asl.systemcommon.persistence.UnitsSerializer;

class SystemCommonSerializerFactory
implements PersistableSerializerFactory {
    SystemCommonSerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 1: {
                return new SystemCommonSerializer(this);
            }
            case 3: {
                return new UnitsSerializer(this);
            }
            case 2: {
                return new AbtFeaturesSerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module SystemCommon");
    }
}

