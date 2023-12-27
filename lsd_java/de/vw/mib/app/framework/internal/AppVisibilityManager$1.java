/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.AppVisibilityManager;

class AppVisibilityManager$1
implements Runnable {
    private final /* synthetic */ String val$screenArea;
    private final /* synthetic */ String val$content;
    private final /* synthetic */ AppVisibilityManager this$0;

    AppVisibilityManager$1(AppVisibilityManager appVisibilityManager, String string, String string2) {
        this.this$0 = appVisibilityManager;
        this.val$screenArea = string;
        this.val$content = string2;
    }

    @Override
    public void run() {
        this.this$0.onUpdateContent(this.val$screenArea, this.val$content);
    }
}

