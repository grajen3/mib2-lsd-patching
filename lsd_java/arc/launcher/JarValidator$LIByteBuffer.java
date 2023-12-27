/*
 * Decompiled with CFR 0.152.
 */
package arc.launcher;

public class JarValidator$LIByteBuffer {
    int pos;
    byte[] buf;

    private JarValidator$LIByteBuffer(byte[] byArray) {
        this.buf = byArray;
    }

    public static JarValidator$LIByteBuffer wrap(byte[] byArray) {
        return new JarValidator$LIByteBuffer(byArray);
    }

    public static JarValidator$LIByteBuffer allocate(int n) {
        return new JarValidator$LIByteBuffer(new byte[n]);
    }

    public byte[] array() {
        return this.buf;
    }

    public void position(int n) {
        this.pos = n;
    }

    public byte get() {
        return this.buf[this.pos++];
    }

    public void put(byte[] byArray) {
        int n = byArray.length;
        int n2 = 0;
        while (n2 < n) {
            this.buf[this.pos++] = byArray[n2];
            ++n2;
        }
    }

    public short getShort() {
        int n = this.buf[this.pos++] & 0xFF;
        int n2 = this.buf[this.pos++] & 0xFF;
        return (short)((n2 << 8) + (n << 0));
    }

    public void putShort(short s) {
        this.buf[this.pos++] = (byte)(s >>> 0 & 0xFF);
        this.buf[this.pos++] = (byte)(s >>> 8 & 0xFF);
    }

    public int getInt() {
        int n = this.buf[this.pos++] & 0xFF;
        int n2 = this.buf[this.pos++] & 0xFF;
        int n3 = this.buf[this.pos++] & 0xFF;
        int n4 = this.buf[this.pos++] & 0xFF;
        return (n4 << 24) + (n3 << 16) + (n2 << 8) + (n << 0);
    }

    public void putInt(int n) {
        this.buf[this.pos++] = (byte)(n >>> 0 & 0xFF);
        this.buf[this.pos++] = (byte)(n >>> 8 & 0xFF);
        this.buf[this.pos++] = (byte)(n >>> 16 & 0xFF);
        this.buf[this.pos++] = (byte)(n >>> 24 & 0xFF);
    }
}

