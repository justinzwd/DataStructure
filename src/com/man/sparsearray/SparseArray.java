package com.man.sparsearray;

public class SparseArray
{
    public static void main(String[] args)
    {
        //创建原始数组
        int chessArr1[][] = new int[11][11];
        //给特殊值赋值，其他默认值为0
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][7] = 8;
        //利用增强for来输出原始二维数组
        System.out.println("输出原始二维数组");
        for (int[] row : chessArr1)
        {
            for (int item : row)
            {
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }

        //将原始二维数组转换为稀疏数组
        //1.遍历原始二维数组，统计出所有非0的数据个数，以便于我们建立后来的稀疏数组的size

        int sum = 0;    //非0数据个数值
        for (int i = 0; i < chessArr1.length; i++)
        {
            for (int j = 0; j < chessArr1[0].length; j++)
            {
                if(chessArr1[i][j] != 0)
                {
                    sum++;
                }
            }
        }

        System.out.println("sum=" + sum);

        //2.填充稀疏数组
        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1[0].length;
        sparseArray[0][2] = sum;

        int count = 0;  //第几个非0数
        for (int i = 0; i < chessArr1.length; i++)
        {
            for (int j = 0; j < chessArr1[0].length; j++)
            {
                if(chessArr1[i][j] != 0)
                {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("输出稀疏数据");
        for (int i = 0; i < sparseArray.length; i++)
        {
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }

        //将稀疏数组重新恢复成原始数组
        int[][] chessArr2 = new int[sparseArray[0][1]][sparseArray[0][1]];
        //从稀疏数组的第二行开始遍历，因为第一行存储的是原始数组的大小
        for(int i = 1; i < sparseArray.length; i++)
        {
            //因为sparseArray从第二行开始，每行的第一个值是行，第二个值是列，第三个值是原始值
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //输出恢复成的原始数组
        System.out.println("重新恢复的二维数组");
        for (int i = 0; i < chessArr2.length; i++)
        {
            for (int j = 0; j <chessArr2[0].length; j++)
            {
                System.out.printf("%d\t",chessArr2[i][j]);
            }
            System.out.println("\n");
        }
    }
}
