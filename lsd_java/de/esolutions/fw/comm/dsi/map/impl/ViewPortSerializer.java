/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.ViewPort;

public class ViewPortSerializer {
    public static void putOptionalViewPort(ISerializer iSerializer, ViewPort viewPort) {
        boolean bl = viewPort == null;
        iSerializer.putBool(bl);
        if (!bl) {
            NavLocationWgs84 navLocationWgs84 = viewPort.getPosition();
            NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, navLocationWgs84);
            short s = viewPort.getRotation();
            iSerializer.putInt16(s);
            int n = viewPort.getZoomIdx();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalViewPortVarArray(ISerializer iSerializer, ViewPort[] viewPortArray) {
        boolean bl = viewPortArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(viewPortArray.length);
            for (int i2 = 0; i2 < viewPortArray.length; ++i2) {
                ViewPortSerializer.putOptionalViewPort(iSerializer, viewPortArray[i2]);
            }
        }
    }

    public static ViewPort getOptionalViewPort(IDeserializer iDeserializer) {
        ViewPort viewPort = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            short s;
            NavLocationWgs84 navLocationWgs84;
            viewPort = new ViewPort();
            viewPort.position = navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
            viewPort.rotation = s = iDeserializer.getInt16();
            viewPort.zoomIdx = n = iDeserializer.getInt32();
        }
        return viewPort;
    }

    public static ViewPort[] getOptionalViewPortVarArray(IDeserializer iDeserializer) {
        ViewPort[] viewPortArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            viewPortArray = new ViewPort[n];
            for (int i2 = 0; i2 < n; ++i2) {
                viewPortArray[i2] = ViewPortSerializer.getOptionalViewPort(iDeserializer);
            }
        }
        return viewPortArray;
    }
}

