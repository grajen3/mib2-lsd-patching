/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public final class NetworkInterface {
    private static final int CHECK_CONNECT_NO_PORT;
    static final int NO_INTERFACE_INDEX;
    static final int UNSET_INTERFACE_INDEX;
    private String name = null;
    private String displayName = null;
    private InetAddress[] addresses = null;
    private int interfaceIndex = 0;
    private int hashCode = 0;

    private static native NetworkInterface[] getNetworkInterfacesImpl() {
    }

    NetworkInterface(String string, String string2, InetAddress[] inetAddressArray, int n) {
        this.name = string;
        this.displayName = string2;
        this.addresses = inetAddressArray;
        this.interfaceIndex = n;
    }

    int getIndex() {
        return this.interfaceIndex;
    }

    InetAddress getFirstAddress() {
        if (this.addresses != null && this.addresses.length >= 1) {
            return this.addresses[0];
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public Enumeration getInetAddresses() {
        if (this.addresses == null) {
            return new Vector(0).elements();
        }
        Vector vector = new Vector(this.addresses.length);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            return new Vector(Arrays.asList(this.addresses)).elements();
        }
        int n = 0;
        while (n < this.addresses.length) {
            if (securityManager != null) {
                try {
                    securityManager.checkConnect(this.addresses[n].getHostAddress(), -1);
                    vector.add(this.addresses[n]);
                }
                catch (SecurityException securityException) {}
            }
            ++n;
        }
        Enumeration enumeration = vector.elements();
        if (enumeration.hasMoreElements()) {
            return vector.elements();
        }
        return new Vector(0).elements();
    }

    public String getDisplayName() {
        if (!this.displayName.equals("")) {
            return this.displayName;
        }
        return this.name;
    }

    public static NetworkInterface getByName(String string) {
        if (string == null) {
            throw new NullPointerException(Msg.getString("K0330"));
        }
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface)enumeration.nextElement();
                if (!networkInterface.getName().equals(string)) continue;
                return networkInterface;
            }
        }
        return null;
    }

    public static NetworkInterface getByInetAddress(InetAddress inetAddress) {
        if (inetAddress == null) {
            throw new NullPointerException(Msg.getString("K0331"));
        }
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                Enumeration enumeration2;
                NetworkInterface networkInterface = (NetworkInterface)enumeration.nextElement();
                if (networkInterface.addresses == null || networkInterface.addresses.length == 0 || (enumeration2 = new Vector(Arrays.asList(networkInterface.addresses)).elements()) == null) continue;
                while (enumeration2.hasMoreElements()) {
                    if (!inetAddress.equals((InetAddress)enumeration2.nextElement())) continue;
                    return networkInterface;
                }
            }
        }
        return null;
    }

    public static Enumeration getNetworkInterfaces() {
        Object[] objectArray = NetworkInterface.getNetworkInterfacesImpl();
        if (objectArray == null) {
            return null;
        }
        return new Vector(Arrays.asList(objectArray)).elements();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof NetworkInterface) {
            NetworkInterface networkInterface = (NetworkInterface)object;
            if (networkInterface.getIndex() != this.interfaceIndex) {
                return false;
            }
            if (!this.name.equals("") && !networkInterface.getName().equals(this.name)) {
                return false;
            }
            if (this.name.equals("") && !networkInterface.getName().equals(this.displayName)) {
                return false;
            }
            Enumeration enumeration = networkInterface.getInetAddresses();
            Enumeration enumeration2 = this.getInetAddresses();
            if (enumeration == null && enumeration2 != null) {
                return false;
            }
            if (enumeration == null && enumeration2 == null) {
                return true;
            }
            if (enumeration != null) {
                while (enumeration.hasMoreElements() && enumeration2.hasMoreElements()) {
                    if (((InetAddress)enumeration2.nextElement()).equals((InetAddress)enumeration.nextElement())) continue;
                    return false;
                }
                if (enumeration.hasMoreElements() || enumeration2.hasMoreElements()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.name.hashCode();
        }
        return this.hashCode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(new StringBuffer("[").append(this.name).append("][").append(this.displayName).append("]").toString());
        Enumeration enumeration = this.getInetAddresses();
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                InetAddress inetAddress = (InetAddress)enumeration.nextElement();
                stringBuffer.append(new StringBuffer("[").append(inetAddress.toString()).append("]").toString());
            }
        }
        return stringBuffer.toString();
    }
}

