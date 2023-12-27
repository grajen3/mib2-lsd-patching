/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

class FunctionBlockingInfo {
    private final String name;
    private final int diagnosisBitId;
    private final String configurationManagerRtMethodName;
    private final int aslPropertyManagerId;

    FunctionBlockingInfo(String string, int n, String string2, int n2) {
        this.name = string;
        this.diagnosisBitId = n;
        this.configurationManagerRtMethodName = string2;
        this.aslPropertyManagerId = n2;
    }

    String getName() {
        return this.name;
    }

    int getDiagnosisBitId() {
        return this.diagnosisBitId;
    }

    String getConfigurationManagerRtMethodName() {
        return this.configurationManagerRtMethodName;
    }

    int getAslPropertyManagerId() {
        return this.aslPropertyManagerId;
    }
}

