/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.reflection.module;

import de.vw.mib.asl.framework.internal.framework.reflection.ReflectionException;

public final class ModuleReflectionConfiguration {
    public static final String CLASS_CONFIG_NAME;
    public static final String FIELD_VERSION;
    public static final String FIELD_MCAO_NAME;
    public static final String FIELD_TARGETS_NAMES;
    public static final String FIELD_TARGETS_MMAOIDX;
    public static final String FIELD_HSMSTATES_NAMES;
    public static final String FIELD_HSMSTATES_MMAOIDX;
    public static final String FIELD_MA_NAMES;
    public static final String FIELD_MA_MAO_IDS;
    private final int version;
    private final String factoryMCAOClassName;
    private final int targetsMMAOId;
    private final String[] supportedTargetsClassesNames;
    private final int hsmStatesMMAOId;
    private final String[] supportedHsmStatesClassesNames;
    private final int[] maosIds;
    private final String[] supportedMethodAccessibleClassesNames;

    public static Class loadConfigurationClass(String string) {
        Class clazz;
        String string2 = new StringBuffer().append(string).append(".").append("MRFCC").toString();
        try {
            clazz = Class.forName(string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new ReflectionException(new StringBuffer().append("Could not load module reflection configuration for package ").append(string).toString(), classNotFoundException);
        }
        return clazz;
    }

    public static ModuleReflectionConfiguration create(Class clazz) {
        return new ModuleReflectionConfiguration(clazz);
    }

    private ModuleReflectionConfiguration(Class clazz) {
        try {
            this.version = ModuleReflectionConfiguration.getIntField(clazz, "VERSION");
            this.factoryMCAOClassName = ModuleReflectionConfiguration.getStringField(clazz, "FACTORY");
            this.targetsMMAOId = ModuleReflectionConfiguration.getIntField(clazz, "TARGETS_MMAO_IDX");
            this.hsmStatesMMAOId = ModuleReflectionConfiguration.getIntField(clazz, "HSMSTATES_MMAO_IDX");
            this.supportedTargetsClassesNames = ModuleReflectionConfiguration.getStringAField(clazz, "TARGETS_NAMES");
            this.supportedHsmStatesClassesNames = ModuleReflectionConfiguration.getStringAField(clazz, "HSMSTATES_NAMES");
            this.maosIds = ModuleReflectionConfiguration.getIntAField(clazz, "MA_MAO_IDS");
            this.supportedMethodAccessibleClassesNames = ModuleReflectionConfiguration.getStringAField(clazz, "MA_NAMES");
        }
        catch (Exception exception) {
            throw new ReflectionException(new StringBuffer().append("Could not load module reflection configuration ").append(clazz.getName()).toString(), exception);
        }
    }

    private static int getIntField(Class clazz, String string) {
        return (Integer)clazz.getField(string).get(null);
    }

    private static int[] getIntAField(Class clazz, String string) {
        return (int[])clazz.getField(string).get(null);
    }

    private static String getStringField(Class clazz, String string) {
        return (String)clazz.getField(string).get(null);
    }

    private static String[] getStringAField(Class clazz, String string) {
        return (String[])clazz.getField(string).get(null);
    }

    public int getVersion() {
        return this.version;
    }

    public String getFactoryMcaoClassName() {
        return this.factoryMCAOClassName;
    }

    public int getTargetsMmaoId() {
        return this.targetsMMAOId;
    }

    public int getHsmStatesMmaoId() {
        return this.hsmStatesMMAOId;
    }

    public String[] getSupportedTargetsClassesNames() {
        return this.supportedTargetsClassesNames;
    }

    public String[] getSupportedHsmStatesClassesNames() {
        return this.supportedHsmStatesClassesNames;
    }

    public int[] getMaosIds() {
        return this.maosIds;
    }

    public String[] getSupportedMethodAccessibleClassesNames() {
        return this.supportedMethodAccessibleClassesNames;
    }
}

