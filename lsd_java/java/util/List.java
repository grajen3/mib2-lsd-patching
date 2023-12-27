/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public interface List
extends Collection {
    default public void add(int n, Object object) {
    }

    @Override
    default public boolean add(Object object) {
    }

    default public boolean addAll(int n, Collection collection) {
    }

    @Override
    default public boolean addAll(Collection collection) {
    }

    @Override
    default public void clear() {
    }

    @Override
    default public boolean contains(Object object) {
    }

    @Override
    default public boolean containsAll(Collection collection) {
    }

    @Override
    default public boolean equals(Object object) {
    }

    default public Object get(int n) {
    }

    @Override
    default public int hashCode() {
    }

    default public int indexOf(Object object) {
    }

    @Override
    default public boolean isEmpty() {
    }

    @Override
    default public Iterator iterator() {
    }

    default public int lastIndexOf(Object object) {
    }

    default public ListIterator listIterator() {
    }

    default public ListIterator listIterator(int n) {
    }

    default public Object remove(int n) {
    }

    @Override
    default public boolean remove(Object object) {
    }

    @Override
    default public boolean removeAll(Collection collection) {
    }

    @Override
    default public boolean retainAll(Collection collection) {
    }

    default public Object set(int n, Object object) {
    }

    @Override
    default public int size() {
    }

    default public List subList(int n, int n2) {
    }

    @Override
    default public Object[] toArray() {
    }

    @Override
    default public Object[] toArray(Object[] objectArray) {
    }
}

