/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.Deque;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import java.util.Iterator;

public interface BlockingDeque
extends BlockingQueue,
Deque {
    @Override
    default public void addFirst(Object object) {
    }

    @Override
    default public void addLast(Object object) {
    }

    @Override
    default public boolean offerFirst(Object object) {
    }

    @Override
    default public boolean offerLast(Object object) {
    }

    default public void putFirst(Object object) {
    }

    default public void putLast(Object object) {
    }

    default public boolean offerFirst(Object object, long l, TimeUnit timeUnit) {
    }

    default public boolean offerLast(Object object, long l, TimeUnit timeUnit) {
    }

    default public Object takeFirst() {
    }

    default public Object takeLast() {
    }

    default public Object pollFirst(long l, TimeUnit timeUnit) {
    }

    default public Object pollLast(long l, TimeUnit timeUnit) {
    }

    @Override
    default public boolean removeFirstOccurrence(Object object) {
    }

    @Override
    default public boolean removeLastOccurrence(Object object) {
    }

    @Override
    default public boolean add(Object object) {
    }

    @Override
    default public boolean offer(Object object) {
    }

    @Override
    default public void put(Object object) {
    }

    @Override
    default public boolean offer(Object object, long l, TimeUnit timeUnit) {
    }

    @Override
    default public Object remove() {
    }

    @Override
    default public Object poll() {
    }

    @Override
    default public Object take() {
    }

    @Override
    default public Object poll(long l, TimeUnit timeUnit) {
    }

    @Override
    default public Object element() {
    }

    @Override
    default public Object peek() {
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

    @Override
    default public void push(Object object) {
    }
}

