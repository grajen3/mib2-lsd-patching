/*
 * Decompiled with CFR 0.152.
 */
package java.io;

public final class FileDescriptor {
    public static final FileDescriptor in = new FileDescriptor();
    public static final FileDescriptor out = new FileDescriptor();
    public static final FileDescriptor err = new FileDescriptor();
    long descriptor = -1L;

    static {
        FileDescriptor.in.descriptor = 0L;
        FileDescriptor.out.descriptor = 1L;
        FileDescriptor.err.descriptor = 0;
        FileDescriptor.oneTimeInitialization();
    }

    private static native void oneTimeInitialization() {
    }

    public native void sync() {
    }

    public native boolean valid() {
    }
}

