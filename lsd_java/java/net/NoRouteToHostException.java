/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.SocketException;

public class NoRouteToHostException
extends SocketException {
    public NoRouteToHostException() {
    }

    public NoRouteToHostException(String string) {
        super(string);
    }
}

