/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.sd.internal;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.api.speechengine.features.GenericTargetFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexInitialPromptsFeature;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.collections.ObjectArrayList;
import generated.de.vw.mib.global.datapool.SdFeatureCollectionHandlerBase;
import java.util.ArrayList;

public final class NavSdfch
extends SdFeatureCollectionHandlerBase {
    @Override
    public void init(int n, int n2) {
        this.sdFeatColId = n;
        this.speechClientId = n2;
        switch (n) {
            case 3: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 4: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal sdFeatColId: ").append(this.sdFeatColId).toString());
            }
        }
    }

    @Override
    protected Feature createFeatureInstance(int n) {
        switch (this.sdFeatColId) {
            case 3: {
                return this.createFeatureInstance_SNPE_07(n);
            }
            case 4: {
                return this.createFeatureInstance_SNPXU_08(n);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal sdFeatColId: ").append(this.sdFeatColId).toString());
    }

    private Feature createFeatureInstance_SNPE_07(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(201);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SNPXU_08(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(NavSdfch.createPrompt(450));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(306);
                genericTargetFeature.setInt(3070, 6);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    @Override
    protected void collectAllUnconditionalCommands(ObjectArrayList objectArrayList) {
        switch (this.sdFeatColId) {
            default: 
        }
        super.collectAllUnconditionalCommands(objectArrayList);
    }

    @Override
    protected boolean evaluateCondition(int n) {
        switch (this.sdFeatColId) {
            default: 
        }
        return super.evaluateCondition(n);
    }

    @Override
    protected void collectAllCommandsGuardedByOneCondition(ObjectArrayList objectArrayList, int n) {
        switch (this.sdFeatColId) {
            default: 
        }
        super.collectAllCommandsGuardedByOneCondition(objectArrayList, n);
    }

    @Override
    protected int[] getAffectedFeatures(int n) {
        switch (this.sdFeatColId) {
            default: 
        }
        return super.getAffectedFeatures(n);
    }

    @Override
    protected int[] getConditionsAffectedByProperty(int n) {
        switch (this.sdFeatColId) {
            default: 
        }
        return super.getConditionsAffectedByProperty(n);
    }

    @Override
    protected int[] getConditionsAffectedByList(int n) {
        switch (this.sdFeatColId) {
            default: 
        }
        return super.getConditionsAffectedByList(n);
    }

    @Override
    protected void updateAffectedFeature(int n) {
        switch (this.sdFeatColId) {
            default: 
        }
        super.updateAffectedFeature(n);
    }
}

