/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.FileDescriptor;
import java.net.PlainDatagramSocketImpl;
import java.net.Socket;

class PlainMulticastSocketImpl
extends PlainDatagramSocketImpl {
    PlainMulticastSocketImpl() {
    }

    static native void createMulticastSocketImpl(FileDescriptor fileDescriptor, boolean bl) {
    }

    @Override
    protected void create() {
        PlainMulticastSocketImpl.createMulticastSocketImpl(this.fd, Socket.preferIPv4Stack());
        this.reuseAddr = true;
    }
}

