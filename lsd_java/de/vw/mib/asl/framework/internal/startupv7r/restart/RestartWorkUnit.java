/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.restart;

import de.vw.mib.asl.framework.internal.startupv7r.workunits.ContextInformationWorkUnit;

public class RestartWorkUnit {
    private final String name;
    private ContextInformationWorkUnit workUnit;

    public RestartWorkUnit(String string) {
        this.name = string;
    }

    public void installStartupWorkUnit(ContextInformationWorkUnit contextInformationWorkUnit) {
        if (contextInformationWorkUnit == null) {
            throw new IllegalArgumentException(new StringBuffer().append("Cannot install work unit to ").append(this.name).append(" because it is null.").toString());
        }
        if (this.workUnit != null) {
            throw new IllegalStateException(new StringBuffer().append("Cannot install work unit to ").append(this.name).append(" because it another work unit was already installed before.").toString());
        }
        this.workUnit = contextInformationWorkUnit;
    }

    ContextInformationWorkUnit getStartupWorkUnit() {
        if (this.workUnit == null) {
            throw new IllegalStateException(new StringBuffer().append("No startup work unit was installed to ").append(this.name).append(", therefor it cannot be accessed.").toString());
        }
        return this.workUnit;
    }
}

