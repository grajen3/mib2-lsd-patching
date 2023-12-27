/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem;

import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.dialogsystem.Dialog;

public interface PromptDialog
extends Dialog {
    default public void addPrompts(Prompt[] promptArray, int n) {
    }
}

