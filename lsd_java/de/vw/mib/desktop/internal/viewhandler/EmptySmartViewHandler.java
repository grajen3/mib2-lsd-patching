/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.viewhandler;

import de.vw.mib.animation.control.AnimatedPropertiesAccessor;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;

public class EmptySmartViewHandler
extends SmartViewHandler {
    public EmptySmartViewHandler() {
        super(null, "{}", null);
    }

    @Override
    public String getName() {
        return "<none>";
    }

    @Override
    public void create() {
    }

    public void init(boolean bl) {
    }

    public void activate() {
    }

    @Override
    public void deactivate() {
    }

    @Override
    public void deinit() {
    }

    public void destroy() {
    }

    @Override
    public boolean consumeEvent(HMIEvent hMIEvent) {
        return false;
    }

    @Override
    public boolean consumeEvent(TouchEvent touchEvent) {
        return false;
    }

    public void activateSWYS() {
    }

    public void deactivateSWYS() {
    }

    @Override
    public void reInit(boolean bl) {
    }

    @Override
    public void release() {
    }

    @Override
    public void reload() {
    }

    @Override
    public void restore() {
    }

    @Override
    public void invalidate() {
    }

    @Override
    public boolean is_visible() {
        return false;
    }

    @Override
    public boolean startLeaveAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, int n2, AnimationListener animationListener) {
        return false;
    }

    @Override
    public boolean startEnterAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, int n2, AnimationListener animationListener) {
        return false;
    }

    @Override
    public void stopLeaveAnimation(int n) {
    }

    @Override
    public void stopEnterAnimation(int n) {
    }

    @Override
    public int getCurrentViewType() {
        return 1;
    }

    @Override
    public boolean is_opaque() {
        return false;
    }
}

