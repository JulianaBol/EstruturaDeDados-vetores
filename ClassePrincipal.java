package estruturaDados;
import java.util.Scanner;

public class ClassePrincipal {
	
	public static int numInt(int n){
		if(n <= 0) {
			System.out.println("Digite somente numeros inteiros positivos!\n");
		}		
		return n;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int op, pos, num;
		
		Edados vetor = new Edados(50);
		vetor.abrirMenu();
		vetor.escolhaMenu(input.nextInt());	
		
		while(vetor.escolha != 0) {
			if(vetor.escolha == 1) {
				vetor.aleatorios();//ver questao dos numeros repetidos				
			}
			if(vetor.escolha == 2) {
				vetor.aleatorios();
				vetor.BubbleSort();				
			}
			if(vetor.escolha == 3) {
				System.out.println("O vetor tem "+vetor.informaOcupados()+" elementos.\n");				
			}
			if(vetor.escolha == 4) {
				vetor.maior();
				vetor.menor();				
				if(vetor.maior != vetor.menor) {
					System.out.println("O maior valor é "+vetor.maior+" e o menor valor é "+ vetor.menor+"\n");				
				}else if (vetor.tot == 1) {
					System.out.println("O vetor tem somente 1 valor armazenado!\n");
				}else if (vetor.tot == 0) {
					System.out.println("O vetor está vazio!\n");
				}				
			}
			if(vetor.escolha == 5) {
				vetor.listar();
			}
			if(vetor.escolha == 11) {
				System.out.println("Digite a posição deseja incluir:"); pos = input.nextInt();
				System.out.println("Digite o valor que deseja incluir:"); 
				numInt(num = input.nextInt());	
				if(num > 0) {
					vetor.inserirNaPosicao(pos, num);
				}else {
					continue;
				}
			}
			if(vetor.escolha == 12) {
				System.out.println("Digite o valor que deseja excluir:"); 	
				vetor.apagar(num = input.nextInt());
			}
			if(vetor.escolha == 13) {
				System.out.println("Digite a posição deseja excluir:");
				vetor.apagarDaPosicao(pos = input.nextInt());
			}
			if(vetor.escolha == 21) {
				System.out.println("Digite o valor que deseja consultar:"); 
				vetor.buscaSequencial(num=input.nextInt());
			}
			if(vetor.escolha == 22) {				
				vetor.BubbleSort();
				System.out.println("Qual valor deseja consultar?");
				int resultado = vetor.buscaBinariaRecursiva(vetor.vetor,num = input.nextInt());				
				if(resultado == -1) {
					System.out.println("Valor não encontrado!\n ");
				}else {
					System.out.println("O valor "+num+" está na posição "+ resultado+"\n");
				}
			}
			if(vetor.escolha == 31) {
				vetor.BubbleSort();
			}
			if(vetor.escolha == 32) {
				vetor.insertionSort(vetor.vetor);
			}
			if(vetor.escolha == 33) {
				vetor.selectionSort(vetor.vetor);
			}
			if(vetor.escolha == 34) {
				System.out.println("Digite a posição deseja consultar:");
				vetor.retornaValor(pos = input.nextInt());
				if(vetor.retornaValor(pos)==true) {
					System.out.println("O valor "+vetor.valor+" está na posição "+pos+"\n");					
				}else {
					System.out.println("A posição "+pos+" está vazia!\n ");
				}
			}
			if(vetor.escolha == 35) {
				System.out.println(" O vetor tem "+vetor.informaTamanho()+" posições\n");
			}
			vetor.abrirMenu();
			vetor.escolhaMenu(input.nextInt());
		}
		System.out.println("Aplicação com vetores finalizada!");
	}

}
