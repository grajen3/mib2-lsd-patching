/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler.impl;

import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.AuxHeaterCoolerExtendedConditioningSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerConfiguration;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;

public class AuxHeaterCoolerConfigurationSerializer {
    public static void putOptionalAuxHeaterCoolerConfiguration(ISerializer iSerializer, AuxHeaterCoolerConfiguration auxHeaterCoolerConfiguration) {
        boolean bl = auxHeaterCoolerConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = auxHeaterCoolerConfiguration.isHeating();
            iSerializer.putBool(bl2);
            boolean bl3 = auxHeaterCoolerConfiguration.isVentilation();
            iSerializer.putBool(bl3);
            AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning = auxHeaterCoolerConfiguration.getExtendedConditioning();
            AuxHeaterCoolerExtendedConditioningSerializer.putOptionalAuxHeaterCoolerExtendedConditioning(iSerializer, auxHeaterCoolerExtendedConditioning);
        }
    }

    public static void putOptionalAuxHeaterCoolerConfigurationVarArray(ISerializer iSerializer, AuxHeaterCoolerConfiguration[] auxHeaterCoolerConfigurationArray) {
        boolean bl = auxHeaterCoolerConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(auxHeaterCoolerConfigurationArray.length);
            for (int i2 = 0; i2 < auxHeaterCoolerConfigurationArray.length; ++i2) {
                AuxHeaterCoolerConfigurationSerializer.putOptionalAuxHeaterCoolerConfiguration(iSerializer, auxHeaterCoolerConfigurationArray[i2]);
            }
        }
    }

    public static AuxHeaterCoolerConfiguration getOptionalAuxHeaterCoolerConfiguration(IDeserializer iDeserializer) {
        AuxHeaterCoolerConfiguration auxHeaterCoolerConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning;
            boolean bl2;
            boolean bl3;
            auxHeaterCoolerConfiguration = new AuxHeaterCoolerConfiguration();
            auxHeaterCoolerConfiguration.heating = bl3 = iDeserializer.getBool();
            auxHeaterCoolerConfiguration.ventilation = bl2 = iDeserializer.getBool();
            auxHeaterCoolerConfiguration.extendedConditioning = auxHeaterCoolerExtendedConditioning = AuxHeaterCoolerExtendedConditioningSerializer.getOptionalAuxHeaterCoolerExtendedConditioning(iDeserializer);
        }
        return auxHeaterCoolerConfiguration;
    }

    public static AuxHeaterCoolerConfiguration[] getOptionalAuxHeaterCoolerConfigurationVarArray(IDeserializer iDeserializer) {
        AuxHeaterCoolerConfiguration[] auxHeaterCoolerConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            auxHeaterCoolerConfigurationArray = new AuxHeaterCoolerConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                auxHeaterCoolerConfigurationArray[i2] = AuxHeaterCoolerConfigurationSerializer.getOptionalAuxHeaterCoolerConfiguration(iDeserializer);
            }
        }
        return auxHeaterCoolerConfigurationArray;
    }
}

