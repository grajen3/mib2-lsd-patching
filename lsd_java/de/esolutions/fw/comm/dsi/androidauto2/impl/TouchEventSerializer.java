/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto2.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto2.TouchEvent;

public class TouchEventSerializer {
    public static void putOptionalTouchEvent(ISerializer iSerializer, TouchEvent touchEvent) {
        boolean bl = touchEvent == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = touchEvent.getX();
            iSerializer.putInt32(n);
            int n2 = touchEvent.getY();
            iSerializer.putInt32(n2);
            int n3 = touchEvent.getPointerID();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalTouchEventVarArray(ISerializer iSerializer, TouchEvent[] touchEventArray) {
        boolean bl = touchEventArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(touchEventArray.length);
            for (int i2 = 0; i2 < touchEventArray.length; ++i2) {
                TouchEventSerializer.putOptionalTouchEvent(iSerializer, touchEventArray[i2]);
            }
        }
    }

    public static TouchEvent getOptionalTouchEvent(IDeserializer iDeserializer) {
        TouchEvent touchEvent = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            touchEvent = new TouchEvent();
            touchEvent.x = n3 = iDeserializer.getInt32();
            touchEvent.y = n2 = iDeserializer.getInt32();
            touchEvent.pointerID = n = iDeserializer.getInt32();
        }
        return touchEvent;
    }

    public static TouchEvent[] getOptionalTouchEventVarArray(IDeserializer iDeserializer) {
        TouchEvent[] touchEventArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            touchEventArray = new TouchEvent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                touchEventArray[i2] = TouchEventSerializer.getOptionalTouchEvent(iDeserializer);
            }
        }
        return touchEventArray;
    }
}

