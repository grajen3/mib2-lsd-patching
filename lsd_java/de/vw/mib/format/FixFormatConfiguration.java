/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.format;

public final class FixFormatConfiguration {
    public static final boolean DEBUG;
    public static final String RULESET_RESOURCES;
    public static final String RULESET_DIRECTORY;
    public static final String RULESETS;

    private FixFormatConfiguration() {
    }

    static {
        RULESET_RESOURCES = System.getProperty("de.vw.mib.format.4asl.rulesets.resources");
        RULESET_DIRECTORY = System.getProperty("de.vw.mib.format.4asl.rulesets.directory");
        RULESETS = System.getProperty("de.vw.mib.format.4asl.rulesets");
    }
}

