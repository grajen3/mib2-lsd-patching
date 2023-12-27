/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

public final class ConnectedDeviceASL
implements Cloneable {
    public static final int TYPE_TELEPHONY_PRIO;
    public static final int TYPE_MEDIA;
    public static final int TYPE_PHONEBOOK;
    public static final int TYPE_TELEPHONY_ASSO;
    public int currentlyConnectedService;
    public String currentlyConnectedMAC;
    public String currentlyConnectedName;

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }
}

