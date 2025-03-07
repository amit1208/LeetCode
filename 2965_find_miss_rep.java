class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] arr=new int[2];

        int n=grid.length;

        Boolean a[]=new Boolean[n*n + 1];
        Arrays.fill(a,false);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[grid[i][j]]==false){
                a[grid[i][j]]=true;
                }
                else{
                    arr[0]=grid[i][j];
                }
                    
            }
        }
        for(int i=1;i<=n*n;i++){
            if(a[i]==false){
                arr[1]=i;
            }
        }
        return arr;
    }
}