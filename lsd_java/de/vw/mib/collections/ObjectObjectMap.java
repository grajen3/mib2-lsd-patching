/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public interface ObjectObjectMap
extends Map {
    @Override
    default public int size() {
    }

    @Override
    default public boolean isEmpty() {
    }

    @Override
    default public boolean containsKey(Object object) {
    }

    @Override
    default public boolean containsValue(Object object) {
    }

    @Override
    default public Object get(Object object) {
    }

    @Override
    default public Object put(Object object, Object object2) {
    }

    @Override
    default public Object remove(Object object) {
    }

    @Override
    default public void clear() {
    }

    default public void ensureAvailableSpaceAndAvoidFurtherRehashes(int n) {
    }

    default public Iterator entryIterator() {
    }

    @Override
    default public Set entrySet() {
    }

    default public Iterator keyIterator() {
    }

    @Override
    default public Set keySet() {
    }

    @Override
    default public Collection values() {
    }

    default public Iterator valueIterator() {
    }

    default public Object replaceKey(Object object, Object object2) {
    }

    default public Object replaceOneValue(Object object, Object object2) {
    }

    default public Object getOneKeyByValue(Object object) {
    }

    default public Object[] valuesToArray() {
    }

    default public Object[] valuesToArray(Object[] objectArray) {
    }

    default public Object[] keysToArray() {
    }

    default public Object[] keysToArray(Object[] objectArray) {
    }

    default public ObjectObjectMap synchronize() {
    }

    @Override
    default public void putAll(Map map) {
    }
}

