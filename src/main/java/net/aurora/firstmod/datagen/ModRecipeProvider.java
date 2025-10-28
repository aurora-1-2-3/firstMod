package net.aurora.firstmod.datagen;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.blocks.ModBlocks;
import net.aurora.firstmod.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;


import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> GALLIUM_SMELTABLES = List.of
                (ModItems.RAW_GALLIUM,
                ModBlocks.DEEPSLATE_GALLIUM_ORE,
                ModBlocks.GALLIUM_ORE);

        List<ItemLike> AXOLOTL_COOKED = List.of
                (Items.AXOLOTL_SPAWN_EGG
                );

        List<ItemLike> GALLIUM_ROD = List.of(ModBlocks.GALLIUM_ROD_BLOCK);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GALLIUM_BLOCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.GALLIUM_INGOT.get())
                .unlockedBy("has_gallium_ingot", has(ModItems.GALLIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GALLIUM_BALL.get(), 8)
                .pattern("GGG")
                .pattern("GSG")
                .pattern("GGG")
                .define('G', ModItems.GALLIUM_INGOT.get())
                .define( 'S', Items.SLIME_BALL)
                .unlockedBy("has_gallium_ingot", has(ModItems.RAW_GALLIUM)).save(recipeOutput);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GALLIUM_ROD_BLOCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.GALLIUM_ROD.get())
                .unlockedBy("has_gallium_ingot", has(ModItems.GALLIUM_ROD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_BOIIUM_BLOCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.RAW_BOIIUM.get())
                .unlockedBy("has_raw_boiium", has(ModItems.RAW_BOIIUM)).save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GALLIUM_ROD.get())
                .pattern("G")
                .pattern("G")
                .pattern("G")
                .define('G', ModItems.GALLIUM_INGOT.get())
                .unlockedBy("has_gallium_ingot", has(ModItems.GALLIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GALLIUM_BREAD.get(), 3)
                .pattern("GGG")
                .define('G', ModItems.GALLIUM_WHEAT.get())
                .unlockedBy("has_gallium_wheat", has(ModItems.GALLIUM_WHEAT_SEEDS)).save(recipeOutput);




        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GALLIUM_INGOT.get(), 9)
                .requires(ModBlocks.GALLIUM_BLOCK)
                .unlockedBy("has_gallium_block", has(ModBlocks.GALLIUM_BLOCK))
                .save(recipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.NETHERITE_BLOCK, 9)
                .requires(ModBlocks.GALLIUM_ROD_BLOCK)
                .unlockedBy("has_gallium_rod_block", has(ModBlocks.GALLIUM_ROD_BLOCK))
                .save(recipeOutput);


        stairBuilder(ModBlocks.GALLIUM_STAIRS.get(), Ingredient.of(ModItems.GALLIUM_INGOT)).group("gallium")
                .unlockedBy("has_gallium_ingot", has(ModItems.GALLIUM_INGOT)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GALLIUM_SLAB.get(), ModItems.GALLIUM_INGOT.get());

        buttonBuilder(ModBlocks.GALLIUM_BUTTON.get(), Ingredient.of(ModItems.GALLIUM_INGOT.get())).group("gallium")
                .unlockedBy("has_gallium_ingot", has(ModItems.GALLIUM_INGOT.get())).save(recipeOutput);

        pressurePlate(recipeOutput, ModBlocks.GALLIUM_PRESSURE_PLATE.get(), ModItems.GALLIUM_INGOT.get());

        fenceBuilder(ModBlocks.GALLIUM_FENCE.get(), Ingredient.of(ModItems.GALLIUM_INGOT.get())).group("gallium")
                .unlockedBy("has_gallium_ingot", has(ModItems.GALLIUM_INGOT.get())).save(recipeOutput);

        fenceGateBuilder(ModBlocks.GALLIUM_FENCE_GATE.get(), Ingredient.of(ModItems.GALLIUM_INGOT.get())).group("gallium")
                .unlockedBy("has_gallium_ingot", has(ModItems.GALLIUM_INGOT.get())).save(recipeOutput);

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GALLIUM_WALL.get(), ModItems.GALLIUM_INGOT.get());

        doorBuilder(ModBlocks.GALLIUM_DOOR.get(), Ingredient.of(ModItems.GALLIUM_INGOT.get())).group("gallium")
                .unlockedBy("has_gallium_ingot", has(ModItems.GALLIUM_INGOT.get())).save(recipeOutput);

        trapdoorBuilder(ModBlocks.GALLIUM_TRAP_DOOR.get(), Ingredient.of(ModItems.GALLIUM_INGOT.get())).group("gallium")
                .unlockedBy("has_gallium_ingot", has(ModItems.GALLIUM_INGOT.get())).save(recipeOutput);











        // COOKING

        oreSmelting(recipeOutput, GALLIUM_SMELTABLES, RecipeCategory.MISC, ModItems.GALLIUM_INGOT.get(), 0.5f, 200, "gallium");
        oreBlasting(recipeOutput, GALLIUM_SMELTABLES, RecipeCategory.MISC, ModItems.GALLIUM_INGOT.get(), 0.5f, 100, "gallium");
        oreBlasting(recipeOutput, GALLIUM_ROD, RecipeCategory.MISC, ModItems.GALLIUM_ROD.get(), 0.5f, 100, "gallium");
        foodSmoking(recipeOutput, AXOLOTL_COOKED, RecipeCategory.MISC, ModItems.COOKED_AXOLOTL_EGG.get(), 0.5f, 100, "gallium");










    }



    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void foodSmoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }



    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, FirstMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
