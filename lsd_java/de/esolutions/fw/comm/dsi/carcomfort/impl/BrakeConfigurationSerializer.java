/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.BrakeConfiguration;

public class BrakeConfigurationSerializer {
    public static void putOptionalBrakeConfiguration(ISerializer iSerializer, BrakeConfiguration brakeConfiguration) {
        boolean bl = brakeConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = brakeConfiguration.isAutoHoldLastMode();
            iSerializer.putBool(bl2);
            boolean bl3 = brakeConfiguration.isAutoHoldOnOff();
            iSerializer.putBool(bl3);
            boolean bl4 = brakeConfiguration.isEscOff();
            iSerializer.putBool(bl4);
            boolean bl5 = brakeConfiguration.isEscSport();
            iSerializer.putBool(bl5);
            boolean bl6 = brakeConfiguration.isEscTcsOff();
            iSerializer.putBool(bl6);
            boolean bl7 = brakeConfiguration.isEscOffroad();
            iSerializer.putBool(bl7);
            boolean bl8 = brakeConfiguration.isSystemtype();
            iSerializer.putBool(bl8);
        }
    }

    public static void putOptionalBrakeConfigurationVarArray(ISerializer iSerializer, BrakeConfiguration[] brakeConfigurationArray) {
        boolean bl = brakeConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(brakeConfigurationArray.length);
            for (int i2 = 0; i2 < brakeConfigurationArray.length; ++i2) {
                BrakeConfigurationSerializer.putOptionalBrakeConfiguration(iSerializer, brakeConfigurationArray[i2]);
            }
        }
    }

    public static BrakeConfiguration getOptionalBrakeConfiguration(IDeserializer iDeserializer) {
        BrakeConfiguration brakeConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            brakeConfiguration = new BrakeConfiguration();
            brakeConfiguration.autoHoldLastMode = bl8 = iDeserializer.getBool();
            brakeConfiguration.autoHoldOnOff = bl7 = iDeserializer.getBool();
            brakeConfiguration.escOff = bl6 = iDeserializer.getBool();
            brakeConfiguration.escSport = bl5 = iDeserializer.getBool();
            brakeConfiguration.escTcsOff = bl4 = iDeserializer.getBool();
            brakeConfiguration.escOffroad = bl3 = iDeserializer.getBool();
            brakeConfiguration.systemtype = bl2 = iDeserializer.getBool();
        }
        return brakeConfiguration;
    }

    public static BrakeConfiguration[] getOptionalBrakeConfigurationVarArray(IDeserializer iDeserializer) {
        BrakeConfiguration[] brakeConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            brakeConfigurationArray = new BrakeConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                brakeConfigurationArray[i2] = BrakeConfigurationSerializer.getOptionalBrakeConfiguration(iDeserializer);
            }
        }
        return brakeConfigurationArray;
    }
}

