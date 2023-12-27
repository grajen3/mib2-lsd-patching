/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.instrumentcluster.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.instrumentcluster.persistence.SDSSD_ASGCapabilities;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class SDSSD_ASGCapabilitiesSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$instrumentcluster$persistence$SDSSD_ASGCapabilitiesSerializer;

    SDSSD_ASGCapabilitiesSerializer(PersistableSerializerFactory persistableSerializerFactory) {
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
            return this.serializeCommonData((SDSSD_ASGCapabilities)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("SDSSD_ASGCapabilities does not conatain any user specific data");
    }

    private byte[] serializeCommonData(SDSSD_ASGCapabilities sDSSD_ASGCapabilities) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(sDSSD_ASGCapabilities.getInstrumentClusterDisplaySize());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$instrumentcluster$persistence$SDSSD_ASGCapabilitiesSerializer == null ? (class$de$vw$mib$asl$instrumentcluster$persistence$SDSSD_ASGCapabilitiesSerializer = SDSSD_ASGCapabilitiesSerializer.class$("de.vw.mib.asl.instrumentcluster.persistence.SDSSD_ASGCapabilitiesSerializer")) : class$de$vw$mib$asl$instrumentcluster$persistence$SDSSD_ASGCapabilitiesSerializer).desiredAssertionStatus();
    }
}

