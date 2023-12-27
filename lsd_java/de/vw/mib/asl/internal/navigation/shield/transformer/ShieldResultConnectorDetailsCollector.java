/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.transformer;

public class ShieldResultConnectorDetailsCollector {
    public int count;
    public String chargeMode;
    public String chargeLevel;
    public String name;
    public String fuseProtection;
    public int poweroutput;
    public int type;

    public ShieldResultConnectorDetailsCollector(int n, String string, String string2, String string3, String string4, int n2, int n3) {
        this.count = n;
        this.chargeMode = string;
        this.chargeLevel = string2;
        this.name = string3;
        this.fuseProtection = string4;
        this.poweroutput = n2;
        this.type = n3;
    }
}

