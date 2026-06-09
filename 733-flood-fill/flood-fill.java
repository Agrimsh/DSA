class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        int orignalclr=image[sr][sc];
        if(orignalclr==newcolor){ // both color are same
            return image;
        }
        dfs(image,sr,sc,orignalclr,newcolor);
        return image;
        
    }
    public void dfs(int image[][],int row,int col,int orignalclr,int newcolor){
        if(row<0||col<0||row>=image.length||col>=image[0].length){
            return;
        }
        if(image[row][col]!=orignalclr){  //color is somthing else like 0 so dont do anything
            return;
        }
        image[row][col]=newcolor; //color with newcolor

        dfs(image,row-1,col,orignalclr,newcolor);   //dfs on all row and col
        dfs(image,row+1,col,orignalclr,newcolor);
        dfs(image,row,col-1,orignalclr,newcolor);
        dfs(image,row,col+1,orignalclr,newcolor);
    }
}