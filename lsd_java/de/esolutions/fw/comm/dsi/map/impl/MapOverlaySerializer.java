/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavRectangleSerializer;
import de.esolutions.fw.comm.dsi.map.impl.RectSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.MapOverlay;
import org.dsi.ifc.map.Rect;

public class MapOverlaySerializer {
    public static void putOptionalMapOverlay(ISerializer iSerializer, MapOverlay mapOverlay) {
        boolean bl = mapOverlay == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = mapOverlay.getPath();
            iSerializer.putOptionalString(string);
            NavRectangle navRectangle = mapOverlay.getRectangle();
            NavRectangleSerializer.putOptionalNavRectangle(iSerializer, navRectangle);
            String string2 = mapOverlay.getDescription();
            iSerializer.putOptionalString(string2);
            Rect rect = mapOverlay.getTextFieldBoundingBox();
            RectSerializer.putOptionalRect(iSerializer, rect);
        }
    }

    public static void putOptionalMapOverlayVarArray(ISerializer iSerializer, MapOverlay[] mapOverlayArray) {
        boolean bl = mapOverlayArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mapOverlayArray.length);
            for (int i2 = 0; i2 < mapOverlayArray.length; ++i2) {
                MapOverlaySerializer.putOptionalMapOverlay(iSerializer, mapOverlayArray[i2]);
            }
        }
    }

    public static MapOverlay getOptionalMapOverlay(IDeserializer iDeserializer) {
        MapOverlay mapOverlay = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            Rect rect;
            String string;
            NavRectangle navRectangle;
            String string2;
            mapOverlay = new MapOverlay();
            mapOverlay.path = string2 = iDeserializer.getOptionalString();
            mapOverlay.rectangle = navRectangle = NavRectangleSerializer.getOptionalNavRectangle(iDeserializer);
            mapOverlay.description = string = iDeserializer.getOptionalString();
            mapOverlay.textFieldBoundingBox = rect = RectSerializer.getOptionalRect(iDeserializer);
        }
        return mapOverlay;
    }

    public static MapOverlay[] getOptionalMapOverlayVarArray(IDeserializer iDeserializer) {
        MapOverlay[] mapOverlayArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mapOverlayArray = new MapOverlay[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mapOverlayArray[i2] = MapOverlaySerializer.getOptionalMapOverlay(iDeserializer);
            }
        }
        return mapOverlayArray;
    }
}

