/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.asl.api.system.FactorySettingsService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponent;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.internal.system.util.Preconditions;
import java.util.HashMap;

public class FactorySettingsServiceImpl
implements FactorySettingsService {
    private final HashMap contextMap = new HashMap();
    private FactoryResetService factoryResetService;

    public FactorySettingsServiceImpl(FactoryResetService factoryResetService) {
        Preconditions.checkArgumentNotNull(factoryResetService);
        this.factoryResetService = factoryResetService;
        this.initComponentMap();
    }

    @Override
    public void resetAllToFactorySettings() {
        this.factoryResetService.reset(FactoryResetComponents.FULL, 0);
    }

    @Override
    public void resetAllToFactorySettingsRemoteControlMode() {
        this.factoryResetService.reset(FactoryResetComponents.FULL, 1);
    }

    @Override
    public void resetToFactorySettings(int n) {
        FactoryResetComponent factoryResetComponent = (FactoryResetComponent)this.contextMap.get(this.createKey(n));
        if (factoryResetComponent == null) {
            throw new IllegalArgumentException(new StringBuffer().append("Context with ID >").append(n).append("< is unknown.").toString());
        }
        this.factoryResetService.reset(factoryResetComponent, 0);
    }

    private Integer createKey(int n) {
        return new Integer(n);
    }

    private void initComponentMap() {
        this.contextMap.put(this.createKey(1000), FactoryResetComponents.AUDIO);
        this.contextMap.put(this.createKey(3000), FactoryResetComponents.CAR);
        this.contextMap.put(this.createKey(3001), FactoryResetComponents.CAR_PARKING_ASSISTANCE);
        this.contextMap.put(this.createKey(10000), FactoryResetComponents.CONNECTIVITY);
        this.contextMap.put(this.createKey(7000), FactoryResetComponents.INTERNET_BROWSER);
        this.contextMap.put(this.createKey(5000), FactoryResetComponents.MEDIA);
        this.contextMap.put(this.createKey(14000), FactoryResetComponents.APP_CONNECT);
        this.contextMap.put(this.createKey(8000), FactoryResetComponents.NAVIGATION);
        this.contextMap.put(this.createKey(13000), FactoryResetComponents.ONLINE);
        this.contextMap.put(this.createKey(15000), FactoryResetComponents.PERSONALIZATION);
        this.contextMap.put(this.createKey(4000), FactoryResetComponents.PHONE);
        this.contextMap.put(this.createKey(2000), FactoryResetComponents.RADIO);
        this.contextMap.put(this.createKey(6000), FactoryResetComponents.SPEECH);
        this.contextMap.put(this.createKey(11000), FactoryResetComponents.SYSTEM);
        this.contextMap.put(this.createKey(12000), FactoryResetComponents.TVTUNER);
        this.contextMap.put(this.createKey(9000), FactoryResetComponents.WLAN);
    }
}

