/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.phonetic;

import org.dsi.ifc.base.DSIListener;

public interface DSIPhoneticConverterListener
extends DSIListener {
    default public void hanziToPinYinResult(String string, String string2, String string3, String string4) {
    }

    default public void hanziToZhuYinResult(String string, String string2, String string3, String string4) {
    }
}

