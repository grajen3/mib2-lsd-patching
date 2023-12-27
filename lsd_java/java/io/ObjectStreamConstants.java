/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.SerializablePermission;

public interface ObjectStreamConstants {
    public static final short STREAM_MAGIC;
    public static final short STREAM_VERSION;
    public static final byte TC_BASE;
    public static final byte TC_NULL;
    public static final byte TC_REFERENCE;
    public static final byte TC_CLASSDESC;
    public static final byte TC_OBJECT;
    public static final byte TC_STRING;
    public static final byte TC_ARRAY;
    public static final byte TC_CLASS;
    public static final byte TC_BLOCKDATA;
    public static final byte TC_ENDBLOCKDATA;
    public static final byte TC_RESET;
    public static final byte TC_BLOCKDATALONG;
    public static final byte TC_EXCEPTION;
    public static final byte TC_LONGSTRING;
    public static final byte TC_PROXYCLASSDESC;
    public static final byte TC_MAX;
    public static final int baseWireHandle;
    public static final int PROTOCOL_VERSION_1;
    public static final int PROTOCOL_VERSION_2;
    public static final SerializablePermission SUBCLASS_IMPLEMENTATION_PERMISSION;
    public static final SerializablePermission SUBSTITUTION_PERMISSION;
    public static final byte SC_WRITE_METHOD;
    public static final byte SC_SERIALIZABLE;
    public static final byte SC_EXTERNALIZABLE;
    public static final byte SC_BLOCK_DATA;

    static {
        SUBCLASS_IMPLEMENTATION_PERMISSION = new SerializablePermission("enableSubclassImplementation");
        SUBSTITUTION_PERMISSION = new SerializablePermission("enableSubstitution");
    }
}

