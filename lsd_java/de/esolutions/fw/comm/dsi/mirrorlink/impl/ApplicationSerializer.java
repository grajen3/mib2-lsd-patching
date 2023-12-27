/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.mirrorlink.Application;

public class ApplicationSerializer {
    public static void putOptionalApplication(ISerializer iSerializer, Application application) {
        boolean bl = application == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = application.getAppID();
            iSerializer.putInt32(n);
            String string = application.getAppName();
            iSerializer.putOptionalString(string);
            int n2 = application.getAppCategory();
            iSerializer.putInt32(n2);
            ResourceLocator resourceLocator = application.getAppIcon();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            int n3 = application.getCertType();
            iSerializer.putInt32(n3);
            int n4 = application.getNotLaunchableReason();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalApplicationVarArray(ISerializer iSerializer, Application[] applicationArray) {
        boolean bl = applicationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(applicationArray.length);
            for (int i2 = 0; i2 < applicationArray.length; ++i2) {
                ApplicationSerializer.putOptionalApplication(iSerializer, applicationArray[i2]);
            }
        }
    }

    public static Application getOptionalApplication(IDeserializer iDeserializer) {
        Application application = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            ResourceLocator resourceLocator;
            int n3;
            String string;
            int n4;
            application = new Application();
            application.appID = n4 = iDeserializer.getInt32();
            application.appName = string = iDeserializer.getOptionalString();
            application.appCategory = n3 = iDeserializer.getInt32();
            application.appIcon = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            application.certType = n2 = iDeserializer.getInt32();
            application.notLaunchableReason = n = iDeserializer.getInt32();
        }
        return application;
    }

    public static Application[] getOptionalApplicationVarArray(IDeserializer iDeserializer) {
        Application[] applicationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            applicationArray = new Application[n];
            for (int i2 = 0; i2 < n; ++i2) {
                applicationArray[i2] = ApplicationSerializer.getOptionalApplication(iDeserializer);
            }
        }
        return applicationArray;
    }
}

