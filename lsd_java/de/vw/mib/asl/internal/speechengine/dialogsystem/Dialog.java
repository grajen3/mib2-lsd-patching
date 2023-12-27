/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem;

import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;

public interface Dialog {
    public static final int RESULT_SUCCESSFUL;
    public static final int RESULT_ERROR;

    default public void start() {
    }

    default public void abort() {
    }

    default public void pttBargeIn() {
    }

    default public void clear() {
    }

    default public void clear(int n) {
    }

    default public void terminate() {
    }

    default public void addDialogListener(DialogListener dialogListener) {
    }

    default public void removeDialogListener(DialogListener dialogListener) {
    }

    default public void addEndDialog(int n) {
    }
}

