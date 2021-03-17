public class Main {

    public static void main(String[] args) {
        String[][] arr  = {
                {"1","2","3","3"},
                {"10","-8","6","3"},
                {"1","45","5"},
                {"3","укк","3","3"},
        };
        try {
            try {
                int result = array(arr);
                System.out.println("Результат: "+ result);
            }catch (MyArraySizeException e)
            {
                System.out.println("Другой размер массива!");
            }
        }catch (MyArrayDataException e)
        {
            System.out.println("Не правильное значение массива!");
            System.out.println("Ошибка в " + e.i+" строке, "+"в "+e.j+" индексе!");
        }


    }
    public static int array(String[][] arr) throws MyArraySizeException,MyArrayDataException
    {

        int count = 0;
        if(arr.length !=4)
        {
            throw new MyArraySizeException();
        }
        for (int i = 0; i<arr.length;i++)
        {
            if (arr[i].length !=4)
            {
                throw new MyArraySizeException();
            }
            for (int j = 0;j<arr[i].length;j++)
            {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch(NumberFormatException e)
                {
                    throw new MyArrayDataException(i,j);
                }

            }
        }

        return count;
    }
}
