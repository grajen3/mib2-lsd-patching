/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

import org.dsi.ifc.base.DSIListener;

public interface DSIObexAuthenticationListener
extends DSIListener {
    default public void authenticationRequired(int n, boolean bl, String string) {
    }

    default public void indAuthentication(boolean bl) {
    }
}

