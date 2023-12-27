/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PostponedCommandMap {
    protected Map commandListMap = new HashMap();

    protected ArrayList find(Object object, boolean bl) {
        Iterator iterator = this.commandListMap.keySet().iterator();
        while (iterator.hasNext()) {
            Object object2 = iterator.next();
            if (!object2.equals(object)) continue;
            ArrayList arrayList = (ArrayList)this.commandListMap.get(object2);
            if (bl) {
                iterator.remove();
            }
            return arrayList;
        }
        return null;
    }

    public void addCommand(Object object, Command command) {
        ArrayList arrayList = this.find(object, false);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.commandListMap.put(object, arrayList);
        }
        arrayList.add(command);
    }

    public Command[] retrieveCommands(Object object) {
        ArrayList arrayList = this.find(object, true);
        if (arrayList == null) {
            return null;
        }
        int n = arrayList.size();
        Object[] objectArray = new Command[n];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public Command[] retrieveOldCommands(long l, long l2) {
        Object[] objectArray;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.commandListMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList arrayList2 = (ArrayList)iterator.next();
            objectArray = arrayList2.iterator();
            while (objectArray.hasNext()) {
                Command command = (Command)objectArray.next();
                long l3 = l2 - command.getCreateTime();
                if (l3 <= l) continue;
                arrayList.add(command);
                objectArray.remove();
            }
            if (arrayList2.size() != 0) continue;
            iterator.remove();
        }
        int n = arrayList.size();
        if (n == 0) {
            return null;
        }
        objectArray = new Command[n];
        arrayList.toArray(objectArray);
        return objectArray;
    }
}

