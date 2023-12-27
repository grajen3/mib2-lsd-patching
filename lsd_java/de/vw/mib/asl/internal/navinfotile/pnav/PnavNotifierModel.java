/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.pnav;

import de.vw.mib.asl.api.navigation.IPnavLikelyDestination;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navinfotile.pnav.PnavLikelyDestinationWrapper;
import generated.de.vw.mib.asl.internal.ListManager;

public class PnavNotifierModel {
    void updateListLikelyDestinations(IPnavLikelyDestination[] iPnavLikelyDestinationArray) {
        Object[] objectArray = new PnavLikelyDestinationWrapper[]{new PnavLikelyDestinationWrapper(null), new PnavLikelyDestinationWrapper(null)};
        if (iPnavLikelyDestinationArray != null) {
            ListManager.getGenericASLList(472799744).updateList(iPnavLikelyDestinationArray);
            if (iPnavLikelyDestinationArray.length >= 1) {
                objectArray[0] = new PnavLikelyDestinationWrapper(iPnavLikelyDestinationArray[0]);
            }
            if (iPnavLikelyDestinationArray.length >= 2) {
                objectArray[1] = new PnavLikelyDestinationWrapper(iPnavLikelyDestinationArray[1]);
            }
        }
        ListManager.getGenericASLList(724457984).updateList(objectArray);
    }

    void updateListSelectedDestination(IPnavLikelyDestination iPnavLikelyDestination) {
        if (iPnavLikelyDestination != null) {
            ListManager.getGenericASLList(489576960).updateList(new IPnavLikelyDestination[]{iPnavLikelyDestination});
        }
    }

    void notifyCombinedCalculationStateChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(456022528, n);
    }

    void notifyPnavEnabledChanged(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(439245312, bl);
    }

    void notifyPNavStatusChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(422468096, n);
    }

    void notifyPNavVisibleChanged(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(405690880, bl);
    }

    void setDefaults() {
        this.updateListLikelyDestinations(new IPnavLikelyDestination[0]);
        this.notifyCombinedCalculationStateChanged(0);
        this.notifyPnavEnabledChanged(false);
        this.notifyPNavStatusChanged(0);
        this.notifyPNavVisibleChanged(false);
    }
}

