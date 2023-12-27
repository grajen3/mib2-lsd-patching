/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconAirFlow;

public class AirconAirFlowSerializer {
    public static void putOptionalAirconAirFlow(ISerializer iSerializer, AirconAirFlow airconAirFlow) {
        boolean bl = airconAirFlow == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = airconAirFlow.isOutletUp();
            iSerializer.putBool(bl2);
            boolean bl3 = airconAirFlow.isOutletBody();
            iSerializer.putBool(bl3);
            boolean bl4 = airconAirFlow.isOutletFootwell();
            iSerializer.putBool(bl4);
            boolean bl5 = airconAirFlow.isOutletIndirect();
            iSerializer.putBool(bl5);
            boolean bl6 = airconAirFlow.isAutomaticAirDistribution();
            iSerializer.putBool(bl6);
            boolean bl7 = airconAirFlow.isOutletSide();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalAirconAirFlowVarArray(ISerializer iSerializer, AirconAirFlow[] airconAirFlowArray) {
        boolean bl = airconAirFlowArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconAirFlowArray.length);
            for (int i2 = 0; i2 < airconAirFlowArray.length; ++i2) {
                AirconAirFlowSerializer.putOptionalAirconAirFlow(iSerializer, airconAirFlowArray[i2]);
            }
        }
    }

    public static AirconAirFlow getOptionalAirconAirFlow(IDeserializer iDeserializer) {
        AirconAirFlow airconAirFlow = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            airconAirFlow = new AirconAirFlow();
            airconAirFlow.outletUp = bl7 = iDeserializer.getBool();
            airconAirFlow.outletBody = bl6 = iDeserializer.getBool();
            airconAirFlow.outletFootwell = bl5 = iDeserializer.getBool();
            airconAirFlow.outletIndirect = bl4 = iDeserializer.getBool();
            airconAirFlow.automaticAirDistribution = bl3 = iDeserializer.getBool();
            airconAirFlow.outletSide = bl2 = iDeserializer.getBool();
        }
        return airconAirFlow;
    }

    public static AirconAirFlow[] getOptionalAirconAirFlowVarArray(IDeserializer iDeserializer) {
        AirconAirFlow[] airconAirFlowArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconAirFlowArray = new AirconAirFlow[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconAirFlowArray[i2] = AirconAirFlowSerializer.getOptionalAirconAirFlow(iDeserializer);
            }
        }
        return airconAirFlowArray;
    }
}

