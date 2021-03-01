public class Employee
{
    String fio;
    String post;
    String email;
    String phone;
    double salary;
    int age;
    Employee ( String fio, String post,String email, String phone,double salary,int age)
    {
        this.fio=fio;
        this.post= post;
        this.email=email;
        this.phone=phone;
        this.salary=salary;
        this.age=age;

    }

    void show()
    {
        System.out.println(fio+ " "+ post+ " "+ email+ " "+ phone+" "+ salary+ " "+ age+ " ");

    }
    int getAge()
    {
        return age;
    }
}
