/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.zip.Adler32;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

final class Compression {
    private static final byte HEADER_ZIP_1;
    private static final byte HEADER_ZIP_2;
    private static final byte HEADER_ZIP_3;
    private static final byte HEADER_ZIP_4;
    private static final byte HEADER_ADLER_1;
    private static final byte HEADER_ADLER_2;
    private static final byte HEADER_ADLER_3;
    private static final byte HEADER_ADLER_4;
    private static final int HEADERLEN;
    private static final int MINLEN;

    private Compression() {
    }

    static boolean isCompressed(byte[] byArray) {
        return byArray != null && byArray.length > 4 && byArray[0] == 11 && byArray[1] == 22 && byArray[2] == 33 && byArray[3] == 44;
    }

    static boolean isAdler(byte[] byArray) {
        return byArray != null && byArray.length > 4 && byArray[0] == 55 && byArray[1] == 66 && byArray[2] == 77 && byArray[3] == 88;
    }

    static byte[] addAdler(byte[] byArray) {
        if (byArray != null && byArray.length > 4 && !Compression.isAdler(byArray)) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.write(55);
                dataOutputStream.write(66);
                dataOutputStream.write(77);
                dataOutputStream.write(88);
                Adler32 adler32 = new Adler32();
                adler32.update(byArray);
                long l = adler32.getValue();
                dataOutputStream.writeLong(l);
                dataOutputStream.write(byArray);
                dataOutputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return byArray;
    }

    static byte[] removeAdler(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        if (!Compression.isAdler(byArray)) {
            return byArray;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray, 4, byArray.length - 4);
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            long l = dataInputStream.readLong();
            dataInputStream.close();
            byteArrayInputStream.close();
            Adler32 adler32 = new Adler32();
            int n = byArray.length - 4 - 8;
            adler32.update(byArray, 12, n);
            if (l == adler32.getValue()) {
                byte[] byArray2 = new byte[n];
                System.arraycopy((Object)byArray, 12, (Object)byArray2, 0, n);
                return byArray2;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }

    static byte[] compress(byte[] byArray) {
        if (byArray != null && byArray.length >= 50) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(11);
                byteArrayOutputStream.write(22);
                byteArrayOutputStream.write(33);
                byteArrayOutputStream.write(44);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                DataOutputStream dataOutputStream = new DataOutputStream(gZIPOutputStream);
                dataOutputStream.writeInt(byArray.length);
                dataOutputStream.write(byArray);
                dataOutputStream.close();
                byteArrayOutputStream.close();
                byte[] byArray2 = byteArrayOutputStream.toByteArray();
                if (byArray2 != null && byArray2.length < byArray.length) {
                    return byArray2;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return byArray;
    }

    static byte[] uncompress(byte[] byArray) {
        if (Compression.isCompressed(byArray)) {
            try {
                int n;
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray, 4, byArray.length - 4);
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                DataInputStream dataInputStream = new DataInputStream(gZIPInputStream);
                int n2 = dataInputStream.readInt();
                byte[] byArray2 = new byte[n2];
                int n3 = 0;
                do {
                    int n4;
                    if ((n = dataInputStream.read(byArray2, n3, n4 = Math.min(1000, n2 - n3))) <= 0) continue;
                    n3 += n;
                } while (n > 0 && n3 < n2);
                dataInputStream.close();
                byteArrayInputStream.close();
                return byArray2;
            }
            catch (Exception exception) {
                PersDebug.warn("Persistence: Error Uncompressing byte array");
                return null;
            }
        }
        return byArray;
    }
}

