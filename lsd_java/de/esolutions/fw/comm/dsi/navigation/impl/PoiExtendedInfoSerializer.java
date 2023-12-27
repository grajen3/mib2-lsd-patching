/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.PoiExtendedInfo;

public class PoiExtendedInfoSerializer {
    public static void putOptionalPoiExtendedInfo(ISerializer iSerializer, PoiExtendedInfo poiExtendedInfo) {
        boolean bl = poiExtendedInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = poiExtendedInfo.getLongitude();
            iSerializer.putInt32(n);
            int n2 = poiExtendedInfo.getLatitude();
            iSerializer.putInt32(n2);
            DateTime dateTime = poiExtendedInfo.getTimestamp();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            String string = poiExtendedInfo.getDescription();
            iSerializer.putOptionalString(string);
            ResourceLocator[] resourceLocatorArray = poiExtendedInfo.getPictureReferences();
            ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, resourceLocatorArray);
            String string2 = poiExtendedInfo.getUnstructuredAddress();
            iSerializer.putOptionalString(string2);
            String string3 = poiExtendedInfo.getEmailAddress();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalPoiExtendedInfoVarArray(ISerializer iSerializer, PoiExtendedInfo[] poiExtendedInfoArray) {
        boolean bl = poiExtendedInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(poiExtendedInfoArray.length);
            for (int i2 = 0; i2 < poiExtendedInfoArray.length; ++i2) {
                PoiExtendedInfoSerializer.putOptionalPoiExtendedInfo(iSerializer, poiExtendedInfoArray[i2]);
            }
        }
    }

    public static PoiExtendedInfo getOptionalPoiExtendedInfo(IDeserializer iDeserializer) {
        PoiExtendedInfo poiExtendedInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            DateTime dateTime;
            int n;
            int n2;
            poiExtendedInfo = new PoiExtendedInfo();
            poiExtendedInfo.longitude = n2 = iDeserializer.getInt32();
            poiExtendedInfo.latitude = n = iDeserializer.getInt32();
            poiExtendedInfo.timestamp = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            poiExtendedInfo.description = string3 = iDeserializer.getOptionalString();
            ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
            poiExtendedInfo.pictureReferences = resourceLocatorArray;
            poiExtendedInfo.unstructuredAddress = string2 = iDeserializer.getOptionalString();
            poiExtendedInfo.emailAddress = string = iDeserializer.getOptionalString();
        }
        return poiExtendedInfo;
    }

    public static PoiExtendedInfo[] getOptionalPoiExtendedInfoVarArray(IDeserializer iDeserializer) {
        PoiExtendedInfo[] poiExtendedInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            poiExtendedInfoArray = new PoiExtendedInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                poiExtendedInfoArray[i2] = PoiExtendedInfoSerializer.getOptionalPoiExtendedInfo(iDeserializer);
            }
        }
        return poiExtendedInfoArray;
    }
}

