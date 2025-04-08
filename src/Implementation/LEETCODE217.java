package Implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LEETCODE217 {
    public boolean containsDuplicate(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            arr.add(nums[i]);
        }

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        return arr.size() != set.size();
    }
}
