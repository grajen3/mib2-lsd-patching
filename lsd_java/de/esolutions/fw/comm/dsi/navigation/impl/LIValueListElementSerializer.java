/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.LIExtDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LIValueListElement;

public class LIValueListElementSerializer {
    public static void putOptionalLIValueListElement(ISerializer iSerializer, LIValueListElement lIValueListElement) {
        boolean bl = lIValueListElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = lIValueListElement.getData();
            iSerializer.putOptionalString(string);
            boolean bl2 = lIValueListElement.isValidDestination();
            iSerializer.putBool(bl2);
            boolean bl3 = lIValueListElement.isToRefine();
            iSerializer.putBool(bl3);
            int n = lIValueListElement.getCriteriaNumber();
            iSerializer.putInt32(n);
            int n2 = lIValueListElement.getPoiUniqueId();
            iSerializer.putInt32(n2);
            int n3 = lIValueListElement.getIconIndex();
            iSerializer.putInt32(n3);
            int n4 = lIValueListElement.getSubIconIndex();
            iSerializer.putInt32(n4);
            int n5 = lIValueListElement.getLongitude();
            iSerializer.putInt32(n5);
            int n6 = lIValueListElement.getLatitude();
            iSerializer.putInt32(n6);
            String string2 = lIValueListElement.getCountryAbbreviation();
            iSerializer.putOptionalString(string2);
            boolean bl4 = lIValueListElement.isHasListIndex();
            iSerializer.putBool(bl4);
            int n7 = lIValueListElement.getListIndex();
            iSerializer.putInt32(n7);
            int n8 = lIValueListElement.getAdditionalFlags();
            iSerializer.putInt32(n8);
            String string3 = lIValueListElement.getAdditionalData();
            iSerializer.putOptionalString(string3);
            boolean bl5 = lIValueListElement.isHouseNumberInZipCode();
            iSerializer.putBool(bl5);
            boolean bl6 = lIValueListElement.isBestGuess();
            iSerializer.putBool(bl6);
            LIExtData[] lIExtDataArray = lIValueListElement.getExtendedData();
            LIExtDataSerializer.putOptionalLIExtDataVarArray(iSerializer, lIExtDataArray);
            int[] nArray = lIValueListElement.getIconDecoratorInformation();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalLIValueListElementVarArray(ISerializer iSerializer, LIValueListElement[] lIValueListElementArray) {
        boolean bl = lIValueListElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(lIValueListElementArray.length);
            for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
                LIValueListElementSerializer.putOptionalLIValueListElement(iSerializer, lIValueListElementArray[i2]);
            }
        }
    }

    public static LIValueListElement getOptionalLIValueListElement(IDeserializer iDeserializer) {
        LIValueListElement lIValueListElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            String string;
            int n;
            int n2;
            boolean bl4;
            String string2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            boolean bl5;
            boolean bl6;
            String string3;
            lIValueListElement = new LIValueListElement();
            lIValueListElement.data = string3 = iDeserializer.getOptionalString();
            lIValueListElement.validDestination = bl6 = iDeserializer.getBool();
            lIValueListElement.toRefine = bl5 = iDeserializer.getBool();
            lIValueListElement.criteriaNumber = n8 = iDeserializer.getInt32();
            lIValueListElement.poiUniqueId = n7 = iDeserializer.getInt32();
            lIValueListElement.iconIndex = n6 = iDeserializer.getInt32();
            lIValueListElement.subIconIndex = n5 = iDeserializer.getInt32();
            lIValueListElement.longitude = n4 = iDeserializer.getInt32();
            lIValueListElement.latitude = n3 = iDeserializer.getInt32();
            lIValueListElement.countryAbbreviation = string2 = iDeserializer.getOptionalString();
            lIValueListElement.hasListIndex = bl4 = iDeserializer.getBool();
            lIValueListElement.listIndex = n2 = iDeserializer.getInt32();
            lIValueListElement.additionalFlags = n = iDeserializer.getInt32();
            lIValueListElement.additionalData = string = iDeserializer.getOptionalString();
            lIValueListElement.houseNumberInZipCode = bl3 = iDeserializer.getBool();
            lIValueListElement.bestGuess = bl2 = iDeserializer.getBool();
            LIExtData[] lIExtDataArray = LIExtDataSerializer.getOptionalLIExtDataVarArray(iDeserializer);
            lIValueListElement.extendedData = lIExtDataArray;
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            lIValueListElement.iconDecoratorInformation = nArray;
        }
        return lIValueListElement;
    }

    public static LIValueListElement[] getOptionalLIValueListElementVarArray(IDeserializer iDeserializer) {
        LIValueListElement[] lIValueListElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            lIValueListElementArray = new LIValueListElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lIValueListElementArray[i2] = LIValueListElementSerializer.getOptionalLIValueListElement(iDeserializer);
            }
        }
        return lIValueListElementArray;
    }
}

