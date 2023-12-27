/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.diagnose;

import org.dsi.ifc.base.DSIListener;

public interface DSIComponentProtectionListener
extends DSIListener {
    default public void authStringResponse(String string, String string2, byte by) {
    }
}

