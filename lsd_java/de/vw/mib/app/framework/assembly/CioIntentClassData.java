/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.assembly;

import de.vw.mib.collections.ObjectIntMap;
import java.util.Map;

public interface CioIntentClassData {
    public static final String SCOPE_LIFECYCLE;
    public static final String SCOPE_SHOW_CONTENT;

    default public String getName() {
    }

    default public boolean isUnique() {
    }

    default public String getScope() {
    }

    default public String[] getUsages() {
    }

    default public ObjectIntMap getActionParams() {
    }

    default public Map getActionParamsDefaultValues() {
    }

    default public ObjectIntMap getOptionalActionParams() {
    }
}

