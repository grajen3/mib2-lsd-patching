/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledTextLayout;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;
import java.util.ArrayList;
import java.util.List;

final class CachingTextLayoutManager$TextLayoutPool
extends AbstractUnsynchronizedObjectPool {
    private static List EMPTY_LIST = new ArrayList(0);
    private static final TextLayout EMPTY_TRUNCATED_TEXT_LAYOUT = new CachingTextLayoutManager$PooledTextLayout("", -1L, 0, 0, true, EMPTY_LIST);
    private static final TextLayout EMPTY_TEXT_LAYOUT = new CachingTextLayoutManager$PooledTextLayout("", -2L, 0, 0, false, EMPTY_LIST);

    public CachingTextLayoutManager$TextLayoutPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new CachingTextLayoutManager$PooledTextLayout(this);
    }

    public static TextLayout getEmptyTruncatedTextLayout() {
        EMPTY_TRUNCATED_TEXT_LAYOUT.reference();
        return EMPTY_TRUNCATED_TEXT_LAYOUT;
    }

    public static TextLayout getEmptyTextLayout() {
        EMPTY_TEXT_LAYOUT.reference();
        return EMPTY_TEXT_LAYOUT;
    }
}

