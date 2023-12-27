/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar;

import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoader;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoaderObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.CommandLoaderImpl;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public class CommandLoaderEmpty
implements CommandLoader {
    private static final int TRACE_CLASS;
    private static final String TRACE_PREFIX;
    private final CommandLoaderImpl commandLoader;
    private final Logger logger;

    public CommandLoaderEmpty(CommandLoaderImpl commandLoaderImpl, Logger logger) {
        this.commandLoader = commandLoaderImpl;
        this.logger = logger;
    }

    @Override
    public void registerObserver(CommandLoaderObserver commandLoaderObserver) {
    }

    @Override
    public Grammar wrapToGrammar(Command command) {
        return this.commandLoader.wrapToGrammar(command);
    }

    @Override
    public GrammarInfo wrapToGrammarInfo(Command command) {
        return this.commandLoader.wrapToGrammarInfo(command);
    }

    @Override
    public void load(Grammar[] grammarArray) {
        this.logger.info(128, "[CommandLoaderEmpty] discart load()");
    }

    @Override
    public void loadSlot(int n, String[] stringArray, long[] lArray) {
        this.logger.info(128, "[CommandLoaderEmpty] discart loadSlot()");
    }

    @Override
    public void unload(GrammarInfo[] grammarInfoArray) {
        this.logger.info(128, "[CommandLoaderEmpty] discart unload()");
    }
}

