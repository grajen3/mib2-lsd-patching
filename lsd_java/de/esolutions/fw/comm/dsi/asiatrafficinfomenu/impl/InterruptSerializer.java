/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;

public class InterruptSerializer {
    public static void putOptionalInterrupt(ISerializer iSerializer, Interrupt interrupt) {
        boolean bl = interrupt == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = interrupt.getInterruptId();
            iSerializer.putInt32(n);
            int n2 = interrupt.getInterruptType();
            iSerializer.putInt32(n2);
            int[] nArray = interrupt.getContentID();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalInterruptVarArray(ISerializer iSerializer, Interrupt[] interruptArray) {
        boolean bl = interruptArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(interruptArray.length);
            for (int i2 = 0; i2 < interruptArray.length; ++i2) {
                InterruptSerializer.putOptionalInterrupt(iSerializer, interruptArray[i2]);
            }
        }
    }

    public static Interrupt getOptionalInterrupt(IDeserializer iDeserializer) {
        Interrupt interrupt = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            interrupt = new Interrupt();
            interrupt.interruptId = n2 = iDeserializer.getInt32();
            interrupt.interruptType = n = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            interrupt.contentID = nArray;
        }
        return interrupt;
    }

    public static Interrupt[] getOptionalInterruptVarArray(IDeserializer iDeserializer) {
        Interrupt[] interruptArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            interruptArray = new Interrupt[n];
            for (int i2 = 0; i2 < n; ++i2) {
                interruptArray[i2] = InterruptSerializer.getOptionalInterrupt(iDeserializer);
            }
        }
        return interruptArray;
    }
}

