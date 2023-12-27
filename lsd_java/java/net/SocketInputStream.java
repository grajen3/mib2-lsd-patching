/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketImpl;

class SocketInputStream
extends InputStream {
    SocketImpl socket;

    public SocketInputStream(SocketImpl socketImpl) {
        this.socket = socketImpl;
    }

    @Override
    public int available() {
        return this.socket.available();
    }

    @Override
    public void close() {
        this.socket.close();
        super.close();
    }

    @Override
    public int read() {
        byte[] byArray = new byte[1];
        int n = this.socket.read(byArray, 0, 1);
        return -1 == n ? n : byArray[0] & 0xFF;
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (byArray == null) {
            throw new IOException(Msg.getString("K0047"));
        }
        if (n2 == 0) {
            return 0;
        }
        if (n < 0 || n >= byArray.length) {
            throw new ArrayIndexOutOfBoundsException(Msg.getString("K002e"));
        }
        if (n2 < 0 || n + n2 > byArray.length) {
            throw new ArrayIndexOutOfBoundsException(Msg.getString("K002f"));
        }
        return this.socket.read(byArray, n, n2);
    }

    @Override
    public long skip(long l) {
        return 0L == l ? 0L : super.skip(l);
    }
}

