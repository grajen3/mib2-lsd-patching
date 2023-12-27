/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.query;

import de.vw.mib.graphics.scene.query.SceneQuery;
import java.util.Set;

public abstract class AbstractSceneQuery
implements SceneQuery {
    private int queryMask;
    private int queryTypeMask;

    public AbstractSceneQuery() {
        this(0, 0);
    }

    public AbstractSceneQuery(int n) {
        this(n, 0);
    }

    public AbstractSceneQuery(int n, int n2) {
        this.queryMask = n;
        this.queryTypeMask = n2;
    }

    @Override
    public final int getQueryMask() {
        return this.queryMask;
    }

    @Override
    public final void setQueryMask(int n) {
        this.queryMask = n;
    }

    @Override
    public final int getQueryTypeMask() {
        return this.queryTypeMask;
    }

    @Override
    public final void setQueryTypeMask(int n) {
        this.queryTypeMask = n;
    }

    @Override
    public abstract Set execute() {
    }
}

