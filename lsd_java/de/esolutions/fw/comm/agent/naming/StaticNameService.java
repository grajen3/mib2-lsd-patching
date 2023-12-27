/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.naming;

import de.esolutions.fw.comm.agent.naming.INameService;
import java.util.HashMap;
import java.util.Map;

public class StaticNameService
implements INameService {
    protected String myProcName;
    protected String myNodeName;
    protected short myID;
    protected Map nameMap;
    protected Map idMap;

    public StaticNameService(String string, String string2, short s) {
        this.myProcName = string;
        this.myNodeName = string2;
        this.myID = s;
        this.nameMap = new HashMap();
        this.idMap = new HashMap();
    }

    @Override
    public short getMyID() {
        return this.myID;
    }

    @Override
    public String getMyProcName() {
        return this.myProcName;
    }

    @Override
    public String getMyNodeName() {
        return this.myNodeName;
    }

    public synchronized void addEntry(String string, short s) {
        this.nameMap.put(string, new Short(s));
        this.idMap.put(new Short(s), string);
    }

    @Override
    public synchronized String mapIDToName(short s) {
        return (String)this.idMap.get(new Short(s));
    }

    @Override
    public synchronized Short mapNameToID(String string) {
        return (Short)this.nameMap.get(string);
    }

    @Override
    public synchronized String[] getNodeNames() {
        return new String[]{this.myNodeName};
    }
}

