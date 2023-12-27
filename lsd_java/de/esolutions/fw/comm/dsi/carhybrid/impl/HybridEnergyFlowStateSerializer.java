/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.HybridSinkStateSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridSinkState;

public class HybridEnergyFlowStateSerializer {
    public static void putOptionalHybridEnergyFlowState(ISerializer iSerializer, HybridEnergyFlowState hybridEnergyFlowState) {
        boolean bl = hybridEnergyFlowState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = hybridEnergyFlowState.getMotionState();
            iSerializer.putInt32(n);
            int n2 = hybridEnergyFlowState.getICEState();
            iSerializer.putInt32(n2);
            int n3 = hybridEnergyFlowState.getBatteryState();
            iSerializer.putInt32(n3);
            int n4 = hybridEnergyFlowState.getTorqueState();
            iSerializer.putInt32(n4);
            int n5 = hybridEnergyFlowState.getPowerSupplyState();
            iSerializer.putInt32(n5);
            int n6 = hybridEnergyFlowState.getEe1State();
            iSerializer.putInt32(n6);
            int n7 = hybridEnergyFlowState.getEe2State();
            iSerializer.putInt32(n7);
            HybridSinkState hybridSinkState = hybridEnergyFlowState.getSinkState();
            HybridSinkStateSerializer.putOptionalHybridSinkState(iSerializer, hybridSinkState);
        }
    }

    public static void putOptionalHybridEnergyFlowStateVarArray(ISerializer iSerializer, HybridEnergyFlowState[] hybridEnergyFlowStateArray) {
        boolean bl = hybridEnergyFlowStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hybridEnergyFlowStateArray.length);
            for (int i2 = 0; i2 < hybridEnergyFlowStateArray.length; ++i2) {
                HybridEnergyFlowStateSerializer.putOptionalHybridEnergyFlowState(iSerializer, hybridEnergyFlowStateArray[i2]);
            }
        }
    }

    public static HybridEnergyFlowState getOptionalHybridEnergyFlowState(IDeserializer iDeserializer) {
        HybridEnergyFlowState hybridEnergyFlowState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            HybridSinkState hybridSinkState;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            hybridEnergyFlowState = new HybridEnergyFlowState();
            hybridEnergyFlowState.motionState = n7 = iDeserializer.getInt32();
            hybridEnergyFlowState.iCEState = n6 = iDeserializer.getInt32();
            hybridEnergyFlowState.batteryState = n5 = iDeserializer.getInt32();
            hybridEnergyFlowState.torqueState = n4 = iDeserializer.getInt32();
            hybridEnergyFlowState.powerSupplyState = n3 = iDeserializer.getInt32();
            hybridEnergyFlowState.ee1State = n2 = iDeserializer.getInt32();
            hybridEnergyFlowState.ee2State = n = iDeserializer.getInt32();
            hybridEnergyFlowState.sinkState = hybridSinkState = HybridSinkStateSerializer.getOptionalHybridSinkState(iDeserializer);
        }
        return hybridEnergyFlowState;
    }

    public static HybridEnergyFlowState[] getOptionalHybridEnergyFlowStateVarArray(IDeserializer iDeserializer) {
        HybridEnergyFlowState[] hybridEnergyFlowStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hybridEnergyFlowStateArray = new HybridEnergyFlowState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hybridEnergyFlowStateArray[i2] = HybridEnergyFlowStateSerializer.getOptionalHybridEnergyFlowState(iDeserializer);
            }
        }
        return hybridEnergyFlowStateArray;
    }
}

