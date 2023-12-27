/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.UUID;
import de.esolutions.fw.util.serializer.IDeserializable;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

public class ServiceUUID
implements ISerializable,
IDeserializable {
    private static final UUID INTERNAL_ZERO_UUID = new UUID("00000000-0000-0000-0000-000000000000");
    public static final ServiceUUID ZERO_UUID = new ServiceUUID("00000000-0000-0000-0000-000000000000");
    protected UUID uuid;

    public ServiceUUID() {
        this.uuid = new UUID();
    }

    public ServiceUUID(UUID uUID) {
        this.uuid = uUID;
    }

    public ServiceUUID(IDeserializer iDeserializer) {
        byte[] byArray = new byte[16];
        iDeserializer.getInt8Array(byArray);
        this.uuid = new UUID(byArray);
    }

    public ServiceUUID(String string) {
        this.uuid = new UUID(string);
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public String toString() {
        return this.uuid.toString();
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt8Array(this.uuid.getRawBytes());
    }

    @Override
    public void deserialize(IDeserializer iDeserializer) {
        byte[] byArray = new byte[16];
        iDeserializer.getInt8Array(byArray);
        this.uuid = new UUID(byArray);
    }

    public boolean equals(Object object) {
        if (!(object instanceof ServiceUUID)) {
            return false;
        }
        ServiceUUID serviceUUID = (ServiceUUID)object;
        return this.uuid.equals(serviceUUID.uuid);
    }

    public int hashCode() {
        int n = 1;
        if (this.uuid != null) {
            n += 17 * this.uuid.hashCode();
        }
        return n;
    }

    public boolean isZero() {
        return this.uuid.equals(INTERNAL_ZERO_UUID);
    }

    public static boolean isBeginOfUUIDString(String string) {
        char[] cArray = string.toCharArray();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            boolean bl;
            if (i2 == 8 || i2 == 13 || i2 == 18 || i2 == 23) {
                if (cArray[i2] == '-') continue;
                return false;
            }
            boolean bl2 = cArray[i2] >= '0' && cArray[i2] <= '9';
            boolean bl3 = cArray[i2] >= 'a' && cArray[i2] <= 'f';
            boolean bl4 = bl = cArray[i2] >= 'A' && cArray[i2] <= 'F';
            if (bl2 || bl3 || bl) continue;
            return false;
        }
        return true;
    }

    public static boolean isUUIDString(String string) {
        if (string.length() != 36) {
            return false;
        }
        return ServiceUUID.isBeginOfUUIDString(string);
    }
}

