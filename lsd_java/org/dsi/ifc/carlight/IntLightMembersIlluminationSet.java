/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

public class IntLightMembersIlluminationSet {
    public boolean frontRoofLighting;
    public boolean rearRoofLighting;
    public boolean frontFootwellLighting;
    public boolean rearFootwellLighting;
    public boolean frontDoorsLighting;
    public boolean rearDoorsLighting;
    public boolean frontDoorsWarningLighting;
    public boolean rearDoorsWarningLighting;
    public boolean frontDoorsEntranceLighting;
    public boolean rearDoorsEntranceLighting;
    public boolean frontDoorsStripLighting;
    public boolean rearDoorsStripLighting;
    public boolean cockpitStripLighting;
    public boolean cupholderStripLighting;
    public boolean premiumSoundLighting;
    public boolean sunRoofStripLighting;
    public boolean frontSliderLighting;
    public boolean navigationDeviceStripLighting;
    public boolean frontClimateControlStripLighting;
    public boolean gearShiftLighting;
    public boolean centerControlLighting;
    public boolean frontDoorPocketLighting;
    public boolean rearDoorPocketLighting;

    public IntLightMembersIlluminationSet() {
        this.frontRoofLighting = false;
        this.rearRoofLighting = false;
        this.frontFootwellLighting = false;
        this.rearFootwellLighting = false;
        this.frontDoorsLighting = false;
        this.rearDoorsLighting = false;
        this.frontDoorsWarningLighting = false;
        this.rearDoorsWarningLighting = false;
        this.frontDoorsEntranceLighting = false;
        this.rearDoorsEntranceLighting = false;
        this.frontDoorsStripLighting = false;
        this.rearDoorsStripLighting = false;
        this.cockpitStripLighting = false;
        this.cupholderStripLighting = false;
        this.premiumSoundLighting = false;
        this.sunRoofStripLighting = false;
        this.frontSliderLighting = false;
        this.navigationDeviceStripLighting = false;
        this.frontClimateControlStripLighting = false;
        this.gearShiftLighting = false;
        this.centerControlLighting = false;
        this.frontDoorPocketLighting = false;
        this.rearDoorPocketLighting = false;
    }

    public IntLightMembersIlluminationSet(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, boolean bl18, boolean bl19, boolean bl20, boolean bl21, boolean bl22, boolean bl23) {
        this.frontRoofLighting = bl;
        this.rearRoofLighting = bl2;
        this.frontFootwellLighting = bl3;
        this.rearFootwellLighting = bl4;
        this.frontDoorsLighting = bl5;
        this.rearDoorsLighting = bl6;
        this.frontDoorsWarningLighting = bl7;
        this.rearDoorsWarningLighting = bl8;
        this.frontDoorsEntranceLighting = bl9;
        this.rearDoorsEntranceLighting = bl10;
        this.frontDoorsStripLighting = bl11;
        this.rearDoorsStripLighting = bl12;
        this.cockpitStripLighting = bl13;
        this.cupholderStripLighting = bl14;
        this.premiumSoundLighting = bl15;
        this.sunRoofStripLighting = bl16;
        this.frontSliderLighting = bl17;
        this.navigationDeviceStripLighting = bl18;
        this.frontClimateControlStripLighting = bl19;
        this.gearShiftLighting = bl20;
        this.centerControlLighting = bl21;
        this.frontDoorPocketLighting = bl22;
        this.rearDoorPocketLighting = bl23;
    }

    public boolean isFrontRoofLighting() {
        return this.frontRoofLighting;
    }

    public boolean isRearRoofLighting() {
        return this.rearRoofLighting;
    }

    public boolean isFrontFootwellLighting() {
        return this.frontFootwellLighting;
    }

    public boolean isRearFootwellLighting() {
        return this.rearFootwellLighting;
    }

    public boolean isFrontDoorsLighting() {
        return this.frontDoorsLighting;
    }

    public boolean isRearDoorsLighting() {
        return this.rearDoorsLighting;
    }

    public boolean isFrontDoorsWarningLighting() {
        return this.frontDoorsWarningLighting;
    }

    public boolean isRearDoorsWarningLighting() {
        return this.rearDoorsWarningLighting;
    }

    public boolean isFrontDoorsEntranceLighting() {
        return this.frontDoorsEntranceLighting;
    }

    public boolean isRearDoorsEntranceLighting() {
        return this.rearDoorsEntranceLighting;
    }

    public boolean isFrontDoorsStripLighting() {
        return this.frontDoorsStripLighting;
    }

    public boolean isRearDoorsStripLighting() {
        return this.rearDoorsStripLighting;
    }

    public boolean isCockpitStripLighting() {
        return this.cockpitStripLighting;
    }

    public boolean isCupholderStripLighting() {
        return this.cupholderStripLighting;
    }

    public boolean isPremiumSoundLighting() {
        return this.premiumSoundLighting;
    }

    public boolean isSunRoofStripLighting() {
        return this.sunRoofStripLighting;
    }

    public boolean isFrontSliderLighting() {
        return this.frontSliderLighting;
    }

    public boolean isNavigationDeviceStripLighting() {
        return this.navigationDeviceStripLighting;
    }

    public boolean isFrontClimateControlStripLighting() {
        return this.frontClimateControlStripLighting;
    }

    public boolean isGearShiftLighting() {
        return this.gearShiftLighting;
    }

    public boolean isCenterControlLighting() {
        return this.centerControlLighting;
    }

    public boolean isFrontDoorPocketLighting() {
        return this.frontDoorPocketLighting;
    }

    public boolean isRearDoorPocketLighting() {
        return this.rearDoorPocketLighting;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1500);
        stringBuffer.append("IntLightMembersIlluminationSet");
        stringBuffer.append('(');
        stringBuffer.append("frontRoofLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.frontRoofLighting);
        stringBuffer.append(',');
        stringBuffer.append("rearRoofLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.rearRoofLighting);
        stringBuffer.append(',');
        stringBuffer.append("frontFootwellLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.frontFootwellLighting);
        stringBuffer.append(',');
        stringBuffer.append("rearFootwellLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.rearFootwellLighting);
        stringBuffer.append(',');
        stringBuffer.append("frontDoorsLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.frontDoorsLighting);
        stringBuffer.append(',');
        stringBuffer.append("rearDoorsLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.rearDoorsLighting);
        stringBuffer.append(',');
        stringBuffer.append("frontDoorsWarningLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.frontDoorsWarningLighting);
        stringBuffer.append(',');
        stringBuffer.append("rearDoorsWarningLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.rearDoorsWarningLighting);
        stringBuffer.append(',');
        stringBuffer.append("frontDoorsEntranceLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.frontDoorsEntranceLighting);
        stringBuffer.append(',');
        stringBuffer.append("rearDoorsEntranceLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.rearDoorsEntranceLighting);
        stringBuffer.append(',');
        stringBuffer.append("frontDoorsStripLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.frontDoorsStripLighting);
        stringBuffer.append(',');
        stringBuffer.append("rearDoorsStripLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.rearDoorsStripLighting);
        stringBuffer.append(',');
        stringBuffer.append("cockpitStripLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.cockpitStripLighting);
        stringBuffer.append(',');
        stringBuffer.append("cupholderStripLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.cupholderStripLighting);
        stringBuffer.append(',');
        stringBuffer.append("premiumSoundLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.premiumSoundLighting);
        stringBuffer.append(',');
        stringBuffer.append("sunRoofStripLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.sunRoofStripLighting);
        stringBuffer.append(',');
        stringBuffer.append("frontSliderLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.frontSliderLighting);
        stringBuffer.append(',');
        stringBuffer.append("navigationDeviceStripLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.navigationDeviceStripLighting);
        stringBuffer.append(',');
        stringBuffer.append("frontClimateControlStripLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.frontClimateControlStripLighting);
        stringBuffer.append(',');
        stringBuffer.append("gearShiftLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.gearShiftLighting);
        stringBuffer.append(',');
        stringBuffer.append("centerControlLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.centerControlLighting);
        stringBuffer.append(',');
        stringBuffer.append("frontDoorPocketLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.frontDoorPocketLighting);
        stringBuffer.append(',');
        stringBuffer.append("rearDoorPocketLighting");
        stringBuffer.append('=');
        stringBuffer.append(this.rearDoorPocketLighting);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

