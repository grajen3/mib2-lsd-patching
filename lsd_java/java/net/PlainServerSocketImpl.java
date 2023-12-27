/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.FileDescriptor;
import java.net.PlainSocketImpl;
import java.net.Socket;

class PlainServerSocketImpl
extends PlainSocketImpl {
    PlainServerSocketImpl() {
    }

    static native void createServerStreamSocketImpl(FileDescriptor fileDescriptor, boolean bl) {
    }

    @Override
    protected void create(boolean bl) {
        PlainServerSocketImpl.createServerStreamSocketImpl(this.fd, Socket.preferIPv4Stack());
    }
}

