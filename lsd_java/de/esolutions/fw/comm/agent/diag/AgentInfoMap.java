/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.diag.IInfoBase;
import java.util.HashMap;
import java.util.Map;

public class AgentInfoMap {
    private Map map = new HashMap();

    public String[] getAllNames() {
        Object[] objectArray = this.map.keySet().toArray();
        String[] stringArray = new String[objectArray.length];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            stringArray[i2] = (String)objectArray[i2];
        }
        return stringArray;
    }

    public IInfoBase[] getIInfoBaseForName(String string) {
        return (IInfoBase[])this.map.get(string);
    }

    public void add(AgentInfoMap agentInfoMap) {
        String[] stringArray = agentInfoMap.getAllNames();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            IInfoBase[] iInfoBaseArray = agentInfoMap.getIInfoBaseForName(stringArray[i2]);
            String string = stringArray[i2];
            this.add(string, iInfoBaseArray);
        }
    }

    public void add(String string, IInfoBase iInfoBase) {
        IInfoBase[] iInfoBaseArray = new IInfoBase[]{iInfoBase};
        this.add(string, iInfoBaseArray);
    }

    public void add(String string, IInfoBase[] iInfoBaseArray) {
        if (this.map.containsKey(string)) {
            IInfoBase[] iInfoBaseArray2 = (IInfoBase[])this.map.get(string);
            IInfoBase[] iInfoBaseArray3 = new IInfoBase[iInfoBaseArray2.length + iInfoBaseArray.length];
            System.arraycopy((Object)iInfoBaseArray2, 0, (Object)iInfoBaseArray3, 0, iInfoBaseArray2.length);
            System.arraycopy((Object)iInfoBaseArray, 0, (Object)iInfoBaseArray3, iInfoBaseArray2.length, iInfoBaseArray.length);
            this.map.put(string, iInfoBaseArray3);
        } else {
            this.map.put(string, iInfoBaseArray);
        }
    }
}

