/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.sound.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface SoundSettings
extends Persistable {
    default public int getEqMode() {
    }

    default public void setEqMode(int n) {
    }

    default public short getEqUserTreble() {
    }

    default public void setEqUserTreble(short s) {
    }

    default public short getEqUserMiddle() {
    }

    default public void setEqUserMiddle(short s) {
    }

    default public short getEqUserBass() {
    }

    default public void setEqUserBass(short s) {
    }

    default public int getEqPresetCanton() {
    }

    default public void setEqPresetCanton(int n) {
    }

    default public boolean isUserMuteActive() {
    }

    default public void setUserMuteActive(boolean bl) {
    }
}

