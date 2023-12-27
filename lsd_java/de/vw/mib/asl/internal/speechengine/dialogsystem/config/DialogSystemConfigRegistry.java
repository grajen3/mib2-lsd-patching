/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.config;

import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigListener;
import java.util.List;

public interface DialogSystemConfigRegistry {
    default public void register(DialogSystemConfigListener dialogSystemConfigListener) {
    }

    default public List getTTSConfigs() {
    }

    default public List getRecognizerConfigs() {
    }
}

