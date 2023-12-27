/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OCUUpdateServiceDecoder {
    protected final byte[] encodingTable = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    protected final byte[] decodingTable = new byte[128];

    protected void initialiseTable() {
        for (int i2 = 0; i2 < this.encodingTable.length; ++i2) {
            this.decodingTable[this.encodingTable[i2]] = (byte)i2;
        }
        this.decodingTable[65] = this.decodingTable[97];
        this.decodingTable[66] = this.decodingTable[98];
        this.decodingTable[67] = this.decodingTable[99];
        this.decodingTable[68] = this.decodingTable[100];
        this.decodingTable[69] = this.decodingTable[101];
        this.decodingTable[70] = this.decodingTable[102];
    }

    private boolean ignore(char c2) {
        return c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == ' ';
    }

    public OCUUpdateServiceDecoder() {
        this.initialiseTable();
    }

    public byte[] decode(byte[] byArray) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.decoder(byArray, 0, byArray.length, byteArrayOutputStream);
        }
        catch (IOException iOException) {
            throw new RuntimeException(new StringBuffer().append("exception decoding Hex string: ").append(iOException).toString());
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int decoder(byte[] byArray, int n, int n2, OutputStream outputStream) {
        int n3;
        int n4 = 0;
        for (n3 = n + n2; n3 > n && this.ignore((char)byArray[n3 - 1]); --n3) {
        }
        int n5 = n;
        while (n5 < n3) {
            while (n5 < n3 && this.ignore((char)byArray[n5])) {
                ++n5;
            }
            byte by = this.decodingTable[byArray[n5++]];
            while (n5 < n3 && this.ignore((char)byArray[n5])) {
                ++n5;
            }
            byte by2 = n5 >= byArray.length ? (byte)0 : this.decodingTable[byArray[n5++]];
            outputStream.write(by << 4 | by2);
            ++n4;
        }
        return n4;
    }
}

