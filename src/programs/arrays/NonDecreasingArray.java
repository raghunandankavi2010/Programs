package programs.arrays;


public class NonDecreasingArray {

    public static void main(String[] args) {
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        int[] arr = {4,2,1};
        System.out.println(nonDecreasingArray.checkPossibility(arr));
    }

    private boolean checkPossibility(int[] nums) {
        int count = 0;
        int index =-1;
        for ( int i = 0; i< nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                index = i;
                count++;
            }
        }
        if(count > 1)
            return false;
        if(count ==1){
            if(index+1 == nums.length-1 || index == 0)
                return true;

            return  (nums[index]<nums[index+2] || nums[index-1]<nums[index+1]);
        }
        return  true;
    }
}
