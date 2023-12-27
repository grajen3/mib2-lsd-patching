/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.service.startlevel;

import org.osgi.framework.Bundle;

public interface StartLevel {
    default public int getStartLevel() {
    }

    default public void setStartLevel(int n) {
    }

    default public int getBundleStartLevel(Bundle bundle) {
    }

    default public void setBundleStartLevel(Bundle bundle, int n) {
    }

    default public int getInitialBundleStartLevel() {
    }

    default public void setInitialBundleStartLevel(int n) {
    }

    default public boolean isBundlePersistentlyStarted(Bundle bundle) {
    }
}

