package com.example.almoxarifado.Model;

public class Material {
    //aqui estão os atributos/caracterisiticas abstraidas do problema
    private int codigo;
    private String nome;
    private int saldo;
    //Todas variáveis são privadas e a quatidade de gets e sets é o dobro da quatidade de variáveis

    /* Dica:
    CONSTRUTORES: sempre recebem exatamente o mesmo nome da classe, até a letra maiuscula
    e nunca vão ter nenhum tipo de retorno e nem o void....
    */
    public Material () //Construtor com assinatura vazia
    {

    }

    public Material (int codigo, String nome, int saldo) //Construtor com assinatura completa
    {   //this significa que eu estou trabalhando com o contesto atual ao da classe, ou seja, utilizando...
        //... as variáveis privadas receberem algo que vem de fora(que está na assinatura)
        this.codigo = codigo;
        this.nome = nome;
        this.saldo = saldo;
    }
    //--------------------------------- //getters e setters utilizados para modificar os estados e capturar valores dos atribrutos/variaveis
    /* Dicas:
      GETTER sempre tem RETURN - o retorno sempre é igual ao que quero
      SETTER nunca tem retorno
    */
    public int getCodigo () //depois do public precisa adicionar o tipo da variável, Recebe algum valor
    {                        //Todo get e set são minúsculos e tem as outras palavras com a inicial maiúscula
        return this.codigo;  //retorna algum valor
    }

    public void setCodigo (int codigo) //Todo void precisa de uma assinatura, sendo pelo menos oque deseja alterar (tipo e nome)
    {
        this.codigo = codigo;
    }
    //----------------------------------
    public String getNome ()
    {
        return this.nome;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }
    //-----------------------------------
    public int getSaldo ()
    {
        return this.saldo;
    }

    public void setSaldo (int saldo)
    {
        this.saldo = saldo;
    }
    //-----------------------------------
}
