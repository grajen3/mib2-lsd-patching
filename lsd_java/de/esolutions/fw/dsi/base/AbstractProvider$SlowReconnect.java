/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.base;

import de.esolutions.fw.dsi.base.AbstractProvider;
import java.util.TimerTask;

class AbstractProvider$SlowReconnect
extends TimerTask {
    private AbstractProvider provider;

    public AbstractProvider$SlowReconnect(AbstractProvider abstractProvider) {
        this.provider = abstractProvider;
    }

    @Override
    public void run() {
        AbstractProvider.access$000(this.provider);
    }
}

