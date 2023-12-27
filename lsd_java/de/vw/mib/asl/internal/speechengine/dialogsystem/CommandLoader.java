/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem;

import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoaderObserver;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public interface CommandLoader {
    default public void registerObserver(CommandLoaderObserver commandLoaderObserver) {
    }

    default public Grammar wrapToGrammar(Command command) {
    }

    default public GrammarInfo wrapToGrammarInfo(Command command) {
    }

    default public void load(Grammar[] grammarArray) {
    }

    default public void loadSlot(int n, String[] stringArray, long[] lArray) {
    }

    default public void unload(GrammarInfo[] grammarInfoArray) {
    }
}

