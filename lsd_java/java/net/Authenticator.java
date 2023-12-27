/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.InetAddress;
import java.net.NetPermission;
import java.net.PasswordAuthentication;

public abstract class Authenticator {
    private static Authenticator thisAuthenticator;
    private static final NetPermission requestPasswordAuthenticationPermission;
    private static final NetPermission setDefaultAuthenticatorPermission;
    private String host;
    private InetAddress addr;
    private int port;
    private String protocol;
    private String prompt;
    private String scheme;

    static {
        requestPasswordAuthenticationPermission = new NetPermission("requestPasswordAuthentication");
        setDefaultAuthenticatorPermission = new NetPermission("setDefaultAuthenticator");
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return null;
    }

    protected final int getRequestingPort() {
        return this.port;
    }

    protected final InetAddress getRequestingSite() {
        return this.addr;
    }

    protected final String getRequestingPrompt() {
        return this.prompt;
    }

    protected final String getRequestingProtocol() {
        return this.protocol;
    }

    protected final String getRequestingScheme() {
        return this.scheme;
    }

    public static synchronized PasswordAuthentication requestPasswordAuthentication(InetAddress inetAddress, int n, String string, String string2, String string3) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(requestPasswordAuthenticationPermission);
        }
        if (thisAuthenticator == null) {
            return null;
        }
        Authenticator.thisAuthenticator.addr = inetAddress;
        Authenticator.thisAuthenticator.port = n;
        Authenticator.thisAuthenticator.protocol = string;
        Authenticator.thisAuthenticator.prompt = string2;
        Authenticator.thisAuthenticator.scheme = string3;
        return thisAuthenticator.getPasswordAuthentication();
    }

    public static void setDefault(Authenticator authenticator) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(setDefaultAuthenticatorPermission);
        }
        thisAuthenticator = authenticator;
    }

    public static synchronized PasswordAuthentication requestPasswordAuthentication(String string, InetAddress inetAddress, int n, String string2, String string3, String string4) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(requestPasswordAuthenticationPermission);
        }
        if (thisAuthenticator == null) {
            return null;
        }
        Authenticator.thisAuthenticator.host = string;
        Authenticator.thisAuthenticator.addr = inetAddress;
        Authenticator.thisAuthenticator.port = n;
        Authenticator.thisAuthenticator.protocol = string2;
        Authenticator.thisAuthenticator.prompt = string3;
        Authenticator.thisAuthenticator.scheme = string4;
        return thisAuthenticator.getPasswordAuthentication();
    }

    protected final String getRequestingHost() {
        return this.host;
    }
}

