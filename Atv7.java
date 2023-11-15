public class Atv7 {
    public static void main(String[] args) {

        boolean temNumAlgarismos;
        boolean ehCapicua;
        boolean multiploSete;
        boolean multiploOnze;
        boolean multiploTreze;
        boolean menosDeTrezAlgarismosConsecutivos;
        boolean menosDeDozeAlgarismosUsados;
        boolean peloMenosOitoAlgarismoUsados;
        int contador = 0;
        int somador = 7;

        int[] array = new int[54];
        int[] arrayCompleto = new int[109];

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

        System.out.println(verificaSeTemTresConsecutivosIguais(array));

        for (int i = 0, j = arrayCompleto.length - 1; i < array.length; i++, j--) {
            arrayCompleto[i] = array[i];
            arrayCompleto[j] = array[i];
        }

        arrayCompleto[54] = 0;
        // arrayCompleto[0] = 4;
        // arrayCompleto[108] = 4;
        printArray(arrayCompleto);
        System.out.println(verificaCapicua(arrayCompleto));
        System.out.println(verificaMultiploOnze(arrayCompleto));
        System.out
                .println(verificaMultiploTreze(new int[] { 1, 2, 3, 4, 5, 6, 7, 9, 8, 1, 3, 5, 7, 8, 5, 6, 8, 1, 6 }));
        System.out.println(verificaMultiploSete(new int[] { 1, 2, 5, 7, 9, 6, 4, 3, 2, 7, 1, 3, 5, 6 }));

        do {
            if (true)
                break;
            temNumAlgarismos = false;
            ehCapicua = false;
            multiploSete = false;
            multiploOnze = false;
            multiploTreze = false;
            menosDeTrezAlgarismosConsecutivos = false;
            menosDeDozeAlgarismosUsados = false;
            peloMenosOitoAlgarismoUsados = false;

            do {
                incrementaArray(array);
                printArray(array);

            } while (verificaSeTemTresConsecutivosIguais(array));

            /*
             * for (int i = 0; i < array.length; i++) {
             * arrayCompleto[i] = array[i];
             * }
             * 
             * arrayCompleto[55] = array[53];
             * 
             * int cont = 4;
             * for (int i = 56; i < array.length; i++) {
             * arrayCompleto[i] = array[i - cont];
             * cont += 2;
             * }
             * 
             * temNumAlgarismos = verificaQtdAlgarismos(array);
             * ehCapicua = verificaCapicua(array);
             * if (!ehCapicua) {
             * continue;
             * }
             * 
             * multiploSete = verificaMultiploSete(array);
             * if (!multiploSete) {
             * continue;
             * }
             * 
             * multiploOnze = verificaMultiploOnze(array);
             * if (!multiploOnze) {
             * continue;
             * }
             * 
             * multiploTreze = verificaMultiploTreze(array);
             * 
             * menosDeTrezAlgarismosConsecutivos =
             * !verificaSeTemTresConsecutivosIguais(array);
             * menosDeDozeAlgarismosUsados = !verificaSeTemMaisDeDozeVezes(array);
             * peloMenosOitoAlgarismoUsados = verificaSeTemPeloMenosOito(array);
             * 
             * System.out.println("Tem 109 algarismos = " + verificaQtdAlgarismos(array));
             * System.out.println("Eh capicua = " + verificaCapicua(array));
             * 
             * System.out.println("Eh multiplo de 7 = " + verificaMultiploSete(array));
             * System.out.println("Eh multiplo de 13 = " + verificaMultiploTreze(array));
             * System.out.println("Eh multiplo de 11 = " + verificaMultiploOnze(array));
             * 
             * System.out.println("Tem mais de 12 vezes o mesmo algarismo = " +
             * verificaSeTemMaisDeDozeVezes(array));
             * System.out.println("Tem pelo menos 8 vezes o mesmo algarismo = " +
             * verificaSeTemPeloMenosOito(array));
             * System.err.println("Tem 3 consecutivos iguais = " +
             * verificaSeTemTresConsecutivosIguais(array));
             */

        } while (!temNumAlgarismos ||
                !multiploSete ||
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
        int[] arrayCompleto = new int[array.length + array.length % 3];
        int[][] grupoDeTres = new int[arrayCompleto.length / 3][3];
        int[] arraySomatorio = new int[arrayCompleto.length / 3];
        int cont;
        int somatorio = 0;

        for (int i = 2; i < arrayCompleto.length; i++) {
            arrayCompleto[i] = array[i - 2];
        }

        /*
         * for (int i = 0; i < arrayCompleto.length; i++) {
         * arrayCompleto[i] = array[i];
         * }
         */

        grupoDeTres = divideEmGruposDeTres(arrayCompleto);

        for (int i = 0; i < arraySomatorio.length; i++) {
            arraySomatorio[i] = grupoDeTres[i][2] + grupoDeTres[i][1] * 3 + grupoDeTres[i][0] * 2;
            System.out.println("ARRAY SOMATORIO 7[" + i + "] = " + arraySomatorio[i]);

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
        int[] arrayCompleto = new int[array.length + array.length % 3];
        int[][] grupoDeTres = new int[arrayCompleto.length / 3][3];
        int[] arraySomatorio = new int[arrayCompleto.length / 3];
        int cont;
        int somatorio = 0;

        for (int i = 2; i < arrayCompleto.length; i++) {
            arrayCompleto[i] = array[i - 2];
        }

        /*
         * for (int i = 0; i < arrayCompleto.length; i++) {
         * arrayCompleto[i] = array[i];
         * }
         */

        grupoDeTres = divideEmGruposDeTres(arrayCompleto);

        for (int i = 0; i < arraySomatorio.length; i++) {
            arraySomatorio[i] = grupoDeTres[i][2] * (-1) + grupoDeTres[i][1] * 3 + grupoDeTres[i][0] * 4;
            System.out.println("GRUPO[" + i + "][2] = " + grupoDeTres[i][2]);
            System.out.println("GRUPO[" + i + "][1] = " + grupoDeTres[i][1]);
            System.out.println("GRUPO[" + i + "][0] = " + grupoDeTres[i][0]);

            System.out.println("ARRAY SOMATORIO[" + i + "] = " + arraySomatorio[i]);
        }

        cont = arraySomatorio.length;
        boolean ehPar = true;
        for (int i = 1; i <= arraySomatorio.length; i++) {
            if (cont % 2 != 0) {
                ehPar = false;
            }

            if (ehPar) {
                if (i % 2 == 0) {
                    somatorio += arraySomatorio[cont - i];
                } else {
                    somatorio -= arraySomatorio[cont - i];
                }
            }

            if (!ehPar) {
                if (i % 2 == 0) {
                    somatorio -= arraySomatorio[cont - i];
                } else {
                    somatorio += arraySomatorio[cont - i];
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

        /*
         * for (int i = 0; i < arrayCompleto.length; i++) {
         * arrayCompleto[i] = array[i];
         * }
         */

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
        // boolean temTresConsecutivos = false;

        for (int j = 0; j < array.length - 3; j++) {
            if (array[j] == array[j + 1] && array[j] == array[j + 2]) {
                return true;

                // if (array[j + 1] == array[j + 2]) {
                // temTresConsecutivos = true;
                // } else {
                // temTresConsecutivos = false;
                // }
            } // else {
              // temTresConsecutivos = false;
              // }
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