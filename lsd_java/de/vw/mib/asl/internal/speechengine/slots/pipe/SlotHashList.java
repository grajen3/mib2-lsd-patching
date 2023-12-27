/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe;

import de.vw.mib.asl.api.speechengine.slots.SlotEntry;
import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotList;
import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotLoader;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.collections.longs.LongOptHashSet;
import de.vw.mib.collections.longs.LongSet;
import java.util.ArrayList;

public class SlotHashList
implements SlotList {
    private final int slotId;
    private final SlotLoader slotLoader;
    private boolean dirty = true;
    private SlotEntry[] slotEntries;
    private LongObjectMap slotEntriesHashRepresentation;

    public SlotHashList(int n, SlotLoader slotLoader) {
        this.slotLoader = slotLoader;
        this.slotId = n;
        this.slotEntries = new SlotEntry[0];
        this.slotEntriesHashRepresentation = new LongObjectOptHashMap();
    }

    private void copy(ArrayList arrayList, Object[] objectArray, int n) {
        int n2 = n;
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            Object object;
            objectArray[n2] = object = arrayList.get(i2);
            ++n2;
        }
    }

    @Override
    public int getSlotId() {
        return this.slotId;
    }

    @Override
    public void add(SlotEntry[] slotEntryArray) {
        ArrayList arrayList = SlotHashList.findDiffSlotEntries(slotEntryArray, this.slotEntriesHashRepresentation);
        if (arrayList.size() != 0) {
            int n = this.slotEntries.length + arrayList.size();
            Object[] objectArray = new SlotEntry[n];
            System.arraycopy((Object)this.slotEntries, 0, (Object)objectArray, 0, this.slotEntries.length);
            int n2 = this.slotEntries.length;
            this.copy(arrayList, objectArray, n2);
            this.slotEntries = objectArray;
            this.dirty = true;
        }
    }

    @Override
    public void exchangeAll(SlotEntry[] slotEntryArray) {
        LongObjectOptHashMap longObjectOptHashMap = new LongObjectOptHashMap();
        ArrayList arrayList = SlotHashList.findDiffSlotEntries(slotEntryArray, longObjectOptHashMap);
        boolean bl = longObjectOptHashMap.equals(this.slotEntriesHashRepresentation);
        if (!bl) {
            Object[] objectArray = new SlotEntry[arrayList.size()];
            this.copy(arrayList, objectArray, 0);
            this.slotEntries = objectArray;
            this.slotEntriesHashRepresentation = longObjectOptHashMap;
            this.dirty = true;
        }
    }

    @Override
    public boolean isDirty() {
        return this.dirty;
    }

    @Override
    public void load() {
        this.slotLoader.loadSlot(this.getSlotId(), this.slotEntries);
        this.dirty = false;
    }

    private static ArrayList findDiffSlotEntries(SlotEntry[] slotEntryArray, LongObjectMap longObjectMap) {
        ArrayList arrayList = new ArrayList(10);
        for (int i2 = 0; i2 < slotEntryArray.length; ++i2) {
            LongSet longSet;
            SlotEntry slotEntry = slotEntryArray[i2];
            if (slotEntry == null || slotEntry.getSpeakableText() == null) continue;
            long l = HashCodeBuilder.hash(slotEntry.getSpeakableText());
            if (longObjectMap.containsKey(l)) {
                longSet = (LongSet)longObjectMap.get(l);
                if (longSet.contains(slotEntry.getObjectId())) continue;
                longSet.add(slotEntry.getObjectId());
                arrayList.add(slotEntry);
                continue;
            }
            longSet = new LongOptHashSet(1);
            longSet.add(slotEntry.getObjectId());
            longObjectMap.put(l, longSet);
            arrayList.add(slotEntry);
        }
        return arrayList;
    }
}

