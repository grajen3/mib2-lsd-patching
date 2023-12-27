/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.TADConfiguration;

public class TADConfigurationSerializer {
    public static void putOptionalTADConfiguration(ISerializer iSerializer, TADConfiguration tADConfiguration) {
        boolean bl = tADConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = tADConfiguration.getRollAngleMaxScale();
            iSerializer.putInt32(n);
            int n2 = tADConfiguration.getRollAngleStartSoftWarning();
            iSerializer.putInt32(n2);
            int n3 = tADConfiguration.getRollAngleStartHardWarning();
            iSerializer.putInt32(n3);
            int n4 = tADConfiguration.getPitchAngleMaxScale();
            iSerializer.putInt32(n4);
            int n5 = tADConfiguration.getPitchAngleStartSoftWarning();
            iSerializer.putInt32(n5);
            int n6 = tADConfiguration.getPitchAngleStartHardWarning();
            iSerializer.putInt32(n6);
            boolean bl2 = tADConfiguration.isRollAngleInstallation();
            iSerializer.putBool(bl2);
            boolean bl3 = tADConfiguration.isPitchAngleInstallation();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalTADConfigurationVarArray(ISerializer iSerializer, TADConfiguration[] tADConfigurationArray) {
        boolean bl = tADConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tADConfigurationArray.length);
            for (int i2 = 0; i2 < tADConfigurationArray.length; ++i2) {
                TADConfigurationSerializer.putOptionalTADConfiguration(iSerializer, tADConfigurationArray[i2]);
            }
        }
    }

    public static TADConfiguration getOptionalTADConfiguration(IDeserializer iDeserializer) {
        TADConfiguration tADConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            tADConfiguration = new TADConfiguration();
            tADConfiguration.rollAngleMaxScale = n6 = iDeserializer.getInt32();
            tADConfiguration.rollAngleStartSoftWarning = n5 = iDeserializer.getInt32();
            tADConfiguration.rollAngleStartHardWarning = n4 = iDeserializer.getInt32();
            tADConfiguration.pitchAngleMaxScale = n3 = iDeserializer.getInt32();
            tADConfiguration.pitchAngleStartSoftWarning = n2 = iDeserializer.getInt32();
            tADConfiguration.pitchAngleStartHardWarning = n = iDeserializer.getInt32();
            tADConfiguration.rollAngleInstallation = bl3 = iDeserializer.getBool();
            tADConfiguration.pitchAngleInstallation = bl2 = iDeserializer.getBool();
        }
        return tADConfiguration;
    }

    public static TADConfiguration[] getOptionalTADConfigurationVarArray(IDeserializer iDeserializer) {
        TADConfiguration[] tADConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tADConfigurationArray = new TADConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tADConfigurationArray[i2] = TADConfigurationSerializer.getOptionalTADConfiguration(iDeserializer);
            }
        }
        return tADConfigurationArray;
    }
}

