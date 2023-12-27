/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.predictivenavigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.NavSegmentIDSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public class LikelyDestinationSerializer {
    public static void putOptionalLikelyDestination(ISerializer iSerializer, LikelyDestination likelyDestination) {
        boolean bl = likelyDestination == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = likelyDestination.getCalculationState();
            iSerializer.putInt32(n);
            int n2 = likelyDestination.getCalculationProgress();
            iSerializer.putInt32(n2);
            int n3 = likelyDestination.getLikelihood();
            iSerializer.putInt32(n3);
            long l = likelyDestination.getDistance();
            iSerializer.putInt64(l);
            long l2 = likelyDestination.getRemainingTravelTime();
            iSerializer.putInt64(l2);
            long l3 = likelyDestination.getTimeDelay();
            iSerializer.putInt64(l3);
            int n4 = likelyDestination.getRouteColor();
            iSerializer.putInt32(n4);
            int n5 = likelyDestination.getRouteColorIconId();
            iSerializer.putInt32(n5);
            NavLocation navLocation = likelyDestination.getDestination();
            NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            NavSegmentID navSegmentID = likelyDestination.getSegmentId();
            NavSegmentIDSerializer.putOptionalNavSegmentID(iSerializer, navSegmentID);
        }
    }

    public static void putOptionalLikelyDestinationVarArray(ISerializer iSerializer, LikelyDestination[] likelyDestinationArray) {
        boolean bl = likelyDestinationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(likelyDestinationArray.length);
            for (int i2 = 0; i2 < likelyDestinationArray.length; ++i2) {
                LikelyDestinationSerializer.putOptionalLikelyDestination(iSerializer, likelyDestinationArray[i2]);
            }
        }
    }

    public static LikelyDestination getOptionalLikelyDestination(IDeserializer iDeserializer) {
        LikelyDestination likelyDestination = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            NavSegmentID navSegmentID;
            NavLocation navLocation;
            int n;
            int n2;
            long l;
            long l2;
            long l3;
            int n3;
            int n4;
            int n5;
            likelyDestination = new LikelyDestination();
            likelyDestination.calculationState = n5 = iDeserializer.getInt32();
            likelyDestination.calculationProgress = n4 = iDeserializer.getInt32();
            likelyDestination.likelihood = n3 = iDeserializer.getInt32();
            likelyDestination.distance = l3 = iDeserializer.getInt64();
            likelyDestination.remainingTravelTime = l2 = iDeserializer.getInt64();
            likelyDestination.timeDelay = l = iDeserializer.getInt64();
            likelyDestination.routeColor = n2 = iDeserializer.getInt32();
            likelyDestination.routeColorIconId = n = iDeserializer.getInt32();
            likelyDestination.destination = navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
            likelyDestination.segmentId = navSegmentID = NavSegmentIDSerializer.getOptionalNavSegmentID(iDeserializer);
        }
        return likelyDestination;
    }

    public static LikelyDestination[] getOptionalLikelyDestinationVarArray(IDeserializer iDeserializer) {
        LikelyDestination[] likelyDestinationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            likelyDestinationArray = new LikelyDestination[n];
            for (int i2 = 0; i2 < n; ++i2) {
                likelyDestinationArray[i2] = LikelyDestinationSerializer.getOptionalLikelyDestination(iDeserializer);
            }
        }
        return likelyDestinationArray;
    }
}

