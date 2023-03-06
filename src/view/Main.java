package view;
import controller.RedesController;
import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {		
		int opc = 0;
		
		 while (opc != 9){
	            opc= Integer.parseInt(JOptionPane.showInputDialog(" 1 - Configuração IP "
	                    + "\n 2 - Ping do sistema \n 9 - Fim"));
	            switch (opc){
	                case 1:
	                	RedesController redes = new RedesController();
	                    redes.ip() ;
	                    break;
	                case 2:
	                	RedesController rede = new RedesController();
	                    rede.ping();
	                    
	                   ;
	                    break;
	                case 9:
	                     JOptionPane.showMessageDialog(null,"Fim do programa");
	                     System.exit(0);
	                     break;
	                default: JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
	            }
	        }
		
		

	}

}
