/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity.transformer;

public class WlanTrustedNetworkCollector {
    public String trustedNetworkName = "";
    public String trustedNetworkAddress = "";
    public int encryptionMode = 1;

    public WlanTrustedNetworkCollector(String string, String string2, int n) {
        this.trustedNetworkAddress = string2;
        this.trustedNetworkName = string;
        this.encryptionMode = n;
    }
}

