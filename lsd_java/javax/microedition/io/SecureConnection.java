/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import javax.microedition.io.SecurityInfo;
import javax.microedition.io.SocketConnection;

public interface SecureConnection
extends SocketConnection {
    default public SecurityInfo getSecurityInfo() {
    }
}

