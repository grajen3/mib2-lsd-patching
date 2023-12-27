/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.FileDescriptor;
import java.net.InetAddress;
import java.net.PlainSocketImpl;
import java.net.Socket;

class PlainSocketImpl2
extends PlainSocketImpl {
    PlainSocketImpl2() {
    }

    static native void createStreamSocketImpl2(FileDescriptor fileDescriptor, boolean bl) {
    }

    static native void connectStreamSocketImpl2(FileDescriptor fileDescriptor, int n, int n2, InetAddress inetAddress) {
    }

    static native void connectStreamWithTimeoutSocketImpl2(FileDescriptor fileDescriptor, int n, int n2, int n3, InetAddress inetAddress) {
    }

    @Override
    protected void create(boolean bl) {
        PlainSocketImpl2.createStreamSocketImpl2(this.fd, Socket.preferIPv4Stack());
    }

    static native int sendDatagramImpl2(FileDescriptor fileDescriptor, byte[] byArray, int n, int n2, int n3, InetAddress inetAddress) {
    }

    static native void socketBindImpl2(FileDescriptor fileDescriptor, int n, InetAddress inetAddress) {
    }
}

