/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.selection.service;

import de.vw.mib.asl.internal.car.fpk.usecases.ServiceState;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model.ContentSelection;

public interface ContentSelectionService
extends ServiceState {
    default public ContentSelection getSelectedElement(int n) {
    }

    default public void selectElement(int n, int n2, int n3) {
    }

    default public void setElementContentToModel(int n, int n2, int n3) {
    }

    default public boolean validateAndUpdatePredefinedPresetContent() {
    }
}

