/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.dsi.carseat.impl.MassageProgsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.MassageConfig;
import org.dsi.ifc.carseat.MassageProgs;

public class MassageConfigSerializer {
    public static void putOptionalMassageConfig(ISerializer iSerializer, MassageConfig massageConfig) {
        boolean bl = massageConfig == null;
        iSerializer.putBool(bl);
        if (!bl) {
            MassageProgs massageProgs = massageConfig.getPrograms();
            MassageProgsSerializer.putOptionalMassageProgs(iSerializer, massageProgs);
            short s = massageConfig.getIntensityRange();
            iSerializer.putInt16(s);
            short s2 = massageConfig.getSpeedRange();
            iSerializer.putInt16(s2);
        }
    }

    public static void putOptionalMassageConfigVarArray(ISerializer iSerializer, MassageConfig[] massageConfigArray) {
        boolean bl = massageConfigArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(massageConfigArray.length);
            for (int i2 = 0; i2 < massageConfigArray.length; ++i2) {
                MassageConfigSerializer.putOptionalMassageConfig(iSerializer, massageConfigArray[i2]);
            }
        }
    }

    public static MassageConfig getOptionalMassageConfig(IDeserializer iDeserializer) {
        MassageConfig massageConfig = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            MassageProgs massageProgs;
            massageConfig = new MassageConfig();
            massageConfig.programs = massageProgs = MassageProgsSerializer.getOptionalMassageProgs(iDeserializer);
            massageConfig.intensityRange = s2 = iDeserializer.getInt16();
            massageConfig.speedRange = s = iDeserializer.getInt16();
        }
        return massageConfig;
    }

    public static MassageConfig[] getOptionalMassageConfigVarArray(IDeserializer iDeserializer) {
        MassageConfig[] massageConfigArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            massageConfigArray = new MassageConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                massageConfigArray[i2] = MassageConfigSerializer.getOptionalMassageConfig(iDeserializer);
            }
        }
        return massageConfigArray;
    }
}

