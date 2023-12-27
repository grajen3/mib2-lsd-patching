/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.onlineglobalwizardpage;

import de.vw.mib.appadapter.onlineglobalwizardpage.OnlineGlobalWizardPageAdapter;
import de.vw.mib.asl.api.online.ASLOnlineServiceAvailabilityListener;

class OnlineGlobalWizardPageAdapter$1
implements ASLOnlineServiceAvailabilityListener {
    private final /* synthetic */ OnlineGlobalWizardPageAdapter this$0;

    OnlineGlobalWizardPageAdapter$1(OnlineGlobalWizardPageAdapter onlineGlobalWizardPageAdapter) {
        this.this$0 = onlineGlobalWizardPageAdapter;
    }

    @Override
    public void updateOnlineServicesAvailabilityStatus(int n) {
        OnlineGlobalWizardPageAdapter.access$100(this.this$0, n, OnlineGlobalWizardPageAdapter.access$000(this.this$0));
        OnlineGlobalWizardPageAdapter.access$100(this.this$0, n, OnlineGlobalWizardPageAdapter.access$200(this.this$0));
    }
}

