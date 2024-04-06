package com.codedecide.leetcode.utils;

import com.codedecide.leetcode.tree.TreeNode;
import com.codedecide.leetcode.util.TreeNodeUtils;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author geckostroll
 * @version TreeNodeUtilsTest.java 2024年04月05日
 */
public class TreeNodeUtilsTest {

    @Test
    public void testBuildFromIntList() {
        List<Integer> valList = Lists.newArrayList(1, 2, 3, null, 5, null, 4);
        TreeNode node = TreeNodeUtils.buildFromIntList(valList);
        Assert.assertEquals(node.val, 1);
    }
}
