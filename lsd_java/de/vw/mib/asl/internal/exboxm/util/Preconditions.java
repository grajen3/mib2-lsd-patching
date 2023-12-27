/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.util;

public class Preconditions {
    public static Object checkArgumentNotNull(Object object, String string) {
        if (object == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string);
            Preconditions.correctStackTrace(illegalArgumentException);
            throw illegalArgumentException;
        }
        return object;
    }

    private static void correctStackTrace(RuntimeException runtimeException) {
        boolean bl = true;
        StackTraceElement[] stackTraceElementArray = runtimeException.getStackTrace();
        if (stackTraceElementArray == null || stackTraceElementArray.length < 1) {
            return;
        }
        StackTraceElement[] stackTraceElementArray2 = new StackTraceElement[stackTraceElementArray.length - 1];
        System.arraycopy((Object)stackTraceElementArray, 1, (Object)stackTraceElementArray2, 0, stackTraceElementArray2.length);
        runtimeException.setStackTrace(stackTraceElementArray2);
    }
}

