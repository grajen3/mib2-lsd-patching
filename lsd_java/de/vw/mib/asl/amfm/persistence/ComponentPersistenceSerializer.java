/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.ComponentPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class ComponentPersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$ComponentPersistenceSerializer;

    ComponentPersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 12;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((ComponentPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("ComponentPersistence does not conatain any user specific data");
    }

    private byte[] serializeCommonData(ComponentPersistence componentPersistence) {
        byte[] byArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(componentPersistence.getEnsId());
        dataOutputStream.writeInt(componentPersistence.getEnsEcc());
        dataOutputStream.writeLong(componentPersistence.getSid());
        dataOutputStream.writeInt(componentPersistence.getScidi());
        dataOutputStream.writeBoolean(componentPersistence.getFullName() == null);
        if (componentPersistence.getFullName() != null) {
            byArray = componentPersistence.getFullName().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeBoolean(componentPersistence.getShortName() == null);
        if (componentPersistence.getShortName() != null) {
            byArray = componentPersistence.getShortName().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeBoolean(componentPersistence.isPrimaryService());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$ComponentPersistenceSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$ComponentPersistenceSerializer = ComponentPersistenceSerializer.class$("de.vw.mib.asl.amfm.persistence.ComponentPersistenceSerializer")) : class$de$vw$mib$asl$amfm$persistence$ComponentPersistenceSerializer).desiredAssertionStatus();
    }
}

