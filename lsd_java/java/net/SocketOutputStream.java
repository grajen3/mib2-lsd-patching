/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import java.io.OutputStream;
import java.net.SocketImpl;

class SocketOutputStream
extends OutputStream {
    SocketImpl socket;

    public SocketOutputStream(SocketImpl socketImpl) {
        this.socket = socketImpl;
    }

    @Override
    public void close() {
        this.socket.close();
        super.close();
    }

    @Override
    public void write(byte[] byArray) {
        this.socket.write(byArray, 0, byArray.length);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (byArray != null) {
            if (n < 0 || n > byArray.length || n2 < 0 || n2 > byArray.length - n) {
                throw new ArrayIndexOutOfBoundsException(Msg.getString("K002f"));
            }
        } else {
            throw new NullPointerException(Msg.getString("K0047"));
        }
        this.socket.write(byArray, n, n2);
    }

    @Override
    public void write(int n) {
        byte[] byArray = new byte[]{(byte)(n & 0xFF)};
        this.socket.write(byArray, 0, 1);
    }
}

