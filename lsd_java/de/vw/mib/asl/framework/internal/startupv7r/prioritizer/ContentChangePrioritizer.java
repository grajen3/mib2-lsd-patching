/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.prioritizer;

import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.StartupStateServiceImpl;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.LastUserModeMapping;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitQueue;
import de.vw.mib.asl.framework.internal.startupv7r.prioritizer.ContentChangePrioritizer$1;
import de.vw.mib.asl.framework.internal.startupv7r.prioritizer.ContentChangePrioritizer$2;
import de.vw.mib.asl.framework.internal.startupv7r.prioritizer.StartupPrioritizer;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.Logger;

public class ContentChangePrioritizer
implements StartupPrioritizer {
    private final IntObjectMap mapKeyId2ContentId = this.createKey2ContentMapping();
    private final StartupStateServiceImpl startupStateService;
    private final LastUserModeMapping lastUserModeMapping;
    private final Logger logger;
    private final StartupServices startupServices;
    private final WorkUnitQueue workUnitQueue;
    private KeyAdapter keyListener;

    public ContentChangePrioritizer(StartupServices startupServices, WorkUnitQueue workUnitQueue, LastUserModeMapping lastUserModeMapping) {
        this.startupServices = startupServices;
        this.workUnitQueue = workUnitQueue;
        this.lastUserModeMapping = lastUserModeMapping;
        this.startupStateService = startupServices.getStartupStateService();
        this.logger = startupServices.getLogger();
    }

    @Override
    public void run() {
        this.startupStateService.addListener(new ContentChangePrioritizer$1(this));
    }

    void onLastUserModeReady() {
        this.keyListener = this.createKeyAdapter();
        IntIterator intIterator = this.mapKeyId2ContentId.keySet().iterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            this.startupServices.getAslSystemApi().addKeyListener(n, this.keyListener);
        }
    }

    void onKeyPressed(int n) {
        String string = (String)this.mapKeyId2ContentId.get(n);
        AbstractWorkUnit abstractWorkUnit = this.lastUserModeMapping.retrieveWorkUnit(string);
        if (abstractWorkUnit != null) {
            this.workUnitQueue.prioritize(abstractWorkUnit);
            this.logger.info(1, new StringBuffer().append("Hard key pressed during startup - priorizing ").append(string).toString());
        }
    }

    void onStartupStateChanged(int n) {
        if (n != 2) {
            return;
        }
        IntIterator intIterator = this.mapKeyId2ContentId.keySet().iterator();
        while (intIterator.hasNext()) {
            int n2 = intIterator.next();
            this.startupServices.getAslSystemApi().removeKeyListener(n2, this.keyListener);
        }
    }

    private KeyAdapter createKeyAdapter() {
        return new ContentChangePrioritizer$2(this);
    }

    private IntObjectMap createKey2ContentMapping() {
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap();
        intObjectOptHashMap.put(11, "HMI_RADIO");
        intObjectOptHashMap.put(1, "HMI_MEDIA");
        intObjectOptHashMap.put(2, "HMI_PHONE");
        intObjectOptHashMap.put(3, "HMI_NAVI");
        intObjectOptHashMap.put(5, "HMI_CAR");
        intObjectOptHashMap.put(4, "HMI_TRAFFIC");
        intObjectOptHashMap.put(17, "HMI_CLIMATE");
        return intObjectOptHashMap;
    }
}

