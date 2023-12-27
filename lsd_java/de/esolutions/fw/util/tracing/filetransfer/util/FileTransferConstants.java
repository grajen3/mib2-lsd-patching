/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.util;

public class FileTransferConstants {
    public static byte HASH_TYPE_NONE = 0;
    public static byte HASH_TYPE_MD5 = 1;
    public static byte HASH_TYPE_SHA1 = (byte)2;
    public static byte OPERATION_DOWNLOAD = 0;
    public static byte OPERATION_UPLOAD = 1;
    public static byte OPERATION_STATUS = (byte)2;
    public static byte FLAG_STATUS_AVAILABLE = 1;
    public static byte FLAG_STATUS_IS_FILE = (byte)2;
    public static byte FLAG_STATUS_READABLE = (byte)4;
    public static byte FLAG_STATUS_ERROR = (byte)8;
    public static byte FLAG_TRANSFER_FIRST_BLOCK = 1;
    public static byte FLAG_TRANSFER_LAST_BLOCK = (byte)2;
    public static byte FLAG_NOTHING_SET = 0;
    public static byte FLAG_FILE_UPLOAD = (byte)16;
    public static byte TRANSFER_FILE_MEMORY = 1;
    public static byte TRANSFER_FILE_REAL = (byte)2;
    public static byte FLAG_USER_UPLOAD = (byte)64;
}

