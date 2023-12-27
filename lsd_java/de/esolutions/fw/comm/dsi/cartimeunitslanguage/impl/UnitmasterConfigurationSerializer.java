/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.UnitmasterSupportedConsumptionUnitsSerializer;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.UnitmasterSupportedSkinsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterConfiguration;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterSupportedConsumptionUnits;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterSupportedSkins;

public class UnitmasterConfigurationSerializer {
    public static void putOptionalUnitmasterConfiguration(ISerializer iSerializer, UnitmasterConfiguration unitmasterConfiguration) {
        boolean bl = unitmasterConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            UnitmasterSupportedConsumptionUnits unitmasterSupportedConsumptionUnits = unitmasterConfiguration.getSupportedConsumptionUnits();
            UnitmasterSupportedConsumptionUnitsSerializer.putOptionalUnitmasterSupportedConsumptionUnits(iSerializer, unitmasterSupportedConsumptionUnits);
            UnitmasterSupportedSkins unitmasterSupportedSkins = unitmasterConfiguration.getSupportedSkins();
            UnitmasterSupportedSkinsSerializer.putOptionalUnitmasterSupportedSkins(iSerializer, unitmasterSupportedSkins);
        }
    }

    public static void putOptionalUnitmasterConfigurationVarArray(ISerializer iSerializer, UnitmasterConfiguration[] unitmasterConfigurationArray) {
        boolean bl = unitmasterConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(unitmasterConfigurationArray.length);
            for (int i2 = 0; i2 < unitmasterConfigurationArray.length; ++i2) {
                UnitmasterConfigurationSerializer.putOptionalUnitmasterConfiguration(iSerializer, unitmasterConfigurationArray[i2]);
            }
        }
    }

    public static UnitmasterConfiguration getOptionalUnitmasterConfiguration(IDeserializer iDeserializer) {
        UnitmasterConfiguration unitmasterConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            UnitmasterSupportedSkins unitmasterSupportedSkins;
            UnitmasterSupportedConsumptionUnits unitmasterSupportedConsumptionUnits;
            unitmasterConfiguration = new UnitmasterConfiguration();
            unitmasterConfiguration.supportedConsumptionUnits = unitmasterSupportedConsumptionUnits = UnitmasterSupportedConsumptionUnitsSerializer.getOptionalUnitmasterSupportedConsumptionUnits(iDeserializer);
            unitmasterConfiguration.supportedSkins = unitmasterSupportedSkins = UnitmasterSupportedSkinsSerializer.getOptionalUnitmasterSupportedSkins(iDeserializer);
        }
        return unitmasterConfiguration;
    }

    public static UnitmasterConfiguration[] getOptionalUnitmasterConfigurationVarArray(IDeserializer iDeserializer) {
        UnitmasterConfiguration[] unitmasterConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            unitmasterConfigurationArray = new UnitmasterConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                unitmasterConfigurationArray[i2] = UnitmasterConfigurationSerializer.getOptionalUnitmasterConfiguration(iDeserializer);
            }
        }
        return unitmasterConfigurationArray;
    }
}

