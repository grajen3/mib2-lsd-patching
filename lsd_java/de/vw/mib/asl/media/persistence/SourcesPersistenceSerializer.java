/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.media.persistence.SourcesPersistence;
import de.vw.mib.collections.ints.IntIntMap$Entry;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Map$Entry;

class SourcesPersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$media$persistence$SourcesPersistenceSerializer;

    SourcesPersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 6;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((SourcesPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeUserSpecificData((SourcesPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    private byte[] serializeCommonData(SourcesPersistence sourcesPersistence) {
        int n;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(sourcesPersistence.getMediaType());
        dataOutputStream.writeInt(sourcesPersistence.getPartitionLSM().size());
        Object object = sourcesPersistence.getPartitionLSM().entrySet().iterator();
        while (object.hasNext()) {
            IntIntMap$Entry intIntMap$Entry = (IntIntMap$Entry)object.next();
            n = intIntMap$Entry.getKey();
            int n2 = intIntMap$Entry.getValue();
            dataOutputStream.writeInt(n);
            dataOutputStream.writeInt(n2);
        }
        dataOutputStream.writeInt(sourcesPersistence.getDatabaseFullReported().size());
        object = sourcesPersistence.getDatabaseFullReported().iterator();
        while (object.hasNext()) {
            int n3 = object.next();
            dataOutputStream.writeInt(n3);
        }
        dataOutputStream.writeInt(sourcesPersistence.getDeflowered().size());
        object = sourcesPersistence.getDeflowered().entrySet().iterator();
        while (object.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)object.next();
            n = (Integer)map$Entry.getKey();
            String string = (String)map$Entry.getValue();
            dataOutputStream.writeInt(n);
            dataOutputStream.writeBoolean(string == null);
            if (string == null) continue;
            byte[] byArray = string.getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] serializeUserSpecificData(SourcesPersistence sourcesPersistence) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(sourcesPersistence.getObjectId());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$media$persistence$SourcesPersistenceSerializer == null ? (class$de$vw$mib$asl$media$persistence$SourcesPersistenceSerializer = SourcesPersistenceSerializer.class$("de.vw.mib.asl.media.persistence.SourcesPersistenceSerializer")) : class$de$vw$mib$asl$media$persistence$SourcesPersistenceSerializer).desiredAssertionStatus();
    }
}

