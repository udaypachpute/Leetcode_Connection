class Solution {

    static void solve(int[] nums, int index, List<Integer> output, List<List<Integer>> ans) {
        //base case
        if (index >= nums.length) {
            //subsequence ready hai -> output wali list me
            //iss subsequence ko store krna h , ans me
            ans.add(new ArrayList<>(output));
            return;

        }

        //include-exclude pattern
        int currValue = nums[index];
        //include
        output.add(currValue);
        solve(nums, index + 1, output, ans);
        //Backtracking step
        output.remove(output.size() - 1);

        //exclude
        solve(nums, index + 1, output, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        solve(nums, index, output, ans);
        return ans;
    }
}