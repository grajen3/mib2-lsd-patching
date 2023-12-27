/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser.impl;

import de.esolutions.fw.comm.dsi.filebrowser.impl.GPSInfoSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.filebrowser.GPSInfo;
import org.dsi.ifc.filebrowser.PreviewInfo;
import org.dsi.ifc.global.ResourceLocator;

public class PreviewInfoSerializer {
    public static void putOptionalPreviewInfo(ISerializer iSerializer, PreviewInfo previewInfo) {
        boolean bl = previewInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            ResourceLocator resourceLocator = previewInfo.getPreviewRL();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            long l = previewInfo.getUtcTimestampCreatedOn();
            iSerializer.putInt64(l);
            GPSInfo gPSInfo = previewInfo.getGpsInfo();
            GPSInfoSerializer.putOptionalGPSInfo(iSerializer, gPSInfo);
            String string = previewInfo.getHeadline();
            iSerializer.putOptionalString(string);
            String string2 = previewInfo.getImageDescription();
            iSerializer.putOptionalString(string2);
            String string3 = previewInfo.getCopyright();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalPreviewInfoVarArray(ISerializer iSerializer, PreviewInfo[] previewInfoArray) {
        boolean bl = previewInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(previewInfoArray.length);
            for (int i2 = 0; i2 < previewInfoArray.length; ++i2) {
                PreviewInfoSerializer.putOptionalPreviewInfo(iSerializer, previewInfoArray[i2]);
            }
        }
    }

    public static PreviewInfo getOptionalPreviewInfo(IDeserializer iDeserializer) {
        PreviewInfo previewInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            GPSInfo gPSInfo;
            long l;
            ResourceLocator resourceLocator;
            previewInfo = new PreviewInfo();
            previewInfo.previewRL = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            previewInfo.utcTimestampCreatedOn = l = iDeserializer.getInt64();
            previewInfo.gpsInfo = gPSInfo = GPSInfoSerializer.getOptionalGPSInfo(iDeserializer);
            previewInfo.headline = string3 = iDeserializer.getOptionalString();
            previewInfo.imageDescription = string2 = iDeserializer.getOptionalString();
            previewInfo.copyright = string = iDeserializer.getOptionalString();
        }
        return previewInfo;
    }

    public static PreviewInfo[] getOptionalPreviewInfoVarArray(IDeserializer iDeserializer) {
        PreviewInfo[] previewInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            previewInfoArray = new PreviewInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                previewInfoArray[i2] = PreviewInfoSerializer.getOptionalPreviewInfo(iDeserializer);
            }
        }
        return previewInfoArray;
    }
}

