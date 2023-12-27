/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.sound.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASDatapool;
import generated.de.vw.mib.has.containers.BalanceFaderContainer;
import generated.de.vw.mib.has.containers.BalanceFaderRangesContainer;
import generated.de.vw.mib.has.containers.SoundVolumeContainer;
import generated.de.vw.mib.has.containers.SoundVolumeRangesContainer;
import generated.de.vw.mib.has.contexts.impl.AbstractContextProperties;
import generated.de.vw.mib.has.contexts.sound.SoundProperties;

public class SoundPropertiesImpl
extends AbstractContextProperties
implements SoundProperties {
    public SoundPropertiesImpl(HASDatapool hASDatapool, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASDatapool, hASBaseContainerFactory);
    }

    @Override
    public void updateSoundVolume(SoundVolumeContainer soundVolumeContainer) {
        this.updateProperty(25, soundVolumeContainer);
    }

    @Override
    public void updateSoundVolumeRanges(SoundVolumeRangesContainer soundVolumeRangesContainer) {
        this.updateProperty(26, soundVolumeRangesContainer);
    }

    @Override
    public void updateBalanceFader(BalanceFaderContainer balanceFaderContainer) {
        this.updateProperty(45, balanceFaderContainer);
    }

    @Override
    public void updateBalanceFaderRanges(BalanceFaderRangesContainer balanceFaderRangesContainer) {
        this.updateProperty(46, balanceFaderRangesContainer);
    }
}

