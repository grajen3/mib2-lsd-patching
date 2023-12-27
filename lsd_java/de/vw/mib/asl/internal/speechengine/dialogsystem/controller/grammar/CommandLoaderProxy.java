/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar;

import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoader;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoaderObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.GrammarController;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public class CommandLoaderProxy
implements CommandLoader {
    private GrammarController grammarController;
    private CommandLoader internalCommandLoader;

    CommandLoaderProxy(CommandLoader commandLoader, GrammarController grammarController) {
        this.grammarController = grammarController;
        this.internalCommandLoader = commandLoader;
    }

    void switchCommandLoader(CommandLoader commandLoader) {
        this.internalCommandLoader = commandLoader;
    }

    @Override
    public void registerObserver(CommandLoaderObserver commandLoaderObserver) {
        this.grammarController.registerObserver(commandLoaderObserver);
    }

    @Override
    public Grammar wrapToGrammar(Command command) {
        return this.internalCommandLoader.wrapToGrammar(command);
    }

    @Override
    public GrammarInfo wrapToGrammarInfo(Command command) {
        return this.internalCommandLoader.wrapToGrammarInfo(command);
    }

    @Override
    public void load(Grammar[] grammarArray) {
        this.internalCommandLoader.load(grammarArray);
    }

    @Override
    public void loadSlot(int n, String[] stringArray, long[] lArray) {
        this.internalCommandLoader.loadSlot(n, stringArray, lArray);
    }

    @Override
    public void unload(GrammarInfo[] grammarInfoArray) {
        this.internalCommandLoader.unload(grammarInfoArray);
    }
}

