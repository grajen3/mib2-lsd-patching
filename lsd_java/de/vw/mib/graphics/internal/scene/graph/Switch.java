/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph;

import de.vw.mib.graphics.internal.scene.graph.AbstractSceneNode;
import de.vw.mib.graphics.scene.graph.SwitchNode;

public class Switch
extends AbstractSceneNode
implements SwitchNode {
    private static final long serialVersionUID;
    private int selectedChild;

    @Override
    public final int getSelectedChild() {
        return this.selectedChild;
    }

    @Override
    public final void setSelectedChild(int n) {
        int n2 = this.selectedChild;
        if (n2 != n) {
            this.selectedChild = n;
            this.selectedChildChanged(n2, n);
        }
    }

    protected void selectedChildChanged(int n, int n2) {
    }
}

