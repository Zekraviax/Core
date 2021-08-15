package com.cafecraft.core.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import net.minecraft.util.Identifier;

public final class MyComponents implements EntityComponentInitializer, WorldComponentInitializer {
    public static final ComponentKey<IntComponent> MAGIK =
            ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier("core:magik"), IntComponent.class);

    public static final ComponentKey<EnumComponent> DAY =
            ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier("core:day"), EnumComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        // Add the component to every PlayerEntity instance, and copy it on respawn with keepInventory
        registry.registerForPlayers(MAGIK, player -> new RandomIntComponent(), RespawnCopyStrategy.INVENTORY);
    }

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        // Add the component to every World instance
        registry.register(MAGIK, world -> new RandomIntComponent());

        registry.register(DAY, world -> new DayEnumComponent());
    }
}