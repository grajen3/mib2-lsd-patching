/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.car.persistence;

import de.vw.mib.asl.car.persistence.CarOffroad;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class CarOffroadSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$car$persistence$CarOffroadSerializer;

    CarOffroadSerializer(PersistableSerializerFactory persistableSerializerFactory) {
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
            return this.serializeCommonData((CarOffroad)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("CarOffroad does not conatain any user specific data");
    }

    private byte[] serializeCommonData(CarOffroad carOffroad) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(carOffroad.getOffroadLeftTubeNonNav());
        dataOutputStream.writeInt(carOffroad.getOffroadMiddleTubeNonNav());
        dataOutputStream.writeInt(carOffroad.getOffroadRightTubeNonNav());
        dataOutputStream.writeInt(carOffroad.getOffroadLeftTubeNav());
        dataOutputStream.writeInt(carOffroad.getOffroadMiddleTubeNav());
        dataOutputStream.writeInt(carOffroad.getOffroadRightTubeNav());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$car$persistence$CarOffroadSerializer == null ? (class$de$vw$mib$asl$car$persistence$CarOffroadSerializer = CarOffroadSerializer.class$("de.vw.mib.asl.car.persistence.CarOffroadSerializer")) : class$de$vw$mib$asl$car$persistence$CarOffroadSerializer).desiredAssertionStatus();
    }
}

