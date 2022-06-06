package com.daimao.block;

import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class PointToOneself extends HorizontalBlockBase {

    private static final VoxelShape SHAPE;

    static {
        SHAPE = createShape("/assets/daimao/models/block/point_to_oneself.json");
//
//        VoxelShape shape1 = Block.makeCuboidShape(0, 0, 0, 16, 1, 16);
//        VoxelShape shape2 = Block.makeCuboidShape(7, 1, 1, 9, 2, 16);
//        VoxelShape shape3 = Block.makeCuboidShape(5, 1, 12, 6, 2, 14);
//        VoxelShape shape4 = Block.makeCuboidShape(4, 1, 11, 5, 2, 13);
//        VoxelShape shape5 = Block.makeCuboidShape(3, 1, 10, 4, 2, 12);
//        VoxelShape shape6 = Block.makeCuboidShape(6, 1, 13, 7, 2, 15);
//        VoxelShape shape7 = Block.makeCuboidShape(9, 1, 13, 10, 2, 15);
//        VoxelShape shape8 = Block.makeCuboidShape(10, 1, 12, 11, 2, 14);
//        VoxelShape shape9 = Block.makeCuboidShape(11, 1, 11, 12, 2, 13);
//        VoxelShape shape10 = Block.makeCuboidShape(12, 1, 10, 13, 2, 12);
//
//        SHAPE = VoxelShapes.or(shape1, shape2, shape3, shape4, shape5, shape6, shape7, shape8, shape9, shape10);
    }

    public PointToOneself(Properties properties) {
        super(properties);
        runCalculation(SHAPE);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES.get(this).get(state.get(BlockStateProperties.HORIZONTAL_FACING));
    }

}
