/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.media.persistence.PlayerPersistence;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;

class PlayerPersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$media$persistence$PlayerPersistenceSerializer;

    PlayerPersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 7;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((PlayerPersistence)persistable);
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
            return this.serializeUserSpecificData((PlayerPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    private byte[] serializeCommonData(PlayerPersistence playerPersistence) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeBoolean(playerPersistence.getParentalManagementPin() == null);
        if (playerPersistence.getParentalManagementPin() != null) {
            byte[] byArray = playerPersistence.getParentalManagementPin().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeInt(playerPersistence.getParentalManagementLevel());
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] serializeUserSpecificData(PlayerPersistence playerPersistence) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeBoolean(playerPersistence.isIncludeSubfolder());
        dataOutputStream.writeInt(playerPersistence.getVideoFormat());
        dataOutputStream.writeInt(playerPersistence.getSelections().size());
        Iterator iterator = playerPersistence.getSelections().entrySet().iterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = intObjectMap$Entry.getKey();
            Persistable persistable = (Persistable)intObjectMap$Entry.getValue();
            dataOutputStream.writeInt(n);
            dataOutputStream.writeBoolean(persistable == null);
            if (persistable == null) continue;
            PersistableSerializer persistableSerializer = this.factory.createSerializer(8);
            dataOutputStream.write(persistableSerializer.serializeCommonData(persistable));
        }
        dataOutputStream.writeBoolean(playerPersistence.isVideoMaximized());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$media$persistence$PlayerPersistenceSerializer == null ? (class$de$vw$mib$asl$media$persistence$PlayerPersistenceSerializer = PlayerPersistenceSerializer.class$("de.vw.mib.asl.media.persistence.PlayerPersistenceSerializer")) : class$de$vw$mib$asl$media$persistence$PlayerPersistenceSerializer).desiredAssertionStatus();
    }
}

