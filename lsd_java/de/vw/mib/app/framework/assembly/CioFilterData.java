/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.assembly;

import de.vw.mib.app.framework.assembly.CioFilterData$CioFilterEntry;

public interface CioFilterData {
    public static final int APPEND_MODE;
    public static final int PARTIAL_MODE;

    default public String getCioIntentClassNameRef() {
    }

    default public String getCioFilterName() {
    }

    default public CioFilterData$CioFilterEntry[] getFilterEntries() {
    }

    default public int getMode() {
    }

    default public String getUsage() {
    }
}

