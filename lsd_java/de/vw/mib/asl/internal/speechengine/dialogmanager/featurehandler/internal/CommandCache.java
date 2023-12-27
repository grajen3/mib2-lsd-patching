/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal;

import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public class CommandCache {
    private IntObjectMap commandMap = new IntObjectOptHashMap();
    private IntObjectMap grammarMap = new IntObjectOptHashMap();
    private IntObjectMap grammarInfoMap = new IntObjectOptHashMap();

    public boolean put(Command command, Grammar grammar, GrammarInfo grammarInfo) {
        int n = command.getSdsId();
        if (this.commandMap.containsKey(n)) {
            return false;
        }
        this.commandMap.put(n, command);
        this.grammarMap.put(n, grammar);
        this.grammarInfoMap.put(n, grammarInfo);
        return true;
    }

    public boolean contains(Command command) {
        return this.commandMap.containsKey(command.getSdsId());
    }

    public boolean contains(int n) {
        return this.commandMap.containsKey(n);
    }

    public boolean remove(Command command) {
        int n = command.getSdsId();
        if (!this.commandMap.containsKey(n)) {
            return false;
        }
        this.commandMap.remove(n);
        this.grammarMap.remove(n);
        this.grammarInfoMap.remove(n);
        return true;
    }

    public Collection getGrammars() {
        return this.grammarMap.values();
    }

    public Collection getGrammarInfos() {
        return this.grammarInfoMap.values();
    }

    public Command getCommand(int n) {
        if (!this.commandMap.containsKey(n)) {
            return null;
        }
        return (Command)this.commandMap.get(n);
    }

    public Grammar getGrammar(int n) {
        if (!this.grammarMap.containsKey(n)) {
            return null;
        }
        return (Grammar)this.grammarMap.get(n);
    }

    public Collection getDifferenceCommands(List list) {
        ArrayList arrayList = new ArrayList(this.commandMap.values());
        arrayList.removeAll(list);
        return arrayList;
    }

    public Collection getAdditionCommands(List list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(this.commandMap.values());
        return arrayList;
    }

    public void updateCommand(Command command) {
        this.commandMap.remove(command.getSdsId());
        this.commandMap.put(command.getSdsId(), command);
    }
}

