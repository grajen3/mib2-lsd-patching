/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateAirVolume;

public class ClimateAirVolumeImpl
implements ClimateAirVolume {
    int airVolume;
    int airVolumeRegulated;
    int airVolumeAuto;
    int zone;

    public ClimateAirVolumeImpl(int n, int n2, int n3, int n4) {
        this.zone = n;
        this.airVolume = n2;
        this.airVolumeRegulated = n3;
        this.airVolumeAuto = n4;
    }

    @Override
    public ClimateAirVolume modifiyAirVolume(int n, int n2) {
        ClimateAirVolumeImpl climateAirVolumeImpl = new ClimateAirVolumeImpl(this.zone, this.airVolume, this.airVolumeRegulated, this.airVolumeAuto);
        switch (n) {
            case 1: {
                climateAirVolumeImpl.airVolume = n2;
                break;
            }
            case 3: {
                climateAirVolumeImpl.airVolumeAuto = n2;
                break;
            }
            case 2: {
                climateAirVolumeImpl.airVolumeRegulated = n2;
                break;
            }
        }
        return climateAirVolumeImpl;
    }

    @Override
    public int getAirVolumeIntSettings(int n) {
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = this.airVolume;
                break;
            }
            case 3: {
                n2 = this.airVolumeAuto;
                break;
            }
            case 2: {
                n2 = this.airVolumeRegulated;
                break;
            }
            case 4: {
                n2 = this.zone;
                break;
            }
        }
        return n2;
    }
}

