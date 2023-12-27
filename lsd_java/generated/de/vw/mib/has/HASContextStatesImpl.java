/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has;

import de.vw.mib.has.HASContextStates;
import de.vw.mib.has.HASDatapool;
import de.vw.mib.has.HASFactory;
import generated.de.vw.mib.has.containers.ContextStateContainer;
import generated.de.vw.mib.has.containers.ContextStatesContainer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class HASContextStatesImpl
implements HASContextStates {
    private final Map states = Collections.synchronizedMap(new HashMap());
    private final HASDatapool datapool;
    private final ContextStatesContainer statesContainer;

    HASContextStatesImpl(HASDatapool hASDatapool, HASFactory hASFactory) {
        this.datapool = hASDatapool;
        this.statesContainer = this.init(hASFactory);
    }

    private ContextStatesContainer init(HASFactory hASFactory) {
        this.initContext(hASFactory, "AppConnect");
        this.initContext(hASFactory, "Car");
        this.initContext(hASFactory, "EntertainmentManager");
        this.initContext(hASFactory, "Exlap");
        this.initContext(hASFactory, "HAS");
        this.initContext(hASFactory, "Media");
        this.initContext(hASFactory, "Navigation");
        this.initContext(hASFactory, "OnlineServices");
        this.initContext(hASFactory, "Phone");
        this.initContext(hASFactory, "Radio");
        this.initContext(hASFactory, "Sound");
        this.initContext(hASFactory, "System");
        ContextStatesContainer contextStatesContainer = (ContextStatesContainer)hASFactory.createContainer(0x1000001);
        contextStatesContainer.setStates((ContextStateContainer[])this.states.values().toArray(new ContextStateContainer[this.states.size()]));
        return contextStatesContainer;
    }

    private void initContext(HASFactory hASFactory, String string) {
        ContextStateContainer contextStateContainer = (ContextStateContainer)hASFactory.createContainer(1);
        contextStateContainer.setContext(string);
        contextStateContainer.setState(0);
        this.states.put(string, contextStateContainer);
    }

    void update() {
        this.datapool.updateProperty(1, this.statesContainer);
    }

    @Override
    public void updateContextState(String string, int n) {
        ContextStateContainer contextStateContainer = (ContextStateContainer)this.states.get(string);
        if (null == contextStateContainer) {
            throw new IllegalArgumentException(new StringBuffer().append("context unknown: ").append(string).toString());
        }
        contextStateContainer.setState(n);
        this.update();
    }

    @Override
    public int getContextState(String string) {
        ContextStateContainer contextStateContainer = (ContextStateContainer)this.states.get(string);
        return null != contextStateContainer ? contextStateContainer.getState() : 0;
    }
}

