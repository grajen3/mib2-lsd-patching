/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Inet6Util;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress$Cache;
import java.net.InetAddress$CacheElement;
import java.net.NegativeCache;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InetAddress
implements Serializable {
    static final byte[] any_bytes = new byte[4];
    static final byte[] localhost_bytes;
    static final InetAddress ANY;
    static final InetAddress LOOPBACK;
    private static final long serialVersionUID;
    String hostName;
    int family = 2;
    byte[] ipaddress;
    private static final ObjectStreamField[] serialPersistentFields;
    static /* synthetic */ Class class$0;

    static {
        byte[] byArray = new byte[4];
        byArray[0] = 127;
        byArray[3] = 1;
        localhost_bytes = byArray;
        ANY = new Inet4Address(any_bytes);
        LOOPBACK = new Inet4Address(localhost_bytes, "localhost");
        InetAddress.oneTimeInitialization(true);
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[3];
        objectStreamFieldArray[0] = new ObjectStreamField("address", Integer.TYPE);
        objectStreamFieldArray[1] = new ObjectStreamField("family", Integer.TYPE);
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[2] = new ObjectStreamField("hostName", clazz);
        serialPersistentFields = objectStreamFieldArray;
    }

    private static native void oneTimeInitialization(boolean bl) {
    }

    InetAddress() {
    }

    InetAddress(byte[] byArray) {
        this.ipaddress = byArray;
    }

    InetAddress(byte[] byArray, String string) {
        this.ipaddress = byArray;
        this.hostName = string;
    }

    static byte[] addressOf(int n) {
        int n2 = n;
        byte[] byArray = new byte[4];
        byArray[3] = (byte)(n2 & 0xFF);
        byArray[2] = (byte)((n2 >>>= 8) & 0xFF);
        byArray[1] = (byte)((n2 >>>= 8) & 0xFF);
        byArray[0] = (byte)((n2 >>>= 8) & 0xFF);
        return byArray;
    }

    InetAddress$CacheElement cacheElement() {
        return new InetAddress$CacheElement(this);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object.getClass() != super.getClass()) {
            return false;
        }
        byte[] byArray = ((InetAddress)object).ipaddress;
        int n = 0;
        while (n < byArray.length) {
            if (byArray[n] != this.ipaddress[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public byte[] getAddress() {
        return (byte[])this.ipaddress.clone();
    }

    public static InetAddress[] getAllByName(String string) {
        if (string == null) {
            return new InetAddress[]{InetAddress.preferIPv6Addresses() ? Inet6Address.LOOPBACK : LOOPBACK};
        }
        if (string.length() == 0) {
            throw new UnknownHostException(Msg.getString("K0038"));
        }
        if (InetAddress.isHostName(string)) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkConnect(string, -1);
            }
            if (Socket.preferIPv4Stack()) {
                return InetAddress.getAliasesByNameImpl(string);
            }
            InetAddress[] inetAddressArray = InetAddress.getAliasesByNameImpl(string);
            InetAddress[] inetAddressArray2 = null;
            if (inetAddressArray != null) {
                inetAddressArray2 = new InetAddress[inetAddressArray.length];
                int n = 0;
                if (InetAddress.preferIPv6Addresses()) {
                    int n2 = 0;
                    while (n2 < inetAddressArray.length) {
                        if (inetAddressArray[n2] instanceof Inet6Address) {
                            inetAddressArray2[n] = inetAddressArray[n2];
                            ++n;
                        }
                        ++n2;
                    }
                    n2 = 0;
                    while (n2 < inetAddressArray.length) {
                        if (inetAddressArray[n2] instanceof Inet4Address) {
                            inetAddressArray2[n] = inetAddressArray[n2];
                            ++n;
                        }
                        ++n2;
                    }
                } else {
                    int n3 = 0;
                    while (n3 < inetAddressArray.length) {
                        if (inetAddressArray[n3] instanceof Inet4Address) {
                            inetAddressArray2[n] = inetAddressArray[n3];
                            ++n;
                        }
                        ++n3;
                    }
                    n3 = 0;
                    while (n3 < inetAddressArray.length) {
                        if (inetAddressArray[n3] instanceof Inet6Address) {
                            inetAddressArray2[n] = inetAddressArray[n3];
                            ++n;
                        }
                        ++n3;
                    }
                }
            }
            return inetAddressArray2;
        }
        byte[] byArray = Inet6Util.createByteArrayFromIPAddressString(string);
        return new InetAddress[]{new InetAddress(byArray)};
    }

    public static InetAddress getByName(String string) {
        if (string == null || string.length() == 0) {
            return LOOPBACK;
        }
        if (string.equals("0")) {
            return ANY;
        }
        if (InetAddress.isHostName(string)) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkConnect(string, -1);
            }
            return InetAddress.lookupHostByName(string);
        }
        return InetAddress.createHostNameFromIPAddress(string);
    }

    public String getHostAddress() {
        return InetAddress.inetNtoaImpl(InetAddress.bytesToInt(this.ipaddress, 0));
    }

    public String getHostName() {
        try {
            if (this.hostName == null) {
                int n = 0;
                if (this.ipaddress.length == 4 && (n = InetAddress.bytesToInt(this.ipaddress, 0)) == 0) {
                    this.hostName = InetAddress.inetNtoaImpl(n);
                    return this.hostName;
                }
                this.hostName = InetAddress.getHostByAddrImpl((byte[])this.ipaddress).hostName;
            }
        }
        catch (UnknownHostException unknownHostException) {
            this.hostName = Inet6Util.createIPAddrStringFromByteArray(this.ipaddress);
            return this.hostName;
        }
        SecurityManager securityManager = System.getSecurityManager();
        try {
            if (securityManager != null && InetAddress.isHostName(this.hostName)) {
                securityManager.checkConnect(this.hostName, -1);
            }
        }
        catch (SecurityException securityException) {
            return Inet6Util.createIPAddrStringFromByteArray(this.ipaddress);
        }
        return this.hostName;
    }

    public String getCanonicalHostName() {
        String string;
        try {
            int n = 0;
            if (this.ipaddress.length == 4 && (n = InetAddress.bytesToInt(this.ipaddress, 0)) == 0) {
                return InetAddress.inetNtoaImpl(n);
            }
            string = InetAddress.getHostByAddrImpl((byte[])this.ipaddress).hostName;
        }
        catch (UnknownHostException unknownHostException) {
            return Inet6Util.createIPAddrStringFromByteArray(this.ipaddress);
        }
        SecurityManager securityManager = System.getSecurityManager();
        try {
            if (securityManager != null && InetAddress.isHostName(string)) {
                securityManager.checkConnect(string, -1);
            }
        }
        catch (SecurityException securityException) {
            return Inet6Util.createIPAddrStringFromByteArray(this.ipaddress);
        }
        return string;
    }

    public static InetAddress getLocalHost() {
        String string = InetAddress.getHostNameImpl();
        SecurityManager securityManager = System.getSecurityManager();
        try {
            if (securityManager != null) {
                securityManager.checkConnect(string, -1);
            }
        }
        catch (SecurityException securityException) {
            return LOOPBACK;
        }
        return InetAddress.lookupHostByName(string);
    }

    public int hashCode() {
        return InetAddress.bytesToInt(this.ipaddress, 0);
    }

    public boolean isMulticastAddress() {
        return (this.ipaddress[0] & 0xFF) >>> 4 == 14;
    }

    static synchronized InetAddress lookupHostByName(String string) {
        InetAddress inetAddress;
        int n = -1;
        String string2 = (String)AccessController.doPrivileged(new PriviAction("networkaddress.cache.ttl"));
        try {
            if (string2 != null) {
                n = Integer.decode(string2);
            }
        }
        catch (NumberFormatException numberFormatException) {}
        InetAddress$CacheElement inetAddress$CacheElement = null;
        if (n == 0) {
            InetAddress$Cache.clear();
        } else {
            inetAddress$CacheElement = InetAddress$Cache.get(string);
            if (inetAddress$CacheElement != null && n > 0 && inetAddress$CacheElement.timeAdded + (long)(n * 1000) < System.currentTimeMillis()) {
                inetAddress$CacheElement = null;
            }
        }
        if (inetAddress$CacheElement != null) {
            return inetAddress$CacheElement.inetAddress();
        }
        String string3 = NegativeCache.getFailedMessage(string);
        if (string3 != null) {
            throw new UnknownHostException(new StringBuffer(String.valueOf(string)).append(" - ").append(string3).toString());
        }
        try {
            inetAddress = InetAddress.getHostByNameImpl(string, InetAddress.preferIPv6Addresses());
        }
        catch (UnknownHostException unknownHostException) {
            NegativeCache.put(string, unknownHostException.getMessage());
            throw new UnknownHostException(new StringBuffer(String.valueOf(string)).append(" - ").append(unknownHostException.getMessage()).toString());
        }
        InetAddress$Cache.add(inetAddress);
        return inetAddress;
    }

    static native InetAddress[] getAliasesByNameImpl(String string) {
    }

    static native InetAddress getHostByAddrImpl(byte[] byArray) {
    }

    static int inetAddr(String string) {
        return string.equals("255.255.255.255") ? -1 : InetAddress.inetAddrImpl(string);
    }

    static native int inetAddrImpl(String string) {
    }

    static native String inetNtoaImpl(int n) {
    }

    static native InetAddress getHostByNameImpl(String string, boolean bl) {
    }

    static native String getHostNameImpl() {
    }

    static String getHostNameInternal(String string) {
        if (string == null || string.length() == 0) {
            return LOOPBACK.getHostAddress();
        }
        if (InetAddress.isHostName(string)) {
            return InetAddress.lookupHostByName(string).getHostAddress();
        }
        return string;
    }

    public String toString() {
        if (this.hostName == null) {
            return new StringBuffer("/").append(this.getHostAddress()).toString();
        }
        return new StringBuffer(String.valueOf(this.getHostName())).append("/").append(this.getHostAddress()).toString();
    }

    private static boolean isHostName(String string) {
        return !Inet6Util.isValidIPV4Address(string) && !Inet6Util.isValidIP6Address(string);
    }

    public boolean isLoopbackAddress() {
        return false;
    }

    public boolean isLinkLocalAddress() {
        return false;
    }

    public boolean isSiteLocalAddress() {
        return false;
    }

    public boolean isMCGlobal() {
        return false;
    }

    public boolean isMCNodeLocal() {
        return false;
    }

    public boolean isMCLinkLocal() {
        return false;
    }

    public boolean isMCSiteLocal() {
        return false;
    }

    public boolean isMCOrgLocal() {
        return false;
    }

    public boolean isAnyLocalAddress() {
        return false;
    }

    public static InetAddress getByAddress(byte[] byArray) {
        return InetAddress.getByAddress(byArray, 0);
    }

    static InetAddress getByAddress(byte[] byArray, int n) {
        if (byArray != null && byArray.length == 4) {
            byte[] byArray2 = new byte[4];
            int n2 = 0;
            while (n2 < 4) {
                byArray2[n2] = byArray[n2];
                ++n2;
            }
            return new Inet4Address(byArray);
        }
        if (byArray != null && byArray.length == 16) {
            if (InetAddress.isIPv4MappedAddress(byArray)) {
                byte[] byArray3 = new byte[4];
                int n3 = 0;
                while (n3 < 4) {
                    byArray3[n3] = byArray[12 + n3];
                    ++n3;
                }
                return new Inet4Address(byArray3);
            }
            byte[] byArray4 = (byte[])byArray.clone();
            return new Inet6Address(byArray4, n);
        }
        throw new UnknownHostException(Msg.getString("K0339"));
    }

    private static boolean isIPv4MappedAddress(byte[] byArray) {
        int n = 0;
        while (n < 10) {
            if (byArray[n] != 0) {
                return false;
            }
            ++n;
        }
        return byArray[10] == -1 && byArray[11] == -1;
    }

    public static InetAddress getByAddress(String string, byte[] byArray) {
        return InetAddress.getByAddress(string, byArray, 0);
    }

    static InetAddress getByAddress(String string, byte[] byArray, int n) {
        if (byArray != null && byArray.length == 4) {
            byte[] byArray2 = new byte[4];
            int n2 = 0;
            while (n2 < 4) {
                byArray2[n2] = byArray[n2];
                ++n2;
            }
            return new Inet4Address(byArray, string);
        }
        if (byArray != null && byArray.length == 16) {
            if (InetAddress.isIPv4MappedAddress(byArray)) {
                byte[] byArray3 = new byte[4];
                int n3 = 0;
                while (n3 < 4) {
                    byArray3[n3] = byArray[12 + n3];
                    ++n3;
                }
                return new Inet4Address(byArray, string);
            }
            byte[] byArray4 = new byte[16];
            int n4 = 0;
            while (n4 < 16) {
                byArray4[n4] = byArray[n4];
                ++n4;
            }
            return new Inet6Address(byArray, string, n);
        }
        throw new UnknownHostException(Msg.getString("K0332", string));
    }

    static void intToBytes(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)(n >> 24 & 0xFF);
        byArray[n2 + 1] = (byte)(n >> 16 & 0xFF);
        byArray[n2 + 2] = (byte)(n >> 8 & 0xFF);
        byArray[n2 + 3] = (byte)(n & 0xFF);
    }

    static int bytesToInt(byte[] byArray, int n) {
        int n2 = byArray[n + 3] & 0xFF | (byArray[n + 2] & 0xFF) << 8 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n] & 0xFF) << 24;
        return n2;
    }

    static InetAddress createHostNameFromIPAddress(String string) {
        InetAddress inetAddress = null;
        if (Inet6Util.isValidIPV4Address(string)) {
            StringTokenizer stringTokenizer = new StringTokenizer(string, ".");
            String string2 = "";
            int n = 0;
            byte[] byArray = new byte[4];
            int n2 = 0;
            while (n2 < 4) {
                string2 = stringTokenizer.nextToken();
                n = Integer.parseInt(string2);
                byArray[n2] = (byte)n;
                ++n2;
            }
            inetAddress = new Inet4Address(byArray);
        } else {
            int n;
            if (string.charAt(0) == '[') {
                string = string.substring(1, string.length() - 1);
            }
            StringTokenizer stringTokenizer = new StringTokenizer(string, ":.%", true);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            String string3 = null;
            String string4 = "";
            String string5 = "";
            String string6 = "";
            int n3 = -1;
            while (stringTokenizer.hasMoreTokens()) {
                string6 = string5;
                string5 = string4;
                string4 = stringTokenizer.nextToken();
                if (string4.equals(":")) {
                    if (string5.equals(":")) {
                        n3 = arrayList.size();
                        continue;
                    }
                    if (string5.equals("")) continue;
                    arrayList.add(string5);
                    continue;
                }
                if (string4.equals(".")) {
                    arrayList2.add(string5);
                    continue;
                }
                if (!string4.equals("%")) continue;
                if (!string5.equals(":") && !string5.equals(".")) {
                    if (string6.equals(":")) {
                        arrayList.add(string5);
                    } else if (string6.equals(".")) {
                        arrayList2.add(string5);
                    }
                }
                string3 = stringTokenizer.nextToken();
                while (stringTokenizer.hasMoreTokens()) {
                    string3 = new StringBuffer(String.valueOf(string3)).append(stringTokenizer.nextToken()).toString();
                }
            }
            if (string5.equals(":")) {
                if (string4.equals(":")) {
                    n3 = arrayList.size();
                } else {
                    arrayList.add(string4);
                }
            } else if (string5.equals(".")) {
                arrayList2.add(string4);
            }
            int n4 = 8;
            if (arrayList2.size() > 0) {
                n4 -= 2;
            }
            if (n3 != -1) {
                int n5 = n4 - arrayList.size();
                n = 0;
                while (n < n5) {
                    arrayList.add(n3, "0");
                    ++n;
                }
            }
            byte[] byArray = new byte[16];
            n = 0;
            while (n < arrayList.size()) {
                Inet6Util.convertToBytes((String)arrayList.get(n), byArray, n * 2);
                ++n;
            }
            n = 0;
            while (n < arrayList2.size()) {
                byArray[n + 12] = (byte)(Integer.parseInt((String)arrayList2.get(n)) & 0xFF);
                ++n;
            }
            n = 1;
            int n6 = 0;
            while (n6 < 10) {
                if (byArray[n6] != 0) {
                    n = 0;
                    break;
                }
                ++n6;
            }
            if (byArray[10] != -1 || byArray[11] != -1) {
                n = 0;
            }
            if (n != 0) {
                byte[] byArray2 = new byte[4];
                int n7 = 0;
                while (n7 < 4) {
                    byArray2[n7] = byArray[n7 + 12];
                    ++n7;
                }
                inetAddress = InetAddress.getByAddress(byArray2);
            } else {
                n6 = 0;
                if (string3 != null) {
                    try {
                        n6 = Integer.parseInt(string3);
                    }
                    catch (Exception exception) {}
                }
                inetAddress = InetAddress.getByAddress(byArray, n6);
            }
        }
        return inetAddress;
    }

    static boolean preferIPv6Addresses() {
        String string = (String)AccessController.doPrivileged(new PriviAction("java.net.preferIPv6Addresses"));
        return "true".equals(string);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream$PutField objectOutputStream$PutField = objectOutputStream.putFields();
        if (this.ipaddress == null) {
            objectOutputStream$PutField.put("address", 0);
        } else {
            objectOutputStream$PutField.put("address", InetAddress.bytesToInt(this.ipaddress, 0));
        }
        objectOutputStream$PutField.put("family", this.family);
        objectOutputStream$PutField.put("hostName", this.hostName);
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream$GetField objectInputStream$GetField = objectInputStream.readFields();
        int n = objectInputStream$GetField.get("address", 0);
        this.ipaddress = new byte[4];
        InetAddress.intToBytes(n, this.ipaddress, 0);
        this.hostName = (String)objectInputStream$GetField.get("hostName", null);
        this.family = objectInputStream$GetField.get("family", 2);
    }

    private Object readResolve() {
        return new Inet4Address(this.ipaddress, this.hostName);
    }
}

