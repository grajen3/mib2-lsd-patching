/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tvtuner.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.tvtuner.LogoInfo;

public class LogoInfoSerializer {
    public static void putOptionalLogoInfo(ISerializer iSerializer, LogoInfo logoInfo) {
        boolean bl = logoInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = logoInfo.getNamePID();
            iSerializer.putInt64(l);
            ResourceLocator resourceLocator = logoInfo.getChannelLogo();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalLogoInfoVarArray(ISerializer iSerializer, LogoInfo[] logoInfoArray) {
        boolean bl = logoInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(logoInfoArray.length);
            for (int i2 = 0; i2 < logoInfoArray.length; ++i2) {
                LogoInfoSerializer.putOptionalLogoInfo(iSerializer, logoInfoArray[i2]);
            }
        }
    }

    public static LogoInfo getOptionalLogoInfo(IDeserializer iDeserializer) {
        LogoInfo logoInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            long l;
            logoInfo = new LogoInfo();
            logoInfo.namePID = l = iDeserializer.getInt64();
            logoInfo.channelLogo = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return logoInfo;
    }

    public static LogoInfo[] getOptionalLogoInfoVarArray(IDeserializer iDeserializer) {
        LogoInfo[] logoInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            logoInfoArray = new LogoInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                logoInfoArray[i2] = LogoInfoSerializer.getOptionalLogoInfo(iDeserializer);
            }
        }
        return logoInfoArray;
    }
}

