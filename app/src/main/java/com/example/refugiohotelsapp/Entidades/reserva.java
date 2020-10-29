package com.example.refugiohotelsapp.Entidades;

import java.util.Date;

public class reserva {
    private int idReserva;
    private Date dataInicio;
    private Date dataFim;
    private int quantidadeAdultos;
    private int quantidadeCriancas;
    private float valorReserva;
    private String metodoPagamento;
    private boolean reservaAtiva;
    private usuario usuario;

    public reserva(int idReserva, Date dataInicio, Date dataFim, int quantidadeAdultos, int quantidadeCriancas,
                   float valorReserva, String metodoPagamento, boolean reservaAtiva, com.example.refugiohotelsapp.Entidades.usuario usuario) {
        this.idReserva = idReserva;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.quantidadeAdultos = quantidadeAdultos;
        this.quantidadeCriancas = quantidadeCriancas;
        this.valorReserva = valorReserva;
        this.metodoPagamento = metodoPagamento;
        //pensar na lógica booleana da flag reservaAtiva, instânciar o objeto já com a flag ativa em 1?
        //pensar e criar função para alterar estado quando a reserva for cancelada
        this.reservaAtiva = reservaAtiva;
        this.usuario = usuario;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getQuantidadeAdultos() {
        return quantidadeAdultos;
    }

    public void setQuantidadeAdultos(int quantidadeAdultos) {
        this.quantidadeAdultos = quantidadeAdultos;
    }

    public int getQuantidadeCriancas() {
        return quantidadeCriancas;
    }

    public void setQuantidadeCriancas(int quantidadeCriancas) {
        this.quantidadeCriancas = quantidadeCriancas;
    }

    public float getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(float valorReserva) {
        this.valorReserva = valorReserva;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public boolean isReservaAtiva() {
        return reservaAtiva;
    }

    public void setReservaAtiva(boolean reservaAtiva) {
        this.reservaAtiva = reservaAtiva;
    }

    public com.example.refugiohotelsapp.Entidades.usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(com.example.refugiohotelsapp.Entidades.usuario usuario) {
        this.usuario = usuario;
    }
}
