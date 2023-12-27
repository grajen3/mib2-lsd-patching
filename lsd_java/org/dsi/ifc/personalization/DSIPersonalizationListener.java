/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.personalization;

import org.dsi.ifc.base.DSIListener;

public interface DSIPersonalizationListener
extends DSIListener {
    default public void copyProfile(int n, int n2) {
    }

    default public void resetProfile(int n) {
    }

    default public void resetAllProfiles() {
    }
}

