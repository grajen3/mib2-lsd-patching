/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.models.ContainerModel;

final class Speller$ReferenceContainerHandler
implements Runnable {
    private final ContainerModel container;

    public Speller$ReferenceContainerHandler(ContainerModel containerModel) {
        this.container = containerModel;
    }

    @Override
    public void run() {
        if (this.container != null) {
            this.container.set_visible(false);
        }
    }
}

