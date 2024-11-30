package Application;

import java.util.List;
import java.util.ArrayList;
import Employes.Employe;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Employe> list = new ArrayList<>();

        System.out.println("Quantidade de empregados: ");
        int quantidade = sc.nextInt();

        int i;

        for(i = 0; i<quantidade; i++) {
            System.out.println("digite o id do empregado: ");
            int id = sc.nextInt();
            while (VerificaId(list, id)) {
                System.out.println("Id ja registrado, digite novamente: ");
                id = sc.nextInt();
            }

            sc.nextLine();
            System.out.println("digite o nome do empregado: ");
            String nome = sc.next();

            System.out.println("digite o salario do empregado: ");
            double salario = sc.nextDouble();

            list.add(new Employe(id, nome, salario));

        }

        System.out.println("Digite o id do empregado que tera o salario aumentado");
        int idEmp = sc.nextInt();
//        list.stream().filter(x -> x.getId() == idEmp).findFirst().ifPresent(x -> {
//            System.out.println("digite a porcentagem de acrescimo:");
//            float porcentagem = 1 + (sc.nextFloat()/100);
//            x.setSalario(x.getSalario()*porcentagem);
//        });
        int count = 0;
        for(Employe emp: list ){
            if(emp.getId() == idEmp){
                count = 1;
                System.out.println("digite a porcentagem de acrescimo:");
                double porcentagem = 1 + (sc.nextDouble()/100);
                emp.setSalario(emp.getSalario()*porcentagem);
                break;
            }
        }
        if(count == 0){
            System.out.println("Id não encontrado");
        }
        for(i = 0; i<list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        sc.close();
    }
    public static boolean VerificaId(List<Employe> list, int id){
        Employe emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}