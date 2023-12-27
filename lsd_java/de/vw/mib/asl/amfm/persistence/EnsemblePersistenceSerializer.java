/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class EnsemblePersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$EnsemblePersistenceSerializer;

    EnsemblePersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 10;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((EnsemblePersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("EnsemblePersistence does not conatain any user specific data");
    }

    private byte[] serializeCommonData(EnsemblePersistence ensemblePersistence) {
        byte[] byArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(ensemblePersistence.getEnsEcc());
        dataOutputStream.writeInt(ensemblePersistence.getEnsId());
        dataOutputStream.writeBoolean(ensemblePersistence.getFrequencyLabel() == null);
        if (ensemblePersistence.getFrequencyLabel() != null) {
            byArray = ensemblePersistence.getFrequencyLabel().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeInt(ensemblePersistence.getFrequencyValue());
        dataOutputStream.writeBoolean(ensemblePersistence.getFullName() == null);
        if (ensemblePersistence.getFullName() != null) {
            byArray = ensemblePersistence.getFullName().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeBoolean(ensemblePersistence.isPotentiallyReceivable());
        dataOutputStream.writeBoolean(ensemblePersistence.getShortName() == null);
        if (ensemblePersistence.getShortName() != null) {
            byArray = ensemblePersistence.getShortName().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeBoolean(ensemblePersistence.isTp());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$EnsemblePersistenceSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$EnsemblePersistenceSerializer = EnsemblePersistenceSerializer.class$("de.vw.mib.asl.amfm.persistence.EnsemblePersistenceSerializer")) : class$de$vw$mib$asl$amfm$persistence$EnsemblePersistenceSerializer).desiredAssertionStatus();
    }
}

