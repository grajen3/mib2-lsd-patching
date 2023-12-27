/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.diag;

import java.util.Map;
import java.util.Set;

public interface EsamDiagService {
    default public Map getEsamMembersAndCategories() {
    }

    default public Set getVisibleEsamMembers() {
    }

    default public void releaseVisibility(String string) {
    }

    default public boolean requestVisibility(String string) {
    }
}

