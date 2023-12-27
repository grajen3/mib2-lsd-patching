/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Point;

public class PointSerializer {
    public static void putOptionalPoint(ISerializer iSerializer, Point point) {
        boolean bl = point == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = point.getXPos();
            iSerializer.putInt32(n);
            int n2 = point.getYPos();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalPointVarArray(ISerializer iSerializer, Point[] pointArray) {
        boolean bl = pointArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pointArray.length);
            for (int i2 = 0; i2 < pointArray.length; ++i2) {
                PointSerializer.putOptionalPoint(iSerializer, pointArray[i2]);
            }
        }
    }

    public static Point getOptionalPoint(IDeserializer iDeserializer) {
        Point point = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            point = new Point();
            point.xPos = n2 = iDeserializer.getInt32();
            point.yPos = n = iDeserializer.getInt32();
        }
        return point;
    }

    public static Point[] getOptionalPointVarArray(IDeserializer iDeserializer) {
        Point[] pointArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pointArray = new Point[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pointArray[i2] = PointSerializer.getOptionalPoint(iDeserializer);
            }
        }
        return pointArray;
    }
}

