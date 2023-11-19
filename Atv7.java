public class Atv8 {
    public static void main(String[] args) {

        boolean temNumAlgarismos;
        boolean ehCapicua;
        boolean multiploSete;
        boolean multiploOnze;
        boolean multiploTreze;
        boolean menosDeTrezAlgarismosConsecutivos;
        boolean menosDeDozeAlgarismosUsados;
        boolean peloMenosOitoAlgarismoUsados;
        int somador = 1;

        int[] array = new int[54];
        int[] arrayCompleto = new int[109];

        do {

            temNumAlgarismos = false;
            ehCapicua = false;
            multiploSete = false;
            multiploOnze = false;
            multiploTreze = false;
            menosDeTrezAlgarismosConsecutivos = false;
            menosDeDozeAlgarismosUsados = false;
            peloMenosOitoAlgarismoUsados = false;

            for (int i = 0; i < array.length; i++) {
                if (i % 2 == 0 && i != 0) {
                    somador++;
                    if (somador == 10) {
                        somador = 0;
                    }
                }
                array[i] = somador;
            }

            printArray(array);

            System.out.println("3 consecutivos: " + verificaSeTemTresConsecutivosIguais(array));

            incrementaArray(array);
            printArray(array);

            for (int i = 0, j = arrayCompleto.length - 1; i < array.length; i++, j--) {
                arrayCompleto[i] = array[i];
                arrayCompleto[j] = array[i];
            }

            arrayCompleto[54] = 0;
            printArray(arrayCompleto);
            /*
             * System.out.println("Capicua: " + verificaCapicua(arrayCompleto));
             * System.out.println("7: " + verificaMultiploSete(arrayCompleto));
             * System.out.println("11: " + verificaMultiploOnze(arrayCompleto));
             * System.out.println("13: " + verificaMultiploTreze(arrayCompleto));
             */

            temNumAlgarismos = verificaQtdAlgarismos(arrayCompleto);
            ehCapicua = verificaCapicua(arrayCompleto);
            if (!ehCapicua) {
                continue;
            }

            multiploSete = verificaMultiploSete(arrayCompleto);
            if (!multiploSete) {
                continue;
            }

            multiploOnze = verificaMultiploOnze(arrayCompleto);
            if (!multiploOnze) {
                continue;
            }

            multiploTreze = verificaMultiploTreze(arrayCompleto);

            menosDeTrezAlgarismosConsecutivos = !verificaSeTemTresConsecutivosIguais(arrayCompleto);
            menosDeDozeAlgarismosUsados = !verificaSeTemMaisDeDozeVezes(arrayCompleto);
            peloMenosOitoAlgarismoUsados = verificaSeTemPeloMenosOito(arrayCompleto);

            System.out.println("Tem 109 algarismos = " + verificaQtdAlgarismos(arrayCompleto));
            System.out.println("Eh capicua = " + verificaCapicua(arrayCompleto));

            System.out.println("Eh multiplo de 7 = " + verificaMultiploSete(arrayCompleto));
            System.out.println("Eh multiplo de 13 = " + verificaMultiploTreze(arrayCompleto));
            System.out.println("Eh multiplo de 11 = " + verificaMultiploOnze(arrayCompleto));

            System.out.println("Tem mais de 12 vezes = " + verificaSeTemMaisDeDozeVezes(arrayCompleto));
            System.out.println("Tem 8 vezes o mesmo algarismo = " + verificaSeTemPeloMenosOito(arrayCompleto));
            System.out.println("Tem 3 consecutivos = " + verificaSeTemTresConsecutivosIguais(arrayCompleto));

        } while (!multiploSete ||
                !multiploOnze ||
                !multiploTreze ||
                !menosDeTrezAlgarismosConsecutivos ||
                !menosDeDozeAlgarismosUsados ||
                !peloMenosOitoAlgarismoUsados);
    }

    private static void incrementaArray(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            int soma = array[i] + 1;

            if (soma == 10) {
                array[i] = 0;
            } else {
                array[i] = soma;
                break;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean verificaQtdAlgarismos(int[] array) {
        return array[0] != 0;
    }

    public static boolean verificaCapicua(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[array.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[][] divideEmGruposDeTres(int[] array) {
        int[][] grupo = new int[array.length / 3][3];
        int cont = 0;

        for (int i = array.length / 3 - 1; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                grupo[i][j] = array[array.length - 1 - cont];
                cont++;
            }
        }

        for (int i = 0; i < grupo.length; i++) {
            for (int j = 0; j < grupo[0].length; j++) {
            }
        }
        return grupo;
    }

    public static boolean verificaMultiploSete(int[] array) {
        int qtdZeros = 3 - array.length % 3;
        int[] arrayCompleto = new int[array.length + qtdZeros];
        int[][] grupoDeTres = new int[arrayCompleto.length / 3][3];
        int[] arraySomatorio = new int[arrayCompleto.length / 3];
        int cont;
        int somatorio = 0;

        for (int i = qtdZeros, j = 0; i < arrayCompleto.length; i++, j++) {
            arrayCompleto[i] = array[j];
        }

        grupoDeTres = divideEmGruposDeTres(arrayCompleto);

        for (int i = 0; i < arraySomatorio.length; i++) {
            arraySomatorio[i] = grupoDeTres[i][2] + grupoDeTres[i][1] * 3 + grupoDeTres[i][0] * 2;
        }

        cont = arraySomatorio.length;
        boolean ehPar = true;
        for (int i = 1; i <= arraySomatorio.length; i++) {
            if (cont % 2 != 0) {
                ehPar = false;
            }

            if (ehPar) {
                if (i % 2 != 0) {
                    somatorio += arraySomatorio[cont - i];
                } else {
                    somatorio -= arraySomatorio[cont - i];
                }
            }

            if (!ehPar) {
                if (i % 2 != 0) {
                    somatorio -= arraySomatorio[cont - i];
                } else {
                    somatorio += arraySomatorio[cont - i];
                }
            }
        }
        return somatorio % 7 == 0;
    }

    public static boolean verificaMultiploTreze(int[] array) {
        int qtdZeros = 3 - array.length % 3;
        int[] arrayCompleto = new int[array.length + qtdZeros];
        int[][] grupoDeTres = new int[arrayCompleto.length / 3][3];
        int[] arraySomatorio = new int[arrayCompleto.length / 3];
        int cont;
        int somatorio = 0;

        for (int i = qtdZeros, j = 0; i < arrayCompleto.length; i++, j++) {
            arrayCompleto[i] = array[j];
        }

        grupoDeTres = divideEmGruposDeTres(arrayCompleto);

        for (int i = 0; i < arraySomatorio.length; i++) {
            arraySomatorio[i] = grupoDeTres[i][2] * (-1) + grupoDeTres[i][1] * 3 + grupoDeTres[i][0] * 4;
        }

        cont = arraySomatorio.length;
        boolean ehPar = true;
        for (int i = 1; i <= arraySomatorio.length; i++) {
            if (cont % 2 != 0) {
                ehPar = false;
            }

            if (ehPar) {
                if (i % 2 == 0) {
                    somatorio -= arraySomatorio[cont - i];
                } else {
                    somatorio += arraySomatorio[cont - i];
                }
            }

            if (!ehPar) {
                if (i % 2 == 0) {
                    somatorio += arraySomatorio[cont - i];
                } else {
                    somatorio -= arraySomatorio[cont - i];
                }
            }
        }
        return somatorio % 13 == 0;
    }

    public static boolean verificaMultiploOnze(int[] array) {
        int[] arrayCompleto = new int[array.length + array.length % 3];
        int cont;
        int somatorio = 0;

        for (int i = 2; i < arrayCompleto.length; i++) {
            arrayCompleto[i] = array[i - 2];
        }

        cont = arrayCompleto.length;
        boolean ehPar = true;
        for (int i = 1; i <= arrayCompleto.length; i++) {
            if (cont % 2 != 0) {
                ehPar = false;
            }

            if (ehPar) {
                if (i % 2 != 0) {
                    somatorio += arrayCompleto[cont - i];
                } else {
                    somatorio -= arrayCompleto[cont - i];
                }
            }

            if (!ehPar) {
                if (i % 2 != 0) {
                    somatorio -= arrayCompleto[cont - i];
                } else {
                    somatorio += arrayCompleto[cont - i];
                }
            }
        }
        return somatorio % 11 == 0;
    }

    public static boolean verificaSeTemMaisDeDozeVezes(int[] array) {
        int[] qtdCadaAlgarismo = new int[10];
        boolean temMaisDeDozeVezes = false;

        for (int i = 0; i < array.length; i++) {
            qtdCadaAlgarismo[array[i]]++;
        }

        for (int i = 0; i < qtdCadaAlgarismo.length; i++) {
            if (qtdCadaAlgarismo[i] > 12) {
                temMaisDeDozeVezes = true;
                break;
            }
        }
        System.err.println("QTD de cada algorismo: ");
        printArray(qtdCadaAlgarismo);
        return temMaisDeDozeVezes;
    }

    public static boolean verificaSeTemPeloMenosOito(int[] array) {
        int[] qtdCadaAlgarismo = new int[10];
        boolean temPeloMenosOitoVezes = false;

        for (int i = 0; i < array.length; i++) {
            qtdCadaAlgarismo[array[i]]++;
        }

        for (int i = 0; i < qtdCadaAlgarismo.length; i++) {
            if (qtdCadaAlgarismo[i] >= 8) {
                temPeloMenosOitoVezes = true;
                break;
            }
        }
        printArray(qtdCadaAlgarismo);
        return temPeloMenosOitoVezes;
    }

    public static boolean verificaSeTemTresConsecutivosIguais(int[] array) {
        for (int j = 0; j < array.length - 3; j++) {
            if (array[j] == array[j + 1] && array[j] == array[j + 2]) {
                return true;
            }
        }

        return false;
    }

    public static boolean verificaSeTemMaisDeSeisVezes(int[] array) {
        int[] qtdCadaAlgarismo = new int[10];
        boolean temMaisDeSeisVezes = false;

        for (int i = 0; i < array.length; i++) {
            qtdCadaAlgarismo[array[i]]++;
        }

        for (int i = 0; i < qtdCadaAlgarismo.length; i++) {
            if (qtdCadaAlgarismo[i] > 6 && array[i] != 0) {
                temMaisDeSeisVezes = true;
                break;
            }
        }
        printArray(qtdCadaAlgarismo);
        return temMaisDeSeisVezes;
    }
}