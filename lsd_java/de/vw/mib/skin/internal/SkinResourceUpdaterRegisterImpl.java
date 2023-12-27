/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.skin.internal;

import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.lsctng.SkinUpdateFailException;
import de.vw.mib.skin.SkinImagePoolUpdater;
import de.vw.mib.skin.SkinResourceUpdater;
import de.vw.mib.skin.SkinResourceUpdaterRegister;
import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArrayList;
import java.io.IOException;
import java.util.Iterator;

public class SkinResourceUpdaterRegisterImpl
implements SkinImagePoolUpdater,
SkinResourceUpdaterRegister {
    private final CopyOnWriteArrayList skinResourceUpdaters = new CopyOnWriteArrayList();

    @Override
    public void add(SkinResourceUpdater skinResourceUpdater) {
        Preconditions.checkNotNull(skinResourceUpdater, "skinResourceUpdater");
        Preconditions.checkArgument(!this.skinResourceUpdaters.contains(skinResourceUpdater), "SkinResourceUpdater already added.");
        this.skinResourceUpdaters.add(skinResourceUpdater);
    }

    @Override
    public void remove(SkinResourceUpdater skinResourceUpdater) {
        Preconditions.checkNotNull(skinResourceUpdater, "skinResourceUpdater");
        Preconditions.checkArgument(this.skinResourceUpdaters.contains(skinResourceUpdater), "SkinResourceUpdater was not added and can't be removed from register.");
        this.skinResourceUpdaters.remove(skinResourceUpdater);
    }

    @Override
    public void updateSkin(int n) {
        try {
            Iterator iterator = this.skinResourceUpdaters.iterator();
            while (iterator.hasNext()) {
                SkinResourceUpdater skinResourceUpdater = (SkinResourceUpdater)iterator.next();
                skinResourceUpdater.onSkinChanged(n);
            }
        }
        catch (SkinUpdateFailException skinUpdateFailException) {
            throw new IOException(new StringBuffer().append("Update resources for skin ").append(n).append(" failed. Cause: ").append(skinUpdateFailException.getMessage()).toString());
        }
    }
}

