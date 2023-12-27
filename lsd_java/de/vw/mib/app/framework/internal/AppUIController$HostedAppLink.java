/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.AppUIController;

final class AppUIController$HostedAppLink {
    boolean visible = false;
    final String screenAreaId;
    final String layerLabel;
    final AppUIController hostedApp;
    private final /* synthetic */ AppUIController this$0;

    protected AppUIController$HostedAppLink(AppUIController appUIController, String string, String string2, AppUIController appUIController2) {
        this.this$0 = appUIController;
        this.screenAreaId = string;
        this.layerLabel = string2;
        this.hostedApp = appUIController2;
    }

    void grantVisibility() {
        if (this.visible) {
            AppUIController.access$100(this.this$0).warn(64).append(AppUIController.access$000(this.this$0)).append(" - grant visibility for a visible app!").log();
            this.hostedApp.revokeVisibility(this.layerLabel, this.this$0.getPathForProvidedScreenArea(this.screenAreaId), this.this$0);
        }
        this.hostedApp.grantVisibility(this.layerLabel, this.this$0.getPathForProvidedScreenArea(this.screenAreaId), this.this$0);
        this.visible = true;
    }

    void revokeVisibility() {
        this.hostedApp.revokeVisibility(this.layerLabel, this.this$0.getPathForProvidedScreenArea(this.screenAreaId), this.this$0);
        this.visible = false;
    }
}

