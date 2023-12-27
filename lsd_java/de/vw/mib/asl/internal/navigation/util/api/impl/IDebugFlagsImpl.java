/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.api.impl;

import de.vw.mib.asl.api.navigation.util.IDebugFlags;
import de.vw.mib.asl.internal.navigation.util.NavDebugFlags;
import de.vw.mib.asl.internal.navigation.util.NavDebugFlagsBase;

public final class IDebugFlagsImpl
implements IDebugFlags {
    @Override
    public void setASLDebugFlag(String string, boolean bl) {
        NavDebugFlagsBase.setASLDebugFlag(string, bl);
    }

    @Override
    public void setAPIDebugFlag(int n, boolean bl) {
        NavDebugFlagsBase.setAPIDebugFlag(n, bl);
    }

    @Override
    public boolean getASLDebugFlag(String string) {
        return NavDebugFlagsBase.getASLDebugFlag(string);
    }

    @Override
    public boolean getAPIDebugFlag(int n) {
        return NavDebugFlagsBase.getAPIDebugFlag(n);
    }

    @Override
    public void initNavDebugFlags() {
        NavDebugFlags.initNavDebugFlags();
    }
}

