/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.AppUIController;
import de.vw.mib.app.framework.internal.AppVisibilityManager;

final class AppVisibilityManager$VisibilityGrant {
    final String layerLabel;
    final String screenAreaId;
    final AppUIController visibleApp;
    private final /* synthetic */ AppVisibilityManager this$0;

    protected AppVisibilityManager$VisibilityGrant(AppVisibilityManager appVisibilityManager, String string, String string2, AppUIController appUIController) {
        this.this$0 = appVisibilityManager;
        this.screenAreaId = string;
        this.layerLabel = string2;
        this.visibleApp = appUIController;
    }

    void grantVisibility() {
        this.visibleApp.grantVisibility(this.layerLabel, new String[]{this.screenAreaId}, null);
    }

    void revokeVisibility() {
        this.visibleApp.revokeVisibility(this.layerLabel, new String[]{this.screenAreaId}, null);
    }
}

