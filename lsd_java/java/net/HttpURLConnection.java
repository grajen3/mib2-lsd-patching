/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.SocketPermission;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;

public abstract class HttpURLConnection
extends URLConnection {
    private String[] methodTokens = new String[]{"GET", "DELETE", "HEAD", "OPTIONS", "POST", "PUT", "TRACE"};
    protected String method = "GET";
    protected int responseCode = -1;
    protected String responseMessage;
    protected boolean instanceFollowRedirects = followRedirects;
    private static boolean followRedirects = true;
    public static final int HTTP_ACCEPTED;
    public static final int HTTP_BAD_GATEWAY;
    public static final int HTTP_BAD_METHOD;
    public static final int HTTP_BAD_REQUEST;
    public static final int HTTP_CLIENT_TIMEOUT;
    public static final int HTTP_CONFLICT;
    public static final int HTTP_CREATED;
    public static final int HTTP_ENTITY_TOO_LARGE;
    public static final int HTTP_FORBIDDEN;
    public static final int HTTP_GATEWAY_TIMEOUT;
    public static final int HTTP_GONE;
    public static final int HTTP_INTERNAL_ERROR;
    public static final int HTTP_LENGTH_REQUIRED;
    public static final int HTTP_MOVED_PERM;
    public static final int HTTP_MOVED_TEMP;
    public static final int HTTP_MULT_CHOICE;
    public static final int HTTP_NO_CONTENT;
    public static final int HTTP_NOT_ACCEPTABLE;
    public static final int HTTP_NOT_AUTHORITATIVE;
    public static final int HTTP_NOT_FOUND;
    public static final int HTTP_NOT_IMPLEMENTED;
    public static final int HTTP_NOT_MODIFIED;
    public static final int HTTP_OK;
    public static final int HTTP_PARTIAL;
    public static final int HTTP_PAYMENT_REQUIRED;
    public static final int HTTP_PRECON_FAILED;
    public static final int HTTP_PROXY_AUTH;
    public static final int HTTP_REQ_TOO_LONG;
    public static final int HTTP_RESET;
    public static final int HTTP_SEE_OTHER;
    public static final int HTTP_USE_PROXY;
    public static final int HTTP_UNAUTHORIZED;
    public static final int HTTP_UNSUPPORTED_TYPE;
    public static final int HTTP_UNAVAILABLE;
    public static final int HTTP_VERSION;

    protected HttpURLConnection(URL uRL) {
        super(uRL);
    }

    public abstract void disconnect() {
    }

    public InputStream getErrorStream() {
        return null;
    }

    public static boolean getFollowRedirects() {
        return followRedirects;
    }

    @Override
    public Permission getPermission() {
        int n = this.url.getPort();
        if (n < 0) {
            n = 80;
        }
        return new SocketPermission(new StringBuffer(String.valueOf(this.url.getHost())).append(":").append(n).toString(), "connect, resolve");
    }

    public String getRequestMethod() {
        return this.method;
    }

    public int getResponseCode() {
        this.getInputStream();
        String string = this.getHeaderField(0);
        if (string == null) {
            return -1;
        }
        string.trim();
        int n = string.indexOf(" ") + 1;
        if (n == 0) {
            return -1;
        }
        int n2 = n + 3;
        if (n2 > string.length()) {
            n2 = string.length();
        }
        this.responseCode = Integer.parseInt(string.substring(n, n2));
        if (n2 + 1 <= string.length()) {
            this.responseMessage = string.substring(n2 + 1);
        }
        return this.responseCode;
    }

    public String getResponseMessage() {
        if (this.responseMessage != null) {
            return this.responseMessage;
        }
        this.getResponseCode();
        return this.responseMessage;
    }

    public static void setFollowRedirects(boolean bl) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSetFactory();
        }
        followRedirects = bl;
    }

    public void setRequestMethod(String string) {
        if (this.connected) {
            throw new ProtocolException(Msg.getString("K0037"));
        }
        int n = 0;
        while (n < this.methodTokens.length) {
            if (this.methodTokens[n].equals(string)) {
                this.method = this.methodTokens[n];
                return;
            }
            ++n;
        }
        throw new ProtocolException();
    }

    public abstract boolean usingProxy() {
    }

    public boolean getInstanceFollowRedirects() {
        return this.instanceFollowRedirects;
    }

    public void setInstanceFollowRedirects(boolean bl) {
        this.instanceFollowRedirects = bl;
    }

    @Override
    public long getHeaderFieldDate(String string, long l) {
        return super.getHeaderFieldDate(string, l);
    }
}

