/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerParameters;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.FeatureIdsUtil;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.List;

public class StartupFeatureHandler
implements FeatureHandler {
    protected DialogManagerLogger logger = new DialogManagerLogger("[StartupFeatureHandler] ");
    protected DialogManagerInternal dialogManager;
    protected DialogManagerParameters dialogManagerParameters;
    private List requiredMap;
    private List unregisterHandler;

    public StartupFeatureHandler(DialogManagerInternal dialogManagerInternal, DialogManagerParameters dialogManagerParameters) {
        this.dialogManager = dialogManagerInternal;
        this.dialogManagerParameters = dialogManagerParameters;
        this.unregisterHandler = new ArrayList();
        this.initRequired();
        this.registerHandlers();
    }

    private void initRequired() {
        this.requiredMap = new ArrayList();
        this.requiredMap.add(new Integer(101));
        this.requiredMap.add(new Integer(102));
        this.requiredMap.add(new Integer(103));
        this.requiredMap.add(new Integer(104));
        this.requiredMap.add(new Integer(105));
        this.requiredMap.add(new Integer(106));
        this.requiredMap.add(new Integer(107));
        this.requiredMap.add(new Integer(108));
        this.requiredMap.add(new Integer(109));
        this.requiredMap.add(new Integer(112));
        this.requiredMap.add(new Integer(110));
    }

    private void registerHandlers() {
        for (int i2 = 0; i2 < this.requiredMap.size(); ++i2) {
            Integer n = (Integer)this.requiredMap.get(i2);
            this.dialogManager.registerFeatureHandler(n, this);
        }
        if (this.requiredMap.size() > 0) {
            this.dialogManager.registerFeatureHandlerDone(this);
        } else {
            this.dialogManager.onInitializationReady();
        }
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("got feature : ").append(FeatureIdsUtil.toString(feature.getFeatureType())).append(".").toString());
            if (this.requiredMap.size() <= 1) {
                this.logger.trace("Got all required features, initialization complete.");
            }
        }
        this.removeFeatureWithId(feature.getFeatureType());
    }

    private void removeFeatureWithId(int n) {
        int n2 = -1;
        for (int i2 = 0; i2 < this.requiredMap.size(); ++i2) {
            Integer n3 = (Integer)this.requiredMap.get(i2);
            if (n3 != n) continue;
            n2 = i2;
            break;
        }
        if (n2 < 0) {
            StringBuffer stringBuffer = new StringBuffer("received feature '");
            stringBuffer.append(FeatureIdsUtil.toString(n));
            stringBuffer.append("', but not found in map.");
            this.logger.error(stringBuffer.toString());
            return;
        }
        this.requiredMap.remove(n2);
        this.unregisterHandler.add(new Integer(n));
    }

    @Override
    public void updateFeature(int n, Feature feature) {
    }

    @Override
    public boolean handleDone() {
        boolean bl = false;
        for (int i2 = 0; i2 < this.unregisterHandler.size(); ++i2) {
            Integer n = (Integer)this.unregisterHandler.get(i2);
            this.dialogManager.unregisterFeatureHandler(n, this);
        }
        this.unregisterHandler.clear();
        if (this.requiredMap.size() == 0) {
            bl = true;
            this.dialogManager.onInitializationReady();
        } else {
            StringBuilder stringBuilder = new StringBuilder("require ");
            stringBuilder.append(this.requiredMap.size());
            stringBuilder.append(" more features for full initialization: [");
            for (int i3 = 0; i3 < this.requiredMap.size(); ++i3) {
                Integer n = (Integer)this.requiredMap.get(i3);
                stringBuilder.append(FeatureIdsUtil.toString(n));
                stringBuilder.append(",");
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
            stringBuilder.append("]");
            this.logger.trace(stringBuilder.toString());
        }
        return bl;
    }

    @Override
    public boolean updateDone() {
        return false;
    }
}

