/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.codec;

import de.vw.mib.codec.ByteArrayDecoder;
import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.codec.ByteStreamDecoder;
import java.io.DataInputStream;

public final class ByteArrayCodec {
    public static final byte TYPE_HEADER;
    public static final byte TYPE_BOOLEAN;
    public static final byte TYPE_CHAR;
    public static final byte TYPE_DOUBLE;
    public static final byte TYPE_FLOAT;
    public static final byte TYPE_INTEGER;
    public static final byte TYPE_LONG;
    public static final byte TYPE_STRING;
    public static final byte TYPE_NULL;
    public static final byte TYPE_ID;
    public static final byte TYPE_OBJECT;
    public static final byte TYPE_THROWABLE;
    public static final byte TYPE_END_OF_MESSAGE;
    public static final byte TYPE_INVOCATION_CONTEXT;
    private static ByteArrayReader defaultReader;

    public static synchronized void decode(byte[] byArray, ByteArrayDecoder byteArrayDecoder) {
        if (defaultReader == null) {
            defaultReader = new ByteArrayReader(byArray);
        } else {
            defaultReader.reset(byArray);
        }
        ByteArrayCodec.decode(defaultReader, byteArrayDecoder);
    }

    public static void decode(ByteArrayReader byteArrayReader, ByteArrayDecoder byteArrayDecoder) {
        int n = byteArrayReader.read();
        while (n != -1) {
            switch (n) {
                case 0: {
                    byteArrayDecoder.readHeader(byteArrayReader);
                    break;
                }
                case 1: {
                    byteArrayDecoder.read(byteArrayReader.readBoolean());
                    break;
                }
                case 2: {
                    byteArrayDecoder.read(byteArrayReader.readChar());
                    break;
                }
                case 3: {
                    byteArrayDecoder.read(byteArrayReader.readDouble());
                    break;
                }
                case 4: {
                    byteArrayDecoder.read(byteArrayReader.readFloat());
                    break;
                }
                case 5: {
                    byteArrayDecoder.read(byteArrayReader.readInt());
                    break;
                }
                case 6: {
                    byteArrayDecoder.read(byteArrayReader.readLong());
                    break;
                }
                case 7: {
                    byteArrayDecoder.read(byteArrayReader.readString());
                    break;
                }
                case 8: {
                    byteArrayDecoder.readNull();
                    break;
                }
                case 11: {
                    byteArrayDecoder.readObject(byteArrayReader);
                    break;
                }
                case 12: {
                    int n2 = byteArrayReader.readInt();
                    byte[] byArray = new byte[n2];
                    byteArrayReader.read(byArray, 0, n2);
                    byteArrayDecoder.readStackTrace(new String(byArray));
                    break;
                }
                case 13: {
                    byteArrayDecoder.finish();
                    return;
                }
                case 14: {
                    byteArrayDecoder.readInvocationContext(byteArrayReader);
                    break;
                }
            }
            n = byteArrayReader.read();
        }
    }

    public static void decode(DataInputStream dataInputStream, ByteStreamDecoder byteStreamDecoder) {
        int n = dataInputStream.read();
        while (n != -1) {
            switch (n) {
                case 0: {
                    byteStreamDecoder.readHeader(dataInputStream);
                    break;
                }
                case 1: {
                    byteStreamDecoder.read(dataInputStream.readBoolean());
                    break;
                }
                case 2: {
                    byteStreamDecoder.read(dataInputStream.readChar());
                    break;
                }
                case 3: {
                    byteStreamDecoder.read(dataInputStream.readDouble());
                    break;
                }
                case 4: {
                    byteStreamDecoder.read(dataInputStream.readFloat());
                    break;
                }
                case 5: {
                    byteStreamDecoder.read(dataInputStream.readInt());
                    break;
                }
                case 6: {
                    byteStreamDecoder.read(dataInputStream.readLong());
                    break;
                }
                case 7: {
                    int n2 = dataInputStream.readInt();
                    Object[] objectArray = new char[n2];
                    for (int i2 = 0; i2 < n2; ++i2) {
                        objectArray[i2] = dataInputStream.readChar();
                    }
                    byteStreamDecoder.read(new String((char[])objectArray));
                    break;
                }
                case 8: {
                    byteStreamDecoder.readNull();
                    break;
                }
                case 11: {
                    byteStreamDecoder.readObject(dataInputStream);
                    break;
                }
                case 12: {
                    int n2 = dataInputStream.readInt();
                    Object[] objectArray = new byte[n2];
                    dataInputStream.read((byte[])objectArray, 0, n2);
                    byteStreamDecoder.readStackTrace(new String((byte[])objectArray));
                    break;
                }
                case 13: {
                    byteStreamDecoder.finish();
                    break;
                }
                case 14: {
                    byteStreamDecoder.readInvocationContext(dataInputStream);
                    break;
                }
            }
            n = dataInputStream.read();
        }
    }

    private ByteArrayCodec() {
    }
}

