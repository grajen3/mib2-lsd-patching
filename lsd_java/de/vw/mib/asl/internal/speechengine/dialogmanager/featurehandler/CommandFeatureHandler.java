/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.CommandCache;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.CommandUtils;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoader;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoaderObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.features.client.state.CommandStateFeature;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.NBestList;

public class CommandFeatureHandler
implements FeatureHandler,
CommandLoaderObserver,
DialogManagerStateListener {
    protected DialogManagerLogger logger = new DialogManagerLogger("[CommandFeatureHandler] ");
    private static final int[] COMMAND_MODES = new int[]{0, 1, 2, 3};
    private static final int MODE_SET;
    private static final int MODE_UPDATE;
    private DialogManagerInternal dialogManager;
    private CommandLoader commandLoader;
    private int dialogManagerState;
    private IntObjectMap commandCaches;
    private CommandCache extraHelpCommands;
    private CommandCache extraGlobalCommands;
    private List loadQueue;
    private List unloadQueue;
    private int updateMode;

    public CommandFeatureHandler(DialogManagerInternal dialogManagerInternal, SpeechDialogSystem speechDialogSystem) {
        this.dialogManager = dialogManagerInternal;
        this.loadQueue = new ArrayList();
        this.unloadQueue = new ArrayList();
        this.commandCaches = new IntObjectOptHashMap();
        for (int i2 = 0; i2 < COMMAND_MODES.length; ++i2) {
            this.commandCaches.put(COMMAND_MODES[i2], new CommandCache());
        }
        this.extraHelpCommands = new CommandCache();
        this.extraGlobalCommands = new CommandCache();
        dialogManagerInternal.registerDialogManagerStateListener(this);
        dialogManagerInternal.registerFeatureHandler(302, this);
        dialogManagerInternal.registerFeatureHandlerDone(this);
        this.commandLoader = speechDialogSystem.getCommandLoader();
        this.commandLoader.registerObserver(this);
    }

    @Override
    public void onDialogManagerStateChanged(int n, int n2) {
        CommandCache commandCache;
        int n3;
        int n4;
        this.dialogManagerState = n2;
        if (n == 2 && n2 == 3) {
            Object object;
            Collection collection = this.extraGlobalCommands.getGrammarInfos();
            if (collection.size() > 0) {
                object = new GrammarInfo[collection.size()];
                collection.toArray((Object[])object);
                this.commandLoader.unload((GrammarInfo[])object);
            }
            if ((object = this.extraHelpCommands.getGrammars()).size() > 0) {
                Object[] objectArray = new Grammar[object.size()];
                object.toArray(objectArray);
                this.commandLoader.load((Grammar[])objectArray);
            }
            return;
        }
        if (n == 3 && n2 == 2) {
            Object object;
            Collection collection = this.extraHelpCommands.getGrammarInfos();
            if (collection.size() > 0) {
                object = new GrammarInfo[collection.size()];
                collection.toArray((Object[])object);
                this.commandLoader.unload((GrammarInfo[])object);
            }
            if ((object = this.extraGlobalCommands.getGrammars()).size() > 0) {
                Object[] objectArray = new Grammar[object.size()];
                object.toArray(objectArray);
                this.commandLoader.load((Grammar[])objectArray);
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (n4 = 0; n4 < COMMAND_MODES.length; ++n4) {
            n3 = COMMAND_MODES[n4];
            if (!this.isCommandLoaded(n3, n) || this.isCommandLoaded(n3, n2)) continue;
            commandCache = (CommandCache)this.commandCaches.get(n3);
            arrayList2.addAll(commandCache.getGrammarInfos());
        }
        for (n4 = 0; n4 < COMMAND_MODES.length; ++n4) {
            n3 = COMMAND_MODES[n4];
            if (this.isCommandLoaded(n3, n) || !this.isCommandLoaded(n3, n2)) continue;
            commandCache = (CommandCache)this.commandCaches.get(n3);
            arrayList.addAll(commandCache.getGrammars());
        }
        if (arrayList2.size() > 0) {
            Object[] objectArray = new GrammarInfo[arrayList2.size()];
            arrayList2.toArray(objectArray);
            this.commandLoader.unload((GrammarInfo[])objectArray);
        }
        if (arrayList.size() > 0) {
            Object[] objectArray = new Grammar[arrayList.size()];
            arrayList.toArray(objectArray);
            this.commandLoader.load((Grammar[])objectArray);
        }
    }

    @Override
    public void setCurrentDialogManagerState(int n) {
        this.dialogManagerState = n;
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.handleCommandFeature((CommandStateFeature)feature);
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.handleCommandFeature((CommandStateFeature)feature);
    }

    @Override
    public boolean handleDone() {
        this.updateMode = 0;
        this.onDone();
        return false;
    }

    @Override
    public boolean updateDone() {
        this.updateMode = 1;
        this.onDone();
        return false;
    }

    private void onDone() {
        Object[] objectArray;
        boolean bl = false;
        if (this.unloadQueue.size() != 0) {
            objectArray = new Command[this.unloadQueue.size()];
            this.unloadQueue.toArray(objectArray);
            this.postUnloadCommands((Command[])objectArray);
            this.unloadQueue.clear();
        }
        if (this.loadQueue.size() != 0) {
            objectArray = new Command[this.loadQueue.size()];
            this.loadQueue.toArray(objectArray);
            this.postLoadCommands((Command[])objectArray);
            if (this.updateMode == 0 && this.dialogManagerState != 4) {
                bl = this.hasDialogCommands((Command[])objectArray);
            }
            this.loadQueue.clear();
        }
        if (bl) {
            this.dialogManager.setState(4);
        }
    }

    private boolean hasDialogCommands(Command[] commandArray) {
        for (int i2 = 0; i2 < commandArray.length; ++i2) {
            if (commandArray[i2].getMode() != 3) continue;
            return true;
        }
        return false;
    }

    private void handleCommandFeature(CommandStateFeature commandStateFeature) {
        if (commandStateFeature.isCommandsToLoadValid()) {
            this.loadCommands(commandStateFeature.getCommandsToLoad());
        }
        if (commandStateFeature.isCommandsToUnloadValid()) {
            this.unloadCommands(commandStateFeature.getCommandsToUnload());
        }
    }

    public void loadCommands(Command[] commandArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("loadCommands() : ").append(this.commandsArrayToString(commandArray)).toString());
        }
        for (int i2 = 0; i2 < commandArray.length; ++i2) {
            this.loadQueue.add(commandArray[i2]);
        }
    }

    private void postLoadCommands(Command[] commandArray) {
        ArrayList arrayList = new ArrayList();
        if (this.updateMode == 1) {
            for (int i2 = 0; i2 < commandArray.length; ++i2) {
                Grammar grammar = this.loadCommand(commandArray[i2]);
                if (grammar == null) continue;
                arrayList.add(grammar);
            }
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < commandArray.length; ++i3) {
                if (commandArray[i3].getMode() == 3) {
                    arrayList2.add(commandArray[i3]);
                    continue;
                }
                Grammar grammar = this.loadCommand(commandArray[i3]);
                if (grammar == null) continue;
                arrayList.add(grammar);
            }
            arrayList.addAll(this.replaceDialogCommands(arrayList2));
        }
        if (arrayList.size() == 0) {
            return;
        }
        Object[] objectArray = new Grammar[arrayList.size()];
        arrayList.toArray(objectArray);
        this.commandLoader.load((Grammar[])objectArray);
    }

    private List replaceDialogCommands(List list) {
        Object object;
        int n;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        CommandCache commandCache = (CommandCache)this.commandCaches.get(3);
        Collection collection = commandCache.getDifferenceCommands(list);
        Object[] objectArray = new Command[collection.size()];
        collection.toArray(objectArray);
        for (n = 0; n < objectArray.length; ++n) {
            object = this.unloadCommand((Command)objectArray[n]);
            if (object == null) continue;
            arrayList2.add(object);
        }
        for (n = 0; n < list.size(); ++n) {
            object = this.loadCommand((Command)list.get(n));
            if (object == null) continue;
            arrayList.add(object);
        }
        if (arrayList2.size() > 0) {
            Object[] objectArray2 = new GrammarInfo[arrayList2.size()];
            arrayList2.toArray(objectArray2);
            this.commandLoader.unload((GrammarInfo[])objectArray2);
        }
        return arrayList;
    }

    public void unloadCommands(Command[] commandArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("unloadCommands() : ").append(this.commandsArrayToString(commandArray)).toString());
        }
        for (int i2 = 0; i2 < commandArray.length; ++i2) {
            this.unloadQueue.add(commandArray[i2]);
        }
    }

    private void postUnloadCommands(Command[] commandArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < commandArray.length; ++i2) {
            GrammarInfo grammarInfo = this.unloadCommand(commandArray[i2]);
            if (grammarInfo == null) continue;
            arrayList.add(grammarInfo);
        }
        if (arrayList.size() == 0) {
            return;
        }
        Object[] objectArray = new GrammarInfo[arrayList.size()];
        arrayList.toArray(objectArray);
        this.commandLoader.unload((GrammarInfo[])objectArray);
    }

    private Grammar loadCommand(Command command) {
        if (!this.commandCaches.containsKey(command.getMode())) {
            this.logger.error(new StringBuffer().append("unknown CommandMode : ").append(command.getMode()).toString());
            return null;
        }
        CommandCache commandCache = (CommandCache)this.commandCaches.get(command.getMode());
        if (commandCache.contains(command)) {
            if (command.getMode() == 3) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("Update already loaded command : ").append(command.toString()).toString());
                }
                commandCache.updateCommand(command);
            } else {
                this.logger.error(new StringBuffer().append("command is already loaded : ").append(command.toString()).toString());
            }
            return null;
        }
        Grammar grammar = this.commandLoader.wrapToGrammar(command);
        GrammarInfo grammarInfo = this.commandLoader.wrapToGrammarInfo(command);
        commandCache.put(command, grammar, grammarInfo);
        if (command.getMode() == 1) {
            CommandCache commandCache2 = (CommandCache)this.commandCaches.get(2);
            if (commandCache2.contains(command)) {
                this.extraHelpCommands.remove(command);
            } else {
                this.extraGlobalCommands.put(command, grammar, grammarInfo);
            }
        } else if (command.getMode() == 2) {
            CommandCache commandCache3 = (CommandCache)this.commandCaches.get(1);
            if (commandCache3.contains(command)) {
                this.extraGlobalCommands.remove(command);
            } else {
                this.extraHelpCommands.put(command, grammar, grammarInfo);
            }
        }
        if (this.isCommandLoaded(command.getMode(), this.dialogManagerState)) {
            return grammar;
        }
        return null;
    }

    private GrammarInfo unloadCommand(Command command) {
        if (!this.commandCaches.containsKey(command.getMode())) {
            this.logger.error(new StringBuffer().append("unknown CommandMode : ").append(command.getMode()).toString());
            return null;
        }
        CommandCache commandCache = (CommandCache)this.commandCaches.get(command.getMode());
        if (!commandCache.contains(command)) {
            this.logger.error(new StringBuffer().append("command is already unloaded : ").append(command.toString()).toString());
            return null;
        }
        GrammarInfo grammarInfo = this.commandLoader.wrapToGrammarInfo(command);
        commandCache.remove(command);
        if (command.getMode() == 1) {
            CommandCache commandCache2 = (CommandCache)this.commandCaches.get(2);
            Grammar grammar = commandCache2.getGrammar(command.getSdsId());
            if (grammar == null) {
                this.extraGlobalCommands.remove(command);
            } else {
                this.extraHelpCommands.put(command, grammar, grammarInfo);
            }
        } else if (command.getMode() == 2) {
            CommandCache commandCache3 = (CommandCache)this.commandCaches.get(1);
            Grammar grammar = commandCache3.getGrammar(command.getSdsId());
            if (grammar == null) {
                this.extraHelpCommands.remove(command);
            } else {
                this.extraGlobalCommands.put(command, grammar, grammarInfo);
            }
        }
        if (!this.isCommandLoaded(command.getMode(), this.dialogManagerState)) {
            return null;
        }
        return grammarInfo;
    }

    public Command getCommand(int n, int n2) {
        if (n2 == 1 && this.dialogManagerState == 3) {
            CommandCache commandCache = (CommandCache)this.commandCaches.get(2);
            return commandCache.getCommand(n);
        }
        if (!this.commandCaches.containsKey(n2)) {
            this.logger.error(new StringBuffer().append("unknown CommandHierarchy : ").append(n2).toString());
            return null;
        }
        CommandCache commandCache = (CommandCache)this.commandCaches.get(n2);
        return commandCache.getCommand(n);
    }

    public Command getCommand(NBestList nBestList) {
        if (nBestList == null || nBestList.entries == null || nBestList.entries.length == 0) {
            return null;
        }
        int n = nBestList.entries[0].grammarId;
        int n2 = nBestList.entries[0].commandHierarchie;
        int n3 = CommandUtils.grammarHierarchyToCommandMode(n2);
        return this.getCommand(n, n3);
    }

    private String commandsArrayToString(Command[] commandArray) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Commands[");
        stringBuffer.append(commandArray.length);
        stringBuffer.append("]=");
        stringBuffer.append("{");
        for (int i2 = 0; i2 < commandArray.length; ++i2) {
            stringBuffer.append(commandArray[i2].toString());
            stringBuffer.append(",");
        }
        stringBuffer.setLength(stringBuffer.length() - 1);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private boolean isCommandLoaded(int n, int n2) {
        if (n2 == 0) {
            return false;
        }
        switch (n) {
            case 0: {
                return true;
            }
            case 1: {
                return n2 == 1 || n2 == 2;
            }
            case 2: {
                return n2 == 3;
            }
            case 3: {
                return n2 == 4;
            }
        }
        this.logger.error(new StringBuffer().append("unknown CommandMode found. ID = ").append(n).toString());
        return false;
    }

    @Override
    public Grammar[] onCommandsLost() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("onCommandsLost() requested.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < COMMAND_MODES.length; ++i2) {
            int n = COMMAND_MODES[i2];
            if (!this.isCommandLoaded(n, this.dialogManagerState)) continue;
            CommandCache commandCache = (CommandCache)this.commandCaches.get(n);
            arrayList.addAll(commandCache.getGrammars());
        }
        Object[] objectArray = new Grammar[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    @Override
    public void onSlotsLost() {
    }
}

