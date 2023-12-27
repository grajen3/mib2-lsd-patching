/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navi.persistence;

import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.navi.persistence.NavigationSerializer;

class NaviSerializerFactory
implements PersistableSerializerFactory {
    NaviSerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 1: {
                return new NavigationSerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module Navi");
    }
}

