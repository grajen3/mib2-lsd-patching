/*
 * Decompiled with CFR 0.152.
 */
package java.net;

public interface SocketOptions {
    public static final int SO_LINGER;
    public static final int SO_TIMEOUT;
    public static final int TCP_NODELAY;
    public static final int IP_MULTICAST_IF;
    public static final int SO_BINDADDR;
    public static final int SO_REUSEADDR;
    public static final int SO_SNDBUF;
    public static final int SO_RCVBUF;
    public static final int SO_KEEPALIVE;
    public static final int IP_TOS;
    public static final int IP_MULTICAST_LOOP;
    public static final int SO_BROADCAST;
    public static final int SO_OOBINLINE;
    public static final int IP_MULTICAST_IF2;

    default public Object getOption(int n) {
    }

    default public void setOption(int n, Object object) {
    }
}

