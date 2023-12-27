/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph;

import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Rotation;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.scene.graph.SceneElement;
import de.vw.mib.graphics.scene.graph.SceneEntity;
import de.vw.mib.graphics.scene.graph.SceneNodeController;
import de.vw.mib.graphics.scene.graph.SceneNodeListener;
import java.util.List;

public interface SceneNode
extends SceneElement {
    default public boolean isRoot() {
    }

    default public void addListener(SceneNodeListener sceneNodeListener) {
    }

    default public void removeListener(SceneNodeListener sceneNodeListener) {
    }

    default public void addController(SceneNodeController sceneNodeController) {
    }

    default public void removeController(SceneNodeController sceneNodeController) {
    }

    default public int getChildCount() {
    }

    default public SceneNode getChild(int n) {
    }

    default public void setChild(int n, SceneNode sceneNode) {
    }

    default public void addChild(SceneNode sceneNode) {
    }

    default public void removeChild(SceneNode sceneNode) {
    }

    default public int getEntityCount() {
    }

    default public SceneEntity getEntity(int n) {
    }

    default public void addEntity(SceneEntity sceneEntity) {
    }

    default public void removeEntity(SceneEntity sceneEntity) {
    }

    default public Transform getTransform() {
    }

    default public void setTransform(Transform transform) {
    }

    default public List getTransformSequence() {
    }

    default public void setTransformSequence(List list) {
    }

    default public SceneNode transform(Transform transform) {
    }

    default public void getPosition(Point3f point3f) {
    }

    default public void setPosition(Point3f point3f) {
    }

    default public void setPosition(float f2, float f3, float f4) {
    }

    default public SceneNode translate(Vector3f vector3f) {
    }

    default public SceneNode translate(float f2, float f3, float f4) {
    }

    default public void getOrientation(Matrix3f matrix3f) {
    }

    default public void getOrientation(Rotation rotation) {
    }

    default public void setOrientation(Matrix3f matrix3f) {
    }

    default public void setOrientation(Rotation rotation) {
    }

    default public SceneNode rotate(Matrix3f matrix3f) {
    }

    default public SceneNode rotate(Rotation rotation) {
    }

    default public SceneNode rotate(float f2, float f3, float f4, float f5) {
    }

    default public void getScale(Tuple3f tuple3f) {
    }

    default public void setScale(Tuple3f tuple3f) {
    }

    default public void setScale(float f2, float f3, float f4) {
    }

    default public SceneNode scale(Tuple3f tuple3f) {
    }

    default public SceneNode scale(float f2, float f3, float f4) {
    }

    default public Transform getGlobalTransform() {
    }
}

