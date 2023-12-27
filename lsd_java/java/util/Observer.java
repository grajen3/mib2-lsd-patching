/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Observable;

public interface Observer {
    default public void update(Observable observable, Object object) {
    }
}

