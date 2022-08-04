package moreberries;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;

public class BlockBerryBush extends SweetBerryBushBlock {

	public Item item;
	private static final VoxelShape SMALL_SHAPE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D);
	private static final VoxelShape LARGE_SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);

	public BlockBerryBush(Item item) {
		super(Properties.create(Material.PLANTS)
				.tickRandomly()
				.doesNotBlockMovement()
				.sound(SoundType.SWEET_BERRY_BUSH)
				.notSolid());
		this.item = item;
	}

	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(this);
	}

	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		int int_1 = (Integer) state.get(AGE);
		boolean boolean_1 = int_1 == 3;
		if (!boolean_1 && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
			return ActionResultType.PASS;
		} else if (int_1 > 1) {
			int int_2 = 1 + worldIn.rand.nextInt(2);
			spawnAsEntity(worldIn, pos, new ItemStack(item, int_2 + (boolean_1 ? 1 : 0)));
			worldIn.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH,
					SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
			worldIn.setBlockState(pos, (BlockState) state.with(AGE, 1), 2);
			return ActionResultType.SUCCESS;
		} else {
			return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
		}
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
			 {
		if (state.get(AGE) == 0) {
			return SMALL_SHAPE;
		} else {
			return LARGE_SHAPE;
		}
	}
	}
	public void onPlantGrow(BlockState state, IWorld world, BlockPos pos, BlockPos source)
	{
		if (state.isIn(Tags.Blocks.DIRT))
			world.setBlockState(pos, Blocks.DIRT.getDefaultState(), 2);
	
	}

}
