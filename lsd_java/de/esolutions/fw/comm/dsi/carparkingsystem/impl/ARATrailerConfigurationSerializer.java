/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.ARATrailerConfiguration;

public class ARATrailerConfigurationSerializer {
    public static void putOptionalARATrailerConfiguration(ISerializer iSerializer, ARATrailerConfiguration aRATrailerConfiguration) {
        boolean bl = aRATrailerConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = aRATrailerConfiguration.getMaxTrailerAngle();
            iSerializer.putInt16(s);
            short s2 = aRATrailerConfiguration.getInstantTrailerAngle();
            iSerializer.putInt16(s2);
            short s3 = aRATrailerConfiguration.getHazinessTrailerAngle();
            iSerializer.putInt16(s3);
            short s4 = aRATrailerConfiguration.getThreshold1();
            iSerializer.putInt16(s4);
            short s5 = aRATrailerConfiguration.getThreshold2();
            iSerializer.putInt16(s5);
            short s6 = aRATrailerConfiguration.getThreshold3();
            iSerializer.putInt16(s6);
            short s7 = aRATrailerConfiguration.getThreshold4();
            iSerializer.putInt16(s7);
            byte by = aRATrailerConfiguration.getStepSize1();
            iSerializer.putInt8(by);
            byte by2 = aRATrailerConfiguration.getStepSize2();
            iSerializer.putInt8(by2);
            byte by3 = aRATrailerConfiguration.getStepSize3();
            iSerializer.putInt8(by3);
            byte by4 = aRATrailerConfiguration.getStepSize4();
            iSerializer.putInt8(by4);
        }
    }

    public static void putOptionalARATrailerConfigurationVarArray(ISerializer iSerializer, ARATrailerConfiguration[] aRATrailerConfigurationArray) {
        boolean bl = aRATrailerConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(aRATrailerConfigurationArray.length);
            for (int i2 = 0; i2 < aRATrailerConfigurationArray.length; ++i2) {
                ARATrailerConfigurationSerializer.putOptionalARATrailerConfiguration(iSerializer, aRATrailerConfigurationArray[i2]);
            }
        }
    }

    public static ARATrailerConfiguration getOptionalARATrailerConfiguration(IDeserializer iDeserializer) {
        ARATrailerConfiguration aRATrailerConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            byte by2;
            byte by3;
            byte by4;
            short s;
            short s2;
            short s3;
            short s4;
            short s5;
            short s6;
            short s7;
            aRATrailerConfiguration = new ARATrailerConfiguration();
            aRATrailerConfiguration.maxTrailerAngle = s7 = iDeserializer.getInt16();
            aRATrailerConfiguration.instantTrailerAngle = s6 = iDeserializer.getInt16();
            aRATrailerConfiguration.hazinessTrailerAngle = s5 = iDeserializer.getInt16();
            aRATrailerConfiguration.threshold1 = s4 = iDeserializer.getInt16();
            aRATrailerConfiguration.threshold2 = s3 = iDeserializer.getInt16();
            aRATrailerConfiguration.threshold3 = s2 = iDeserializer.getInt16();
            aRATrailerConfiguration.threshold4 = s = iDeserializer.getInt16();
            aRATrailerConfiguration.stepSize1 = by4 = iDeserializer.getInt8();
            aRATrailerConfiguration.stepSize2 = by3 = iDeserializer.getInt8();
            aRATrailerConfiguration.stepSize3 = by2 = iDeserializer.getInt8();
            aRATrailerConfiguration.stepSize4 = by = iDeserializer.getInt8();
        }
        return aRATrailerConfiguration;
    }

    public static ARATrailerConfiguration[] getOptionalARATrailerConfigurationVarArray(IDeserializer iDeserializer) {
        ARATrailerConfiguration[] aRATrailerConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            aRATrailerConfigurationArray = new ARATrailerConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                aRATrailerConfigurationArray[i2] = ARATrailerConfigurationSerializer.getOptionalARATrailerConfiguration(iDeserializer);
            }
        }
        return aRATrailerConfigurationArray;
    }
}

