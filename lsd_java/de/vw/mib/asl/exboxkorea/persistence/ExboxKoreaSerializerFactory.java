/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.exboxkorea.persistence;

import de.vw.mib.asl.exboxkorea.persistence.ExboxKoreaSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;

class ExboxKoreaSerializerFactory
implements PersistableSerializerFactory {
    ExboxKoreaSerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 1: {
                return new ExboxKoreaSerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module ExboxKorea");
    }
}

