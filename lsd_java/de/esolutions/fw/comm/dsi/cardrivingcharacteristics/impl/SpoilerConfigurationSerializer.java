/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SpoilerPositionSetupSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SpoilerPositionsSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SpoilerTypeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerPositionSetup;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerPositions;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerType;

public class SpoilerConfigurationSerializer {
    public static void putOptionalSpoilerConfiguration(ISerializer iSerializer, SpoilerConfiguration spoilerConfiguration) {
        boolean bl = spoilerConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            SpoilerType spoilerType = spoilerConfiguration.getType();
            SpoilerTypeSerializer.putOptionalSpoilerType(iSerializer, spoilerType);
            SpoilerPositions spoilerPositions = spoilerConfiguration.getPositionsAvailable();
            SpoilerPositionsSerializer.putOptionalSpoilerPositions(iSerializer, spoilerPositions);
            SpoilerPositionSetup spoilerPositionSetup = spoilerConfiguration.getPositionSetup();
            SpoilerPositionSetupSerializer.putOptionalSpoilerPositionSetup(iSerializer, spoilerPositionSetup);
        }
    }

    public static void putOptionalSpoilerConfigurationVarArray(ISerializer iSerializer, SpoilerConfiguration[] spoilerConfigurationArray) {
        boolean bl = spoilerConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(spoilerConfigurationArray.length);
            for (int i2 = 0; i2 < spoilerConfigurationArray.length; ++i2) {
                SpoilerConfigurationSerializer.putOptionalSpoilerConfiguration(iSerializer, spoilerConfigurationArray[i2]);
            }
        }
    }

    public static SpoilerConfiguration getOptionalSpoilerConfiguration(IDeserializer iDeserializer) {
        SpoilerConfiguration spoilerConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            SpoilerPositionSetup spoilerPositionSetup;
            SpoilerPositions spoilerPositions;
            SpoilerType spoilerType;
            spoilerConfiguration = new SpoilerConfiguration();
            spoilerConfiguration.type = spoilerType = SpoilerTypeSerializer.getOptionalSpoilerType(iDeserializer);
            spoilerConfiguration.positionsAvailable = spoilerPositions = SpoilerPositionsSerializer.getOptionalSpoilerPositions(iDeserializer);
            spoilerConfiguration.positionSetup = spoilerPositionSetup = SpoilerPositionSetupSerializer.getOptionalSpoilerPositionSetup(iDeserializer);
        }
        return spoilerConfiguration;
    }

    public static SpoilerConfiguration[] getOptionalSpoilerConfigurationVarArray(IDeserializer iDeserializer) {
        SpoilerConfiguration[] spoilerConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            spoilerConfigurationArray = new SpoilerConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                spoilerConfigurationArray[i2] = SpoilerConfigurationSerializer.getOptionalSpoilerConfiguration(iDeserializer);
            }
        }
        return spoilerConfigurationArray;
    }
}

