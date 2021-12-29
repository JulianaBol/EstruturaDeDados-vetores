package estruturaDados;
import java.util.Random;

public class Edados {
	int n, escolha, tot = 0, vetor[];
	int maior, menor, valor;
	
	public Edados(int num) {
		vetor = new int[num];
		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = 0;
		}		
	}
	
	public void abrirMenu() {
		System.out.println("    Aplicação com vetores ");
		System.out.println("\n   --------------------------");
		System.out.println("       MENU DE OPÇÕES:");
		System.out.println("   --------------------------");
		System.out.println("   [ 1] - Povoar o vetor");
		System.out.println("   [ 2] - Povoar o vetor em ordem crescente");
		System.out.println("   [ 3] - Informar o total de elementos no vetor");
		System.out.println("   [ 4] - Informar maior e menor valores no vetor");
		System.out.println("   [ 5] - Listar vetor");	
		System.out.println("   [11] - inserir um valor em determinada posição");
		System.out.println("   [12] - Apagar um valor");
		System.out.println("   [13] - Apagar um valor informando a posição");
		System.out.println("   [21] - Consultar um valor com busca sequencial");	
		System.out.println("   [22] - Consultar um valor com busca binária");	
		System.out.println("   [31] - Ordenar o vetor com Bubblesort");	
		System.out.println("   [32] - Ordenar o vetor com Insertsort");	
		System.out.println("   [33] - Ordenar o vetor com Selectionsort");
		System.out.println("   [34] - Consultar o valor em determinada posição");
		System.out.println("   [35] - Informa o tamanho do vetor");
		System.out.println("   [ 0] - Encerrar o programa ");
		System.out.println("  \n   Digite a sua opção: ");		
	}	
	
	public void escolhaMenu(int n) {
		escolha = n;
	}
	
	public void aleatorios() {
		Random num = new Random(654321);
		for(int i = 0; i < vetor.length; i++) {
			if(vetor[i] == 0) {
				vetor[i] = num.nextInt(1 + 1000);
				tot++;
			}else {
				continue;
			}
		}		
	}
	
	public void BubbleSort() {
		for(int ultimo = vetor.length -1; ultimo > 0; ultimo--) {
			for(int i = 0; i < ultimo; i++) {
				if(vetor[i] > vetor[i+1]) {
					troca(vetor, i, i+1);
				}
			}
		}		
	}		
	public static void troca(int v[], int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}
	
	public void maior () {
		maior = vetor[0];
		for(int i = 1; i < vetor.length; i++) {
			if(vetor[i] > maior) {
				maior = vetor[i];
			}
		}		
	}			
	
	public void menor () {
		for(int vet:vetor) {
			if(vet == 0) {
				continue;
			}else {
				menor = vet;
				break;
			}
		}
		for(int i = 0; i < vetor.length; i++) {
			if(vetor[i] < menor && vetor[i] != 0) {
				menor = vetor[i];
			}
		}
		
	}
	
	public void listar() {
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(" vetor "+"["+ i +"]"+ " => "+ vetor[i]);			
		}
	
	}
	
	public void inserirNaPosicao(int pos, int num) {
		for(int i = 0; i < vetor.length; i++) {
			if(i == pos) {
				if(vetor[i] == 0) {
					vetor[i] = num;
					System.out.println("O valor "+ num+ " foi incluído na posição "+ i+"\n");
					tot++;
				}else {
					vetor[i] = num;
					System.out.println("O valor "+ num+ " foi incluído na posição "+ i+"\n");
				}
			}
		}
	}
	
	public void apagar(int num) {
		boolean existe = false;
		for (int i = 0; i < vetor.length; i++) {			
			if(vetor[i] == num) {
				existe = true;
				System.out.println("O valor "+ vetor[i]+ " foi excluído da posição "+ i+"\n");	
				vetor[i]=0;
				tot--;
			}			
		}
		if(existe == false) {
			System.out.println("Valor não encontrado");
		}								
	}
	
	public void apagarDaPosicao(int pos) {
		for (int i = 0; i < vetor.length; i++) {			
			if(i == pos && vetor[i]==0) {
				System.out.println("Posição vazia! ");
			}else if(i == pos && vetor[i]!=0) {
				System.out.println("O valor "+ vetor[i]+ " foi excluído da posição "+ i+"\n");	
				vetor[i]=0;
				tot--;
			}
		}									
	}	
	
	public void buscaSequencial(int num) {
		boolean vazio = true;
	
		for(int i=0; i<vetor.length; i++) {
			if (vetor[i] == num) {						
				System.out.println("O valor "+ vetor[i]+ " está na posição "+ i);
				vazio = false;
				break;
			}
		}
		if (vazio== true) {
			System.out.println("Valor não encontrado! ");
		}
	}
	
	public static int buscaBinariaRecursiva(int v[], int num) {
		return buscaRecursiva(v, num, 0, v.length - 1);		
	}
	
	public static int buscaRecursiva(int v[], int num, int menor, int maior) {
		int meio = (menor + maior) / 2;
		if (menor > maior) {
			return -1;
		}
		if(v[meio] == num) {
			return meio;
		}
		if(v[meio] < num) {
			return buscaRecursiva(v, num, meio + 1, maior);
		}
		else {
			return buscaRecursiva( v, num, menor, meio - 1);
		}		
	}
	
	public static void insertionSort(int v[]) {
		int aux, j;
		for(int i = 1; i < v.length; i++) {
			aux = v[i];
			j = i - 1;
			while((j >= 0) && v[j] > aux) {
				v[j + 1] = v[j];
				j--;
			}
			v[j + 1] = aux;
		}
	}
	
	public static void selectionSort(int v[]) {
		for(int i = 0; i < v.length; i++) {
			int menor = i;
			for(int j = i+1; j < v.length; j++) {
				if(v[j] < v[menor]) {
					menor = j;
				}
			}
			troca(v, i, menor);			
		}		
	}
	
	public boolean retornaValor (int n) {
		boolean contem = false;
		for(int i = 0; i < vetor.length; i++) {
			if(i == n) {
				if(vetor[i] != 0) {
				valor = vetor[i];
				contem = true;
				}
			}else {
				continue;
			}			
		}
		return contem;
	}
	
	public int informaTamanho() {
		return vetor.length;
	}
	
	public int informaOcupados() {
		return tot;
	}
	
}
