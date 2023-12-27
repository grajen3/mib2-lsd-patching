/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.transformer;

public class BatteryControlPowerProviderCollector {
    public int posID;
    public int NR_StartHour;
    public int NR_StartMinutes;
    public int NR_EndHour;
    public int NR_EndMinutes;

    public BatteryControlPowerProviderCollector() {
        this.posID = 0;
        this.NR_StartHour = 0;
        this.NR_StartMinutes = 0;
        this.NR_EndHour = 0;
        this.NR_EndMinutes = 0;
    }

    public BatteryControlPowerProviderCollector(int n, int n2, int n3, int n4, int n5) {
        this.posID = n;
        this.NR_StartHour = n2;
        this.NR_StartMinutes = n3;
        this.NR_EndHour = n4;
        this.NR_EndMinutes = n5;
    }

    public final BatteryControlPowerProviderCollector copyCollector() {
        return this.copyCollector(this.posID, this.NR_StartHour, this.NR_StartMinutes, this.NR_EndHour, this.NR_EndMinutes);
    }

    protected BatteryControlPowerProviderCollector copyCollector(int n, int n2, int n3, int n4, int n5) {
        return new BatteryControlPowerProviderCollector(n, n2, n3, n4, n5);
    }
}

