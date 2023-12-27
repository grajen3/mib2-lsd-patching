/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.config;

import de.esolutions.fw.comm.agent.config.CommConfigTransportParams;
import de.esolutions.fw.comm.agent.naming.ConfigNameService;
import de.esolutions.fw.comm.agent.naming.INameService;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.IConfigValueTracer;
import de.esolutions.fw.util.config.commons.PriorityParser;
import de.esolutions.fw.util.config.fw.SystemConfig;
import de.esolutions.fw.util.config.model.ConfigArray;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;

public class CommConfigTransportStatic
implements IConfigValueTracer {
    private HashMap mapValues = null;
    private INameService nameService = null;
    private String key;
    private CommConfigTransportParams defaultValues;

    public CommConfigTransportStatic(ConfigValue configValue, CommConfigTransportParams commConfigTransportParams, String string) {
        this.key = string;
        this.defaultValues = commConfigTransportParams;
        this.nameService = new ConfigNameService(SystemConfig.getInstance());
        this.mapValues = new HashMap();
        if (configValue != null && configValue.isArray()) {
            this.walkThroughStaticArray((ConfigArray)configValue);
        }
        this.nameService = null;
    }

    private void walkThroughStaticArray(ConfigArray configArray) {
        int n = configArray.getArraySize();
        for (int i2 = 0; i2 < n; ++i2) {
            ConfigValue configValue = configArray.getArrayValue(i2);
            if (!configValue.isDictionary()) continue;
            this.parseValues(configValue);
        }
    }

    private void parseValues(ConfigValue configValue) {
        ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
        Short[] shortArray = this.parseProcessesValues(configPathQuery, "procs");
        if (shortArray != null && shortArray.length != 0) {
            CommConfigTransportParams commConfigTransportParams = this.createCommConfigTransportValues(configPathQuery);
            HashMap hashMap = this.createMap(shortArray, commConfigTransportParams);
            this.mapValues.putAll(hashMap);
        }
    }

    private CommConfigTransportParams createCommConfigTransportValues(ConfigPathQuery configPathQuery) {
        CommConfigTransportParams commConfigTransportParams = null;
        boolean bl = configPathQuery.getBooleanValue("async", this.defaultValues.getAsync());
        int n = configPathQuery.getIntegerValue("queue_limit_bytes", this.defaultValues.getQueueLimitBytes());
        int n2 = configPathQuery.getIntegerValue("queue_limit_jobs", this.defaultValues.getQueueLimitJobs());
        int n3 = PriorityParser.parse(configPathQuery, "prio", this.defaultValues.getPriority(), false);
        commConfigTransportParams = new CommConfigTransportParams(bl, n3, n2, n);
        return commConfigTransportParams;
    }

    private HashMap createMap(Short[] shortArray, CommConfigTransportParams commConfigTransportParams) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < shortArray.length; ++i2) {
            if (shortArray[i2] == null) continue;
            hashMap.put(shortArray[i2], commConfigTransportParams);
            CommAgentTracing.CONFIG.log((short)2, "%1: %4 for process with ID %2 = %3", (Object)this.key, (Object)shortArray[i2], (Object)commConfigTransportParams);
        }
        return hashMap;
    }

    private Short[] parseProcessesValues(ConfigPathQuery configPathQuery, String string) {
        Object[] objectArray = null;
        ConfigValue configValue = configPathQuery.getArray(string);
        if (configValue != null && configValue.isArray()) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < configValue.getArraySize(); ++i2) {
                Short s = this.parseProcessValue(configValue.getArrayValue(i2));
                if (s == null) continue;
                arrayList.add(s);
            }
            objectArray = new Short[arrayList.size()];
            arrayList.toArray(objectArray);
        } else {
            ConfigValue configValue2 = configPathQuery.getValue(string);
            if (configValue2 != null) {
                objectArray = new Short[]{this.parseProcessValue(configValue2)};
            }
        }
        return objectArray;
    }

    private Short parseProcessValue(ConfigValue configValue) {
        Short s = null;
        if (configValue.isInteger()) {
            s = new Short((short)configValue.getInteger().intValue());
        } else if (configValue.isString()) {
            try {
                s = this.nameService.mapNameToID(configValue.getString());
            }
            catch (Exception exception) {
                CommAgentTracing.CONFIG.log((short)3, "id look up for procName %1 in array %2. Exception: %3 ", (Object)configValue.getString(), (Object)this.key, (Object)exception);
            }
            if (s == null) {
                CommAgentTracing.CONFIG.log((short)3, "Id for procName %1 not found, the procName will be ignored ", (Object)configValue.getString(), (Object)this.key);
            }
        }
        return s;
    }

    public Short[] getIds() {
        int n = this.mapValues.keySet().size();
        Object[] objectArray = new Short[n];
        this.mapValues.keySet().toArray(objectArray);
        return objectArray;
    }

    public CommConfigTransportParams getTransportConfigForAgent(short s) {
        CommConfigTransportParams commConfigTransportParams = null;
        Short s2 = new Short(s);
        if (this.mapValues != null && this.mapValues.containsKey(s2)) {
            commConfigTransportParams = (CommConfigTransportParams)this.mapValues.get(s2);
        }
        return commConfigTransportParams;
    }

    @Override
    public void traceValues() {
        Iterator iterator = this.mapValues.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            Short s = (Short)map$Entry.getKey();
            this.key = new StringBuffer().append(this.key).append(".").append(s.toString()).toString();
            CommConfigTransportParams commConfigTransportParams = (CommConfigTransportParams)map$Entry.getValue();
            CommAgentTracing.CONFIG.log((short)2, "%2.queueLimitBytes = %1", new Integer(commConfigTransportParams.getQueueLimitBytes()), (Object)this.key);
            CommAgentTracing.CONFIG.log((short)2, "%2.queueLimitJobs  = %1", new Integer(commConfigTransportParams.getQueueLimitJobs()), (Object)this.key);
            CommAgentTracing.CONFIG.log((short)2, "%2.priority        = %1", new Integer(commConfigTransportParams.getPriority()), (Object)this.key);
            CommAgentTracing.CONFIG.log((short)2, "%2.async           = %1", new Boolean(commConfigTransportParams.getAsync()), (Object)this.key);
        }
    }
}

