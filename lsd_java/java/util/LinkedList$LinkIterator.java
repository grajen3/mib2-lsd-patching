/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.LinkedList$Link;
import java.util.ListIterator;
import java.util.NoSuchElementException;

final class LinkedList$LinkIterator
implements ListIterator {
    int pos;
    int expectedModCount;
    final LinkedList list;
    LinkedList$Link link;
    LinkedList$Link lastLink;

    LinkedList$LinkIterator(LinkedList linkedList, int n) {
        this.list = linkedList;
        this.expectedModCount = this.list.modCount;
        if (n >= 0 && n <= this.list.size) {
            this.link = this.list.voidLink;
            if (n < this.list.size / 2) {
                this.pos = -1;
                while (this.pos + 1 < n) {
                    this.link = this.link.next;
                    ++this.pos;
                }
            } else {
                this.pos = this.list.size;
                while (this.pos >= n) {
                    this.link = this.link.previous;
                    --this.pos;
                }
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(Object object) {
        if (this.expectedModCount == this.list.modCount) {
            LinkedList$Link linkedList$Link;
            LinkedList$Link linkedList$Link2 = this.link.next;
            this.link.next = linkedList$Link = new LinkedList$Link(object, this.link, linkedList$Link2);
            linkedList$Link2.previous = linkedList$Link;
            this.link = linkedList$Link;
            this.lastLink = null;
            ++this.pos;
            ++this.expectedModCount;
            ++this.list.size;
            ++this.list.modCount;
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public boolean hasNext() {
        return this.link.next != this.list.voidLink;
    }

    @Override
    public boolean hasPrevious() {
        return this.link != this.list.voidLink;
    }

    @Override
    public Object next() {
        if (this.expectedModCount == this.list.modCount) {
            LinkedList$Link linkedList$Link = this.link.next;
            if (linkedList$Link != this.list.voidLink) {
                this.lastLink = this.link = linkedList$Link;
                ++this.pos;
                return this.link.data;
            }
            throw new NoSuchElementException();
        }
        throw new ConcurrentModificationException();
    }

    @Override
    public int nextIndex() {
        return this.pos + 1;
    }

    @Override
    public Object previous() {
        if (this.expectedModCount == this.list.modCount) {
            if (this.link != this.list.voidLink) {
                this.lastLink = this.link;
                this.link = this.link.previous;
                --this.pos;
                return this.lastLink.data;
            }
            throw new NoSuchElementException();
        }
        throw new ConcurrentModificationException();
    }

    @Override
    public int previousIndex() {
        return this.pos;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void remove() {
        LinkedList$Link linkedList$Link;
        if (this.expectedModCount != this.list.modCount) throw new ConcurrentModificationException();
        if (this.lastLink == null) throw new IllegalStateException();
        LinkedList$Link linkedList$Link2 = this.lastLink.next;
        linkedList$Link2.previous = linkedList$Link = this.lastLink.previous;
        linkedList$Link.next = linkedList$Link2;
        if (this.lastLink == this.link) {
            --this.pos;
        }
        this.link = linkedList$Link;
        this.lastLink = null;
        ++this.expectedModCount;
        --this.list.size;
        ++this.list.modCount;
    }

    @Override
    public void set(Object object) {
        if (this.expectedModCount == this.list.modCount) {
            if (this.lastLink == null) {
                throw new IllegalStateException();
            }
        } else {
            throw new ConcurrentModificationException();
        }
        this.lastLink.data = object;
    }
}

