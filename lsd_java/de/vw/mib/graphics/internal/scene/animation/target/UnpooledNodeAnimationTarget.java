/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.animation.target;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.internal.scene.animation.target.AbstractAnimationTarget;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.algebra.AxisAngle;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.scene.animation.target.NodeAnimationTarget;
import de.vw.mib.graphics.scene.graph.SceneNode;
import de.vw.mib.graphics.scene.graph.TransformElement;
import de.vw.mib.util.StringBuilder;
import java.util.List;

public final class UnpooledNodeAnimationTarget
extends AbstractAnimationTarget
implements NodeAnimationTarget {
    private final SceneNode node;

    public UnpooledNodeAnimationTarget(int n, int n2, int n3, SceneNode sceneNode) {
        super(3, n, n2, n3);
        this.node = sceneNode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",node=").append(this.node);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public Object getTarget() {
        return this.node;
    }

    @Override
    public void setValue(float[] fArray) {
        int n = this.getAttribute();
        int n2 = this.getAttributeIndex();
        int n3 = this.getArrayIndex();
        List list = this.node.getTransformSequence();
        TransformElement transformElement = (TransformElement)list.get(n2);
        switch (n) {
            case 3000: {
                throw new NotYetImplementedException();
            }
            case 3001: {
                Vector3f vector3f = transformElement.getTranslation();
                UnpooledNodeAnimationTarget.setValue(vector3f, fArray, n3);
                break;
            }
            case 3002: {
                AxisAngle axisAngle = transformElement.getRotation();
                UnpooledNodeAnimationTarget.setValue(axisAngle, fArray, n3);
                break;
            }
            case 3003: {
                Tuple3f tuple3f = transformElement.getScale();
                UnpooledNodeAnimationTarget.setValue(tuple3f, fArray, n3);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid node target attribute");
            }
        }
        this.node.setTransformSequence(list);
    }
}

