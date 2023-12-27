/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Rotation;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.MeshWidgetController;
import de.vw.mib.widgets.models.MeshWidgetModel;

public final class DefaultMeshWidgetController
extends AbstractWidgetController
implements MeshWidgetController {
    private static final boolean FULLSCREEN;
    private static final boolean TOUCHBALL;
    private Vector3f lastTouchPoint = new Vector3f();
    private Vector3f touchPoint = new Vector3f();

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        this.lastTouchPoint.setZero();
        this.touchPoint.setZero();
        super.deInit();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        return false;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        MeshWidgetModel meshWidgetModel = (MeshWidgetModel)this.getWidget();
        switch (touchEvent.getType()) {
            case 1: {
                meshWidgetModel.setAnimationMode(2);
                Util.getPointOnSphere(this.lastTouchPoint, touchEvent.getX() - meshWidgetModel.getAbsX(), touchEvent.getY() - meshWidgetModel.getAbsY(), meshWidgetModel.get_width(), meshWidgetModel.get_height());
                break;
            }
            case 2: {
                if (touchEvent.getGestureParam1() != 2) break;
                meshWidgetModel.setZoom(1.0f);
                meshWidgetModel.setAnimationMode(1);
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                meshWidgetModel.setAnimationMode(touchEvent.getGestureParam1() < 0 ? 0 : 1);
                break;
            }
            case 9: {
                int n = touchEvent.getZDelta();
                int n2 = touchEvent.getGestureParam1();
                float f2 = (float)n / (float)(n - n2);
                meshWidgetModel.setZoom(meshWidgetModel.getZoom() * 1.0f / f2);
                meshWidgetModel.setAnimationMode(2);
                break;
            }
            case 10: {
                break;
            }
            case 3: 
            case 4: {
                Util.getPointOnSphere(this.touchPoint, touchEvent.getX() - meshWidgetModel.getAbsX(), touchEvent.getY() - meshWidgetModel.getAbsY(), meshWidgetModel.get_width(), meshWidgetModel.get_height());
                if (!this.touchPoint.equals(this.lastTouchPoint)) {
                    Vector3f vector3f = new Vector3f();
                    this.lastTouchPoint.cross(this.touchPoint, vector3f);
                    vector3f.normalize();
                    float f3 = this.lastTouchPoint.getAngle(this.touchPoint);
                    Rotation rotation = new Rotation(new Vector3f(0.0f, 1.0f, 0.0f), this.touchPoint.x - this.lastTouchPoint.x);
                    Rotation rotation2 = meshWidgetModel.getRotationCurrent();
                    rotation2.mul(rotation);
                    meshWidgetModel.setRotationCurrent(rotation2);
                }
                this.lastTouchPoint.set(this.touchPoint);
                break;
            }
            case 0: {
                break;
            }
            case 11: {
                break;
            }
        }
        return true;
    }
}

