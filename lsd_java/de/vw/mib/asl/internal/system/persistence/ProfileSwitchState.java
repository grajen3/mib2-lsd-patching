/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

class ProfileSwitchState {
    private byte NO_PENDING_PROFILE_SWITCH;
    private boolean isProfileSwitchRunning;
    private byte pendingProfile;

    ProfileSwitchState() {
        this.pendingProfile = this.NO_PENDING_PROFILE_SWITCH = (byte)-1;
    }

    public boolean isProfileSwitchRunning() {
        return this.isProfileSwitchRunning;
    }

    public void setProfileSwitchRunning(boolean bl) {
        this.isProfileSwitchRunning = bl;
    }

    public byte getPendingProfile() {
        return this.pendingProfile;
    }

    public void setPendingProfile(byte by) {
        this.pendingProfile = by;
    }

    public void clearPendingProfile() {
        this.pendingProfile = this.NO_PENDING_PROFILE_SWITCH;
    }

    public boolean isProfileSwitchPending() {
        return this.pendingProfile != this.NO_PENDING_PROFILE_SWITCH;
    }
}

