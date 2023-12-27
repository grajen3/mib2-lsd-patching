/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input.gesture;

import de.vw.mib.asl.api.system.input.SpaceGestureListener;
import de.vw.mib.asl.internal.system.input.gesture.PropagatingSpaceGestureService;
import de.vw.mib.asl.internal.system.util.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SpaceGestureServiceImpl
implements PropagatingSpaceGestureService {
    private final Set listeners = new HashSet();
    private boolean isCurrentSpaceGestureActivated;
    private boolean istCurrentSpaceGestureInformationActivated;
    private boolean isCurrentSpaceGestureSoundEffectActivated;

    @Override
    public void addListener(SpaceGestureListener spaceGestureListener) {
        Preconditions.checkArgumentNotNull(spaceGestureListener);
        this.listeners.add(spaceGestureListener);
    }

    @Override
    public void removeListener(SpaceGestureListener spaceGestureListener) {
        this.listeners.remove(spaceGestureListener);
    }

    @Override
    public boolean isCurrentSpaceGestureActivated() {
        return this.isCurrentSpaceGestureActivated;
    }

    @Override
    public boolean istCurrentSpaceGestureInformationActivated() {
        return this.istCurrentSpaceGestureInformationActivated;
    }

    @Override
    public boolean isCurrentSpaceGestureSoundEffectActivated() {
        return this.isCurrentSpaceGestureSoundEffectActivated;
    }

    @Override
    public void applyCurrentSpaceGestureValue(boolean bl) {
        this.isCurrentSpaceGestureActivated = bl;
        this.notifySpaceGesture(bl);
    }

    @Override
    public void applyCurrentSpaceGestureInformationValue(boolean bl) {
        this.istCurrentSpaceGestureInformationActivated = bl;
        this.notifySpaceGestureInformation(bl);
    }

    @Override
    public void applyCurrentSpaceGestureSoundEffectValue(boolean bl) {
        this.isCurrentSpaceGestureSoundEffectActivated = bl;
        this.notifySpaceGestureSoundEffect(bl);
    }

    private void notifySpaceGesture(boolean bl) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            SpaceGestureListener spaceGestureListener = (SpaceGestureListener)iterator.next();
            spaceGestureListener.onSpaceGestureChanged(bl);
        }
    }

    private void notifySpaceGestureInformation(boolean bl) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            SpaceGestureListener spaceGestureListener = (SpaceGestureListener)iterator.next();
            spaceGestureListener.onSpaceGestureInformationChanged(bl);
        }
    }

    private void notifySpaceGestureSoundEffect(boolean bl) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            SpaceGestureListener spaceGestureListener = (SpaceGestureListener)iterator.next();
            spaceGestureListener.onSpaceGestureSoundEffectChanged(bl);
        }
    }
}

