/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.naming;

public interface INameService {
    default public String getMyProcName() {
    }

    default public String getMyNodeName() {
    }

    default public short getMyID() {
    }

    default public Short mapNameToID(String string) {
    }

    default public String mapIDToName(short s) {
    }

    default public String[] getNodeNames() {
    }
}

