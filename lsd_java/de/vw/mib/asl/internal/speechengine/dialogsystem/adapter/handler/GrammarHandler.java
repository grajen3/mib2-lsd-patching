/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler;

import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;

public interface GrammarHandler {
    default public void responseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    default public void responseUnloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    default public void updateGrammarState(GrammarStateInfo grammarStateInfo) {
    }
}

