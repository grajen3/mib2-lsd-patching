/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.animation.target;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.internal.scene.animation.target.AbstractAnimationTarget;
import de.vw.mib.graphics.scene.animation.target.CameraAnimationTarget;
import de.vw.mib.graphics.scene.graph.visual.camera.CameraEntity;
import de.vw.mib.graphics.scene.graph.visual.camera.FrustumCamera;
import de.vw.mib.graphics.scene.graph.visual.camera.OrthographicCamera;
import de.vw.mib.graphics.scene.graph.visual.camera.PerspectiveCamera;
import de.vw.mib.util.StringBuilder;

public final class UnpooledCameraAnimationTarget
extends AbstractAnimationTarget
implements CameraAnimationTarget {
    private final CameraEntity camera;

    public UnpooledCameraAnimationTarget(int n, int n2, CameraEntity cameraEntity) {
        super(0, n, n2);
        this.camera = cameraEntity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",camera=").append(this.camera);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public Object getTarget() {
        return this.camera;
    }

    @Override
    public void setValue(float[] fArray) {
        int n = this.getAttribute();
        switch (n) {
            case 0: {
                FrustumCamera frustumCamera = (FrustumCamera)this.camera;
                float f2 = fArray[0];
                frustumCamera.setNear(f2);
                break;
            }
            case 1: {
                FrustumCamera frustumCamera = (FrustumCamera)this.camera;
                float f3 = fArray[0];
                frustumCamera.setNear(f3);
                break;
            }
            case 2: {
                FrustumCamera frustumCamera = (FrustumCamera)this.camera;
                break;
            }
            case 3: {
                PerspectiveCamera perspectiveCamera = (PerspectiveCamera)this.camera;
                break;
            }
            case 4: {
                PerspectiveCamera perspectiveCamera = (PerspectiveCamera)this.camera;
                break;
            }
            case 5: {
                OrthographicCamera orthographicCamera = (OrthographicCamera)this.camera;
                throw new NotYetImplementedException();
            }
            case 6: {
                OrthographicCamera orthographicCamera = (OrthographicCamera)this.camera;
                throw new NotYetImplementedException();
            }
            default: {
                throw new IllegalArgumentException("Invalid camera target attribute");
            }
        }
    }
}

