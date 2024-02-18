/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.relatorios;

import br.com.sskings.app.gestor.financeiro.model.dao.LancamentoDao;
import br.com.sskings.app.gestor.financeiro.model.dao.UsuarioDao;
import br.com.sskings.app.gestor.financeiro.model.dto.LancamentoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.UsuarioDto;
import br.com.sskings.app.gestor.financeiro.view.TelaLogin;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author sskings
 */
public class Relatorios {

    public static void gerarRelatorioDeTodosOsLancamentos() {
        Document documento = new Document(PageSize.A4);
        documento.setMargins(40f, 40f, 40f, 40f);

        try {

            PdfWriter.getInstance(documento, new FileOutputStream("relatorio_todos_lancamentos.pdf"));
            documento.open();

            Paragraph dataDeEmissao = gerarDataDeEmissao();
            documento.add(dataDeEmissao);

            Image msmLogo = gerarLogo();
            documento.add(msmLogo);

            Paragraph titulo = gerarTitulo();
            documento.add(titulo);

            Paragraph subtitulo = gerarSubtitulo("Todos os lançamentos.\n\n");
            documento.add(subtitulo);

            PdfPTable tabela = gerarTabelaDeTodosOsLancamentos();;
            documento.add(tabela);
            documento.close();

            //executar programa padrão de visualização de pdf em Windows
            //Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "relatorio_de_lancamentos.pdf"}); 
            Runtime.getRuntime().exec(new String[]{"xdg-open", "relatorio_todos_lancamentos.pdf"});//executar programa padrão de visualização de pdf em Linux

        } catch (Exception ex) {
        }
    }

    public static void gerarRelatorioDeTodasAsReceitas() {
        Document documento = new Document(PageSize.A4);
        documento.setMargins(40f, 40f, 40f, 40f);

        try {

            PdfWriter.getInstance(documento, new FileOutputStream("relatorio_todas_as_receitas.pdf"));
            documento.open();

            Paragraph dataDeEmissao = gerarDataDeEmissao();
            documento.add(dataDeEmissao);

            Image msmLogo = gerarLogo();
            documento.add(msmLogo);

            Paragraph titulo = gerarTitulo();
            documento.add(titulo);

            Paragraph subtitulo = gerarSubtitulo("Todas as receitas.\n\n");
            documento.add(subtitulo);

            PdfPTable tabela = gerarTabelaDeTodasAsReceitas();
            documento.add(tabela);
            documento.close();

            //executar programa padrão de visualização de pdf em Windows
            //Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "relatorio_de_lancamentos.pdf"}); 
            Runtime.getRuntime().exec(new String[]{"xdg-open", "relatorio_todas_as_receitas.pdf"});//executar programa padrão de visualização de pdf em Linux

        } catch (Exception ex) {
        }
    }

    public static void gerarRelatorioDeTodasAsDespesas() {
        Document documento = new Document(PageSize.A4);
        documento.setMargins(40f, 40f, 40f, 40f);

        try {

            PdfWriter.getInstance(documento, new FileOutputStream("relatorio_todas_as_despesas.pdf"));
            documento.open();

            Paragraph dataDeEmissao = gerarDataDeEmissao();
            documento.add(dataDeEmissao);

            Image msmLogo = gerarLogo();
            documento.add(msmLogo);

            Paragraph titulo = gerarTitulo();
            documento.add(titulo);

            Paragraph subtitulo = gerarSubtitulo("Todas as despesas.\n\n");
            documento.add(subtitulo);

            PdfPTable tabela = gerarTabelaDeTodasAsDespesas();
            documento.add(tabela);
            documento.close();

            //executar programa padrão de visualização de pdf em Windows
            //Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "relatorio_de_lancamentos.pdf"});
            //executar programa padrão de visualização de pdf em Linux
            Runtime.getRuntime().exec(new String[]{"xdg-open", "relatorio_todas_as_despesas.pdf"});

        } catch (Exception ex) {
        }
    }
    
    public static void gerarRelatorioDeLancamentosDeCartao(){
        Document documento = new Document(PageSize.A4);
        documento.setMargins(40f, 40f, 40f, 40f);

        try {

            PdfWriter.getInstance(documento, new FileOutputStream("relatorio_lancamentos_cartao.pdf"));
            documento.open();

            Paragraph dataDeEmissao = gerarDataDeEmissao();
            documento.add(dataDeEmissao);

            Image msmLogo = gerarLogo();
            documento.add(msmLogo);

            Paragraph titulo = gerarTitulo();
            documento.add(titulo);

            Paragraph subtitulo = gerarSubtitulo("Cartões De Crédito\n\n");
            documento.add(subtitulo);

            PdfPTable tabela = gerarTabelaLancamentosDeCartao();
            documento.add(tabela);
            documento.close();

            //executar programa padrão de visualização de pdf em Windows
            //Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "relatorio_de_lancamentos.pdf"}); 
            Runtime.getRuntime().exec(new String[]{"xdg-open", "relatorio_lancamentos_cartao.pdf"});//executar programa padrão de visualização de pdf em Linux

        } catch (Exception ex) {
        }
    }
    
    public static void gerarRelatorioDeLancamentosDeConta(){
        Document documento = new Document(PageSize.A4);
        documento.setMargins(40f, 40f, 40f, 40f);

        try {

            PdfWriter.getInstance(documento, new FileOutputStream("relatorio_lancamentos_conta.pdf"));
            documento.open();

            Paragraph dataDeEmissao = gerarDataDeEmissao();
            documento.add(dataDeEmissao);

            Image msmLogo = gerarLogo();
            documento.add(msmLogo);

            Paragraph titulo = gerarTitulo();
            documento.add(titulo);

            Paragraph subtitulo = gerarSubtitulo("Contas Bancárias\n\n");
            documento.add(subtitulo);

            PdfPTable tabela = gerarTabelaLancamentosDeConta();
            documento.add(tabela);
            documento.close();

            //executar programa padrão de visualização de pdf em Windows
            //Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "relatorio_de_lancamentos.pdf"}); 
            Runtime.getRuntime().exec(new String[]{"xdg-open", "relatorio_lancamentos_conta.pdf"});//executar programa padrão de visualização de pdf em Linux

        } catch (Exception ex) {
        }
    }

    private static Image gerarLogo() throws Exception {
        var msmLogo = Image.getInstance("src/main/resources/images/msm-1.png");
        msmLogo.scaleAbsolute(520f, 300f);
        msmLogo.setAlignment(Element.ALIGN_CENTER);

        return msmLogo;
    }

    private static Paragraph gerarDataDeEmissao() {
        var dataDeEmissao = new Paragraph("Data: "
                + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));

        return dataDeEmissao;

    }

    private static Paragraph gerarTitulo() {
        Paragraph titulo = new Paragraph(new Phrase(40f, "\nRelatório de lançamentos\n\n",
                FontFactory.getFont(FontFactory.TIMES_BOLD, 30f)));
        titulo.setAlignment(Element.ALIGN_CENTER);

        return titulo;
    }

    private static Paragraph gerarSubtitulo(String texto) {
        Paragraph subtitulo = new Paragraph(new Phrase(30f, texto,
                FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 20f)));
        subtitulo.setAlignment(Element.ALIGN_CENTER);

        return subtitulo;
    }

    private static PdfPTable gerarTabelaDeTodosOsLancamentos() throws Exception {

        PdfPTable tabela = new PdfPTable(4);
        tabela.setWidths(new int[]{10, 25, 10, 15});

        tabela.addCell(new Paragraph("TIPO", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("FONTE", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("VALOR", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("DATA: ", FontFactory.getFont(FontFactory.TIMES_BOLD)));

        tabela = carregarDadosDeTodosLancamentos(tabela);
        return tabela;
    }

    private static PdfPTable gerarTabelaDeTodasAsReceitas() throws Exception {
        PdfPTable tabela = new PdfPTable(4);
        tabela.setWidths(new int[]{10, 25, 10, 15});

        tabela.addCell(new Paragraph("TIPO", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("FONTE", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("VALOR", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("DATA: ", FontFactory.getFont(FontFactory.TIMES_BOLD)));

        tabela = carregarDadosDeTodasAsReceitas(tabela);
        return tabela;
    }
    
    private static PdfPTable gerarTabelaDeTodasAsDespesas() throws Exception {
        PdfPTable tabela = new PdfPTable(4);
        tabela.setWidths(new int[]{10, 25, 10, 15});

        tabela.addCell(new Paragraph("TIPO", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("FONTE", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("VALOR", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("DATA: ", FontFactory.getFont(FontFactory.TIMES_BOLD)));

        tabela = carregarDadosDeTodasAsDespesas(tabela);
        return tabela;
    }
    
    private static PdfPTable gerarTabelaLancamentosDeCartao() throws Exception {
        
        PdfPTable tabela = new PdfPTable(4);
        tabela.setWidths(new int[]{10, 25, 10, 15});

        tabela.addCell(new Paragraph("TIPO", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("FONTE", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("VALOR", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("DATA: ", FontFactory.getFont(FontFactory.TIMES_BOLD)));

        tabela = carregarDadosDeLancamentosDoCartao(tabela);
        return tabela;
    }
    
    private static PdfPTable gerarTabelaLancamentosDeConta() throws Exception {
        PdfPTable tabela = new PdfPTable(4);
        tabela.setWidths(new int[]{10, 25, 10, 15});

        tabela.addCell(new Paragraph("TIPO", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("FONTE", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("VALOR", FontFactory.getFont(FontFactory.TIMES_BOLD)));
        tabela.addCell(new Paragraph("DATA: ", FontFactory.getFont(FontFactory.TIMES_BOLD)));

        tabela = carregarDadosDeLancamentosDaConta(tabela);
        return tabela;
    }
    
    private static PdfPTable carregarDadosDeTodosLancamentos(PdfPTable tabela) throws Exception {

        List<LancamentoDto> lancamentos = new LancamentoDao().listar(obterUsuarioLogado());

        lancamentos.forEach(l -> {
            String tipo = l.getTipo().getNome();
            String fonte = l.getFonte().getNome();
            Double valor = l.getValor();
            LocalDate data = l.getData();

            try {

                tabela.addCell(new Paragraph(tipo));
                tabela.addCell(new Paragraph(fonte));
                tabela.addCell(new Paragraph(valor.toString()));
                tabela.addCell(new Paragraph(data.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))));

            } catch (Exception ex) {
            }
        });
        return tabela;
    }

    private static PdfPTable carregarDadosDeTodasAsReceitas(PdfPTable tabela) throws Exception {

        List<LancamentoDto> lancamentos = new LancamentoDao().pesquisarPorReceita(obterUsuarioLogado());

        lancamentos.forEach(l -> {
            String tipo = l.getTipo().getNome();
            String fonte = l.getFonte().getNome();
            Double valor = l.getValor();
            LocalDate data = l.getData();

            try {

                tabela.addCell(new Paragraph(tipo));
                tabela.addCell(new Paragraph(fonte));
                tabela.addCell(new Paragraph(valor.toString()));
                tabela.addCell(new Paragraph(data.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))));

            } catch (Exception ex) {
            }
        });
        return tabela;
    }
    
    private static PdfPTable carregarDadosDeTodasAsDespesas(PdfPTable tabela) throws Exception {
        
        List<LancamentoDto> lancamentos = new LancamentoDao().pesquisarPorDespesa(obterUsuarioLogado());

        lancamentos.forEach(l -> {
            String tipo = l.getTipo().getNome();
            String fonte = l.getFonte().getNome();
            Double valor = l.getValor();
            LocalDate data = l.getData();

            try {

                tabela.addCell(new Paragraph(tipo));
                tabela.addCell(new Paragraph(fonte));
                tabela.addCell(new Paragraph(valor.toString()));
                tabela.addCell(new Paragraph(data.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))));

            } catch (Exception ex) {
            }
        });
        return tabela;
    }
    
    private static PdfPTable carregarDadosDeLancamentosDoCartao(PdfPTable tabela) throws Exception {
        
        List<LancamentoDto> lancamentos = new LancamentoDao().pesquisarPorCartao(obterUsuarioLogado());

        lancamentos.forEach(l -> {
            String tipo = l.getTipo().getNome();
            String fonte = l.getFonte().getNome();
            Double valor = l.getValor();
            LocalDate data = l.getData();

            try {

                tabela.addCell(new Paragraph(tipo));
                tabela.addCell(new Paragraph(fonte));
                tabela.addCell(new Paragraph(valor.toString()));
                tabela.addCell(new Paragraph(data.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))));

            } catch (Exception ex) {
            }
        });
        return tabela;
    }
    
    private static PdfPTable carregarDadosDeLancamentosDaConta(PdfPTable tabela) throws Exception {
        
        List<LancamentoDto> lancamentos = new LancamentoDao().pesquisarPorConta(obterUsuarioLogado());

        lancamentos.forEach(l -> {
            String tipo = l.getTipo().getNome();
            String fonte = l.getFonte().getNome();
            Double valor = l.getValor();
            LocalDate data = l.getData();

            try {

                tabela.addCell(new Paragraph(tipo));
                tabela.addCell(new Paragraph(fonte));
                tabela.addCell(new Paragraph(valor.toString()));
                tabela.addCell(new Paragraph(data.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))));

            } catch (Exception ex) {
            }
        });
        return tabela;
    }
            
    private static UsuarioDto obterUsuarioLogado() throws Exception {
        UsuarioDto usuarioLogado = new UsuarioDto();
        usuarioLogado.setEmail(TelaLogin.getCampoUsuario());
        usuarioLogado.setLogin(TelaLogin.getCampoUsuario());
        usuarioLogado = new UsuarioDao().pesquisar(usuarioLogado);
        return usuarioLogado;
    }
}
