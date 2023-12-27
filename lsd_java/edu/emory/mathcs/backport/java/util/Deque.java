/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Queue;
import java.util.Iterator;

public interface Deque
extends Queue {
    default public void addFirst(Object object) {
    }

    default public void addLast(Object object) {
    }

    default public boolean offerFirst(Object object) {
    }

    default public boolean offerLast(Object object) {
    }

    default public Object removeFirst() {
    }

    default public Object removeLast() {
    }

    default public Object pollFirst() {
    }

    default public Object pollLast() {
    }

    default public Object getFirst() {
    }

    default public Object getLast() {
    }

    default public Object peekFirst() {
    }

    default public Object peekLast() {
    }

    default public boolean removeFirstOccurrence(Object object) {
    }

    default public boolean removeLastOccurrence(Object object) {
    }

    @Override
    default public boolean add(Object object) {
    }

    @Override
    default public boolean offer(Object object) {
    }

    @Override
    default public Object remove() {
    }

    @Override
    default public Object poll() {
    }

    @Override
    default public Object element() {
    }

    @Override
    default public Object peek() {
    }

    default public void push(Object object) {
    }

    default public Object pop() {
    }

    @Override
    default public boolean remove(Object object) {
    }

    @Override
    default public boolean contains(Object object) {
    }

    @Override
    default public int size() {
    }

    @Override
    default public Iterator iterator() {
    }

    default public Iterator descendingIterator() {
    }
}

