/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.internal.speechmedia.sources.model.SourceModel;

public interface SourceListObserver {
    default public void onUpdateSourceList(SourceModel[] sourceModelArray) {
    }
}

