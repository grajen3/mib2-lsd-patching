/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.CarPosition;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.NextDestinationInfo;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.navigation.ASINavigationListener;
import de.vw.mib.asi.navigation.impl.ASINavigationBaseServiceImpl;

class ASINavigationBaseServiceImpl$ListenerProxy
implements ASINavigationListener {
    private final /* synthetic */ ASINavigationBaseServiceImpl this$0;

    ASINavigationBaseServiceImpl$ListenerProxy(ASINavigationBaseServiceImpl aSINavigationBaseServiceImpl) {
        this.this$0 = aSINavigationBaseServiceImpl;
    }

    @Override
    public void updateCarPosition(CarPosition carPosition, boolean bl) {
        try {
            this.this$0.updateCarPosition(carPosition, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateDestinationInfo(DestinationInfo[] destinationInfoArray, boolean bl) {
        try {
            this.this$0.updateDestinationInfo(destinationInfoArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateDestinationsForGuidance(DestinationInfo[] destinationInfoArray, boolean bl) {
        try {
            this.this$0.updateDestinationsForGuidance(destinationInfoArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateNextDestinationInfo(NextDestinationInfo nextDestinationInfo, boolean bl) {
        try {
            this.this$0.updateNextDestinationInfo(nextDestinationInfo, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateNightDesignRequested(boolean bl, boolean bl2) {
        try {
            this.this$0.updateNightDesignRequested(bl, bl2);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateRouteGuidanceActive(boolean bl, boolean bl2) {
        try {
            this.this$0.updateRouteGuidanceActive(bl, bl2);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

