/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debugmanager.internal.DebugProbeManagerImpl;
import java.io.File;
import java.io.FileFilter;

class DebugProbeManagerImpl$1
implements FileFilter {
    private final /* synthetic */ DebugProbeManagerImpl this$0;

    DebugProbeManagerImpl$1(DebugProbeManagerImpl debugProbeManagerImpl) {
        this.this$0 = debugProbeManagerImpl;
    }

    @Override
    public boolean accept(File file) {
        String string = file.getName();
        return string.startsWith("debugprobes_") && string.endsWith(".config");
    }
}

