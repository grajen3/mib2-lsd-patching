/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.i18n.I18nLanguage;
import de.vw.mib.lsctng.internal.GuiLscListener;

class GuiLscListener$1
implements Runnable {
    private final /* synthetic */ String val$language;
    private final /* synthetic */ I18nLanguage val$i18n;
    private final /* synthetic */ GuiLscListener this$0;

    GuiLscListener$1(GuiLscListener guiLscListener, String string, I18nLanguage i18nLanguage) {
        this.this$0 = guiLscListener;
        this.val$language = string;
        this.val$i18n = i18nLanguage;
    }

    @Override
    public void run() {
        this.this$0.onNewLanguageInternal(this.val$language, this.val$i18n);
    }
}

