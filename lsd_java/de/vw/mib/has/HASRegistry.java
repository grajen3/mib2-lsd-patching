/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASListControl;
import de.vw.mib.has.HASListProperty;

public interface HASRegistry {
    default public HASContext getContextByName(String string) {
    }

    default public HASContext getContextByAction(int n) {
    }

    default public HASContext getContextByProperty(int n) {
    }

    default public boolean isImmediateProperty(int n) {
    }

    default public void registerContext(HASContext hASContext) {
    }

    default public void registerAction(int n, HASContext hASContext) {
    }

    default public void registerProperty(int n, HASContext hASContext) {
    }

    default public void registerImmediateProperty(int n, HASContext hASContext) {
    }

    default public HASListControl registerList(HASListProperty hASListProperty, HASContext hASContext) {
    }
}

