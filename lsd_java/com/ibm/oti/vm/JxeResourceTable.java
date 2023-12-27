/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.JxeResource;
import com.ibm.oti.vm.MemInputStream;
import com.ibm.oti.vm.VM;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

class JxeResourceTable {
    private static final boolean useNative = VM.useNatives();
    private Hashtable pointerTable;
    private InputStream iStream;
    private JxeResource osmEntry;
    private int offset;
    private long pointer;
    private byte[] header = new byte[30];
    private byte[] nameBytes = new byte[16];
    private char[] nameChars = new char[0];
    private static final int LOCHDR;
    private static final int SIG_LOCAL;
    private static final int SIG_CEN;
    private static final int SIG_ENDCEN;

    JxeResourceTable(InputStream inputStream) {
        this.iStream = inputStream;
    }

    JxeResourceTable(MemInputStream memInputStream) {
        this.iStream = memInputStream;
        this.pointer = memInputStream.getPointer();
        this.readEntries();
    }

    private void readEntries() {
        String string;
        this.offset = 0;
        this.pointerTable = new Hashtable(15);
        while ((string = this.getNext()) != null) {
            int n = this.osmEntry.getSize();
            long l = this.iStream.skip(n);
            this.offset += n;
            if (l != (long)n) {
                throw new IOException(Msg.getString("K01a0"));
            }
            if (string.equals("rom.classes")) continue;
            this.pointerTable.put(string, this.osmEntry);
        }
    }

    JxeResource getResource() {
        return this.osmEntry;
    }

    Hashtable getTable() {
        return this.pointerTable;
    }

    String getNext() {
        String string;
        this.osmEntry = null;
        int n = this.iStream.read(this.header, 0, this.header.length);
        long l = this.getInt(this.header, 0);
        if (0 == l || 0 == l) {
            return null;
        }
        if (0 != l) {
            throw new IOException(Msg.getString("K019c"));
        }
        if (n != 30) {
            throw new IOException(Msg.getString("K01a0"));
        }
        this.offset += n;
        int n2 = this.getShort(this.header, 6);
        int n3 = this.getShort(this.header, 8);
        long l2 = this.getInt(this.header, 18);
        int n4 = this.getShort(this.header, 26);
        int n5 = this.getShort(this.header, 28);
        if (n3 != 0 && 8 != n3) {
            throw new IOException(Msg.getString("K019d"));
        }
        if ((1 & n2) != 0) {
            throw new IOException(Msg.getString("K019e"));
        }
        if ((0x80 & n2) != 0) {
            throw new IOException(Msg.getString("K019f"));
        }
        if (n4 > this.nameBytes.length) {
            this.nameBytes = new byte[n4 + 32];
        }
        if ((n = this.iStream.read(this.nameBytes, 0, n4)) != n4) {
            throw new IOException(Msg.getString("K01a0"));
        }
        this.offset += n4;
        if (useNative) {
            string = Util.convertFromUTF8(this.nameBytes, 0, n4);
        } else {
            if (this.nameChars.length < this.nameBytes.length) {
                this.nameChars = new char[this.nameBytes.length];
            }
            string = Util.convertUTF8WithBuf(this.nameBytes, this.nameChars, 0, n4);
        }
        n = (int)this.iStream.skip(n5);
        if (n != n5) {
            throw new IOException(Msg.getString("K01a0"));
        }
        this.offset += n5;
        this.osmEntry = new JxeResource(this.pointer + (long)this.offset, (int)l2, n3);
        return string;
    }

    private long getInt(byte[] byArray, int n) {
        return (long)(((byArray[n + 2] & 0xFF) << 16) + ((byArray[n + 1] & 0xFF) << 8) + (byArray[n] & 0xFF)) + ((long)(byArray[n + 3] & 0xFF) << 24);
    }

    private int getShort(byte[] byArray, int n) {
        return ((byArray[n + 1] & 0xFF) << 8) + (byArray[n] & 0xFF);
    }
}

