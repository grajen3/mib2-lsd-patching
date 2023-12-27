/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import javax.microedition.io.ContentConnection;

public interface HttpConnection
extends ContentConnection {
    public static final String GET;
    public static final String HEAD;
    public static final String POST;
    public static final int HTTP_ACCEPTED;
    public static final int HTTP_BAD_GATEWAY;
    public static final int HTTP_BAD_METHOD;
    public static final int HTTP_BAD_REQUEST;
    public static final int HTTP_CLIENT_TIMEOUT;
    public static final int HTTP_CONFLICT;
    public static final int HTTP_CREATED;
    public static final int HTTP_ENTITY_TOO_LARGE;
    public static final int HTTP_EXPECT_FAILED;
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
    public static final int HTTP_TEMP_REDIRECT;
    public static final int HTTP_UNAUTHORIZED;
    public static final int HTTP_UNAVAILABLE;
    public static final int HTTP_UNSUPPORTED_RANGE;
    public static final int HTTP_UNSUPPORTED_TYPE;
    public static final int HTTP_USE_PROXY;
    public static final int HTTP_VERSION;

    default public long getDate() {
    }

    default public long getExpiration() {
    }

    default public String getFile() {
    }

    default public String getHeaderField(int n) {
    }

    default public String getHeaderField(String string) {
    }

    default public long getHeaderFieldDate(String string, long l) {
    }

    default public int getHeaderFieldInt(String string, int n) {
    }

    default public String getHeaderFieldKey(int n) {
    }

    default public String getHost() {
    }

    default public long getLastModified() {
    }

    default public int getPort() {
    }

    default public String getProtocol() {
    }

    default public String getQuery() {
    }

    default public String getRef() {
    }

    default public String getRequestMethod() {
    }

    default public String getRequestProperty(String string) {
    }

    default public int getResponseCode() {
    }

    default public String getResponseMessage() {
    }

    default public String getURL() {
    }

    default public void setRequestMethod(String string) {
    }

    default public void setRequestProperty(String string, String string2) {
    }
}

