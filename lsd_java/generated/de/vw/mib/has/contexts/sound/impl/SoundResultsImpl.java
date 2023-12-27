/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.sound.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASContextResults;
import generated.de.vw.mib.has.contexts.impl.AbstractContextResults;
import generated.de.vw.mib.has.contexts.sound.SoundResults;

public class SoundResultsImpl
extends AbstractContextResults
implements SoundResults {
    public SoundResultsImpl(HASContextResults hASContextResults, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASContextResults, hASBaseContainerFactory);
    }

    @Override
    public void increaseVolumeResult(int n, int n2) {
        this.callResult(n, 10, n2);
    }

    @Override
    public void decreaseVolumeResult(int n, int n2) {
        this.callResult(n, 11, n2);
    }

    @Override
    public void muteEntertainmentResult(int n, int n2) {
        this.callResult(n, 12, n2);
    }

    @Override
    public void unmuteEntertainmentResult(int n, int n2) {
        this.callResult(n, 13, n2);
    }

    @Override
    public void setBalanceFaderResult(int n, int n2) {
        this.callResult(n, 34, n2);
    }
}

