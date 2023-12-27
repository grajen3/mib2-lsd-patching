/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar;

import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.observer.InitialLscObserverCallback;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.GrammarController;

class GrammarController$1
implements InitialLscObserverCallback {
    private final /* synthetic */ GrammarController this$0;

    GrammarController$1(GrammarController grammarController) {
        this.this$0 = grammarController;
    }

    @Override
    public void onLanguageSet() {
        this.this$0.reloadSlots();
        this.this$0.getCommandLoaderInternal().load(this.this$0.getCurrentGrammarSet());
    }
}

