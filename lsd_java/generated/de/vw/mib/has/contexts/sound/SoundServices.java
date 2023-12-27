/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.sound;

import de.vw.mib.has.HASContextServices;
import generated.de.vw.mib.has.containers.BalanceFaderContainer;

public interface SoundServices
extends HASContextServices {
    default public void increaseVolume(int n) {
    }

    default public void decreaseVolume(int n) {
    }

    default public void muteEntertainment(int n) {
    }

    default public void unmuteEntertainment(int n) {
    }

    default public void setBalanceFader(int n, BalanceFaderContainer balanceFaderContainer) {
    }

    default public void getSoundVolume() {
    }

    default public void getSoundVolumeRanges() {
    }

    default public void getBalanceFader() {
    }

    default public void getBalanceFaderRanges() {
    }
}

