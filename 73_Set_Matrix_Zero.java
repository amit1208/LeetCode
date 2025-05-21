class Solution {
    public void setZeroes(int[][] matrix) {

      int[] arrow=new int[matrix.length];
      int[] arcol=new int[matrix[0].length];
    
      for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]==0){
                arrow[i]=1;
                arcol[j]=1;
            }
      }
    }
      for(int i=0;i<matrix.length;i++){
            if(arrow[i]==1){
               for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=0;
               }
            }  
      }
      for(int j=0;j<matrix[0].length;j++){
            if(arcol[j]==1){
               for(int i=0;i<matrix.length;i++){
                matrix[i][j]=0;
               }
            }  
      }
    }
}