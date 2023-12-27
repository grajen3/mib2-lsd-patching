/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar;

import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoaderObserver;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import org.dsi.ifc.speechrec.Grammar;

public class CommandLoaderObserverProxy
implements CommandLoaderObserver {
    private final LinkedList observerList = new LinkedList();

    void addObserver(CommandLoaderObserver commandLoaderObserver) {
        this.observerList.add(commandLoaderObserver);
    }

    void removeObserver(CommandLoaderObserver commandLoaderObserver) {
        this.observerList.remove(commandLoaderObserver);
    }

    @Override
    public Grammar[] onCommandsLost() {
        ArrayList arrayList = new ArrayList(0);
        for (int i2 = 0; i2 < this.observerList.size(); ++i2) {
            Object[] objectArray = ((CommandLoaderObserver)this.observerList.get(i2)).onCommandsLost();
            if (objectArray == null) continue;
            arrayList.addAll(Arrays.asList(objectArray));
        }
        Object[] objectArray = new Grammar[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    @Override
    public void onSlotsLost() {
        for (int i2 = 0; i2 < this.observerList.size(); ++i2) {
            ((CommandLoaderObserver)this.observerList.get(i2)).onSlotsLost();
        }
    }
}

