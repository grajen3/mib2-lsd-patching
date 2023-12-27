/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.AppUIController;
import de.vw.mib.app.framework.internal.AppVisibilityManager;

final class AppVisibilityManager$ContentProvider {
    private final String appName;
    private final AppUIController appUIController;
    private final String contentId;
    private final String layerLabel;
    private final /* synthetic */ AppVisibilityManager this$0;

    AppVisibilityManager$ContentProvider(AppVisibilityManager appVisibilityManager, String string, AppUIController appUIController, String string2, String string3) {
        this.this$0 = appVisibilityManager;
        this.appName = string;
        this.appUIController = appUIController;
        this.layerLabel = string2;
        this.contentId = string3;
    }

    void activate() {
        if (this.this$0.logger.isTraceEnabled(32)) {
            this.this$0.logger.trace(32).append("activate content provider - content:").append(this.contentId).append(", app: ").append(this.appName).log();
        }
        this.appUIController.requestVisibility(this.layerLabel);
    }
}

