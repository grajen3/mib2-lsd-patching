/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.instrumentcluster.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.instrumentcluster.persistence.AudioSD_ASGCapabilities;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class AudioSD_ASGCapabilitiesSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$instrumentcluster$persistence$AudioSD_ASGCapabilitiesSerializer;

    AudioSD_ASGCapabilitiesSerializer(PersistableSerializerFactory persistableSerializerFactory) {
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
            return this.serializeCommonData((AudioSD_ASGCapabilities)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("AudioSD_ASGCapabilities does not conatain any user specific data");
    }

    private byte[] serializeCommonData(AudioSD_ASGCapabilities audioSD_ASGCapabilities) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeBoolean(audioSD_ASGCapabilities.isUseDABLongLabel());
        dataOutputStream.writeBoolean(audioSD_ASGCapabilities.isUseSDARSLongLabel());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$instrumentcluster$persistence$AudioSD_ASGCapabilitiesSerializer == null ? (class$de$vw$mib$asl$instrumentcluster$persistence$AudioSD_ASGCapabilitiesSerializer = AudioSD_ASGCapabilitiesSerializer.class$("de.vw.mib.asl.instrumentcluster.persistence.AudioSD_ASGCapabilitiesSerializer")) : class$de$vw$mib$asl$instrumentcluster$persistence$AudioSD_ASGCapabilitiesSerializer).desiredAssertionStatus();
    }
}

