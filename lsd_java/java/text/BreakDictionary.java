/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.text.CompactByteArray;
import com.ibm.oti.util.Msg;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.MissingResourceException;

class BreakDictionary {
    private char[] reverseColumnMap = null;
    private static int supportedVersion = 0;
    private int version;
    private CompactByteArray columnMap = null;
    private int numCols;
    private int numColGroups;
    private short[] table = null;
    private short[] rowIndex = null;
    private int[] rowIndexFlags = null;
    private short[] rowIndexFlagsIndex = null;
    private byte[] rowIndexShifts = null;

    public BreakDictionary(InputStream inputStream) {
        this.readDictionaryFile(new DataInputStream(inputStream));
    }

    public void readDictionaryFile(DataInputStream dataInputStream) {
        this.version = dataInputStream.readInt();
        if (this.version != supportedVersion) {
            throw new MissingResourceException(Msg.getString("K000f", this.version), dataInputStream.toString(), "");
        }
        int n = dataInputStream.readInt();
        short[] sArray = new short[n];
        int n2 = 0;
        while (n2 < sArray.length) {
            sArray[n2] = dataInputStream.readShort();
            ++n2;
        }
        n = dataInputStream.readInt();
        byte[] byArray = new byte[n];
        char c2 = '\u0000';
        while (c2 < byArray.length) {
            byArray[c2] = dataInputStream.readByte();
            ++c2;
        }
        this.columnMap = new CompactByteArray(sArray, byArray);
        this.numCols = dataInputStream.readInt();
        this.numColGroups = dataInputStream.readInt();
        n = dataInputStream.readInt();
        this.rowIndex = new short[1];
        c2 = '\u0000';
        while (c2 < this.rowIndex.length) {
            this.rowIndex[c2] = dataInputStream.readShort();
            ++c2;
        }
        n = dataInputStream.readInt();
        this.rowIndexFlagsIndex = new short[n];
        c2 = '\u0000';
        while (c2 < this.rowIndexFlagsIndex.length) {
            this.rowIndexFlagsIndex[c2] = dataInputStream.readShort();
            ++c2;
        }
        n = dataInputStream.readInt();
        this.rowIndexFlags = new int[1];
        c2 = '\u0000';
        while (c2 < this.rowIndexFlags.length) {
            this.rowIndexFlags[c2] = dataInputStream.readInt();
            ++c2;
        }
        n = dataInputStream.readInt();
        this.rowIndexShifts = new byte[1];
        c2 = '\u0000';
        while (c2 < this.rowIndexShifts.length) {
            this.rowIndexShifts[c2] = dataInputStream.readByte();
            ++c2;
        }
        n = dataInputStream.readInt();
        this.table = new short[n];
        c2 = '\u0000';
        while (c2 < this.table.length) {
            this.table[c2] = dataInputStream.readShort();
            ++c2;
        }
        this.reverseColumnMap = new char[this.numCols];
        c2 = '\u0000';
        while (c2 < '\uffff0000') {
            byte by = this.columnMap.elementAt(c2);
            if (by != 0) {
                this.reverseColumnMap[by] = c2;
            }
            c2 = (char)(c2 + '\u0001');
        }
        dataInputStream.close();
    }

    public final short at(int n, char c2) {
        byte by = this.columnMap.elementAt(c2);
        return this.at(n, by);
    }

    public final short at(int n, int n2) {
        if (this.cellIsPopulated(n, n2)) {
            return this.internalAt(this.rowIndex[n], n2 + this.rowIndexShifts[n]);
        }
        return 0;
    }

    private final boolean cellIsPopulated(int n, int n2) {
        if (this.rowIndexFlagsIndex[n] < 0) {
            return n2 == -this.rowIndexFlagsIndex[n];
        }
        int n3 = this.rowIndexFlags[this.rowIndexFlagsIndex[n] + (n2 >> 5)];
        return (n3 & 1 << (n2 & 0x1F)) != 0;
    }

    private final short internalAt(int n, int n2) {
        return this.table[n * this.numCols + n2];
    }
}

