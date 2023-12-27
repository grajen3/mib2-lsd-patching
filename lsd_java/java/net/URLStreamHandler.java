/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public abstract class URLStreamHandler {
    protected abstract URLConnection openConnection(URL uRL) {
    }

    protected void parseURL(URL uRL, String string, int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        if (n2 < n) {
            return;
        }
        String string2 = "";
        if (n < n2) {
            string2 = string.substring(n, n2);
        }
        n2 -= n;
        int n7 = 0;
        String string3 = uRL.getHost();
        int n8 = uRL.getPort();
        String string4 = uRL.getRef();
        String string5 = uRL.getPath();
        String string6 = uRL.getQuery();
        String string7 = uRL.getAuthority();
        String string8 = uRL.getUserInfo();
        int n9 = string2.indexOf(35, 0);
        if (string2.startsWith("//")) {
            n6 = 2;
            n5 = -1;
            n8 = -1;
            n7 = string2.indexOf(47, n6);
            if (n7 == -1) {
                n7 = n2;
                string5 = "";
            }
            n4 = n7;
            if (n9 != -1 && n9 < n7) {
                n4 = n9;
            }
            n3 = string2.lastIndexOf(64, n4);
            string7 = string2.substring(n6, n4);
            if (n3 > -1) {
                string8 = string2.substring(n6, n3);
                n6 = n3 + 1;
            }
            n5 = string2.indexOf(58, n3 == -1 ? n6 : n3);
            int n10 = string2.indexOf(93);
            if (n10 != -1) {
                try {
                    char c2;
                    n5 = string2.length() > n10 + 1 ? ((c2 = string2.charAt(n10 + 1)) == ':' ? n10 + 1 : -1) : -1;
                }
                catch (Exception exception) {}
            }
            if (n5 == -1 || n5 > n7) {
                string3 = string2.substring(n6, n4);
            } else {
                string3 = string2.substring(n6, n5);
                String string9 = string2.substring(n5 + 1, n4);
                n8 = string9.length() == 0 ? -1 : Integer.parseInt(string9);
            }
        }
        if (n9 > -1) {
            string4 = string2.substring(n9 + 1, n2);
        }
        if ((n5 = string2.lastIndexOf(63, n6 = n9 == -1 ? n2 : n9)) > -1) {
            string6 = string2.substring(n5 + 1, n6);
            if (n5 == 0 && string5 != null) {
                string5 = "/";
            }
            n6 = n5;
        } else if (n9 != 0) {
            string6 = null;
        }
        n4 = 0;
        if (n7 > -1) {
            if (n7 < n2 && string2.charAt(n7) == '/') {
                string5 = string2.substring(n7, n6);
            } else if (n6 > n7) {
                if (string5 == null) {
                    string5 = "";
                } else if (string5.equals("")) {
                    string5 = "/";
                } else if (string5.startsWith("/")) {
                    n4 = 1;
                }
                n3 = string5.lastIndexOf(47) + 1;
                string5 = n3 == 0 ? string2.substring(n7, n6) : new StringBuffer(String.valueOf(string5.substring(0, n3))).append(string2.substring(n7, n6)).toString();
            }
        }
        if (string5 == null) {
            string5 = "";
        }
        if (string3 == null) {
            string3 = "";
        }
        if (n4 != 0) {
            while ((n3 = string5.indexOf("/./")) >= 0) {
                string5 = new StringBuffer(String.valueOf(string5.substring(0, n3 + 1))).append(string5.substring(n3 + 3)).toString();
            }
            if (string5.endsWith("/.")) {
                string5 = string5.substring(0, string5.length() - 1);
            }
            while ((n3 = string5.indexOf("/../")) >= 0) {
                string5 = n3 != 0 ? new StringBuffer(String.valueOf(string5.substring(0, string5.lastIndexOf(47, n3 - 1)))).append(string5.substring(n3 + 3)).toString() : string5.substring(n3 + 3);
            }
            if (string5.endsWith("/..") && string5.length() > 3) {
                string5 = string5.substring(0, string5.lastIndexOf(47, string5.length() - 4) + 1);
            }
        }
        this.setURL(uRL, uRL.getProtocol(), string3, n8, string7, string8, string5, string6, string4);
    }

    protected void setURL(URL uRL, String string, String string2, int n, String string3, String string4, String string5, String string6, String string7) {
        if (this != uRL.strmHandler) {
            throw new SecurityException();
        }
        uRL.set(string, string2, n, string3, string4, string5, string6, string7);
    }

    protected String toExternalForm(URL uRL) {
        StringBuffer stringBuffer = new StringBuffer(uRL.getProtocol().length() + uRL.getFile().length() + 16);
        stringBuffer.append(uRL.getProtocol());
        stringBuffer.append(':');
        String string = uRL.getAuthority();
        if (string != null && string.length() > 0) {
            stringBuffer.append("//");
            stringBuffer.append(uRL.getAuthority());
        }
        String string2 = uRL.getFile();
        String string3 = uRL.getRef();
        stringBuffer.append(string2);
        if (string3 != null) {
            stringBuffer.append('#');
            stringBuffer.append(string3);
        }
        return stringBuffer.toString();
    }

    protected boolean equals(URL uRL, URL uRL2) {
        String string;
        if (!this.sameFile(uRL, uRL2)) {
            return false;
        }
        String string2 = uRL.getRef();
        if (!(string2 == (string = uRL2.getRef()) || string2 != null && string2.equals(string))) {
            return false;
        }
        string2 = uRL.getQuery();
        return string2 == (string = uRL2.getQuery()) || string2 != null && string2.equals(string);
    }

    protected int getDefaultPort() {
        return -1;
    }

    protected InetAddress getHostAddress(URL uRL) {
        try {
            String string = uRL.getHost();
            if (string == null || string.length() == 0) {
                return null;
            }
            return InetAddress.getByName(string);
        }
        catch (UnknownHostException unknownHostException) {
            return null;
        }
    }

    protected int hashCode(URL uRL) {
        return this.toExternalForm(uRL).hashCode();
    }

    protected boolean hostsEqual(URL uRL, URL uRL2) {
        String string;
        String string2 = uRL.getHost();
        return string2 == (string = uRL2.getHost()) || string2 != null && string2.equalsIgnoreCase(string);
    }

    protected boolean sameFile(URL uRL, URL uRL2) {
        int n;
        String string;
        String string2 = uRL.getProtocol();
        if (!(string2 == (string = uRL2.getProtocol()) || string2 != null && string2.equals(string))) {
            return false;
        }
        string2 = uRL.getFile();
        if (!(string2 == (string = uRL2.getFile()) || string2 != null && string2.equals(string))) {
            return false;
        }
        if (!this.hostsEqual(uRL, uRL2)) {
            return false;
        }
        int n2 = uRL.getPort();
        if (n2 == -1) {
            n2 = this.getDefaultPort();
        }
        if ((n = uRL2.getPort()) == -1) {
            n = this.getDefaultPort();
        }
        return n2 == n;
    }
}

