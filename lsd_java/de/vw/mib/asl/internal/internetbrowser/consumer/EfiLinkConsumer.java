/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.consumer;

import java.util.HashSet;
import java.util.Set;

public final class EfiLinkConsumer {
    private int _targetId = 0;
    private Set _actions = new HashSet();

    public EfiLinkConsumer(int n) {
        this.setTargetId(n);
    }

    public int getTargetId() {
        return this._targetId;
    }

    private void setTargetId(int n) {
        this._targetId = n;
    }

    public boolean addAction(String string) {
        return this._actions.add(string);
    }

    public boolean isAction(String string) {
        return this._actions.contains(string);
    }

    public boolean removeAction(String string) {
        boolean bl = false;
        if (this.isAction(string)) {
            bl = this._actions.remove(string);
        }
        return bl;
    }
}

