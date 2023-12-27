/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.organizer.DownloadInfo;

public class DownloadInfoSerializer {
    public static void putOptionalDownloadInfo(ISerializer iSerializer, DownloadInfo downloadInfo) {
        boolean bl = downloadInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = downloadInfo.getCount();
            iSerializer.putInt32(n);
            int n2 = downloadInfo.getNumberOfItems();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalDownloadInfoVarArray(ISerializer iSerializer, DownloadInfo[] downloadInfoArray) {
        boolean bl = downloadInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(downloadInfoArray.length);
            for (int i2 = 0; i2 < downloadInfoArray.length; ++i2) {
                DownloadInfoSerializer.putOptionalDownloadInfo(iSerializer, downloadInfoArray[i2]);
            }
        }
    }

    public static DownloadInfo getOptionalDownloadInfo(IDeserializer iDeserializer) {
        DownloadInfo downloadInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            downloadInfo = new DownloadInfo();
            downloadInfo.count = n2 = iDeserializer.getInt32();
            downloadInfo.numberOfItems = n = iDeserializer.getInt32();
        }
        return downloadInfo;
    }

    public static DownloadInfo[] getOptionalDownloadInfoVarArray(IDeserializer iDeserializer) {
        DownloadInfo[] downloadInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            downloadInfoArray = new DownloadInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                downloadInfoArray[i2] = DownloadInfoSerializer.getOptionalDownloadInfo(iDeserializer);
            }
        }
        return downloadInfoArray;
    }
}

