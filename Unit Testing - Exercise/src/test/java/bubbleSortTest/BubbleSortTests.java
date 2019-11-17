package bubbleSortTest;

import org.junit.Assert;
import org.junit.Test;
import p04_BubbleSortTest.Bubble;

public class BubbleSortTests {
    private static final int[] nums = {5, 47, 69, 58, 69, 71, 56,-88};
    private static final int[] sortedNums = {-88,5, 47, 56, 58, 69, 69, 71};

    @Test
    public void sortedCorrectlyNumsOfAlgorithm() {
        Bubble.sort(nums);
        Assert.assertArrayEquals(nums, sortedNums);
    }
    @Test
    public void untouchedSortedCollectionAfterSortAlgorithm(){
        Bubble.sort(sortedNums);
        Assert.assertArrayEquals(sortedNums,sortedNums);
    }
}
