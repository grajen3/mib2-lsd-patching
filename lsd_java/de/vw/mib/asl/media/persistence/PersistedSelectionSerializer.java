/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.media.persistence.PersistedSelection;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class PersistedSelectionSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$media$persistence$PersistedSelectionSerializer;

    PersistedSelectionSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 8;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((PersistedSelection)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("PersistedSelection does not conatain any user specific data");
    }

    private byte[] serializeCommonData(PersistedSelection persistedSelection) {
        Object object;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(persistedSelection.getPlaymode());
        dataOutputStream.writeBoolean(persistedSelection.getUniqeMediaId() == null);
        if (persistedSelection.getUniqeMediaId() != null) {
            object = persistedSelection.getUniqeMediaId().getBytes();
            dataOutputStream.writeInt(((byte[])object).length);
            dataOutputStream.write((byte[])object);
        }
        dataOutputStream.writeInt(persistedSelection.getInstanceId());
        dataOutputStream.writeBoolean(persistedSelection.isCompositeSelection());
        dataOutputStream.writeInt(persistedSelection.getSelectionScope());
        dataOutputStream.writeInt(persistedSelection.getSelectionPath().size());
        object = persistedSelection.getSelectionPath().iterator();
        while (object.hasNext()) {
            Persistable persistable = (Persistable)object.next();
            dataOutputStream.writeBoolean(persistable == null);
            if (persistable == null) continue;
            PersistableSerializer persistableSerializer = this.factory.createSerializer(9);
            dataOutputStream.write(persistableSerializer.serializeCommonData(persistable));
        }
        dataOutputStream.writeBoolean(persistedSelection.isRecursive());
        dataOutputStream.writeBoolean(persistedSelection.isSelected());
        dataOutputStream.writeInt(persistedSelection.getSelectionResult());
        dataOutputStream.writeInt(persistedSelection.getSelectionState());
        dataOutputStream.writeLong(persistedSelection.getSizeAvailable());
        dataOutputStream.writeLong(persistedSelection.getSizeSelected());
        dataOutputStream.writeLong(persistedSelection.getEntriesAvailable());
        dataOutputStream.writeLong(persistedSelection.getEntriesSelected());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$media$persistence$PersistedSelectionSerializer == null ? (class$de$vw$mib$asl$media$persistence$PersistedSelectionSerializer = PersistedSelectionSerializer.class$("de.vw.mib.asl.media.persistence.PersistedSelectionSerializer")) : class$de$vw$mib$asl$media$persistence$PersistedSelectionSerializer).desiredAssertionStatus();
    }
}

