/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Timer$TimerImpl$TimerNode;

final class Timer$TimerImpl$TimerTree {
    Timer$TimerImpl$TimerNode root;

    Timer$TimerImpl$TimerTree() {
    }

    boolean isEmpty() {
        return this.root == null;
    }

    void insert(Timer$TimerImpl$TimerNode timer$TimerImpl$TimerNode) {
        Timer$TimerImpl$TimerNode timer$TimerImpl$TimerNode2 = null;
        Timer$TimerImpl$TimerNode timer$TimerImpl$TimerNode3 = this.root;
        while (timer$TimerImpl$TimerNode3 != null) {
            timer$TimerImpl$TimerNode2 = timer$TimerImpl$TimerNode3;
            timer$TimerImpl$TimerNode3 = timer$TimerImpl$TimerNode.task.when < timer$TimerImpl$TimerNode3.task.when ? timer$TimerImpl$TimerNode3.left : timer$TimerImpl$TimerNode3.right;
        }
        timer$TimerImpl$TimerNode.parent = timer$TimerImpl$TimerNode2;
        if (timer$TimerImpl$TimerNode2 == null) {
            this.root = timer$TimerImpl$TimerNode;
        } else if (timer$TimerImpl$TimerNode.task.when < timer$TimerImpl$TimerNode2.task.when) {
            timer$TimerImpl$TimerNode2.left = timer$TimerImpl$TimerNode;
        } else {
            timer$TimerImpl$TimerNode2.right = timer$TimerImpl$TimerNode;
        }
    }

    void delete(Timer$TimerImpl$TimerNode timer$TimerImpl$TimerNode) {
        Timer$TimerImpl$TimerNode timer$TimerImpl$TimerNode2 = null;
        Timer$TimerImpl$TimerNode timer$TimerImpl$TimerNode3 = null;
        timer$TimerImpl$TimerNode2 = timer$TimerImpl$TimerNode.left == null || timer$TimerImpl$TimerNode.right == null ? timer$TimerImpl$TimerNode : this.successor(timer$TimerImpl$TimerNode);
        timer$TimerImpl$TimerNode3 = timer$TimerImpl$TimerNode2.left != null ? timer$TimerImpl$TimerNode2.left : timer$TimerImpl$TimerNode2.right;
        if (timer$TimerImpl$TimerNode3 != null) {
            timer$TimerImpl$TimerNode3.parent = timer$TimerImpl$TimerNode2.parent;
        }
        if (timer$TimerImpl$TimerNode2.parent == null) {
            this.root = timer$TimerImpl$TimerNode3;
        } else if (timer$TimerImpl$TimerNode2 == timer$TimerImpl$TimerNode2.parent.left) {
            timer$TimerImpl$TimerNode2.parent.left = timer$TimerImpl$TimerNode3;
        } else {
            timer$TimerImpl$TimerNode2.parent.right = timer$TimerImpl$TimerNode3;
        }
        if (timer$TimerImpl$TimerNode2 != timer$TimerImpl$TimerNode) {
            timer$TimerImpl$TimerNode.task = timer$TimerImpl$TimerNode2.task;
        }
    }

    private Timer$TimerImpl$TimerNode successor(Timer$TimerImpl$TimerNode timer$TimerImpl$TimerNode) {
        if (timer$TimerImpl$TimerNode.right != null) {
            return this.minimum(timer$TimerImpl$TimerNode.right);
        }
        Timer$TimerImpl$TimerNode timer$TimerImpl$TimerNode2 = timer$TimerImpl$TimerNode.parent;
        while (timer$TimerImpl$TimerNode2 != null && timer$TimerImpl$TimerNode == timer$TimerImpl$TimerNode2.right) {
            timer$TimerImpl$TimerNode = timer$TimerImpl$TimerNode2;
            timer$TimerImpl$TimerNode2 = timer$TimerImpl$TimerNode2.parent;
        }
        return timer$TimerImpl$TimerNode2;
    }

    private Timer$TimerImpl$TimerNode minimum(Timer$TimerImpl$TimerNode timer$TimerImpl$TimerNode) {
        while (timer$TimerImpl$TimerNode.left != null) {
            timer$TimerImpl$TimerNode = timer$TimerImpl$TimerNode.left;
        }
        return timer$TimerImpl$TimerNode;
    }

    Timer$TimerImpl$TimerNode minimum() {
        return this.minimum(this.root);
    }
}

