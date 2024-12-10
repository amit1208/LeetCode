class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat=new int[n][n]; 
int count=1;
int top=0;
int right=n-1;
int bottom=n-1;
int left=0;

    while(left<=right && top<=bottom){

        for(int i=left;i<=right;i++){
                mat[top][i]=count++;
            }
        top++;
        if(top<=bottom){
        for(int i=top;i<=bottom;i++){
                mat[i][right]=count++;
            }}
        right--;
        
        if(left<=right){
        for(int i=right;i>=left;i--){
                mat[bottom][i]=count++;
            }
        }
        bottom--;

        if(top<=bottom){
        for(int i=bottom;i>=top;i--){
                mat[i][left]=count++;
            }
        }
        left++;
        }
    
    return mat;
    }
    }

