/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.selection.service;

import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model.ContentSelection;

public interface ContentSelectionChangeListener {
    default public void onSelectionUpdated(ContentSelection[] contentSelectionArray) {
    }
}

