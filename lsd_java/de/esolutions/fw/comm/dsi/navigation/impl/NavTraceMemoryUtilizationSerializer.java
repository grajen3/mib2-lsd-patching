/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;

public class NavTraceMemoryUtilizationSerializer {
    public static void putOptionalNavTraceMemoryUtilization(ISerializer iSerializer, NavTraceMemoryUtilization navTraceMemoryUtilization) {
        boolean bl = navTraceMemoryUtilization == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = navTraceMemoryUtilization.getFirstTrackpoint();
            iSerializer.putInt64(l);
            long l2 = navTraceMemoryUtilization.getNumberOfTrackpoints();
            iSerializer.putInt64(l2);
            short s = navTraceMemoryUtilization.getUtilization();
            iSerializer.putInt16(s);
            int n = navTraceMemoryUtilization.getRecordingDistance();
            iSerializer.putInt32(n);
            int n2 = navTraceMemoryUtilization.getRemainingDistance();
            iSerializer.putInt32(n2);
            int n3 = navTraceMemoryUtilization.getRemainingTime();
            iSerializer.putInt32(n3);
            long l3 = navTraceMemoryUtilization.getTotalNumberOfTrackPoints();
            iSerializer.putInt64(l3);
            long l4 = navTraceMemoryUtilization.getMaximumNumberOfTrackPoints();
            iSerializer.putInt64(l4);
        }
    }

    public static void putOptionalNavTraceMemoryUtilizationVarArray(ISerializer iSerializer, NavTraceMemoryUtilization[] navTraceMemoryUtilizationArray) {
        boolean bl = navTraceMemoryUtilizationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navTraceMemoryUtilizationArray.length);
            for (int i2 = 0; i2 < navTraceMemoryUtilizationArray.length; ++i2) {
                NavTraceMemoryUtilizationSerializer.putOptionalNavTraceMemoryUtilization(iSerializer, navTraceMemoryUtilizationArray[i2]);
            }
        }
    }

    public static NavTraceMemoryUtilization getOptionalNavTraceMemoryUtilization(IDeserializer iDeserializer) {
        NavTraceMemoryUtilization navTraceMemoryUtilization = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            long l2;
            int n;
            int n2;
            int n3;
            short s;
            long l3;
            long l4;
            navTraceMemoryUtilization = new NavTraceMemoryUtilization();
            navTraceMemoryUtilization.firstTrackpoint = l4 = iDeserializer.getInt64();
            navTraceMemoryUtilization.numberOfTrackpoints = l3 = iDeserializer.getInt64();
            navTraceMemoryUtilization.utilization = s = iDeserializer.getInt16();
            navTraceMemoryUtilization.recordingDistance = n3 = iDeserializer.getInt32();
            navTraceMemoryUtilization.remainingDistance = n2 = iDeserializer.getInt32();
            navTraceMemoryUtilization.remainingTime = n = iDeserializer.getInt32();
            navTraceMemoryUtilization.totalNumberOfTrackPoints = l2 = iDeserializer.getInt64();
            navTraceMemoryUtilization.maximumNumberOfTrackPoints = l = iDeserializer.getInt64();
        }
        return navTraceMemoryUtilization;
    }

    public static NavTraceMemoryUtilization[] getOptionalNavTraceMemoryUtilizationVarArray(IDeserializer iDeserializer) {
        NavTraceMemoryUtilization[] navTraceMemoryUtilizationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navTraceMemoryUtilizationArray = new NavTraceMemoryUtilization[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navTraceMemoryUtilizationArray[i2] = NavTraceMemoryUtilizationSerializer.getOptionalNavTraceMemoryUtilization(iDeserializer);
            }
        }
        return navTraceMemoryUtilizationArray;
    }
}

