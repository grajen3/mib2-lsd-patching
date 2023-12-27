/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$WaitNode;

final class Semaphore$FairSync$Node
extends WaitQueue$WaitNode {
    final int requests;

    Semaphore$FairSync$Node(int n) {
        this.requests = n;
    }
}

