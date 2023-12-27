/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.esam;

import de.vw.mib.app.esam.CloseEsamMemberHandler;

public interface EsamServiceForViews {
    default public boolean requestVisibility(String string, CloseEsamMemberHandler closeEsamMemberHandler) {
    }

    default public void releaseVisibility(String string) {
    }
}

