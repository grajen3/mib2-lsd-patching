/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.picturestore.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import java.util.List;

public interface PictureStore
extends Persistable {
    default public List getPictures() {
    }
}

