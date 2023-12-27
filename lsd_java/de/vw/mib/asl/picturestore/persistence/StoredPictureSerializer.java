/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.picturestore.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.picturestore.persistence.StoredPicture;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class StoredPictureSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$picturestore$persistence$StoredPictureSerializer;

    StoredPictureSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 1;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((StoredPicture)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("StoredPicture does not conatain any user specific data");
    }

    private byte[] serializeCommonData(StoredPicture storedPicture) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(storedPicture.getIdentification());
        dataOutputStream.writeBoolean(storedPicture.getUrl() == null);
        if (storedPicture.getUrl() != null) {
            byte[] byArray = storedPicture.getUrl().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeInt(storedPicture.getBitfieldOfUsers());
        dataOutputStream.writeInt(storedPicture.getCtxId());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$picturestore$persistence$StoredPictureSerializer == null ? (class$de$vw$mib$asl$picturestore$persistence$StoredPictureSerializer = StoredPictureSerializer.class$("de.vw.mib.asl.picturestore.persistence.StoredPictureSerializer")) : class$de$vw$mib$asl$picturestore$persistence$StoredPictureSerializer).desiredAssertionStatus();
    }
}

