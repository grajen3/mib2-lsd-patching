/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;

public class AuxHeaterCoolerExtendedConditioningSerializer {
    public static void putOptionalAuxHeaterCoolerExtendedConditioning(ISerializer iSerializer, AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning) {
        boolean bl = auxHeaterCoolerExtendedConditioning == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = auxHeaterCoolerExtendedConditioning.isZ1rl();
            iSerializer.putBool(bl2);
            boolean bl3 = auxHeaterCoolerExtendedConditioning.isZ1rr();
            iSerializer.putBool(bl3);
            boolean bl4 = auxHeaterCoolerExtendedConditioning.isZ2rl();
            iSerializer.putBool(bl4);
            boolean bl5 = auxHeaterCoolerExtendedConditioning.isZ2rr();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalAuxHeaterCoolerExtendedConditioningVarArray(ISerializer iSerializer, AuxHeaterCoolerExtendedConditioning[] auxHeaterCoolerExtendedConditioningArray) {
        boolean bl = auxHeaterCoolerExtendedConditioningArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(auxHeaterCoolerExtendedConditioningArray.length);
            for (int i2 = 0; i2 < auxHeaterCoolerExtendedConditioningArray.length; ++i2) {
                AuxHeaterCoolerExtendedConditioningSerializer.putOptionalAuxHeaterCoolerExtendedConditioning(iSerializer, auxHeaterCoolerExtendedConditioningArray[i2]);
            }
        }
    }

    public static AuxHeaterCoolerExtendedConditioning getOptionalAuxHeaterCoolerExtendedConditioning(IDeserializer iDeserializer) {
        AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            auxHeaterCoolerExtendedConditioning = new AuxHeaterCoolerExtendedConditioning();
            auxHeaterCoolerExtendedConditioning.z1rl = bl5 = iDeserializer.getBool();
            auxHeaterCoolerExtendedConditioning.z1rr = bl4 = iDeserializer.getBool();
            auxHeaterCoolerExtendedConditioning.z2rl = bl3 = iDeserializer.getBool();
            auxHeaterCoolerExtendedConditioning.z2rr = bl2 = iDeserializer.getBool();
        }
        return auxHeaterCoolerExtendedConditioning;
    }

    public static AuxHeaterCoolerExtendedConditioning[] getOptionalAuxHeaterCoolerExtendedConditioningVarArray(IDeserializer iDeserializer) {
        AuxHeaterCoolerExtendedConditioning[] auxHeaterCoolerExtendedConditioningArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            auxHeaterCoolerExtendedConditioningArray = new AuxHeaterCoolerExtendedConditioning[n];
            for (int i2 = 0; i2 < n; ++i2) {
                auxHeaterCoolerExtendedConditioningArray[i2] = AuxHeaterCoolerExtendedConditioningSerializer.getOptionalAuxHeaterCoolerExtendedConditioning(iDeserializer);
            }
        }
        return auxHeaterCoolerExtendedConditioningArray;
    }
}

