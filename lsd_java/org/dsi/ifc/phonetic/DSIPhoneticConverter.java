/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.phonetic;

import org.dsi.ifc.base.DSIBase;

public interface DSIPhoneticConverter
extends DSIBase {
    public static final String VERSION;
    public static final int RT_HANZITOPINYIN;
    public static final int RT_HANZITOZHUYIN;
    public static final int RP_HANZITOPINYINRESULT;
    public static final int RP_HANZITOZHUYINRESULT;

    default public void hanziToPinYin(String string) {
    }

    default public void hanziToZhuYin(String string) {
    }
}

