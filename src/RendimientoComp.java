import java.util.Arrays;

public class RendimientoComp {
    int arreglo[] = new int[1000];

    public static void main(String[] args) {
        Insercion();
        QuickSort();
        Seleccion();
    }

    public static void Insercion() {
        final long START = System.nanoTime(); // Inicia el contador
        RendimientoComp rendimientoComp = new RendimientoComp();
        System.out.println("\nMetodo Insercion");
        Arreglo(rendimientoComp.arreglo);
        RenInsercion(rendimientoComp.arreglo);
        System.out.println(Arrays.toString(rendimientoComp.arreglo));
        final long END = System.nanoTime();
        System.out.println("Time taken : " + ((END - START) / 1e+9) + " seconds"); // FIn contador
    }

    public static void RenInsercion(int num[]) {
        int i, j, act, cont = 0;
        for (i = 1; i < num.length; i += 1) {
            act = num[i];
            for (j = i; j > 0 && num[j - 1] > act; j -= 1) {
                if (num[j - 1] > act) {
                    cont = cont + 1;
                }
                num[j] = num[j - 1];
            }
            num[j] = act;
        }
        System.out.println("Iteraciones: " + cont);
    }

    public static void QuickSort() {
        final long START = System.nanoTime(); // Inicia el contador
        RendimientoComp rendimientoComp = new RendimientoComp();
        System.out.println("\nMetodo QuickSort");
        Arreglo(rendimientoComp.arreglo);
        RenQuicksort(rendimientoComp.arreglo, 0, rendimientoComp.arreglo.length - 1);
        System.out.println(Arrays.toString(rendimientoComp.arreglo));
        final long END = System.nanoTime();
        System.out.println("Time taken : " + ((END - START) / 1e+9) + " seconds"); // FIn contador
    }

    public static void RenQuicksort(int num[], int izq, int der) {
        int pivote = num[izq], i = izq, j = der, aux, cont = 0;
        while (i < j) {
            while (num[i] <= pivote && i < j)
                i += 1;
            while (num[j] > pivote)
                j -= 1;
            if (i < j) {
                aux = num[i];
                num[i] = num[j];
                num[j] = aux;
                cont += 1;
            }
        }
        num[izq] = num[j];
        num[j] = pivote;
        if (izq < j - 1) {
            RenQuicksort(num, izq, j - 1);
            cont += 1;
        }
        if (j + 1 < der) {
            RenQuicksort(num, j + 1, der);
            cont += 1;
        }
        if (izq == 0 && der == (num.length - 1)) {
            System.out.println("Iteraciones: " + cont);
        }
    }

    public static void Seleccion() {
        final long START = System.nanoTime(); // Inicia el contador
        RendimientoComp rendimientoComp = new RendimientoComp();
        System.out.println("\nMetodo Seleccion");
        Arreglo(rendimientoComp.arreglo);
        Renseleccion(rendimientoComp.arreglo);
        System.out.println(Arrays.toString(rendimientoComp.arreglo));
        final long END = System.nanoTime();
        System.out.println("Time taken : " + ((END - START) / 1e+9) + " seconds"); // FIn contador
    }

    public static void Renseleccion(int num[]) {
        int i, j, menor, pos, tmp, cont = 0;
        for (i = 0; i < num.length - 1; i += 1) {
            menor = num[i];
            pos = i;
            for (j = i + 1; j < num.length; j += 1) {
                if (num[j] < menor) {
                    menor = num[j];
                    pos = j;
                }
            }
            if (pos != i) {
                tmp = num[i];
                num[i] = num[pos];
                num[pos] = tmp;
                cont += 1;
            }
        }
        System.out.println("Iteraciones: " + cont);
    }

    private static void Arreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i += 1) {
            arreglo[i] = (int) (Math.random() * 1000) + 1;
        }
    }
}