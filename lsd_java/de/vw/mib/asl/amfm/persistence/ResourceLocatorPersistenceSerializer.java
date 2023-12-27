/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class ResourceLocatorPersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$ResourceLocatorPersistenceSerializer;

    ResourceLocatorPersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 4;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((ResourceLocatorPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("ResourceLocatorPersistence does not conatain any user specific data");
    }

    private byte[] serializeCommonData(ResourceLocatorPersistence resourceLocatorPersistence) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(resourceLocatorPersistence.getIdentification());
        dataOutputStream.writeBoolean(resourceLocatorPersistence.getUrl() == null);
        if (resourceLocatorPersistence.getUrl() != null) {
            byte[] byArray = resourceLocatorPersistence.getUrl().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$ResourceLocatorPersistenceSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$ResourceLocatorPersistenceSerializer = ResourceLocatorPersistenceSerializer.class$("de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistenceSerializer")) : class$de$vw$mib$asl$amfm$persistence$ResourceLocatorPersistenceSerializer).desiredAssertionStatus();
    }
}

