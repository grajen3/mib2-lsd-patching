/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.navigation;

import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.vw.mib.asi.navigation.ASINavigation;
import de.vw.mib.asi.navigation.ASINavigationListener;
import de.vw.mib.asi.navigation.ASINavigationResponse;

public class ASINavigationAdapter
implements ASINavigation {
    protected ASINavigationListener listener;

    @Override
    public ASINavigationListener getASINavigationListener() {
        return this.listener;
    }

    @Override
    public void setASINavigationListener(ASINavigationListener aSINavigationListener) {
        this.listener = aSINavigationListener;
    }

    @Override
    public void startGuidanceToDestinations(DestinationInfo[] destinationInfoArray, ASINavigationResponse aSINavigationResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}

