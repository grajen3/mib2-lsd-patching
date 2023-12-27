/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerMode;

public class AuxHeaterCoolerModeSerializer {
    public static void putOptionalAuxHeaterCoolerMode(ISerializer iSerializer, AuxHeaterCoolerMode auxHeaterCoolerMode) {
        boolean bl = auxHeaterCoolerMode == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = auxHeaterCoolerMode.getMode();
            iSerializer.putInt32(n);
            int n2 = auxHeaterCoolerMode.getState();
            iSerializer.putInt32(n2);
            int n3 = auxHeaterCoolerMode.getReason();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalAuxHeaterCoolerModeVarArray(ISerializer iSerializer, AuxHeaterCoolerMode[] auxHeaterCoolerModeArray) {
        boolean bl = auxHeaterCoolerModeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(auxHeaterCoolerModeArray.length);
            for (int i2 = 0; i2 < auxHeaterCoolerModeArray.length; ++i2) {
                AuxHeaterCoolerModeSerializer.putOptionalAuxHeaterCoolerMode(iSerializer, auxHeaterCoolerModeArray[i2]);
            }
        }
    }

    public static AuxHeaterCoolerMode getOptionalAuxHeaterCoolerMode(IDeserializer iDeserializer) {
        AuxHeaterCoolerMode auxHeaterCoolerMode = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            auxHeaterCoolerMode = new AuxHeaterCoolerMode();
            auxHeaterCoolerMode.mode = n3 = iDeserializer.getInt32();
            auxHeaterCoolerMode.state = n2 = iDeserializer.getInt32();
            auxHeaterCoolerMode.reason = n = iDeserializer.getInt32();
        }
        return auxHeaterCoolerMode;
    }

    public static AuxHeaterCoolerMode[] getOptionalAuxHeaterCoolerModeVarArray(IDeserializer iDeserializer) {
        AuxHeaterCoolerMode[] auxHeaterCoolerModeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            auxHeaterCoolerModeArray = new AuxHeaterCoolerMode[n];
            for (int i2 = 0; i2 < n; ++i2) {
                auxHeaterCoolerModeArray[i2] = AuxHeaterCoolerModeSerializer.getOptionalAuxHeaterCoolerMode(iDeserializer);
            }
        }
        return auxHeaterCoolerModeArray;
    }
}

