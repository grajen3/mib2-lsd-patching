/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.internal.connectivity.StateWLANMain;
import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityWLANHotspotHotspotListCollector;
import java.util.Comparator;

class StateWLANMain$1
implements Comparator {
    private final /* synthetic */ StateWLANMain this$0;

    StateWLANMain$1(StateWLANMain stateWLANMain) {
        this.this$0 = stateWLANMain;
    }

    @Override
    public int compare(Object object, Object object2) {
        ConnectivityWLANHotspotHotspotListCollector connectivityWLANHotspotHotspotListCollector = (ConnectivityWLANHotspotHotspotListCollector)object;
        if (connectivityWLANHotspotHotspotListCollector.discoveredNetwork.encryptionType == 1 || connectivityWLANHotspotHotspotListCollector.discoveredNetwork.encryptionType == 5 || connectivityWLANHotspotHotspotListCollector.discoveredNetwork.encryptionType == 4 || connectivityWLANHotspotHotspotListCollector.discoveredNetwork.encryptionType == 3 || connectivityWLANHotspotHotspotListCollector.discoveredNetwork.encryptionType == 2 || connectivityWLANHotspotHotspotListCollector.discoveredNetwork.encryptionType == 8) {
            return 1;
        }
        return 0;
    }
}

