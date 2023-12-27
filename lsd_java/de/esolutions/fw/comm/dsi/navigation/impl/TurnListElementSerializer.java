/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.AdditionalTurnListIconSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.ManeuverElementSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavLaneGuidanceDataSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.PriceInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.AdditionalTurnListIcon;
import org.dsi.ifc.navigation.ManeuverElement;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.PriceInfo;
import org.dsi.ifc.navigation.TurnListElement;

public class TurnListElementSerializer {
    public static void putOptionalTurnListElement(ISerializer iSerializer, TurnListElement turnListElement) {
        boolean bl = turnListElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = turnListElement.getDistance();
            iSerializer.putInt64(l);
            long l2 = turnListElement.getEta();
            iSerializer.putInt64(l2);
            long l3 = turnListElement.getEtaWithTimeDelay();
            iSerializer.putInt64(l3);
            ManeuverElement[] maneuverElementArray = turnListElement.getManeuver();
            ManeuverElementSerializer.putOptionalManeuverElementVarArray(iSerializer, maneuverElementArray);
            String string = turnListElement.getStreet();
            iSerializer.putOptionalString(string);
            String string2 = turnListElement.getTurnToStreet();
            iSerializer.putOptionalString(string2);
            String string3 = turnListElement.getStreetIconText();
            iSerializer.putOptionalString(string3);
            int n = turnListElement.getStreetIconId();
            iSerializer.putInt32(n);
            String string4 = turnListElement.getExitNumber();
            iSerializer.putOptionalString(string4);
            String string5 = turnListElement.getSignPostInfo();
            iSerializer.putOptionalString(string5);
            int n2 = turnListElement.getExitIconId();
            iSerializer.putInt32(n2);
            String string6 = turnListElement.getCountryAbbreviation();
            iSerializer.putOptionalString(string6);
            int n3 = turnListElement.getType();
            iSerializer.putInt32(n3);
            AdditionalTurnListIcon[] additionalTurnListIconArray = turnListElement.getAdditionalIcons();
            AdditionalTurnListIconSerializer.putOptionalAdditionalTurnListIconVarArray(iSerializer, additionalTurnListIconArray);
            NavLaneGuidanceData[] navLaneGuidanceDataArray = turnListElement.getLaneGuidance();
            NavLaneGuidanceDataSerializer.putOptionalNavLaneGuidanceDataVarArray(iSerializer, navLaneGuidanceDataArray);
            int n4 = turnListElement.getDestinationIndex();
            iSerializer.putInt32(n4);
            PriceInfo priceInfo = turnListElement.getTollcost();
            PriceInfoSerializer.putOptionalPriceInfo(iSerializer, priceInfo);
            long l4 = turnListElement.getLength();
            iSerializer.putInt64(l4);
            String string7 = turnListElement.getStreetCardinalDirection();
            iSerializer.putOptionalString(string7);
        }
    }

    public static void putOptionalTurnListElementVarArray(ISerializer iSerializer, TurnListElement[] turnListElementArray) {
        boolean bl = turnListElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(turnListElementArray.length);
            for (int i2 = 0; i2 < turnListElementArray.length; ++i2) {
                TurnListElementSerializer.putOptionalTurnListElement(iSerializer, turnListElementArray[i2]);
            }
        }
    }

    public static TurnListElement getOptionalTurnListElement(IDeserializer iDeserializer) {
        TurnListElement turnListElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            PriceInfo priceInfo;
            int n;
            int n2;
            String string2;
            int n3;
            String string3;
            String string4;
            int n4;
            String string5;
            String string6;
            String string7;
            long l2;
            long l3;
            long l4;
            turnListElement = new TurnListElement();
            turnListElement.distance = l4 = iDeserializer.getInt64();
            turnListElement.eta = l3 = iDeserializer.getInt64();
            turnListElement.etaWithTimeDelay = l2 = iDeserializer.getInt64();
            ManeuverElement[] maneuverElementArray = ManeuverElementSerializer.getOptionalManeuverElementVarArray(iDeserializer);
            turnListElement.maneuver = maneuverElementArray;
            turnListElement.street = string7 = iDeserializer.getOptionalString();
            turnListElement.turnToStreet = string6 = iDeserializer.getOptionalString();
            turnListElement.streetIconText = string5 = iDeserializer.getOptionalString();
            turnListElement.streetIconId = n4 = iDeserializer.getInt32();
            turnListElement.exitNumber = string4 = iDeserializer.getOptionalString();
            turnListElement.signPostInfo = string3 = iDeserializer.getOptionalString();
            turnListElement.exitIconId = n3 = iDeserializer.getInt32();
            turnListElement.countryAbbreviation = string2 = iDeserializer.getOptionalString();
            turnListElement.type = n2 = iDeserializer.getInt32();
            AdditionalTurnListIcon[] additionalTurnListIconArray = AdditionalTurnListIconSerializer.getOptionalAdditionalTurnListIconVarArray(iDeserializer);
            turnListElement.additionalIcons = additionalTurnListIconArray;
            NavLaneGuidanceData[] navLaneGuidanceDataArray = NavLaneGuidanceDataSerializer.getOptionalNavLaneGuidanceDataVarArray(iDeserializer);
            turnListElement.laneGuidance = navLaneGuidanceDataArray;
            turnListElement.destinationIndex = n = iDeserializer.getInt32();
            turnListElement.tollcost = priceInfo = PriceInfoSerializer.getOptionalPriceInfo(iDeserializer);
            turnListElement.length = l = iDeserializer.getInt64();
            turnListElement.streetCardinalDirection = string = iDeserializer.getOptionalString();
        }
        return turnListElement;
    }

    public static TurnListElement[] getOptionalTurnListElementVarArray(IDeserializer iDeserializer) {
        TurnListElement[] turnListElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            turnListElementArray = new TurnListElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                turnListElementArray[i2] = TurnListElementSerializer.getOptionalTurnListElement(iDeserializer);
            }
        }
        return turnListElementArray;
    }
}

