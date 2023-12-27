/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.http;

import com.ibm.oti.connection.http.Connection;
import java.security.PrivilegedAction;
import java.util.Properties;

final class Connection$1
implements PrivilegedAction {
    final /* synthetic */ Connection this$0;
    private final /* synthetic */ String[] val$proxyValues;

    Connection$1(Connection connection, String[] stringArray) {
        this.this$0 = connection;
        this.val$proxyValues = stringArray;
    }

    @Override
    public Object run() {
        Properties properties = System.getProperties();
        properties.setProperty("http.proxyHost", this.this$0.proxyName);
        properties.setProperty("http.proxyPort", this.val$proxyValues[1]);
        return null;
    }
}

