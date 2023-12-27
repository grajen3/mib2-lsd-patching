/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.asl.internal.list.IndexIterable;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASDynamicList;
import de.vw.mib.has.HASListFetcher;

public interface HASList
extends IndexIterable {
    public static final int STATE_READY;
    public static final int STATE_LOADING;
    public static final int STATE_NO_DATA;

    default public void setState(int n) {
    }

    default public HASDynamicList enableFetching(HASListFetcher hASListFetcher, int n) {
    }

    default public int getPageSize() {
    }

    default public int getSize() {
    }

    default public void clear() {
    }

    default public void setContent(HASContainer[] hASContainerArray) {
    }

    default public void update(int n, HASContainer[] hASContainerArray) {
    }

    default public HASContainer getItem(int n) {
    }
}

