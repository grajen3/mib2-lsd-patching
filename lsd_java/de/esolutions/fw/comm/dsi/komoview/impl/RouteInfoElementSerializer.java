/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komoview.impl;

import de.esolutions.fw.comm.dsi.komoview.impl.ManeuverElementSerializer;
import de.esolutions.fw.comm.dsi.komoview.impl.TrafficInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.komoview.ManeuverElement;
import org.dsi.ifc.komoview.RouteInfoElement;
import org.dsi.ifc.komoview.TrafficInfo;

public class RouteInfoElementSerializer {
    public static void putOptionalRouteInfoElement(ISerializer iSerializer, RouteInfoElement routeInfoElement) {
        boolean bl = routeInfoElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = routeInfoElement.getDistanceToElement();
            iSerializer.putOptionalString(string);
            String string2 = routeInfoElement.getEstimatedTimeToElement();
            iSerializer.putOptionalString(string2);
            int n = routeInfoElement.getRouteInfoElementType();
            iSerializer.putInt32(n);
            int[] nArray = routeInfoElement.getElementIconIDs();
            iSerializer.putOptionalInt32VarArray(nArray);
            String string3 = routeInfoElement.getPrio1EventText();
            iSerializer.putOptionalString(string3);
            String string4 = routeInfoElement.getStreetIconText();
            iSerializer.putOptionalString(string4);
            int n2 = routeInfoElement.getStreetIconID();
            iSerializer.putInt32(n2);
            String string5 = routeInfoElement.getExitNumber();
            iSerializer.putOptionalString(string5);
            String string6 = routeInfoElement.getTurnToStreet();
            iSerializer.putOptionalString(string6);
            String[] stringArray = routeInfoElement.getPOIElementNames();
            iSerializer.putOptionalStringVarArray(stringArray);
            ManeuverElement[] maneuverElementArray = routeInfoElement.getManeuverDescriptor();
            ManeuverElementSerializer.putOptionalManeuverElementVarArray(iSerializer, maneuverElementArray);
            TrafficInfo trafficInfo = routeInfoElement.getTrafficInfo();
            TrafficInfoSerializer.putOptionalTrafficInfo(iSerializer, trafficInfo);
            int n3 = routeInfoElement.getDestinationIndex();
            iSerializer.putInt32(n3);
            String string7 = routeInfoElement.getSignPostInfo();
            iSerializer.putOptionalString(string7);
            String string8 = routeInfoElement.getDistanceToManeuver();
            iSerializer.putOptionalString(string8);
            String string9 = routeInfoElement.getEstimatedTimeToManeuver();
            iSerializer.putOptionalString(string9);
            String string10 = routeInfoElement.getStreetCardinalDirection();
            iSerializer.putOptionalString(string10);
            int n4 = routeInfoElement.getExitIconId();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalRouteInfoElementVarArray(ISerializer iSerializer, RouteInfoElement[] routeInfoElementArray) {
        boolean bl = routeInfoElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(routeInfoElementArray.length);
            for (int i2 = 0; i2 < routeInfoElementArray.length; ++i2) {
                RouteInfoElementSerializer.putOptionalRouteInfoElement(iSerializer, routeInfoElementArray[i2]);
            }
        }
    }

    public static RouteInfoElement getOptionalRouteInfoElement(IDeserializer iDeserializer) {
        RouteInfoElement routeInfoElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            String string3;
            String string4;
            int n2;
            TrafficInfo trafficInfo;
            String string5;
            String string6;
            int n3;
            String string7;
            String string8;
            int n4;
            String string9;
            String string10;
            routeInfoElement = new RouteInfoElement();
            routeInfoElement.distanceToElement = string10 = iDeserializer.getOptionalString();
            routeInfoElement.estimatedTimeToElement = string9 = iDeserializer.getOptionalString();
            routeInfoElement.routeInfoElementType = n4 = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            routeInfoElement.elementIconIDs = nArray;
            routeInfoElement.prio1EventText = string8 = iDeserializer.getOptionalString();
            routeInfoElement.streetIconText = string7 = iDeserializer.getOptionalString();
            routeInfoElement.streetIconID = n3 = iDeserializer.getInt32();
            routeInfoElement.exitNumber = string6 = iDeserializer.getOptionalString();
            routeInfoElement.turnToStreet = string5 = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            routeInfoElement.pOIElementNames = stringArray;
            ManeuverElement[] maneuverElementArray = ManeuverElementSerializer.getOptionalManeuverElementVarArray(iDeserializer);
            routeInfoElement.maneuverDescriptor = maneuverElementArray;
            routeInfoElement.trafficInfo = trafficInfo = TrafficInfoSerializer.getOptionalTrafficInfo(iDeserializer);
            routeInfoElement.destinationIndex = n2 = iDeserializer.getInt32();
            routeInfoElement.signPostInfo = string4 = iDeserializer.getOptionalString();
            routeInfoElement.distanceToManeuver = string3 = iDeserializer.getOptionalString();
            routeInfoElement.estimatedTimeToManeuver = string2 = iDeserializer.getOptionalString();
            routeInfoElement.streetCardinalDirection = string = iDeserializer.getOptionalString();
            routeInfoElement.exitIconId = n = iDeserializer.getInt32();
        }
        return routeInfoElement;
    }

    public static RouteInfoElement[] getOptionalRouteInfoElementVarArray(IDeserializer iDeserializer) {
        RouteInfoElement[] routeInfoElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            routeInfoElementArray = new RouteInfoElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                routeInfoElementArray[i2] = RouteInfoElementSerializer.getOptionalRouteInfoElement(iDeserializer);
            }
        }
        return routeInfoElementArray;
    }
}

