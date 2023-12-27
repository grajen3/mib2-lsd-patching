/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.appstate;

import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.GrammarController;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public class DeactivationByLanguage {
    private static int TRACE_CLASS = 8;
    private static String TRACE_PREFIX = "[DeactivationByLanguage] ";
    private final GrammarController grammarController;
    private final Logger logger;
    private boolean isDeactivated;

    public DeactivationByLanguage(Logger logger, GrammarController grammarController) {
        this.logger = logger;
        this.grammarController = grammarController;
        this.isDeactivated = false;
    }

    public void start() {
        LogMessage logMessage = this.logger.info(TRACE_CLASS);
        logMessage.append(TRACE_PREFIX);
        logMessage.append("start deactivation by language");
        logMessage.log();
        this.isDeactivated = true;
        this.grammarController.pause();
        Grammar[] grammarArray = this.grammarController.getCurrentGrammarSet();
        GrammarInfo[] grammarInfoArray = this.getGrammarInfo(grammarArray);
        this.grammarController.getCommandLoaderInternal().unload(grammarInfoArray);
    }

    public void undo() {
        if (this.isDeactivated) {
            LogMessage logMessage = this.logger.info(TRACE_CLASS);
            logMessage.append(TRACE_PREFIX);
            logMessage.append("undo deactivation by language");
            logMessage.log();
            Grammar[] grammarArray = this.grammarController.getCurrentGrammarSet();
            this.grammarController.getCommandLoaderInternal().load(grammarArray);
            this.grammarController.resume();
            this.grammarController.reloadSlots();
            this.isDeactivated = false;
        } else if (this.logger.isTraceEnabled(TRACE_CLASS)) {
            LogMessage logMessage = this.logger.trace(TRACE_CLASS);
            logMessage.append(TRACE_PREFIX);
            logMessage.append("undo skipped because not deactivated by language");
            logMessage.log();
        }
    }

    private GrammarInfo[] getGrammarInfo(Grammar[] grammarArray) {
        if (grammarArray == null) {
            grammarArray = new Grammar[]{};
        }
        GrammarInfo[] grammarInfoArray = new GrammarInfo[grammarArray.length];
        for (int i2 = 0; i2 < grammarArray.length; ++i2) {
            grammarInfoArray[i2] = new GrammarInfo(grammarArray[i2].getGrammarId(), grammarArray[i2].getCommandHierarchy());
        }
        return grammarInfoArray;
    }
}

