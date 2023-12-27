/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.http;

import com.ibm.oti.net.www.protocol.http.HttpURLConnection;
import java.security.PrivilegedAction;
import java.util.Properties;

final class HttpURLConnection$2
implements PrivilegedAction {
    final /* synthetic */ HttpURLConnection this$0;
    private final /* synthetic */ String[] val$proxyValues;

    HttpURLConnection$2(HttpURLConnection httpURLConnection, String[] stringArray) {
        this.this$0 = httpURLConnection;
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

