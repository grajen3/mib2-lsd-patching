/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.picturestore.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.picturestore.persistence.PictureStore;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;

class PictureStoreSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$picturestore$persistence$PictureStoreSerializer;

    PictureStoreSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 2;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((PictureStore)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("PictureStore does not conatain any user specific data");
    }

    private byte[] serializeCommonData(PictureStore pictureStore) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(pictureStore.getPictures().size());
        Iterator iterator = pictureStore.getPictures().iterator();
        while (iterator.hasNext()) {
            Persistable persistable = (Persistable)iterator.next();
            dataOutputStream.writeBoolean(persistable == null);
            if (persistable == null) continue;
            PersistableSerializer persistableSerializer = this.factory.createSerializer(1);
            dataOutputStream.write(persistableSerializer.serializeCommonData(persistable));
        }
        return byteArrayOutputStream.toByteArray();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$picturestore$persistence$PictureStoreSerializer == null ? (class$de$vw$mib$asl$picturestore$persistence$PictureStoreSerializer = PictureStoreSerializer.class$("de.vw.mib.asl.picturestore.persistence.PictureStoreSerializer")) : class$de$vw$mib$asl$picturestore$persistence$PictureStoreSerializer).desiredAssertionStatus();
    }
}

