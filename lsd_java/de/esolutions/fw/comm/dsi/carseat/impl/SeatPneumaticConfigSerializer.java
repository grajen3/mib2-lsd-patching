/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.dsi.carseat.impl.MassageConfigSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.VisualizationConfigSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.MassageConfig;
import org.dsi.ifc.carseat.SeatPneumaticConfig;
import org.dsi.ifc.carseat.VisualizationConfig;

public class SeatPneumaticConfigSerializer {
    public static void putOptionalSeatPneumaticConfig(ISerializer iSerializer, SeatPneumaticConfig seatPneumaticConfig) {
        boolean bl = seatPneumaticConfig == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = seatPneumaticConfig.isDriversideLeft();
            iSerializer.putBool(bl2);
            MassageConfig massageConfig = seatPneumaticConfig.getMassageConfig1RL();
            MassageConfigSerializer.putOptionalMassageConfig(iSerializer, massageConfig);
            MassageConfig massageConfig2 = seatPneumaticConfig.getMassageConfig1RR();
            MassageConfigSerializer.putOptionalMassageConfig(iSerializer, massageConfig2);
            VisualizationConfig visualizationConfig = seatPneumaticConfig.getVisualizationConfig1RL();
            VisualizationConfigSerializer.putOptionalVisualizationConfig(iSerializer, visualizationConfig);
            VisualizationConfig visualizationConfig2 = seatPneumaticConfig.getVisualizationConfig1RR();
            VisualizationConfigSerializer.putOptionalVisualizationConfig(iSerializer, visualizationConfig2);
        }
    }

    public static void putOptionalSeatPneumaticConfigVarArray(ISerializer iSerializer, SeatPneumaticConfig[] seatPneumaticConfigArray) {
        boolean bl = seatPneumaticConfigArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seatPneumaticConfigArray.length);
            for (int i2 = 0; i2 < seatPneumaticConfigArray.length; ++i2) {
                SeatPneumaticConfigSerializer.putOptionalSeatPneumaticConfig(iSerializer, seatPneumaticConfigArray[i2]);
            }
        }
    }

    public static SeatPneumaticConfig getOptionalSeatPneumaticConfig(IDeserializer iDeserializer) {
        SeatPneumaticConfig seatPneumaticConfig = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            VisualizationConfig visualizationConfig;
            VisualizationConfig visualizationConfig2;
            MassageConfig massageConfig;
            MassageConfig massageConfig2;
            boolean bl2;
            seatPneumaticConfig = new SeatPneumaticConfig();
            seatPneumaticConfig.driversideLeft = bl2 = iDeserializer.getBool();
            seatPneumaticConfig.massageConfig1RL = massageConfig2 = MassageConfigSerializer.getOptionalMassageConfig(iDeserializer);
            seatPneumaticConfig.massageConfig1RR = massageConfig = MassageConfigSerializer.getOptionalMassageConfig(iDeserializer);
            seatPneumaticConfig.visualizationConfig1RL = visualizationConfig2 = VisualizationConfigSerializer.getOptionalVisualizationConfig(iDeserializer);
            seatPneumaticConfig.visualizationConfig1RR = visualizationConfig = VisualizationConfigSerializer.getOptionalVisualizationConfig(iDeserializer);
        }
        return seatPneumaticConfig;
    }

    public static SeatPneumaticConfig[] getOptionalSeatPneumaticConfigVarArray(IDeserializer iDeserializer) {
        SeatPneumaticConfig[] seatPneumaticConfigArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seatPneumaticConfigArray = new SeatPneumaticConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seatPneumaticConfigArray[i2] = SeatPneumaticConfigSerializer.getOptionalSeatPneumaticConfig(iDeserializer);
            }
        }
        return seatPneumaticConfigArray;
    }
}

