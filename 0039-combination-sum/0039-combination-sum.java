class Solution {

    static void solve(int[] candidates, int target, int index,
    List<List<Integer>> ans, List<Integer> output ) {
    //base case
        if(target == 0){
        //target 0.ka mtlb, mere outoput walilist me ek answe
        //chuka ·h ·,
        //then store this ans into ans wali list h
            ans.add(new ArrayList(output));
            return;
        }

        if(index >= candidates.length) {
            return;
        }

        if(target < 0) {
            return ;
        }

        output.add(candidates[index]);
        solve(candidates, target-candidates[index], index, ans, output);
        //backtrack wala step
        output.remove(output.size()-1);

        //exclude
        solve(candidates, target, index+1, ans, output);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        solve(candidates, target, index, ans, output);
        return ans;
    }
}