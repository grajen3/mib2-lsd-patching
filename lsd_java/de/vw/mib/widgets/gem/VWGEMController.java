/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.gem.KeyListenerIFC
 *  de.audi.gem.TouchControllerIFC
 *  de.audi.gem.TouchListenerIFC
 */
package de.vw.mib.widgets.gem;

import de.audi.gem.KeyListenerIFC;
import de.audi.gem.TouchControllerIFC;
import de.audi.gem.TouchListenerIFC;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.widgets.internal.ServiceManager;

public final class VWGEMController
implements TouchControllerIFC {
    private CowList keyListeners = CowList.EMPTY;
    private CowList touchListeners = CowList.EMPTY;

    public void addListener(KeyListenerIFC keyListenerIFC) {
        this.keyListeners = this.keyListeners.addIfAbsent(keyListenerIFC);
    }

    public void removeListener(KeyListenerIFC keyListenerIFC) {
        this.keyListeners = this.keyListeners.remove(keyListenerIFC);
    }

    public void updateKeyPressed(int n) {
        for (CowList cowList = this.keyListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            KeyListenerIFC keyListenerIFC = (KeyListenerIFC)cowList.head();
            keyListenerIFC.keyPressed(n);
        }
    }

    public void updateKeyReleased(int n) {
        for (CowList cowList = this.keyListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            KeyListenerIFC keyListenerIFC = (KeyListenerIFC)cowList.head();
            keyListenerIFC.keyReleased(n);
        }
    }

    public void updateKeyTurned(int n, int n2, int n3) {
        for (CowList cowList = this.keyListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            KeyListenerIFC keyListenerIFC = (KeyListenerIFC)cowList.head();
            keyListenerIFC.keyTurned(n, n2, n3);
        }
    }

    public void triggerRepaint() {
        ServiceManager.repaintManager.repaint();
    }

    public void addTouchListener(TouchListenerIFC touchListenerIFC) {
        this.touchListeners = this.touchListeners.addIfAbsent(touchListenerIFC);
    }

    public void removeTouchListener(TouchListenerIFC touchListenerIFC) {
        this.touchListeners = this.touchListeners.remove(touchListenerIFC);
    }

    public void removeTouchListener(TouchControllerIFC touchControllerIFC) {
        this.touchListeners = this.touchListeners.remove(touchControllerIFC);
    }

    public void updateTouchGesture(int n, int n2, int n3, int n4) {
        for (CowList cowList = this.touchListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            TouchListenerIFC touchListenerIFC = (TouchListenerIFC)cowList.head();
            touchListenerIFC.touchGestureReceived(n, n2, n3, n4);
        }
    }
}

