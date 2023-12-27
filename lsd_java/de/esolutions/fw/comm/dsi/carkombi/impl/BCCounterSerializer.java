/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCCounter;

public class BCCounterSerializer {
    public static void putOptionalBCCounter(ISerializer iSerializer, BCCounter bCCounter) {
        boolean bl = bCCounter == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCCounter.getState();
            iSerializer.putInt32(n);
            int n2 = bCCounter.getValue();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalBCCounterVarArray(ISerializer iSerializer, BCCounter[] bCCounterArray) {
        boolean bl = bCCounterArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCCounterArray.length);
            for (int i2 = 0; i2 < bCCounterArray.length; ++i2) {
                BCCounterSerializer.putOptionalBCCounter(iSerializer, bCCounterArray[i2]);
            }
        }
    }

    public static BCCounter getOptionalBCCounter(IDeserializer iDeserializer) {
        BCCounter bCCounter = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            bCCounter = new BCCounter();
            bCCounter.state = n2 = iDeserializer.getInt32();
            bCCounter.value = n = iDeserializer.getInt32();
        }
        return bCCounter;
    }

    public static BCCounter[] getOptionalBCCounterVarArray(IDeserializer iDeserializer) {
        BCCounter[] bCCounterArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCCounterArray = new BCCounter[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCCounterArray[i2] = BCCounterSerializer.getOptionalBCCounter(iDeserializer);
            }
        }
        return bCCounterArray;
    }
}

