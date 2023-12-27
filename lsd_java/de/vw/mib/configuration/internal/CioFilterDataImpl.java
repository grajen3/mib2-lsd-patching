/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.app.framework.assembly.CioFilterData;
import de.vw.mib.app.framework.assembly.CioFilterData$CioFilterEntry;
import de.vw.mib.configuration.internal.CioFilterDataImpl$CioFilterEntryImpl;

final class CioFilterDataImpl
implements CioFilterData {
    private final String cioFilterName;
    private final String cioIntentClassNameRef;
    private final String usage;
    private final int mode;
    private final CioFilterDataImpl$CioFilterEntryImpl[] filterEntries;

    public CioFilterDataImpl(String string, String string2, String string3, int n, CioFilterDataImpl$CioFilterEntryImpl[] cioFilterEntryImplArray) {
        this.cioFilterName = string;
        this.cioIntentClassNameRef = string2;
        this.usage = string3;
        this.mode = n;
        this.filterEntries = cioFilterEntryImplArray;
    }

    @Override
    public String getCioFilterName() {
        return this.cioFilterName;
    }

    @Override
    public String getCioIntentClassNameRef() {
        return this.cioIntentClassNameRef;
    }

    @Override
    public String getUsage() {
        return this.usage;
    }

    @Override
    public int getMode() {
        return this.mode;
    }

    @Override
    public CioFilterData$CioFilterEntry[] getFilterEntries() {
        return this.filterEntries;
    }
}

