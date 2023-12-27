/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.pnav;

import de.vw.mib.asl.api.navigation.IPnavLikelyDestination;
import de.vw.mib.asl.internal.navinfotile.pnav.DefaultPnavLikelyDestination;

public class PnavLikelyDestinationWrapper {
    private IPnavLikelyDestination pnavLikelyDestination;
    private boolean valid = false;

    public IPnavLikelyDestination getPnavLikelyDestination() {
        return this.pnavLikelyDestination;
    }

    public boolean isValid() {
        return this.valid;
    }

    public PnavLikelyDestinationWrapper(IPnavLikelyDestination iPnavLikelyDestination) {
        if (null == iPnavLikelyDestination) {
            this.pnavLikelyDestination = new DefaultPnavLikelyDestination();
        } else {
            this.pnavLikelyDestination = iPnavLikelyDestination;
            this.valid = true;
        }
    }
}

