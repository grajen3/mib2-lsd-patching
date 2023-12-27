/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class ServicePersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$ServicePersistenceSerializer;

    ServicePersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 11;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((ServicePersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("ServicePersistence does not conatain any user specific data");
    }

    private byte[] serializeCommonData(ServicePersistence servicePersistence) {
        Object object;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(servicePersistence.getEnsEcc());
        dataOutputStream.writeInt(servicePersistence.getEnsId());
        dataOutputStream.writeLong(servicePersistence.getServiceId());
        dataOutputStream.writeBoolean(servicePersistence.getFullName() == null);
        if (servicePersistence.getFullName() != null) {
            object = servicePersistence.getFullName().getBytes();
            dataOutputStream.writeInt(((byte[])object).length);
            dataOutputStream.write((byte[])object);
        }
        dataOutputStream.writeBoolean(servicePersistence.getShortName() == null);
        if (servicePersistence.getShortName() != null) {
            object = servicePersistence.getShortName().getBytes();
            dataOutputStream.writeInt(((byte[])object).length);
            dataOutputStream.write((byte[])object);
        }
        dataOutputStream.writeInt(servicePersistence.getPtyCodes().size());
        object = servicePersistence.getPtyCodes().iterator();
        while (object.hasNext()) {
            byte by = (Byte)object.next();
            dataOutputStream.writeByte(by);
        }
        dataOutputStream.writeBoolean(servicePersistence.isTp());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$ServicePersistenceSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$ServicePersistenceSerializer = ServicePersistenceSerializer.class$("de.vw.mib.asl.amfm.persistence.ServicePersistenceSerializer")) : class$de$vw$mib$asl$amfm$persistence$ServicePersistenceSerializer).desiredAssertionStatus();
    }
}

