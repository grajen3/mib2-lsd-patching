/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;

public class AuxHeaterCoolerTimerSerializer {
    public static void putOptionalAuxHeaterCoolerTimer(ISerializer iSerializer, AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        boolean bl = auxHeaterCoolerTimer == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = auxHeaterCoolerTimer.getHour();
            iSerializer.putInt16(s);
            short s2 = auxHeaterCoolerTimer.getMinute();
            iSerializer.putInt16(s2);
            short s3 = auxHeaterCoolerTimer.getSecond();
            iSerializer.putInt16(s3);
            short s4 = auxHeaterCoolerTimer.getYear();
            iSerializer.putInt16(s4);
            short s5 = auxHeaterCoolerTimer.getMonth();
            iSerializer.putInt16(s5);
            short s6 = auxHeaterCoolerTimer.getDay();
            iSerializer.putInt16(s6);
            short s7 = auxHeaterCoolerTimer.getDateMode();
            iSerializer.putInt16(s7);
        }
    }

    public static void putOptionalAuxHeaterCoolerTimerVarArray(ISerializer iSerializer, AuxHeaterCoolerTimer[] auxHeaterCoolerTimerArray) {
        boolean bl = auxHeaterCoolerTimerArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(auxHeaterCoolerTimerArray.length);
            for (int i2 = 0; i2 < auxHeaterCoolerTimerArray.length; ++i2) {
                AuxHeaterCoolerTimerSerializer.putOptionalAuxHeaterCoolerTimer(iSerializer, auxHeaterCoolerTimerArray[i2]);
            }
        }
    }

    public static AuxHeaterCoolerTimer getOptionalAuxHeaterCoolerTimer(IDeserializer iDeserializer) {
        AuxHeaterCoolerTimer auxHeaterCoolerTimer = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            short s4;
            short s5;
            short s6;
            short s7;
            auxHeaterCoolerTimer = new AuxHeaterCoolerTimer();
            auxHeaterCoolerTimer.hour = s7 = iDeserializer.getInt16();
            auxHeaterCoolerTimer.minute = s6 = iDeserializer.getInt16();
            auxHeaterCoolerTimer.second = s5 = iDeserializer.getInt16();
            auxHeaterCoolerTimer.year = s4 = iDeserializer.getInt16();
            auxHeaterCoolerTimer.month = s3 = iDeserializer.getInt16();
            auxHeaterCoolerTimer.day = s2 = iDeserializer.getInt16();
            auxHeaterCoolerTimer.dateMode = s = iDeserializer.getInt16();
        }
        return auxHeaterCoolerTimer;
    }

    public static AuxHeaterCoolerTimer[] getOptionalAuxHeaterCoolerTimerVarArray(IDeserializer iDeserializer) {
        AuxHeaterCoolerTimer[] auxHeaterCoolerTimerArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            auxHeaterCoolerTimerArray = new AuxHeaterCoolerTimer[n];
            for (int i2 = 0; i2 < n; ++i2) {
                auxHeaterCoolerTimerArray[i2] = AuxHeaterCoolerTimerSerializer.getOptionalAuxHeaterCoolerTimer(iDeserializer);
            }
        }
        return auxHeaterCoolerTimerArray;
    }
}

