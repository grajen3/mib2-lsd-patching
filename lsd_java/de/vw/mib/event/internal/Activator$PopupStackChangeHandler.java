/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.event.PopupStackChangeEvent;
import de.vw.mib.event.consumer.PopupStackChangeEventConsumer;
import de.vw.mib.event.internal.Activator;

class Activator$PopupStackChangeHandler
implements PopupStackChangeEventConsumer {
    private final CowArray consumers = new CowArray();
    private final /* synthetic */ Activator this$0;

    Activator$PopupStackChangeHandler(Activator activator) {
        this.this$0 = activator;
    }

    @Override
    public void consumeEvent(PopupStackChangeEvent popupStackChangeEvent) {
        Object[] objectArray = this.consumers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((PopupStackChangeEventConsumer)objectArray[i2]).consumeEvent(popupStackChangeEvent);
        }
    }

    void addConsumer(PopupStackChangeEventConsumer popupStackChangeEventConsumer) {
        this.consumers.addIfNotAlreadyIn(popupStackChangeEventConsumer);
    }

    void removeConsumer(PopupStackChangeEventConsumer popupStackChangeEventConsumer) {
        this.consumers.remove(popupStackChangeEventConsumer);
    }
}

