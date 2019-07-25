mods.hac.Crusher.addRecipe(<minecraft:apple> * 2, <minecraft:apple>, <minecraft:apple>, null, 1, 1, 0, <minecraft:apple>, null);
mods.hac.Crusher.addRecipe(<ore:blockGlass> * 32, <minecraft:apple>, <minecraft:apple>, null, 1, 1, 0, <minecraft:apple>, null);

mods.hac.Mill.addRecipe(<ore:blockGlass>, <minecraft:apple>, <minecraft:apple>, 1.0);
mods.hac.Mill.addRecipe(<ore:bone>, <minecraft:apple>, <minecraft:apple>, 1.0);

mods.hac.Spinning.addRecipe(<minecraft:apple> * 2,1,<minecraft:apple> * 20);

var fluid = mods.hac.FluidProcess.newRecipe();
fluid.addInput("blockGlass");
fluid.setOutput(<minecraft:stone>);
fluid.addHeatTier(-5);
fluid.addHeatTier(-4);
fluid.addHeatTier(-3);
fluid.addHeatTier(-2);
fluid.addAirflow(0);
fluid.addAirflow(2);
fluid.setSecondary(<minecraft:gold_ore>);
fluid.setChance(1);
fluid.ignite();

var react = mods.hac.Reactor.newRecipe();
react.addInput("dustRedstone");
react.setOutput(<minecraft:glass>);
react.setFluidI1(<liquid:water>);
react.setCatalyst([<minecraft:iron_ore>, <minecraft:gold_ore>]);
react.ignite();