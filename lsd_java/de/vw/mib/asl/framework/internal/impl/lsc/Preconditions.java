/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

public final class Preconditions {
    private Preconditions() {
    }

    public static Object checkArgumentNotNull(Object object, String string) {
        if (object == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string);
            Preconditions.correctStackTrace(illegalArgumentException);
            throw illegalArgumentException;
        }
        return object;
    }

    public static Object checkArgumentNotNull(Object object) {
        return Preconditions.checkArgumentNotNull(object, null);
    }

    public static void checkArgument(boolean bl, String string) {
        if (!bl) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string);
            Preconditions.correctStackTrace(illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    public static void checkArgument(boolean bl) {
        Preconditions.checkArgument(bl, null);
    }

    public static void checkState(boolean bl, String string) {
        if (!bl) {
            IllegalStateException illegalStateException = new IllegalStateException(string);
            Preconditions.correctStackTrace(illegalStateException);
            throw illegalStateException;
        }
    }

    public static void checkState(boolean bl) {
        Preconditions.checkState(bl, null);
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

