/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.appconnecttiles.component;

import de.vw.mib.appadapter.appconnecttiles.component.AppConnectTileApiListener;
import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAppConnectAppAdapter;

class AppConnectTileApiListener$1
implements ASLSmartphoneIntegrationAppConnectAppAdapter {
    private final /* synthetic */ AppConnectTileApiListener this$0;

    AppConnectTileApiListener$1(AppConnectTileApiListener appConnectTileApiListener) {
        this.this$0 = appConnectTileApiListener;
    }

    @Override
    public void updateDevicename(String string) {
        AppConnectTileApiListener.access$100(this.this$0).createLogger(128).info(128).append("Update Devicename ").append(string).append(" by ASL for Instance ID: ").append(AppConnectTileApiListener.access$000(this.this$0).getInstanceID()).log();
        this.this$0.updateCurrentDeviceName(string);
    }

    @Override
    public void updateConnectionMethod(int n) {
        AppConnectTileApiListener.access$100(this.this$0).createLogger(128).info(128).append("Update Connectionmethod ").append(n).append(" by ASL for Instance ID: ").append(AppConnectTileApiListener.access$000(this.this$0).getInstanceID()).log();
        this.this$0.updateCurrentConnectionMethod(n);
    }

    @Override
    public void isSwapStateUpdated(boolean bl, boolean bl2, boolean bl3) {
        AppConnectTileApiListener.access$100(this.this$0).createLogger(128).info(128).append("Update Old SWAP State").append(" by ASL for Instance ID: ").append(AppConnectTileApiListener.access$000(this.this$0).getInstanceID()).log();
        this.this$0.updateSwapState();
    }

    @Override
    public void isSwapStateUpdated(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl4) {
            AppConnectTileApiListener.access$100(this.this$0).createLogger(128).info(128).append("Update New SWAP State ").append(bl4).append(" by ASL for Instance ID: ").append(AppConnectTileApiListener.access$000(this.this$0).getInstanceID()).log();
            this.this$0.updateSwapState();
        }
    }
}

