/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASContainer;

public interface HASListRequest {
    default public int getOffset() {
    }

    default public void setOffset(int n) {
    }

    default public int getModCount() {
    }

    default public void setModCount(int n) {
    }

    default public HASContainer[] getData() {
    }

    default public void setData(HASContainer[] hASContainerArray) {
    }

    default public void response(int n) {
    }
}

