/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.VersionInfo;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class VersionInfoSerializer {
    public static void putOptionalVersionInfo(ISerializer iSerializer, VersionInfo versionInfo) {
        boolean bl = versionInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = versionInfo.getVersion();
            iSerializer.putInt32(n);
            int n2 = versionInfo.getProfileId();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalVersionInfoVarArray(ISerializer iSerializer, VersionInfo[] versionInfoArray) {
        boolean bl = versionInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(versionInfoArray.length);
            for (int i2 = 0; i2 < versionInfoArray.length; ++i2) {
                VersionInfoSerializer.putOptionalVersionInfo(iSerializer, versionInfoArray[i2]);
            }
        }
    }

    public static VersionInfo getOptionalVersionInfo(IDeserializer iDeserializer) {
        VersionInfo versionInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            versionInfo = new VersionInfo();
            versionInfo.version = n2 = iDeserializer.getInt32();
            versionInfo.profileId = n = iDeserializer.getInt32();
        }
        return versionInfo;
    }

    public static VersionInfo[] getOptionalVersionInfoVarArray(IDeserializer iDeserializer) {
        VersionInfo[] versionInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            versionInfoArray = new VersionInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                versionInfoArray[i2] = VersionInfoSerializer.getOptionalVersionInfo(iDeserializer);
            }
        }
        return versionInfoArray;
    }
}

