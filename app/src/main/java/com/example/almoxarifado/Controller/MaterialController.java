package com.example.almoxarifado.Controller;

import com.example.almoxarifado.Model.Material;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class MaterialController {

    /*Erros observados
(OK) Listar especifico: ao utilizar essa opção continua listando todos os produtos
(OK) Editar nome do produto: ao utilizar essa função o sitema retorna ao menu principal
(OK) Função sair funciona com qualquer caractere!
(OK) Mensagem de alteração de saldo, caso tenha dado certo.
(OK) Ao inserir ou importar, precisamos verificar se o codigo não está duplicado
(OK) Opção 1, inserir. Pergunta o nome e o saldo ao mesmo tempo.
(OK) Quando se insere um material pela opção 1, não é possivel listar ele
(OK) Opção 1 inserir, não funciona quando é a primeira iteração, ou seja o vetor está vazio
(OK) Importar após inserir
 */

        public static void ler(Material materiais[], String nome) {
            String linha, v[], nome2;
            int cod, aux, saldo, cont = 0;

            Material material;

            try {
                //lendo arquivo
                FileReader fr = new FileReader(nome);
                //armazendando em buffer para poder utilizar
                BufferedReader bfr = new BufferedReader(fr);
                //verificando as linhas do meu arquivo
                linha = bfr.readLine();
                /*Linha está organizada em 0-codigo 1-nome 2-saldo*/

                while ((linha != null) && (cont < materiais.length)) {
                    v = linha.split(";");
                    //procurar se o codigo existe em todo o vetor
                    if (procuraNoVetor(materiais, Integer.parseInt(v[0]))) {
                        //se existir vai para a proxima linha do arquivo de importação
                        System.out.println("Produto ja cadastrado " + linha);
                        linha = bfr.readLine();
                    } else {
                        //senao existir, procura a primeira posição vazia para inserir o produto
                        for (int i = 0; i < materiais.length; i++) {
                            if (materiais[i].getCodigo() == -1) {
                                material
                                        = new Material(Integer.parseInt(v[0]),
                                        v[1],
                                        Integer.parseInt(v[2]));
                                materiais[i] = material;
                                break;
                            }
                        }
                        cont++;
                        linha = bfr.readLine();

                    }
                }
                bfr.close();
                fr.close();
                System.out.println(cont + " Produtos importados!");
            } catch (Exception e) {
                System.err.println("Erro ao importar!");
            }
        }

        public static boolean procuraNoVetor(Material[] vetorParaBuscar, int codABuscar) {
            boolean encontrado = false;
            for (int i = 0; i < vetorParaBuscar.length; i++) {
                if (vetorParaBuscar[i].getCodigo() == codABuscar) {
                    encontrado = true;
                }
            }
            return encontrado;
        }

        public static void mostraMenu() {
            //criando o menu de ações
            System.out.println("O que deseja fazer?");
            System.out.println("--MENU--");
            System.out.println("1 - Inserir");
            System.out.println("2 - Importar");
            System.out.println("3 - Listar");
            System.out.println("4 - Editar");
            System.out.println("5 - Sair");
            System.out.println("6 - Remover");
        }

        private static void alimentaVetor(Material[] materiais) {
            for (int i = 0; i < materiais.length; i++) {
                Material materialVazio = new Material(-1, "", 0);
                materiais[i] = materialVazio;
            }
        }

        private static int buscarPorCodigo(Material[] vetorParaBuscar, int codABuscar) {
            for (int i = 0; i < vetorParaBuscar.length; i++) {
                if (vetorParaBuscar[i].getCodigo() == codABuscar && codABuscar != -1) {
                    //caso existe o codigo armazenado a var indice
                    //guarda o valor de i e em seguida encerramos
                    //o laço!
                    return i;
                }
            }
            return -1;
        }
}
