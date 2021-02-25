public class Main {

    public static void main(String[] args) {

	Employee[] arr= new Employee[5];
	arr[0]= new Employee("Иванов Денис","Инженер1","sdfwreg@mail.ru","89261112233",30000,30);
	arr[1]= new Employee("Иванов Иван","Инженер2","123sdf@mail.ru","892611134546",31000,19);
	arr[2]= new Employee("Иванов Сергей","Инженер3","ytrewq@mail.ru","89261145657",22000,28);
	arr[3]= new Employee("Иванов Михаил","Инженер4","qwerty@mail.ru","89261112123",36000,45);
	arr[4]= new Employee("Иванов Эдуард","Инженер5","sdfaq1@mail.ru","89261111111",50000,55);

	for(Employee A : arr)
	{
		if(A.getAge()>40) A.show();

	}


    }
}
