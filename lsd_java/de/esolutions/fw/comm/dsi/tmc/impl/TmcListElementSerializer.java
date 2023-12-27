/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc.impl;

import de.esolutions.fw.comm.dsi.tmc.impl.TmcMessageSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class TmcListElementSerializer {
    public static void putOptionalTmcListElement(ISerializer iSerializer, TmcListElement tmcListElement) {
        boolean bl = tmcListElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = tmcListElement.getStreetSignId();
            iSerializer.putInt64(l);
            TmcMessage tmcMessage = tmcListElement.getMessage();
            TmcMessageSerializer.putOptionalTmcMessage(iSerializer, tmcMessage);
            int n = tmcListElement.getType();
            iSerializer.putInt32(n);
            String string = tmcListElement.getDescription();
            iSerializer.putOptionalString(string);
            boolean bl2 = tmcListElement.isHasChild();
            iSerializer.putBool(bl2);
            long l2 = tmcListElement.getUID();
            iSerializer.putInt64(l2);
            long l3 = tmcListElement.getParentID();
            iSerializer.putInt64(l3);
            int n2 = tmcListElement.getNumberOfMessagesInNode();
            iSerializer.putInt32(n2);
            int n3 = tmcListElement.getPositionInCompleteList();
            iSerializer.putInt32(n3);
            String string2 = tmcListElement.getDirectionOfRoad1();
            iSerializer.putOptionalString(string2);
            String string3 = tmcListElement.getDirectionOfRoad2();
            iSerializer.putOptionalString(string3);
            boolean bl3 = tmcListElement.isIsBidirectional();
            iSerializer.putBool(bl3);
            String string4 = tmcListElement.getRoadName();
            iSerializer.putOptionalString(string4);
            String string5 = tmcListElement.getRoadNumber();
            iSerializer.putOptionalString(string5);
            int[] nArray = tmcListElement.getIconIdList();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalTmcListElementVarArray(ISerializer iSerializer, TmcListElement[] tmcListElementArray) {
        boolean bl = tmcListElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tmcListElementArray.length);
            for (int i2 = 0; i2 < tmcListElementArray.length; ++i2) {
                TmcListElementSerializer.putOptionalTmcListElement(iSerializer, tmcListElementArray[i2]);
            }
        }
    }

    public static TmcListElement getOptionalTmcListElement(IDeserializer iDeserializer) {
        TmcListElement tmcListElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            boolean bl2;
            String string3;
            String string4;
            int n;
            int n2;
            long l;
            long l2;
            boolean bl3;
            String string5;
            int n3;
            TmcMessage tmcMessage;
            long l3;
            tmcListElement = new TmcListElement();
            tmcListElement.streetSignId = l3 = iDeserializer.getInt64();
            tmcListElement.message = tmcMessage = TmcMessageSerializer.getOptionalTmcMessage(iDeserializer);
            tmcListElement.type = n3 = iDeserializer.getInt32();
            tmcListElement.description = string5 = iDeserializer.getOptionalString();
            tmcListElement.hasChild = bl3 = iDeserializer.getBool();
            tmcListElement.uID = l2 = iDeserializer.getInt64();
            tmcListElement.parentID = l = iDeserializer.getInt64();
            tmcListElement.numberOfMessagesInNode = n2 = iDeserializer.getInt32();
            tmcListElement.positionInCompleteList = n = iDeserializer.getInt32();
            tmcListElement.directionOfRoad1 = string4 = iDeserializer.getOptionalString();
            tmcListElement.directionOfRoad2 = string3 = iDeserializer.getOptionalString();
            tmcListElement.isBidirectional = bl2 = iDeserializer.getBool();
            tmcListElement.roadName = string2 = iDeserializer.getOptionalString();
            tmcListElement.roadNumber = string = iDeserializer.getOptionalString();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            tmcListElement.iconIdList = nArray;
        }
        return tmcListElement;
    }

    public static TmcListElement[] getOptionalTmcListElementVarArray(IDeserializer iDeserializer) {
        TmcListElement[] tmcListElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tmcListElementArray = new TmcListElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tmcListElementArray[i2] = TmcListElementSerializer.getOptionalTmcListElement(iDeserializer);
            }
        }
        return tmcListElementArray;
    }
}

