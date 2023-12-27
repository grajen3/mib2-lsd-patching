/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.diag.PrintUtils$ValueGetter;
import de.esolutions.fw.util.commons.Buffer;

public class PrintUtils {
    public static void printArrayToBuffer(Buffer buffer, Object[] objectArray, PrintUtils$ValueGetter printUtils$ValueGetter) {
        buffer.append("[ ");
        if (objectArray == null) {
            buffer.append("]");
        } else {
            boolean bl = true;
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (bl) {
                    bl = false;
                } else {
                    buffer.append(", ");
                }
                Object object = printUtils$ValueGetter.getValue(objectArray[i2]);
                if (object == null) {
                    buffer.append("<null>");
                    continue;
                }
                buffer.append(object.toString());
            }
            buffer.append(" ]");
        }
    }
}

