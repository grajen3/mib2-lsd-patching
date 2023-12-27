/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultTouchAreaController;

class DefaultTouchAreaController$EventAccumulator {
    private final String eventName;
    private boolean eventAccumulated;
    private int eventParam1;
    private int eventParam2;
    private int x;
    private int y;
    private final /* synthetic */ DefaultTouchAreaController this$0;

    public DefaultTouchAreaController$EventAccumulator(DefaultTouchAreaController defaultTouchAreaController, String string) {
        this.this$0 = defaultTouchAreaController;
        this.eventName = string;
        this.reset();
    }

    public void accumulateEvent(int n, int n2, int n3, int n4) {
        this.eventParam1 += n3;
        this.eventParam2 += n4;
        this.x = n;
        this.y = n2;
        this.eventAccumulated = true;
    }

    public void reset() {
        this.eventParam1 = 0;
        this.eventParam2 = 0;
        this.x = 0;
        this.y = 0;
        this.eventAccumulated = false;
    }

    public boolean fireEvent() {
        boolean bl = false;
        if (this.eventAccumulated && this.this$0.getOutEventMapping(this.eventName) != -1) {
            this.this$0.fireEvent(this.eventName, this.x, this.y, this.eventParam1, this.eventParam2);
            bl = true;
            this.reset();
        }
        return bl;
    }
}

