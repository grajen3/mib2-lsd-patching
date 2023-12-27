/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.sound;

import de.vw.mib.has.HASContextProperties;
import generated.de.vw.mib.has.containers.BalanceFaderContainer;
import generated.de.vw.mib.has.containers.BalanceFaderRangesContainer;
import generated.de.vw.mib.has.containers.SoundVolumeContainer;
import generated.de.vw.mib.has.containers.SoundVolumeRangesContainer;

public interface SoundProperties
extends HASContextProperties {
    default public void updateSoundVolume(SoundVolumeContainer soundVolumeContainer) {
    }

    default public void updateSoundVolumeRanges(SoundVolumeRangesContainer soundVolumeRangesContainer) {
    }

    default public void updateBalanceFader(BalanceFaderContainer balanceFaderContainer) {
    }

    default public void updateBalanceFaderRanges(BalanceFaderRangesContainer balanceFaderRangesContainer) {
    }
}

