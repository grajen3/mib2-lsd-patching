/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.gem.TouchControllerIFC
 */
package de.vw.mib.widgets.controller;

import de.audi.gem.TouchControllerIFC;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.RotationEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.DefaultViewController;
import de.vw.mib.widgets.controller.GEMAdapterController;
import de.vw.mib.widgets.gem.VWGEMController;
import de.vw.mib.widgets.models.GEMAdapterModel;

public final class DefaultGEMAdapterController
extends DefaultViewController
implements GEMAdapterController {
    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        GEMAdapterModel gEMAdapterModel = (GEMAdapterModel)this.getWidget();
        VWGEMController vWGEMController = gEMAdapterModel.getGEMController();
        int n = 1;
        if (null != hMIEvent && hMIEvent.getType() == 16) {
            n = ((RotationEvent)hMIEvent).getTicks();
        }
        if ("rotateLeft" == string) {
            vWGEMController.updateKeyTurned(0, -1, n);
        } else if ("rotateRight" == string) {
            vWGEMController.updateKeyTurned(0, 1, n);
        } else if ("rotatePress" == string) {
            vWGEMController.updateKeyPressed(0);
        } else if ("rotateRelease" == string) {
            vWGEMController.updateKeyReleased(0);
        }
        return true;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        GEMAdapterModel gEMAdapterModel = (GEMAdapterModel)this.getWidget();
        VWGEMController vWGEMController = gEMAdapterModel.getGEMController();
        if (vWGEMController instanceof TouchControllerIFC) {
            int n;
            switch (touchEvent.getType()) {
                case 0: {
                    n = 0;
                    break;
                }
                case 1: {
                    n = 1;
                    break;
                }
                case 6: {
                    n = 4;
                    break;
                }
                case 3: 
                case 4: {
                    n = 3;
                    break;
                }
                case 7: 
                case 8: {
                    n = 5;
                    break;
                }
                case 2: {
                    n = 2;
                    break;
                }
                case 10: {
                    n = 6;
                    break;
                }
                case 11: {
                    n = -1;
                    break;
                }
                default: {
                    return true;
                }
            }
            int n2 = touchEvent.getX() - gEMAdapterModel.getAbsX();
            int n3 = touchEvent.getY() - gEMAdapterModel.getAbsY();
            int n4 = touchEvent.getTimestamp();
            ((TouchControllerIFC)vWGEMController).updateTouchGesture(n, n2, n3, n4);
        }
        return true;
    }

    @Override
    public void fire_rotateLeft() {
    }

    @Override
    public void fire_rotateRight() {
    }

    @Override
    public void fire_rotatePress() {
    }

    @Override
    public void fire_rotateRelease() {
    }
}

