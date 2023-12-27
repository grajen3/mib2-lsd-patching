/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdlprogress.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public class GeneralProgressSerializer {
    public static void putOptionalGeneralProgress(ISerializer iSerializer, GeneralProgress generalProgress) {
        boolean bl = generalProgress == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = generalProgress.getCurrentStage();
            iSerializer.putInt16(s);
            short s2 = generalProgress.getMaxStage();
            iSerializer.putInt16(s2);
            short s3 = generalProgress.getFinishedDevicesWithoutError();
            iSerializer.putInt16(s3);
            short s4 = generalProgress.getUpdatingDevices();
            iSerializer.putInt16(s4);
            short s5 = generalProgress.getUnavailableDevices();
            iSerializer.putInt16(s5);
            short s6 = generalProgress.getFinishedDevicesWithError();
            iSerializer.putInt16(s6);
            short s7 = generalProgress.getActiveDevices();
            iSerializer.putInt16(s7);
        }
    }

    public static void putOptionalGeneralProgressVarArray(ISerializer iSerializer, GeneralProgress[] generalProgressArray) {
        boolean bl = generalProgressArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(generalProgressArray.length);
            for (int i2 = 0; i2 < generalProgressArray.length; ++i2) {
                GeneralProgressSerializer.putOptionalGeneralProgress(iSerializer, generalProgressArray[i2]);
            }
        }
    }

    public static GeneralProgress getOptionalGeneralProgress(IDeserializer iDeserializer) {
        GeneralProgress generalProgress = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            short s4;
            short s5;
            short s6;
            short s7;
            generalProgress = new GeneralProgress();
            generalProgress.currentStage = s7 = iDeserializer.getInt16();
            generalProgress.maxStage = s6 = iDeserializer.getInt16();
            generalProgress.finishedDevicesWithoutError = s5 = iDeserializer.getInt16();
            generalProgress.updatingDevices = s4 = iDeserializer.getInt16();
            generalProgress.unavailableDevices = s3 = iDeserializer.getInt16();
            generalProgress.finishedDevicesWithError = s2 = iDeserializer.getInt16();
            generalProgress.activeDevices = s = iDeserializer.getInt16();
        }
        return generalProgress;
    }

    public static GeneralProgress[] getOptionalGeneralProgressVarArray(IDeserializer iDeserializer) {
        GeneralProgress[] generalProgressArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            generalProgressArray = new GeneralProgress[n];
            for (int i2 = 0; i2 < n; ++i2) {
                generalProgressArray[i2] = GeneralProgressSerializer.getOptionalGeneralProgress(iDeserializer);
            }
        }
        return generalProgressArray;
    }
}

