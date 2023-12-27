/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.ASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventService;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.datapool.ASLDatapool;
import java.util.ArrayList;
import java.util.List;

public abstract class HMIRelevantASLDataPoolAdapter
extends ASLDataPoolAdapter
implements HMIEventService,
HMIEventListener {
    protected static int LIST_INITIAL_CAPACITY = 5;
    private IntObjectOptHashMap registeredHMIListeners;

    public HMIRelevantASLDataPoolAdapter(ASLDatapool aSLDatapool) {
        super(aSLDatapool);
    }

    protected IntObjectOptHashMap getRegisteredHMIListeners() {
        if (this.registeredHMIListeners == null) {
            this.registeredHMIListeners = new IntObjectOptHashMap();
        }
        return this.registeredHMIListeners;
    }

    @Override
    public void addHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
        if (nArray != null) {
            IntObjectOptHashMap intObjectOptHashMap = this.getRegisteredHMIListeners();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                List list = (List)intObjectOptHashMap.get(nArray[i2]);
                if (list == null) {
                    ArrayList arrayList = new ArrayList(LIST_INITIAL_CAPACITY);
                    arrayList.add(hMIEventListener);
                    intObjectOptHashMap.put(nArray[i2], arrayList);
                    continue;
                }
                if (list.contains(hMIEventListener)) continue;
                list.add(hMIEventListener);
            }
        }
    }

    @Override
    public void removeHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
        if (nArray != null) {
            IntObjectOptHashMap intObjectOptHashMap = this.getRegisteredHMIListeners();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                List list = (List)intObjectOptHashMap.get(nArray[i2]);
                if (list == null) continue;
                list.remove(hMIEventListener);
                if (!list.isEmpty()) continue;
                intObjectOptHashMap.remove(nArray[i2]);
            }
        }
    }

    @Override
    public void processHMIEvent(int n) {
        List list = (List)this.getRegisteredHMIListeners().get(n);
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                HMIEventListener hMIEventListener = (HMIEventListener)list.get(i2);
                hMIEventListener.processHMIEvent(n);
            }
        }
    }
}

