package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class Main extends Application {
	private static Stage stage;
    private static Scene login;
    private static Scene main;
    private static Scene vendedor;
    private static Scene Relatorio;  
    private static Scene Cliente;
    private static Scene Fornecedor;
    private static Scene Compra;
    private static Scene Produto;
    private static Stage cadProduto;
    private static Stage cadFornecedor;
    private static Stage cadCliente;
    private static Stage cadVendedor;
    private static Stage cadRegistrar;
    

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            primaryStage.setTitle("Blue Paint");

            Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/package_View/viewLogin.fxml"));
            login = new Scene(fxmlLogin);

            Parent fxmlMain = FXMLLoader.load(getClass().getResource("/package_View/viewMain.fxml"));
            main = new Scene(fxmlMain);

            Parent fxmlVendedor = FXMLLoader.load(getClass().getResource("/package_View/viewVendedor.fxml"));
            vendedor = new Scene(fxmlVendedor);

            Parent fxmlCliente = FXMLLoader.load(getClass().getResource("/package_View/viewCliente.fxml"));
            Cliente = new Scene(fxmlCliente);

            Parent fxmlFornecedor = FXMLLoader.load(getClass().getResource("/package_View/viewFornecedores.fxml"));
            Fornecedor = new Scene(fxmlFornecedor);

            Parent fxmlCompra = FXMLLoader.load(getClass().getResource("/package_View/viewCompra.fxml"));
            Compra = new Scene(fxmlCompra);

            Parent fxmlProduto = FXMLLoader.load(getClass().getResource("/package_View/viewProduto.fxml"));
            Produto = new Scene(fxmlProduto);

            // Adicionei a tela de relatórios
            Parent fxmlRelatorio = FXMLLoader.load(getClass().getResource("/package_View/viewRelatorio.fxml"));
            Relatorio = new Scene(fxmlRelatorio);
            
            Parent fxmlLogout = FXMLLoader.load(getClass().getResource("/package_View/viewLogin.fxml"));
            login = new Scene(fxmlLogout);
            
            

            primaryStage.setScene(login);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeScreen(String tela) {
        if(tela.equals("login")) {
            stage.setScene(login);
            stage.centerOnScreen();
        } else if (tela.equals("main")) {
            stage.setScene(main);
        } else if (tela.equals("vendedor")) {
            stage.setScene(vendedor);
        } else if (tela.equals("Cliente")) {
            stage.setScene(Cliente);
        } else if (tela.equals("Fornecedor")) {
            stage.setScene(Fornecedor);
        } else if (tela.equals("Compra")) {
            stage.setScene(Compra);
        } else if (tela.equals("Produto")) {
            stage.setScene(Produto);
        } else if (tela.equals("Relatorio")) { 
            stage.setScene(Relatorio);
        }
    }

    public static void telaCadastrarProduto() throws IOException {
        FXMLLoader ProdutoCadastro = new FXMLLoader();
        ProdutoCadastro.setLocation(Main.class.getResource("/package_View/viewCadastrarProduto.fxml"));
        Parent cadastroProd = ProdutoCadastro.load();
        Scene scene2 = new Scene(cadastroProd);

        cadProduto = new Stage();
        cadProduto.setTitle("Cadastro/Edição de Produtos - BLUE PAINT");
        cadProduto.initModality(Modality.WINDOW_MODAL);
        cadProduto.setScene(scene2);
        cadProduto.centerOnScreen();
        cadProduto.showAndWait();
    }

    public static void telaCadastrarFornecedor() throws IOException {
        FXMLLoader FornecedorCadastro = new FXMLLoader();
        FornecedorCadastro.setLocation(Main.class.getResource("/package_View/viewCadastrarFornecedor.fxml"));
        Parent cadastroForn = FornecedorCadastro.load();
        Scene scene2 = new Scene(cadastroForn);

        cadFornecedor = new Stage();
        cadFornecedor.setTitle("Cadastro/Edição de Fornecedores - BLUE PAINT");
        cadFornecedor.initModality(Modality.WINDOW_MODAL);
        cadFornecedor.setScene(scene2);
        cadFornecedor.centerOnScreen();
        cadFornecedor.showAndWait();
    }

    public static void telaCadastrarVendedor() throws IOException {
        FXMLLoader VendedorCadastro = new FXMLLoader();
        VendedorCadastro.setLocation(Main.class.getResource("/package_View/viewCadastrarVendedor.fxml"));
        Parent cadastroVen = VendedorCadastro.load();
        Scene scene2 = new Scene(cadastroVen);

        cadVendedor = new Stage();
        cadVendedor.setTitle("Cadastro/Edição de Vendedor - BLUE PAINT");
        cadVendedor.initModality(Modality.WINDOW_MODAL);
        cadVendedor.setScene(scene2);
        cadVendedor.centerOnScreen();
        cadVendedor.showAndWait();
    }

    public static void telaCadastrarCliente() throws IOException {
        FXMLLoader ClienteCadastro = new FXMLLoader();
        ClienteCadastro.setLocation(Main.class.getResource("/package_View/viewCadastrarCliente.fxml"));
        Parent cadastroClien = ClienteCadastro.load();
        Scene scene2 = new Scene(cadastroClien);

        cadCliente = new Stage();
        cadCliente.setTitle("Cadastro/Edição de Cliente - BLUE PAINT");
        cadCliente.initModality(Modality.WINDOW_MODAL);
        cadCliente.setScene(scene2);
        cadCliente.centerOnScreen();
        cadCliente.showAndWait();
    }
    
    public static void telaCadastrarVenda() throws IOException {
        FXMLLoader CadastrarVenda = new FXMLLoader();
        CadastrarVenda.setLocation(Main.class.getResource("/package_View/viewCadastrarRegistrar.fxml"));
        Parent cdastrarVenda = CadastrarVenda.load();
        Scene scene2 = new Scene(cdastrarVenda);

        cadRegistrar = new Stage();
        cadRegistrar.setTitle("Cadastro/Edição de Venda - BLUE PAINT");
        cadRegistrar.initModality(Modality.WINDOW_MODAL);
        cadRegistrar.setScene(scene2);
        cadRegistrar.centerOnScreen();
        cadRegistrar.showAndWait();
    }
    	
	
	public static void main(String[] args) {
//		ArrayList<Cliente> cliente = new ArrayList<>();
//		Connection con = ConnectionDatabase.getConnection();
//		 ConnectionDatabase.closeConnection(con);
//		 ClienteDAO c = new ClienteDAO();
//		 /*
//		 Cliente cl = new Cliente();
//		 cl.setNome("José Augusto");
//		 cl.setCPF_CNPJ("07464420289");
//		 cl.setDataNasc("2006-05-11");
//		 cl.setDataPrimCom("2006-03-11");
//		 cl.setEmail("joseemail@gmail.com");
//		 cl.setEndereço("São João");
//		 cl.setTelefone("63992790809");
//		 cl.setTipojurd("PF"	);
//		 c.update(cl);
//		 */
//		 cliente = c.read();
//		 /*
//		 Cliente c = new Cliente();
//		 c.setNome("Pedro Aquino");
//		 c.setCPF_CNPJ("07433394467");
//		 c.setDataNasc("2006-04-11");
//		 c.setDataPrimCom("21-03-2024");
//		 c.setEmail("pedroaquino123@gmailcom");
//		 c.setEndereço("Bairro São João");
//		 c.setTipojurd("PF");
//		 c.setTelefone("63992596970");
//		 
//		 ClienteDAO cl = new ClienteDAO();
//		 cl.create(c);
//		 */
//		 
//		ClienteDAO clt = new ClienteDAO();
//		cliente = clt.read();
//		for (int i = 0; i < cliente.size(); i++) {
//			Cliente clnt = cliente.get(i);
//			System.out.println();
//			System.out.print(clnt.getId_cliente()+"| ");
//			System.out.print(clnt.getNome()+"| ");
//			System.out.print(clnt.getCPF_CNPJ()+"| ");
//			System.out.print(clnt.getEmail()+"| ");
//			System.out.print(clnt.getTelefone()+"| ");
//			System.out.print(clnt.getDataNasc()+"| ");
//			System.out.print(clnt.getDataPrimCom()+"| ");
//			System.out.print(clnt.getEndereço()+"| ");
//			System.out.print(clnt.getTipojurd()+"| ");
//		}
//		
//
//		ArrayList<Produto> produto = new ArrayList<>();
//		Connection conn = ConnectionDatabase.getConnection();
//		 ConnectionDatabase.closeConnection(con);
//		 
//		 ProdutoDAO produtoDAO = new ProdutoDAO();
//
//	        // Criar um novo produto 
//	        /*
//	        Produto novoProduto = new Produto();
//	        novoProduto.setNome("Produto Exemplo");
//	        novoProduto.setCodigo("P001");
//	        novoProduto.setEstoque("100");
//	        novoProduto.setPreco_un("29.99");
//	        novoProduto.setTipo_un("Unidade");
//	        novoProduto.setData_fab("2024-01-01");
//	        novoProduto.setData_val("2025-01-01");
//	        produtoDAO.create(novoProduto);
//	        System.out.println("Produto criado:");
//	        */
//		 
//		 
//		 ProdutoDAO cc = new ProdutoDAO();
//		 produto = cc.read();
//
//		 for( int i = 0; i < produto.size(); i++) {
//		    Produto clnnt = produto.get(i);
//			System.out.println();
//			System.out.print(clnnt.getId_produto()+"| ");
//			System.out.print(clnnt.getNome()+"| ");
//			System.out.print(clnnt.getCodigo()+"| ");
//			System.out.print(clnnt.getEstoque()+"| ");
//			System.out.print(clnnt.getPreco_un()+"| ");
//			System.out.print(clnnt.getTipo_un()+"| ");
//			System.out.print(clnnt.getData_fab()+"| ");
//			System.out.print(clnnt.getData_val()+"| ");
//		 }
//		 
//			ArrayList<Vendedor> vendedor = new ArrayList<>();
//			Connection ven = ConnectionDatabase.getConnection();
//			 ConnectionDatabase.closeConnection(con);
//			 
//			 VendedorDAO vendedorDAO = new VendedorDAO();
//			 VendedorDAO vv = new VendedorDAO();
//			 vendedor = vv.read();
//			 
//			  // Operações com Vendedor
//		        VendedorDAO vendedorDAO1 = new VendedorDAO();
//
//		        // Criar um novo vendedor
//		        /*
//		        Vendedor novoVendedor = new Vendedor();
//		        novoVendedor.setId_Vendedor("V002");
//		        novoVendedor.setNome("Maria Oliveira");
//		        novoVendedor.setCPF("98765432100");
//		        novoVendedor.setEmail("maria.oliveira@example.com");
//		        novoVendedor.setTelefone("0987654321");
//		        novoVendedor.setDataNasc("1990-03-15");
//		        novoVendedor.setDataCont("2024-02-01");
//		        novoVendedor.setTotal_Vend("200");
//		        novoVendedor.setEndereço("Avenida Brasil");
//		        vendedorDAO.create(novoVendedor);
//		        System.out.println("Vendedor criado:");
//		        */
//
//		        // Atualizar um vendedor existente
//		        /*
//		        Vendedor vendedorAtualizado = new Vendedor();
//		        vendedorAtualizado.setId_Vendedor("V001");
//		        vendedorAtualizado.setNome("Ana Silva Atualizada");
//		        vendedorAtualizado.setCPF("12345678901");
//		        vendedorAtualizado.setEmail("ana.silva.novo@example.com");
//		        vendedorAtualizado.setTelefone("1234567890");
//		        vendedorAtualizado.setDataNasc("1980-02-20");
//		        vendedorAtualizado.setDataCont("2024-01-01");
//		        vendedorAtualizado.setTotal_Vend("175");
//		        vendedorAtualizado.setEndereço("Rua das Flores Atualizada");
//		        vendedorDAO.update(vendedorAtualizado);
//		        System.out.println("Vendedor atualizado:");
//		        */
//
//		        // Excluir um vendedor
//		        /*
//		        vendedorDAO.delete("V001");
//		        System.out.println("Vendedor excluído:");
//		        */
//			 
//			 for(int i = 0; i < vendedor.size(); i++){
//				 Vendedor vlnt = vendedor.get(i);
//				 
//				 System.out.println();
//				 
//	 
//				System.out.print(vlnt.getNome()+"| ");
//					System.out.print(vlnt.getEmail()+"| ");
//					System.out.print(vlnt.getTelefone()+"| ");
//					System.out.print(vlnt.getDataNasc()+"| ");
//					System.out.print(vlnt.getDataCont()+"| ");
//					System.out.print(vlnt.getTotal_Vend()+"| ");
//					System.out.print(vlnt.getEndereço()+"| ");
//					System.out.print(vlnt.getCPF()+"| ");
//			 }
//
//		      // Operações com Compra
//		        ArrayList<Compra> compras = new ArrayList<>();
//		        Connection con1 = ConnectionDatabase.getConnection();
//		        ConnectionDatabase.closeConnection(con1);
//
//		        CompraDAO compraDAO = new CompraDAO();
//		        compras = compraDAO.read();
//		        
//		        // Criar uma nova compra
//		        /*
//		        Compra novaCompra = new Compra();
//		        novaCompra.setIdCliente("C001");
//		        novaCompra.setIdVendedor("V001");
//		        novaCompra.setIdProduto("P001");
//		        novaCompra.setQuantidade("10");
//		        novaCompra.setPreço_Total("299.90");
//		        compraDAO.create(novaCompra);
//		        System.out.println("Compra criada com sucesso!");
//		        */
//
//		        // Atualizar uma compra existente
//		        /*
//		        Compra compraAtualizada = new Compra();
//		        compraAtualizada.setIdCliente("C001");
//		        compraAtualizada.setIdVendedor("V001");
//		        compraAtualizada.setIdProduto("P001");
//		        compraAtualizada.setQuantidade("15"); // Atualiza a quantidade
//		        compraAtualizada.setPreço_Total("449.85"); // Atualiza o preço total
//		        compraDAO.update(compraAtualizada);
//		        System.out.println("Compra atualizada com sucesso!");
//		        */
//
//		        // Deletar uma compra
//		        /*
//		        String idCompraParaDeletar = "C001-V001-P001";
//		        compraDAO.delete(idCompraParaDeletar);
//		        System.out.println("Compra deletada com sucesso!");
//		        */
//
//		        // Ler todas as compras e imprimir
//		        compras = compraDAO.read();
//
//		        for (int i = 0; i < compras.size(); i++) {
//		            Compra comp = compras.get(i);
//		            System.out.println();
//		            System.out.print(comp.getIdCompra() + "| ");
//		            System.out.print(comp.getIdCliente() + "| ");
//		            System.out.print(comp.getIdVendedor() + "| ");
//		            System.out.print(comp.getIdProduto() + "| ");
//		            System.out.print(comp.getQuantidade() + "| ");
//		            System.out.print(comp.getPreço_Total() + "| ");
//		        }
//					
//		        ArrayList<Fornecedor> fornecedor = new ArrayList<>();
//		        Connection fon = ConnectionDatabase.getConnection();
//		        ConnectionDatabase.closeConnection(fon);
//		        
//		        FornecedorDAO fornecedorDAO = new FornecedorDAO();
//		        fornecedor = fornecedorDAO.read();
//		        
//		        for (int i = 0; i < fornecedor.size(); i++) {
//		            Fornecedor fon1 = fornecedor.get(i);
//		            System.out.println();
//		            System.out.print(fon1.getIdFornecedor() + "| ");
//		            System.out.print(fon1.getNome() + "| ");
//		            System.out.print(fon1.getCNPJ() + "| ");
//		            System.out.print(fon1.getTelefone() + "| ");
//		            System.out.print(fon1.getEndereço() + "| ");
//		        }	
	
		launch(args);
	}
	
}
