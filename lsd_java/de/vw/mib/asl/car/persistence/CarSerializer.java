/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.car.persistence;

import de.vw.mib.asl.car.persistence.Car;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class CarSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$car$persistence$CarSerializer;

    CarSerializer(PersistableSerializerFactory persistableSerializerFactory) {
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
            return this.serializeCommonData((Car)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("Car does not conatain any user specific data");
    }

    private byte[] serializeCommonData(Car car) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeBoolean(car.isFrontWindowHeater());
        dataOutputStream.writeBoolean(car.isSteeringWheelheater());
        dataOutputStream.writeBoolean(car.isFifthCamera());
        dataOutputStream.writeBoolean(car.isHDC());
        dataOutputStream.writeBoolean(car.isAmbientLight());
        dataOutputStream.writeInt(car.getIntLightColor());
        dataOutputStream.writeBoolean(car.isPersonalization());
        dataOutputStream.writeBoolean(car.isTurboCharger());
        dataOutputStream.writeBoolean(car.isPowerInstrument());
        dataOutputStream.writeBoolean(car.isClimateSetupButton());
        dataOutputStream.writeInt(car.getRDKSystem());
        dataOutputStream.writeInt(car.getRDKLoadChange());
        dataOutputStream.writeInt(car.getSportLeftTube());
        dataOutputStream.writeInt(car.getSportMiddleTube());
        dataOutputStream.writeInt(car.getSportRightTube());
        dataOutputStream.writeInt(car.getOffroadLeftTube());
        dataOutputStream.writeInt(car.getOffroadMiddleTube());
        dataOutputStream.writeInt(car.getOffroadRightTube());
        dataOutputStream.writeBoolean(car.isTrailerModeRouteCalculation());
        dataOutputStream.writeBoolean(car.isButtonStartStopNoticeHighlighted());
        dataOutputStream.writeBoolean(car.getCarOffroad() == null);
        if (car.getCarOffroad() != null) {
            PersistableSerializer persistableSerializer = this.factory.createSerializer(2);
            dataOutputStream.write(persistableSerializer.serializeCommonData(car.getCarOffroad()));
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
        $assertionsDisabled = !(class$de$vw$mib$asl$car$persistence$CarSerializer == null ? (class$de$vw$mib$asl$car$persistence$CarSerializer = CarSerializer.class$("de.vw.mib.asl.car.persistence.CarSerializer")) : class$de$vw$mib$asl$car$persistence$CarSerializer).desiredAssertionStatus();
    }
}

