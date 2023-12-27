/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.picturestore.persistence;

import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.picturestore.persistence.PictureStoreSerializer;
import de.vw.mib.asl.picturestore.persistence.StoredPictureSerializer;

class PictureStoreSerializerFactory
implements PersistableSerializerFactory {
    PictureStoreSerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 1: {
                return new StoredPictureSerializer(this);
            }
            case 2: {
                return new PictureStoreSerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module PictureStore");
    }
}

