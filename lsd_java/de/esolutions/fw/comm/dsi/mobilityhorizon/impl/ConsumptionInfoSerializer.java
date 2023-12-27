/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon.impl;

import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.ValueUnitPairSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.ValueUnitPair;

public class ConsumptionInfoSerializer {
    public static void putOptionalConsumptionInfo(ISerializer iSerializer, ConsumptionInfo consumptionInfo) {
        boolean bl = consumptionInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            ValueUnitPair valueUnitPair = consumptionInfo.getResidualEnergy();
            ValueUnitPairSerializer.putOptionalValueUnitPair(iSerializer, valueUnitPair);
            ValueUnitPair valueUnitPair2 = consumptionInfo.getConsumptionMotorway();
            ValueUnitPairSerializer.putOptionalValueUnitPair(iSerializer, valueUnitPair2);
            ValueUnitPair valueUnitPair3 = consumptionInfo.getConsumptionHighway();
            ValueUnitPairSerializer.putOptionalValueUnitPair(iSerializer, valueUnitPair3);
            ValueUnitPair valueUnitPair4 = consumptionInfo.getConsumptionCountryRoad();
            ValueUnitPairSerializer.putOptionalValueUnitPair(iSerializer, valueUnitPair4);
            ValueUnitPair valueUnitPair5 = consumptionInfo.getConsumptionDistrictRoad();
            ValueUnitPairSerializer.putOptionalValueUnitPair(iSerializer, valueUnitPair5);
            ValueUnitPair valueUnitPair6 = consumptionInfo.getConsumptionLocalRoad();
            ValueUnitPairSerializer.putOptionalValueUnitPair(iSerializer, valueUnitPair6);
            ValueUnitPair valueUnitPair7 = consumptionInfo.getConsumptionRuralRoad();
            ValueUnitPairSerializer.putOptionalValueUnitPair(iSerializer, valueUnitPair7);
            ValueUnitPair valueUnitPair8 = consumptionInfo.getConsumptionUnclassifiedRoad();
            ValueUnitPairSerializer.putOptionalValueUnitPair(iSerializer, valueUnitPair8);
            ValueUnitPair[] valueUnitPairArray = consumptionInfo.getReserved();
            ValueUnitPairSerializer.putOptionalValueUnitPairVarArray(iSerializer, valueUnitPairArray);
        }
    }

    public static void putOptionalConsumptionInfoVarArray(ISerializer iSerializer, ConsumptionInfo[] consumptionInfoArray) {
        boolean bl = consumptionInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(consumptionInfoArray.length);
            for (int i2 = 0; i2 < consumptionInfoArray.length; ++i2) {
                ConsumptionInfoSerializer.putOptionalConsumptionInfo(iSerializer, consumptionInfoArray[i2]);
            }
        }
    }

    public static ConsumptionInfo getOptionalConsumptionInfo(IDeserializer iDeserializer) {
        ConsumptionInfo consumptionInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ValueUnitPair valueUnitPair;
            ValueUnitPair valueUnitPair2;
            ValueUnitPair valueUnitPair3;
            ValueUnitPair valueUnitPair4;
            ValueUnitPair valueUnitPair5;
            ValueUnitPair valueUnitPair6;
            ValueUnitPair valueUnitPair7;
            ValueUnitPair valueUnitPair8;
            consumptionInfo = new ConsumptionInfo();
            consumptionInfo.residualEnergy = valueUnitPair8 = ValueUnitPairSerializer.getOptionalValueUnitPair(iDeserializer);
            consumptionInfo.consumptionMotorway = valueUnitPair7 = ValueUnitPairSerializer.getOptionalValueUnitPair(iDeserializer);
            consumptionInfo.consumptionHighway = valueUnitPair6 = ValueUnitPairSerializer.getOptionalValueUnitPair(iDeserializer);
            consumptionInfo.consumptionCountryRoad = valueUnitPair5 = ValueUnitPairSerializer.getOptionalValueUnitPair(iDeserializer);
            consumptionInfo.consumptionDistrictRoad = valueUnitPair4 = ValueUnitPairSerializer.getOptionalValueUnitPair(iDeserializer);
            consumptionInfo.consumptionLocalRoad = valueUnitPair3 = ValueUnitPairSerializer.getOptionalValueUnitPair(iDeserializer);
            consumptionInfo.consumptionRuralRoad = valueUnitPair2 = ValueUnitPairSerializer.getOptionalValueUnitPair(iDeserializer);
            consumptionInfo.consumptionUnclassifiedRoad = valueUnitPair = ValueUnitPairSerializer.getOptionalValueUnitPair(iDeserializer);
            ValueUnitPair[] valueUnitPairArray = ValueUnitPairSerializer.getOptionalValueUnitPairVarArray(iDeserializer);
            consumptionInfo.reserved = valueUnitPairArray;
        }
        return consumptionInfo;
    }

    public static ConsumptionInfo[] getOptionalConsumptionInfoVarArray(IDeserializer iDeserializer) {
        ConsumptionInfo[] consumptionInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            consumptionInfoArray = new ConsumptionInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                consumptionInfoArray[i2] = ConsumptionInfoSerializer.getOptionalConsumptionInfo(iDeserializer);
            }
        }
        return consumptionInfoArray;
    }
}

