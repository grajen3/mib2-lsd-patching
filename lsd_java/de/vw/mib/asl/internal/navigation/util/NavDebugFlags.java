/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.internal.navigation.util.NavDebugFlagsBase;

public class NavDebugFlags
extends NavDebugFlagsBase {
    public static void initNavDebugFlags() {
        NavDebugFlags.setAPIDebugFlag(-219213824, true);
        NavDebugFlags.setASLDebugFlag("NEW_NAV_PERSISTENCE", true);
    }
}

