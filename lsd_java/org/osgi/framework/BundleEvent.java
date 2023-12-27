/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.util.EventObject;
import org.osgi.framework.Bundle;

public class BundleEvent
extends EventObject {
    private transient Bundle bundle;
    private transient int type;
    public static final int INSTALLED;
    public static final int STARTED;
    public static final int STOPPED;
    public static final int UPDATED;
    public static final int UNINSTALLED;

    public BundleEvent(int n, Bundle bundle) {
        super(bundle);
        this.bundle = bundle;
        this.type = n;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public int getType() {
        return this.type;
    }
}

