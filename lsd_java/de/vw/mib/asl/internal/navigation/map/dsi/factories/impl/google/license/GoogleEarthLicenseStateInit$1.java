/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license;

import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license.GoogleEarthLicenseStateInit;
import de.vw.mib.genericevents.EventGeneric;

class GoogleEarthLicenseStateInit$1
implements ASLOnlineServiceListener {
    private final /* synthetic */ GoogleEarthLicenseStateInit this$0;

    GoogleEarthLicenseStateInit$1(GoogleEarthLicenseStateInit googleEarthLicenseStateInit) {
        this.this$0 = googleEarthLicenseStateInit;
    }

    @Override
    public void updateServiceStatusOnChange(int n) {
        if (n == 0) {
            this.this$0.licenceDelayTimerRetryCount = 0;
            GoogleEarthLicenseStateInit.access$002(this.this$0, true);
            GoogleEarthLicenseStateInit.access$100(this.this$0);
        } else if (this.this$0.licenceDelayTimerRetryCount < 2) {
            ++this.this$0.licenceDelayTimerRetryCount;
            EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.this$0.target.getTargetId(), this.this$0.target.getTargetId(), 1482962176);
            this.this$0.target.startTimer(eventGeneric, (long)0, false);
        } else {
            this.this$0.licenceDelayTimerRetryCount = 0;
            this.this$0.disableGoogleEarthLastModeAndStayOnOnboardMap();
        }
    }
}

