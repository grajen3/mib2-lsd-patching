/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.util;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class NIO {
    private static boolean BYTEBUFFER_HAS_ORDER = false;
    static /* synthetic */ Class class$java$nio$ByteBuffer;

    private NIO() {
    }

    public static ByteBuffer createJavaByteBuffer(byte[] byArray) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray);
        if (BYTEBUFFER_HAS_ORDER) {
            byteBuffer.order(ByteOrder.nativeOrder());
        }
        return byteBuffer;
    }

    public static ByteBuffer createJavaByteBuffer(int n) {
        return NIO.createJavaByteBuffer(new byte[n]);
    }

    public static ByteBuffer createNativeByteBuffer(int n) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n);
        if (BYTEBUFFER_HAS_ORDER) {
            byteBuffer.order(ByteOrder.nativeOrder());
        }
        return byteBuffer;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        try {
            Method method;
            Class clazz = Class.forName("java.nio.ByteOrder");
            if (clazz != null && (method = (class$java$nio$ByteBuffer == null ? (class$java$nio$ByteBuffer = NIO.class$("java.nio.ByteBuffer")) : class$java$nio$ByteBuffer).getMethod("order", new Class[]{clazz})) != null) {
                BYTEBUFFER_HAS_ORDER = true;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
    }
}

