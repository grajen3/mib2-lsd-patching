/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.graphics.internal.scene.graph.AbstractSceneElement;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.algebra.AxisAngle;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Rotation;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import de.vw.mib.graphics.scene.graph.SceneElement;
import de.vw.mib.graphics.scene.graph.SceneEntity;
import de.vw.mib.graphics.scene.graph.SceneNode;
import de.vw.mib.graphics.scene.graph.SceneNodeController;
import de.vw.mib.graphics.scene.graph.SceneNodeListener;
import de.vw.mib.graphics.scene.graph.TransformElement;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSceneNode
extends AbstractSceneElement
implements SceneNode {
    private static final long serialVersionUID;
    private static final boolean BOUNDING_VOLUME_AAB;
    private transient CowList listeners = CowList.EMPTY;
    private transient CowList controllers = CowList.EMPTY;
    private List children;
    private List entities;
    private Transform transform;
    private List transformSequence;
    private Transform globalTransform;
    private boolean globalTransformValid;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$scene$graph$AbstractSceneNode;

    public AbstractSceneNode() {
        int n = 3;
        this.children = new ArrayList(3);
        boolean bl = true;
        this.entities = new ArrayList(1);
        this.transform = new Transform();
        this.transformSequence = null;
        this.globalTransform = new Transform();
        this.globalTransformValid = false;
    }

    @Override
    public Object clone() {
        int n;
        AbstractSceneNode abstractSceneNode = (AbstractSceneNode)super.clone();
        int n2 = this.children.size();
        abstractSceneNode.children = new ArrayList(n2);
        for (n = 0; n < n2; ++n) {
            abstractSceneNode.children.add(((SceneElement)this.children.get(n)).clone());
        }
        abstractSceneNode.listeners = CowList.EMPTY;
        abstractSceneNode.controllers = CowList.EMPTY;
        n = this.entities.size();
        abstractSceneNode.entities = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            abstractSceneNode.entities.add(((SceneEntity)this.entities.get(i2)).clone());
        }
        abstractSceneNode.transform = null;
        abstractSceneNode.globalTransform = null;
        abstractSceneNode.globalTransformValid = false;
        return abstractSceneNode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",transform=").append(this.transform);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.children.clear();
        this.listeners = CowList.EMPTY;
        this.controllers = CowList.EMPTY;
        this.entities.clear();
        super.dispose();
    }

    @Override
    protected void parentChanged(SceneNode sceneNode, SceneNode sceneNode2) {
        this.fireParentChanged(sceneNode);
    }

    private void fireParentChanged(SceneNode sceneNode) {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            SceneNodeListener sceneNodeListener = (SceneNodeListener)cowList.head();
            sceneNodeListener.parentChanged(this, sceneNode);
        }
    }

    @Override
    public final boolean isRoot() {
        return this.getParent() == null;
    }

    @Override
    public final void addListener(SceneNodeListener sceneNodeListener) {
        this.listeners = this.listeners.addIfAbsent(sceneNodeListener);
    }

    @Override
    public final void removeListener(SceneNodeListener sceneNodeListener) {
        this.listeners = this.listeners.remove(sceneNodeListener);
    }

    @Override
    public final void addController(SceneNodeController sceneNodeController) {
        this.controllers = this.controllers.addIfAbsent(sceneNodeController);
    }

    @Override
    public final void removeController(SceneNodeController sceneNodeController) {
        this.controllers = this.controllers.remove(sceneNodeController);
    }

    @Override
    public final int getChildCount() {
        return this.children.size();
    }

    public final List getChildren() {
        return this.children;
    }

    @Override
    public final SceneNode getChild(int n) {
        return (SceneNode)this.children.get(n);
    }

    @Override
    public final void setChild(int n, SceneNode sceneNode) {
        sceneNode.setParent(this);
        SceneNode sceneNode2 = (SceneNode)this.children.get(n);
        if (sceneNode2 != null) {
            sceneNode2.setParent(null);
            this.childRemoved(sceneNode2);
        }
        this.children.set(n, sceneNode);
        this.childAdded(sceneNode);
    }

    @Override
    public final void addChild(SceneNode sceneNode) {
        if (!$assertionsDisabled && this == sceneNode) {
            throw new AssertionError((Object)"Must not add a node to itself");
        }
        sceneNode.setParent(this);
        this.children.add(sceneNode);
        this.childAdded(sceneNode);
    }

    protected void childAdded(SceneNode sceneNode) {
        this.fireChildAdded(sceneNode);
        this.invalidateBoundingVolume();
    }

    private void fireChildAdded(SceneNode sceneNode) {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            SceneNodeListener sceneNodeListener = (SceneNodeListener)cowList.head();
            sceneNodeListener.childAdded(this, sceneNode);
        }
    }

    @Override
    public final void removeChild(SceneNode sceneNode) {
        sceneNode.setParent(null);
        this.children.remove(sceneNode);
        this.childRemoved(sceneNode);
    }

    protected void childRemoved(SceneNode sceneNode) {
        this.fireChildRemoved(sceneNode);
        this.invalidateBoundingVolume();
    }

    private void fireChildRemoved(SceneNode sceneNode) {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            SceneNodeListener sceneNodeListener = (SceneNodeListener)cowList.head();
            sceneNodeListener.childRemoved(this, sceneNode);
        }
    }

    @Override
    public final int getEntityCount() {
        return this.entities.size();
    }

    @Override
    public final SceneEntity getEntity(int n) {
        return (SceneEntity)this.entities.get(n);
    }

    @Override
    public final void addEntity(SceneEntity sceneEntity) {
        if (!$assertionsDisabled && sceneEntity.getParent() != null) {
            throw new AssertionError();
        }
        sceneEntity.setParent(this);
        this.entities.add(sceneEntity);
        this.entityAdded(sceneEntity);
    }

    protected void entityAdded(SceneEntity sceneEntity) {
        this.fireEntityAdded(sceneEntity);
        this.invalidateBoundingVolume();
    }

    private void fireEntityAdded(SceneEntity sceneEntity) {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            SceneNodeListener sceneNodeListener = (SceneNodeListener)cowList.head();
            sceneNodeListener.entityAdded(this, sceneEntity);
        }
    }

    @Override
    public final void removeEntity(SceneEntity sceneEntity) {
        if (!$assertionsDisabled && sceneEntity.getParent() == null) {
            throw new AssertionError();
        }
        sceneEntity.setParent(null);
        this.entities.remove(sceneEntity);
        this.entityRemoved(sceneEntity);
    }

    protected void entityRemoved(SceneEntity sceneEntity) {
        this.fireEntityRemoved(sceneEntity);
        this.invalidateBoundingVolume();
    }

    private void fireEntityRemoved(SceneEntity sceneEntity) {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            SceneNodeListener sceneNodeListener = (SceneNodeListener)cowList.head();
            sceneNodeListener.entityRemoved(this, sceneEntity);
        }
    }

    @Override
    public final Transform getTransform() {
        return this.transform;
    }

    @Override
    public final void setTransform(Transform transform) {
        if (!this.transform.equals(transform)) {
            this.transform.set(transform);
            this.transformChanged();
        }
    }

    @Override
    public final List getTransformSequence() {
        return this.transformSequence;
    }

    @Override
    public final void setTransformSequence(List list) {
        this.transformSequence = list;
        int n = this.transformSequence.size();
        this.transform.setIdentity();
        block7: for (int i2 = 0; i2 < n; ++i2) {
            TransformElement transformElement = (TransformElement)this.transformSequence.get(i2);
            switch (transformElement.getType()) {
                case 0: {
                    Cloneable cloneable = transformElement.getTranslation();
                    AxisAngle axisAngle = transformElement.getRotation();
                    Tuple3f tuple3f = transformElement.getScale();
                    Transform transform = new Transform();
                    transform.setTranslation((Tuple3f)cloneable);
                    transform.setRotation(axisAngle);
                    transform.setScale(tuple3f);
                    this.transform.transform(transform);
                    continue block7;
                }
                case 1: {
                    Cloneable cloneable = transformElement.getTranslation();
                    this.transform.translate((Vector3f)cloneable);
                    continue block7;
                }
                case 2: {
                    Cloneable cloneable = transformElement.getRotation();
                    this.transform.rotate(((AxisAngle)cloneable).getAngle(), ((Tuple4f)cloneable).getX(), ((Tuple4f)cloneable).getY(), ((Tuple4f)cloneable).getZ());
                    continue block7;
                }
                case 3: {
                    Cloneable cloneable = transformElement.getScale();
                    this.transform.scale((Tuple3f)cloneable);
                    continue block7;
                }
                case 4: {
                    Cloneable cloneable = transformElement.getMatrix();
                    this.transform.transform((Matrix4f)cloneable);
                    continue block7;
                }
                default: {
                    throw new IllegalArgumentException("Invalid transform element type");
                }
            }
        }
        this.transformChanged();
    }

    protected void transformChanged() {
        this.invalidateTransform();
    }

    @Override
    public final SceneNode transform(Transform transform) {
        this.transform.transform(transform);
        this.invalidateTransform();
        return this;
    }

    @Override
    public final void getPosition(Point3f point3f) {
        this.transform.getTranslation(point3f);
    }

    @Override
    public final void setPosition(Point3f point3f) {
        this.transform.setTranslation(point3f);
        this.positionChanged();
    }

    @Override
    public final void setPosition(float f2, float f3, float f4) {
        this.transform.setTranslation(f2, f3, f4);
        this.positionChanged();
    }

    @Override
    public final SceneNode translate(Vector3f vector3f) {
        this.transform.translate(vector3f);
        this.positionChanged();
        return this;
    }

    @Override
    public final SceneNode translate(float f2, float f3, float f4) {
        this.transform.translate(f2, f3, f4);
        this.positionChanged();
        return this;
    }

    protected void positionChanged() {
        this.transformChanged();
    }

    @Override
    public final void getOrientation(Matrix3f matrix3f) {
        this.transform.getRotation(matrix3f);
    }

    @Override
    public final void getOrientation(Rotation rotation) {
        this.transform.getRotation(rotation);
    }

    @Override
    public final void setOrientation(Matrix3f matrix3f) {
        this.transform.setRotation(matrix3f);
        this.orientationChanged();
    }

    @Override
    public final void setOrientation(Rotation rotation) {
        this.transform.setRotation(rotation);
        this.orientationChanged();
    }

    @Override
    public SceneNode rotate(Rotation rotation) {
        this.transform.rotate(rotation);
        this.orientationChanged();
        return this;
    }

    @Override
    public final SceneNode rotate(Matrix3f matrix3f) {
        this.transform.rotate(matrix3f);
        this.orientationChanged();
        return this;
    }

    @Override
    public final SceneNode rotate(float f2, float f3, float f4, float f5) {
        this.transform.rotate(f2, f3, f4, f5);
        this.orientationChanged();
        return this;
    }

    protected void orientationChanged() {
        this.transformChanged();
    }

    @Override
    public final void getScale(Tuple3f tuple3f) {
        this.transform.getScale(tuple3f);
    }

    @Override
    public final void setScale(Tuple3f tuple3f) {
        this.transform.setScale(tuple3f);
        this.scaleChanged();
    }

    @Override
    public final void setScale(float f2, float f3, float f4) {
        this.transform.setScale(f2, f3, f4);
        this.scaleChanged();
    }

    @Override
    public final SceneNode scale(Tuple3f tuple3f) {
        this.transform.scale(tuple3f);
        this.scaleChanged();
        return this;
    }

    @Override
    public final SceneNode scale(float f2, float f3, float f4) {
        this.transform.scale(f2, f3, f4);
        this.scaleChanged();
        return this;
    }

    protected void scaleChanged() {
        this.transformChanged();
    }

    @Override
    public final Transform getGlobalTransform() {
        if (!this.globalTransformValid) {
            this.updateGlobalTransform();
            this.globalTransformValid = true;
        }
        return this.globalTransform;
    }

    protected final void setGlobalTransform(Transform transform) {
        Transform transform2 = this.globalTransform;
        if (transform2 == null || !transform2.equals(transform)) {
            this.globalTransform = transform;
            this.globalTransformChanged(transform2, transform);
        }
        this.globalTransformValid = true;
    }

    protected void globalTransformChanged(Transform transform, Transform transform2) {
    }

    public final void invalidateTransform() {
        SceneElement sceneElement;
        int n;
        this.globalTransformValid = false;
        this.invalidateBoundingVolume();
        for (n = this.entities.size() - 1; n >= 0; --n) {
            sceneElement = (SceneEntity)this.entities.get(n);
            ((AbstractSceneElement)sceneElement).invalidateBoundingVolume();
        }
        for (n = this.children.size() - 1; n >= 0; --n) {
            sceneElement = (AbstractSceneNode)this.children.get(n);
            super.invalidateTransform();
        }
    }

    private void updateGlobalTransform() {
        Transform transform = this.getTransform();
        SceneNode sceneNode = this.getParent();
        if (sceneNode != null) {
            Transform transform2 = sceneNode.getGlobalTransform();
            transform2.transform(transform, this.globalTransform);
        } else {
            this.globalTransform.set(transform);
        }
    }

    @Override
    protected final BoundingVolume createBoundingVolume() {
        return new Sphere3f();
    }

    @Override
    protected final void updateBoundingVolume(BoundingVolume boundingVolume) {
        BoundingVolume boundingVolume2;
        SceneElement sceneElement;
        int n;
        boundingVolume.clear();
        for (n = this.entities.size() - 1; n >= 0; --n) {
            sceneElement = (SceneEntity)this.entities.get(n);
            boundingVolume2 = sceneElement.getBoundingVolume();
            if (boundingVolume2.isEmpty()) continue;
            if (boundingVolume.isEmpty()) {
                boundingVolume.set(boundingVolume2);
                continue;
            }
            boundingVolume.union(boundingVolume2);
        }
        for (n = this.children.size() - 1; n >= 0; --n) {
            sceneElement = (SceneNode)this.children.get(n);
            boundingVolume2 = sceneElement.getBoundingVolume();
            if (boundingVolume2.isEmpty()) continue;
            if (boundingVolume.isEmpty()) {
                boundingVolume.set(boundingVolume2);
                continue;
            }
            boundingVolume.union(boundingVolume2);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$scene$graph$AbstractSceneNode == null ? (class$de$vw$mib$graphics$internal$scene$graph$AbstractSceneNode = AbstractSceneNode.class$("de.vw.mib.graphics.internal.scene.graph.AbstractSceneNode")) : class$de$vw$mib$graphics$internal$scene$graph$AbstractSceneNode).desiredAssertionStatus();
    }
}

