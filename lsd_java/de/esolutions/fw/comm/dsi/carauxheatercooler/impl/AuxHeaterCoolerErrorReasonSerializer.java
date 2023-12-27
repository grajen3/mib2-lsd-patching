/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;

public class AuxHeaterCoolerErrorReasonSerializer {
    public static void putOptionalAuxHeaterCoolerErrorReason(ISerializer iSerializer, AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        boolean bl = auxHeaterCoolerErrorReason == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = auxHeaterCoolerErrorReason.isBatteryLow();
            iSerializer.putBool(bl2);
            boolean bl3 = auxHeaterCoolerErrorReason.isFuelLow();
            iSerializer.putBool(bl3);
            boolean bl4 = auxHeaterCoolerErrorReason.isHeaterDefect();
            iSerializer.putBool(bl4);
            boolean bl5 = auxHeaterCoolerErrorReason.isMaxOperationTime();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalAuxHeaterCoolerErrorReasonVarArray(ISerializer iSerializer, AuxHeaterCoolerErrorReason[] auxHeaterCoolerErrorReasonArray) {
        boolean bl = auxHeaterCoolerErrorReasonArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(auxHeaterCoolerErrorReasonArray.length);
            for (int i2 = 0; i2 < auxHeaterCoolerErrorReasonArray.length; ++i2) {
                AuxHeaterCoolerErrorReasonSerializer.putOptionalAuxHeaterCoolerErrorReason(iSerializer, auxHeaterCoolerErrorReasonArray[i2]);
            }
        }
    }

    public static AuxHeaterCoolerErrorReason getOptionalAuxHeaterCoolerErrorReason(IDeserializer iDeserializer) {
        AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            auxHeaterCoolerErrorReason = new AuxHeaterCoolerErrorReason();
            auxHeaterCoolerErrorReason.batteryLow = bl5 = iDeserializer.getBool();
            auxHeaterCoolerErrorReason.fuelLow = bl4 = iDeserializer.getBool();
            auxHeaterCoolerErrorReason.heaterDefect = bl3 = iDeserializer.getBool();
            auxHeaterCoolerErrorReason.maxOperationTime = bl2 = iDeserializer.getBool();
        }
        return auxHeaterCoolerErrorReason;
    }

    public static AuxHeaterCoolerErrorReason[] getOptionalAuxHeaterCoolerErrorReasonVarArray(IDeserializer iDeserializer) {
        AuxHeaterCoolerErrorReason[] auxHeaterCoolerErrorReasonArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            auxHeaterCoolerErrorReasonArray = new AuxHeaterCoolerErrorReason[n];
            for (int i2 = 0; i2 < n; ++i2) {
                auxHeaterCoolerErrorReasonArray[i2] = AuxHeaterCoolerErrorReasonSerializer.getOptionalAuxHeaterCoolerErrorReason(iDeserializer);
            }
        }
        return auxHeaterCoolerErrorReasonArray;
    }
}

