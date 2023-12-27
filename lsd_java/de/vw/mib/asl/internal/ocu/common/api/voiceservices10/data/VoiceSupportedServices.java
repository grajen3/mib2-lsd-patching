/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.voiceservices10.data;

public class VoiceSupportedServices
implements de.vw.mib.asl.api.ocu.voiceservices10.data.VoiceSupportedServices {
    private final boolean infoCallAvailable;
    private final boolean serviceCallAvailable;
    private final boolean emergencyCallAvailable;

    public VoiceSupportedServices(boolean bl, boolean bl2, boolean bl3) {
        this.infoCallAvailable = bl;
        this.serviceCallAvailable = bl2;
        this.emergencyCallAvailable = bl3;
    }

    @Override
    public boolean isInfoCallAvailable() {
        return this.infoCallAvailable;
    }

    @Override
    public boolean isServiceCallAvailable() {
        return this.serviceCallAvailable;
    }

    @Override
    public boolean isEmergencyCallAvailable() {
        return this.emergencyCallAvailable;
    }

    public boolean equals(Object object) {
        VoiceSupportedServices voiceSupportedServices = (VoiceSupportedServices)object;
        return voiceSupportedServices.infoCallAvailable == this.infoCallAvailable && voiceSupportedServices.serviceCallAvailable == this.serviceCallAvailable && voiceSupportedServices.emergencyCallAvailable == this.emergencyCallAvailable;
    }

    public int hashCode() {
        return super.hashCode();
    }
}

