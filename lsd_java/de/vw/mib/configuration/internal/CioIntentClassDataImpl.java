/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.app.framework.assembly.CioIntentClassData;
import de.vw.mib.collections.ObjectIntMap;
import java.util.Map;

public class CioIntentClassDataImpl
implements CioIntentClassData {
    private String name;
    private boolean unique;
    private String scope;
    private String[] usages;
    private ObjectIntMap actionParams;
    private ObjectIntMap optionalActionParams;
    private Map actionParamsDefaultValues;

    public CioIntentClassDataImpl(String string, boolean bl, String string2, String[] stringArray, ObjectIntMap objectIntMap, ObjectIntMap objectIntMap2, Map map) {
        this.name = string;
        this.unique = bl;
        this.scope = string2;
        this.usages = stringArray;
        this.actionParams = objectIntMap;
        this.optionalActionParams = objectIntMap2;
        this.actionParamsDefaultValues = map;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isUnique() {
        return this.unique;
    }

    @Override
    public String getScope() {
        return this.scope;
    }

    @Override
    public String[] getUsages() {
        return this.usages;
    }

    @Override
    public ObjectIntMap getActionParams() {
        return this.actionParams;
    }

    @Override
    public ObjectIntMap getOptionalActionParams() {
        return this.optionalActionParams;
    }

    @Override
    public Map getActionParamsDefaultValues() {
        return this.actionParamsDefaultValues;
    }
}

