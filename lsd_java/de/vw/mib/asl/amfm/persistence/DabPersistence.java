/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.ComponentPersistence;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistence;
import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import java.util.List;

public interface DabPersistence
extends Persistable {
    default public FrequencyPersistence getCurrentFrequency() {
    }

    default public void setCurrentFrequency(FrequencyPersistence frequencyPersistence) {
    }

    default public EnsemblePersistence getCurrentEnsemble() {
    }

    default public void setCurrentEnsemble(EnsemblePersistence ensemblePersistence) {
    }

    default public ServicePersistence getCurrentService() {
    }

    default public void setCurrentService(ServicePersistence servicePersistence) {
    }

    default public ComponentPersistence getCurrentComponent() {
    }

    default public void setCurrentComponent(ComponentPersistence componentPersistence) {
    }

    default public EnsemblePersistence getLinkingEnsemble() {
    }

    default public void setLinkingEnsemble(EnsemblePersistence ensemblePersistence) {
    }

    default public ServicePersistence getLinkingService() {
    }

    default public void setLinkingService(ServicePersistence servicePersistence) {
    }

    default public boolean isLBandOptionState() {
    }

    default public void setLBandOptionState(boolean bl) {
    }

    default public boolean isOtherAnnouncementOption() {
    }

    default public void setOtherAnnouncementOption(boolean bl) {
    }

    default public boolean isTrafficAnnouncementOption() {
    }

    default public void setTrafficAnnouncementOption(boolean bl) {
    }

    default public boolean isDabFollowing() {
    }

    default public void setDabFollowing(boolean bl) {
    }

    default public boolean isFmLinking() {
    }

    default public void setFmLinking(boolean bl) {
    }

    default public int getViewMode() {
    }

    default public void setViewMode(int n) {
    }

    default public boolean isLsmSupportsSlideshow() {
    }

    default public void setLsmSupportsSlideshow(boolean bl) {
    }

    default public int getCurrentBand1() {
    }

    default public void setCurrentBand1(int n) {
    }

    default public int getCurrentBand2() {
    }

    default public void setCurrentBand2(int n) {
    }

    default public int getCurrentPresetIndexSelectedByHmi() {
    }

    default public void setCurrentPresetIndexSelectedByHmi(int n) {
    }

    default public int getVisibleBankIndex() {
    }

    default public void setVisibleBankIndex(int n) {
    }

    default public boolean isSoftLinkingOption() {
    }

    default public void setSoftLinkingOption(boolean bl) {
    }

    default public List getDabPresets() {
    }
}

