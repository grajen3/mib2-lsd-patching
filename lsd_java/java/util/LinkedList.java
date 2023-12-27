/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList$Link;
import java.util.LinkedList$LinkIterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList
extends AbstractSequentialList
implements List,
Cloneable,
Serializable {
    private static final long serialVersionUID;
    transient int size = 0;
    transient LinkedList$Link voidLink;

    public LinkedList() {
        this.voidLink.previous = this.voidLink = new LinkedList$Link(null, null, null);
        this.voidLink.next = this.voidLink;
    }

    public LinkedList(Collection collection) {
        this();
        this.addAll(collection);
    }

    @Override
    public void add(int n, Object object) {
        if (n >= 0 && n <= this.size) {
            LinkedList$Link linkedList$Link;
            int n2;
            LinkedList$Link linkedList$Link2 = this.voidLink;
            if (n < this.size / 2) {
                n2 = 0;
                while (n2 <= n) {
                    linkedList$Link2 = linkedList$Link2.next;
                    ++n2;
                }
            } else {
                n2 = this.size;
                while (n2 > n) {
                    linkedList$Link2 = linkedList$Link2.previous;
                    --n2;
                }
            }
            LinkedList$Link linkedList$Link3 = linkedList$Link2.previous;
            linkedList$Link3.next = linkedList$Link = new LinkedList$Link(object, linkedList$Link3, linkedList$Link2);
            linkedList$Link2.previous = linkedList$Link;
            ++this.size;
            ++this.modCount;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean add(Object object) {
        LinkedList$Link linkedList$Link;
        LinkedList$Link linkedList$Link2 = this.voidLink.previous;
        this.voidLink.previous = linkedList$Link = new LinkedList$Link(object, linkedList$Link2, this.voidLink);
        linkedList$Link2.next = linkedList$Link;
        ++this.size;
        ++this.modCount;
        return true;
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        int n2 = collection.size();
        if (n2 == 0) {
            return false;
        }
        if (n >= 0 && n <= this.size) {
            int n3;
            LinkedList$Link linkedList$Link = this.voidLink;
            if (n < this.size / 2) {
                n3 = 0;
                while (n3 < n) {
                    linkedList$Link = linkedList$Link.next;
                    ++n3;
                }
            } else {
                n3 = this.size;
                while (n3 >= n) {
                    linkedList$Link = linkedList$Link.previous;
                    --n3;
                }
            }
            LinkedList$Link linkedList$Link2 = linkedList$Link.next;
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                LinkedList$Link linkedList$Link3;
                linkedList$Link.next = linkedList$Link3 = new LinkedList$Link(iterator.next(), linkedList$Link, null);
                linkedList$Link = linkedList$Link3;
            }
            linkedList$Link.next = linkedList$Link2;
            linkedList$Link2.previous = linkedList$Link;
            this.size += n2;
            ++this.modCount;
            return true;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean addAll(Collection collection) {
        int n = collection.size();
        if (n == 0) {
            return false;
        }
        LinkedList$Link linkedList$Link = this.voidLink.previous;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            LinkedList$Link linkedList$Link2;
            linkedList$Link.next = linkedList$Link2 = new LinkedList$Link(iterator.next(), linkedList$Link, null);
            linkedList$Link = linkedList$Link2;
        }
        linkedList$Link.next = this.voidLink;
        this.voidLink.previous = linkedList$Link;
        this.size += n;
        ++this.modCount;
        return true;
    }

    public void addFirst(Object object) {
        LinkedList$Link linkedList$Link;
        LinkedList$Link linkedList$Link2 = this.voidLink.next;
        this.voidLink.next = linkedList$Link = new LinkedList$Link(object, this.voidLink, linkedList$Link2);
        linkedList$Link2.previous = linkedList$Link;
        ++this.size;
        ++this.modCount;
    }

    public void addLast(Object object) {
        LinkedList$Link linkedList$Link;
        LinkedList$Link linkedList$Link2 = this.voidLink.previous;
        this.voidLink.previous = linkedList$Link = new LinkedList$Link(object, linkedList$Link2, this.voidLink);
        linkedList$Link2.next = linkedList$Link;
        ++this.size;
        ++this.modCount;
    }

    @Override
    public void clear() {
        if (this.size > 0) {
            this.size = 0;
            this.voidLink.next = this.voidLink;
            this.voidLink.previous = this.voidLink;
            ++this.modCount;
        }
    }

    public Object clone() {
        return new LinkedList(this);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean contains(Object var1_1) {
        block4: {
            var2_2 = this.voidLink.next;
            if (var1_1 == null) ** GOTO lbl12
            while (var2_2 != this.voidLink) {
                if (var1_1.equals(var2_2.data)) {
                    return true;
                }
                var2_2 = var2_2.next;
            }
            break block4;
lbl-1000:
            // 1 sources

            {
                if (var2_2.data == null) {
                    return true;
                }
                var2_2 = var2_2.next;
lbl12:
                // 2 sources

                ** while (var2_2 != this.voidLink)
            }
        }
        return false;
    }

    @Override
    public Object get(int n) {
        if (n >= 0 && n < this.size) {
            LinkedList$Link linkedList$Link = this.voidLink;
            if (n < this.size / 2) {
                int n2 = 0;
                while (n2 <= n) {
                    linkedList$Link = linkedList$Link.next;
                    ++n2;
                }
            } else {
                int n3 = this.size;
                while (n3 > n) {
                    linkedList$Link = linkedList$Link.previous;
                    --n3;
                }
            }
            return linkedList$Link.data;
        }
        throw new IndexOutOfBoundsException();
    }

    public Object getFirst() {
        LinkedList$Link linkedList$Link = this.voidLink.next;
        if (linkedList$Link != this.voidLink) {
            return linkedList$Link.data;
        }
        throw new NoSuchElementException();
    }

    public Object getLast() {
        LinkedList$Link linkedList$Link = this.voidLink.previous;
        if (linkedList$Link != this.voidLink) {
            return linkedList$Link.data;
        }
        throw new NoSuchElementException();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public int indexOf(Object var1_1) {
        block4: {
            var2_2 = 0;
            var3_3 = this.voidLink.next;
            if (var1_1 == null) ** GOTO lbl15
            while (var3_3 != this.voidLink) {
                if (var1_1.equals(var3_3.data)) {
                    return var2_2;
                }
                var3_3 = var3_3.next;
                ++var2_2;
            }
            break block4;
lbl-1000:
            // 1 sources

            {
                if (var3_3.data == null) {
                    return var2_2;
                }
                var3_3 = var3_3.next;
                ++var2_2;
lbl15:
                // 2 sources

                ** while (var3_3 != this.voidLink)
            }
        }
        return -1;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public int lastIndexOf(Object var1_1) {
        block4: {
            var2_2 = this.size;
            var3_3 = this.voidLink.previous;
            if (var1_1 == null) ** GOTO lbl15
            while (var3_3 != this.voidLink) {
                --var2_2;
                if (var1_1.equals(var3_3.data)) {
                    return var2_2;
                }
                var3_3 = var3_3.previous;
            }
            break block4;
lbl-1000:
            // 1 sources

            {
                --var2_2;
                if (var3_3.data == null) {
                    return var2_2;
                }
                var3_3 = var3_3.previous;
lbl15:
                // 2 sources

                ** while (var3_3 != this.voidLink)
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator(int n) {
        return new LinkedList$LinkIterator(this, n);
    }

    @Override
    public Object remove(int n) {
        if (n >= 0 && n < this.size) {
            LinkedList$Link linkedList$Link;
            int n2;
            LinkedList$Link linkedList$Link2 = this.voidLink;
            if (n < this.size / 2) {
                n2 = 0;
                while (n2 <= n) {
                    linkedList$Link2 = linkedList$Link2.next;
                    ++n2;
                }
            } else {
                n2 = this.size;
                while (n2 > n) {
                    linkedList$Link2 = linkedList$Link2.previous;
                    --n2;
                }
            }
            LinkedList$Link linkedList$Link3 = linkedList$Link2.previous;
            linkedList$Link3.next = linkedList$Link = linkedList$Link2.next;
            linkedList$Link.previous = linkedList$Link3;
            --this.size;
            ++this.modCount;
            return linkedList$Link2.data;
        }
        throw new IndexOutOfBoundsException();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean remove(Object var1_1) {
        block3: {
            var2_2 = this.voidLink.next;
            if (var1_1 == null) ** GOTO lbl8
            while (var2_2 != this.voidLink && !var1_1.equals(var2_2.data)) {
                var2_2 = var2_2.next;
            }
            break block3;
lbl-1000:
            // 1 sources

            {
                var2_2 = var2_2.next;
lbl8:
                // 2 sources

                ** while (var2_2 != this.voidLink && var2_2.data != null)
            }
        }
        if (var2_2 == this.voidLink) {
            return false;
        }
        var3_3 = var2_2.next;
        var4_4 = var2_2.previous;
        var4_4.next = var3_3;
        var3_3.previous = var4_4;
        --this.size;
        ++this.modCount;
        return true;
    }

    public Object removeFirst() {
        LinkedList$Link linkedList$Link = this.voidLink.next;
        if (linkedList$Link != this.voidLink) {
            LinkedList$Link linkedList$Link2;
            this.voidLink.next = linkedList$Link2 = linkedList$Link.next;
            linkedList$Link2.previous = this.voidLink;
            --this.size;
            ++this.modCount;
            return linkedList$Link.data;
        }
        throw new NoSuchElementException();
    }

    public Object removeLast() {
        LinkedList$Link linkedList$Link = this.voidLink.previous;
        if (linkedList$Link != this.voidLink) {
            LinkedList$Link linkedList$Link2;
            this.voidLink.previous = linkedList$Link2 = linkedList$Link.previous;
            linkedList$Link2.next = this.voidLink;
            --this.size;
            ++this.modCount;
            return linkedList$Link.data;
        }
        throw new NoSuchElementException();
    }

    @Override
    public Object set(int n, Object object) {
        if (n >= 0 && n < this.size) {
            int n2;
            LinkedList$Link linkedList$Link = this.voidLink;
            if (n < this.size / 2) {
                n2 = 0;
                while (n2 <= n) {
                    linkedList$Link = linkedList$Link.next;
                    ++n2;
                }
            } else {
                n2 = this.size;
                while (n2 > n) {
                    linkedList$Link = linkedList$Link.previous;
                    --n2;
                }
            }
            Object object2 = linkedList$Link.data;
            linkedList$Link.data = object;
            return object2;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object[] toArray() {
        int n = 0;
        Object[] objectArray = new Object[this.size];
        LinkedList$Link linkedList$Link = this.voidLink.next;
        while (linkedList$Link != this.voidLink) {
            objectArray[n++] = linkedList$Link.data;
            linkedList$Link = linkedList$Link.next;
        }
        return objectArray;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        int n = 0;
        if (this.size > objectArray.length) {
            objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), this.size);
        }
        LinkedList$Link linkedList$Link = this.voidLink.next;
        while (linkedList$Link != this.voidLink) {
            objectArray[n++] = linkedList$Link.data;
            linkedList$Link = linkedList$Link.next;
        }
        if (n < objectArray.length) {
            objectArray[n] = null;
        }
        return objectArray;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            objectOutputStream.writeObject(iterator.next());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.size = objectInputStream.readInt();
        LinkedList$Link linkedList$Link = this.voidLink = new LinkedList$Link(null, null, null);
        int n = this.size;
        while (--n >= 0) {
            LinkedList$Link linkedList$Link2;
            linkedList$Link.next = linkedList$Link2 = new LinkedList$Link(objectInputStream.readObject(), linkedList$Link, null);
            linkedList$Link = linkedList$Link2;
        }
        linkedList$Link.next = this.voidLink;
        this.voidLink.previous = linkedList$Link;
    }
}

