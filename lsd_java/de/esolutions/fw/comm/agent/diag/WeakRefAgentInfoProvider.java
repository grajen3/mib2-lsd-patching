/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.IAgentInfoProvider;
import de.esolutions.fw.comm.agent.diag.AgentInfoMap;
import de.esolutions.fw.comm.agent.diag.IInfoBase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeakRefAgentInfoProvider
implements IAgentInfoProvider {
    private List list = new ArrayList();

    @Override
    public AgentInfoMap getAgentInfoMap() {
        AgentInfoMap agentInfoMap = new AgentInfoMap();
        Iterator iterator = this.list.iterator();
        while (iterator.hasNext()) {
            WeakReference weakReference = (WeakReference)iterator.next();
            IAgentInfoProvider iAgentInfoProvider = (IAgentInfoProvider)weakReference.get();
            if (null != iAgentInfoProvider) {
                agentInfoMap.add(iAgentInfoProvider.getAgentInfoMap());
                continue;
            }
            iterator.remove();
        }
        return agentInfoMap;
    }

    public IInfoBase[] getData() {
        IInfoBase[] iInfoBaseArray = null;
        ArrayList arrayList = new ArrayList();
        try {
            Iterator iterator = this.list.iterator();
            while (iterator.hasNext()) {
            }
            iInfoBaseArray = (IInfoBase[])arrayList.toArray(new IInfoBase[arrayList.size()]);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return iInfoBaseArray;
    }

    public void registerIAgentInfoProvider(IAgentInfoProvider iAgentInfoProvider) {
        this.list.add(new WeakReference(iAgentInfoProvider));
    }
}

