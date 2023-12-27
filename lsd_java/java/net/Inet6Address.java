/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Inet6Util;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamField;
import java.net.InetAddress;

public final class Inet6Address
extends InetAddress {
    private static final long serialVersionUID;
    static final byte[] any_bytes;
    static final byte[] localhost_bytes;
    static final InetAddress ANY;
    static final InetAddress LOOPBACK;
    int scope_id = 0;
    boolean scope_id_set = false;
    boolean scope_ifname_set = false;
    String ifname = null;
    private static final ObjectStreamField[] serialPersistentFields;

    static {
        any_bytes = new byte[16];
        byte[] byArray = new byte[16];
        byArray[15] = 1;
        localhost_bytes = byArray;
        ANY = new Inet6Address(any_bytes);
        LOOPBACK = new Inet6Address(localhost_bytes, "localhost");
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("ipaddress", super.getClass()), new ObjectStreamField("scope_id", Integer.TYPE), new ObjectStreamField("scope_id_set", Boolean.TYPE)};
    }

    Inet6Address(byte[] byArray) {
        this.ipaddress = byArray;
        this.scope_id = 0;
    }

    Inet6Address(byte[] byArray, String string) {
        this.hostName = string;
        this.ipaddress = byArray;
        this.scope_id = 0;
    }

    Inet6Address(byte[] byArray, String string, int n) {
        this.hostName = string;
        this.ipaddress = byArray;
        this.scope_id = n;
        if (n != 0) {
            this.scope_id_set = true;
        }
    }

    Inet6Address(byte[] byArray, int n) {
        this.ipaddress = byArray;
        this.scope_id = n;
        if (n != 0) {
            this.scope_id_set = true;
        }
    }

    @Override
    public boolean isMulticastAddress() {
        return this.ipaddress[0] == -1;
    }

    @Override
    public boolean isAnyLocalAddress() {
        int n = 0;
        while (n < this.ipaddress.length) {
            if (this.ipaddress[n] != 0) {
                return false;
            }
            ++n;
        }
        return true;
    }

    @Override
    public boolean isLoopbackAddress() {
        if (this.ipaddress[15] != 1) {
            return false;
        }
        int n = 0;
        while (n < 15) {
            if (this.ipaddress[n] != 0) {
                return false;
            }
            ++n;
        }
        return true;
    }

    @Override
    public boolean isLinkLocalAddress() {
        return this.ipaddress[0] == -2 && (this.ipaddress[1] & 0xFF) >>> 6 == 2;
    }

    @Override
    public boolean isSiteLocalAddress() {
        return this.ipaddress[0] == -2 && (this.ipaddress[1] & 0xFF) >>> 6 == 3;
    }

    @Override
    public boolean isMCGlobal() {
        return this.ipaddress[0] == -1 && (this.ipaddress[1] & 0xF) == 14;
    }

    @Override
    public boolean isMCNodeLocal() {
        return this.ipaddress[0] == -1 && (this.ipaddress[1] & 0xF) == 1;
    }

    @Override
    public boolean isMCLinkLocal() {
        return this.ipaddress[0] == -1 && (this.ipaddress[1] & 0xF) == 2;
    }

    @Override
    public boolean isMCSiteLocal() {
        return this.ipaddress[0] == -1 && (this.ipaddress[1] & 0xF) == 5;
    }

    @Override
    public boolean isMCOrgLocal() {
        return this.ipaddress[0] == -1 && (this.ipaddress[1] & 0xF) == 8;
    }

    @Override
    public String getHostAddress() {
        return Inet6Util.createIPAddrStringFromByteArray(this.ipaddress);
    }

    @Override
    public int hashCode() {
        return Inet6Address.bytesToInt(this.ipaddress, 12);
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    public boolean isIPv4CompatibleAddress() {
        int n = 0;
        while (n < 12) {
            if (this.ipaddress[n] != 0) {
                return false;
            }
            ++n;
        }
        return true;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream$PutField objectOutputStream$PutField = objectOutputStream.putFields();
        if (this.ipaddress == null) {
            objectOutputStream$PutField.put("ipaddress", null);
        } else {
            objectOutputStream$PutField.put("ipaddress", this.ipaddress);
        }
        objectOutputStream$PutField.put("scope_id", this.scope_id);
        objectOutputStream$PutField.put("scope_id_set", this.scope_id_set);
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream$GetField objectInputStream$GetField = objectInputStream.readFields();
        this.ipaddress = (byte[])objectInputStream$GetField.get("ipaddress", null);
        this.scope_id = objectInputStream$GetField.get("scope_id", 0);
        this.scope_id_set = objectInputStream$GetField.get("scope_id_set", false);
    }

    @Override
    public String toString() {
        if (this.scope_id != 0) {
            return new StringBuffer(String.valueOf(super.toString())).append("%").append(this.scope_id).toString();
        }
        return super.toString();
    }
}

