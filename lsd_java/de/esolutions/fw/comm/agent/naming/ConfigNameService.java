/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.naming;

import de.esolutions.fw.comm.agent.naming.INameService;
import de.esolutions.fw.util.config.fw.SystemConfig;

public class ConfigNameService
implements INameService {
    private SystemConfig config;

    public ConfigNameService(SystemConfig systemConfig) {
        this.config = systemConfig;
    }

    @Override
    public short getMyID() {
        return (short)this.config.getMyProcId();
    }

    @Override
    public String getMyProcName() {
        return this.config.getMyProcName();
    }

    @Override
    public String getMyNodeName() {
        return this.config.getMyNodeName();
    }

    @Override
    public String mapIDToName(short s) {
        return this.config.mapProcId(s);
    }

    @Override
    public Short mapNameToID(String string) {
        return new Short(this.config.mapIdProc(string).shortValue());
    }

    @Override
    public String[] getNodeNames() {
        return this.config.getAllNodeNames();
    }
}

