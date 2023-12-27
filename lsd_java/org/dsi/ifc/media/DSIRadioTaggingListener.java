/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;

public interface DSIRadioTaggingListener
extends DSIListener {
    default public void tagResult(int n) {
    }

    default public void updateCompatibleDevAvail(int n, int n2) {
    }

    default public void groupTagsResult(int n, int n2) {
    }
}

