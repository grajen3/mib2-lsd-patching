/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollection
implements Collection {
    protected AbstractCollection() {
    }

    @Override
    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection collection) {
        boolean bl = false;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!this.add(iterator.next())) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public void clear() {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean contains(Object var1_1) {
        block2: {
            var2_2 = this.iterator();
            if (var1_1 == null) ** GOTO lbl9
            while (var2_2.hasNext()) {
                if (!var1_1.equals(var2_2.next())) continue;
                return true;
            }
            break block2;
lbl-1000:
            // 1 sources

            {
                if (var2_2.next() != null) continue;
                return true;
lbl9:
                // 2 sources

                ** while (var2_2.hasNext())
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (this.contains(iterator.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public abstract Iterator iterator() {
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean remove(Object var1_1) {
        block2: {
            var2_2 = this.iterator();
            if (var1_1 == null) ** GOTO lbl11
            while (var2_2.hasNext()) {
                if (!var1_1.equals(var2_2.next())) continue;
                var2_2.remove();
                return true;
            }
            break block2;
lbl-1000:
            // 1 sources

            {
                if (var2_2.next() != null) continue;
                var2_2.remove();
                return true;
lbl11:
                // 2 sources

                ** while (var2_2.hasNext())
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean bl = false;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (!collection.contains(iterator.next())) continue;
            iterator.remove();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean retainAll(Collection collection) {
        boolean bl = false;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (collection.contains(iterator.next())) continue;
            iterator.remove();
            bl = true;
        }
        return bl;
    }

    @Override
    public abstract int size() {
    }

    @Override
    public Object[] toArray() {
        int n = this.size();
        int n2 = 0;
        Iterator iterator = this.iterator();
        Object[] objectArray = new Object[n];
        while (n2 < n) {
            objectArray[n2++] = iterator.next();
        }
        return objectArray;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        int n = this.size();
        int n2 = 0;
        Iterator iterator = this.iterator();
        if (n > objectArray.length) {
            objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), n);
        }
        while (n2 < n) {
            objectArray[n2++] = iterator.next();
        }
        if (n2 < objectArray.length) {
            objectArray[n2] = null;
        }
        return objectArray;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer(this.size() * 16);
        stringBuffer.append('[');
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (object != this) {
                stringBuffer.append(object);
            } else {
                stringBuffer.append("(this Collection)");
            }
            stringBuffer.append(", ");
        }
        if (stringBuffer.length() > 1) {
            stringBuffer.setLength(stringBuffer.length() - 2);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }
}

