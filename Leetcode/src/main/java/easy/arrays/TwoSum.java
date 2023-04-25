package easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    static int test1[] = {2,7,11,15}; // Expected Outcome: [0,1]
    static int tg1=9;

    static int test2[] = {3,2,4}; // Expected Outcome: [1,2]
    static int tg2=6;

    static int test3[]={3,3}; // Expected Outcome: [0,1]
    static int tg3=6;
    public static void main(String[] args) {



        checkBruteForceApproach();
        checkTwoPassApproach();
        checkSinglePassApproach();



    }


    /**
     * Brute force appraoch
     * @return
     */
    public int[] twoSumBasic(int nums[], int target)
    {
        for (int i = 0; i < nums.length ; i++)
        {
            for (int j = 1; j < nums.length ; j++)
            {
                if(nums[i] + nums[j]==target)
                {
                   return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    /**
     * Two Pass Hash Approach
     * @param nums
     * @param target
     * @return
     */
    public int[] twoPassHash(int[] nums, int target)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++)
        {
            map.put(nums[i],i);

        }

        for(int i=0;i<nums.length;i++)
        {
            int complement = target - nums[i];

            if(map.containsKey(complement) & map.get(complement)!=i)
            {
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }


    public int[] singlePassHash(int[] nums, int target)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++)
        {
            int complement = target - nums[i];
            if(map.containsKey(complement))
            {
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);

        }
        return null;
    }


    //Checks

    private static void checkBruteForceApproach()
    {
        System.out.println("*** Brute force approach check started ***");
        TwoSum  twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSumBasic(test1,tg1)));
        System.out.println(Arrays.toString(twoSum.twoSumBasic(test2,tg2)));
        System.out.println(Arrays.toString(twoSum.twoSumBasic(test3,tg3)));
        System.out.println("*** Brute force approach check ended ***");
    }

    private static void checkTwoPassApproach() {
        System.out.println("*** Two Pass  approach check started ***");
        TwoSum  twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoPassHash(test1, tg1)));
        System.out.println(Arrays.toString(twoSum.twoPassHash(test2, tg2)));
        System.out.println(Arrays.toString(twoSum.twoPassHash(test3, tg3)));
        System.out.println("*** Two Pass  approach check ended ***");
    }

    private static void checkSinglePassApproach() {
        System.out.println("*** Single Pass  approach check started ***");
        TwoSum  twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.singlePassHash(test1, tg1)));
        System.out.println(Arrays.toString(twoSum.singlePassHash(test2, tg2)));
        System.out.println(Arrays.toString(twoSum.singlePassHash(test3, tg3)));
        System.out.println("*** Single Pass  approach check ended ***");
    }

}
