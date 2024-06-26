package xyz.amymialee.noenchantcap.platform;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.GameRules;
import xyz.amymialee.noenchantcap.NoEnchantCapFabric;
import xyz.amymialee.noenchantcap.platform.services.IPlatformHelper;

/**
 * Handles Fabric exclusive code.
 */
public class FabricPlatformHelper implements IPlatformHelper {
    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public <T extends GameRules.Rule<T>> GameRules.Key<T> registerGamerule(String name, GameRules.Type<T> type) {
        return GameRuleRegistry.register(name, NoEnchantCapFabric.ENCHANT_CAP_GAMERULES, type);
    }

    @Override
    public GameRules.Type<GameRules.BooleanRule> createBooleanValue(boolean defaultValue) {
        return GameRuleFactory.createBooleanRule(defaultValue);
    }

    @Override
    public GameRules.Type<GameRules.IntRule> createIntegerValue(int defaultValue) {
        return GameRuleFactory.createIntRule(defaultValue);
    }
}