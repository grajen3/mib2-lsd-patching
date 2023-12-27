/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe;

import de.vw.mib.asl.api.speechengine.slots.SlotEntry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoader;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoaderObserver;
import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotLoader;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.Iterator;
import org.dsi.ifc.speechrec.Grammar;

public class SlotLoaderBuffer
extends SlotLoader
implements CommandLoaderObserver {
    private final CommandLoader commandLoader;
    protected final IntObjectMap currentEntries = new IntObjectOptHashMap();

    public SlotLoaderBuffer(CommandLoader commandLoader) {
        this.commandLoader = commandLoader;
        this.commandLoader.registerObserver(this);
    }

    @Override
    public void loadSlot(int n, SlotEntry[] slotEntryArray) {
        this.currentEntries.put(n, slotEntryArray);
        this.forwardLoadRequestToRuleLoadingComponent(n, slotEntryArray);
    }

    private void forwardLoadRequestToRuleLoadingComponent(int n, SlotEntry[] slotEntryArray) {
        String[] stringArray = new String[slotEntryArray.length];
        long[] lArray = new long[slotEntryArray.length];
        for (int i2 = 0; i2 < slotEntryArray.length; ++i2) {
            lArray[i2] = slotEntryArray[i2].getObjectId();
            stringArray[i2] = slotEntryArray[i2].getSpeakableText();
        }
        this.commandLoader.loadSlot(n, stringArray, lArray);
    }

    public void reloadSlots() {
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap((IntObjectOptHashMap)this.currentEntries);
        this.currentEntries.clear();
        Iterator iterator = intObjectOptHashMap.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = intObjectMap$Entry.getKey();
            SlotEntry[] slotEntryArray = (SlotEntry[])intObjectMap$Entry.getValue();
            this.loadSlot(n, slotEntryArray);
        }
    }

    @Override
    public Grammar[] onCommandsLost() {
        return new Grammar[0];
    }

    @Override
    public void onSlotsLost() {
        this.reloadSlots();
    }
}

