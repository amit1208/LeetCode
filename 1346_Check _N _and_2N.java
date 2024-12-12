class Solution {
    public boolean checkIfExist(int[] arr) {
        for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr.length;j++){
            if(arr[i]==2*arr[j] && i!=j){
                return true;
            }
        }
        }
        return false;
    }
}




// class Solution {
//     public boolean checkIfExist(int[] arr) {
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int a: arr){
//             map.put(a,0);
//             if(map.containsKey(2*a) || (a % 2 == 0 && map.containsKey(a/2))){
//                 return true;
//             }
//         }
//         return false;
// }}
