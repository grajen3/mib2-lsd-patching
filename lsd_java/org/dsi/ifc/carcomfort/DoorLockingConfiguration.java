/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.DoorLockingCLSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListTransmittableElements;

public class DoorLockingConfiguration {
    public int numberOfDoors;
    public int numberOfWindows;
    public boolean sunRoof;
    public boolean rearBlindButton;
    public boolean rearBlindSunProtection;
    public boolean rearBlindReverseGear;
    public boolean kessy;
    public boolean bootBlind;
    public boolean individual;
    public int profiles;
    public DoorLockingUserListTransmittableElements profilesTransmittableElements;
    public boolean driverWindowInCO;
    public boolean extendedKeyMapping;
    public boolean keyDetection;
    public boolean atne;
    public boolean temporaryKeyAssignment;
    public boolean sideBlinds;
    public boolean keyMappingAutomatic;
    public DoorLockingCLSettings centralLockingSettings;
    public boolean restore;
    public int numOfParams;

    public DoorLockingConfiguration() {
        this.numberOfDoors = 0;
        this.numberOfWindows = 0;
        this.sunRoof = false;
        this.rearBlindButton = false;
        this.rearBlindSunProtection = false;
        this.rearBlindReverseGear = false;
        this.kessy = false;
        this.bootBlind = false;
        this.individual = false;
        this.profiles = 0;
        this.profilesTransmittableElements = null;
        this.driverWindowInCO = false;
        this.extendedKeyMapping = false;
        this.keyDetection = false;
        this.atne = false;
        this.temporaryKeyAssignment = false;
        this.sideBlinds = false;
        this.keyMappingAutomatic = false;
        this.centralLockingSettings = null;
        this.restore = false;
        this.numOfParams = 0;
    }

    public DoorLockingConfiguration(int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n3, DoorLockingUserListTransmittableElements doorLockingUserListTransmittableElements, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12) {
        this.numberOfDoors = n;
        this.numberOfWindows = n2;
        this.sunRoof = bl;
        this.rearBlindButton = bl2;
        this.rearBlindSunProtection = bl3;
        this.rearBlindReverseGear = bl4;
        this.kessy = bl5;
        this.bootBlind = bl6;
        this.individual = bl7;
        this.profiles = n3;
        this.profilesTransmittableElements = doorLockingUserListTransmittableElements;
        this.driverWindowInCO = bl8;
        this.extendedKeyMapping = bl9;
        this.keyDetection = bl10;
        this.atne = bl11;
        this.temporaryKeyAssignment = bl12;
        this.sideBlinds = false;
        this.keyMappingAutomatic = false;
        this.centralLockingSettings = null;
        this.restore = false;
        this.numOfParams = 0;
    }

    public DoorLockingConfiguration(int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n3, DoorLockingUserListTransmittableElements doorLockingUserListTransmittableElements, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13) {
        this.numberOfDoors = n;
        this.numberOfWindows = n2;
        this.sunRoof = bl;
        this.rearBlindButton = bl2;
        this.rearBlindSunProtection = bl3;
        this.rearBlindReverseGear = bl4;
        this.kessy = bl5;
        this.bootBlind = bl6;
        this.individual = bl7;
        this.profiles = n3;
        this.profilesTransmittableElements = doorLockingUserListTransmittableElements;
        this.driverWindowInCO = bl8;
        this.extendedKeyMapping = bl9;
        this.keyDetection = bl10;
        this.atne = bl11;
        this.temporaryKeyAssignment = bl12;
        this.sideBlinds = bl13;
        this.keyMappingAutomatic = false;
        this.centralLockingSettings = null;
        this.restore = false;
        this.numOfParams = 0;
    }

    public DoorLockingConfiguration(int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n3, DoorLockingUserListTransmittableElements doorLockingUserListTransmittableElements, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, DoorLockingCLSettings doorLockingCLSettings, boolean bl15, int n4) {
        this.numberOfDoors = n;
        this.numberOfWindows = n2;
        this.sunRoof = bl;
        this.rearBlindButton = bl2;
        this.rearBlindSunProtection = bl3;
        this.rearBlindReverseGear = bl4;
        this.kessy = bl5;
        this.bootBlind = bl6;
        this.individual = bl7;
        this.profiles = n3;
        this.profilesTransmittableElements = doorLockingUserListTransmittableElements;
        this.driverWindowInCO = bl8;
        this.extendedKeyMapping = bl9;
        this.keyDetection = bl10;
        this.atne = bl11;
        this.temporaryKeyAssignment = bl12;
        this.sideBlinds = bl13;
        this.keyMappingAutomatic = bl14;
        this.centralLockingSettings = doorLockingCLSettings;
        this.restore = bl15;
        this.numOfParams = n4;
    }

    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    public int getNumberOfWindows() {
        return this.numberOfWindows;
    }

    public boolean isSunRoof() {
        return this.sunRoof;
    }

    public boolean isRearBlindButton() {
        return this.rearBlindButton;
    }

    public boolean isRearBlindSunProtection() {
        return this.rearBlindSunProtection;
    }

    public boolean isRearBlindReverseGear() {
        return this.rearBlindReverseGear;
    }

    public boolean isKessy() {
        return this.kessy;
    }

    public boolean isBootBlind() {
        return this.bootBlind;
    }

    public boolean isIndividual() {
        return this.individual;
    }

    public int getProfiles() {
        return this.profiles;
    }

    public DoorLockingUserListTransmittableElements getProfilesTransmittableElements() {
        return this.profilesTransmittableElements;
    }

    public boolean isDriverWindowInCO() {
        return this.driverWindowInCO;
    }

    public boolean isExtendedKeyMapping() {
        return this.extendedKeyMapping;
    }

    public boolean isKeyDetection() {
        return this.keyDetection;
    }

    public boolean isAtne() {
        return this.atne;
    }

    public boolean isTemporaryKeyAssignment() {
        return this.temporaryKeyAssignment;
    }

    public boolean isSideBlinds() {
        return this.sideBlinds;
    }

    public boolean isKeyMappingAutomatic() {
        return this.keyMappingAutomatic;
    }

    public DoorLockingCLSettings getCentralLockingSettings() {
        return this.centralLockingSettings;
    }

    public boolean isRestore() {
        return this.restore;
    }

    public int getNumOfParams() {
        return this.numOfParams;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3050);
        stringBuffer.append("DoorLockingConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("numberOfDoors");
        stringBuffer.append('=');
        stringBuffer.append(this.numberOfDoors);
        stringBuffer.append(',');
        stringBuffer.append("numberOfWindows");
        stringBuffer.append('=');
        stringBuffer.append(this.numberOfWindows);
        stringBuffer.append(',');
        stringBuffer.append("sunRoof");
        stringBuffer.append('=');
        stringBuffer.append(this.sunRoof);
        stringBuffer.append(',');
        stringBuffer.append("rearBlindButton");
        stringBuffer.append('=');
        stringBuffer.append(this.rearBlindButton);
        stringBuffer.append(',');
        stringBuffer.append("rearBlindSunProtection");
        stringBuffer.append('=');
        stringBuffer.append(this.rearBlindSunProtection);
        stringBuffer.append(',');
        stringBuffer.append("rearBlindReverseGear");
        stringBuffer.append('=');
        stringBuffer.append(this.rearBlindReverseGear);
        stringBuffer.append(',');
        stringBuffer.append("kessy");
        stringBuffer.append('=');
        stringBuffer.append(this.kessy);
        stringBuffer.append(',');
        stringBuffer.append("bootBlind");
        stringBuffer.append('=');
        stringBuffer.append(this.bootBlind);
        stringBuffer.append(',');
        stringBuffer.append("individual");
        stringBuffer.append('=');
        stringBuffer.append(this.individual);
        stringBuffer.append(',');
        stringBuffer.append("profiles");
        stringBuffer.append('=');
        stringBuffer.append(this.profiles);
        stringBuffer.append(',');
        stringBuffer.append("profilesTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.profilesTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append("driverWindowInCO");
        stringBuffer.append('=');
        stringBuffer.append(this.driverWindowInCO);
        stringBuffer.append(',');
        stringBuffer.append("extendedKeyMapping");
        stringBuffer.append('=');
        stringBuffer.append(this.extendedKeyMapping);
        stringBuffer.append(',');
        stringBuffer.append("keyDetection");
        stringBuffer.append('=');
        stringBuffer.append(this.keyDetection);
        stringBuffer.append(',');
        stringBuffer.append("atne");
        stringBuffer.append('=');
        stringBuffer.append(this.atne);
        stringBuffer.append(',');
        stringBuffer.append("temporaryKeyAssignment");
        stringBuffer.append('=');
        stringBuffer.append(this.temporaryKeyAssignment);
        stringBuffer.append(',');
        stringBuffer.append("sideBlinds");
        stringBuffer.append('=');
        stringBuffer.append(this.sideBlinds);
        stringBuffer.append(',');
        stringBuffer.append("keyMappingAutomatic");
        stringBuffer.append('=');
        stringBuffer.append(this.keyMappingAutomatic);
        stringBuffer.append(',');
        stringBuffer.append("centralLockingSettings");
        stringBuffer.append('=');
        stringBuffer.append(this.centralLockingSettings);
        stringBuffer.append(',');
        stringBuffer.append("restore");
        stringBuffer.append('=');
        stringBuffer.append(this.restore);
        stringBuffer.append(',');
        stringBuffer.append("numOfParams");
        stringBuffer.append('=');
        stringBuffer.append(this.numOfParams);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

