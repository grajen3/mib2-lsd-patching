/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.model;

import de.esolutions.fw.util.config.ConfigValue;

public abstract class ConfigScalar
extends ConfigValue {
    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public boolean isDictionary() {
        return false;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean isScalar() {
        return true;
    }
}

