/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.entertainmentmanager.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASContextResults;
import generated.de.vw.mib.has.contexts.entertainmentmanager.EntertainmentManagerResults;
import generated.de.vw.mib.has.contexts.impl.AbstractContextResults;

public class EntertainmentManagerResultsImpl
extends AbstractContextResults
implements EntertainmentManagerResults {
    public EntertainmentManagerResultsImpl(HASContextResults hASContextResults, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASContextResults, hASBaseContainerFactory);
    }

    @Override
    public void activateRadioBandResult(int n, int n2) {
        this.callResult(n, 14, n2);
    }

    @Override
    public void activateMediaSourceResult(int n, int n2) {
        this.callResult(n, 18, n2);
    }

    @Override
    public void activateAppConnectAudioResult(int n, int n2) {
        this.callResult(n, 39, n2);
    }
}

