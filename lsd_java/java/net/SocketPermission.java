/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Inet6Util;
import com.ibm.oti.util.Msg;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.SocketPermissionCollection;
import java.net.UnknownHostException;
import java.security.Permission;
import java.security.PermissionCollection;

public final class SocketPermission
extends Permission
implements Serializable {
    private static final long serialVersionUID;
    static final int SP_CONNECT;
    static final int SP_LISTEN;
    static final int SP_ACCEPT;
    static final int SP_RESOLVE;
    private static final String[] actionNames;
    private transient boolean isPartialWild = false;
    private transient boolean isWild = false;
    private static final int HIGHEST_PORT;
    private static final int LOWEST_PORT;
    transient String hostName;
    transient String ipString;
    transient boolean resolved = false;
    transient int portMin = 0;
    transient int portMax = -65536;
    private String actions;
    transient int actionsMask = 8;

    static {
        actionNames = new String[]{"", "connect", "listen", "", "accept", "", "", "", "resolve"};
    }

    public SocketPermission(String string, String string2) {
        super(string.equals("") ? "localhost" : string);
        this.hostName = this.getHostString(string);
        if (string2 == null) {
            throw new NullPointerException();
        }
        if (string2.equals("")) {
            throw new IllegalArgumentException();
        }
        this.setActions(string2);
        this.actions = this.toCanonicalActionString(string2);
        this.parsePort(string);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        SocketPermission socketPermission = (SocketPermission)object;
        if (!(this.hostName.equals(socketPermission.hostName) || this.getIPString() != null && this.ipString.equals(socketPermission.getIPString()))) {
            return false;
        }
        if (this.portMin != socketPermission.portMin) {
            return false;
        }
        if (this.portMax != socketPermission.portMax) {
            return false;
        }
        return this.actionsMask == socketPermission.actionsMask;
    }

    @Override
    public int hashCode() {
        return this.hostName.hashCode() ^ this.actionsMask ^ this.portMin ^ this.portMax;
    }

    @Override
    public String getActions() {
        return this.actions;
    }

    private void setActions(String string) {
        if (string.equals("")) {
            return;
        }
        boolean bl = true;
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        int n2 = string.length();
        while (bl) {
            String string2;
            char c2;
            stringBuffer.setLength(0);
            while (n < n2 && (c2 = string.charAt(n++)) != ',') {
                stringBuffer.append(c2);
            }
            if (n == n2) {
                bl = false;
            }
            if ((string2 = stringBuffer.toString().trim().toLowerCase()).equals(actionNames[1])) {
                this.actionsMask |= 1;
                continue;
            }
            if (string2.equals(actionNames[2])) {
                this.actionsMask |= 2;
                continue;
            }
            if (string2.equals(actionNames[4])) {
                this.actionsMask |= 4;
                continue;
            }
            if (string2.equals(actionNames[8])) continue;
            throw new IllegalArgumentException(Msg.getString("K0048", string2));
        }
    }

    @Override
    public boolean implies(Permission permission) {
        SocketPermission socketPermission;
        try {
            socketPermission = (SocketPermission)permission;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        if ((this.actionsMask & socketPermission.actionsMask) != socketPermission.actionsMask) {
            return false;
        }
        if (!(permission.getActions().equals("resolve") || socketPermission.portMin >= this.portMin && socketPermission.portMax <= this.portMax)) {
            return false;
        }
        return this.checkHost(socketPermission);
    }

    @Override
    public PermissionCollection newPermissionCollection() {
        return new SocketPermissionCollection();
    }

    private void parsePort(String string) {
        int n = -1;
        int n2 = -1;
        int n3 = string.lastIndexOf(58);
        int n4 = string.indexOf(58);
        int n5 = string.lastIndexOf(93);
        if (n5 == -1 && n4 != n3) {
            if (Inet6Util.isValidIP6Address(string)) {
                return;
            }
            throw new IllegalArgumentException(Msg.getString("K004a"));
        }
        if (n3 > -1 && n3 > n5) {
            try {
                n2 = string.length();
                n = string.indexOf(45, n3);
                if (n == n3 + 1) {
                    this.portMax = Integer.parseInt(string.substring(n3 + 2, n2));
                } else if (n != -1 && n != n2 - 1) {
                    this.portMin = Integer.parseInt(string.substring(n3 + 1, n));
                    this.portMax = Integer.parseInt(string.substring(n + 1, n2));
                } else if (n == -1) {
                    this.portMax = this.portMin = Integer.parseInt(string.substring(n3 + 1, n2));
                } else {
                    this.portMin = Integer.parseInt(string.substring(n3 + 1, n));
                }
                if (this.portMax < this.portMin) {
                    throw new IllegalArgumentException(Msg.getString("K0049"));
                }
            }
            catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException(Msg.getString("K004a"));
            }
        }
    }

    private String toCanonicalActionString(String string) {
        if (string == null || string.equals("") || this.actionsMask == 8) {
            return actionNames[8];
        }
        StringBuffer stringBuffer = new StringBuffer();
        if ((this.actionsMask & 1) == 1) {
            stringBuffer.append(',');
            stringBuffer.append(actionNames[1]);
        }
        if ((this.actionsMask & 2) == 2) {
            stringBuffer.append(',');
            stringBuffer.append(actionNames[2]);
        }
        if ((this.actionsMask & 4) == 4) {
            stringBuffer.append(',');
            stringBuffer.append(actionNames[4]);
        }
        stringBuffer.append(',');
        stringBuffer.append(actionNames[8]);
        this.actions = stringBuffer.substring(1, stringBuffer.length());
        return this.actions;
    }

    private String getIPString() {
        if (!this.resolved) {
            try {
                this.ipString = InetAddress.getHostNameInternal(this.hostName);
            }
            catch (UnknownHostException unknownHostException) {}
            this.resolved = true;
        }
        return this.ipString;
    }

    private String getHostString(String string) {
        int n = -1;
        n = string.indexOf(58);
        this.isPartialWild = string.length() > 0 && string.charAt(0) == '*';
        if (this.isPartialWild) {
            this.resolved = true;
            this.isWild = string.length() == 1;
            if (this.isWild) {
                return string;
            }
            if (n > -1) {
                string = string.substring(0, n);
            }
            return string.toLowerCase();
        }
        int n2 = string.lastIndexOf(58);
        if (n > -1 && n == n2) {
            string = string.substring(0, n);
        } else if (n2 != -1) {
            if (Inet6Util.isValidIP6Address(string)) {
                return string.toLowerCase();
            }
            if (Inet6Util.isValidIP6Address(string.substring(0, n2))) {
                string = string.substring(0, n2);
            } else {
                throw new IllegalArgumentException(Msg.getString("K004a"));
            }
        }
        return string.toLowerCase();
    }

    boolean checkHost(SocketPermission socketPermission) {
        if (this.isPartialWild) {
            if (this.isWild) {
                return true;
            }
            int n = this.hostName.length() - 1;
            return socketPermission.hostName.regionMatches(socketPermission.hostName.length() - n, this.hostName, 1, n);
        }
        return this.getIPString() != null && this.ipString.equals(socketPermission.getIPString()) || this.hostName.equals(socketPermission.hostName);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.isPartialWild = false;
        this.isWild = false;
        this.portMin = 0;
        this.portMax = -65536;
        this.actionsMask = 8;
        this.hostName = this.getHostString(this.getName());
        this.parsePort(this.getName());
        this.setActions(this.actions);
    }
}

