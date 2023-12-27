/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.version;

public final class VersionTag {
    private final String name;
    private final String value;

    public VersionTag(String string, String string2) {
        this.name = string;
        this.value = string2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }
}

