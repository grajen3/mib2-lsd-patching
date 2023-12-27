/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import javax.microedition.io.HttpConnection;
import javax.microedition.io.SecurityInfo;

public interface HttpsConnection
extends HttpConnection {
    @Override
    default public int getPort() {
    }

    default public SecurityInfo getSecurityInfo() {
    }
}

