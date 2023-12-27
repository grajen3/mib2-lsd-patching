/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconAirDistributionConfigSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconAirFlowSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconBCMeasuresConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListTransmittableElementsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconAirDistributionConfig;
import org.dsi.ifc.caraircondition.AirconAirFlow;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconRowConfiguration;
import org.dsi.ifc.global.CarArrayListTransmittableElements;

public class AirconRowConfigurationSerializer {
    public static void putOptionalAirconRowConfiguration(ISerializer iSerializer, AirconRowConfiguration airconRowConfiguration) {
        boolean bl = airconRowConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = airconRowConfiguration.isExternalDisplay();
            iSerializer.putBool(bl2);
            boolean bl3 = airconRowConfiguration.isSetupButton();
            iSerializer.putBool(bl3);
            boolean bl4 = airconRowConfiguration.isAutoMode();
            iSerializer.putBool(bl4);
            AirconAirFlow airconAirFlow = airconRowConfiguration.getAirFlowConfigZoneLeft();
            AirconAirFlowSerializer.putOptionalAirconAirFlow(iSerializer, airconAirFlow);
            AirconAirFlow airconAirFlow2 = airconRowConfiguration.getAirFlowConfigZoneRight();
            AirconAirFlowSerializer.putOptionalAirconAirFlow(iSerializer, airconAirFlow2);
            AirconAirDistributionConfig airconAirDistributionConfig = airconRowConfiguration.getAirDistributionConfigZoneLeft();
            AirconAirDistributionConfigSerializer.putOptionalAirconAirDistributionConfig(iSerializer, airconAirDistributionConfig);
            AirconAirDistributionConfig airconAirDistributionConfig2 = airconRowConfiguration.getAirDistributionConfigZoneRight();
            AirconAirDistributionConfigSerializer.putOptionalAirconAirDistributionConfig(iSerializer, airconAirDistributionConfig2);
            boolean bl5 = airconRowConfiguration.isAirconTempStepViaHMI();
            iSerializer.putBool(bl5);
            AirconBCMeasuresConfiguration airconBCMeasuresConfiguration = airconRowConfiguration.getBcMeasureConfig();
            AirconBCMeasuresConfigurationSerializer.putOptionalAirconBCMeasuresConfiguration(iSerializer, airconBCMeasuresConfiguration);
            int n = airconRowConfiguration.getAirVolumeSteps();
            iSerializer.putInt32(n);
            int n2 = airconRowConfiguration.getAirDistributionSteps();
            iSerializer.putInt32(n2);
            boolean bl6 = airconRowConfiguration.isAirDistributionCombined();
            iSerializer.putBool(bl6);
            CarArrayListTransmittableElements carArrayListTransmittableElements = airconRowConfiguration.getNozzleListTransmittableElements();
            CarArrayListTransmittableElementsSerializer.putOptionalCarArrayListTransmittableElements(iSerializer, carArrayListTransmittableElements);
            int[] nArray = airconRowConfiguration.getNozzleListRAConfig();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalAirconRowConfigurationVarArray(ISerializer iSerializer, AirconRowConfiguration[] airconRowConfigurationArray) {
        boolean bl = airconRowConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconRowConfigurationArray.length);
            for (int i2 = 0; i2 < airconRowConfigurationArray.length; ++i2) {
                AirconRowConfigurationSerializer.putOptionalAirconRowConfiguration(iSerializer, airconRowConfigurationArray[i2]);
            }
        }
    }

    public static AirconRowConfiguration getOptionalAirconRowConfiguration(IDeserializer iDeserializer) {
        AirconRowConfiguration airconRowConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarArrayListTransmittableElements carArrayListTransmittableElements;
            boolean bl2;
            int n;
            int n2;
            AirconBCMeasuresConfiguration airconBCMeasuresConfiguration;
            boolean bl3;
            AirconAirDistributionConfig airconAirDistributionConfig;
            AirconAirDistributionConfig airconAirDistributionConfig2;
            AirconAirFlow airconAirFlow;
            AirconAirFlow airconAirFlow2;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            airconRowConfiguration = new AirconRowConfiguration();
            airconRowConfiguration.externalDisplay = bl6 = iDeserializer.getBool();
            airconRowConfiguration.setupButton = bl5 = iDeserializer.getBool();
            airconRowConfiguration.autoMode = bl4 = iDeserializer.getBool();
            airconRowConfiguration.airFlowConfigZoneLeft = airconAirFlow2 = AirconAirFlowSerializer.getOptionalAirconAirFlow(iDeserializer);
            airconRowConfiguration.airFlowConfigZoneRight = airconAirFlow = AirconAirFlowSerializer.getOptionalAirconAirFlow(iDeserializer);
            airconRowConfiguration.airDistributionConfigZoneLeft = airconAirDistributionConfig2 = AirconAirDistributionConfigSerializer.getOptionalAirconAirDistributionConfig(iDeserializer);
            airconRowConfiguration.airDistributionConfigZoneRight = airconAirDistributionConfig = AirconAirDistributionConfigSerializer.getOptionalAirconAirDistributionConfig(iDeserializer);
            airconRowConfiguration.airconTempStepViaHMI = bl3 = iDeserializer.getBool();
            airconRowConfiguration.bcMeasureConfig = airconBCMeasuresConfiguration = AirconBCMeasuresConfigurationSerializer.getOptionalAirconBCMeasuresConfiguration(iDeserializer);
            airconRowConfiguration.airVolumeSteps = n2 = iDeserializer.getInt32();
            airconRowConfiguration.airDistributionSteps = n = iDeserializer.getInt32();
            airconRowConfiguration.airDistributionCombined = bl2 = iDeserializer.getBool();
            airconRowConfiguration.nozzleListTransmittableElements = carArrayListTransmittableElements = CarArrayListTransmittableElementsSerializer.getOptionalCarArrayListTransmittableElements(iDeserializer);
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            airconRowConfiguration.nozzleListRAConfig = nArray;
        }
        return airconRowConfiguration;
    }

    public static AirconRowConfiguration[] getOptionalAirconRowConfigurationVarArray(IDeserializer iDeserializer) {
        AirconRowConfiguration[] airconRowConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconRowConfigurationArray = new AirconRowConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconRowConfigurationArray[i2] = AirconRowConfigurationSerializer.getOptionalAirconRowConfiguration(iDeserializer);
            }
        }
        return airconRowConfigurationArray;
    }
}

