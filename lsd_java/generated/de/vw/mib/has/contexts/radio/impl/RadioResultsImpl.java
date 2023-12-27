/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.radio.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASContextResults;
import generated.de.vw.mib.has.contexts.impl.AbstractContextResults;
import generated.de.vw.mib.has.contexts.radio.RadioResults;

public class RadioResultsImpl
extends AbstractContextResults
implements RadioResults {
    public RadioResultsImpl(HASContextResults hASContextResults, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASContextResults, hASBaseContainerFactory);
    }

    @Override
    public void tuneStationResult(int n, int n2) {
        this.callResult(n, 21, n2);
    }

    @Override
    public void tuneResult(int n, int n2) {
        this.callResult(n, 22, n2);
    }

    @Override
    public void nextRadioStationResult(int n, int n2) {
        this.callResult(n, 23, n2);
    }

    @Override
    public void previousRadioStationResult(int n, int n2) {
        this.callResult(n, 24, n2);
    }

    @Override
    public void seekForwardResult(int n, int n2) {
        this.callResult(n, 25, n2);
    }

    @Override
    public void seekBackwardResult(int n, int n2) {
        this.callResult(n, 26, n2);
    }

    @Override
    public void increaseRadioFrequencyResult(int n, int n2) {
        this.callResult(n, 27, n2);
    }

    @Override
    public void decreaseRadioFrequencyResult(int n, int n2) {
        this.callResult(n, 28, n2);
    }

    @Override
    public void storePresetResult(int n, int n2) {
        this.callResult(n, 30, n2);
    }

    @Override
    public void deletePresetResult(int n, int n2) {
        this.callResult(n, 31, n2);
    }
}

