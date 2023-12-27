/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.ManeuverElementSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavRouteListDataIconSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.ManeuverElement;
import org.dsi.ifc.navigation.NavRouteListDataIcon;

public class CombinedRouteListElementSerializer {
    public static void putOptionalCombinedRouteListElement(ISerializer iSerializer, CombinedRouteListElement combinedRouteListElement) {
        boolean bl = combinedRouteListElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = combinedRouteListElement.getUid();
            iSerializer.putInt64(l);
            long l2 = combinedRouteListElement.getParent();
            iSerializer.putInt64(l2);
            int[] nArray = combinedRouteListElement.getType();
            iSerializer.putOptionalInt32VarArray(nArray);
            long l3 = combinedRouteListElement.getStartDistance();
            iSerializer.putInt64(l3);
            long l4 = combinedRouteListElement.getEndDistance();
            iSerializer.putInt64(l4);
            long l5 = combinedRouteListElement.getStartTime();
            iSerializer.putInt64(l5);
            long l6 = combinedRouteListElement.getEndTime();
            iSerializer.putInt64(l6);
            String string = combinedRouteListElement.getDescription();
            iSerializer.putOptionalString(string);
            String string2 = combinedRouteListElement.getRoadNumber();
            iSerializer.putOptionalString(string2);
            String string3 = combinedRouteListElement.getStreetIconText();
            iSerializer.putOptionalString(string3);
            String string4 = combinedRouteListElement.getExitNumber();
            iSerializer.putOptionalString(string4);
            String string5 = combinedRouteListElement.getSignPostInfo();
            iSerializer.putOptionalString(string5);
            NavRouteListDataIcon[] navRouteListDataIconArray = combinedRouteListElement.getIcons();
            NavRouteListDataIconSerializer.putOptionalNavRouteListDataIconVarArray(iSerializer, navRouteListDataIconArray);
            long l7 = combinedRouteListElement.getStartDistanceTraffic();
            iSerializer.putInt64(l7);
            long l8 = combinedRouteListElement.getEndDistanceTraffic();
            iSerializer.putInt64(l8);
            ManeuverElement[] maneuverElementArray = combinedRouteListElement.getManeuver();
            ManeuverElementSerializer.putOptionalManeuverElementVarArray(iSerializer, maneuverElementArray);
            boolean bl2 = combinedRouteListElement.isBlocked();
            iSerializer.putBool(bl2);
            int n = combinedRouteListElement.getDestinationIndex();
            iSerializer.putInt32(n);
            boolean bl3 = combinedRouteListElement.isHasChildren();
            iSerializer.putBool(bl3);
            String string6 = combinedRouteListElement.getCountryAbbreviation();
            iSerializer.putOptionalString(string6);
        }
    }

    public static void putOptionalCombinedRouteListElementVarArray(ISerializer iSerializer, CombinedRouteListElement[] combinedRouteListElementArray) {
        boolean bl = combinedRouteListElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(combinedRouteListElementArray.length);
            for (int i2 = 0; i2 < combinedRouteListElementArray.length; ++i2) {
                CombinedRouteListElementSerializer.putOptionalCombinedRouteListElement(iSerializer, combinedRouteListElementArray[i2]);
            }
        }
    }

    public static CombinedRouteListElement getOptionalCombinedRouteListElement(IDeserializer iDeserializer) {
        CombinedRouteListElement combinedRouteListElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            boolean bl2;
            int n;
            boolean bl3;
            long l;
            long l2;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            long l3;
            long l4;
            long l5;
            long l6;
            long l7;
            long l8;
            combinedRouteListElement = new CombinedRouteListElement();
            combinedRouteListElement.uid = l8 = iDeserializer.getInt64();
            combinedRouteListElement.parent = l7 = iDeserializer.getInt64();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            combinedRouteListElement.type = nArray;
            combinedRouteListElement.startDistance = l6 = iDeserializer.getInt64();
            combinedRouteListElement.endDistance = l5 = iDeserializer.getInt64();
            combinedRouteListElement.startTime = l4 = iDeserializer.getInt64();
            combinedRouteListElement.endTime = l3 = iDeserializer.getInt64();
            combinedRouteListElement.description = string6 = iDeserializer.getOptionalString();
            combinedRouteListElement.roadNumber = string5 = iDeserializer.getOptionalString();
            combinedRouteListElement.streetIconText = string4 = iDeserializer.getOptionalString();
            combinedRouteListElement.exitNumber = string3 = iDeserializer.getOptionalString();
            combinedRouteListElement.signPostInfo = string2 = iDeserializer.getOptionalString();
            NavRouteListDataIcon[] navRouteListDataIconArray = NavRouteListDataIconSerializer.getOptionalNavRouteListDataIconVarArray(iDeserializer);
            combinedRouteListElement.icons = navRouteListDataIconArray;
            combinedRouteListElement.startDistanceTraffic = l2 = iDeserializer.getInt64();
            combinedRouteListElement.endDistanceTraffic = l = iDeserializer.getInt64();
            ManeuverElement[] maneuverElementArray = ManeuverElementSerializer.getOptionalManeuverElementVarArray(iDeserializer);
            combinedRouteListElement.maneuver = maneuverElementArray;
            combinedRouteListElement.blocked = bl3 = iDeserializer.getBool();
            combinedRouteListElement.destinationIndex = n = iDeserializer.getInt32();
            combinedRouteListElement.hasChildren = bl2 = iDeserializer.getBool();
            combinedRouteListElement.countryAbbreviation = string = iDeserializer.getOptionalString();
        }
        return combinedRouteListElement;
    }

    public static CombinedRouteListElement[] getOptionalCombinedRouteListElementVarArray(IDeserializer iDeserializer) {
        CombinedRouteListElement[] combinedRouteListElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            combinedRouteListElementArray = new CombinedRouteListElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                combinedRouteListElementArray[i2] = CombinedRouteListElementSerializer.getOptionalCombinedRouteListElement(iDeserializer);
            }
        }
        return combinedRouteListElementArray;
    }
}

