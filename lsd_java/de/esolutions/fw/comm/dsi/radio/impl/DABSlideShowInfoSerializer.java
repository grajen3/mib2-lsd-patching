/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.DABSlideShowInfo;

public class DABSlideShowInfoSerializer {
    public static void putOptionalDABSlideShowInfo(ISerializer iSerializer, DABSlideShowInfo dABSlideShowInfo) {
        boolean bl = dABSlideShowInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dABSlideShowInfo.getEnsID();
            iSerializer.putInt32(n);
            int n2 = dABSlideShowInfo.getEnsECC();
            iSerializer.putInt32(n2);
            int n3 = dABSlideShowInfo.getSID();
            iSerializer.putInt32(n3);
            int n4 = dABSlideShowInfo.getSCIDI();
            iSerializer.putInt32(n4);
            ResourceLocator resourceLocator = dABSlideShowInfo.getSlideshowImage();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            int n5 = dABSlideShowInfo.getCategory();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalDABSlideShowInfoVarArray(ISerializer iSerializer, DABSlideShowInfo[] dABSlideShowInfoArray) {
        boolean bl = dABSlideShowInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dABSlideShowInfoArray.length);
            for (int i2 = 0; i2 < dABSlideShowInfoArray.length; ++i2) {
                DABSlideShowInfoSerializer.putOptionalDABSlideShowInfo(iSerializer, dABSlideShowInfoArray[i2]);
            }
        }
    }

    public static DABSlideShowInfo getOptionalDABSlideShowInfo(IDeserializer iDeserializer) {
        DABSlideShowInfo dABSlideShowInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            ResourceLocator resourceLocator;
            int n2;
            int n3;
            int n4;
            int n5;
            dABSlideShowInfo = new DABSlideShowInfo();
            dABSlideShowInfo.ensID = n5 = iDeserializer.getInt32();
            dABSlideShowInfo.ensECC = n4 = iDeserializer.getInt32();
            dABSlideShowInfo.sID = n3 = iDeserializer.getInt32();
            dABSlideShowInfo.sCIDI = n2 = iDeserializer.getInt32();
            dABSlideShowInfo.slideshowImage = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            dABSlideShowInfo.category = n = iDeserializer.getInt32();
        }
        return dABSlideShowInfo;
    }

    public static DABSlideShowInfo[] getOptionalDABSlideShowInfoVarArray(IDeserializer iDeserializer) {
        DABSlideShowInfo[] dABSlideShowInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dABSlideShowInfoArray = new DABSlideShowInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dABSlideShowInfoArray[i2] = DABSlideShowInfoSerializer.getOptionalDABSlideShowInfo(iDeserializer);
            }
        }
        return dABSlideShowInfoArray;
    }
}

