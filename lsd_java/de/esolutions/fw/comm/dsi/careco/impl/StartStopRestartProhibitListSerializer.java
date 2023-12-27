/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.StartStopRestartProhibitList;

public class StartStopRestartProhibitListSerializer {
    public static void putOptionalStartStopRestartProhibitList(ISerializer iSerializer, StartStopRestartProhibitList startStopRestartProhibitList) {
        boolean bl = startStopRestartProhibitList == null;
        iSerializer.putBool(bl);
        if (!bl) {
            byte by = startStopRestartProhibitList.getListPosition();
            iSerializer.putInt8(by);
            int n = startStopRestartProhibitList.getReason();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalStartStopRestartProhibitListVarArray(ISerializer iSerializer, StartStopRestartProhibitList[] startStopRestartProhibitListArray) {
        boolean bl = startStopRestartProhibitListArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(startStopRestartProhibitListArray.length);
            for (int i2 = 0; i2 < startStopRestartProhibitListArray.length; ++i2) {
                StartStopRestartProhibitListSerializer.putOptionalStartStopRestartProhibitList(iSerializer, startStopRestartProhibitListArray[i2]);
            }
        }
    }

    public static StartStopRestartProhibitList getOptionalStartStopRestartProhibitList(IDeserializer iDeserializer) {
        StartStopRestartProhibitList startStopRestartProhibitList = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            byte by;
            startStopRestartProhibitList = new StartStopRestartProhibitList();
            startStopRestartProhibitList.listPosition = by = iDeserializer.getInt8();
            startStopRestartProhibitList.reason = n = iDeserializer.getInt32();
        }
        return startStopRestartProhibitList;
    }

    public static StartStopRestartProhibitList[] getOptionalStartStopRestartProhibitListVarArray(IDeserializer iDeserializer) {
        StartStopRestartProhibitList[] startStopRestartProhibitListArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            startStopRestartProhibitListArray = new StartStopRestartProhibitList[n];
            for (int i2 = 0; i2 < n; ++i2) {
                startStopRestartProhibitListArray[i2] = StartStopRestartProhibitListSerializer.getOptionalStartStopRestartProhibitList(iDeserializer);
            }
        }
        return startStopRestartProhibitListArray;
    }
}

