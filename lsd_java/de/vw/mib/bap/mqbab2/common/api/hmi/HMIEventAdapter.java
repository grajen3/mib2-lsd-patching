/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.hmi;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventAdapter$1;
import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventService;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.event.SystemEvent;
import de.vw.mib.event.consumer.BAPSystemEventConsumer;
import java.util.ArrayList;
import java.util.List;

public class HMIEventAdapter
implements HMIEventService,
BAPSystemEventConsumer {
    private final APIFactoryInterface apiFactory;
    private static int LIST_INITIAL_CAPACITY = 3;
    private IntObjectOptHashMap registeredListeners;

    public HMIEventAdapter(APIFactoryInterface aPIFactoryInterface) {
        this.apiFactory = aPIFactoryInterface;
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    protected IntObjectOptHashMap getRegisteredListeners() {
        if (this.registeredListeners == null) {
            this.registeredListeners = new IntObjectOptHashMap();
        }
        return this.registeredListeners;
    }

    @Override
    public void addHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
        if (nArray != null) {
            IntObjectOptHashMap intObjectOptHashMap = this.getRegisteredListeners();
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
            IntObjectOptHashMap intObjectOptHashMap = this.getRegisteredListeners();
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
    public boolean consumeEvent(SystemEvent systemEvent) {
        int n = systemEvent.getType();
        if (n == 1 || n == 2) {
            int n2 = systemEvent.getId();
            IntObjectOptHashMap intObjectOptHashMap = this.getRegisteredListeners();
            List list = (List)intObjectOptHashMap.get(n2);
            if (list != null) {
                ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLThreadSwitch().enqueue(new HMIEventAdapter$1(this, list, n2));
            }
        }
        return false;
    }
}

