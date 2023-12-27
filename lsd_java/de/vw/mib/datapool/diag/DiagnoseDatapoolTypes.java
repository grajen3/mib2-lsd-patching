/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.diag;

public interface DiagnoseDatapoolTypes {
    public static final int ASL_POOLTYPE;
    public static final int HMI_POOLTYPE;
    public static final int I18N_POOLTYPE;
    public static final int SPEECH_POOLTYPE;
    public static final int SKIN_POOLTYPE;
    public static final int CALC_POOLTYPE;
    public static final int CONST_POOLTYPE;
    public static final String[] NAMES;

    static {
        NAMES = new String[]{"ASL", "HMI", "I18n", "Speech", "Skin", "Calc", "Const"};
    }
}

