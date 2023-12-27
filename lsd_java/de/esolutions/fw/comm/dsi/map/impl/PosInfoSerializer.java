/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.map.impl.RectSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;

public class PosInfoSerializer {
    public static void putOptionalPosInfo(ISerializer iSerializer, PosInfo posInfo) {
        boolean bl = posInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = posInfo.getEInfoType();
            iSerializer.putInt32(n);
            long l = posInfo.getObjectId();
            iSerializer.putInt64(l);
            NavLocation navLocation = posInfo.getTLocation();
            NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            Rect rect = posInfo.getDisplayPosition();
            RectSerializer.putOptionalRect(iSerializer, rect);
            String string = posInfo.getInfoTxt();
            iSerializer.putOptionalString(string);
            String string2 = posInfo.getUrl();
            iSerializer.putOptionalString(string2);
            ResourceLocator resourceLocator = posInfo.getResourceLocator();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            int n2 = posInfo.getNumberOfObjects();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalPosInfoVarArray(ISerializer iSerializer, PosInfo[] posInfoArray) {
        boolean bl = posInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(posInfoArray.length);
            for (int i2 = 0; i2 < posInfoArray.length; ++i2) {
                PosInfoSerializer.putOptionalPosInfo(iSerializer, posInfoArray[i2]);
            }
        }
    }

    public static PosInfo getOptionalPosInfo(IDeserializer iDeserializer) {
        PosInfo posInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            ResourceLocator resourceLocator;
            String string;
            String string2;
            Rect rect;
            NavLocation navLocation;
            long l;
            int n2;
            posInfo = new PosInfo();
            posInfo.eInfoType = n2 = iDeserializer.getInt32();
            posInfo.objectId = l = iDeserializer.getInt64();
            posInfo.tLocation = navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
            posInfo.displayPosition = rect = RectSerializer.getOptionalRect(iDeserializer);
            posInfo.infoTxt = string2 = iDeserializer.getOptionalString();
            posInfo.url = string = iDeserializer.getOptionalString();
            posInfo.resourceLocator = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            posInfo.numberOfObjects = n = iDeserializer.getInt32();
        }
        return posInfo;
    }

    public static PosInfo[] getOptionalPosInfoVarArray(IDeserializer iDeserializer) {
        PosInfo[] posInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            posInfoArray = new PosInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                posInfoArray[i2] = PosInfoSerializer.getOptionalPosInfo(iDeserializer);
            }
        }
        return posInfoArray;
    }
}

